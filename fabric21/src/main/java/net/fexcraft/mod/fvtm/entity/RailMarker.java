package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.mod.fcl.util.FclCodecs;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.util.ClientAddEntity;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.fvtm.util.SpawnPacketEntity;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.UUID;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailMarker extends Entity implements SpawnPacketEntity {

	public QV3D position;
	public UUID queueid;

	public RailMarker(EntityType<RailMarker> type, Level level){
		super(type, level);
	}

	@Override
	public void recreateFromPacket(ClientboundAddEntityPacket packet){
		super.recreateFromPacket(packet);
		readSpawnData(((ClientAddEntity)packet).getFvtmData());
	}

	@Override
	public void readAdditionalSaveData(ValueInput in){
		queueid = new UUID(in.getLongOr("uuid0", 0l), in.getLongOr("uuid1", 0l));
		in.read("position", FclCodecs.V3D).ifPresent(pos -> position = new QV3D(pos));
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput out){
		if(queueid != null){
			out.putLong("uuid0", queueid.getMostSignificantBits());
			out.putLong("uuid1", queueid.getLeastSignificantBits());
		}
		if(position != null){
			out.store("position", FclCodecs.V3D, position.vec);
		}
	}

	@Override
	public void writeSpawnData(TagCW com){
		try{
			if(queueid != null){
				com.set("uuid0", queueid.getMostSignificantBits());
				com.set("uuid1", queueid.getLeastSignificantBits());
			}
			com.set("pos", position.vec);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void readSpawnData(TagCW com){
		try{
			if(com.has("uuid0")){
				queueid = new UUID(com.getLong("uuid0"), com.getLong("uuid1"));
			}
			position = new QV3D(com.getV3D("pos"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.tick();
	}

	/*@Override
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
	public boolean canBeCollidedWith(Entity entity){
		return true;
	}

}