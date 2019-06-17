package net.fexcraft.mod.fvtm.util.handler;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.PartData;
import net.fexcraft.mod.fvtm.data.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.VehicleData;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.util.function.WheelFunction;
import net.minecraft.command.ICommandSender;

public class WheelInstallationHandler extends PartInstallationHandler {
	
	public static final WheelInstallationHandler INSTANCE = new WheelInstallationHandler();

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat)){
			Print.chatnn(sender, "There is already another part with that category installed."); return false;
		}
		WheelData idata = part.getType().getInstallationHandlerData();
		WheelSlot slot = data.getWheelPositions().get(cat);
		if(slot == null){ Print.chatnn(sender, "Error, slot not found."); return false;}
		if(idata.radius > slot.maxradius()){
			Print.chatnn(sender, "Wheel radius too large. [" + idata.radius + ">" + slot.maxradius() + "]"); return false;
		}
		if(idata.radius < slot.minradius()){
			Print.chatnn(sender, "Wheel radius too small. [" + idata.radius + "<" + slot.minradius() + "]"); return false;
		}
		if(idata.connector != slot.connector()){
			Print.chatnn(sender, "Incompatible connector."); return false;
		}
		Print.chatnn(sender, "Installation check passed."); return true;
	}
	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		part.setInstalledPos(data.getWheelPositions().get(cat).pos());
		WheelFunction func = part.getFunction("fvtm:wheel");
		if(func != null) func.setWheel(cat, data.getWheelPositions().get(cat));
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
		Print.chatnn(sender, "Part uninstalled and position reset."); return true;
	}
	
	/** Default Part Install Handler Data */
	public static class WheelData {
		
		private float radius, connector;
		private boolean removable;//, needs_tires;
		
		public WheelData(JsonObject obj){
			this.radius = JsonUtil.getIfExists(obj, "Radius", 16f).floatValue();
			this.connector = JsonUtil.getIfExists(obj, "Connector", 0f).floatValue();
			this.removable = JsonUtil.getIfExists(obj, "Removable", true);
			//this.needs_tires = JsonUtil.getIfExists(obj, "needs_tires", needs_tires);
		}
		
	}

	@Override
	public boolean allowsCustomCategory(PartData part){
		return false;
	}

	@Override
	public String[] getValidCategories(PartData part, VehicleData vehicle){
		return vehicle.getWheelPositions().keySet().toArray(new String[0]);
	}

}
