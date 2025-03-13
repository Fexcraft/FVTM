package net.fexcraft.mod.fvtm.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallHandler;
import net.fexcraft.mod.fvtm.data.part.PartSlot;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.part.PartSlotsFunction;
import net.fexcraft.mod.fvtm.function.part.WheelPositionsFunction;
import net.fexcraft.mod.fvtm.util.Rot;
import net.fexcraft.mod.uni.world.MessageSender;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DefaultPartInstallHandler extends PartInstallHandler {

	@Override
	public boolean validInstall(MessageSender sender, PartData part, String cat, VehicleData data, boolean swap){
		String catin = getslotcat(cat);
		if(data.getParts().containsKey(catin) && !swap){
			sender.send("handler.install.fvtm.default.category_occupied");
			return false;
		}
		DPIHData idata = part.getType().getInstallHandlerData();
		if(!compatible(idata, data.getType())){
			sender.send("handler.install.fvtm.default.part_incompatible_vehicle");
			return false;
		}
		if(incompatible(idata, data)){
			sender.send("handler.install.fvtm.default.vehicle_contains_incompatible");
			return false;
		}
		if(!required(idata, data)){
			sender.send("handler.install.fvtm.default.vehicle_missing_required_parts");
			return false;
		}
		if(!swivelpresent(data, cat)){
			sender.send("handler.install.fvtm.default.vehicle_swivelpoint_missing");
		}
		sender.send("handler.install.fvtm.default.check_passed");
		return true;
	}

	private boolean swivelpresent(VehicleData data, String cat){
		String[] slotin = cat.split(":");
		PartSlots slots = data.getPartSlotsProvider(slotin[0]);
		return data.getRotationPoints().containsKey(slots.get(slotin[1]).swivel);
	}

	private String getslotcat(String cat){
		String[] slotin = cat.split(":");
		return slotin[1].contains("*") ? slotin[1].replace("*", slotin[0]) : slotin[1];
	}

	private boolean compatible(DPIHData id, Vehicle veh){
		if(id.compatible.isEmpty() || id.compatible.contains(veh.getIDS())) return true;
		for(String cat : veh.getCategories()) if(id.compatible.contains(cat)) return true;
		return false;
	}
	
	private boolean incompatible(DPIHData idata, VehicleData data){
		if(!idata.incompatible.containsKey(data.getType().getIDS())) return false;
		ArrayList<String> list = idata.incompatible.get(data.getType().getIDS());
		for(String str : list) if(data.getParts().containsKey(str)) return true;
		return false;
	}
	
	private boolean required(DPIHData idata, VehicleData data){
		if(!idata.required.containsKey(data.getType().getIDS())) return true;
		ArrayList<String> list = idata.required.get(data.getType().getIDS());
		for(String str : list) if(!data.getParts().containsKey(str)) return false;
		return true;
	}

	@Override
	public boolean processInstall(MessageSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(getslotcat(cat), part);
		DPIHData idata = part.getType().getInstallHandlerData();
		setPosRotAndSwivelPoint(idata, cat, part, data);
		sender.send("handler.install.fvtm.default.success");
		return true;
	}

	public static void setPosRotAndSwivelPoint(DPIHData idata, String cat, PartData part, VehicleData data){
		String[] slotin = cat.split(":");
		PartSlots slots = data.getPartSlotsProvider(slotin[0]);
		V3D result = slots.get(slotin[1]).pos.copy();
		Rot rosult = slots.get(slotin[1]).rotation;
		if(!slotin[0].equals("vehicle")){
			PartData mount = data.getPart(slotin[0]);
			result = result.add(mount.getInstalledPos());
			if(mount.getSwivelPointInstalledOn() != null && !mount.getSwivelPointInstalledOn().equals(SwivelPoint.DEFAULT)){
				part.setInstalledOnSwivelPoint(mount.getSwivelPointInstalledOn());
			}
			if(slots.copy_rot) rosult = rosult.add(mount.getInstalledRot());
		}
		if(!slots.get(slotin[1]).swivel.equals(SwivelPoint.DEFAULT) && data.getRotationPoints().containsKey(slots.get(slotin[1]).swivel)){
			part.setInstalledOnSwivelPoint(slots.get(slotin[1]).swivel);
		}
		part.setInstalled(slotin[0], result, rosult);
	}

	@Override
	public boolean validUninstall(MessageSender sender, PartData part, String in_cat, VehicleData from, boolean swap){
		DPIHData idata = part.getType().getInstallHandlerData();
		if(!idata.removable && !swap){
			sender.send("handler.deinstall.fvtm.default.part_not_removable");
			return false;
		}
		//Function Check
		if(!checkWheelSlotsInUse(sender, in_cat, part, from)) return false;
		if(!checkPartSlotsInUse(sender, in_cat, part, from)) return false;
		sender.send("handler.deinstall.fvtm.default.check_passed");
		return true;
	}
	
	public static boolean checkWheelSlotsInUse(MessageSender sender, String cat, PartData part, VehicleData from){
		if(part.hasFunction("fvtm:wheel_positions")){
			WheelPositionsFunction func = part.getFunction("fvtm:wheel_positions");
			ArrayList<String> pid = func.getPosIds(cat);
			for(String key : from.getParts().keySet()){
				if(pid.contains(key)){
					sender.send("handler.deinstall.fvtm.default.remove_linked_wheels");
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkPartSlotsInUse(MessageSender sender, String cat, PartData part, VehicleData from){
		if(!part.hasFunction("fvtm:part_slots")) return true;
		PartSlotsFunction func = part.getFunction(PartSlotsFunction.class, "fvtm:part_slots");
		for(Entry<String, PartSlot> slot : func.getPartSlotss().entrySet()){
			if(from.hasPart(slot.getKey()) && from.getPart(slot.getKey()).getSource().equals(cat)){
				sender.send("handler.deinstall.fvtm.default.remove_sub_parts");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean processUninstall(MessageSender sender, PartData part, String cat, VehicleData data){
		part.setInstalled(null, V3D.NULL, Rot.NULL);
		part.setInstalledOnSwivelPoint(null);
		data.getParts().remove(cat);
		sender.send("handler.deinstall.fvtm.default.success");
		return true;
	}
	
	/** Default Part Install Handler Data */
	public static class DPIHData {

		public ArrayList<String> compatible;
		public boolean removable = true;
		public boolean swappable;
		public boolean construct;
		public HashMap<String, ArrayList<String>> incompatible = new LinkedHashMap<>();
		public HashMap<String, ArrayList<String>> required = new LinkedHashMap<>();
		
		public DPIHData(JsonMap map){
			removable = map.getBoolean("Removable", true);
			swappable = map.getBoolean("Swappable", false);
			construct = map.getBoolean("ConstOnly", false);
			compatible = map.has("Compatible") ? map.getArray("Compatible").toStringList() : new ArrayList<>();
			if(map.has("Incompatible")){
				for(Entry<String, JsonValue<?>> entry : map.get("Incompatible").asMap().entries()){
					incompatible.put(entry.getKey(), entry.getValue().asArray().toStringList());
				}
			}
			if(map.has("Required")){
				for(Entry<String, JsonValue<?>> entry : map.get("Required").asMap().entries()){
					required.put(entry.getKey(), entry.getValue().asArray().toStringList());
				}
			}
		}
		
	}

	@Override
	public ArrayList<String> getValidCategories(PartData part, VehicleData vehicle){
		DPIHData idata = part.getType().getInstallHandlerData();
		ArrayList<String> found = new ArrayList<>();
		for(Entry<String, PartSlots> data : vehicle.getPartSlotProviders().entrySet()){
			for(Entry<String, PartSlot> slot : data.getValue().entrySet()){
				String type = slot.getValue().type;
				for(String str : part.getType().getCategories()){
					if(str.equals(type)){
						found.add(data.getKey() + ":" + slot.getKey());
					}
				}
			}
		}
		return found;
	}

	@Override
	public Object parseData(JsonMap map){
		return new DPIHData(map);
	}

}
