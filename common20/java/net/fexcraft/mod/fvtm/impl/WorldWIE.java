package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fcl.util.ClientPacketPlayer;
import net.fexcraft.mod.fcl.util.EntityUtil;
import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.data.InteractZone;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.packet.PacketListener;
import net.fexcraft.mod.fvtm.packet.Packet_VehMove;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.impl.WorldWI;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.AABB;

import java.util.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WorldWIE extends WorldWI implements FvtmWorld {

	public WorldWIE(Level world){
		super(world);
	}

	@Override
	public SeatInstance getSeat(int entid, int seatid){
		Entity ent = level.getEntity(entid);
		if(ent == null || ent instanceof RootVehicle == false) return null;
		return ((RootVehicle)ent).vehicle.seats.get(seatid);
	}

	@Override
	public SwivelPoint getSwivelPoint(int entid, String pointid){
		Entity ent = level.getEntity(entid);
		if(ent == null || ent instanceof RootVehicle == false) return null;
		return ((RootVehicle)ent).vehicle.data.getRotationPoint(pointid);
	}

	@Override
	public Passenger getPassenger(int source){
		return EntityUtil.get(level.getEntity(source));
	}

	@Override
	public void onVehicleMove(Packet_VehMove packet){
		Entity ent = level.getEntity(packet.entid);
		if(ent instanceof RootVehicle == false) return;
		((RootVehicle)ent).setPosRotMot(packet.pos, packet.yaw, packet.pitch, packet.roll, packet.throttle, packet.steering, packet.fuel);
	}

	@Override
	public VehicleInstance getVehicle(int entid){
		Entity ent = level.getEntity(entid);
		if(ent instanceof RootVehicle == false) return null;
		return ((RootVehicle)ent).vehicle;
	}

	@Override
	public Map.Entry<VehicleData, InteractionHandler.InteractRef> getInteractRef(TagCW packet){
		if(packet.has("entity")){
			VehicleInstance inst = getVehicle(packet.getInteger("entity"));
			return inst == null ? null : new AbstractMap.SimpleEntry<>(inst.data, inst.iref());
		}
		else{
			V3I pos = new V3I(packet.getIntArray("lift"), 0);
			VehicleLiftEntity tile = (VehicleLiftEntity)level.getBlockEntity(new BlockPos(pos.x, pos.y, pos.z));
			return tile == null ? null : new AbstractMap.SimpleEntry<>(tile.getVehicleData(), tile.iref());
		}
	}

	@Override
	public boolean noViewEntity(){
		return ClientPacketPlayer.get() == null;
	}

	public static AABB aabb = new AABB(-20, -20, -20, 20, 20, 20);

	@Override
	public ArrayList<VehicleInstance> getVehicles(V3D pos){
		ArrayList<VehicleInstance> list = new ArrayList<>();
		VehicleInstance inst = null;
		List<Entity> entities = level.getEntities(null, aabb.move(pos.x, pos.y, pos.z));
		for(Entity entity : entities){
			if(entity instanceof RootVehicle){
				inst = ((RootVehicle)entity).vehicle;
				for(InteractZone zone : inst.data.getInteractZones().values()){
					if(list.contains(inst)) break;
					if(zone.inRange(inst, pos)) list.add(inst);
				}
			}
		}
		return list;
	}

	@Override
	public Map<VehicleData, InteractionHandler.InteractRef> getVehicleDatas(V3D pos){
		LinkedHashMap<VehicleData, InteractionHandler.InteractRef> map = new LinkedHashMap<>();
		VehicleInstance inst = null;
		List<Entity> entities = level.getEntities(null, aabb.move(pos.x, pos.y, pos.z));
		VehicleLiftEntity lift;
		for(Entity entity : entities){
			if(entity instanceof RootVehicle){
				inst = ((RootVehicle)entity).vehicle;
				for(InteractZone zone : inst.data.getInteractZones().values()){
					if(map.containsKey(inst.data)) break;
					if(zone.inRange(inst, pos)) map.put(inst.data, new InteractionHandler.InteractRef(inst));
				}
			}
		}
		int xx = (int)pos.x >> 4, zz = (int)pos.z >> 4;
		for(int x = -1; x < 2; x++){
			for(int z = -1; z < 2; z++){
				LevelChunk chunk = level.getChunk(xx + x, zz + z);
				for(BlockEntity tile : chunk.getBlockEntities().values()){
					if(!(tile instanceof VehicleLiftEntity)) continue;
					if((lift = (VehicleLiftEntity)tile).getVehicleData() == null) continue;
					for(InteractZone zone : lift.getVehicleData().getInteractZones().values()){
						if(map.containsKey(lift.getVehicleData())) break;
						if(zone.inRange(lift.getVehicleData(), lift.getVehicleDataPos(), pos))
							map.put(lift.getVehicleData(), lift.iref());
					}
				}
			}
		}
		return map;
	}

	@Override
	public Passenger getClientPassenger(){
		return EntityUtil.get(ClientPacketPlayer.get());
	}

	@Override
	public boolean isFvtmRoad(StateWrapper state){
		return state.getBlock() instanceof Asphalt;
	}

	@Override
	public int getRoadHeight(StateWrapper state){
		if(state.getBlock() instanceof Asphalt){
			return ((Asphalt)state.getBlock()).height;
		}
		return 0;
	}

	@Override
	public StateWrapper getRoadWithHeight(StateWrapper block, int height){
		if(block.getBlock() instanceof Asphalt == false){
			ResourceLocation rl = BuiltInRegistries.BLOCK.getKey((Block)block.getBlock());
			String str = rl.toString();
			str = str.substring(0, str.lastIndexOf("_") + 1);
			return StateWrapper.of(BuiltInRegistries.BLOCK.get(new ResourceLocation(str + height)).defaultBlockState());
		}
		return StateWrapper.of(FvtmGetters.ASPHALT[height].get().defaultBlockState());
	}

	@Override
	public void handleBlockEntityPacket(TagCW com, Passenger player){
		BlockPos pos = BlockPos.of(com.getLong("pos"));
		BlockEntity tile = level.getBlockEntity(pos);
		if(tile instanceof PacketListener){
			((PacketListener)tile).handle(com, player);
		}
		else{
			FvtmLogger.debug("No receiver for packet '" + com + "' found. Dest: " + pos);
		}
	}

}
