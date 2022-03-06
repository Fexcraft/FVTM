package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class ListenerClient implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return Resources.UTIL_LISTENER;
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayer player = (EntityPlayer)objs[0];
		switch(task){
			case "update_passenger":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null) return;
				/*if(ent == null){
					PassengerCapHandler.CLQUEUE.put(uuid, packet.nbt.getInteger("seat"));
					return;
				}*/
				ent.getCapability(Capabilities.PASSENGER, null).set(packet.nbt.getInteger("vehicle"), packet.nbt.getInteger("seat"));
				return;
			}
			case "config_sync":{
				ULandVehicle.SYNC_RATE = packet.nbt.hasKey("u12_sync_rate") ? packet.nbt.getInteger("u12_sync_rate") : Config.U12_SYNC_RATE;
				return;
			}
			case "lock_state":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null || ent instanceof VehicleEntity) return;
				((VehicleEntity)ent).getVehicleData().setLocked(packet.nbt.getBoolean("state"));
				return;
			}
			case "ts_ck_sync":{
				TrafficSigns signs = player.world.getChunk(packet.nbt.getInteger("x"), packet.nbt.getInteger("z")).getCapability(Capabilities.TRAFFIC_SIGNS, null);
				if(signs != null) signs.read(null, packet.nbt.getCompoundTag("signs"));
				return;
			}
			case "ts_removed":{
				BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
				TrafficSigns signs = player.world.getChunk(pos).getCapability(Capabilities.TRAFFIC_SIGNS, null);
				if(signs != null) signs.remove(pos);
				return;
			}
			case "ts_update":{
				BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
				TrafficSigns signs = player.world.getChunk(pos).getCapability(Capabilities.TRAFFIC_SIGNS, null);
				if(signs == null) return;
				TrafficSignData data = signs.getSign(pos, true);
				data.read(packet.nbt.getCompoundTag("signdata"));
				return;
			}
			default: return;
		}
	}

}
