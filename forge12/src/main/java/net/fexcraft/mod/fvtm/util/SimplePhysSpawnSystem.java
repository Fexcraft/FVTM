package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.sys.pro.NLandVehicle;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.MessageSender;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SimplePhysSpawnSystem extends EntitySystem {

	@Override
	public String getId(){
		return "simple";
	}

	@Override
	public String getName(){
		return "Classic / Simple Physics";
	}

	@Override
	public boolean validFor(VehicleType type){
		return type == VehicleType.LAND || type == VehicleType.WATER;
	}

	@Override
	public void spawn(MessageSender placer, WorldW world, V3D pos, VehicleData data, StackWrapper stack){
		EntityW ent = placer.asEntity();
		switch(data.getType().getVehicleType()){
			case WATER:
			case LAND:
				((World)world.local()).spawnEntity(new NLandVehicle(world.local(), data, new Vec3d(pos.x, pos.y + 2, pos.z), ent == null ? null : ent.local(), -1));
				break;
			default: return;
		}
		if(ent != null && !ent.isCreative()) stack.count(stack.count() - 1);
	}

	@Override
	public boolean canSpawn(MessageSender placer, WorldW world, V3D pos, VehicleData data, StackWrapper stack){
		switch(data.getType().getVehicleType()){
			case WATER:
			case LAND: return validToSpawn(placer, stack, data);
			default: return false;
		}
	}
    
    public static boolean validToSpawn(MessageSender placer, StackWrapper stack, VehicleData data){
		boolean failed = false;
		if(!data.getType().isTrailer() && !data.hasPart("engine")){
			placer.send("&9Vehicle does not have an Engine installed!");
		}
		if(!data.getType().isTrailer() && data.getSeats().size() < 1){
			placer.send("&9Vehicle does not have any Seats!");
		}
		if(data.getType().getSphData() == null){
			placer.send("&9Vehicle does not have simple-physics data configured!");
			failed = true;
		}
		//TODO other checks
		return !failed;
	}

}
