package net.fexcraft.mod.fvtm.util.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.fexcraft.mod.fvtm.sys.legacy.KeyPress;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PKT_VehKeyPress implements IPacket, IMessage {

    public KeyPress keypress;

    public PKT_VehKeyPress(){}

    public PKT_VehKeyPress(KeyPress press){ keypress = press; }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(keypress.ordinal());
    }

    @Override
    public void fromBytes(ByteBuf buf){
        keypress = KeyPress.values()[buf.readInt()];
    }

}
