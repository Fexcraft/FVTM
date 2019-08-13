package net.fexcraft.mod.fvtm.util.handler;

import java.util.HashMap;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.math.Vec3d;

public class ConnectorInstallationHandler extends PartInstallationHandler {
	
	public static final ConnectorInstallationHandler INSTANCE = new ConnectorInstallationHandler();

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat)){
			Print.chatnn(sender, "There is already another part with that category installed."); return false;
		}
		ConnectorData idata = part.getType().getInstallationHandlerData();
		String regname = data.getType().getRegistryName().toString();
		if(cat.startsWith("front")){
			if(data.getFrontConnector() != null){
				Print.chatnn(sender, "Front Connector Pos is already set."); return false;
			}
			if(idata.getFrontPosition(regname) == null){
				Print.chatnn(sender, "This is not a Front Connector Part."); return false;
			}
		}
		else{
			if(data.getRearConnector() != null){
				Print.chatnn(sender, "Rear Connector Pos is already set."); return false;
			}
			if(idata.getRearPosition(regname) == null){
				Print.chatnn(sender, "This is not a Rear Connector Part."); return false;
			}
		}
		//TODO connector kind
		Print.chatnn(sender, "Installation check passed."); return true;
	}
	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part); part.setInstalledPos(getPosForPart(part, data.getType().getRegistryName().toString()));
		boolean front = cat.startsWith("front"); ConnectorData idata = part.getType().getInstallationHandlerData();
		String regname = data.getType().getRegistryName().toString();
		data.setConnector(front ? idata.getFrontPosition(regname) : idata.getRearPosition(regname), front);
		Print.chatnn(sender, "Part installed into selected category."); return true;
	}

	private Pos getPosForPart(PartData part, String string){
		ConnectorData idata = part.getType().getInstallationHandlerData();
		if(idata == null || !idata.compatible.containsKey(string)) return new Pos(0, 0, 0); return idata.compatible.get(string);
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		ConnectorData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			Print.chatnn(sender, "Part is marked as non removable."); return false;
		} Print.chatnn(sender, "Deinstallation check passed."); return true;
	}

	@Override
	public boolean processUninstall(ICommandSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new Pos(0, 0, 0)); data.getParts().remove(cat); part.getAttributes().clear();
		data.setConnector(null, cat.startsWith("front"));
		Print.chatnn(sender, "Part uninstalled and position reset."); return true;
	}
	
	/** Default Part Install Handler Data */
	public static class ConnectorData {
		
		private boolean removable;
		private TreeMap<String, Pos> compatible = new TreeMap<String, Pos>();
		private HashMap<String, Vec3d> front = new HashMap<String, Vec3d>();
		private HashMap<String, Vec3d> rear = new HashMap<String, Vec3d>();
		
		public ConnectorData(JsonObject obj){
			if(obj.has("Front") && obj.get("Front").isJsonArray()){
				front.put("*", Pos.fromJson(obj.get("Front"), true).to16Double());
			}
			if(obj.has("Rear") && obj.get("Rear").isJsonArray()){
				rear.put("*", Pos.fromJson(obj.get("Rear"), true).to16Double());
			}
			//
			if(obj.has("Front") && obj.get("Front").isJsonObject()){
				JsonObject jsn = obj.get("Front").getAsJsonObject();
				for(java.util.Map.Entry<String, JsonElement> entry : jsn.entrySet()){
					front.put(entry.getKey(), Pos.fromJson(entry.getValue(), true).to16Double());
				}
			}
			if(obj.has("Rear") && obj.get("Rear").isJsonObject()){
				JsonObject jsn = obj.get("Rear").getAsJsonObject();
				for(java.util.Map.Entry<String, JsonElement> entry : jsn.entrySet()){
					rear.put(entry.getKey(), Pos.fromJson(entry.getValue(), true).to16Double());
				}
			}
			//
			removable = JsonUtil.getIfExists(obj, "Removable", true);
			if(obj.has("Compatible")){
				obj.get("Compatible").getAsJsonArray().forEach(elm -> {
					JsonObject jsn = elm.getAsJsonObject();
					this.compatible.put(jsn.get("vehicle").getAsString(), Pos.fromJson(jsn, false));
				});
			}
		}

		public Vec3d getFrontPosition(String id){
			if(front.containsKey(id)) return front.get(id);
			return front.get("*");
		}
		
		public Vec3d getRearPosition(String id){
			if(rear.containsKey(id)) return rear.get(id);
			return rear.get("*");
		}
		
		public boolean isRemovable(){
			return removable;
		}
		
	}

	@Override
	public boolean allowsCustomCategory(PartData part){
		return false;
	}

	@Override
	public String[] getValidCategories(PartData part, VehicleData vehicle){
		return new String[]{ "front_connector", "rear_connector" };
	}

}
