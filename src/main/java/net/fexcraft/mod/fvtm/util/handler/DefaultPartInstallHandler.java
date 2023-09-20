package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallHandler;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.WheelPositionsFunction;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.fvtm.util.Rot;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.uni.world.MessageSender;

public class DefaultPartInstallHandler extends PartInstallHandler {

	public static final String[] wildcards = { "*", "any", "all" };

	@Override
	public boolean validInstall(MessageSender sender, PartData part, String cat, VehicleData data){
		String[] split = cat.startsWith(":") ? cat.split(":") : null;
		if(data.getParts().containsKey(split == null ? cat : gscn(split))){
			sender.send("handler.install.fvtm.default.category_occupied");
			return false;
		}
		DPIHData idata = part.getType().getInstallHandlerData();
		if(!part.getType().getCategories().contains(cat) && !idata.custom_cat && !idata.onslot){
			sender.send("handler.install.fvtm.default.part_invalid_category");
			return false;
		}
		if(!compatible(idata, data.getType().getID().colon())){
			sender.send("handler.install.fvtm.default.part_incompatible_vehicle");
			return false;
		}
		if(containsIncompatible(idata, data)){
			sender.send("handler.install.fvtm.default.vehicle_contains_incompatible");
			return false;
		}
		if(!containsRequired(idata, data)){
			sender.send("handler.install.fvtm.default.vehicle_missing_required_parts");
			return false;
		}
		if(idata.sp_req && !idata.onslot && !data.getRotationPoints().containsKey(idata.swivel_point)){
			sender.send("handler.install.fvtm.default.vehicle_missing_required_swivelpoint:" + idata.swivel_point);
			return false;
		}
		sender.send("handler.install.fvtm.default.check_passed"); return true;
	}

	private boolean compatible(DPIHData idata, String string){
		if(idata == null || idata.allowsAny()) return true;
		return idata.compatible.containsKey(string);
	}
	
	private boolean containsIncompatible(DPIHData idata, VehicleData data){
		if(idata == null || !idata.incompatible.containsKey(data.getType().getIDS())) return false;
		ArrayList<String> list = idata.incompatible.get(data.getType().getIDS());
		for(String str : list) if(data.getParts().containsKey(str)) return true;
		return false;
	}
	
	private boolean containsRequired(DPIHData idata, VehicleData data){
		if(idata == null || !idata.required.containsKey(data.getType().getIDS())) return true;
		ArrayList<String> list = idata.required.get(data.getType().getIDS());
		for(String str : list) if(!data.getParts().containsKey(str)) return false;
		return true;
	}

	@Override
	public boolean processInstall(MessageSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat.startsWith("s:") ? gscn(cat.split(":")) : cat, part);
		DPIHData idata = part.getType().getInstallHandlerData();
		setPosAndSwivelPoint(idata, null, cat, part, data);
		/*data.getAttributes().values().forEach(attr ->{
			attr.getModifiers().forEach(mod -> {
				Print.debug(mod.id(), mod.origin(), mod.target());
			});
		});*/
		sender.send("handler.install.fvtm.default.success");
		return true;
	}

	private String gscn(String[] split){
		if(split[2].contains("*")){
			return split[2].replace("*", split[1]);
		}
		return split[2];
	}

	public static void setPosAndSwivelPoint(DPIHData idata, TreeMap<String, V3D> compatible, String cat, PartData part, VehicleData data){
		String vehid = data.getType().getIDS();
		V3D result = new V3D();
		Rot rosult = Rot.NULL;
		if(cat.startsWith("s:")){
			String[] split = cat.split(":");
			int idx = Integer.parseInt(split[3]);
			PartSlots slots = data.getPartSlotsProvider(split[1]);
			rosult = slots.get(idx).rotation;
			if(!split[1].equals(PartSlots.VEHPARTSLOTS)){
				PartData mount = data.getPart(split[1]);
				result = mount.getInstalledPos();
				if(mount.getSwivelPointInstalledOn() != null && !mount.getSwivelPointInstalledOn().equals("vehicle")){
					part.setInstalledOnSwivelPoint(mount.getSwivelPointInstalledOn());
				}
				if(slots.copy_rot) rosult = rosult.add(mount.getInstalledRot());
			}
			result = result.add(new Pos(slots.get(idx).pos).toV3D());
		}
		if(idata != null) compatible = idata.compatible;
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
		if(idata != null && idata.com_rot != null && !idata.com_rot.isEmpty()){
			if(idata.com_rot.containsKey(vehid)){
				rosult = new Rot((idata.com_rot.get(vehid)));
			}
			for(String str : wildcards){
				if(idata.com_rot.containsKey(str)){
					rosult = new Rot((idata.com_rot.get(str)));
					break;
				}
			}
		}
		part.setInstalledPos(result);
		part.setInstalledRot(rosult);
		if(!cat.startsWith("s:") && part.getType().getInstallHandlerData() instanceof DPIHData){
			String point = ((DPIHData)part.getType().getInstallHandlerData()).swivel_point;
			if(point != null && !point.equals("vehicle") && data.getRotationPoints().containsKey(point)){
				part.setInstalledOnSwivelPoint(point);
			}
		}
	}

	@Override
	public boolean validUninstall(MessageSender sender, PartData part, String is_category, VehicleData from){
		DPIHData idata = part.getType().getInstallHandlerData();
		if(idata != null && !idata.removable){
			sender.send("handler.deinstall.fvtm.default.part_not_removable");
			return false;
		}
		//Function Check
		if(!checkWheelSlotsInUse(sender, part, from)) return false;
		sender.send("handler.deinstall.fvtm.default.check_passed");
		return true;
	}
	
	public static boolean checkWheelSlotsInUse(MessageSender sender, PartData part, VehicleData from){
		if(part.hasFunction("fvtm:wheel_positions")){
			WheelPositionsFunction func = part.getFunction("fvtm:wheel_positions");
			for(String key : from.getParts().keySet()){
				if(func.getPositions().containsKey(key)){
					sender.send("handler.deinstall.fvtm.default.remove_linked_wheels");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean processUninstall(MessageSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new V3D());
		data.getParts().remove(cat);
		sender.send("handler.deinstall.fvtm.default.success");
		return true;
	}
	
	/** Default Part Install Handler Data */
	public static class DPIHData {
		
		public TreeMap<String, V3D> compatible = new TreeMap<>();
		public TreeMap<String, V3D> com_rot = new TreeMap<>();
		public TreeMap<String, ArrayList<String>> incompatible = new TreeMap<>();
		public TreeMap<String, ArrayList<String>> required = new TreeMap<>();
		public boolean removable = true, custom_cat, sp_req = false, onslot, hotswap;
		public String swivel_point = "vehicle";
		
		public DPIHData(JsonMap map){
			removable = map.getBoolean("Removable", true);
			custom_cat = map.getBoolean("CustomCategory", false);
			swivel_point = map.getString("SwivelPoint", "vehicle");
			sp_req = map.getBoolean("SwivelPointRequired", false);
			if(map.has("Compatible")){
				map.getArray("Compatible").value.forEach(elm -> {
					if(elm.isMap()){
						JsonMap jsn = elm.asMap();
						this.compatible.put(jsn.get("vehicle").string_value(), ContentConfigUtil.getVector(jsn));
						if(jsn.has("rx") || jsn.has("ry") || jsn.has("rz")){
							com_rot.put(jsn.get("vehicle").string_value(), ContentConfigUtil.getVector(jsn, "r"));
						}
					}
					else if(elm.isArray()){
						JsonArray array = elm.asArray();
						this.compatible.put(array.get(3).string_value(), ContentConfigUtil.getVector(array));
						if(array.size() > 4){
							double x = array.get(4).float_value();
							double y = array.size() > 5 ? array.get(5).float_value() : 0;
							double z = array.size() > 6 ? array.get(6).float_value() : 0;
							com_rot.put(array.get(3).string_value(), new V3D(x, y, z));
						}
					}
					else{
						this.compatible.put(elm.string_value(), new V3D());
					}
				});
			}
			if(map.has("Incompatible")){
				if(map.get("Incompatible").isArray()){
					map.get("Incompatible").asArray().value.forEach(elm -> {
						JsonMap jsn = elm.asMap();
						ArrayList<String> parts = jsn.get("parts").asArray().toStringList();
						this.incompatible.put(jsn.get("vehicle").string_value(), parts);
					});
				}
				else{
					map.get("Incompatible").asMap().entries().forEach(entry -> {
						ArrayList<String> parts = null;
						if(entry.getValue().isArray()){
							parts = entry.getValue().asArray().toStringList();
						}
						else{
							parts = (ArrayList<String>)Collections.singletonList(entry.getValue().string_value());
						}
						this.incompatible.put(entry.getKey(), parts);
					});
				}
			}
			if(map.has("Required")){
				if(map.get("Required").isArray()){
					map.get("Required").asArray().value.forEach(elm -> {
						JsonMap jsn = elm.asMap();
						ArrayList<String> parts = jsn.get("parts").asArray().toStringList();
						this.required.put(jsn.get("vehicle").string_value(), parts);
					});
				}
				else{
					map.get("Required").asMap().entries().forEach(entry -> {
						ArrayList<String> parts = null;
						if(entry.getValue().isArray()){
							parts = entry.getValue().asArray().toStringList();
						}
						else{
							parts = (ArrayList<String>)Collections.singletonList(entry.getValue().string_value());
						}
						this.required.put(entry.getKey(), parts);
					});
				}
			}
			onslot = map.getBoolean("SlotBased", false);
			hotswap = map.getBoolean("HotSwap", false);
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
		DPIHData idata = part.getType().getInstallHandlerData();
		return idata == null ? false : idata.custom_cat;
	}

	@Override
	public String[] getValidCategories(PartData part, VehicleData vehicle){
		DPIHData idata = part.getType().getInstallHandlerData();
		if(idata != null && idata.onslot){
			ArrayList<String> found = new ArrayList<>();
			for(Entry<String, PartSlots> data : vehicle.getPartSlotProviders().entrySet()){
				for(int i = 0; i < data.getValue().size(); i++){
					String type = data.getValue().get(i).type;
					for(String str : part.getType().getCategories()){
						if(str.equals(type)){
							found.add(data.getKey() + ":" + data.getValue().get(i).category + ":" + i);
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

	@Override
	public Object parseData(JsonMap map){
		return new DPIHData(map);
	}

}
