package net.fexcraft.mod.fvtm.util.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PKT_SeatUpdate implements IPacket, IMessage {

    public float yaw, pitch;
	public int entid;

    public PKT_SeatUpdate(){}

    public PKT_SeatUpdate(SeatEntity ent){
    	entid = ent.getEntityId();
        yaw = ent.looking.getYaw();
        pitch = ent.looking.getPitch();
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(entid); buf.writeFloat(yaw); buf.writeFloat(pitch);
    }

    @Override
    public void fromBytes(ByteBuf buf){
        entid = buf.readInt(); yaw = buf.readFloat(); pitch = buf.readFloat();
    }

}
