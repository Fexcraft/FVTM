package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.pro.NLandVehicle;
import net.fexcraft.mod.uni.EnvInfo;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LegacySpawnSystem extends EntitySystem {

	@Override
	public String getId(){
		return "legacy";
	}

	@Override
	public String getName(){
		return "Classic/Legacy Entities";
	}

	@Override
	public boolean validFor(SpawnMode mode, VehicleType type){
		return type == VehicleType.AIR || type == VehicleType.LAND || type == VehicleType.WATER;
	}

	@Override
	public void spawnEntity(ICommandSender placer, Vec3d pos, ItemStack stack, VehicleData data, SpawnMode mode){
		World world = placer.getEntityWorld();
		EntityPlayer player = (EntityPlayer)placer;
		switch(data.getType().getVehicleType()){
			case WATER:
			case LAND:
				world.spawnEntity(new NLandVehicle(world, data, new Vec3d(pos.x, pos.y + 2, pos.z), player, -1));
				break;
			default: return;
		}
    	if(!player.capabilities.isCreativeMode) stack.shrink(1);
	}

	@Override
	public boolean canSpawn(ICommandSender placer, Vec3d pos, ItemStack stack, VehicleData data, SpawnMode mode){
		switch(data.getType().getVehicleType()){
			case WATER:
			case LAND: return validToSpawn((EntityPlayer)placer, stack, data); 
			default: return false;
		}
	}
    
    public static boolean validToSpawn(EntityPlayer player, ItemStack stack, VehicleData data){
		String[] index = data.getType().isTrailer() ? LandVehicle.TRAILERWHEELINDEX : LandVehicle.WHEELINDEX;
		boolean failed = false;
		for(String str : index){
			if(!data.getWheelPositions().containsKey(str)){
				String trailer = data.getType().isTrailer() ? "&9Trailer" : "&9Vehicle";
				Print.chat(player, trailer + " is missing a wheel! &7&o" + str);
				//failed = true;
			}
		}
		if(!data.getType().isTrailer() && !data.hasPart("engine")){
			Print.chat(player, "&9Vehicle does not have an Engine installed!"); // failed = true;
		}
		if(!EnvInfo.DEV && !data.getType().isTrailer() && data.getSeats().size() < 1){
			Print.chat(player, "&9Vehicle does not have any Seats!");
			failed = true;
		}
		/*for(String part : data.getType().getRequiredParts()){
			if(data.getPart(part) == null){
				Print.chat(player, "&9Vehicle is missing &6required part&9: &a" + part + "&9!");
				failed = true;
			}
		}*///TODO replace with new required parts check
		if(data.getType().getSphData() == null){
			Print.chat(player, "&9Vehicle does not have simple-physics data configured!");
			failed = true;
		}
		// TODO add later more checks if necessary
		return !failed;
	}

}
