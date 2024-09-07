package net.fexcraft.mod.fvtm.gui.construct;

import net.fexcraft.lib.common.math.RGB;
import net.minecraft.command.ICommandSender;

public interface ConstConInterface {
	
	public void setTitleText(String string, RGB color);

	public ICommandSender getCommandSender();

}
