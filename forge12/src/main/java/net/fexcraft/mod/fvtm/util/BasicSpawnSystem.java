package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.MessageSender;
import net.minecraft.entity.player.EntityPlayer;
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
	public boolean validFor(VehicleType type){
		return type == VehicleType.AIR || type == VehicleType.LAND || type == VehicleType.WATER;
	}

	@Override
	public void spawn(MessageSender placer, V3D pos, VehicleData data, StackWrapper stack){
		EntityW ent = (EntityW)placer;
		World world = ent.getWorld().local();
		EntityPlayer player = ent.local();
		world.spawnEntity(new ULandVehicle(world, data, new V3D(pos.x, pos.y + 2, pos.z), player, -1));
    	if(!player.capabilities.isCreativeMode) stack.count(stack.count() - 1);
	}

	@Override
	public boolean canSpawn(MessageSender placer, V3D pos, VehicleData data, StackWrapper stack){
		switch(data.getType().getVehicleType()){
			case LAND: return validToSpawn(((EntityW)placer).local(), stack, data);
			default: return false;
		}
	}
    
    public static boolean validToSpawn(EntityPlayer player, StackWrapper stack, VehicleData data){
		String[] index = data.getType().isTrailer() ? LandVehicle.TRAILERWHEELINDEX : LandVehicle.WHEELINDEX; boolean failed = false;
		boolean tireinfo = false;
		for(String str : index){
			String trailer = data.getType().isTrailer() ? "&9Trailer" : "&9Vehicle";
			if(!data.getWheelPositions().containsKey(str)){
				Print.chat(player, trailer + " is missing a wheel! &7&o" + str); failed = true;
			}
        	PartData part = data.getPart(str);
        	if(!((WheelData)part.getType().getInstallHandlerData()).hasTire()){
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
		if(!data.getType().isTrailer()){
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
		if(!data.getType().isTrailer() && !data.hasPart("engine")){
			Print.chat(player, "&9Vehicle does not have an Engine installed!"); //failed = true;
		}
		if(!data.getType().isTrailer() && data.getSeats().size() < 1){
			Print.chat(player, "&9Vehicle does not have any Seats!"); failed = true;
		}
		/*for(String part : data.getType().getRequiredParts()){
			if(data.getPart(part) == null){
				Print.chat(player, "&9Vehicle is missing &6required part&9: &a" + part + "&9!"); failed = true;
			}
		}*///TODO replace with new required parts check
		return !failed;
	}

}
