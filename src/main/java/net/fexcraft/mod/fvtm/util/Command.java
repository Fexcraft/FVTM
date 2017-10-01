package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class Command extends CommandBase {

	@Override
	public String getName(){
		return "fvtm";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "commands.fvtm.main_usage";
	}
	
	public String trs(String string){
		return I18n.format(string, new Object[0]);
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length < 1){
			Print.chat(sender, I18n.format("commands.fvtm.main_usage", new Object[0]));
			return;
		}
		switch(args[0]){
			case "help":
				Print.chat(sender, trs("commands.fvtm.main_help_desc"));
				Print.chat(sender, trs("commands.fvtm.main_help_addons"));
				Print.chat(sender, trs("commands.fvtm.main_help_version"));
				break;
			case "addons":
				((EntityPlayer)sender).openGui(FVTM.getInstance(), GuiHandler.ADDON_MANAGER, sender.getEntityWorld(), 0, 0, 0);
				break;
			case "version":
				Print.chat(sender, trs("commands.fvtm.main_version") + " " + FVTM.VERSION);
				break;
		}
	}
	
}