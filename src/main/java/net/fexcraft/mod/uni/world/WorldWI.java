package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.InteractData;
import net.fexcraft.mod.fvtm.data.InteractType;
import net.fexcraft.mod.fvtm.data.block.BlockEntity;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.entity.BlockSeat;
import net.fexcraft.mod.fvtm.packet.PacketListener;
import net.fexcraft.mod.fvtm.packet.Packet_VehMove;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WorldWI extends FvtmWorld {

	private World world;

	public WorldWI(World level){
		world = level;
	}

	@Override
	public boolean isClient(){
		return world.isRemote;
	}

	@Override
	public boolean isTilePresent(V3I pos){
		return world.getTileEntity(new BlockPos(pos.x, pos.y, pos.z)) != null;
	}

	@Override
	public BlockEntity getBlockEntity(V3I pos){
		return (BlockEntity)world.getTileEntity(new BlockPos(pos.x, pos.y, pos.z));
	}

	@Override
	public <W> W local(){
		return (W)world;
	}

	@Override
	public Object direct(){
		return world;
	}

	@Override
	public void setBlockState(V3I pos, StateWrapper state, int flag) {
		world.setBlockState(new BlockPos(pos.x, pos.y, pos.z), state.local(), flag);
	}

	@Override
	public void spawnBlockSeat(V3D vec, EntityW player){
		BlockSeat seat = new BlockSeat(world);
		seat.setPosition(vec.x, vec.y, vec.z);
		world.spawnEntity(seat);
		((Entity)player.direct()).startRiding(seat);
	}

	@Override
	public int dim(){
		return world.provider.getDimension();
	}

	@Override
	public void drop(StackWrapper stack, V3D vec){
		EntityItem item = new EntityItem(world);
		item.setPosition(vec.x, vec.y, vec.z);
		item.setItem(stack.local());
		world.spawnEntity(item);
	}

	@Override
	public StateWrapper getStateAt(V3I pos){
		return StateWrapper.of(world.getBlockState(new BlockPos(pos.x, pos.y, pos.z)));
	}

	@Override
	public SeatInstance getSeat(int entid, int seatid){
		Entity ent = world.getEntityByID(entid);
		if(ent == null) return null;
		return ((RootVehicle)ent).vehicle.seats.get(seatid);
	}

	@Override
	public SwivelPoint getSwivelPoint(int entid, String pointid){
		Entity ent = world.getEntityByID(entid);
		if(ent == null) return null;
		return ((RootVehicle)ent).vehicle.data.getRotationPoint(pointid);
	}

	@Override
	public Passenger getPassenger(int id){
		Entity ent = world.getEntityByID(id);
		if(ent == null) return null;
		return ent.getCapability(Capabilities.PASSENGER, null).asWrapper();
	}

	@Override
	public void onVehicleMove(Packet_VehMove packet){
		Entity ent = world.getEntityByID(packet.entid);
		if(ent == null) return;
		((RootVehicle)ent).setPosRotMot(
			packet.pos, packet.yaw, packet.pitch, packet.roll, packet.throttle, packet.steering, packet.fuel);
	}

	@Override
	public VehicleInstance getVehicle(int entid){
		Entity ent = world.getEntityByID(entid);
		if(ent instanceof RootVehicle == false) return null;
		return ((RootVehicle)ent).vehicle;
	}

	@Override
	public boolean noViewEntity(){
		return Minecraft.getMinecraft().getRenderViewEntity() == null || Minecraft.getMinecraft().getRenderViewEntity().world == null;
	}

	@Override
	public ArrayList<VehicleInstance> getVehicles(V3D pos){
		ArrayList<VehicleInstance> list = new ArrayList<>();
		float cr;
		for(Entity entity : world.loadedEntityList){
			if(entity instanceof RootVehicle){
				cr = ((RootVehicle)entity).vehicle.data.getAttribute("collision_range").asFloat() + 1;
				if(cr < ((RootVehicle)entity).vehicle.entity.getPos().dis(pos)) continue;
				list.add(((RootVehicle)entity).vehicle);
			}
		}
		return list;
	}

		@Override
	public ArrayList<InteractData> getInteractables(InteractType type, V3D pos){
		ArrayList<InteractData> list = new ArrayList<>();
		VehicleInstance inst;
		float cr;
		switch(type){
			case GENERIC:{
				for(Entity entity : world.loadedEntityList){
					if(!(entity instanceof RootVehicle)) continue;
					inst = ((RootVehicle)entity).vehicle;
					cr = inst.data.getAttribute("collision_range").asFloat() + 1;
					if(cr < inst.entity.getPos().dis(pos)) continue;
					list.add(new InteractData(inst, null, null));
				}
				break;
			}
			case IMPACT:{
				for(TileEntity tile : world.loadedTileEntityList){
					if(!(tile instanceof VehicleLiftEntity)) continue;
				}
			}
		}
		return list;
	}

	@Override
	public Passenger getClientPassenger(){
		return net.minecraft.client.Minecraft.getMinecraft().player.getCapability(Capabilities.PASSENGER, null).asWrapper();
	}

	@Override
	public boolean isFvtmRoad(StateWrapper state){
		return state.getBlock() == Asphalt.INSTANCE || state.getBlock() instanceof G_ROAD;
	}

	@Override
	public int getRoadHeight(StateWrapper state){
		return isFvtmRoad(state) ? ((IBlockState)state.direct()).getValue(Asphalt.HEIGHT) : ((IBlockState)state.direct()).getBlock().getMetaFromState(state.local());
	}

	@Override
	public StateWrapper getRoadWithHeight(StateWrapper block, int height){
		return StateWrapper.of(((IBlockState)block.direct()).getBlock().getStateFromMeta(height));
	}

	@Override
	public void handleBlockEntityPacket(TagCW com, Passenger player){
		BlockPos pos = BlockPos.fromLong(com.getLong("pos"));
		TileEntity tile = world.getTileEntity(pos);
		if(tile instanceof PacketListener){
			((PacketListener)tile).handle(com, player);
		}
		else{
			FvtmLogger.debug("No receiver for packet '" + com + "' found. Dest: " + pos);
		}
	}

}
