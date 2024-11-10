package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.utils.Print;
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
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

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
	public void spawnEntity(ICommandSender placer, Vec3d pos, ItemStack stack, VehicleData data){
		if(data.getType().getVehicleType() != VehicleType.RAIL) return;
		validate(placer, pos, stack, data, true);
	}

	@Override
	public boolean canSpawn(ICommandSender placer, Vec3d pos, ItemStack stack, VehicleData data){
		if(data.getType().getVehicleType() != VehicleType.RAIL) return false;
		return validate(placer, pos, stack, data, false);
	}

	private boolean validate(ICommandSender placer, Vec3d pos, ItemStack stack, VehicleData data, boolean spawn){
		World world = placer.getEntityWorld();
		EntityPlayer player = (EntityPlayer)placer;
		RailSystem syscap = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(world));
        if(syscap == null){
        	Print.chat(placer, "&cWorld Capability not found.");
        	return false;
        }
        QV3D vector = new QV3D(pos.x, pos.y, pos.z);
		Junction junk = syscap.getJunction(vector.pos, true);
		BlockPos bpos = new BlockPos(pos);
		//net.fexcraft.mod.fvtm.block.RailEntity tile = world.getBlockState(bpos).getBlock() instanceof RailBlock ? (net.fexcraft.mod.fvtm.block.RailEntity)world.getTileEntity(bpos) : null;
		if(!data.getWheelPositions().containsKey("bogie_front")){
			Print.chat(player, "Vehicle is missing a front bogie.");
			return false;
		}
		if(!data.getWheelPositions().containsKey("bogie_rear")){
			Print.chat(player, "Vehicle is missing a rear bogie.");
			return false;
		}
		double length = data.getWheelPositions().get("bogie_front").x + -data.getWheelPositions().get("bogie_rear").x;
		/*if((junk == null || junk.tracks.isEmpty()) && tile != null){
			if(tile.getTracks().size() > 1){
    			Print.bar(player, "&c&oPlaceable only on single-track rail blocks.");
    			return false;
			}
			else{
				Track track = syscap.getTrack(tile.getTracks().keySet().toArray(new PathKey[0])[0]);
    			if(track.length < length){
        			Print.bar(player, "&c&oTrack too short to spawn this vehicle.");
        			return false;
    			}
    			else if(track.gauge.width() != data.getAttributeInteger("gauge", 30)){
        			Print.bar(player, "&c&oWrong rail gauge width for this vehicle.");
        			Print.chat(player, "&eTrack: &7" + track.gauge.width() + " &8!= &eVehicle: &7" + data.getAttributeInteger("gauge", 30));
        			return false;
    			}
    			else{
    				if(spawn){
            			Print.bar(player, "&b&oSpawning vehicle...");
        				syscap.registerEntity(new RailEntity(syscap, data, track, player.getGameProfile().getId()));
    				}
    				return true;
    			}
			}
		}*/
		if(junk == null){
			Print.bar(player, "&c&oNo Junction found at this position.");
			return false;
		}
		else if(junk.tracks.isEmpty()){
			Print.bar(player, "&c&oJunction has no tracks attached.");
			return false;
		}
		else{
			if(junk.tracks.get(0).length < length){
    			Print.bar(player, "&c&oFirst Track of Junction too short to spawn this vehicle.");
    			return false;
			}
			else if(junk.tracks.get(0).gauge.getWidth() != data.getAttributeFloat("gauge", RailGauge.DEFWIDTH)){
    			Print.bar(player, "&c&oWrong rail gauge width for this vehicle.");
    			Print.chat(player, "&eTrack: &7" + junk.tracks.get(0).gauge.getWidth() + " &8!= &eVehicle: &7" + data.getAttributeFloat("gauge", RailGauge.DEFWIDTH));
    			return false;
			}
			if(spawn){
				Print.bar(player, "&a&oSpawning vehicle...");
				syscap.registerEntity(new RailEntity(syscap, new VehicleInstance(null, data), junk.tracks.get(0), player.getGameProfile().getId()));
			}
			return true;
		}
	}

}
