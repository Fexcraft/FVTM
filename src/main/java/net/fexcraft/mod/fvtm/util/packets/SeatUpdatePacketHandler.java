package net.fexcraft.mod.fvtm.util.packets;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SeatUpdatePacketHandler {
	
	public static class Server implements IMessageHandler<PacketSeatUpdate, IMessage>{
		@Override
		public IMessage onMessage(final PacketSeatUpdate packet, final MessageContext ctx) {
			IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayerMP player = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(ctx.getServerHandler().player.getName());
					VehicleEntity vehicle = null;
					for(Entity obj : player.world.loadedEntityList){
						if(obj instanceof VehicleEntity && obj.getEntityId() == packet.entity){
							vehicle = (VehicleEntity)obj;
							break;
						}
					}
					if(vehicle != null){
						vehicle.getSeats()[packet.seat].prevlooking = vehicle.getSeats()[packet.seat].looking.clone();
						vehicle.getSeats()[packet.seat].looking.setAngles(packet.yaw, packet.pitch, 0F);
						PacketHandler.getInstance().sendToAllAround(packet, new TargetPoint(vehicle.getEntity().dimension, vehicle.getEntity().getPosition().getX(), vehicle.getEntity().getPosition().getY(), vehicle.getEntity().getPosition().getZ(), 256));//TODO config
					}
				}
			});
			return null;
		}
	}
	
	public static class Client implements IMessageHandler<PacketSeatUpdate, IMessage>{
		@Override
		public IMessage onMessage(final PacketSeatUpdate packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayer player = Minecraft.getMinecraft().player;
					VehicleEntity vehicle = null;
					for(Entity obj : player.world.loadedEntityList){
						if(obj instanceof VehicleEntity && obj.getEntityId() == packet.entity){
							vehicle = (VehicleEntity)obj;
							break;
						}
					}
					if(vehicle != null){
						if(vehicle.getSeats()[packet.seat] == null || vehicle.getSeats()[packet.seat].getControllingPassenger() == player){
							return;
						}
						vehicle.getSeats()[packet.seat].prevlooking = vehicle.getSeats()[packet.seat].looking.clone();
						vehicle.getSeats()[packet.seat].looking.setAngles(packet.yaw, packet.pitch, 0F);
					}
				}
			});
			return null;
		}
	}
	
}