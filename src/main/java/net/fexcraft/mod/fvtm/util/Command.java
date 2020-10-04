package net.fexcraft.mod.fvtm.util;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.HashMap;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.api.registry.fCommand;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
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
	public static HashMap<String, String> VALS = new HashMap<>();

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
        		Print.chat(sender, "&9Command arguments");
        		Print.chat(sender, "&7- /fvtm rrr (reload rail region)");
        		Print.chat(sender, "&7- /fvtm rrs (reload rail sections)");
        		Print.chat(sender, "&7- /fvtm debug (toggle debug mode)");
        		Print.chat(sender, "&7- /fvtm preset <args>");
        		Print.chat(sender, "&7- /fvtm attr <args>");
        		Print.chat(sender, "&7- /fvtm vals <args> (debug values)");
        		Print.chat(sender, "&7- /fvtm spawn-sys");
                break;
            }
            case "rrr": case "reload-railregion":{
            	((RailSys)sender.getEntityWorld().getCapability(Capabilities.RAILSYSTEM, null)).sendReload("all", sender);
            	Print.chat(sender, "&oRail-Regions Reloading."); break;
            }
            case "rrs": case "reload-railsections":{
            	((RailSys)sender.getEntityWorld().getCapability(Capabilities.RAILSYSTEM, null)).sendReload("sections", sender);
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
            		Print.chat(sender, "&eUsable with VEHICLE items or RAILGAUGE items with set points!");
            		break;
            	}
            	if(sender instanceof EntityPlayer == false){
            		Print.chat(sender, "Can be only used by online players."); return;
            	}
            	EntityPlayer player = (EntityPlayer)sender;
            	ItemStack stack = player.getHeldItemMainhand();
            	if(stack.getItem() instanceof VehicleItem){
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
                			Print.chat(sender, "&6File saved! &9[" + str + "]");
                		}
                	}
            	}
            	else if(stack.getItem() instanceof RailGaugeItem){
            		Vec316f[] origin = ((JunctionGridItem)stack.getItem()).getVectors(stack), vecs = new Vec316f[origin.length];
            		for(int i = 0; i < vecs.length; i++) vecs[i] = new Vec316f(origin[i].vector.subtract(origin[0].vector));
                	if(args[1].equals("print")){
                		for(Vec316f vec : vecs){
                    		Print.chat(sender, vec.vector.xCoord + ", " + vec.vector.yCoord + ", " + vec.vector.zCoord);
                		} return;
                	}
                	if(args[1].equals("copy")){
                		String str = new String(); Vec316f vec = null;
                		for(int i = 0; i < vecs.length; i++){ vec = vecs[i];
                    		str += "[ " + vec.vector.xCoord + ", " + vec.vector.yCoord + ", " + vec.vector.zCoord + (i == vecs.length - 1 ? "]" : "],\n");
                		}
                		StringSelection stringSelection = new StringSelection(str);
                		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                		Print.chat(sender, "&9Copied rail path preset to clipboard."); return;
                	}
                	if(args[1].equals("save") || args[1].equals("override")){
                		Print.chat(sender, "Feature not available for Rail Presets.");
                	}
            	}
            	else if(stack.isEmpty() || stack.getItem() instanceof VehicleItem == false){
            		Print.chat(sender, "You need to hold a VehicleItem in hand."); return;
            	}
            	break;
            }
            case "vals":{
            	if(!server.isSinglePlayer()) return;
            	if(args.length < 3){
            		Print.chat(sender, VALS.get(args[1]));
            		return;
            	}
            	VALS.put(args[1], args[2]);
            	return;
            }
            case "attr":{
            	if(args.length < 2){
            		Print.chat(sender, "&9Attribute commands:");
            		Print.chat(sender, "&7- /fvtm attr reset <id>");
            		Print.chat(sender, "&7- &m/fvtm attr set <id> <value>");
            		Print.chat(sender, "&7- /fvtm attr see <id>");
            		Print.chat(sender, "&eUsable with VEHICLE items.");
            		break;
            	}
            	if(sender instanceof EntityPlayer == false){
            		Print.chat(sender, "Can be only used by online players."); return;
            	}
            	EntityPlayer player = (EntityPlayer)sender;
            	ItemStack stack = player.getHeldItemMainhand();
            	if(stack.getItem() instanceof VehicleItem){
                	VehicleData data = ((VehicleItem)stack.getItem()).getData(stack);
                	if(args.length < 3){
                		Print.chat(sender, "No Attribute ID specified.");
                		return;
                	}
                	Attribute<?> attr = data.getAttribute(args[2]);
                	if(attr == null){
                		Print.chat(sender, "Attribute not found in vehicle.");
                		return;
                	}
                	if(args[1].equals("see")){
                		Print.chat(sender, attr.getStringValue());
                		return;
                	}
                	else if(args[1].equals("set")){
                		Print.chat(sender, "Not available yet.");
                		return;
                	}
                	if(args[1].equals("reset")){
                		if(!data.getType().getBaseAttributes().containsKey(args[2])){
                    		Print.chat(sender, "Only default/base attributes can be reset.");
                		}
                		else{
                			Attribute<?> base = data.getType().getBaseAttributes().get(args[2]);
                			attr.setInitValue(base.getInitValue());
                			attr.setValue(base.getValue());
                			data.write(stack.getTagCompound());
                    		Print.chat(sender, "Attribute reset.");
                		}
                		return;
                	}
            	}
            	else if(stack.isEmpty() || stack.getItem() instanceof VehicleItem == false){
            		Print.chat(sender, "You need to hold a VehicleItem in hand."); return;
            	}
            	break;
            }
            case "spawn-sys":{
            	((EntityPlayer)sender).openGui(FVTM.getInstance(), GuiHandler.SPAWNSYS, sender.getEntityWorld(), 0, 0, 0);
            	break;
            }
            default: {
                Print.chat(sender, "null [0]");
                break;
            }
        }
        //
    }

	public static String getValS(String string){
		return VALS.get(string);
	}

	public static String getValS(String string, String def){
		if(!VALS.containsKey(string)) return def;
		return VALS.get(string);
	}

	public static float getValF(String string, float def){
		if(!VALS.containsKey(string)) return def;
		return Float.parseFloat(VALS.get(string));
	}

	public static int getValI(String string, int def){
		if(!VALS.containsKey(string)) return def;
		return Integer.parseInt(VALS.get(string));
	}

	public static boolean getValB(String string, boolean def){
		if(!VALS.containsKey(string)) return def;
		return Boolean.parseBoolean(VALS.get(string));
	}

}
