package net.fexcraft.mod.fvtm.util;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.packet.*;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PacketsImpl extends Packets {

	private static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("fvtm");
	public static final HashMap<Class<? extends PacketBase>, Class<? extends PacketBase>> PACKETS = new LinkedHashMap<>();

	public void init(){
		super.init();
		FvtmLogger.LOGGER.log("Starting Packet Handler initialization.");
		//
		PACKETS.put(Packet_VehKeyPress.class, Packets12.PI_VehKeyPress.class);
		PACKETS.put(Packet_VehKeyPressState.class, Packets12.PI_VehKeyPressState.class);
		PACKETS.put(Packet_SeatUpdate.class, Packets12.PI_SeatUpdate.class);
		PACKETS.put(Packet_SPUpdate.class, Packets12.PI_SPUpdate.class);
		PACKETS.put(Packet_TagListener.class, Packets12.PI_TagListener.class);
		PACKETS.put(Packet_VehMove.class, Packets12.PI_VehMove.class);
		//
		instance.registerMessage(Packets12.HI_SeatUpdate_C.class, Packets12.PI_SeatUpdate.class, 0, Side.CLIENT);
		instance.registerMessage(Packets12.HI_SeatUpdate_S.class, Packets12.PI_SeatUpdate.class, 1, Side.SERVER);
		instance.registerMessage(Packets12.HI_VehKeyPress.class, Packets12.PI_VehKeyPress.class, 2, Side.SERVER);
		instance.registerMessage(Packets12.HI_VehMove_C.class, Packets12.PI_VehMove.class, 3, Side.CLIENT);
		instance.registerMessage(Packets12.HI_VehMove_S.class, Packets12.PI_VehMove.class, 4, Side.SERVER);
		instance.registerMessage(Packets12.HI_SPUpdate_C.class, Packets12.PI_SPUpdate.class, 5, Side.CLIENT);
		instance.registerMessage(Packets12.HI_SPUpdate_S.class, Packets12.PI_SPUpdate.class, 6, Side.SERVER);
		instance.registerMessage(Packets12.HI_VehKeyPressState_C.class, Packets12.PI_VehKeyPressState.class, 7, Side.CLIENT);
		instance.registerMessage(Packets12.HI_VehKeyPressState_S.class, Packets12.PI_VehKeyPressState.class, 8, Side.SERVER);
		instance.registerMessage(Packets12.HI_TagListener_C.class, Packets12.PI_TagListener.class, 9, Side.CLIENT);
		instance.registerMessage(Packets12.HI_TagListener_S.class, Packets12.PI_TagListener.class, 10, Side.SERVER);
		//
		FvtmLogger.LOGGER.log("Done initialising Packet Handler.");
		FvtmLogger.LOGGER.log("Starting Packet Listener registration.");
		if(EnvInfo.CLIENT){
			LIS_CLIENT.put("deco", (tag, player) -> {
				World world = player.getWorld().local();
				Entity ent = world.getEntityByID(tag.getInteger("entid"));
				if(ent != null && ent instanceof DecorationEntity){
					((DecorationEntity)ent).readEntityFromNBT(tag.local());
				}
			});
			LIS_CLIENT.put("block_func_sync", (tag, player) -> {
				World world = player.getWorld().local();
				BlockPos pos = BlockPos.fromLong(tag.getLong("pos"));
				BlockTileEntity tile = (BlockTileEntity)world.getTileEntity(pos);
				if(tile != null){
					TagCW data = tag.getCompound("data");
					for(BlockFunction func : tile.getBlockData().getFunctions()) func.load(data);
				}
			});
		}
		FvtmLogger.LOGGER.log("Completed Packet Listener registration.");
	}

	@Override
	public void writeTag(ByteBuf buffer, TagCW tag){
		ByteBufUtils.writeTag(buffer, tag.local());
	}

	@Override
	public TagCW readTag(ByteBuf buffer){
		return TagCW.wrap(ByteBufUtils.readTag(buffer));
	}

	@Override
	public void send(BlockData blockdata, WorldW world, V3I vec){
		Packets.sendToAllTrackingPos(PKT_TAG, world, vec, "block_func_sync", getBlockFuncData(blockdata, new BlockPos(vec.x, vec.y, vec.z)));
	}

	private TagCW getBlockFuncData(BlockData blockdata, BlockPos pos){
		TagCW com = TagCW.create();
		com.set("pos", pos.toLong());
		TagCW data = TagCW.create();
		for(BlockFunction func : blockdata.getFunctions()) func.save(data);
		com.set("data", data);
		return com;
	}

	@Override
	public void send(WorldW world, V3I vec){
		BlockPos pos = new BlockPos(vec.x, vec.y, vec.z);
		BlockTileEntity tile = (BlockTileEntity)((World)world.direct()).getTileEntity(pos);
		if(tile == null) return;
		send(tile.getBlockData(), world, vec);
	}

	@Override
	public void send(VehicleInstance vehicle, TagCW com){
		com.set("entity", vehicle.entity.getId());
		if(vehicle.entity.isOnClient()){
			send0(Packet_TagListener.class, "vehicle", com);
		}
		else{
			sendInRange0(Packet_TagListener.class, vehicle.entity.getWorld(), vehicle.entity.getPos(), Config.PACKET_RANGE, "vehicle", com);
		}
	}

	@Override
	public void send0(Class<? extends PacketBase> packet, Object... data){
		try{
			instance.sendToServer((IMessage)PACKETS.get(packet).newInstance().fill(data));
		}
		catch(IllegalAccessException | InstantiationException e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sendInRange0(Class<? extends PacketBase> packet, WorldW world, V3D pos, int range, Object... data){
		try{
			instance.sendToAllAround((IMessage)PACKETS.get(packet).newInstance().fill(data), new TargetPoint(world.dim(), pos.x, pos.y, pos.z, range));
		}
		catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}
		catch(InstantiationException e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sendToAllTrackingPos0(Class<? extends PacketBase> packet, WorldW world, V3D pos, Object... data){
		try{
			instance.sendToAllTracking((IMessage)PACKETS.get(packet).newInstance().fill(data), new TargetPoint(world.dim(), pos.x, pos.y, pos.z, Config.PACKET_RANGE));
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sendToAllTrackingEnt0(Class<? extends PacketBase> packet, EntityW ent, Object... data){
		try{
			instance.sendToAllTracking((IMessage)PACKETS.get(packet).newInstance().fill(data), (Entity)ent.direct());
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sendToAll0(Class<? extends PacketBase> packet, Object... data){
		try{
			instance.sendToAll((IMessage)PACKETS.get(packet).newInstance().fill(data));
		}
		catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}
		catch(InstantiationException e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sendTo0(Class<? extends PacketBase> packet, EntityW to, Object... data){
		try{
			instance.sendTo((IMessage)PACKETS.get(packet).newInstance().fill(data), to.local());
		}
		catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}
		catch(InstantiationException e){
			throw new RuntimeException(e);
		}
	}

	public static final void sendToServer(IMessage packet){
		instance.sendToServer(packet);
	}

	public static final void sendToAllAround(IMessage packet, TargetPoint point){
		instance.sendToAllAround(packet, point);
	}

	public static final void sendToAllAround(IMessage packet, Entity ent){
		instance.sendToAllAround(packet, getTargetPoint(ent));
	}

	public static final void sendToAllAround(IMessage packet, Object ent){
		instance.sendToAllAround(packet, getTargetPoint((Entity)ent));
	}

	public static final void sendTo(IMessage packet, EntityPlayerMP player){
		instance.sendTo(packet, player);
	}

	public static NetworkRegistry.TargetPoint getTargetPoint(Entity ent){
		return new NetworkRegistry.TargetPoint(ent.dimension, ent.posX, ent.posY, ent.posZ, Config.PACKET_RANGE);
	}

	public static TargetPoint getTargetPoint(int dim, BlockPos pos){
		return new NetworkRegistry.TargetPoint(dim, pos.getX(), pos.getY(), pos.getZ(), Config.PACKET_RANGE);
	}

	public static TargetPoint getTargetPoint(int dim, V3I pos){
		return new NetworkRegistry.TargetPoint(dim, pos.x, pos.y, pos.z, Config.PACKET_RANGE);
	}

}