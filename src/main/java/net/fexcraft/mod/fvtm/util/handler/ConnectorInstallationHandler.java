package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallHandler;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.world.MessageSender;

public class ConnectorInstallationHandler extends PartInstallHandler {

	public static final ConnectorInstallationHandler INSTANCE = new ConnectorInstallationHandler();

	@Override
	public boolean validInstall(MessageSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat)){
			sender.send("handler.install.fvtm.connector.category_occupied");
			return false;
		}
		ConnectorData idata = part.getType().getInstallHandlerData();
		String regname = data.getType().getIDS();
		if(cat.startsWith("front")){
			if(data.getFrontConnector() != null){
				sender.send("handler.install.fvtm.connector.front_occupied");
				return false;
			}
			if(idata.getFrontPosition(regname) == null){
				sender.send("handler.install.fvtm.connector.not_front_part");
				return false;
			}
		}
		else{
			if(data.getRearConnector() != null){
				sender.send("handler.install.fvtm.connector.rear_occupied");
				return false;
			}
			if(idata.getRearPosition(regname) == null){
				sender.send("handler.install.fvtm.connector.not_rear_part");
				return false;
			}
		}
		//TODO connector kind
		sender.send("handler.install.fvtm.connector.check_passed");
		return true;
	}
	@Override
	public boolean processInstall(MessageSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat.startsWith("s:") ? cat.split(":")[2] : cat, part);
		ConnectorData idata = part.getType().getInstallHandlerData();
		DefaultPartInstallHandler.setPosAndSwivelPoint(null, idata.compatible, cat, part, data);
		boolean front = cat.startsWith("front");
		String regname = data.getType().getIDS();
		V3D conn = front ? idata.getFrontPosition(regname) : idata.getRearPosition(regname);
		if(idata.relative){
			conn = conn.add(part.getInstalledPos());
		}
		data.setConnector(conn, front);
		sender.send("handler.install.fvtm.connector.success");
		return true;
	}

	@Override
	public boolean validUninstall(MessageSender sender, PartData part, String is_category, VehicleData from){
		ConnectorData idata = part.getType().getInstallHandlerData();
		if(idata != null && !idata.removable){
			sender.send("handler.deinstall.fvtm.connector.part_not_removable");
			return false;
		}
		sender.send("handler.deinstall.fvtm.connector.check_passed");
		return true;
	}

	@Override
	public boolean processUninstall(MessageSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new V3D(0, 0, 0));
		data.getParts().remove(cat);
		data.setConnector(null, cat.startsWith("front"));
		sender.send("handler.deinstall.fvtm.connector.success");
		return true;
	}
	
	/** Default Part Install Handler Data */
	public static class ConnectorData {
		
		private boolean removable, onslot, relative;
		private TreeMap<String, V3D> compatible = new TreeMap<>();
		private HashMap<String, V3D> front = new HashMap<String, V3D>();
		private HashMap<String, V3D> rear = new HashMap<String, V3D>();
		
		public ConnectorData(JsonMap map){
			if(map.has("Front") && map.get("Front").isArray()){
				front.put("*", ContentConfigUtil.getVector(map.get("Front").asArray()));
			}
			if(map.has("Rear") && map.get("Rear").isArray()){
				rear.put("*", ContentConfigUtil.getVector(map.get("Rear").asArray()));
			}
			//
			if(map.has("Front") && map.get("Front").isMap()){
				JsonMap jsn = map.get("Front").asMap();
				for(Entry<String, JsonValue<?>> entry : jsn.entries()){
					front.put(entry.getKey(), ContentConfigUtil.getVector(entry.getValue().asArray()));
				}
			}
			if(map.has("Rear") && map.get("Rear").isMap()){
				JsonMap jsn = map.get("Rear").asMap();
				for(Entry<String, JsonValue<?>> entry : jsn.entries()){
					rear.put(entry.getKey(), ContentConfigUtil.getVector(entry.getValue().asArray()));
				}
			}
			//
			removable = map.getBoolean("Removable", true);
			if(map.has("Compatible")){
				map.get("Compatible").asArray().value.forEach(elm -> {
					if(elm.isMap()){
						JsonMap jsn = elm.asMap();
						this.compatible.put(jsn.get("vehicle").string_value(), ContentConfigUtil.getVector(jsn));
					}
					else if(elm.isArray()){
						JsonArray array = elm.asArray();
						this.compatible.put(array.get(3).string_value(), ContentConfigUtil.getVector(array));
					}
					else{
						this.compatible.put(elm.string_value(), new V3D());
					}
				});
			}
			onslot = map.getBoolean("SlotBased", false);
			relative = map.getBoolean("Relative", false);
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
		ConnectorData idata = part.getType().getInstallHandlerData();
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

	@Override
	public Object parseData(JsonMap map){
		return new ConnectorData(map);
	}

}
