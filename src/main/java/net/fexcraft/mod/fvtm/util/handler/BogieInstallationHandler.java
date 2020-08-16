package net.fexcraft.mod.fvtm.util.handler;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallationHandler;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.function.BogieFunction;
import net.minecraft.command.ICommandSender;

public class BogieInstallationHandler extends PartInstallationHandler {
	
	public static final BogieInstallationHandler INSTANCE = new BogieInstallationHandler();

	@Override
	public boolean allowInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		if(data.getParts().containsKey(cat)){
			Print.chatnn(sender, "There is already another part with that category installed.");
			return false;
		}
		if(!data.getWheelSlots().containsKey(cat)){
			Print.chatnn(sender, "This Vehicle does not have the required BogieSlot configured.");
			return false;
		}
		Print.chatnn(sender, "Installation check passed.");
		return true;
	}
	@Override
	public boolean processInstall(@Nullable ICommandSender sender, PartData part, String cat, VehicleData data){
		data.getParts().put(cat, part);
		part.setInstalledPos(data.getWheelSlots().get(cat).pos());
		BogieFunction func = part.getFunction("fvtm:bogie");
		if(func != null) func.setBogie(cat);
		BogieData idata = part.getType().getInstallationHandlerData();
		Pos partpos = part.getInstalledPos();
		data.getWheelPositions().put(cat, new Pos(partpos.x, -partpos.y - idata.height, -partpos.z).to16Double());
		//Print.debug("New BogiePos: " + data.getWheelPositions().get(cat));
		Print.chatnn(sender, "Part installed into selected category.");
		return true;
	}

	@Override
	public boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from){
		BogieData idata = part.getType().getInstallationHandlerData();
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
		part.getAttributes().clear();
		data.getWheelPositions().remove(cat);
		Print.chatnn(sender, "Part uninstalled and position reset.");
		return true;
	}
	
	/** Bogie Part Install Handler Data */
	public static class BogieData {
		
		private boolean removable;
		/** from 0 (connection/install) point to rail (e.g. wheel base) */
		private float height;
		
		public BogieData(JsonObject obj){ if(obj == null) return;
			removable = JsonUtil.getIfExists(obj, "Removable", true);
			height = JsonUtil.getIfExists(obj, "Height", 8).floatValue();
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

}
