package net.fexcraft.mod.fvtm.util.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SeatDismountPacketHandler {

    public static class Client implements IMessageHandler<PacketSeatDismount, IMessage> {

        @Override
        public IMessage onMessage(final PacketSeatDismount packet, final MessageContext ctx){
            IThreadListener ls = Minecraft.getMinecraft();
            ls.addScheduledTask(new Runnable() {
                @Override
                public void run(){
                    World world = Minecraft.getMinecraft().world;
                    for(Entity ent : world.loadedEntityList){
                        if(ent.getPersistentID().getMostSignificantBits() == packet.id0 && ent.getPersistentID().getLeastSignificantBits() == packet.id1){
                            ent.dismountRidingEntity();
                            break;
                        }
                    }
                    return;
                }
            });
            return null;
        }
    }

}
