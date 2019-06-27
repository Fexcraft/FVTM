package net.fexcraft.mod.fvtm.util.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PKT_SeatDismount implements IPacket, IMessage {

    public int ent;

    public PKT_SeatDismount(){}

    public PKT_SeatDismount(Entity pass){ this.ent = pass.getEntityId(); }

    @Override
    public void toBytes(ByteBuf bbuf){ bbuf.writeInt(ent); }

    @Override
    public void fromBytes(ByteBuf bbuf){ ent = bbuf.readInt(); }

}
