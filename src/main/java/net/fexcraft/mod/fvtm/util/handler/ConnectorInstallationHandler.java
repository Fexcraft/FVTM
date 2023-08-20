package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.part.PartSlot.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.uni.Pos;
import net.minecraft.command.ICommandSender;

public class ConnectorInstallationHandler extends PartInstallationHandler {
	
	public static final ConnectorInstallationHandler INSTANCE = new ConnectorInstallationHandler();

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat)){
			Print.chatnn(sender, "handler.install.fvtm.connector.category_occupied");
			return false;
		}
		ConnectorData idata = part.getType().getInstallationHandlerData();
		String regname = data.getType().getRegistryName().toString();
		if(cat.startsWith("front")){
			if(data.getFrontConnector() != null){
				Print.chatnn(sender, "handler.install.fvtm.connector.front_occupied");
				return false;
			}
			if(idata.getFrontPosition(regname) == null){
				Print.chatnn(sender, "handler.install.fvtm.connector.not_front_part");
				return false;
			}
		}
		else{
			if(data.getRearConnector() != null){
				Print.chatnn(sender, "handler.install.fvtm.connector.rear_occupied");
				return false;
			}
			if(idata.getRearPosition(regname) == null){
				Print.chatnn(sender, "handler.install.fvtm.connector.not_rear_part");
				return false;
			}
		}
		//TODO connector kind
		Print.chatnn(sender, "handler.install.fvtm.connector.check_passed");
		return true;
	}
	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat.startsWith("s:") ? cat.split(":")[2] : cat, part);
		ConnectorData idata = part.getType().getInstallationHandlerData();
		DefaultPartInstallHandler.setPosAndSwivelPoint(null, idata.compatible, cat, part, data);
		boolean front = cat.startsWith("front");
		String regname = data.getType().getRegistryName().toString();
		V3D conn = front ? idata.getFrontPosition(regname) : idata.getRearPosition(regname);
		if(idata.relative){
			conn = conn.add(part.getInstalledPos().toV3D());
		}
		data.setConnector(conn, front);
		Print.chatnn(sender, "handler.install.fvtm.connector.success");
		return true;
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		ConnectorData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			Print.chatnn(sender, "handler.deinstall.fvtm.connector.part_not_removable");
			return false;
		}
		Print.chatnn(sender, "handler.deinstall.fvtm.connector.check_passed");
		return true;
	}

	@Override
	public boolean processUninstall(ICommandSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new Pos(0, 0, 0));
		data.getParts().remove(cat);
		data.setConnector(null, cat.startsWith("front"));
		Print.chatnn(sender, "handler.deinstall.fvtm.connector.success");
		return true;
	}
	
	/** Default Part Install Handler Data */
	public static class ConnectorData {
		
		private boolean removable, onslot, relative;
		private TreeMap<String, Pos> compatible = new TreeMap<String, Pos>();
		private HashMap<String, V3D> front = new HashMap<String, V3D>();
		private HashMap<String, V3D> rear = new HashMap<String, V3D>();
		
		public ConnectorData(JsonObject obj){
			if(obj.has("Front") && obj.get("Front").isJsonArray()){
				front.put("*", Pos.fromJson(obj.get("Front"), true).toV3D());
			}
			if(obj.has("Rear") && obj.get("Rear").isJsonArray()){
				rear.put("*", Pos.fromJson(obj.get("Rear"), true).toV3D());
			}
			//
			if(obj.has("Front") && obj.get("Front").isJsonObject()){
				JsonObject jsn = obj.get("Front").getAsJsonObject();
				for(java.util.Map.Entry<String, JsonElement> entry : jsn.entrySet()){
					front.put(entry.getKey(), Pos.fromJson(entry.getValue(), true).toV3D());
				}
			}
			if(obj.has("Rear") && obj.get("Rear").isJsonObject()){
				JsonObject jsn = obj.get("Rear").getAsJsonObject();
				for(java.util.Map.Entry<String, JsonElement> entry : jsn.entrySet()){
					rear.put(entry.getKey(), Pos.fromJson(entry.getValue(), true).toV3D());
				}
			}
			//
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
						this.compatible.put(elm.getAsString(), Pos.NULL);
					}
				});
			}
			onslot = JsonUtil.getIfExists(obj, "SlotBased", false);
			relative = JsonUtil.getIfExists(obj, "Relative", false);
		}

		public V3D getFrontPosition(String id){
			if(front.containsKey(id)) return front.get(id);
			return front.get("*");
		}
		
		public V3D getRearPosition(String id){
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
		ConnectorData idata = part.getType().getInstallationHandlerData();
		if(idata != null && idata.onslot){
			ArrayList<String> found = new ArrayList<>();
			for(Entry<String, PartSlots> entry : vehicle.getPartSlotProviders().entrySet()){
				for(int i = 0; i < entry.getValue().size(); i++){
					String type = entry.getValue().get(i).type;
					if(type.equals("front_connector") || type.equals("rear_connector")){
						found.add(entry.getKey() + ":" + (type.equals("front_connector") ? "front_connector" : "rear_connector"));
					}
				}
			}
			String[] arr = new String[found.size()];
			for(int i = 0; i < arr.length; i++){
				arr[i] = "s:" + found.get(i) + ":" + i;
			}
			return arr;
		}
		return new String[]{ "front_connector", "rear_connector" };
	}

}
