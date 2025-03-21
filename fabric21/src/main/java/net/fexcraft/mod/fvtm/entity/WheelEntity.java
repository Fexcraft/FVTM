package net.fexcraft.mod.fvtm.entity;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.sys.uni.UniWheel;
import net.fexcraft.mod.fvtm.sys.uni.WheelTireData;
import net.fexcraft.mod.fvtm.util.SpawnPacket;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Collections;

import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.GRAVITY_20th;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelEntity extends Entity implements UniWheel, SpawnPacket.PacketEntity {

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
	private int synctimer;
	protected V3D pos = new V3D();

	public WheelEntity(EntityType<WheelEntity> type, Level level){
		super(type, level);
	}

	public WheelEntity assign(RootVehicle veh, String wid){
		vehid = (root = veh).getId();
		wheelid = wid;
		wheel = root.vehicle.wheeldata.get(wid);
		setStepHeight();
		//
		if(root.vehicle.wheeldata.isEmpty()){
			if(!root.isRemoved()){
				level().addFreshEntity(new ItemEntity(level(), position().x, position().y, position().z, root.vehicle.data.newItemStack().local()));
				root.kill((ServerLevel)level());
			}
			return this;
		}
		if(!root.vehicle.wheeldata.containsKey(wheelid)){
			remtimer = 100;
			return this;
		}
		/*V3D vec = root.vehicle.pivot().get_vector(wheel.pos);
		setPos(root.position().x + vec.x, root.position().y + vec.y, root.position().z + vec.z);
		setOldPosAndRot();*/
		return this;
	}

	private void setStepHeight(){
		WheelTireData wtd = root.vehicle.wheeldata.get(wheelid);
		stepheight = wtd == null ? root.vehicle.spdata == null ? 1f : root.vehicle.spdata.wheel_step_height : wtd.function.step_height;
		//getAttributes().getInstance(Attributes.STEP_HEIGHT).setBaseValue(stepheight);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag){
		wheelid = tag.getString("wheelid");
		remtimer = 100;
	}

	/*@Override
	public Iterable<ItemStack> getArmorSlots(){
		return Collections.EMPTY_LIST;
	}

	@Override
	public ItemStack getItemBySlot(EquipmentSlot slot){
		return ItemStack.EMPTY;
	}

	@Override
	public void setItemSlot(EquipmentSlot slot, ItemStack itemStack){}

	@Override
	public HumanoidArm getMainArm(){
		return HumanoidArm.RIGHT;
	}*/

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float f){
		if(source == this.damageSources().genericKill()){
			setRemoved(RemovalReason.KILLED);
		}
		return false;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag){
		tag.putString("wheelid", wheelid);
	}

	@Override
	public boolean isPickable(){
		return false;
	}

	@Override
	public boolean canBeCollidedWith(){
		return false;
	}

	@Override
	public void writeSpawnData(TagCW com){
		if(wheelid == null) return;
		com.set("veh", vehid);
		com.set("id", wheelid);
	}

	@Override
	public void readSpawnData(TagCW com){
		vehid = com.getInteger("veh");
		wheelid = com.getString("id");
		root = (RootVehicle)level().getEntity(vehid);
		if(root == null) return;
		setPos(root.position());
		if(root.vehicle.data == null) return;
		wheel = root.vehicle.wheeldata.get(wheelid);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder){
		//
	}

	@Override
	public void tick(){
		if(remtimer > 0){
			if(remtimer == 1) kill((ServerLevel)level());
			remtimer--;
			return;
		}
		if(!found){
			if(level().isClientSide && vehid == 0 && synctimer < 1){
				ClientPlayNetworking.send(new SpawnPacket((Entity)this));
				synctimer = 10;
			}
			synctimer--;
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
	public void updatePrevPos(){
		setOldPosAndRot();
		pos.x = position().x;
		pos.y = position().y;
		pos.z = position().z;
	}

	@Override
	public void remove(){
		kill((ServerLevel)level());
	}

	@Override
	public boolean isAdded(){
		return true;//TODO
	}

	@Override
	public V3D pos(){
		return pos;
	}

	@Override
	public void pos(double x, double y, double z){
		setPos(x, y, z);
	}

	@Override
	public void yaw(float yaw){
		setYRot(yaw);
	}

	@Override
	public void prepare(){
		setOnGround(true);
		motionX *= 0.9;
		motionZ *= 0.9;
		motionY = -GRAVITY_20th;
	}

	@Override
	public void move(){
		move(MoverType.SELF, motion());
	}

	@Override
	public WheelTireData wtd(){
		return wheel;
	}

	@Override
	public void addMotion(double x, double y, double z){
		motionX += x;
		motionY += y;
		motionZ += z;
	}

	@Override
	public void setMotion(double x, double y, double z){
		motionX = x;
		motionY = y;
		motionZ = z;
	}

}