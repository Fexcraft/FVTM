package net.fexcraft.mod.fvtm.util;

import java.util.UUID;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil.NewTrack;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil.NewRoad;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.uni.tag.TagCW;
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
				//
				return;
			}
			case "lock_state":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null || ent instanceof RootVehicle == false) return;
				((RootVehicle)ent).vehicle.data.getLock().setLocked(packet.nbt.getBoolean("state"));
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
				switch(packet.nbt.getString("subtask")){
					case "new":{
						RailPlacingUtil.CL_CURRENT = new NewTrack(uuid, new GridV3D(packet.nbt.getCompoundTag("vector")), Resources.RAILGAUGES.get(packet.nbt.getString("gauge")));
						RailPlacingUtil.QUEUE.put(uuid, RailPlacingUtil.CL_CURRENT);
						break;
					}
					case "reset":{
						if(RailPlacingUtil.CL_CURRENT.id.equals(uuid)) RailPlacingUtil.CL_CURRENT = null;
						RailPlacingUtil.QUEUE.remove(uuid);
						break;
					}
					case "add":{
						NewTrack track = RailPlacingUtil.QUEUE.get(uuid);
						if(track == null) return;
						track.add(new GridV3D(packet.nbt.getCompoundTag("vector")));
						break;
					}
					case "remove":{
						NewTrack track = RailPlacingUtil.QUEUE.get(uuid);
						if(track == null) return;
						track.remove(player, new GridV3D(packet.nbt.getCompoundTag("vector")));
						break;
					}
					case "selected":{
						NewTrack track = RailPlacingUtil.QUEUE.get(uuid);
						if(track == null) return;
						track.selected = packet.nbt.getInteger("selected");
					}
				}
				return;
			}
			case "road_place_util":{
				UUID uuid = new UUID(packet.nbt.getLong("uuid_m"), packet.nbt.getLong("uuid_l"));
				switch(packet.nbt.getString("subtask")){
					case "new":{
						RoadPlacingUtil.CL_CURRENT = new NewRoad(uuid, new GridV3D(packet.nbt.getCompoundTag("vector")), packet.nbt.getInteger("width"));
						RoadPlacingUtil.QUEUE.put(uuid, RoadPlacingUtil.CL_CURRENT);
						break;
					}
					case "reset":{
						if(RoadPlacingUtil.CL_CURRENT.id.equals(uuid)) RoadPlacingUtil.CL_CURRENT = null;
						RoadPlacingUtil.QUEUE.remove(uuid);
						break;
					}
					case "add":{
						NewRoad road = RoadPlacingUtil.QUEUE.get(uuid);
						if(road == null) return;
						road.add(new GridV3D(packet.nbt.getCompoundTag("vector")), packet.nbt.getInteger("width"));
						break;
					}
					case "remove":{
						NewRoad road = RoadPlacingUtil.QUEUE.get(uuid);
						if(road == null) return;
						road.remove(player, new GridV3D(packet.nbt.getCompoundTag("vector")));
						break;
					}
					case "selected":{
						NewRoad road = RoadPlacingUtil.QUEUE.get(uuid);
						if(road == null) return;
						road.selected = packet.nbt.getInteger("selected");
					}
				}
				return;
			}
			case "block_func_sync":{
				BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
				BlockTileEntity tile = (BlockTileEntity)player.world.getTileEntity(pos);
				if(tile != null){
					TagCW tag = TagCW.wrap(packet.nbt.getCompoundTag("data"));
					for(BlockFunction func : tile.getBlockData().getFunctions()) func.load(tag);
				}
				return;
			}
			default: return;
		}
	}

}
