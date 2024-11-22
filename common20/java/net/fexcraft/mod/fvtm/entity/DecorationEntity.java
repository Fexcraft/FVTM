package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecorationEntity extends Entity {

	public ArrayList<DecorationData> decos = new ArrayList<>();
	protected boolean locked;

	protected DecorationEntity(EntityType<?> type, Level level){
		super(type, level);
	}

	@Override
	protected void defineSynchedData(){

	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag){
		this.decos.clear();
		if(tag.contains("decorations")){
			ListTag list = (ListTag)tag.get("decorations");
			for(int i = 0; i < list.size(); i++){
				this.decos.add(FvtmResources.getDecorationData(TagCW.wrap(list.get(i))));
			}
		}
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag){
		if(this.decos.size() == 0) return;
		ListTag list = new ListTag();
		for(DecorationData deco : this.decos) list.add(deco.write(TagCW.create()).local());
		tag.put("decorations", list);
	}

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
	public Packet<ClientGamePacketListener> getAddEntityPacket(){
		return new ClientboundAddEntityPacket(this);
	}

	@Override
	public boolean isPickable(){
		return true;
	}

	public InteractionResult interact(Player player, InteractionHand hand){
		if(isRemoved() || level().isClientSide || hand == InteractionHand.OFF_HAND){
			return InteractionResult.PASS;
		}
		ItemStack stack = player.getItemInHand(hand);
		if(!stack.isEmpty() && stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getContent().isVehicleKey()){
			this.locked = !this.locked;
			player.sendSystemMessage(Component.literal("Toggled Deco Lock status."));
			return InteractionResult.SUCCESS;
		}
		if(this.locked){
			player.sendSystemMessage(Component.literal("Deco is locked."));
			return InteractionResult.SUCCESS;
		}
		if(stack.isEmpty() || stack.getItem() instanceof DecorationItem){
			if(stack.getItem() instanceof DecorationItem){
				DecorationData data = ((DecorationItem)stack.getItem()).getData(StackWrapper.wrap(stack));
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
	public boolean hurt(DamageSource source, float am){
		if(level().isClientSide || isRemoved()) return false;
		if(source.getDirectEntity() instanceof Player){
			if(this.locked){
				source.getDirectEntity().sendSystemMessage(Component.literal("Deco is locked."));
				return true;
			}
			//ItemStack stack = getPickedResult(null);
			for(DecorationData deco : decos){
				ItemEntity entity = new ItemEntity(EntityType.ITEM, level());
				entity.setPos(position().add(0.0D, 0.25D, 0.0D));
				entity.setItem(deco.getNewStack().local());
				level().addFreshEntity(entity);
			}
			kill();
			return true;
		}
		return false;
	}

	@Override
	public boolean canBeCollidedWith(){
		return true;
	}

	public void updateClient(){
		TagCW com = TagCW.create();
		addAdditionalSaveData(com.local());
		com.set("entid", getId());
		Packets.sendToAll(Packet_TagListener.class, "deco", TagCW.wrap(com));//TODO change to ranged packet
	}

}