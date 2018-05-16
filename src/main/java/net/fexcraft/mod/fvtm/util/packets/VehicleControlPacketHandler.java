package net.fexcraft.mod.fvtm.util.packets;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class VehicleControlPacketHandler {
	
	public static class Server implements IMessageHandler<PacketVehicleControl, IMessage>{
		@Override
		public IMessage onMessage(final PacketVehicleControl packet, final MessageContext ctx){
			Static.getServer().addScheduledTask(() -> {
				EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(ctx.getServerHandler().player.getName());
				for(Entity ent : player.world.loadedEntityList){
					if(ent.getEntityId() == packet.entityId){
						updatevehicle(ent, packet);
						return;
					}
				}
				return;
			});
			return null;
		}
	}
	
	public static class Client implements IMessageHandler<PacketVehicleControl, IMessage>{
		@Override
		public IMessage onMessage(final PacketVehicleControl packet, final MessageContext ctx){
			Minecraft.getMinecraft().addScheduledTask(new Runnable(){
                            @Override
                            public void run() {
                                for(Entity ent : Minecraft.getMinecraft().world.getLoadedEntityList()){
					if(ent.getEntityId() == packet.entityId){
						updatevehicle(ent, packet);
						return;
					}
				}
				return;
                            }
			});
			return null;
		}
	}
	
	private static void updatevehicle(Entity entity, PacketVehicleControl pkt){
		if(entity == null){ return; }
		VehicleEntity vehicle = (VehicleEntity)entity;
		vehicle.setPositionRotationAndMotion(pkt.posX, pkt.posY, pkt.posZ, pkt.yaw, pkt.pitch, pkt.roll, pkt.motX, pkt.motY, pkt.motZ, pkt.avelx, pkt.avely, pkt.avelz, pkt.throttle, pkt.steeringYaw);
		vehicle.getVehicleData().toggleDoors(pkt.doors);
		if(vehicle.getEntityAtRear() != null){
			vehicle.getEntityAtRear().getVehicleData().toggleDoors(pkt.doors);
		}
	}
	
}