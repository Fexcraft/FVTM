package net.fexcraft.mod.fvtm.util.handler;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.BogieFunction;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.uni.world.MessageSender;

public class BogieInstallationHandler extends PartInstallHandler {

	public static final BogieInstallationHandler INSTANCE = new BogieInstallationHandler();

	@Override
	public boolean validInstall(MessageSender sender, PartData part, String cat, VehicleData data){
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
		part.setInstalledPos(new Pos(data.getWheelSlots().get(cat).position));
		BogieFunction func = part.getFunction("fvtm:bogie");
		if(func != null) func.setBogie(cat);
		BogieData idata = part.getType().getInstallationHandlerData();
		Pos partpos = part.getInstalledPos();
		data.getWheelPositions().put(cat, new Pos(partpos.x, -partpos.y - idata.height, -partpos.z).toV3D());
		//Print.debug("New BogiePos: " + data.getWheelPositions().get(cat));
		sender.send("handler.install.fvtm.bogie.success");
		return true;
	}

	@Override
	public boolean validUninstall(MessageSender sender, PartData part, String is_category, VehicleData from){
		BogieData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			sender.send("handler.deinstall.fvtm.bogie.part_not_removable");
			return false;
		}
		sender.send("handler.deinstall.fvtm.bogie.check_passed");
		return true;
	}

	@Override
	public boolean processUninstall(MessageSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new Pos(0, 0, 0));
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
	public boolean allowsCustomCategory(PartData part){
		return false;
	}

	@Override
	public String[] getValidCategories(PartData part, VehicleData vehicle){
		return new String[]{ "bogie_front", "bogie_rear" };
	}

	@Override
	public Object parseData(JsonMap map){
		return new BogieData(map);
	}

}
