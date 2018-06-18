package net.fexcraft.mod.fvtm.util.packets;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketSeatDismount implements IPacket, IMessage {

    public long id0, id1;

    public PacketSeatDismount(){
    }

    public PacketSeatDismount(UUID uuid){
        this.id0 = uuid.getMostSignificantBits();
        this.id1 = uuid.getLeastSignificantBits();
    }

    @Override
    public void toBytes(ByteBuf bbuf){
        bbuf.writeLong(id0);
        bbuf.writeLong(id1);
    }

    @Override
    public void fromBytes(ByteBuf bbuf){
        id0 = bbuf.readLong();
        id1 = bbuf.readLong();
    }

}
