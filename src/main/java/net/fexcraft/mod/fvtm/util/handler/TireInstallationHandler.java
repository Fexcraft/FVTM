package net.fexcraft.mod.fvtm.util.handler;

import static net.fexcraft.mod.fvtm.util.AnotherUtil.toV3;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.util.function.TireFunction;
import net.fexcraft.mod.fvtm.util.function.WheelFunction;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.uni.Pos;
import net.minecraft.command.ICommandSender;

public class TireInstallationHandler extends PartInstallationHandler {

	public static final TireInstallationHandler INSTANCE = new TireInstallationHandler();

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getType().getVehicleType().isRailVehicle()){
			Print.chatnn(sender, "handler.install.fvtm.tire.rail_vehicle");
			return false;
		}
		if(data.getParts().containsKey(cat)){
			Print.chatnn(sender, "handler.install.fvtm.tire.category_occupied");
			return false;
		}
		String whcat = cat.split(":")[0];
		if(!data.getWheelSlots().containsKey(whcat)){
			Print.chatnn(sender, "handler.install.fvtm.tire.wheelslot_missing");
			return false;
		}
		if(!data.hasPart(whcat)){
			Print.chatnn(sender, "handler.install.fvtm.tire.no_wheel_at_slot");
			return false;
		}
		TireData idata = part.getType().getInstallationHandlerData();
		WheelSlot slot = data.getWheelSlots().get(whcat);
		if(slot == null){
			Print.chatnn(sender, "handler.install.fvtm.tire.wheelslot_null");
			return false;
		}
		// Print.debug(idata.radius, slot.maxradius(), slot.minradius());
		if(idata.outer_radius > slot.max_radius){
			Print.chatnn(sender, "handler.install.fvtm.tire.radius_too_large:" + idata.outer_radius + ":" + slot.max_radius);
			return false;
		}
		if(idata.outer_radius < slot.min_tire_radius){
			Print.chatnn(sender, "handler.install.fvtm.tire.radius_too_small:" + idata.outer_radius + ":" + slot.min_tire_radius);
			return false;
		}
		WheelData wdata = data.getPart(whcat).getType().getInstallationHandlerData();
		if(idata.inner_radius < wdata.getRadius()){
			Print.chatnn(sender, "handler.install.fvtm.tire.wheel_larger_than_tire_inner_radius:" + wdata.getRadius() + ":" + idata.inner_radius);
			return false;
		}
		if(idata.inner_radius > wdata.getRadius()){
			Print.chatnn(sender, "handler.install.fvtm.tire.tire_inner_radius_larger_than_wheel:" + idata.inner_radius + ":" +  wdata.getRadius());
			return false;
		}
		//
		if(idata.width > slot.max_width){
			Print.chatnn(sender, "handler.install.fvtm.tire.width_too_wide:" + idata.width + ":" + slot.max_width);
			return false;
		}
		if(idata.width < slot.min_tire_width){
			Print.chatnn(sender, "handler.install.fvtm.tire.width_too_thin:" + idata.width + ":" + slot.min_tire_width);
			return false;
		}
		Print.chatnn(sender, "handler.install.fvtm.tire.check_passed");
		return true;
	}

	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		String whcat = cat.split(":")[0];
		part.setInstalledPos(new Pos(data.getWheelSlots().get(whcat).position));
		{
			PartData wheel = data.getPart(whcat);
			WheelFunction func = wheel.getFunction("fvtm:wheel");
			if(func != null) func.setWheel(whcat, data.getWheelSlots().get(whcat));
		}
		{
			TireFunction func = part.getFunction("fvtm:tire");
			if(func != null) func.setWheel(whcat, data.getWheelSlots().get(whcat));
		}
		TireData idata = part.getType().getInstallationHandlerData();
		Pos partpos = part.getInstalledPos();
		data.getWheelPositions().put(cat, toV3(new Pos(partpos.x, -partpos.y - idata.outer_radius, -partpos.z + ((cat.contains("left") ? -idata.width : idata.width) * 0.5f))));
		// Print.debug("New WheelPos: " + data.getWheelPositions().get(cat));
		Print.chatnn(sender, "handler.install.fvtm.tire.success");
		return true;
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		TireData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			Print.chatnn(sender, "handler.deinstall.fvtm.tire.part_not_removable");
			return false;
		}
		Print.chatnn(sender, "handler.deinstall.fvtm.tire.check_passed");
		return true;
	}

	@Override
	public boolean processUninstall(ICommandSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new Pos(0, 0, 0));
		data.getParts().remove(cat);
		data.getWheelPositions().remove(cat);
		Print.chatnn(sender, "handler.deinstall.fvtm.tire.success");
		return true;
	}

	/** Wheel Part Install Handler Data */
	public static class TireData {

		private float outer_radius, inner_radius, width;
		private boolean removable;

		public TireData(JsonObject obj){
			this.outer_radius = JsonUtil.getIfExists(obj, "OuterRadius", 16f).floatValue();
			this.inner_radius = JsonUtil.getIfExists(obj, "InnerRadius", 16f).floatValue();
			this.width = JsonUtil.getIfExists(obj, "Width", 4f).floatValue();
			this.removable = JsonUtil.getIfExists(obj, "Removable", true);
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
	public boolean allowsCustomCategory(PartData part){
		return false;
	}

	@Override
	public String[] getValidCategories(PartData part, VehicleData vehicle){
		ArrayList<String> strs = new ArrayList<>();
		for(String str : vehicle.getWheelSlots().keySet()){
			if(vehicle.hasPart(str)){
				WheelData data = vehicle.getPart(str).getType().getInstallationHandlerData();
				if(data != null && data.hasTire()) continue;
				strs.add(str + ":tire");
			}
		}
		return strs.toArray(new String[0]);
	}

}
