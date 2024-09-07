package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packet_VehKeyPress implements PacketBase<Packet_VehKeyPress> {

    public KeyPress keypress;

    @Override
    public Packet_VehKeyPress fill(Object[] data){
        keypress = (KeyPress)data[0];
        return this;
    }

    @Override
    public void encode(ByteBuf buffer){
        buffer.writeInt(keypress.ordinal());
    }

    @Override
    public void decode(ByteBuf buffer){
        keypress = KeyPress.values()[buffer.readInt()];
    }

}
