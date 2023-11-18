package net.fexcraft.mod.fvtm.util.packet;

import static net.fexcraft.mod.fvtm.Config.VEHICLE_UPDATE_RANGE;

import java.util.List;

import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PKTH_SeatUpdate {

    public static class Server implements IMessageHandler<PKT_SeatUpdate, IMessage> {

        @Override
        public IMessage onMessage(final PKT_SeatUpdate packet, final MessageContext ctx){
            IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
            ls.addScheduledTask(new Runnable() {
                @Override
                public void run(){
                    findAndApply(packet, ctx.getServerHandler().player.world.loadedEntityList, true);
                }
            });
            return null;
        }
    }

    public static class Client implements IMessageHandler<PKT_SeatUpdate, IMessage> {

        @Override
        public IMessage onMessage(final PKT_SeatUpdate packet, final MessageContext ctx){
            IThreadListener ls = Minecraft.getMinecraft();
            ls.addScheduledTask(new Runnable() {
                @Override
                public void run(){
                    EntityPlayer player = Minecraft.getMinecraft().player;
                    findAndApply(packet, player.world.loadedEntityList, false);
                }
            });
            return null;
        }
    }

	private static final void findAndApply(PKT_SeatUpdate packet, List<Entity> list, boolean send){
        for(Entity ent : list){
            if(ent.getEntityId() == packet.entid){
            	RootVehicle veh = (RootVehicle)ent;
            	SeatInstance seat = veh.vehicle.seats.get(packet.seatid);
            	seat.pelook = seat.elook.copy();
            	seat.elook.set_rotation(packet.yaw, packet.pitch, 0F, true);
            	if(send){
                    Packets.sendToAllAround(packet, new TargetPoint(veh.dimension, veh.posX, veh.posY, veh.posZ, VEHICLE_UPDATE_RANGE));
            	}
            	return;
            }
        }
	}

}
