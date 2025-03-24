package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;

public class ListenerClient implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return UTIL_LISTENER;
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
			case "color_channel":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null || ent instanceof RootVehicle == false) return;
				((RootVehicle)ent).vehicle.data.getColorChannel(packet.nbt.getString("channel")).packed = packet.nbt.getInteger("color");
				return;
			}
			case "deco_update":{
				DecorationEntity ent = (DecorationEntity)player.world.getEntityByID(packet.nbt.getInteger("entid"));
				if(ent != null) ent.readEntityFromNBT(packet.nbt);
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
