package net.fexcraft.mod.fvtm.util.handler;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.uni.world.MessageSender;

import java.util.List;

public class BogieInstallationHandler extends net.fexcraft.mod.fvtm.data.part.PartInstallHandler {

	@Override
	public boolean validInstall(MessageSender sender, PartData part, String as_category, VehicleData into, boolean swap){
		return false;
	}

	@Override
	public boolean processInstall(MessageSender sender, PartData part, String in_category, VehicleData into){
		return false;
	}

	@Override
	public boolean validUninstall(MessageSender sender, PartData part, String is_category, VehicleData from, boolean swap){
		return false;
	}

	@Override
	public boolean processUninstall(MessageSender sender, PartData part, String in_category, VehicleData from){
		return false;
	}

	@Override
	public List<String> getValidCategories(PartData part, VehicleData vehicle){
		return null;
	}

	@Override
	public Object parseData(JsonMap map){
		return null;
	}

}
