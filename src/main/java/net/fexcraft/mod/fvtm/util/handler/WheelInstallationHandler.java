package net.fexcraft.mod.fvtm.util.handler;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.WheelFunction;
import net.fexcraft.mod.fvtm.util.function.TireFunction;
import net.fexcraft.mod.uni.world.MessageSender;

public class WheelInstallationHandler extends PartInstallHandler {

	public static final WheelInstallationHandler INSTANCE = new WheelInstallationHandler();

	@Override
	public boolean validInstall(MessageSender sender, PartData part, String cat, VehicleData data){
		if(data.getType().getVehicleType().isRailVehicle()){
			sender.send("handler.install.fvtm.wheel.rail_vehicle");
			return false;
		}
		if(data.getParts().containsKey(cat)){
			sender.send("handler.install.fvtm.wheel.category_occupied");
			return false;
		}
		if(!data.getWheelSlots().containsKey(cat)){
			sender.send("handler.install.fvtm.wheel.wheelslot_missing");
			return false;
		}
		WheelData idata = part.getType().getInstallHandlerData();
		WheelSlot slot = data.getWheelSlots().get(cat);
		if(slot == null){
			sender.send("handler.install.fvtm.wheel.wheelslot_null");
			return false;
		}
		// Print.debug(idata.radius, slot.maxradius(), slot.minradius());
		if(idata.radius > slot.max_radius){
			sender.send("handler.install.fvtm.wheel.radius_too_large:" + idata.radius + ":" + slot.max_radius);
			return false;
		}
		if(idata.radius < slot.min_radius(idata.has_tire)){
			sender.send("handler.install.fvtm.wheel.radius_too_small:" + idata.radius + ":" + slot.min_radius(idata.has_tire));
			return false;
		}
		if(idata.width > slot.max_width){
			sender.send("handler.install.fvtm.wheel.width_too_wide:" + idata.width + ":" + slot.max_width);
			return false;
		}
		if(idata.width < slot.min_width(idata.has_tire)){
			sender.send("handler.install.fvtm.wheel.width_too_thin:" + idata.width + ":" + slot.min_width(idata.has_tire));
			return false;
		}
		if(idata.hubsize != slot.hubsize){
			sender.send("handler.install.fvtm.wheel.incompatible_connector");
			return false;
		}
		sender.send("handler.install.fvtm.wheel.check_passed");
		return true;
	}

	@Override
	public boolean processInstall(MessageSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		part.setInstalledPos(data.getWheelSlots().get(cat).position);
		{
			WheelFunction func = part.getFunction("fvtm:wheel");
			if(func != null) func.setWheel(cat, data.getWheelSlots().get(cat));
		}
		{
			TireFunction func = part.getFunction("fvtm:tire");
			if(func != null) func.setWheel(cat, data.getWheelSlots().get(cat));
		}
		WheelData idata = part.getType().getInstallHandlerData();
		data.getWheelPositions().put(cat, part.getInstalledPos().add(0, -idata.radius, ((cat.contains("left") ? -idata.width : idata.width) * 0.5f)));
		// Print.debug("New WheelPos: " + data.getWheelPositions().get(cat));
		sender.send("handler.install.fvtm.wheel.success");
		return true;
	}

	@Override
	public boolean validUninstall(MessageSender sender, PartData part, String is_category, VehicleData from){
		WheelData idata = part.getType().getInstallHandlerData();
		if(idata != null && !idata.removable){
			sender.send("handler.deinstall.fvtm.wheel.part_not_removable");
			return false;
		}
		if(from.hasPart(is_category + ":tire")){
			sender.send("handler.deinstall.fvtm.wheel.remove_tire_first");
			return false;
		}
		sender.send("handler.deinstall.fvtm.wheel.check_passed");
		return true;
	}

	@Override
	public boolean processUninstall(MessageSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new V3D(0, 0, 0));
		data.getParts().remove(cat);
		data.getWheelPositions().remove(cat);
		sender.send("handler.deinstall.fvtm.wheel.success");
		return true;
	}

	/** Wheel Part Install Handler Data */
	public static class WheelData {

		private float radius, width, hubsize;
		private boolean removable, has_tire;

		public WheelData(JsonMap map){
			this.radius = map.getFloat("Radius", 16f);
			this.width = map.getFloat("Width", 4f);
			this.hubsize = map.getFloat("HubSize", 0f);
			this.removable = map.getBoolean("Removable", true);
			this.has_tire = map.getBoolean("Tireless", true);
		}

		public float getRadius(){
			return radius;
		}

		public float getWidth(){
			return width;
		}
		
		public boolean hasTire(){
			return has_tire;
		}

	}

	@Override
	public boolean allowsCustomCategory(PartData part){
		return false;
	}

	@Override
	public String[] getValidCategories(PartData part, VehicleData vehicle){
		return vehicle.getWheelSlots().keySet().toArray(new String[0]);
	}

	@Override
	public Object parseData(JsonMap map){
		return new WheelData(map);
	}

}
