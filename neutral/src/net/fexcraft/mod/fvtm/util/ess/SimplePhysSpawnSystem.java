package net.fexcraft.mod.fvtm.util.ess;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.MessageSender;
import net.fexcraft.mod.uni.world.WorldW;

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
				((FvtmWorld)world).spawnLandEntity(data, pos.add(0, 2, 0), ent);
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
			placer.send("fvtm.spawn.simple.no_engine");
		}
		if(!data.getType().isTrailer() && data.getSeats().size() < 1){
			placer.send("fvtm.spawn.simple.no_seats");
		}
		if(data.getType().getSphData() == null){
			placer.send("fvtm.spawn.simple.no_data");
			failed = true;
		}
		//TODO other checks
		return !failed;
	}

}
