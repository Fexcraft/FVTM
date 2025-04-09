package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.UUID;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailMarker extends Entity {

	public QV3D position;
	public UUID queueid;

	public RailMarker(EntityType<RailMarker> type, Level level){
		super(type, level);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag){
		if(tag.contains("uuid0")){
			queueid = new UUID(tag.getLongOr("uuid0", 0l), tag.getLongOr("uuid1", 0l));
		}
		if(tag.contains("position")){
			position = new QV3D(TagCW.wrap(tag), "position");
		}
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag){
		if(queueid != null){
			tag.putLong("uuid0", queueid.getMostSignificantBits());
			tag.putLong("uuid1", queueid.getLeastSignificantBits());
		}
		if(position != null){
			position.write(TagCW.wrap(tag), "position");
		}
	}

	/*@Override
	public void writeSpawnData(FriendlyByteBuf buffer){
		try{
			if(queueid == null){
				buffer.writeLong(0);
				buffer.writeLong(0);
			}
			else{
				buffer.writeLong(queueid.getMostSignificantBits());
				buffer.writeLong(queueid.getLeastSignificantBits());
			}
			buffer.writeDouble(position.vec.x);
			buffer.writeDouble(position.vec.y);
			buffer.writeDouble(position.vec.z);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void readSpawnData(FriendlyByteBuf buffer){
		try{
			long m = buffer.readLong(), l = buffer.readLong();
			if(m == 0 && l == 0) queueid = null;
			else queueid = new UUID(m, l);
			position = new QV3D(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.tick();
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}*/

	@Override
	public boolean isPickable(){
		return true;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder){

	}

	@Override
	public void baseTick(){
		super.baseTick();
		if(level().isClientSide) return;
		if(queueid == null || !RailPlacingUtil.QUEUE.containsKey(queueid)) kill((ServerLevel)level());
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand){
		if(level().isClientSide || hand == InteractionHand.OFF_HAND.OFF_HAND) return InteractionResult.PASS;
		UUID current = RailPlacingUtil.CURRENT.get(player.getGameProfile().getId());
		if(current == null || queueid == null) return InteractionResult.SUCCESS;
		if(queueid.equals(current)){
			RailPlacingUtil.NewTrack track = RailPlacingUtil.QUEUE.get(current);
			if(track == null) return InteractionResult.SUCCESS;
			if(player.getMainHandItem().getItem() instanceof RailGaugeItem){
				track.create(UniEntity.getEntity(player), position);
			}
			else track.select(UniEntity.getEntity(player), position);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float f){
		if(source.getDirectEntity() instanceof Player){
			if(queueid != null && queueid.equals(queueid)){
				Player player = (Player)source.getDirectEntity();
				RailPlacingUtil.NewTrack track = RailPlacingUtil.QUEUE.get(queueid);
				if(track != null) track.remove(UniEntity.getEntity(player), position);
				kill(level);
			}
		}
		return false;
	}

	@Override
	public boolean canBeCollidedWith(){
		return true;
	}

}