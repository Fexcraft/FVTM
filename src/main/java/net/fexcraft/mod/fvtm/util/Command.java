package net.fexcraft.mod.fvtm.util;

import java.util.stream.Collectors;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.blocks.UniversalTileEntity;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.entities.WheelEntity;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

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
                Print.chat(sender, trs("commands.fvtm.main_help_desc"));
                Print.chat(sender, trs("commands.fvtm.main_help_addons"));
                Print.chat(sender, trs("commands.fvtm.main_help_version"));
                Print.chat(sender, trs("commands.fvtm.main_help_key_help"));
                Print.chat(sender, "/fvtm entities");
                break;
            }
            case "addons": {
                if(sender instanceof EntityPlayer == false){
                    Print.chat(sender, trs("commands.fvtm.main_noconsole"));
                }
                else{
                    ((EntityPlayer) sender).openGui(FVTM.getInstance(), GuiHandler.ADDON_MANAGER, sender.getEntityWorld(), 0, 0, 0);
                }
                break;
            }
            case "version": {
                Print.chat(sender, trs("commands.fvtm.main_version") + " " + FVTM.VERSION);
                if(Static.dev()){
                    Print.chat(sender, "TEST:STATE: " + Config.TEST);
                }
                break;
            }
            case "key": {
                if(args.length <= 1){
                    Print.chat(sender, trs("commands.fvtm.main_key_error"));
                    break;
                }
                switch(args[1]){
                    case "help": {
                        Print.chat(sender, trs("commands.fvtm.main_key_help_desc"));
                        Print.chat(sender, trs("commands.fvtm.main_key_help_get"));
                        Print.chat(sender, trs("commands.fvtm.main_key_help_admin"));
                        Print.chat(sender, trs("commands.fvtm.main_key_help_view"));
                        break;
                    }
                    case "get": {
                        if(sender instanceof EntityPlayer == false){
                            Print.chat(sender, trs("commands.fvtm.main_noconsole"));
                            break;
                        }
                        EntityPlayer player = (EntityPlayer) sender;
                        if(args.length == 2 || args[2].equals("one")){
                            Entity ridden = player.getRidingEntity();
                            if(ridden == null || ridden instanceof SeatEntity == false){
                                Print.chat(sender, trs("commands.fvtm.main_key_not_in_veh"));
                                break;
                            }
                            SeatEntity seat = (SeatEntity) ridden;
                            if(!seat.driver){
                                Print.chat(sender, trs("commands.fvtm.main_key_not_in_veh"));
                                break;
                            }
                            Vehicle.VehicleEntity ent = seat.getVehicle();
                            if(ent.getVehicleData().getSpawnedKeysAmount() >= Config.MAX_SPAWNED_VEHICLE_KEYS){
                                Print.chat(sender, trs("commands.fvtm.main_key_max_used"));
                                break;
                            }
                            Material mat = Resources.MATERIALS.getValue(ent.getVehicleData().getVehicle().getDefaultKey());
                            ItemStack stack = mat.getItemStack();
                            stack.getTagCompound().setString("VehicleKeyCreator", player.getGameProfile().getId().toString());
                            stack.getTagCompound().setBoolean("VehicleKeyType", false);
                            stack.getTagCompound().setString("VehicleKeyCode", ent.getVehicleData().getLockCode());
                            if(!player.inventory.addItemStackToInventory(stack)){
                                player.dropItem(stack, false);
                            }
                            ent.getVehicleData().setSpawnedKeysAmount(null);
                        }
                        else if(args[2].equals("all") || args[2].equals("*")){
                            Entity ridden = player.getRidingEntity();
                            if(ridden == null || ridden instanceof SeatEntity == false){
                                Print.chat(sender, trs("commands.fvtm.main_key_not_in_veh"));
                                break;
                            }
                            SeatEntity seat = (SeatEntity) ridden;
                            if(!seat.driver){
                                Print.chat(sender, trs("commands.fvtm.main_key_not_in_veh"));
                                break;
                            }
                            Vehicle.VehicleEntity ent = seat.getVehicle();
                            if(ent.getVehicleData().getSpawnedKeysAmount() >= Config.MAX_SPAWNED_VEHICLE_KEYS){
                                Print.chat(sender, trs("commands.fvtm.main_key_max_used"));
                                break;
                            }
                            Material mat = Resources.MATERIALS.getValue(ent.getVehicleData().getVehicle().getDefaultKey());
                            ItemStack stack = mat.getItemStack();
                            stack.getTagCompound().setString("VehicleKeyCreator", player.getGameProfile().getId().toString());
                            stack.getTagCompound().setBoolean("VehicleKeyType", false);
                            stack.getTagCompound().setString("VehicleKeyCode", ent.getVehicleData().getLockCode());
                            for(int i = ent.getVehicleData().getSpawnedKeysAmount(); i < Config.MAX_SPAWNED_VEHICLE_KEYS; i++){
                                if(!player.inventory.addItemStackToInventory(stack)){
                                    player.dropItem(stack, false);
                                }
                                ent.getVehicleData().setSpawnedKeysAmount(null);
                            }
                        }
                        else{
                            Print.chat(sender, trs("commands.fvtm.main_key_error"));
                        }
                        break;
                    }
                    case "admin": {
                        if(sender instanceof EntityPlayer == false){
                            Print.chat(sender, trs("commands.fvtm.main_noconsole"));
                            break;
                        }
                        EntityPlayer player = (EntityPlayer) sender;
                        if(Static.isOp(player.getGameProfile().getName()) || server.isSinglePlayer()){
                            Material mat = null;
                            Entity ridden = player.getRidingEntity();
                            if(ridden == null || ridden instanceof SeatEntity == false){
                                mat = Resources.MATERIALS.getValue(new ResourceLocation("generic:goldkey"));//TODO dangereous.
                            }
                            else{
                                mat = Resources.MATERIALS.getValue(((SeatEntity) ridden).getVehicle().getVehicleData().getVehicle().getDefaultKey());
                            }
                            ItemStack stack = mat.getItemStack();
                            stack.getTagCompound().setString("VehicleKeyCreator", player.getGameProfile().getId().toString());
                            stack.getTagCompound().setBoolean("VehicleKeyType", true);
                            stack.getTagCompound().setString("VehicleKeyCode", "0101010");
                            if(!player.inventory.addItemStackToInventory(stack)){
                                player.dropItem(stack, false);
                            }
                        }
                        else{
                            Print.chat(sender, trs("commands.fvtm.main_key_no_permission"));
                        }
                        break;
                    }
                    case "view": {
                        if(sender instanceof EntityPlayer == false){
                            Print.chat(sender, trs("commands.fvtm.main_noconsole"));
                            break;
                        }
                        EntityPlayer player = (EntityPlayer) sender;
                        Entity ridden = player.getRidingEntity();
                        if(ridden == null || ridden instanceof SeatEntity == false){
                            Print.chat(sender, trs("commands.fvtm.main_key_not_in_veh"));
                            break;
                        }
                        SeatEntity seat = (SeatEntity) ridden;
                        if(!seat.driver){
                            Print.chat(sender, trs("commands.fvtm.main_key_not_in_veh"));
                            break;
                        }
                        Vehicle.VehicleData data = seat.getVehicle().getVehicleData();
                        Print.chat(sender, trs("commands.fvtm.main_key_view_veh") + data.getVehicle().getName());
                        Print.chat(sender, trs("commands.fvtm.main_key_view_spawned") + data.getSpawnedKeysAmount() + "/" + Config.MAX_SPAWNED_VEHICLE_KEYS);
                        Print.chat(sender, trs("commands.fvtm.main_key_view_type") + data.getVehicle().getDefaultKey());
                        Print.chat(sender, trs("commands.fvtm.main_key_view_code") + data.getLockCode());
                        break;
                    }
                    default: {
                        Print.chat(sender, "null [1]");
                        break;
                    }
                }
                break;
            }
            case "entities":{
            	Print.chat(sender, "&8- - - - &9- &6- &9- &8- - - -");
            	Print.chat(sender, "&9Vehicles: &7" + sender.getEntityWorld().loadedEntityList.stream().filter(pre -> pre instanceof VehicleEntity).collect(Collectors.toList()).size());
            	Print.chat(sender, "&9Wheels: &7" + sender.getEntityWorld().loadedEntityList.stream().filter(pre -> pre instanceof WheelEntity).collect(Collectors.toList()).size());
            	Print.chat(sender, "&9Seats: &7" + sender.getEntityWorld().loadedEntityList.stream().filter(pre -> pre instanceof SeatEntity).collect(Collectors.toList()).size());
            	//Print.chat(sender, "&9Container Holders: &7" + sender.getEntityWorld().loadedEntityList.stream().filter(pre -> pre instanceof ContainerEntity).collect(Collectors.toList()).size());
            	Print.chat(sender, "&8- - - - &9- &6- &9- &8- - - -");
            	Print.chat(sender, "&9BlockData (UT): &7" + sender.getEntityWorld().loadedTileEntityList.stream().filter(pre -> pre instanceof UniversalTileEntity && ((UniversalTileEntity)pre).isCore()).count());
            	break;
            }
            case "spam":{
            	if(!server.isSinglePlayer()){
            		Print.chat(sender, "Not usable on server.");
            		return;
            	}
            	ItemStack stack = new ItemStack(Blocks.STONE, 64, args.length > 1 ? Integer.parseInt(args[1]) : 0);
            	Vec3d vec = sender.getPositionVector();
            	for(int i = 0; i < 64; i++){
            		sender.getEntityWorld().spawnEntity(new EntityItem(sender.getEntityWorld(), vec.x, vec.y - 1.5, vec.z, stack.copy()));
            	}
            	Print.chat(sender, "Spawned 64 EntityItems of selected type.");
            	break;
            }
            case "testgui":{
            	if(!server.isSinglePlayer() || !Static.dev()){
            		Print.chat(sender, "Feature not available.");
            		return;
            	}
            	BlockPos vec = sender.getPosition();
            	GuiHandler.EventHandler.QUEUE.put(((EntityPlayer)sender).getGameProfile().getId(), new String[]{ "static_command", "null", "mill"});
            	((EntityPlayer)sender).openGui(FVTM.getInstance(), 200, sender.getEntityWorld(), vec.getX(), vec.getY(), vec.getZ());
            	break;
            }
            default: {
                Print.chat(sender, "null [0]");
                break;
            }
        }
        
    }

}
