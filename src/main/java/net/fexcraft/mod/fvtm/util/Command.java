package net.fexcraft.mod.fvtm.util;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.api.registry.fCommand;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.rail.RailData;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
            	Print.chat(sender, "&oRail-Regions Reloading."); break;
            }
            case "rrs": case "reload-railsections":{
            	((RailData)sender.getEntityWorld().getCapability(Capabilities.RAILSYSTEM, null)).sendReload("sections", sender);
            	Print.chat(sender, "&oRail-Sections Reloading."); break;
            }
            case "debug":{
            	Print.chat(sender, "&7Debug: " + ((DEBUG = !DEBUG) ? "&cenabled" : "&adisabled") + "&7.");
            	break;
            }
            case "preset":{
            	if(args.length < 2){
            		Print.chat(sender, "&9Preset commands:");
            		Print.chat(sender, "&7- /fvtm preset print");
            		Print.chat(sender, "&7- /fvtm preset copy");
            		Print.chat(sender, "&7- /fvtm preset save <name>");
            		Print.chat(sender, "&7- /fvtm preset override <name>");
            		break;
            	}
            	if(sender instanceof EntityPlayer == false){
            		Print.chat(sender, "Can be only used by online players."); return;
            	}
            	EntityPlayer player = (EntityPlayer)sender;
            	ItemStack stack = player.getHeldItemMainhand();
            	if(stack.isEmpty() || stack.getItem() instanceof VehicleItem == false){
            		Print.chat(sender, "You need to hold a VehicleItem in hand."); return;
            	}
            	VehicleData data = ((VehicleItem)stack.getItem()).getData(stack);
            	if(args[1].equals("print")){
            		Print.chat(sender, data.toJson()); return;
            	}
            	if(args[1].equals("copy")){
            		StringSelection stringSelection = new StringSelection(data.toJson().toString());
            		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            		Print.chat(sender, "&9Copied preset to clipboard."); return;
            	}
            	if(args[1].equals("save") || args[1].equals("override")){
            		if(args.length < 3){
                		Print.chat(sender, "&cMissing name for Preset!"); return;
            		}
            		String str = args[2]; for(int i = 3; i < args.length; i++) str += " " + args[i];
            		File file = new File("./config/fvtm/presets/" + str + ".json");
            		if(file.exists() && !args[1].equals("override")){
            			Print.chat(sender, "&9File already exists, try &7override &9argument to override.");
            		}
            		else{
            			data.setPreset(str); JsonUtil.write(file, data.toJson());
            			PresetTab.INSTANCE.add(data.newItemStack());
            			Print.chat(sender, "&6File saved!");
            		}
            	}
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
