package net.fexcraft.mod.fvtm.handler;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.WheelFunction;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.function.part.TireFunction;
import net.fexcraft.mod.uni.world.MessageSender;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TireInstallationHandler extends PartInstallHandler {

	public static final TireInstallationHandler INSTANCE = new TireInstallationHandler();

	@Override
	public boolean validInstall(MessageSender sender, PartData part, String cat, VehicleData data, boolean swap){
		if(data.getType().getVehicleType().isRailVehicle()){
			sender.send("handler.install.fvtm.tire.rail_vehicle");
			return false;
		}
		if(data.getParts().containsKey(cat)){
			sender.send("handler.install.fvtm.tire.category_occupied");
			return false;
		}
		String whcat = cat.split(":")[0];
		if(!data.getWheelSlots().containsKey(whcat)){
			sender.send("handler.install.fvtm.tire.wheelslot_missing");
			return false;
		}
		if(!data.hasPart(whcat)){
			sender.send("handler.install.fvtm.tire.no_wheel_at_slot");
			return false;
		}
		TireData idata = part.getType().getInstallHandlerData();
		WheelSlot slot = data.getWheelSlots().get(whcat);
		if(slot == null){
			sender.send("handler.install.fvtm.tire.wheelslot_null");
			return false;
		}
		if(idata.outer_radius > slot.max_radius){
			sender.send("handler.install.fvtm.tire.radius_too_large:" + idata.outer_radius + ":" + slot.max_radius);
			return false;
		}
		if(idata.outer_radius < slot.min_tire_radius){
			sender.send("handler.install.fvtm.tire.radius_too_small:" + idata.outer_radius + ":" + slot.min_tire_radius);
			return false;
		}
		WheelData wdata = data.getPart(whcat).getType().getInstallHandlerData();
		if(idata.inner_radius < wdata.getRadius()){
			sender.send("handler.install.fvtm.tire.wheel_larger_than_tire_inner_radius:" + wdata.getRadius() + ":" + idata.inner_radius);
			return false;
		}
		if(idata.inner_radius > wdata.getRadius()){
			sender.send("handler.install.fvtm.tire.tire_inner_radius_larger_than_wheel:" + idata.inner_radius + ":" +  wdata.getRadius());
			return false;
		}
		//
		if(idata.width > slot.max_width){
			sender.send("handler.install.fvtm.tire.width_too_wide:" + idata.width + ":" + slot.max_width);
			return false;
		}
		if(idata.width < slot.min_tire_width){
			sender.send("handler.install.fvtm.tire.width_too_thin:" + idata.width + ":" + slot.min_tire_width);
			return false;
		}
		sender.send("handler.install.fvtm.tire.check_passed");
		return true;
	}

	@Override
	public boolean processInstall(MessageSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		String whcat = cat.split(":")[0];
		part.setInstalledPos(data.getWheelSlots().get(whcat).position);
		{
			PartData wheel = data.getPart(whcat);
			WheelFunction func = wheel.getFunction("fvtm:wheel");
			if(func != null) func.setWheel(whcat, data.getWheelSlots().get(whcat));
		}
		{
			TireFunction func = part.getFunction("fvtm:tire");
			if(func != null) func.setWheel(whcat, data.getWheelSlots().get(whcat));
		}
		TireData idata = part.getType().getInstallHandlerData();
		data.getWheelPositions().put(whcat, part.getInstalledPos().add(((cat.contains("left") ? -idata.width : idata.width) * 0.5f), -idata.outer_radius, 0));
		sender.send("handler.install.fvtm.tire.success");
		return true;
	}

	@Override
	public boolean validUninstall(MessageSender sender, PartData part, String is_category, VehicleData from, boolean swap){
		TireData idata = part.getType().getInstallHandlerData();
		if(idata != null && !idata.removable){
			sender.send("handler.deinstall.fvtm.tire.part_not_removable");
			return false;
		}
		sender.send("handler.deinstall.fvtm.tire.check_passed");
		return true;
	}

	@Override
	public boolean processUninstall(MessageSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new V3D(0, 0, 0));
		data.getParts().remove(cat);
		data.getWheelPositions().remove(cat);
		sender.send("handler.deinstall.fvtm.tire.success");
		return true;
	}

	/** Wheel Part Install Handler Data */
	public static class TireData {

		private float outer_radius, inner_radius, width;
		protected boolean removable;

		public TireData(JsonMap map){
			this.outer_radius = map.getFloat("OuterRadius", 1f);
			this.inner_radius = map.getFloat("InnerRadius", 0.75f);
			this.width = map.getFloat("Width", 0.25f);
			this.removable = map.getBoolean("Removable", true);
		}

		public float getOuterRadius(){
			return outer_radius;
		}

		public float getInnerRadius(){
			return inner_radius;
		}

		public float getWidth(){
			return width;
		}

	}

	@Override
	public List<String> getValidCategories(PartData part, VehicleData vehicle){
		ArrayList<String> strs = new ArrayList<>();
		for(String str : vehicle.getWheelSlots().keySet()){
			if(vehicle.hasPart(str)){
				WheelData data = vehicle.getPart(str).getType().getInstallHandlerData();
				if(data != null && data.hasTire()) continue;
				strs.add(str + ":tire");
			}
		}
		return strs;
	}

	@Override
	public Object parseData(JsonMap map){
		return new TireData(map);
	}

}
