package net.fexcraft.mod.fvtm.sys.pro;

import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.UniWheel;
import net.fexcraft.mod.fvtm.sys.uni.WheelTireData;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.GRAVITY_20th;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelEntity extends Entity implements IEntityAdditionalSpawnData, UniWheel {

	public RootVehicle root;
	private boolean found;
	private int vehid;
	public WheelTireData wheel;
	public String wheelid;
	protected V3D pos = new V3D();

	public WheelEntity(World world){
		super(world);
		setSize(0.25f, 0.25f);
		stepHeight = 1.125f;
	}

	public WheelEntity(RootVehicle root, String wid){
		this(root.world);
		this.root = root;
		vehid = this.root.getEntityId();
		wheelid = wid;
		wheel = this.root.vehicle.wheeldata.get(wid);
		init();
	}

	private void init(){
		if(root.vehicle.wheeldata.isEmpty()){
			if(!root.isDead){
				EntityItem itemstack = new EntityItem(world, root.posX, root.posY, root.posZ);
				itemstack.setItem(root.vehicle.data.newItemStack().local());
				world.spawnEntity(itemstack); root.setDead();
			}
			return;
		}
		if(!root.vehicle.wheeldata.containsKey(wheelid)){
			setDead();
			return;
		}
		V3D vec = root.vehicle.pivot().get_vector(wheel.pos);
		setPosition(root.posX + vec.x, root.posY + vec.y, root.posZ + vec.z);
		setStepHeight();
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		setDead();
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		//
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
		buffer.writeInt(vehid);
		buffer.writeInt(wheelid.length());
		buffer.writeCharSequence(wheelid, StandardCharsets.UTF_8);
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
		vehid = buffer.readInt();
		wheelid = buffer.readCharSequence(buffer.readInt(), StandardCharsets.UTF_8).toString();
		root = (RootVehicle)world.getEntityByID(vehid);
		if(root == null) return;
		setPosition(root.posX, root.posY, root.posZ);
		wheel = root.vehicle.wheeldata.get(wheelid);
		setStepHeight();
	}

	private void setStepHeight(){
		if(root instanceof LandVehicle == false){
			WheelTireData wtd = root.vehicle.wheeldata.get(wheelid);
			stepHeight = wtd == null ? 0 : wtd.function.step_height;
		}
		else{
			WheelTireData wtd = root.vehicle.wheeldata.get(wheelid);
			LandVehicle veh = (LandVehicle) root;
			stepHeight = wtd == null ? veh.vehicle.data == null ? 1f : veh.vehicle.data.getType().getSphData().wheel_step_height : wtd.function.step_height;
		}
	}

	public boolean isOnTrailer(){
		return root.vehicle.data.getType().isTrailer();
	}

	public double getHorSpeed(){
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}

	@Override
	public void fall(float dis, float dam){
		//
	}

	@Override
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int incr, boolean tele){
		setPosition(x, y, z);
		setRotation(yaw, pitch);
	}

	@Override
	public boolean canBePushed(){
		return false;
	}

	@Override
	public boolean canBeCollidedWith(){
		return false;
	}

	@Override
	public void applyEntityCollision(Entity entity){
		//
	}

	@Override
	public void playStepSound(BlockPos blockpos, Block block){
		//
	}

	@Override
	public void onUpdate(){
		if(world.isRemote && !found){
			root = (RootVehicle)world.getEntityByID(vehid);
			if(root == null) return;
			found = true;
			root.vehicle.wheels.put(wheelid, this);
		}
		if(root == null) return;
		if(!addedToChunk) world.spawnEntity(this);
	}

	@Override
	public void setDead(){
		super.setDead();
	}

	@Override
	public String getName(){
		return "entity.fvtm.wheel." + wheelid;
	}

	@Override
	public void updatePrevPos(){
		pos.x = prevPosX = posX;
		pos.y = prevPosY = posY;
		pos.z = prevPosZ = posZ;
	}

	@Override
	public void remove(){
		setDead();
	}

	@Override
	public boolean isAdded(){
		return addedToChunk;
	}

	@Override
	public V3D pos(){
		return pos;
	}

	@Override
	public void pos(double x, double y, double z){
		setPosition(x, y, z);
	}

	@Override
	public void yaw(float yaw){
		rotationYaw = yaw;
	}

	@Override
	public void prepare(){
		onGround = true;
		motionX *= 0.9;
		motionZ *= 0.9;
		motionY = -GRAVITY_20th;
	}

	@Override
	public void move(){
		move(MoverType.SELF, motionX, motionY, motionZ);
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
