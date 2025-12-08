package net.fexcraft.mod.fvtm.mixin;

import net.fexcraft.mod.fvtm.util.ClientAddEntity;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.fvtm.util.SpawnPacketEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mixin(ClientboundAddEntityPacket.class)
public class ClientAddEntityMixin implements ClientAddEntity {

	@Shadow
	private EntityType<?> type;

	@Unique
	public CompoundTag fvtm_data;

	@Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/server/level/ServerEntity;)V")
	public void fvtm_init(Entity entity, ServerEntity sentity, CallbackInfo ci){
		if(entity instanceof SpawnPacketEntity){
			TagCW com = TagCW.create();
			((SpawnPacketEntity)entity).writeSpawnData(com);
			fvtm_data = com.local();
		}
	}

	@Inject(at = @At("TAIL"), method = "write")
	public void write_fvtm_data(RegistryFriendlyByteBuf buf, CallbackInfo ci){
		if(fvtm_data != null) buf.writeNbt(fvtm_data);
	}

	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/network/RegistryFriendlyByteBuf;)V")
	public void fvtm_packet(RegistryFriendlyByteBuf buf, CallbackInfo ci){
		if(isFvtmEntity(type)) fvtm_data = buf.readNbt();
	}

	private boolean isFvtmEntity(EntityType<?> type){
		if(type == Resources21.WHEEL_ENTITY) return true;
		if(type == Resources21.VEHICLE_ENTITY) return true;
		if(type == Resources21.RAIL_ENTITY) return true;
		if(type == Resources21.ROAD_MARKER_ENTITY) return true;
		if(type == Resources21.RAIL_MARKER_ENTITY) return true;
		if(type == Resources21.DECO_ENTITY) return true;
		return false;
	}

	@Override
	public TagCW getFvtmData(){
		return TagCW.wrap(fvtm_data);
	}

}