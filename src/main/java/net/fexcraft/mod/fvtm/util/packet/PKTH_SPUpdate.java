package net.fexcraft.mod.fvtm.util.packet;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PKTH_SPUpdate {

	public static class Server implements IMessageHandler<PKT_SPUpdate, IMessage> {

		@Override
		public IMessage onMessage(final PKT_SPUpdate packet, final MessageContext ctx){
			Static.getServer().addScheduledTask(() -> {
				EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(ctx.getServerHandler().player.getName());
				for(Entity ent : player.world.loadedEntityList){
					if(ent.getEntityId() == packet.entid){
						updatesp(ent, packet, false);
						return;
					}
				}
				return;
			});
			return null;
		}

	}

	public static class Client implements IMessageHandler<PKT_SPUpdate, IMessage> {

		@Override
		public IMessage onMessage(final PKT_SPUpdate packet, final MessageContext ctx){
			Minecraft.getMinecraft().addScheduledTask(new Runnable(){
				@Override
				public void run(){
					for(Entity ent : Minecraft.getMinecraft().world.getLoadedEntityList()){
						if(ent.getEntityId() == packet.entid){
							updatesp(ent, packet, true);
							return;
						}
					}
					return;
				}
			});
			return null;
		}

	}

	private static void updatesp(Entity entity, PKT_SPUpdate pkt, boolean client){
		if(entity instanceof VehicleEntity == false){ return; }
		SwivelPoint point = ((VehicleEntity)entity).getVehicleData().getRotationPoints().get(pkt.pointid);
		if(point != null) point.processPacket(pkt, client);
	}

}
