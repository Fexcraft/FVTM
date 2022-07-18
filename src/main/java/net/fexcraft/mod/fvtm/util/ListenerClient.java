package net.fexcraft.mod.fvtm.util;

import java.util.UUID;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil.NewTrack;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
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
				TrafficSignData data = signs.getSign(pos);
				if(data != null) data.read(packet.nbt.getCompoundTag("signdata"));
				return;
			}
			case "ts_added":{
				BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
				TrafficSigns signs = player.world.getChunk(pos).getCapability(Capabilities.TRAFFIC_SIGNS, null);
				if(signs != null) signs.addSignAt(pos, packet.nbt.getFloat("rotation"), packet.nbt.getFloat("offset"), true);
				return;
			}
			case "deco_update":{
				Decoration ent = (Decoration)player.world.getEntityByID(packet.nbt.getInteger("entid"));
				if(ent != null) ent.readEntityFromNBT(packet.nbt);
				return;
			}
			case "rail_place_util":{
				UUID uuid = new UUID(packet.nbt.getLong("uuid_m"), packet.nbt.getLong("uuid_l"));
				if(packet.nbt.hasKey("new")){
					RailPlacingUtil.CL_CURRENT = new NewTrack(new Vec316f(packet.nbt.getCompoundTag("vector")), Resources.RAILGAUGES.getValue(new ResourceLocation(packet.nbt.getString("gauge"))));
					RailPlacingUtil.QUEUE.put(uuid, RailPlacingUtil.CL_CURRENT);
				}
				else if(packet.nbt.hasKey("reset")){
					RailPlacingUtil.CL_CURRENT = null;
					RailPlacingUtil.QUEUE.remove(uuid);
				}
				else{
					Vec316f vector = new Vec316f(packet.nbt.getCompoundTag("vector"));
					RailPlacingUtil.CL_CURRENT.add(vector);
				}
			}
			default: return;
		}
	}

}
