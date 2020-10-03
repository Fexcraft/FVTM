package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.function.PartSlotsFunction;
import net.fexcraft.mod.fvtm.util.function.WheelPositionsFunction;
import net.minecraft.command.ICommandSender;

public class DefaultPartInstallHandler extends PartInstallationHandler {
	
	public static final DefaultPartInstallHandler INSTANCE = new DefaultPartInstallHandler();
	public static final String[] wildcards = { "*", "any", "all" };

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat.startsWith("s:") ? cat.split(":")[2] : cat)){
			Print.chatnn(sender, "There is already another part with that category installed.");
			return false;
		}
		DPIHData idata = part.getType().getInstallationHandlerData();
		if(!part.getType().getCategories().contains(cat) && (idata != null && !idata.custom_cat && !idata.onslot)){
			Print.chatnn(sender, "Part does not allow installing into this category.");
			return false;
		}
		if(!compatible(idata, data.getType().getRegistryName().toString())){
			Print.chatnn(sender, "Part incompatible with this vehicle.");
			return false;
		}
		if(containsIncompatible(idata, data)){
			Print.chatnn(sender, "Vehicle contains parts incompatible with this part.");
			return false;
		}
		if(!containsRequired(idata, data)){
			Print.chatnn(sender, "Vehicle does not contain all required parts.");
			return false;
		}
		if(idata != null && idata.sp_req && !idata.onslot && !data.getRotationPoints().containsKey(idata.swivel_point)){
			Print.chatnn(sender, "Vehicle does not contain a required swivel/rotation point. Missing: " + idata.swivel_point);
			return false;
		}
		Print.chatnn(sender, "Installation check passed."); return true;
	}

	private boolean compatible(DPIHData idata, String string){
		if(idata == null || idata.allowsAny()) return true;
		return idata.compatible.containsKey(string);
	}
	
	private boolean containsIncompatible(DPIHData idata, VehicleData data){
		if(idata == null || !idata.incompatible.containsKey(data.getType().getRegistryName().toString())) return false;
		ArrayList<String> list = idata.incompatible.get(data.getType().getRegistryName().toString());
		for(String str : list) if(data.getParts().containsKey(str)) return true;
		return false;
	}
	
	private boolean containsRequired(DPIHData idata, VehicleData data){
		if(idata == null || !idata.required.containsKey(data.getType().getRegistryName().toString())) return true;
		ArrayList<String> list = idata.required.get(data.getType().getRegistryName().toString());
		for(String str : list) if(!data.getParts().containsKey(str)) return false;
		return true;
	}

	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat.startsWith("s:") ? cat.split(":")[2] : cat, part);
		DPIHData idata = part.getType().getInstallationHandlerData();
		setPosAndSwivelPoint(idata == null ? null : idata.compatible, cat, part, data);
		/*data.getAttributes().values().forEach(attr ->{
			attr.getModifiers().forEach(mod -> {
				Print.debug(mod.id(), mod.origin(), mod.target());
			});
		});*/
		Print.chatnn(sender, "Part installed into selected category."); return true;
	}

	public static void setPosAndSwivelPoint(TreeMap<String, Pos> compatible, String cat, PartData part, VehicleData data){
		String vehid = data.getType().getRegistryName().toString();
		Pos result = Pos.NULL;
		if(cat.startsWith("s:")){
			String[] split = cat.split(":");
			PartData mount = data.getPart(split[1]);
			result = mount.getInstalledPos();
			result = result.add(mount.getFunction(PartSlotsFunction.class, "fvtm:part_slots").getSlotPositions().get(Integer.parseInt(split[3])));
			if(mount.getSwivelPointInstalledOn() != null && !mount.getSwivelPointInstalledOn().equals("vehicle")){
				part.setInstalledOnSwivelPoint(mount.getSwivelPointInstalledOn());
			}
		}
		if(compatible != null && !compatible.isEmpty()){
			if(compatible.containsKey(vehid)){
				result = result.add(compatible.get(vehid));
			}
			for(String str : wildcards){
				if(compatible.containsKey(str)){
					result = result.add(compatible.get(str));
					break;
				}
			}
		}
		part.setInstalledPos(result);
		if(!cat.startsWith("s:") && part.getType().getInstallationHandlerData() instanceof DPIHData){
			String point = ((DPIHData)part.getType().getInstallationHandlerData()).swivel_point;
			if(point != null && !point.equals("vehicle") && data.getRotationPoints().containsKey(point)){
				part.setInstalledOnSwivelPoint(point);
			}
		}
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		DPIHData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			Print.chatnn(sender, "Part is marked as non removable."); return false;
		}
		//Function Check
		if(!checkWheelSlotsInUse(sender, part, from)) return false;
		Print.chatnn(sender, "Deinstallation check passed."); return true;
	}
	
	public static boolean checkWheelSlotsInUse(@Nullable ICommandSender sender, PartData part, VehicleData from){
		if(part.hasFunction("fvtm:wheel_positions")){
			WheelPositionsFunction func = part.getFunction("fvtm:wheel_positions");
			for(String key : from.getParts().keySet()){
				if(func.getPositions().containsKey(key)){
					Print.chatnn(sender, "Please remove all linked wheels first."); return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean processUninstall(ICommandSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(Pos.NULL);
		data.getParts().remove(cat);
		Print.chatnn(sender, "Part uninstalled and position reset."); return true;
	}
	
	/** Default Part Install Handler Data */
	public static class DPIHData {
		
		public TreeMap<String, Pos> compatible = new TreeMap<String, Pos>();
		public TreeMap<String, ArrayList<String>> incompatible = new TreeMap<>();
		public TreeMap<String, ArrayList<String>> required = new TreeMap<>();
		public boolean removable = true, custom_cat, sp_req = false, onslot, hotswap;
		public String swivel_point = "vehicle";
		
		public DPIHData(JsonObject obj){
			if(obj == null) return;
			removable = JsonUtil.getIfExists(obj, "Removable", true);
			custom_cat = JsonUtil.getIfExists(obj, "CustomCategory", false);
			swivel_point = JsonUtil.getIfExists(obj, "SwivelPoint", "vehicle");
			sp_req = JsonUtil.getIfExists(obj, "SwivelPointRequired", false);
			if(obj.has("Compatible")){
				obj.get("Compatible").getAsJsonArray().forEach(elm -> {
					if(elm.isJsonObject()){
						JsonObject jsn = elm.getAsJsonObject();
						this.compatible.put(jsn.get("vehicle").getAsString(), Pos.fromJson(jsn, false));
					}
					else if(elm.isJsonArray()){
						JsonArray array = elm.getAsJsonArray();
						this.compatible.put(array.get(3).getAsString(), Pos.fromJson(array, true));
					}
					else{
						this.compatible.put(elm.getAsString(), Pos.NULL);
					}
				});
			}
			if(obj.has("Incompatible")){
				if(obj.get("Incompatible").isJsonArray()){
					obj.get("Incompatible").getAsJsonArray().forEach(elm -> {
						JsonObject jsn = elm.getAsJsonObject();
						ArrayList<String> parts = JsonUtil.jsonArrayToStringArray(jsn.get("parts").getAsJsonArray());
						this.incompatible.put(jsn.get("vehicle").getAsString(), parts);
					});
				}
				else{
					obj.get("Incompatible").getAsJsonObject().entrySet().forEach(entry -> {
						ArrayList<String> parts = null;
						if(entry.getValue().isJsonArray()){
							parts = JsonUtil.jsonArrayToStringArray(entry.getValue().getAsJsonArray());
						}
						else{
							parts = (ArrayList<String>)Collections.singletonList(entry.getValue().getAsString());
						}
						this.incompatible.put(entry.getKey(), parts);
					});
				}
			}
			if(obj.has("Required")){
				if(obj.get("Required").isJsonArray()){
					obj.get("Required").getAsJsonArray().forEach(elm -> {
						JsonObject jsn = elm.getAsJsonObject();
						ArrayList<String> parts = JsonUtil.jsonArrayToStringArray(jsn.get("parts").getAsJsonArray());
						this.required.put(jsn.get("vehicle").getAsString(), parts);
					});
				}
				else{
					obj.get("Required").getAsJsonObject().entrySet().forEach(entry -> {
						ArrayList<String> parts = null;
						if(entry.getValue().isJsonArray()){
							parts = JsonUtil.jsonArrayToStringArray(entry.getValue().getAsJsonArray());
						}
						else{
							parts = (ArrayList<String>)Collections.singletonList(entry.getValue().getAsString());
						}
						this.required.put(entry.getKey(), parts);
					});
				}
			}
			onslot = JsonUtil.getIfExists(obj, "SlotBased", false);
			hotswap = JsonUtil.getIfExists(obj, "HotSwap", false);
		}

		public boolean allowsAny(){
			if(compatible.isEmpty()) return true;
			for(String str : wildcards){
				if(compatible.containsKey(str)) return true;
			}
			return false;
		}
		
	}

	@Override
	public boolean allowsCustomCategory(PartData part){
		DPIHData idata = part.getType().getInstallationHandlerData();
		return idata == null ? false : idata.custom_cat;
	}

	@Override
	public String[] getValidCategories(PartData part, VehicleData vehicle){
		DPIHData idata = part.getType().getInstallationHandlerData();
		if(idata != null && idata.onslot){
			ArrayList<String> found = new ArrayList<>();
			for(Entry<String, PartData> data : vehicle.getParts().entrySet()){
				if(!data.getValue().hasFunction("fvtm:part_slots")) continue;
				PartSlotsFunction func = data.getValue().getFunction("fvtm:part_slots");
				int funds = 0;
				for(int i = 0; i < func.getSlotTypes().size(); i++){
					String type = func.getSlotTypes().get(i);
					for(String str : part.getType().getCategories()){
						if(str.equals(type)){
							found.add(data.getKey() + ":" + func.getSlotCategories().get(i) + ":" + funds++);
						}
					}
				}
			}
			String[] arr = new String[found.size()];
			for(int i = 0; i < arr.length; i++){
				arr[i] = "s:" + found.get(i);
			}
			return arr;
		}
		return part.getType().getCategories().toArray(new String[0]);
	}

}
