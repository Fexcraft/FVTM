package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.api.registry.fCommand;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.sys.rail.RailData;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

@fCommand
public class Command extends CommandBase {
	
	public static boolean DEBUG;

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
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException{
        if(args.length < 1){
            Print.chat(sender, I18n.format("commands.fvtm.main_usage", new Object[0]));
            return;
        }
        switch(args[0]){
            case "help": {
            	//TODO
                break;
            }
            case "rrr": case "reload-railregion":{
            	((RailData)sender.getEntityWorld().getCapability(Capabilities.RAILSYSTEM, null)).sendReload("all", sender);
            	break;
            }
            case "rrs": case "reload-railsections":{
            	((RailData)sender.getEntityWorld().getCapability(Capabilities.RAILSYSTEM, null)).sendReload("sections", sender);
            	break;
            }
            case "debug":{
            	Print.chat(sender, "&7Debug: " + ((DEBUG = !DEBUG) ? "&cenabled" : "&adisabled") + "&7.");
            	break;
            }
            default: {
                Print.chat(sender, "null [0]");
                break;
            }
        }
        //
    }

}
