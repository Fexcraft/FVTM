package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
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
		EntityPlayer player = (EntityPlayer)placer;
		world.spawnEntity(new net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle(world, data, new Vec3d(pos.x, pos.y + 2, pos.z), player, -1));
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
		for(String str : index){
			if(!data.getWheelPositions().containsKey(str)){
				String trailer = data.getType().isTrailerOrWagon() ? "&9Trailer" : "&9Vehicle";
				Print.chat(player, trailer + " is missing a wheel! &7&o" + str); failed = true;
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
