package net.fexcraft.mod.fvtm.util.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.api.packet.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketVehicleKeyPress implements IPacket, IMessage {

    public int key;

    public PacketVehicleKeyPress(){
    }

    public PacketVehicleKeyPress(int key){
        this.key = key;
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(key);
    }

    @Override
    public void fromBytes(ByteBuf buf){
        key = buf.readInt();
    }

}
