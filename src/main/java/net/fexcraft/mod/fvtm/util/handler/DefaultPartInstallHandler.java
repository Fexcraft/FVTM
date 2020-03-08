package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.function.WheelPositionsFunction;
import net.minecraft.command.ICommandSender;

public class DefaultPartInstallHandler extends PartInstallationHandler {
	
	public static final DefaultPartInstallHandler INSTANCE = new DefaultPartInstallHandler();

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat)){
			Print.chatnn(sender, "There is already another part with that category installed."); return false;
		}
		DPIHData idata = part.getType().getInstallationHandlerData();
		if(!part.getType().getCategories().contains(cat) && (idata != null && !idata.custom_cat)){
			Print.chatnn(sender, "Part does not allow installing into this category."); return false;
		}
		if(!compatible(idata, data.getType().getRegistryName().toString())){
			Print.chatnn(sender, "Part incompatible with this vehicle."); return false;
		}
		if(containsIncompatible(idata, data)){
			Print.chatnn(sender, "Vehicle contains parts incompatible with this part."); return false;
		}
		if(!containsRequired(idata, data)){
			Print.chatnn(sender, "Vehicle does not contain all required parts."); return false;
		}
		if(idata != null && idata.sp_req && !data.getRotationPoints().containsKey(idata.swivel_point)){
			Print.chatnn(sender, "Vehicle does not contain a required swivel/rotation point. Missing: " + idata.swivel_point);
			return false;
		}
		Print.chatnn(sender, "Installation check passed."); return true;
	}

	private boolean compatible(DPIHData idata, String string){
		if(idata != null && !idata.compatible.isEmpty() && !idata.compatible.containsKey("*")
			&& !idata.compatible.containsKey("any") && !idata.compatible.containsKey("all")){
			return idata.compatible.containsKey(string);
		} else return true;
	}
	
	private boolean containsIncompatible(DPIHData idata, VehicleData data){
		if(idata == null || !idata.incompatible.containsKey(data.getType().getRegistryName().toString())){ return false; }
		ArrayList<String> list = idata.incompatible.get(data.getType().getRegistryName().toString());
		for(String str : list) if(data.getParts().containsKey(str)) return true; return false;
	}
	
	private boolean containsRequired(DPIHData idata, VehicleData data){
		if(idata == null || !idata.required.containsKey(data.getType().getRegistryName().toString())){ return true; }
		ArrayList<String> list = idata.required.get(data.getType().getRegistryName().toString());
		for(String str : list) if(!data.getParts().containsKey(str)) return false; return true;
	}

	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		part.setInstalledPos(getPosForPart(part, data.getType().getRegistryName().toString()));
		if(part.getType().getInstallationHandlerData() != null){
			String point = ((DPIHData)part.getType().getInstallationHandlerData()).swivel_point;
			if(point != null && !point.equals("vehicle") && data.getRotationPoints().containsKey(point)){
				part.setInstalledOnSwivelPoint(point);
			}
		}
		/*data.getAttributes().values().forEach(attr ->{
			attr.getModifiers().forEach(mod -> {
				Print.debug(mod.id(), mod.origin(), mod.target());
			});
		});*/
		Print.chatnn(sender, "Part installed into selected category."); return true;
	}

	private Pos getPosForPart(PartData part, String string){
		DPIHData idata = part.getType().getInstallationHandlerData();
		if(idata == null || !idata.compatible.containsKey(string)) return new Pos(0, 0, 0); return idata.compatible.get(string);
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		DPIHData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			Print.chatnn(sender, "Part is marked as non removable."); return false;
		}
		//Function Check
		if(part.hasFunction("fvtm:wheel_positions")){
			WheelPositionsFunction func = part.getFunction("fvtm:wheel_positions");
			for(String key : from.getParts().keySet()){
				if(func.getPositions().containsKey(key)){
					Print.chatnn(sender, "Please remove all linked wheels first."); return false;
				}
			}
		}
		Print.chatnn(sender, "Deinstallation check passed."); return true;
	}

	@Override
	public boolean processUninstall(ICommandSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new Pos(0, 0, 0)); data.getParts().remove(cat);
		part.getAttributes().clear();
		Print.chatnn(sender, "Part uninstalled and position reset."); return true;
	}
	
	/** Default Part Install Handler Data */
	public static class DPIHData {
		
		public TreeMap<String, Pos> compatible = new TreeMap<String, Pos>();
		public TreeMap<String, ArrayList<String>> incompatible = new TreeMap<>();
		public TreeMap<String, ArrayList<String>> required = new TreeMap<>();
		public boolean removable = true, custom_cat, sp_req = false;
		public String swivel_point = "vehicle";
		
		public DPIHData(JsonObject obj){
			if(obj == null) return;
			removable = JsonUtil.getIfExists(obj, "Removable", true);
			custom_cat = JsonUtil.getIfExists(obj, "CustomCategory", false);
			swivel_point = JsonUtil.getIfExists(obj, "SwivelPoint", "vehicle");
			sp_req = JsonUtil.getIfExists(obj, "SwivelPointRequired", false);
			if(obj.has("Compatible")){
				obj.get("Compatible").getAsJsonArray().forEach(elm -> {
					JsonObject jsn = elm.getAsJsonObject();
					this.compatible.put(jsn.get("vehicle").getAsString(), Pos.fromJson(jsn, false));
				});
			}
			if(obj.has("Incompatible")){
				obj.get("Incompatible").getAsJsonArray().forEach(elm -> {
					JsonObject jsn = elm.getAsJsonObject();
					ArrayList<String> parts = JsonUtil.jsonArrayToStringArray(jsn.get("parts").getAsJsonArray());
					this.incompatible.put(jsn.get("vehicle").getAsString(), parts);
				});
			}
			if(obj.has("Required")){
				obj.get("Required").getAsJsonArray().forEach(elm -> {
					JsonObject jsn = elm.getAsJsonObject();
					ArrayList<String> parts = JsonUtil.jsonArrayToStringArray(jsn.get("parts").getAsJsonArray());
					this.incompatible.put(jsn.get("vehicle").getAsString(), parts);
				});
			}
		}
		
	}

	@Override
	public boolean allowsCustomCategory(PartData part){
		DPIHData idata = part.getType().getInstallationHandlerData();
		return idata == null ? false : idata.custom_cat;
	}

	@Override
	public String[] getValidCategories(PartData part, VehicleData vehicle){
		return part.getType().getCategories().toArray(new String[0]);
	}

}
