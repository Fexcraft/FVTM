package net.fexcraft.mod.fvtm.impl;

import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.common.utils.CallbackContainer;
import net.fexcraft.mod.fcl.FCL;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.packet.*;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.SpawnPacket;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Packets21 extends Packets {

	public static final HashMap<Class<? extends PacketBase>, Class<? extends PacketBase>> PACKETS = new LinkedHashMap<>();
	public static final ResourceLocation TAG_PACKET = ResourceLocation.parse("fvtm:tag");
	public static final ResourceLocation VEHMOVE_PACKET = ResourceLocation.parse("fvtm:veh_move");
	public static final ResourceLocation VEHKEYPRESS_PACKET = ResourceLocation.parse("fvtm:veh_key");
	public static final ResourceLocation VEHKEYSTATE_PACKET = ResourceLocation.parse("fvtm:veh_keystate");
	public static final ResourceLocation SEATUPDATE_PACKET = ResourceLocation.parse("fvtm:seat_upd");
	public static final ResourceLocation SPUPDATE_PACKET = ResourceLocation.parse("fvtm:sp_upd");
	public static final CallbackContainer PACKET_HANDLERS = new CallbackContainer();
	//
	public static Handler_TagListener HTL = new Handler_TagListener();
	public static Handler_VehMove HVM = new Handler_VehMove();
	public static Handler_VehKeyPress HVK = new Handler_VehKeyPress();
	public static Handler_VehKeyPressState HVKS = new Handler_VehKeyPressState();
	public static Handler_SeatUpdate HSU = new Handler_SeatUpdate();
	public static Handler_SPUpdate HSPU = new Handler_SPUpdate();
	//
	public static final ResourceLocation SPAWN_PACKET = ResourceLocation.parse("fvtm:spawn");
	public static final CustomPacketPayload.Type<SpawnPacket> SPAWN_PACKET_TYPE = new CustomPacketPayload.Type<>(SPAWN_PACKET);
	public static final StreamCodec<RegistryFriendlyByteBuf, SpawnPacket> SPAWN_PACKET_CODEC = StreamCodec.of(SpawnPacket::encode, SpawnPacket::new);
	//
	public static final CustomPacketPayload.Type<Pkt_TagListener> TAG_PACKET_TYPE = new CustomPacketPayload.Type<>(TAG_PACKET);
	public static final CustomPacketPayload.Type<Pkt_VehMove> VEHMOVE_PACKET_TYPE = new CustomPacketPayload.Type<>(VEHMOVE_PACKET);
	public static final CustomPacketPayload.Type<Pkt_VehKeyPress> VEHKEYPRESS_PACKET_TYPE = new CustomPacketPayload.Type<>(VEHKEYPRESS_PACKET);
	public static final CustomPacketPayload.Type<Pkt_VehKeyState> VEHKEYSTATE_PACKET_TYPE = new CustomPacketPayload.Type<>(VEHKEYSTATE_PACKET);
	public static final CustomPacketPayload.Type<Pkt_SeatUpdate> SEATUPDATE_PACKET_TYPE = new CustomPacketPayload.Type<>(SEATUPDATE_PACKET);
	public static final CustomPacketPayload.Type<Pkt_SPUpdate> SPUPDATE_PACKET_TYPE = new CustomPacketPayload.Type<>(SPUPDATE_PACKET);
	public static final StreamCodec<RegistryFriendlyByteBuf, Pkt_TagListener> TAG_PACKET_CODEC = StreamCodec.of((buf, pkt) -> pkt.encode(buf), buf -> new Pkt_TagListener().decode(buf));
	public static final StreamCodec<RegistryFriendlyByteBuf, Pkt_VehMove> VEHMOVE_PACKET_CODEC = StreamCodec.of((buf, pkt) -> pkt.encode(buf), buf -> new Pkt_VehMove().decode(buf));
	public static final StreamCodec<RegistryFriendlyByteBuf, Pkt_VehKeyPress> VEHKEYPRESS_PACKET_CODEC = StreamCodec.of((buf, pkt) -> pkt.encode(buf), buf -> new Pkt_VehKeyPress().decode(buf));
	public static final StreamCodec<RegistryFriendlyByteBuf, Pkt_VehKeyState> VEHKEYSTATE_PACKET_CODEC = StreamCodec.of((buf, pkt) -> pkt.encode(buf), buf -> new Pkt_VehKeyState().decode(buf));
	public static final StreamCodec<RegistryFriendlyByteBuf, Pkt_SeatUpdate> SEATUPDATE_PACKET_CODEC = StreamCodec.of((buf, pkt) -> pkt.encode(buf), buf -> new Pkt_SeatUpdate().decode(buf));
	public static final StreamCodec<RegistryFriendlyByteBuf, Pkt_SPUpdate> SPUPDATE_PACKET_CODEC = StreamCodec.of((buf, pkt) -> pkt.encode(buf), buf -> new Pkt_SPUpdate().decode(buf));

	@Override
	public void init(){
		super.init();
		register();
		INSTANCE = this;
		LIS_SERVER.put("mount_seat", (com, player) -> {
			Player entity = player.local();
			RootVehicle vehicle = (RootVehicle)entity.level().getEntity(com.getInteger("entity"));
			int index = com.getInteger("seat");
			if(index < 0 || index > vehicle.vehicle.seats.size()) return;
			vehicle.processSeatInteract(index, player.local(), InteractionHand.MAIN_HAND);
		});
		if(EnvInfo.CLIENT){
			LIS_CLIENT.put("deco", (tag, player) -> {
				Level level = player.getWorld().local();
				Entity ent = level.getEntity(tag.getInteger("entid"));
				if(ent != null && ent instanceof DecorationEntity){
					((DecorationEntity)ent).readAdditionalSaveData(tag.local());
				}
			});
			LIS_CLIENT.put("passenger_update", (tag, player) -> {
				Level level = player.getWorld().local();
				Entity ent = level.getEntity(tag.getInteger("entity"));
				if(ent == null) return;
				((Passenger)UniEntity.getEntity(ent)).set(tag.getInteger("vehicle"), tag.getInteger("seat"));
			});
		}
	}

	private void register(){
		PayloadTypeRegistry.playS2C().register(SPAWN_PACKET_TYPE, SPAWN_PACKET_CODEC);
		PayloadTypeRegistry.playC2S().register(SPAWN_PACKET_TYPE, SPAWN_PACKET_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(SPAWN_PACKET_TYPE, (packet, context) -> {
			context.server().execute(() -> {
				Entity ent = context.player().level().getEntity(packet.entity());
				if(ent instanceof SpawnPacket.PacketEntity pe){
					ServerPlayNetworking.getSender(context.player()).sendPacket(new SpawnPacket(pe));
				}
			});
		});
		//
		register(Packet_TagListener.class, Pkt_TagListener.class, TAG_PACKET_TYPE, TAG_PACKET_CODEC, HTL);
		register(Packet_VehMove.class, Pkt_VehMove.class, VEHMOVE_PACKET_TYPE, VEHMOVE_PACKET_CODEC, HVM);
		register(Packet_VehKeyPress.class, Pkt_VehKeyPress.class, VEHKEYPRESS_PACKET_TYPE, VEHKEYPRESS_PACKET_CODEC, HVK);
		register(Packet_VehKeyPressState.class, Pkt_VehKeyState.class, VEHKEYSTATE_PACKET_TYPE, VEHKEYSTATE_PACKET_CODEC, HVKS);
		register(Packet_SeatUpdate.class, Pkt_SeatUpdate.class, SEATUPDATE_PACKET_TYPE, SEATUPDATE_PACKET_CODEC, HSU);
		register(Packet_SPUpdate.class, Pkt_SPUpdate.class, SPUPDATE_PACKET_TYPE, SPUPDATE_PACKET_CODEC, HSPU);
		//
		PACKET_HANDLERS.complete();
	}

	private <T extends CustomPacketPayload> void register(Class<? extends PacketBase> root, Class<T> ext, CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf, T> codec, PacketHandler ph){
		PACKETS.put(root, (Class<? extends PacketBase>)ext);
		PayloadTypeRegistry.playS2C().register(type, codec);
		PayloadTypeRegistry.playC2S().register(type, codec);
		ServerPlayNetworking.registerGlobalReceiver(type, (packet, context) -> context.server().execute(() -> ph.handleServer((PacketBase)packet, UniEntity.getEntity(context.player()))));
	}

	@Override
	public void writeTag(ByteBuf buffer, TagCW tag){
		((FriendlyByteBuf)buffer).writeNbt(tag.local());
	}

	@Override
	public TagCW readTag(ByteBuf buffer){
		return TagCW.wrap(((FriendlyByteBuf)buffer).readNbt());
	}

	@Override
	public void send(BlockData blockdata, V3I pos, int dim){

	}

	@Override
	public void send(WorldW world, V3I pos){

	}

	@Override
	public void send(VehicleInstance vehicle, TagCW com){
		com.set("entity", vehicle.entity.getId());
		if(vehicle.entity.isOnClient()){
			send(Pkt_TagListener.class, "vehicle", com);
		}
		else{
			sendInRange(Pkt_TagListener.class, vehicle.entity.getWorld(), vehicle.entity.getPos(), "vehicle", com);
		}
	}

	//

	public static class Pkt_TagListener extends Packet_TagListener implements CustomPacketPayload {

		public Pkt_TagListener decode(RegistryFriendlyByteBuf buf){
			super.decode(buf);
			return this;
		}

		@Override
		public Type<? extends CustomPacketPayload> type(){
			return TAG_PACKET_TYPE;
		}

	}

	public static class Pkt_VehMove extends Packet_VehMove implements CustomPacketPayload {
		
		public Pkt_VehMove decode(RegistryFriendlyByteBuf buf){
			super.decode(buf);
			return this;
		}

		@Override
		public Type<? extends CustomPacketPayload> type(){
			return VEHMOVE_PACKET_TYPE;
		}
		
	}

	public static class Pkt_VehKeyPress extends Packet_VehKeyPress implements CustomPacketPayload {

		public Pkt_VehKeyPress decode(RegistryFriendlyByteBuf buf){
			super.decode(buf);
			return this;
		}

		@Override
		public Type<? extends CustomPacketPayload> type(){
			return VEHKEYPRESS_PACKET_TYPE;
		}

	}

	public static class Pkt_VehKeyState extends Packet_VehKeyPressState implements CustomPacketPayload {

		public Pkt_VehKeyState decode(RegistryFriendlyByteBuf buf){
			super.decode(buf);
			return this;
		}

		@Override
		public Type<? extends CustomPacketPayload> type(){
			return VEHKEYSTATE_PACKET_TYPE;
		}

	}

	public static class Pkt_SeatUpdate extends Packet_SeatUpdate implements CustomPacketPayload {

		public Pkt_SeatUpdate decode(RegistryFriendlyByteBuf buf){
			super.decode(buf);
			return this;
		}

		@Override
		public Type<? extends CustomPacketPayload> type(){
			return SEATUPDATE_PACKET_TYPE;
		}

	}

	public static class Pkt_SPUpdate extends Packet_SPUpdate implements CustomPacketPayload {

		public Pkt_SPUpdate decode(RegistryFriendlyByteBuf buf){
			super.decode(buf);
			return this;
		}

		@Override
		public Type<? extends CustomPacketPayload> type(){
			return SPUPDATE_PACKET_TYPE;
		}

	}

	//

	@Override
	public void send0(Class<? extends PacketBase> packet, Object... data){
		try{
			ClientPlayNetworking.send((CustomPacketPayload)PACKETS.get(packet).newInstance().fill(data));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void sendInRange0(Class<? extends PacketBase> packet, WorldW world, V3D pos, int range, Object... data){
		try{
			Vec3 vec = new Vec3(pos.x, pos.y, pos.z);
			for(ServerPlayer player : FCL.SERVER.get().getPlayerList().getPlayers()){
				if(player.position().distanceTo(vec) > range) continue;
				ServerPlayNetworking.getSender(player).sendPacket((CustomPacketPayload)PACKETS.get(packet).newInstance().fill(data));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void sendToAll0(Class<? extends PacketBase> packet, Object... data){
		try{
			for(ServerPlayer player : FCL.SERVER.get().getPlayerList().getPlayers()){
				ServerPlayNetworking.getSender(player).sendPacket((CustomPacketPayload)PACKETS.get(packet).newInstance().fill(data));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void sendTo0(Class<? extends PacketBase> packet, Passenger to, Object... data){
		try{
			ServerPlayNetworking.getSender((ServerPlayer)to.direct()).sendPacket((CustomPacketPayload)PACKETS.get(packet).newInstance().fill(data));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
