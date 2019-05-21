package net.fexcraft.mod.fvtm.data;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.minecraft.command.ICommandSender;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class PartInstallationHandler {
	
	public abstract boolean allowInstall(@Nullable ICommandSender sender, PartData part, String as_category, VehicleData into);
	
	public abstract boolean processInstall(@Nullable ICommandSender sender, PartData part, String category_in, VehicleData into);
	
	public abstract boolean allowUninstall(@Nullable ICommandSender sender, PartData part, String is_category, VehicleData from);
	
	public abstract boolean processUninstall(@Nullable ICommandSender sender, PartData part, String in_category, VehicleData from);
	
	/** Override, in case this PIH expects additional data in the part json. */
	public void parse(@Nullable JsonObject obj){}

	public abstract boolean allowsCustomCategory(PartData part);

}
