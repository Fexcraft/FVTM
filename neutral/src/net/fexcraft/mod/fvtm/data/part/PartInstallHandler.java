package net.fexcraft.mod.fvtm.data.part;

import java.util.HashMap;
import java.util.List;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.uni.world.MessageSender;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class PartInstallHandler {

	public static HashMap<String, PartInstallHandler> HANDLERS = new HashMap<>();

	public abstract boolean validInstall(MessageSender sender, PartData part, String as_category, VehicleData into, boolean swap);
	
	public abstract boolean processInstall(MessageSender sender, PartData part, String in_category, VehicleData into);

	public abstract boolean validUninstall(MessageSender sender, PartData part, String is_category, VehicleData from, boolean swap);

	public abstract boolean processUninstall(MessageSender sender, PartData part, String in_category, VehicleData from);
	
	public abstract List<String> getValidCategories(PartData part, VehicleData vehicle);

	public abstract Object parseData(JsonMap map);

	public static PartInstallHandler getHandler(String id){
		if(HANDLERS.containsKey(id)) return HANDLERS.get(id);
		return HANDLERS.get("default");
	}

}
