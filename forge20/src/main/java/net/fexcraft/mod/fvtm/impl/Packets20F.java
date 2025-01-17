package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fcl.util.ClientPacketPlayer;
import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.packet.*;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packets20F extends Packets20 {

	@Override
	public void init(){
		super.init();
		FVTM4.CHANNEL.registerMessage(1, Packet_TagListener.class,
			(packet, buffer) -> {
				packet.encode(buffer);
			},
			buffer -> {
				Packet_TagListener packet = new Packet_TagListener();
				packet.decode(buffer);
				return packet;
			},
			(packet, context) -> {
				context.get().enqueueWork(getRunnable(packet, context, HTL));
				context.get().setPacketHandled(true);
			});
		FVTM4.CHANNEL.registerMessage(2, Packet_VehMove.class,
			(packet, buffer) -> packet.encode(buffer),
			buffer -> {
				Packet_VehMove packet = new Packet_VehMove();
				packet.decode(buffer);
				return packet;
			},
			(packet, context) -> {
				context.get().enqueueWork(getRunnableWhenPlayerPresent(packet, context, HVM));
				context.get().setPacketHandled(true);
			});
		FVTM4.CHANNEL.registerMessage(3, Packet_VehKeyPress.class,
			(packet, buffer) -> packet.encode(buffer),
			buffer -> {
				Packet_VehKeyPress packet = new Packet_VehKeyPress();
				packet.decode(buffer);
				return packet;
			},
			(packet, context) -> {
				context.get().enqueueWork(getRunnable(packet, context, HVK));
				context.get().setPacketHandled(true);
			});
		FVTM4.CHANNEL.registerMessage(4, Packet_VehKeyPressState.class,
			(packet, buffer) -> packet.encode(buffer),
			buffer -> {
				Packet_VehKeyPressState packet = new Packet_VehKeyPressState();
				packet.decode(buffer);
				return packet;
			},
			(packet, context) -> {
				context.get().enqueueWork(getRunnable(packet, context, HVKS));
				context.get().setPacketHandled(true);
			});
		FVTM4.CHANNEL.registerMessage(5, Packet_SeatUpdate.class,
			(packet, buffer) -> packet.encode(buffer),
			buffer -> {
				Packet_SeatUpdate packet = new Packet_SeatUpdate();
				packet.decode(buffer);
				return packet;
			},
			(packet, context) -> {
				context.get().enqueueWork(getRunnable(packet, context, HSU));
				context.get().setPacketHandled(true);
			});
		FVTM4.CHANNEL.registerMessage(6, Packet_SPUpdate.class,
			(packet, buffer) -> packet.encode(buffer),
			buffer -> {
				Packet_SPUpdate packet = new Packet_SPUpdate();
				packet.decode(buffer);
				return packet;
			},
			(packet, context) -> {
				context.get().enqueueWork(getRunnable(packet, context, HSPU));
				context.get().setPacketHandled(true);
			});
	}

	private <PKT extends PacketBase> Runnable getRunnable(PKT packet, Supplier<NetworkEvent.Context> context, PacketHandler<PKT> handler){
		if(context.get().getDirection().getOriginationSide().isClient()){
			try{
				return handler.handleServer(packet, UniEntity.getCasted(context.get().getSender()));
			}
			catch(Throwable e){
				e.printStackTrace();
			}
		}
		else{
			try{
				return handler.handleClient(packet, UniEntity.getCasted(ClientPacketPlayer.get()));
			}
			catch(Throwable e){
				e.printStackTrace();
			}
		}
		return () -> {};
	}

	private <PKT extends PacketBase> Runnable getRunnableWhenPlayerPresent(PKT packet, Supplier<NetworkEvent.Context> context, PacketHandler<PKT> handler){
		if(context.get().getDirection().getOriginationSide().isClient()){
			if(context.get().getSender() == null) return () -> {};
			Passenger pass = UniEntity.getCasted(context.get().getSender());
			if(pass == null) return () -> {};
			return handler.handleServer(packet, pass);
		}
		else{
			if(ClientPacketPlayer.get() == null) return () -> {};
			Passenger pass = UniEntity.getCasted(ClientPacketPlayer.get());
			if(pass == null) return () -> {};
			return handler.handleClient(packet, pass);
		}
	}

	@Override
	public void send0(Class<? extends PacketBase> packet, Object... data){
		try{
			FVTM4.CHANNEL.send(PacketDistributor.SERVER.noArg(), packet.newInstance().fill(data));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void sendInRange0(Class<? extends PacketBase> packet, WorldW world, V3D pos, int range, Object... data){
		try{
			Vec3 vec = new Vec3(pos.x, pos.y, pos.z);
			for(ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()){
				if(player.position().distanceTo(vec) > range) continue;
				FVTM4.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), packet.newInstance().fill(data));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void sendToAll0(Class<? extends PacketBase> packet, Object... data){
		try{
			for(ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()){
				FVTM4.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), packet.newInstance().fill(data));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void sendTo0(Class<? extends PacketBase> packet, Passenger to, Object... data){
		try{
			FVTM4.CHANNEL.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)to.direct()), packet.newInstance().fill(data));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
