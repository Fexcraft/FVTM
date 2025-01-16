package net.fexcraft.mod.fvtm.util;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.packet.*;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.tag.TagCW;
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
	public static final String UTIL_LISTENER = "fvtm:utils";
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
		LIS_SERVER.put("mount_seat", (com, player) -> {
			World world = player.getWorld().local();
			RootVehicle vehicle = (RootVehicle)world.getEntityByID(com.getInteger("entity"));
			int index = com.getInteger("seat");
			if(index < 0 || index > vehicle.vehicle.seats.size()) return;
			vehicle.processSeatInteract(index, player.local(), EnumHand.MAIN_HAND);
		});
		if(EnvInfo.CLIENT){
			LIS_CLIENT.put("deco", (tag, player) -> {
				World world = player.getWorld().local();
				Entity ent = world.getEntityByID(tag.getInteger("entid"));
				if(ent != null && ent instanceof DecorationEntity){
					((DecorationEntity)ent).readEntityFromNBT(tag.local());
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
	public void send(BlockData blockdata, V3I vec, int dim){
		BlockPos pos = new BlockPos(vec.x, vec.y, vec.z);
		TagCW com = getBlockFuncData(blockdata, pos);
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(com.local()), getTargetPoint(dim, pos));
	}

	private TagCW getBlockFuncData(BlockData blockdata, BlockPos pos){
		TagCW com = TagCW.create();
		com.set("target_listener", UTIL_LISTENER);
		com.set("task", "block_func_sync");
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
		TagCW com = getBlockFuncData(tile.getBlockData(), pos);
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(com.local()), getTargetPoint(tile.getDim(), pos));
	}

	@Override
	public void send(VehicleInstance vehicle, TagCW com){
		com.set("entity", vehicle.entity.getId());
		if(vehicle.entity.isOnClient()){
			send0(Packet_TagListener.class, "vehicle", com);
		}
		else{
			sendInRange0(Packet_TagListener.class, vehicle.entity.getWorld(), vehicle.entity.getPos(), RANGE, "vehicle", com);
		}
	}

	@Override
	public void send0(Class<? extends PacketBase> packet, Object... data){
		try{
			instance.sendToServer((IMessage)PACKETS.get(packet).newInstance().fill(data));
		}
		catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}
		catch(InstantiationException e){
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
	public void sendTo0(Class<? extends PacketBase> packet, Passenger to, Object... data){
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
		return new NetworkRegistry.TargetPoint(ent.dimension, ent.posX, ent.posY, ent.posZ, RANGE);
	}

	public static TargetPoint getTargetPoint(int dim, BlockPos pos){
		return new NetworkRegistry.TargetPoint(dim, pos.getX(), pos.getY(), pos.getZ(), RANGE);
	}

	public static TargetPoint getTargetPoint(int dim, V3I pos){
		return new NetworkRegistry.TargetPoint(dim, pos.x, pos.y, pos.z, RANGE);
	}

}