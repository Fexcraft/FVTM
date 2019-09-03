package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.api.registry.fCommand;
import net.fexcraft.lib.mc.utils.Print;
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
            case "debug":{
            	Print.chat(sender, "&7Debug: " + ((DEBUG = !DEBUG) ? "&cenabled" : "&adisabled") + "&7.");
            	break;
            }
            default: {
                Print.chat(sender, "null [0]");
                break;
            }
        }
        
    }

}
