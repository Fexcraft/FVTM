package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.item.UniInventory;
import net.fexcraft.mod.uni.item.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleFuelCon extends ContainerInterface {

	protected VehicleInstance vehicle;
	protected long date;

	public VehicleFuelCon(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		vehicle = ((Passenger)player.entity).getFvtmWorld().getVehicle(pos.x);
		inventory = UniInventory.create(1).stacksize(1).drop(true);
	}

	@Override
	public Object get(String key, Object... objs){
		if(key.equals("vehicle")) return vehicle;
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(!client) return;
		if(com.getString("cargo").equals("update_fuel_tank")){
			vehicle.data.getAttribute("fuel_stored").set(com.getInteger("state"));
			if(com.has("stack")){
				inventory.set(0, UniStack.createStack(com.getCompound("stack")));
			}
		}
		if(com.getString("cargo").equals("update_fuel_data")){
			vehicle.data.getAttribute("fuel_primary").set(com.getString("primary"));
			vehicle.data.getAttribute("fuel_secondary").set(com.getString("secondary"));
			vehicle.data.getAttribute("fuel_quality").set(com.getFloat("quality"));
		}
	}

	protected boolean isFuelItem(){
		return inventory.get(0).getItem().direct() instanceof Fuel.FuelItem;
	}

	protected Fuel.FuelItem getFuelItem(){
		return inventory.get(0).getItem().local();
	}

	@Override
	public void update(Object lc){
		if(inventory.empty(0)) return;
		if(date + 50 > Time.getDate()) return;
		date = Time.getDate();
		boolean changes = false;
		StackWrapper stack = inventory.get(0);
		if(isFuelItem()){
			Fuel.FuelItem item = getFuelItem();
			boolean pass = false;
			Fuel fuel = item.getStoredFuelType(stack);
			if(fuel != null){
				for(String str : vehicle.data.getFuelGroup()){
					if(fuel.primary.equals(str)){
						pass = true;
						break;
					}
				}
			}
			if(!pass) return;
			int stored = item.getStoredFuelAmount(stack);
			if(stored > 0){
				boolean considerempty = vehicle.data.getAttribute("fuel_stored").asInteger() <= 1000;
				int in = vehicle.data.getAttribute("fuel_stored").asInteger();
				int cantake = vehicle.data.getAttribute("fuel_capacity").asInteger() - in;
				if(cantake < stored) stored = cantake;
				if(stored > 100) stored = 100;
				if(stored > 0){
					item.extractFuel(stack, stored);
					vehicle.data.getAttribute("fuel_stored").increase(stored);
					changes = true;
					//
					boolean morechanges = false;
					if(vehicle.data.getAttribute("fuel_primary").asString().length() == 0){
						vehicle.data.getAttribute("fuel_primary").set(fuel.getPrimaryGroup());
						morechanges = true;
					}
					Attribute<?> seco = vehicle.data.getAttribute("fuel_secondary");
					Attribute<?> qual = vehicle.data.getAttribute("fuel_quality");
					if(!seco.asString().equals(fuel.secondary)){
						seco.set(considerempty ? fuel.secondary : "mixed");
						morechanges = true;
					}
					float oldqual = qual.asFloat();
					int stor = vehicle.data.getAttribute("fuel_stored").asInteger();
					if(!considerempty){
						if(fuel.quality != oldqual){
							float per0 = in / stor, per1 = stored / stor;
							qual.set(per0 * oldqual + per1 * fuel.quality);
							//TODO control this
						}
						if(!morechanges) morechanges = qual.asFloat() != oldqual;
					}
					else{
						qual.set(fuel.quality);
						morechanges = true;
					}
					if(morechanges){
						TagCW com = TagCW.create();
						com.set("cargo", "update_fuel_data");
						com.set("primary", vehicle.data.getAttribute("fuel_primary").asString());
						com.set("secondary", seco.asString());
						com.set("quality", qual.asFloat());
						SEND_TO_CLIENT.accept(com, player);
					}
				}
			}
		}
		if(!player.entity.isOnClient() && changes){
			TagCW com = TagCW.create();
			com.set("cargo", "update_fuel_tank");
			com.set("state", vehicle.data.getAttributeInteger("fuel_stored", 0));
			TagCW is = TagCW.create();
			stack.save(is);
			com.set("stack", is);
			SEND_TO_CLIENT.accept(com, player);
		}
	}

}
