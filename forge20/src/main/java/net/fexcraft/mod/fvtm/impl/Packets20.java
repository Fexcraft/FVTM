package net.fexcraft.mod.fvtm.impl;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.packet.*;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class Packets20 extends Packets {

	public static final HashMap<Class<? extends PacketBase>, Class<? extends PacketBase>> PACKETS = new LinkedHashMap<>();
	public static final ResourceLocation TAG_PACKET = new ResourceLocation("fvtm", "tag");
	public static final ResourceLocation VEHMOVE_PACKET = new ResourceLocation("fvtm", "veh_move");
	public static final ResourceLocation VEHKEYPRESS_PACKET = new ResourceLocation("fvtm", "veh_key");
	public static final ResourceLocation VEHKEYSTATE_PACKET = new ResourceLocation("fvtm", "veh_keystate");
	public static final ResourceLocation SEATUPDATE_PACKET = new ResourceLocation("fvtm", "seat_upd");
	public static final ResourceLocation SPUPDATE_PACKET = new ResourceLocation("fvtm", "sp_upd");
	//
	public static Handler_TagListener HTL = new Handler_TagListener();
	public static Handler_VehMove HVM = new Handler_VehMove();
	public static Handler_VehKeyPress HVK = new Handler_VehKeyPress();
	public static Handler_VehKeyPressState HVKS = new Handler_VehKeyPressState();
	public static Handler_SeatUpdate HSU = new Handler_SeatUpdate();
	public static Handler_SPUpdate HSPU = new Handler_SPUpdate();

	@Override
	public void init(){
		super.init();
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
			send(Packet_TagListener.class, "vehicle", com);
		}
		else{
			sendInRange(Packet_TagListener.class, vehicle.entity.getWorld(), vehicle.entity.getPos(), "vehicle", com);
		}
	}

}
