package net.fexcraft.mod.fvtm.util.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PKT_SeatUpdate implements IPacket, IMessage {

    public float yaw, pitch;
	public int entid, seatid;

    public PKT_SeatUpdate(){}

    public PKT_SeatUpdate(SeatInstance seat){
    	entid = seat.root.entity.getId();
    	seatid = seat.index;
        yaw = seat.elook.deg_yaw();
        pitch = seat.elook.deg_pitch();
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(entid);
        buf.writeInt(seatid);
        buf.writeFloat(yaw);
        buf.writeFloat(pitch);
    }

    @Override
    public void fromBytes(ByteBuf buf){
        entid = buf.readInt();
        seatid = buf.readInt();
        yaw = buf.readFloat();
        pitch = buf.readFloat();
    }

}
