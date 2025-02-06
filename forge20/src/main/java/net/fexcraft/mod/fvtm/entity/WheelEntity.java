package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.sys.uni.WheelTireData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelEntity extends LivingEntity {

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
	public ItemStack getItemBySlot(EquipmentSlot equipmentSlot){
		return ItemStack.EMPTY;
	}

	@Override
	public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack itemStack){

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
		return null;
	}

	@Override
	public boolean canBeCollidedWith(){
		return false;
	}

	@Override
	public float getStepHeight(){
		return stepheight;
	}

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
	public void tick(){
		if(remtimer > 0){
			if(remtimer == 1) kill();
			remtimer--;
		}
		if(level().isClientSide && !found){
			root = (RootVehicle)level().getEntity(vehid);
			if(root == null) return;
			found = true;
			root.wheels.put(wheelid, this);
		}
		if(root == null) return;
	}

	public Vec3 motion(){
		return new Vec3(motionX, motionY, motionZ);
	}

	public double getHorSpeed(){
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}

}