package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.part.BogieFunction;
import net.fexcraft.mod.uni.world.MessageSender;

public class BogieInstallationHandler extends PartInstallHandler {

	public static final BogieInstallationHandler INSTANCE = new BogieInstallationHandler();
	private static List<String> bogies = new ArrayList<>();
	static{
		bogies.add("bogie_front");
		bogies.add("bogie_rear");
	}

	@Override
	public boolean validInstall(MessageSender sender, PartData part, String cat, VehicleData data, boolean swap){
		if(!data.getType().getVehicleType().isRailVehicle()){
			sender.send("handler.install.fvtm.bogie.not_rail_vehicle");
			return false;
		}
		if(data.getParts().containsKey(cat)){
			sender.send("handler.install.fvtm.bogie.category_occupied");
			return false;
		}
		if(!data.getWheelSlots().containsKey(cat)){
			sender.send("handler.install.fvtm.bogie.bogieslot_missing");
			return false;
		}
		sender.send("handler.install.fvtm.bogie.check_passed");
		return true;
	}
	@Override
	public boolean processInstall(MessageSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		part.setInstalledPos(data.getWheelSlots().get(cat).position);
		BogieFunction func = part.getFunction("fvtm:bogie");
		if(func != null) func.setBogie(cat);
		BogieData idata = part.getType().getInstallHandlerData();
		data.getWheelPositions().put(cat, part.getInstalledPos().add(0, -idata.height, 0));
		//Print.debug("New BogiePos: " + data.getWheelPositions().get(cat));
		sender.send("handler.install.fvtm.bogie.success");
		return true;
	}

	@Override
	public boolean validUninstall(MessageSender sender, PartData part, String is_category, VehicleData from, boolean swap){
		BogieData idata = part.getType().getInstallHandlerData();
		if(idata != null && !idata.removable){
			sender.send("handler.deinstall.fvtm.bogie.part_not_removable");
			return false;
		}
		sender.send("handler.deinstall.fvtm.bogie.check_passed");
		return true;
	}

	@Override
	public boolean processUninstall(MessageSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new V3D(0, 0, 0));
		data.getParts().remove(cat);
		data.getWheelPositions().remove(cat);
		sender.send("handler.deinstall.fvtm.bogie.success");
		return true;
	}
	
	/** Bogie Part Install Handler Data */
	public static class BogieData {
		
		private boolean removable;
		/** from 0 (connection/install) point to rail (e.g. wheel base) */
		private float height;
		
		public BogieData(JsonMap map){
			removable = map.getBoolean("Removable", true);
			height = map.getFloat("Height", 8);
		}
		
	}

	@Override
	public List<String> getValidCategories(PartData part, VehicleData vehicle){
		return bogies;
	}

	@Override
	public Object parseData(JsonMap map){
		return new BogieData(map);
	}

}
