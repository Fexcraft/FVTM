package net.fexcraft.mod.fvtm.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.entities.LandVehicleEntity;
import net.fexcraft.mod.lib.api.common.fCommand;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.NBTToJson;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

@fCommand
public class SpawnCmd extends CommandBase {
    
    @Override 
    public String getName(){ 
        return "fvtms"; 
    } 

    @Override         
    public String getUsage(ICommandSender var1){ 
        return "/fvtms <arg>"; 
    }
    
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	if(sender instanceof EntityPlayer){
    		return PermManager.getPlayerPerms((EntityPlayer)sender).hasPermission(FvtmPermissions.SPAWN_CMD);
    	}
    	return false;
    }

    @Override 
    public void execute(MinecraftServer server, ICommandSender sender, String[] args)  throws CommandException{
        if(args.length < 1){
        	Print.chat(sender, FVTM.PREFIX + "&0=============== ==== ==");
        	Print.chat(sender, "&7Vehicle Spawning Command");
        	Print.chat(sender, "&9/fvtms preset &6<json>");
        	Print.chat(sender, "&9/fvtms print &f&o(vehicle item in hand)");
        	Print.chat(sender, "&9/fvtms print clipboard &f&o(vehicle item in hand)");
        	Print.chat(sender, "&9/fvtms registry &6<vehicle-registry-name>");
        	return;
        }
        else if(args[0].equals("preset")){
        	try{
        		NBTTagCompound nbt = JsonToNBT.getTagFromJson(args[1]);
        		Vec3d vec = sender.getPositionVector().addVector(0, 2, 0);
        		sender.getEntityWorld().spawnEntity(new LandVehicleEntity(sender.getEntityWorld(), vec.x, vec.y, vec.z, (EntityPlayer)sender, Resources.getVehicleData(nbt, sender.getEntityWorld().isRemote)));
        	}
        	catch(Exception e){
        		Print.chat(sender, e.getLocalizedMessage());
        	}
        }
        else if(args[0].equals("print")){
        	ItemStack stack = ((EntityPlayer)sender).getHeldItem(EnumHand.MAIN_HAND);
        	if(!stack.isEmpty() && stack.getItem() instanceof VehicleItem){
        		boolean cptc = args.length >= 2 && args[1].equals("clipboard");
        		NBTTagCompound nbt = ((VehicleItem)stack.getItem()).getVehicle(stack).writeToNBT(new NBTTagCompound());
        		JsonObject json = NBTToJson.getJsonFromTag(nbt);
        		if(cptc){
        			StringSelection selection = new StringSelection(json.toString());
        		    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        		    clipboard.setContents(selection, selection);
        		    Print.chat(sender, "Copied to clipboard!");
        		}
        		else{
            		Print.chat(sender, "&7&o" + json.toString());
        		}
        	}
        	else{
        		Print.chat(sender, "No valid Vehicle Item in mainhand.");
        	}
        }
        else if(args[0].equals("registry")){
        	try{
        		Vehicle vehicle = Resources.VEHICLES.getValue(new ResourceLocation(args[0]));
        		Vec3d vec = sender.getPositionVector().addVector(0, 2, 0);
        		sender.getEntityWorld().spawnEntity(new LandVehicleEntity(sender.getEntityWorld(), vec.x, vec.y, vec.z, (EntityPlayer)sender, vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle)));
        	}
        	catch(Exception e){
        		Print.stacktrace(sender, e);
        		e.printStackTrace();
        	}
        }
    }
    
}

