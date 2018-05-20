package net.fexcraft.mod.fvtm.util.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketSeatDismount implements IPacket, IMessage {

    public int id;

    public PacketSeatDismount(){
    }

    public PacketSeatDismount(int id){
        this.id = id;
    }

    @Override
    public void toBytes(ByteBuf bbuf){
        bbuf.writeInt(id);
    }

    @Override
    public void fromBytes(ByteBuf bbuf){
        id = bbuf.readInt();
    }

}
