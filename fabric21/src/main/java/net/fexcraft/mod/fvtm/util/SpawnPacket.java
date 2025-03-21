package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;

import static net.fexcraft.mod.fvtm.impl.Packets21.SPAWN_PACKET_TYPE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public record SpawnPacket(int entity, TagCW com) implements CustomPacketPayload {

	public SpawnPacket(RegistryFriendlyByteBuf buf){
		this(buf.readInt(), TagCW.wrap(buf.readNbt()));
	}

	public SpawnPacket(Entity ent){//sync request
		this(ent.getId(), TagCW.create());
	}

	public SpawnPacket(PacketEntity ent){//sync response
		this((Entity)ent);
		ent.writeSpawnData(com);
	}

	public static void encode(FriendlyByteBuf buf, SpawnPacket packet){
		buf.writeInt(packet.entity);
		buf.writeNbt(packet.com.local());
	}

	@Override
	public Type<? extends CustomPacketPayload> type(){
		return SPAWN_PACKET_TYPE;
	}

	public static interface PacketEntity {

		public void writeSpawnData(TagCW com);

		public void readSpawnData(TagCW com);

	}


}
