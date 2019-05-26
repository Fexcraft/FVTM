package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.PartData;
import net.fexcraft.mod.fvtm.data.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.VehicleData;
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

	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part); part.setInstalledPos(getPosForPart(part, data.getType().getRegistryName().toString()));
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
		
		private TreeMap<String, Pos> compatible = new TreeMap<String, Pos>();
		private TreeMap<String, ArrayList<String>> incompatible = new TreeMap<>();
		private boolean removable, custom_cat;
		
		public DPIHData(JsonObject obj){
			removable = JsonUtil.getIfExists(obj, "Removable", true);
			custom_cat = JsonUtil.getIfExists(obj, "CustomCategory", false);
			if(obj.has("Compatible")){
				obj.get("Compatible").getAsJsonArray().forEach(elm -> {
					JsonObject jsn = elm.getAsJsonObject();
					this.compatible.put(jsn.get("Vehicle").getAsString(), Pos.fromJson(jsn, false));
				});
			}
			if(obj.has("Incompatible")){
				obj.get("Incompable").getAsJsonArray().forEach(elm -> {
					JsonObject jsn = elm.getAsJsonObject();
					ArrayList<String> parts = JsonUtil.jsonArrayToStringArray(jsn.get("Parts").getAsJsonArray());
					this.incompatible.put(jsn.get("Vehicle").getAsString(), parts);
				});
			}
		}
		
	}

	@Override
	public boolean allowsCustomCategory(PartData part){
		DPIHData idata = part.getType().getInstallationHandlerData();
		return idata == null ? false : idata.custom_cat;
	}

}
