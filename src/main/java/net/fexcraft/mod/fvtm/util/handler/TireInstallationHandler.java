package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.function.TireFunction;
import net.fexcraft.mod.fvtm.util.function.WheelFunction;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.minecraft.command.ICommandSender;

public class TireInstallationHandler extends PartInstallationHandler {

	public static final TireInstallationHandler INSTANCE = new TireInstallationHandler();

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat)){
			Print.chatnn(sender, "There is already another part with that category installed.");
			return false;
		}
		if(!data.getWheelSlots().containsKey(cat)){
			Print.chatnn(sender, "This Vehicle does not have the required WheelSlot configured.");
			return false;
		}
		if(!data.hasPart(cat.split(":")[0])){
			Print.chatnn(sender, "There is no wheel/rim to install this tire on at that slot!");
			return false;
		}
		TireData idata = part.getType().getInstallationHandlerData();
		WheelSlot slot = data.getWheelSlots().get(cat);
		if(slot == null){
			Print.chatnn(sender, "Error, slot not found.");
			return false;
		}
		// Print.debug(idata.radius, slot.maxradius(), slot.minradius());
		if(idata.outer_radius > slot.max_radius()){
			Print.chatnn(sender, "Tire radius too large. [" + idata.outer_radius + ">" + slot.max_radius() + "]");
			return false;
		}
		if(idata.outer_radius < slot.min_tire_radius()){
			Print.chatnn(sender, "Tire radius too small. [" + idata.outer_radius + "<" + slot.min_tire_radius() + "]");
			return false;
		}
		WheelData wdata = data.getPart(cat.split(":")[0]).getType().getInstallationHandlerData();
		if(idata.inner_radius < wdata.getRadius()){
			Print.chatnn(sender, "Wheel too large for Tire inner radius. [" + wdata.getRadius() + ">" + idata.inner_radius + "]");
			return false;
		}
		if(idata.inner_radius > wdata.getRadius()){
			Print.chatnn(sender, "Tire inner radius too large for this Wheel. [" + idata.inner_radius + ">" +  wdata.getRadius() + "]");
			return false;
		}
		//
		if(idata.width > slot.max_width()){
			Print.chatnn(sender, "Tire is too wide. [" + idata.width + ">" + slot.max_width() + "]");
			return false;
		}
		if(idata.width < slot.min_tire_width()){
			Print.chatnn(sender, "Tire is too thin. [" + idata.width + "<" + slot.min_tire_width() + "]");
			return false;
		}
		Print.chatnn(sender, "Installation check passed.");
		return true;
	}

	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		String whcat = cat.split(":")[0];
		part.setInstalledPos(data.getWheelSlots().get(whcat).pos());
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
		data.getWheelPositions().put(cat, new Pos(partpos.x, -partpos.y - idata.outer_radius, -partpos.z + ((cat.contains("left") ? -idata.width : idata.width) * 0.5f)).to16Double());
		// Print.debug("New WheelPos: " + data.getWheelPositions().get(cat));
		Print.chatnn(sender, "Part installed into selected category.");
		return true;
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		TireData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			Print.chatnn(sender, "Part is marked as non removable.");
			return false;
		}
		Print.chatnn(sender, "Deinstallation check passed.");
		return true;
	}

	@Override
	public boolean processUninstall(ICommandSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new Pos(0, 0, 0));
		data.getParts().remove(cat);
		data.getWheelPositions().remove(cat);
		Print.chatnn(sender, "Part uninstalled and position reset.");
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
