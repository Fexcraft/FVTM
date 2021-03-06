package net.fexcraft.mod.fvtm.util.handler;

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
import net.minecraft.command.ICommandSender;

public class WheelInstallationHandler extends PartInstallationHandler {

	public static final WheelInstallationHandler INSTANCE = new WheelInstallationHandler();

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
		WheelData idata = part.getType().getInstallationHandlerData();
		WheelSlot slot = data.getWheelSlots().get(cat);
		if(slot == null){
			Print.chatnn(sender, "Error, slot not found.");
			return false;
		}
		// Print.debug(idata.radius, slot.maxradius(), slot.minradius());
		if(idata.radius > slot.max_radius()){
			Print.chatnn(sender, "Wheel radius too large. [" + idata.radius + ">" + slot.max_radius() + "]");
			return false;
		}
		if(idata.radius < slot.min_radius(idata.has_tire)){
			Print.chatnn(sender, "Wheel radius too small. [" + idata.radius + "<" + slot.min_radius(idata.has_tire) + "]");
			return false;
		}
		if(idata.width > slot.max_width()){
			Print.chatnn(sender, "Wheel is too wide. [" + idata.width + ">" + slot.max_width() + "]");
			return false;
		}
		if(idata.width < slot.min_width(idata.has_tire)){
			Print.chatnn(sender, "Wheel is too thin. [" + idata.width + "<" + slot.min_width(idata.has_tire) + "]");
			return false;
		}
		if(idata.connector != slot.connector()){
			Print.chatnn(sender, "Incompatible connector.");
			return false;
		}
		Print.chatnn(sender, "Installation check passed.");
		return true;
	}

	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		part.setInstalledPos(data.getWheelSlots().get(cat).pos());
		{
			WheelFunction func = part.getFunction("fvtm:wheel");
			if(func != null) func.setWheel(cat, data.getWheelSlots().get(cat));
		}
		{
			TireFunction func = part.getFunction("fvtm:tire");
			if(func != null) func.setWheel(cat, data.getWheelSlots().get(cat));
		}
		WheelData idata = part.getType().getInstallationHandlerData();
		Pos partpos = part.getInstalledPos();
		data.getWheelPositions().put(cat, new Pos(partpos.x, -partpos.y - idata.radius, -partpos.z + ((cat.contains("left") ? -idata.width : idata.width) * 0.5f)).to16Double());
		// Print.debug("New WheelPos: " + data.getWheelPositions().get(cat));
		Print.chatnn(sender, "Part installed into selected category.");
		return true;
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		WheelData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			Print.chatnn(sender, "Part is marked as non removable.");
			return false;
		}
		if(from.hasPart(is_category + ":tire")){
			Print.chatnn(sender, "Please remove the tire first.");
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
	public static class WheelData {

		private float radius, width, connector;
		private boolean removable, has_tire;

		public WheelData(JsonObject obj){
			this.radius = JsonUtil.getIfExists(obj, "Radius", 16f).floatValue();
			this.width = JsonUtil.getIfExists(obj, "Width", 4f).floatValue();
			this.connector = JsonUtil.getIfExists(obj, "Connector", 0f).floatValue();
			this.removable = JsonUtil.getIfExists(obj, "Removable", true);
			this.has_tire = JsonUtil.getIfExists(obj, "Tireless", true);
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

}
