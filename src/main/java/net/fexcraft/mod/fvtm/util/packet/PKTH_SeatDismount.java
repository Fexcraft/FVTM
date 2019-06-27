package net.fexcraft.mod.fvtm.util.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PKTH_SeatDismount {

    public static class Client implements IMessageHandler<PKT_SeatDismount, IMessage> {

        @Override
        public IMessage onMessage(final PKT_SeatDismount packet, final MessageContext ctx){
            IThreadListener ls = Minecraft.getMinecraft();
            ls.addScheduledTask(new Runnable() {
                @Override
                public void run(){
                    World world = Minecraft.getMinecraft().world;
                    for(Entity ent : world.loadedEntityList){
                        if(ent.getEntityId() == packet.ent){ ent.dismountRidingEntity(); break; }
                    } return;
                }
            });
            return null;
        }
    }

}
