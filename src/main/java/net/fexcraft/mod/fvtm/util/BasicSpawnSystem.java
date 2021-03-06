package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BasicSpawnSystem extends EntitySystem {

	@Override
	public String getId(){
		return "uni12";
	}

	@Override
	public String getName(){
		return "Basic/U12 Prototype";
	}

	@Override
	public boolean validFor(SpawnMode mode, VehicleType type){
		return type == VehicleType.AIR || type == VehicleType.LAND || type == VehicleType.WATER;
	}

	@Override
	public void spawnEntity(ICommandSender placer, Vec3d pos, ItemStack stack, VehicleData data, SpawnMode mode){
		World world = placer.getEntityWorld();
		EntityPlayer player = (EntityPlayer)placer.getCommandSenderEntity();
		world.spawnEntity(new ULandVehicle(world, data, new Vec3d(pos.x, pos.y + 2, pos.z), player, -1));
    	if(!player.capabilities.isCreativeMode) stack.shrink(1);
	}

	@Override
	public boolean canSpawn(ICommandSender placer, Vec3d pos, ItemStack stack, VehicleData data, SpawnMode mode){
		switch(data.getType().getVehicleType()){
			case LAND: return validToSpawn((EntityPlayer)placer, stack, data); 
			default: return false;
		}
	}
    
    public static boolean validToSpawn(EntityPlayer player, ItemStack stack, VehicleData data){
		String[] index = data.getType().isTrailerOrWagon() ? LandVehicle.TRAILERWHEELINDEX : LandVehicle.WHEELINDEX; boolean failed = false;
		boolean tireinfo = false;
		for(String str : index){
			String trailer = data.getType().isTrailerOrWagon() ? "&9Trailer" : "&9Vehicle";
			if(!data.getWheelPositions().containsKey(str)){
				Print.chat(player, trailer + " is missing a wheel! &7&o" + str); failed = true;
			}
        	PartData part = data.getPart(str);
        	if(!((WheelData)part.getType().getInstallationHandlerData()).hasTire()){
        		part = data.getPart(str + ":tire");
        	}
        	if(!part.hasFunction("fvtm:tire")){
				Print.chat(player, trailer + " is missing a &avalid &9tire! &7&o" + str);
				tireinfo = failed = true;
        	}
		}
		if(tireinfo){
			Print.chat(player, "&bU12/Basic vehicles need tire/wheel parts with a TireFunction attached!");
		}
		if(!data.getType().isTrailerOrWagon()){
			if(!data.hasPart("engine")){
				Print.chat(player, "&9Vehicle does not have an Engine installed!"); //failed = true;
			}
			else{
				EngineFunction func = data.getFunctionInPart("engine", "fvtm:engine");
				if(func == null){
					Print.chat(player, "&cInstalled engine has no function!"); //failed = true;
				}
				else if(func.getTorqueChart() == null){
					Print.chat(player, "&cInstalled engine is not valid for the Basic System.");
					Print.chat(player, "&7&oInstall another engine or try the Legacy Entities!");
					failed = true;
				}
			}
			if(!data.hasPart("transmission")){
				Print.chat(player, "&9Vehicle does not have a Transmission installed!"); //failed = true;
			}
			else{
				if(data.getFunctionInPart("transmission", "fvtm:transmission") == null){
					Print.chat(player, "&cInstalled transmission has no function!");
					failed = true;
				}
			}
		}
		if(!data.getType().isTrailerOrWagon() && !data.hasPart("engine")){
			Print.chat(player, "&9Vehicle does not have an Engine installed!"); //failed = true;
		}
		if(!data.getType().isTrailerOrWagon() && data.getSeats().size() < 1){
			Print.chat(player, "&9Vehicle does not have any Seats!"); failed = true;
		}
		for(String part : data.getType().getRequiredParts()){
			if(data.getPart(part) == null){
				Print.chat(player, "&9Vehicle is missing &6required part&9: &a" + part + "&9!"); failed = true;
			}
		}
		return !failed;
	}

}
