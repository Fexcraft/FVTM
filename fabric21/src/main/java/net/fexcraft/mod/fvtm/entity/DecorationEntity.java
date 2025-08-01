package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecorationEntity extends Entity {

	public ArrayList<DecorationData> decos = new ArrayList<>();
	protected boolean locked;

	public DecorationEntity(EntityType<?> type, Level level){
		super(type, level);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder){

	}

	@Override
	public void readAdditionalSaveData(ValueInput in){
		decos.clear();
		var list = in.listOrEmpty("decorations", CompoundTag.CODEC);
		if(!list.isEmpty()){
			for(CompoundTag com : list){
				decos.add(FvtmResources.getDecorationData(TagCW.wrap(com)));
			}
		}
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput out){
		if(decos.size() == 0) return;
		var list = out.list("decorations", CompoundTag.CODEC);
		for(DecorationData deco : this.decos) list.add(deco.write(TagCW.create()).local());
	}

	/*@Override
	public void writeSpawnData(FriendlyByteBuf buffer){
		try{
			buffer.writeBoolean(this.locked);
			buffer.writeInt(this.decos.size());
			for(DecorationData deco : this.decos){
				buffer.writeNbt(deco.write(TagCW.create()).local());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void readSpawnData(FriendlyByteBuf buffer){
		try{
			locked = buffer.readBoolean();
			decos.clear();
			int amount = buffer.readInt();
			for(int i = 0; i < amount; i++){
				this.decos.add(FvtmResources.getDecorationData(TagCW.wrap(buffer.readNbt())));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}*/

	@Override
	public boolean isPickable(){
		return true;
	}

	public InteractionResult interact(Player player, InteractionHand hand){
		if(isRemoved() || level().isClientSide || hand == InteractionHand.OFF_HAND){
			return InteractionResult.PASS;
		}
		ItemStack stack = player.getItemInHand(hand);
		/*if(!stack.isEmpty() && stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getContent().isVehicleKey()){
			this.locked = !this.locked;
			player.sendSystemMessage(Component.literal("Toggled Deco Lock status."));
			return InteractionResult.SUCCESS;
		}
		if(this.locked){
			player.sendSystemMessage(Component.literal("Deco is locked."));
			return InteractionResult.SUCCESS;
		}*/
		if(stack.isEmpty() || stack.getItem() instanceof DecorationItem){
			if(stack.getItem() instanceof DecorationItem){
				DecorationData data = ((DecorationItem)stack.getItem()).getData(UniStack.getStack(stack));
				if(data != null){
					decos.add(data);
					updateClient();
				}
			}
			UniEntity.getEntity(player).openUI(UIKeys.DECORATION_EDITOR.key, new V3I(getId(), 0, 0));
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float am){
		if(source.getDirectEntity() instanceof Player){
			if(this.locked){
				//TODO source.getDirectEntity().sendSystemMessage(Component.literal("Deco is locked."));
				return true;
			}
			//ItemStack stack = getPickedResult(null);
			for(DecorationData deco : decos){
				ItemEntity entity = new ItemEntity(EntityType.ITEM, level());
				entity.setPos(position().add(0.0D, 0.25D, 0.0D));
				entity.setItem(deco.getNewStack().local());
				level().addFreshEntity(entity);
			}
			kill(level);
			return true;
		}
		return false;
	}

	@Override
	public boolean canBeCollidedWith(Entity entity){
		return true;
	}

	public void updateClient(){
		TagCW com = TagCW.create();
		addAdditionalSaveData(com.local());
		com.set("entid", getId());
		Packets.sendToAll(Packet_TagListener.class, "deco", TagCW.wrap(com));//TODO change to ranged packet
	}

}