package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.mod.fcl.util.FclCodecs;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.EntityW;
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
public class RoadMarker extends Entity {

	public QV3D position;
	public UUID queueid;

	public RoadMarker(EntityType<RoadMarker> type, Level level){
		super(type, level);
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
		if(queueid == null || !RoadPlacingUtil.QUEUE.containsKey(queueid)) kill((ServerLevel)level());
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand){
		if(level().isClientSide || hand == InteractionHand.OFF_HAND.OFF_HAND) return InteractionResult.PASS;
		UUID current = RoadPlacingUtil.CURRENT.get(player.getGameProfile().getId());
		if(current == null || queueid == null) return InteractionResult.SUCCESS;
		if(queueid.equals(current)){
			RoadPlacingUtil.NewRoad road = RoadPlacingUtil.QUEUE.get(current);
			if(road == null) return InteractionResult.SUCCESS;
			EntityW pass = UniEntity.getEntity(player);
			if(player.getMainHandItem().getItem() instanceof RoadToolItem){
				road.create(pass, position, pass.getHeldItem(true));
			}
			else road.select(pass, position);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float f){
		if(source.getDirectEntity() instanceof Player){
			if(queueid != null && queueid.equals(queueid)){
				Player player = (Player)source.getDirectEntity();
				RoadPlacingUtil.NewRoad road = RoadPlacingUtil.QUEUE.get(queueid);
				if(road != null) road.remove(UniEntity.getEntity(player), position);
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