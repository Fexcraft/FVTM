package net.fexcraft.mod.fvtm.util.packet;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PKTH_VehControl {

    public static class Server implements IMessageHandler<PKT_VehControl, IMessage> {

        @Override
        public IMessage onMessage(final PKT_VehControl packet, final MessageContext ctx){
            Static.getServer().addScheduledTask(() -> {
                for(Entity ent : ctx.getServerHandler().player.world.loadedEntityList){
                    if(ent.getEntityId() == packet.entid){ updatevehicle(ent, packet); return; }
                } return;
            }); return null;
        }
    }

    public static class Client implements IMessageHandler<PKT_VehControl, IMessage> {

        @Override
        public IMessage onMessage(final PKT_VehControl packet, final MessageContext ctx){
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                @Override
                public void run(){
                    for(Entity ent : Minecraft.getMinecraft().world.getLoadedEntityList()){
                        if(ent.getEntityId() == packet.entid){ updatevehicle(ent, packet); return; }
                    } return;
                }
            }); return null;
        }
    }

    private static void updatevehicle(Entity entity, PKT_VehControl pkt){
        if(entity == null || entity instanceof GenericVehicle == false){ return; }
        ((GenericVehicle)entity).setPositionRotationAndMotion(pkt.posX, pkt.posY, pkt.posZ, pkt.yaw, pkt.pitch, pkt.roll,
        	pkt.motX, pkt.motY, pkt.motZ, pkt.throttle, pkt.steeringYaw, pkt.fuel);
    }

}
