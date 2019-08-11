package net.fexcraft.mod.fvtm.util.handler;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.function.WheelFunction;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.math.Vec3d;

public class WheelInstallationHandler extends PartInstallationHandler {
	
	public static final WheelInstallationHandler INSTANCE = new WheelInstallationHandler();

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat)){
			Print.chatnn(sender, "There is already another part with that category installed."); return false;
		}
		WheelData idata = part.getType().getInstallationHandlerData();
		WheelSlot slot = data.getWheelSlots().get(cat);
		if(slot == null){ Print.chatnn(sender, "Error, slot not found."); return false;}
		//Print.debug(idata.radius, slot.maxradius(), slot.minradius());
		if(idata.radius > slot.maxradius()){
			Print.chatnn(sender, "Wheel radius too large. [" + idata.radius + ">" + slot.maxradius() + "]"); return false;
		}
		if(idata.radius < slot.minradius()){
			Print.chatnn(sender, "Wheel radius too small. [" + idata.radius + "<" + slot.minradius() + "]"); return false;
		}
		if(idata.width > slot.maxwidth()){
			Print.chatnn(sender, "Wheel is too wide. [" + idata.width + ">" + slot.maxwidth() + "]"); return false;
		}
		if(idata.width < slot.minwidth()){
			Print.chatnn(sender, "Wheel is too thin. [" + idata.width + "<" + slot.minwidth() + "]"); return false;
		}
		if(idata.connector != slot.connector()){
			Print.chatnn(sender, "Incompatible connector."); return false;
		}
		Print.chatnn(sender, "Installation check passed."); return true;
	}
	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		part.setInstalledPos(data.getWheelSlots().get(cat).pos());
		WheelFunction func = part.getFunction("fvtm:wheel");
		if(func != null) func.setWheel(cat, data.getWheelSlots().get(cat));
		WheelData idata = part.getType().getInstallationHandlerData();
		Vec3d vec = part.getInstalledPos().to16Double();
		data.getWheelPositions().put(cat, vec.addVector(0, -idata.radius * Static.sixteenth, (cat.contains("left") ? -idata.width : idata.width) * Static.sixteenth));
		Print.chatnn(sender, "Part installed into selected category."); return true;
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		WheelData idata = part.getType().getInstallationHandlerData();
		if(idata != null && !idata.removable){
			Print.chatnn(sender, "Part is marked as non removable."); return false;
		} Print.chatnn(sender, "Deinstallation check passed."); return true;
	}

	@Override
	public boolean processUninstall(ICommandSender sender, PartData part, String cat, VehicleData data){
		part.setInstalledPos(new Pos(0, 0, 0)); data.getParts().remove(cat); part.getAttributes().clear();
		data.getWheelPositions().remove(cat);
		Print.chatnn(sender, "Part uninstalled and position reset."); return true;
	}
	
	/** Default Part Install Handler Data */
	public static class WheelData {
		
		private float radius, width, connector;
		private boolean removable;//, needs_tires;
		
		public WheelData(JsonObject obj){
			this.radius = JsonUtil.getIfExists(obj, "Radius", 16f).floatValue();
			this.width = JsonUtil.getIfExists(obj, "Width", 4f).floatValue();
			this.connector = JsonUtil.getIfExists(obj, "Connector", 0f).floatValue();
			this.removable = JsonUtil.getIfExists(obj, "Removable", true);
			//this.needs_tires = JsonUtil.getIfExists(obj, "needs_tires", needs_tires);
		}
		
		public float getRadius(){ return radius; }
		public float getWidth(){ return width; }
		
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
