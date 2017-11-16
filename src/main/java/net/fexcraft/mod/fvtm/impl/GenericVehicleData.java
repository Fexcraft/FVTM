package net.fexcraft.mod.fvtm.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.fexcraft.mod.addons.gep.attributes.ConnectorAttribute;
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
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class GenericVehicleData implements VehicleData {
	
	private Vehicle vehicle;
	private int sel, keys;
	//private double tank;
	private String url, lockcode;
	private ResourceLocation custom;
	private TreeMap<String, PartData> parts = new TreeMap<String, PartData>();
	private List<Pos> wheelpos;
	private RGB primary, secondary;
	private boolean doors, isexternal, locked, remote;
	private Map<Class<?>, VehicleScript> scripts = new HashMap<Class<?>, VehicleScript>();
	private ArrayList<FMSeat> seats = new ArrayList<FMSeat>();
	private Pos frontConnector, rearConnector;
	
	public GenericVehicleData(Vehicle veh){
		this.vehicle = veh;
	}
	
	@Override
	public Vehicle getVehicle(){
		return this.vehicle;
	}

	@Override
	public TreeMap<String, PartData> getParts(){
		return parts;
	}

	@Override
	public List<Pos> getWheelPos(){
		return wheelpos == null ? vehicle.getDefaultWheelPos() : wheelpos;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
		tagcompound.setString(VehicleItem.NBTKEY, vehicle.getRegistryName().toString());
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("SelectedTexture", sel);
		compound.setString("CustomTexture", isexternal ? url == null ? "" : url : custom == null ? "minecraft:stone" : custom.toString());
		compound.setBoolean("IsTextureExternal", isexternal);
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
		if(this.primary != null){
			compound.setFloat("PrimaryRed", this.primary.red);
			compound.setFloat("PrimaryGreen", this.primary.green);
			compound.setFloat("PrimaryBlue", this.primary.blue);
		}
		if(this.secondary != null){
			compound.setFloat("SecondaryRed", this.secondary.red);
			compound.setFloat("SecondaryGreen", this.secondary.green);
			compound.setFloat("SecondaryBlue", this.secondary.blue);
		}
		compound.setBoolean("DoorsOpen", doors);
		//FM
		compound.setBoolean("Locked", locked);
		compound.setString("LockCode", lockcode == null ? KeyItem.getNewKeyCode() : lockcode);
		compound.setInteger("SpawnedKeys", keys);
		//
		scripts.forEach((clazz, script) -> {
			script.writeToNBT(compound);
		});
		//
		tagcompound.setTag(FVTM.MODID + "_landvehicle", compound);
		return tagcompound;
	}

	@Override
	public VehicleData readFromNBT(NBTTagCompound compound, boolean isRemote){
		this.remote = isRemote();
		compound = compound.getCompoundTag(FVTM.MODID + "_landvehicle");
		this.sel = compound.getInteger("SelectedTexture");
		isexternal = compound.getBoolean("IsTextureExternal");
		url = isexternal ? compound.getString("CustomTexture") : null;
		custom = isexternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
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
			vehicle.getPreinstalledParts().forEach((key, rs) -> {
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
		this.primary = compound.hasKey("PrimaryRed") ? new RGB(compound.getByte("PrimaryRed"), compound.getByte("PrimaryGreen"), compound.getByte("PrimaryBlue")) : new RGB(vehicle.getDefPrimaryColor());
		this.secondary = compound.hasKey("SecondaryRed") ? new RGB(compound.getByte("SecondaryRed"), compound.getByte("SecondaryGreen"), compound.getByte("SecondaryBlue")) : new RGB(vehicle.getDefSecondaryolor());
		this.doors = compound.getBoolean("DoorsOpen");
		//FM
		this.locked = compound.getBoolean("Locked");
		this.lockcode = compound.hasKey("LockCode") ? compound.getString("LockCode") : KeyItem.getNewKeyCode();
		this.keys = compound.getInteger("SpawnedKeys");
		//
		this.scripts.clear();
		NBTTagCompound[] nbt = new NBTTagCompound[]{compound};
		parts.forEach((key, data) ->{
			data.getPart().getScripts().forEach((clazz) -> {
				try{
					VehicleScript script = clazz.newInstance();
					if(script.isOn(Static.side(remote))){
						this.scripts.put(clazz, script.readFromNBT(nbt[0], remote));
					}
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
	public RGB getPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getSecondaryColor(){
		return secondary;
	}

	@Override
	public boolean readyToSpawn(){
		boolean result = true;
		for(String rs : vehicle.getRequiredParts()){
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
	public int getSelectedTexture(){
		return sel;
	}

	@Override
	public void setSelectedTexture(int i){
		this.sel = i;
	}

	@Override
	public ResourceLocation getCustomTexture(){
		return isexternal ? ExternalTextureHelper.get(url) : custom;
	}

	@Override
	public void setCustomTexture(String string, boolean external){
		url = external ? string : null;
		custom = external ? null : new ResourceLocation(string);
		isexternal = external;
	}

	@Override
	public boolean isTextureExternal(){
		return this.isexternal;
	}

	@Override
	public ResourceLocation getTexture(){
		return sel >= 0 ? vehicle.getTextures().get(sel) : this.getCustomTexture();
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
	public boolean isLocked(){
		return locked;
	}

	@Override
	public boolean setLocked(Boolean lock){
		return lock == null ? (locked = !locked) : (locked = lock);
	}

	@Override
	public String getLockCode(){
		return lockcode;
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

	@Override
	public boolean isRemote(){
		return remote;
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
		ArrayList<PartData> map = new ArrayList<PartData>();
		this.parts.forEach((key, data) -> {
			if(data.getPart().getAttribute(InventoryAttribute.class) != null){
				map.add(data);
			}
		});
		return map;
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
	
}