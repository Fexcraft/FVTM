package net.fexcraft.mod.fvtm.util.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketSeatUpdate implements IPacket, IMessage {

	public long entid0, entid1;
    public float yaw, pitch;
    public int seat;

    public PacketSeatUpdate(){}

    public PacketSeatUpdate(SeatEntity ent){
    	entid0 = ent.getVehicle().getEntity().getPersistentID().getMostSignificantBits();
        entid1 = ent.getVehicle().getEntity().getPersistentID().getLeastSignificantBits();
        seat = ent.getSeatId();
        yaw = ent.looking.getYaw();
        pitch = ent.looking.getPitch();
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeLong(entid0);
        buf.writeLong(entid1);
        buf.writeInt(seat);
        buf.writeFloat(yaw);
        buf.writeFloat(pitch);
    }

    @Override
    public void fromBytes(ByteBuf buf){
        entid0 = buf.readLong();
        entid1 = buf.readLong();
        seat = buf.readInt();
        yaw = buf.readFloat();
        pitch = buf.readFloat();
    }

}
