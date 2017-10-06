package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.lib.api.common.fCommand;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

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
    	return true;
    }

    @Override 
    public void execute(MinecraftServer server, ICommandSender sender, String[] args)  throws CommandException{
        if(args.length < 1){
        	Print.chat(sender, "&9/fvtms <args>");
        	return;
        }
        else if(args[0].equals("preset")){
        	try{
        		//NBTTagCompound nbt = JsonToNBT.getTagFromJson(args[1]);
        		//sender.getEntityWorld().spawnEntity(new LandVehicleEntity(sender.getEntityWorld(), Resources.getVehicleData(nbt, sender.getEntityWorld().isRemote), sender.getPositionVector().addVector(0, 2, 0)));
        	}
        	catch(Exception e){
        		Print.chat(sender, e.getLocalizedMessage());
        	}
        }
        else if(args[0].equals("print")){
        	//TODO print current vehicle
        }
        else{
        	try{
        		//Vehicle vehicle = Resources.VEHICLES.getValue(new ResourceLocation(args[0]));
        		//sender.getEntityWorld().spawnEntity(new LandVehicleEntity(sender.getEntityWorld(), vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle), sender.getPositionVector().addVector(0, 2, 0)));
        	}
        	catch(Exception e){
        		Print.chat(sender, e.getLocalizedMessage());
        		e.printStackTrace();
        	}
        }
    }
    
}

