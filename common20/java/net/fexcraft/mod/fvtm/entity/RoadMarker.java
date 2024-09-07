package net.fexcraft.mod.fvtm.entity;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fcl.util.EntityUtil;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
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
public class RoadMarker extends Entity {

	public QV3D position;
	public UUID queueid;

	protected RoadMarker(EntityType<? extends RoadMarker> type, Level level){
		super(type, level);
	}

	@Override
	protected void defineSynchedData(){

	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag){
		if(tag.contains("uuid0")){
			queueid = new UUID(tag.getLong("uuid0"), tag.getLong("uuid1"));
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

	public void writeSpawnData(ByteBuf buffer){
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

	public void readSpawnData(ByteBuf buffer){
		try{
			long m = buffer.readLong(), l = buffer.readLong();
			if(m == 0 && l == 0) queueid = null;
			else queueid = new UUID(m, l);
			position = new QV3D(buffer.readDouble(), buffer.readDouble(), buffer.readDouble(), 0);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.tick();
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket(){
		return new ClientboundAddEntityPacket(this);
	}

	@Override
	public boolean isPickable(){
		return true;
	}

	@Override
	public void baseTick(){
		super.baseTick();
		if(level().isClientSide) return;
		if(queueid == null || !RoadPlacingUtil.QUEUE.containsKey(queueid)) kill();
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand){
		if(level().isClientSide || hand == InteractionHand.OFF_HAND.OFF_HAND) return InteractionResult.PASS;
		UUID current = RoadPlacingUtil.CURRENT.get(player.getGameProfile().getId());
		if(current == null || queueid == null) return InteractionResult.SUCCESS;
		if(queueid.equals(current)){
			RoadPlacingUtil.NewRoad road = RoadPlacingUtil.QUEUE.get(current);
			if(road == null) return InteractionResult.SUCCESS;
			if(player.getMainHandItem().getItem() instanceof RoadToolItem){
				road.create(EntityUtil.get(player), position, StackWrapper.wrap(player.getMainHandItem()));
			}
			else road.select(EntityUtil.get(player), position);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public boolean hurt(DamageSource source, float am){
		if(level().isClientSide || isRemoved()){
			return true;
		}
		if(source.getDirectEntity() instanceof Player){
			if(queueid != null && queueid.equals(queueid)){
				Player player = (Player)source.getDirectEntity();
				RoadPlacingUtil.NewRoad road = RoadPlacingUtil.QUEUE.get(queueid);
				if(road != null) road.remove(EntityUtil.get(player), position);
				kill();
			}
		}
		return false;
	}

	@Override
	public boolean canBeCollidedWith(){
		return true;
	}

}