package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packet_SeatUpdate implements PacketBase<Packet_SeatUpdate> {

    public float yaw;
    public float pitch;
	public int entid;
    public int seatid;

    @Override
    public Packet_SeatUpdate fill(Object[] data){
        SeatInstance seat = (SeatInstance)data[0];
        entid = seat.root.entity.getId();
    	seatid = seat.index;
        yaw = seat.elook.deg_yaw();
        pitch = seat.elook.deg_pitch();
        return this;
    }

    @Override
    public void encode(ByteBuf buffer){
        buffer.writeInt(entid);
        buffer.writeInt(seatid);
        buffer.writeFloat(yaw);
        buffer.writeFloat(pitch);
    }

    @Override
    public void decode(ByteBuf buffer){
        entid = buffer.readInt();
        seatid = buffer.readInt();
        yaw = buffer.readFloat();
        pitch = buffer.readFloat();
    }

}
