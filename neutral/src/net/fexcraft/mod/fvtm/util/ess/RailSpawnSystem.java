package net.fexcraft.mod.fvtm.util.ess;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.MessageSender;
import net.fexcraft.mod.uni.world.WorldW;

public class RailSpawnSystem extends EntitySystem {

	@Override
	public String getId(){
		return "rail";
	}

	@Override
	public String getName(){
		return "FVTM Rail Entities";
	}

	@Override
	public boolean validFor(VehicleType type){
		return type == VehicleType.RAIL;
	}

	@Override
	public void spawn(MessageSender placer, WorldW world, V3D pos, VehicleData data, StackWrapper stack){
		if(data.getType().getVehicleType() != VehicleType.RAIL) return;
		validate(placer, world, pos, stack, data, true);
	}

	@Override
	public boolean canSpawn(MessageSender placer, WorldW world, V3D pos, VehicleData data, StackWrapper stack){
		if(data.getType().getVehicleType() != VehicleType.RAIL) return false;
		return validate(placer, world, pos, stack, data, false);
	}

	private boolean validate(MessageSender placer, WorldW world, V3D pos, StackWrapper stack, VehicleData data, boolean spawn){
		RailSystem syscap = SystemManager.get(Systems.RAIL, world);
        if(syscap == null){
        	placer.send("fvtm.spawn.rail.no_system");
        	return false;
        }
        QV3D vector = new QV3D(pos.x, pos.y, pos.z);
		Junction junk = syscap.getJunction(vector.pos, true);
		if(!data.getWheelPositions().containsKey("bogie_front")){
			placer.send("fvtm.spawn.rail.no_front_bogie");
			return false;
		}
		if(!data.getWheelPositions().containsKey("bogie_rear")){
			placer.send("fvtm.spawn.rail.no_rear_bogie");
			return false;
		}
		double length = data.getWheelPositions().get("bogie_front").x + -data.getWheelPositions().get("bogie_rear").x;
		if(junk == null){
			placer.bar("fvtm.spawn.rail.no_junction");
			return false;
		}
		else if(junk.tracks.isEmpty()){
			placer.bar("fvtm.spawn.rail.junction_empty");
			return false;
		}
		else{
			if(junk.tracks.get(0).length < length){
    			placer.bar("fvtm.spawn.rail.first_track_short");
    			return false;
			}
			else if(junk.tracks.get(0).gauge.getWidth() != data.getAttributeFloat("gauge", RailGauge.DEFWIDTH)){
    			placer.bar("fvtm.spawn.rail.wrong_gauge_width");
    			placer.send("&eTrack: &7" + junk.tracks.get(0).gauge.getWidth() + " &8!= &eVehicle: &7" + data.getAttributeFloat("gauge", RailGauge.DEFWIDTH));
    			return false;
			}
			if(spawn){
				placer.bar("fvtm.spawn.rail.success");
				syscap.registerEntity(new RailEntity(syscap, new VehicleInstance(null, data), junk.tracks.get(0), placer.getUUID()));
				if(placer != null && placer.asEntity() != null && !placer.asEntity().isCreative()) stack.count(stack.count() - 1);
			}
			return true;
		}
	}

}
