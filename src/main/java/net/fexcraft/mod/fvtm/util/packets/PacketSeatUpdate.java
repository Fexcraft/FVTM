package net.fexcraft.mod.fvtm.util.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketSeatUpdate implements IPacket, IMessage {
	
	public int entity, seat;
	public float yaw, pitch;
	
	public PacketSeatUpdate(){}
	
	public PacketSeatUpdate(SeatEntity ent){
		entity = ent.getVehicle().getEntity().getEntityId();
		seat = ent.getSeatId();
		yaw = ent.looking.getYaw();
		pitch = ent.looking.getPitch();
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(entity);
		buf.writeInt(seat);
		buf.writeFloat(yaw);
		buf.writeFloat(pitch);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		entity = buf.readInt();
		seat = buf.readInt();
		yaw = buf.readFloat();
		pitch = buf.readFloat();
	}
	
}