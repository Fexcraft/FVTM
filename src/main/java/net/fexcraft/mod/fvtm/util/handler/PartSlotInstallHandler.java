package net.fexcraft.mod.fvtm.util.handler;

import static net.fexcraft.mod.fvtm.util.handler.DefaultPartInstallHandler.checkWheelSlotsInUse;
import static net.fexcraft.mod.fvtm.util.handler.DefaultPartInstallHandler.wildcards;

import java.util.ArrayList;
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
import net.minecraft.command.ICommandSender;

public class PartSlotInstallHandler extends PartInstallationHandler {
	
	public static final PartSlotInstallHandler INSTANCE = new PartSlotInstallHandler();

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat.split(":")[2])){
			Print.chatnn(sender, "There is already another part with that category installed.");
			return false;
		}
		PSIHData idata = part.getType().getInstallationHandlerData();
		if(!compatible(idata, data.getType().getRegistryName().toString())){
			Print.chatnn(sender, "Part incompatible with this vehicle.");
			return false;
		}
		Print.chatnn(sender, "Installation check passed."); return true;
	}

	private boolean compatible(PSIHData idata, String string){
		if(idata == null || idata.allowsAny()) return true;
		return idata.compatible.containsKey(string);
	}

	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		PartData mount = data.getPart(cat.split(":")[1]);
		PSIHData idata = part.getType().getInstallationHandlerData();
		Pos pos = mount.getInstalledPos();
		if(idata != null){
			pos = pos.add(idata.getOffset());
		}
		part.setInstalledPos(pos);
		if(mount.getSwivelPointInstalledOn() != null && !mount.getSwivelPointInstalledOn().equals("vehicle")){
			part.setInstalledOnSwivelPoint(mount.getSwivelPointInstalledOn());
		}
		Print.chatnn(sender, "Part installed into selected part slot."); return true;
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		PSIHData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			Print.chatnn(sender, "Part is marked as non removable."); return false;
		}
		//Function Check
		if(!checkWheelSlotsInUse(sender, part, from)) return false;
		Print.chatnn(sender, "Deinstallation check passed."); return true;
	}

	@Override
	public boolean processUninstall(ICommandSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new Pos(0, 0, 0));
		data.getParts().remove(cat);
		part.getAttributes().clear();
		Print.chatnn(sender, "Part uninstalled and position reset."); return true;
	}
	
	/** Default Part Install Handler Data */
	public static class PSIHData {

		public TreeMap<String, Pos> compatible = new TreeMap<String, Pos>();
		public boolean removable = true;
		
		public PSIHData(JsonObject obj){
			if(obj == null) return;
			removable = JsonUtil.getIfExists(obj, "Removable", true);
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
						this.compatible.put(elm.getAsString(), new Pos(0, 0, 0));
					}
				});
			}
		}

		public Pos getOffset(){
			return null;
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
		return false;
	}

	@Override
	public String[] getValidCategories(PartData part, VehicleData vehicle){
		ArrayList<String> found = new ArrayList<>();
		for(Entry<String, PartData> data : vehicle.getParts().entrySet()){
			if(!data.getValue().hasFunction("fvtm:part_slots")) continue;
			PartSlotsFunction func = data.getValue().getFunction("fvtm:part_slots");
			for(int i = 0; i < func.getSlotTypes().size(); i++){
				String type = func.getSlotTypes().get(i);
				for(String str : part.getType().getCategories()){
					if(str.equals(type)){
						found.add(data.getKey() + ":" + func.getSlotCategories().get(i));
					}
				}
			}
		}
		String[] arr = new String[found.size()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = "s:" + found.size();
		}
		return arr;
	}

}
