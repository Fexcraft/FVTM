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
import net.minecraft.util.math.BlockPos;

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
        	placer.send("&cWorld Capability not found.");
        	return false;
        }
        QV3D vector = new QV3D(pos.x, pos.y, pos.z);
		Junction junk = syscap.getJunction(vector.pos, true);
		BlockPos bpos = new BlockPos(pos.x, pos.y, pos.z);
		//net.fexcraft.mod.fvtm.block.RailEntity tile = world.getBlockState(bpos).getBlock() instanceof RailBlock ? (net.fexcraft.mod.fvtm.block.RailEntity)world.getTileEntity(bpos) : null;
		if(!data.getWheelPositions().containsKey("bogie_front")){
			placer.send("Vehicle is missing a front bogie.");
			return false;
		}
		if(!data.getWheelPositions().containsKey("bogie_rear")){
			placer.send("Vehicle is missing a rear bogie.");
			return false;
		}
		double length = data.getWheelPositions().get("bogie_front").x + -data.getWheelPositions().get("bogie_rear").x;
		/*if((junk == null || junk.tracks.isEmpty()) && tile != null){
			if(tile.getTracks().size() > 1){
    			placer.bar("&c&oPlaceable only on single-track rail blocks.");
    			return false;
			}
			else{
				Track track = syscap.getTrack(tile.getTracks().keySet().toArray(new PathKey[0])[0]);
    			if(track.length < length){
        			placer.bar("&c&oTrack too short to spawn this vehicle.");
        			return false;
    			}
    			else if(track.gauge.width() != data.getAttributeInteger("gauge", 30)){
        			placer.bar("&c&oWrong rail gauge width for this vehicle.");
        			placer.send("&eTrack: &7" + track.gauge.width() + " &8!= &eVehicle: &7" + data.getAttributeInteger("gauge", 30));
        			return false;
    			}
    			else{
    				if(spawn){
            			placer.bar("&b&oSpawning vehicle...");
        				syscap.registerEntity(new RailEntity(syscap, data, track, player.getGameProfile().getId()));
    				}
    				return true;
    			}
			}
		}*/
		if(junk == null){
			placer.bar("&c&oNo Junction found at this position.");
			return false;
		}
		else if(junk.tracks.isEmpty()){
			placer.bar("&c&oJunction has no tracks attached.");
			return false;
		}
		else{
			if(junk.tracks.get(0).length < length){
    			placer.bar("&c&oFirst Track of Junction too short to spawn this vehicle.");
    			return false;
			}
			else if(junk.tracks.get(0).gauge.getWidth() != data.getAttributeFloat("gauge", RailGauge.DEFWIDTH)){
    			placer.bar("&c&oWrong rail gauge width for this vehicle.");
    			placer.send("&eTrack: &7" + junk.tracks.get(0).gauge.getWidth() + " &8!= &eVehicle: &7" + data.getAttributeFloat("gauge", RailGauge.DEFWIDTH));
    			return false;
			}
			if(spawn){
				placer.bar("&a&oSpawning vehicle...");
				syscap.registerEntity(new RailEntity(syscap, new VehicleInstance(null, data), junk.tracks.get(0), placer.getUUID()));
			}
			return true;
		}
	}

}
