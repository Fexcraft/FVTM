package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.sys.uni.UniWheel;
import net.fexcraft.mod.fvtm.sys.uni.WheelTireData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelEntity extends LivingEntity implements IEntityAdditionalSpawnData, UniWheel {

	public RootVehicle root;
	private boolean found;
	private int vehid;
	public WheelTireData wheel;
	public String wheelid;
	private float stepheight = 1.125f;
	public double motionX;
	public double motionY;
	public double motionZ;
	private int remtimer;

	public WheelEntity(EntityType<?> type, Level level){
		super((EntityType<? extends LivingEntity>)type, level);
	}

	public WheelEntity(RootVehicle veh, String wid){
		super(FvtmGetters.WHEEL_ENTITY.get(), veh.level());
		vehid = (root = veh).getId();
		wheelid = wid;
		wheel = root.vehicle.wheeldata.get(wid);
		setStepHeight();
		//
		if(root.vehicle.wheeldata.isEmpty()){
			if(!root.isRemoved()){
				level().addFreshEntity(new ItemEntity(level(), position().x, position().y, position().z, root.vehicle.data.newItemStack().local()));
				root.kill();
			}
			return;
		}
		if(!root.vehicle.wheeldata.containsKey(wheelid)){
			kill();
			return;
		}
		V3D vec = root.vehicle.pivot().get_vector(wheel.pos);
		setPos(root.position().x + vec.x, root.position().y + vec.y, root.position().z + vec.z);
		setOldPosAndRot();
		Sheep r;
	}

	private void setStepHeight(){
		WheelTireData wtd = root.vehicle.wheeldata.get(wheelid);
		stepheight = wtd == null ? root.spdata == null ? 1f : root.spdata.wheel_step_height : wtd.function.step_height;
	}

	@Override
	protected void defineSynchedData(){
		super.defineSynchedData();
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag){
		remtimer = 40;
	}

	@Override
	public Iterable<ItemStack> getArmorSlots(){
		return Collections.EMPTY_LIST;
	}

	@Override
	public ItemStack getItemBySlot(EquipmentSlot slot){
		return ItemStack.EMPTY;
	}

	@Override
	public void setItemSlot(EquipmentSlot slot, ItemStack itemStack){

	}

	@Override
	public boolean hurt(DamageSource src, float am){
		if(src == this.damageSources().genericKill()){
			setRemoved(RemovalReason.KILLED);
		}
		return false;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag){
		//
	}

	@Override
	public boolean isPickable(){
		return false;
	}

	@Override
	public HumanoidArm getMainArm(){
		return HumanoidArm.RIGHT;
	}

	@Override
	public boolean canBeCollidedWith(){
		return false;
	}

	@Override
	public float getStepHeight(){
		return stepheight;
	}

	@Override
	public void writeSpawnData(FriendlyByteBuf buffer){
		if(wheelid == null){
			buffer.writeInt(0);
			buffer.writeInt(0);
			return;
		}
		buffer.writeInt(vehid);
		buffer.writeInt(wheelid.length());
		buffer.writeCharSequence(wheelid, StandardCharsets.UTF_8);
	}

	@Override
	public void readSpawnData(FriendlyByteBuf buffer){
		vehid = buffer.readInt();
		wheelid = buffer.readCharSequence(buffer.readInt(), StandardCharsets.UTF_8).toString();
		root = (RootVehicle)level().getEntity(vehid);
		if(root == null) return;
		setPos(root.position());
		if(root.vehicle.data == null) return;
		wheel = root.vehicle.wheeldata.get(wheelid);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void tick(){
		if(remtimer > 0){
			if(remtimer == 1) kill();
			remtimer--;
		}
		if(!found){
			root = (RootVehicle)level().getEntity(vehid);
			if(root == null) return;
			found = true;
			root.vehicle.wheels.put(wheelid, this);
		}
		if(root == null || wheel == null) return;
		V3D dest = root.vehicle.pivot().get_vector(wheel.pos);
		dest.x = (dest.x - (position().x - root.position().x)) * 0.5;
		dest.y = (dest.y - (position().y - root.position().y)) * 0.5;
		dest.z = (dest.z - (position().z - root.position().z)) * 0.5;
		if(dest.length() > 0.001){
			if(dest.length() > 16) setPos(position().x + dest.x, position().y + dest.y, position().z + dest.z);
			else move(MoverType.SELF, new Vec3(dest.x, dest.y, dest.z));
		}
	}

	public Vec3 motion(){
		return new Vec3(motionX, motionY, motionZ);
	}

	public double getHorSpeed(){
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}

	@Override
	public void setPrevAsPos(){
		setOldPosAndRot();
	}

	@Override
	public void remove(){
		kill();
	}

}