package net.fexcraft.mod.fvtm.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import net.fexcraft.mod.addons.gep.attributes.ConnectorAttribute;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute;
import net.fexcraft.mod.addons.gep.attributes.FMSeatAttribute;
import net.fexcraft.mod.addons.gep.attributes.FuelTankExtensionAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.mod.addons.gep.attributes.FuelTankExtensionAttribute.FuelTankExtensionAttributeData;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.api.compatibility.FMSeat;
import net.fexcraft.mod.fvtm.impl.root.GenericColorable;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class GenericVehicleData extends GenericColorable<VehicleData, Vehicle> implements VehicleData {
	
	private int keys, lights;
	//private double tank;
	private TreeMap<String, PartData> parts = new TreeMap<String, PartData>();
	private List<Pos> wheelpos;
	private boolean doors;
	private Map<Class<?>, VehicleScript> scripts = new HashMap<Class<?>, VehicleScript>();
	private ArrayList<FMSeat> seats = new ArrayList<FMSeat>();
	private Pos frontConnector, rearConnector;
	
	public GenericVehicleData(Vehicle veh){
		super(veh);
		//
		this.lights = 0;
	}
	
	@Override
	public Vehicle getVehicle(){
		return root;
	}

	@Override
	public TreeMap<String, PartData> getParts(){
		return parts;
	}

	@Override
	public List<Pos> getWheelPos(){
		return wheelpos == null ? root.getDefaultWheelPos() : wheelpos;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
		tagcompound.setString(VehicleItem.NBTKEY, root.getRegistryName().toString());
		NBTTagCompound compound = new NBTTagCompound();
		super.writeToNBT(compound);
		//
		compound.setInteger("LightsState", lights);
		//compound.setDouble("FuelTank", tank);
		if(parts.size() > 0){
			NBTTagList list = new NBTTagList();
			parts.forEach((key, partdata) -> {
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString("UsedAs", key);
				list.appendTag(partdata.writeToNBT(nbt));
			});
			compound.setTag("Parts", list);
		}
		if(wheelpos != null){
			NBTTagList wlist = new NBTTagList();
			for(int i = 0; i < wheelpos.size(); i++){
				wlist.appendTag(wheelpos.get(i).toNBT("W" + i, compound));
			}
			compound.setTag("WheelPos", wlist);
		}
		compound.setBoolean("DoorsOpen", doors);
		compound.setInteger("SpawnedKeys", keys);
		//
		scripts.forEach((clazz, script) -> {
			script.writeToNBT(compound);
		});
		//
		tagcompound.setTag(FVTM.MODID + "_vehicle", compound);
		return tagcompound;
	}

	@Override
	public VehicleData readFromNBT(NBTTagCompound compound){
		compound = compound.hasKey(FVTM.MODID + "_landvehicle") ? compound.getCompoundTag(FVTM.MODID + "_landvehicle") : compound.getCompoundTag(FVTM.MODID + "_vehicle");
		super.readFromNBT(compound);
		//
		lights = compound.getInteger("LightsState");
		//this.tank = compound.getDouble("FuelTank");
		if(compound.hasKey("Parts")){
			NBTTagList list = (NBTTagList)compound.getTag("Parts");
			for(NBTBase base : list){
				NBTTagCompound nbt = (NBTTagCompound)base;
				PartData data = Resources.getPartData(nbt);
				if(data != null){
					this.parts.put(nbt.getString("UsedAs"), data);
				}
				//Print.debug("PART: " + (data == null ? "[NULL] " : "" ) + nbt.toString());
			}
			this.updatePartDependantData();
		}
		else{
			root.getPreinstalledParts().forEach((key, rs) -> {
				PartData data = Resources.getPartData((ResourceLocation)rs);
				if(data != null){
					this.parts.put(key, data);
				}
			});
			this.updatePartDependantData();
		}
		if(compound.hasKey("WheelPos")){
			NBTTagList list = (NBTTagList)compound.getTag("WheelPos");
			this.wheelpos = new ArrayList<Pos>();
			for(int i = 0; i < list.tagCount(); i++){
				if(this.wheelpos.size() < 4){
					this.wheelpos.add(Pos.fromNBT("W" + i, list.getCompoundTagAt(i)));
				}
			}
		}
		this.doors = compound.getBoolean("DoorsOpen");
		this.keys = compound.getInteger("SpawnedKeys");
		//
		this.scripts.clear();
		NBTTagCompound[] nbt = new NBTTagCompound[]{compound};
		parts.forEach((key, data) ->{
			data.getPart().getScripts().forEach((clazz) -> {
				try{
					/*boolean duplicate = false;
					for(Class<?> script : scripts.keySet()){
						if(script.equals(clazz)){ duplicate = true; break; }
					}
					if(!duplicate){*/
						VehicleScript script = clazz.newInstance();
						this.scripts.put(clazz, script.readFromNBT(nbt[0]));
					/*}*/
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		});
		//
		return this;
	}

	@Override
	public boolean readyToSpawn(){
		boolean result = true;
		for(String rs : root.getRequiredParts()){
			if(!this.parts.containsKey(rs)){
				result = false;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean doorsOpen(){
		return doors;
	}

	@Override
	public void installPart(String as, PartData data){
		this.parts.put(as, data);
		this.updatePartDependantData();
	}

	@Override
	public void toggleDoors(Boolean doors){
		this.doors = doors == null ? !this.doors : doors;
	}

	@Override
	public PartData getPart(String string){
		return parts.get(string);
	}

	@Override
	public Collection<VehicleScript> getScripts(){
		return scripts.values();
	}

	@Override
	public int getSpawnedKeysAmount(){
		return keys;
	}

	@Override
	public void setSpawnedKeysAmount(Integer i){
		keys = i == null ? (keys + 1) : (keys + i);
	}

	@Override
	public List<FMSeat> getSeats(){
		return seats;
	}

	private void updatePartDependantData(){
		seats.clear();
		parts.forEach((key, partdata) -> {
			if(partdata.getPart().getAttribute(FMSeatAttribute.class) != null){
				seats.addAll(partdata.getPart().getAttribute(FMSeatAttribute.class).getSeats());
			}
		});
		FMSeat seat = null;
		for(int i = 0; i < seats.size(); i++){
			if(seats.get(i).isDriver()){
				seat = seats.remove(i);
			}
		}
		if(seat != null){
			seats.add(0, seat);
		}
		//
		parts.forEach((key, partdata) -> {
			if(partdata.getPart().getAttribute(ConnectorAttribute.class) != null){
				if(partdata.getPart().getAttribute(ConnectorAttribute.class).hasFrontConnector(this.getVehicle().getRegistryName())){
					this.frontConnector = partdata.getPart().getAttribute(ConnectorAttribute.class).getFrontConnector(this.getVehicle().getRegistryName());
				}
				if(partdata.getPart().getAttribute(ConnectorAttribute.class).hasRearConnector(this.getVehicle().getRegistryName())){
					this.rearConnector = partdata.getPart().getAttribute(ConnectorAttribute.class).getRearConnector(this.getVehicle().getRegistryName());
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends VehicleScript> T getScript(Class<T> clazz){
		return (T)scripts.get(clazz);
	}

	@Override
	public int getFuelTankSize(){
		int[] i = new int[]{0};
		parts.forEach((key, partdata) -> {
			if(partdata.getPart().getAttribute(FuelTankExtensionAttribute.class) != null){
				FuelTankExtensionAttribute ext = partdata.getPart().getAttribute(FuelTankExtensionAttribute.class);
				i[0] += ext.getFuelTankSize();
			}
		});
		return i[0];
	}

	@Override
	public double getFuelTankContent(){
		double[] d = new double[]{0};
		parts.forEach((key, partdata) -> {
			if(partdata.getAttributeData(FuelTankExtensionAttributeData.class) != null){
				d[0] += partdata.getAttributeData(FuelTankExtensionAttributeData.class).getContent();
			}
		});
		return d[0];
	}

	@Override
	public boolean consumeFuel(double d){
		double f = d;
		for(PartData data : parts.values()){
			if(data.getAttributeData(FuelTankExtensionAttributeData.class) != null){
				FuelTankExtensionAttributeData tank = data.getAttributeData(FuelTankExtensionAttributeData.class);
				f = tank.consume(d, data.getPart().getAttribute(FuelTankExtensionAttribute.class).getFuelTankSize());
				if(f == 0){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int getMaxInventorySize(){
		int[] i = new int[]{0};
		this.getInventoryContainers().forEach((data) -> {
			i[0] += data.getPart().getAttribute(InventoryAttribute.class).getSize();
		});
		return i[0];
	}

	@Override
	public NonNullList<ItemStack> getAllInventoryContents(){
		NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(this.getMaxInventorySize(), ItemStack.EMPTY);
		this.getInventoryContainers().forEach((data) -> {
			stacks.addAll(data.getAttributeData(InventoryAttribute.InventoryAttributeData.class).getInventory());
		});
		return stacks;
	}

	@Override
	public List<PartData> getInventoryContainers(){
		return parts.values().stream().filter(pre -> pre.getPart().getAttribute(InventoryAttribute.class) != null).collect(Collectors.toList());
	}

	@Override
	public List<PartData> getContainerHolders(){
		return parts.values().stream().filter(pre -> pre.getPart().getAttribute(ContainerAttribute.class) != null).collect(Collectors.toList());
	}
	
	@Override
	public String toString(){
		return this.writeToNBT(new NBTTagCompound()).toString();
	}

	@Override
	public Pos getFrontConnector(){
		return frontConnector;
	}

	@Override
	public Pos getRearConnector(){
		return rearConnector;
	}

	@Override
	public int getLightsState(){
		return lights;
	}

	@Override
	public void setLightsState(int i){
		lights = i;
	}
	
}