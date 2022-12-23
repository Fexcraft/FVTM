package net.fexcraft.mod.fvtm.util;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.api.registry.fCommand;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
@fCommand
public class Command extends CommandBase {
	
	public static boolean OTHER, TOGGABLE, TOGG_LABEL, HOTSWAP, CONTAINER;
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
        return I18n.translateToLocalFormatted(string, new Object[0]);
    }
    
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException{
        if(args.length < 1){
            Print.chat(sender, I18n.translateToLocalFormatted("commands.fvtm.main_usage", new Object[0]));
            return;
        }
        switch(args[0]){
            case "help": {
        		Print.chat(sender, "&9Command arguments");
        		Print.chat(sender, "&7- /fvtm packs");
        		Print.chat(sender, "&7- /fvtm pack-info <pack_id>");
        		Print.chat(sender, "&7- /fvtm get-key <vehicle/container>");
        		Print.chat(sender, "&7- /fvtm preset <args>");
        		Print.chat(sender, "&7- /fvtm attr <args>");
        		Print.chat(sender, "&7- /fvtm debug <args>");
        		Print.chat(sender, "&7- /fvtm spawn-sys");
        		Print.chat(sender, "&7- /fvtm undo road");
        		Print.chat(sender, "&7- /fvtm vpinfo");
        		Print.chat(sender, "&8- - - - - -");
        		Print.chat(sender, "&7- /fvtm vals <args> (debug values)");
        		Print.chat(sender, "&7- /fvtm rrr (reload rail region)");
        		Print.chat(sender, "&7- /fvtm rrs (reload rail sections)");
                break;
            }
            case "packs":{
            	Print.chat(sender, "");
            	Print.chat(sender, "&0[&2FVTM Packs&0]&6 = = = = = =");
            	for(Addon addon : Resources.ADDONS.getValuesCollection()){
            		Print.chat(sender, "&e" + addon.getRegistryName().getPath() + " &b- &7" + addon.getName());
            	}
            	break;
            }
            case "pack-info":{
            	Addon addon = Resources.getAddon(args[1]);
            	if(addon == null){
            		Print.chat(sender, "not found");
            		return;
            	}
            	Print.chat(sender, "");
            	Print.chat(sender, "&0[&2FVTM Pack Info&0]&6 = = = = = =");
            	Print.chat(sender, "&2ID: &7" + addon.getRegistryName().getPath());
            	Print.chat(sender, "&2Name: &7" + addon.getName());
            	Print.chat(sender, "&2Version: &7" + addon.getVersion());
            	if(addon.getAuthors().size() > 0){
                	Print.chat(sender, "&2Authors:");
                	for(String str : addon.getAuthors()){
                		UUID uuid = parseUUID(str);
                		if(uuid == null) Print.chat(sender, "&7- " + str);
                		else Print.chat(sender, "&7- " + Static.getPlayerNameByUUID(uuid));
                	}
            	}
            	Print.chat(sender, "&2URL: &7" + addon.getURL());
            	Print.chat(sender, "&2License: &7" + addon.getLicense());
            	Print.chat(sender, "&6Type: &7" + addon.getLoc().name().toLowerCase());
            	break;
            }
            case "vpinfo":{
            	((EntityPlayer)sender.getCommandSenderEntity()).openGui(FVTM.getInstance(), GuiHandler.VEHICLE_AND_PART_INFO, sender.getEntityWorld(), 0, 0, 0);
            	break;
            }
            case "get-key": {
            	EntityPlayer player = (EntityPlayer)sender.getCommandSenderEntity();
            	if(args.length < 2){
            		Print.chat(sender, "&cPlease select a key type! &7(vehicle or container)");
            	}
            	else if(args[1].equals("vehicle")){
            		if(player.isRiding() && player.getRidingEntity() instanceof GenericVehicle){
            			GenericVehicle ent = (GenericVehicle)player.getRidingEntity();
            			VehicleData data = ent.getVehicleData();
            			if(data.isLocked()){
                    		Print.chat(sender, "&cPlease unlock the Vehicle first.");
            			}
            			else if(!ent.getSeatOf(player).seatdata.driver){
                    		Print.chat(sender, "&eYou need to be the driver to get a key.");
            			}
            			else if(data.getAttributeInteger("generated_keys", 0) >= data.getType().getMaxKeys()){
                    		Print.chat(sender, "&cMax amount of keys for this vehicle has been given already.");
            			}
            			else{
            				giveKeyItem(player, data.getType().getKeyType(), data.getLockCode());
            				Attribute<Integer> attr = data.getAttributeCasted("generated_keys");
            				attr.value(attr.integer_value() + 1);
            			}
            		}
            		else if(player.getHeldItemMainhand().getItem() instanceof VehicleItem){
            			ItemStack stack = player.getHeldItemMainhand();
            			VehicleItem item = (VehicleItem)stack.getItem();
            			if(item.getData(stack).isLocked()){
                    		Print.chat(sender, "&cPlease unlock the Container first.");
            			}
            			else if(item.getData(stack).getAttributeInteger("generated_keys", 0) >= item.getType().getMaxKeys()){
                    		Print.chat(sender, "&cMax amount of keys for this vehicle has been given already.");
            			}
            			else{
            				giveKeyItem(player, item.getType().getKeyType(), item.getData(stack).getLockCode());
            				Attribute<Integer> attr = item.getData(stack).getAttributeCasted("generated_keys");
            				attr.value(attr.integer_value() + 1);
            			}
            		}
            		else{
                		Print.chat(sender, "&eYou need to sit in a vehicle or hold the item in hand.");
            		}
            	}
            	else if(args[1].equals("container")){
            		if(player.getHeldItemMainhand().getItem() instanceof ContainerItem){
            			ItemStack stack = player.getHeldItemMainhand();
            			ContainerItem item = (ContainerItem)stack.getItem();
            			if(item.getData(stack).isLocked()){
                    		Print.chat(sender, "&cPlease unlock the Container first.");
            			}
            			else{
            				giveKeyItem(player, item.getType().getKeyType(), item.getData(stack).getLockCode());
            			}
            		}
            		else{
                		Print.chat(sender, "&eYou need to hold a Container item in hand.");
            		}
            	}
            	else{
            		Print.chat(sender, "&cKey type not found.");
            	}
            	break;
            }
            case "debug":{
            	if(args.length < 2){
            		Print.chat(sender, "&9Debug commands:");
            		Print.chat(sender, "&7- /fvtm debug all");
            		Print.chat(sender, "&7- /fvtm debug toggable (/tog)");
            		Print.chat(sender, "&7- /fvtm debug toggable-label (/togl)");
            		Print.chat(sender, "&7- /fvtm debug hotswap (/hot)");
            		Print.chat(sender, "&7- /fvtm debug container (/con)");
            		Print.chat(sender, "&7- /fvtm debug other");
            		break;
            	}
            	if(sender instanceof EntityPlayer == false){
            		Print.chat(sender, "Can be only used by online players."); return;
            	}
            	switch(args[1]){
            		case "all":{
            			boolean any = !(OTHER || TOGGABLE || HOTSWAP || CONTAINER);
            			OTHER = TOGGABLE = HOTSWAP = CONTAINER = any;
                    	Print.chat(sender, "&7Debug ALL: " + (any ? "&cenabled" : "&adisabled") + "&7.");
            			return;
            		}
            		case "tog":
            		case "toggable":{
                    	Print.chat(sender, "&7Debug TOGGABLE: " + ((TOGGABLE = !TOGGABLE) ? "&cenabled" : "&adisabled") + "&7.");
            			return;
            		}
            		case "togl":
            		case "toggable-label":{
            			TOGGABLE = TOGG_LABEL = !TOGGABLE;
                    	Print.chat(sender, "&7Debug TOGGABE-LABEL: " + (TOGGABLE ? "&cenabled" : "&adisabled") + "&7.");
            			return;
            		}
            		case "hot":
            		case "hotswap":{
                    	Print.chat(sender, "&7Debug HOT-SWAP: " + ((HOTSWAP = !HOTSWAP) ? "&cenabled" : "&adisabled") + "&7.");
            			return;
            		}
            		case "con":
            		case "container":{
                    	Print.chat(sender, "&7Debug CONTAINER: " + ((CONTAINER = !CONTAINER) ? "&cenabled" : "&adisabled") + "&7.");
            			return;
            		}
            		case "other":{
                    	Print.chat(sender, "&7Debug OTHER: " + ((OTHER = !OTHER) ? "&cenabled" : "&adisabled") + "&7.");
            			return;
            		}
            	}
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
            		Print.chat(sender, "Can be only used by online players.");
            		return;
            	}
            	if(!server.isSinglePlayer()){
            		Print.chat(sender, "Can only be used in single player.");
            		return;
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
            		for(int i = 0; i < vecs.length; i++) vecs[i] = new Vec316f(origin[i].vector.sub(origin[0].vector));
                	if(args[1].equals("print")){
                		for(Vec316f vec : vecs){
                    		Print.chat(sender, vec.vector.x + ", " + vec.vector.y + ", " + vec.vector.z);
                		} return;
                	}
                	if(args[1].equals("copy")){
                		String str = new String(); Vec316f vec = null;
                		for(int i = 0; i < vecs.length; i++){ vec = vecs[i];
                    		str += "[ " + vec.vector.x + ", " + vec.vector.y + ", " + vec.vector.z + (i == vecs.length - 1 ? "]" : "],\n");
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
                		Print.chat(sender, attr.string_value());
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
                			attr.initial(base.initial());
                			attr.value(base.value());
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
            	((EntityPlayer)sender).openGui(FVTM.getInstance(), GuiHandler.SPAWNSYS, sender.getEntityWorld(), 0, 0, 1);
            	break;
            }
            case "rrr": case "reload-railregion":{
            	if(!Static.dev()) return;
            	((RailSystem)SystemManager.get(Systems.RAIL, sender.getEntityWorld())).sendReload("all", sender);
            	Print.chat(sender, "&oRail-Regions Reloading.");
            	break;
            }
            case "rrs": case "reload-railsections":{
            	if(!Static.dev()) return;
            	((RailSystem)SystemManager.get(Systems.RAIL, sender.getEntityWorld())).sendReload("sections", sender);
            	Print.chat(sender, "&oRail-Sections Reloading.");
            	break;
            }
            case "vals":{
            	if(!Static.dev() || !server.isSinglePlayer()) return;
            	if(args.length < 3){
            		Print.chat(sender, VALS.get(args[1]));
            		return;
            	}
            	VALS.put(args[1], args[2]);
            	return;
            }
            case "undo":{
            	EntityPlayer player = (EntityPlayer)sender;
            	if(args.length > 1 || args[1].equals("road") || player.getHeldItemMainhand().getItem() instanceof RoadToolItem){
            		JsonMap map = RoadPlacingCache.getLastEntry(player);
            		if(map == null || map.empty()){
                		Print.chatbar(sender, "No last road data in item.");
            			return;
            		}
            		if(map.getInteger("dimension", player.dimension) != player.dimension){
                		Print.chatbar(sender, "Last road was placed in &6DIM" + map.getInteger("dimension", -99999));
                		Print.chatbar(sender, "You are currenctly in &6DIM" + player.world.provider.getDimension());
            			return;
            		}
            		map.rem("dimension");
            		Print.chatbar(sender, "&oUndo-ing last placed road...");
            		for(String str : map.value.keySet()){
            			JsonArray array = map.getArray(str);
            			BlockPos pos = BlockPos.fromLong(Long.parseLong(str));
            			Block block = Block.REGISTRY.getObject(new ResourceLocation(array.get(0).string_value()));
            			IBlockState state = block.getStateFromMeta(array.get(1).integer_value());
            			player.world.setBlockState(pos, state);
            		}
            		RoadPlacingCache.remLastEntry(player);
            		Print.chat(sender, "&7Last road undone.");
            	}
            	return;
            }
            default: {
                Print.chat(sender, "null [0]");
                break;
            }
        }
        //
    }

	private UUID parseUUID(String str){
		try{
			return UUID.fromString(str);
		}
		catch(Exception e){
			//e.printStackTrace();
			return null;
		}
	}

	private Item giveKeyItem(EntityPlayer player, ResourceLocation keytype, String lockcode){
		Item ki = Item.REGISTRY.getObject(keytype);
		if(ki == null) ki = Item.REGISTRY.getObject(Lockable.DEFAULT_KEY);
		if(ki == null){
			Print.chat(player, "&cKey item and replacement not found.");
			Print.chat(player, "&ePlease make sure you have at least GEP installed.");
		}
		else{
			ItemStack keystack = new ItemStack(ki, 1);
			if(keystack.getTagCompound() == null) keystack.setTagCompound(new NBTTagCompound());
			keystack.getTagCompound().setString("LockCode", lockcode);
			player.addItemStackToInventory(keystack);
			Print.chat(player, "&aKey added to inventory.");
		}
		return null;
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
