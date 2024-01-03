package net.fexcraft.mod.fvtm.util.packet;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.UniCon;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packets extends net.fexcraft.mod.fvtm.packet.Packets {
	
	private static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("fvtm");
	public static final String UTIL_LISTENER = "fvtm:utils";

	public void init(){
		FvtmLogger.LOGGER.log("Starting Packet Handler initialization.");
		//
		instance.registerMessage(PKTH_SeatUpdate.Client.class, PKT_SeatUpdate.class, 0, Side.CLIENT);
		instance.registerMessage(PKTH_SeatUpdate.Server.class, PKT_SeatUpdate.class, 1, Side.SERVER);
		instance.registerMessage(PKTH_VehKeyPress.class, PKT_VehKeyPress.class, 2, Side.SERVER);
		instance.registerMessage(PKTH_VehControl.Client.class, PKT_VehControl.class, 3, Side.CLIENT);
		instance.registerMessage(PKTH_VehControl.Server.class, PKT_VehControl.class, 4, Side.SERVER);
		instance.registerMessage(PKTH_SPUpdate.Client.class, PKT_SPUpdate.class, 5, Side.CLIENT);
		instance.registerMessage(PKTH_SPUpdate.Server.class, PKT_SPUpdate.class, 6, Side.SERVER);
		instance.registerMessage(PKTH_VehKeyPressState.Client.class, PKT_VehKeyPressState.class, 7, Side.CLIENT);
		instance.registerMessage(PKTH_VehKeyPressState.Server.class, PKT_VehKeyPressState.class, 8, Side.SERVER);
		//
		instance.registerMessage(PKTH_UT.Client.class, PKT_UT.class, 10, Side.CLIENT);
		instance.registerMessage(PKTH_UT.Server.class, PKT_UT.class, 10, Side.SERVER);
		//
		FvtmLogger.LOGGER.log("Done initialising Packet Handler.");
		FvtmLogger.LOGGER.log("Starting Packet Listener registration.");
		PKTH_UT.LIS_SERVER.put("ui", (com, player) -> {
			((UniCon)player.openContainer).container().packet(new TagCWI(com), false);
		});
		PKTH_UT.LIS_SERVER.put("vehicle", (com, player) -> {

		});
		if(EnvInfo.CLIENT){
			PKTH_UT.LIS_CLIENT.put("ui", (com, player) -> {
				((UniCon)player.openContainer).container().packet(new TagCWI(com), true);
			});
		}
		FvtmLogger.LOGGER.log("Completed Packet Listener registration.");
	}

	@Override
	public void send(SeatInstance seat){
		sendToServer(new PKT_SeatUpdate(seat));
	}

	@Override
	public void send(BlockData blockdata, V3I vec, int dim) {
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
		com.set("target_listener", UTIL_LISTENER);
		com.set("task", "vehicle");
		com.set("entity", vehicle.entity.getId());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(com.local()), getTargetPoint(vehicle.entity.local()));
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
		return new NetworkRegistry.TargetPoint(ent.dimension, ent.posX, ent.posY, ent.posZ, Config.VEHICLE_UPDATE_RANGE);
	}

	public static TargetPoint getTargetPoint(int dim, BlockPos pos){
		return new NetworkRegistry.TargetPoint(dim, pos.getX(), pos.getY(), pos.getZ(), Config.VEHICLE_UPDATE_RANGE);
	}
}