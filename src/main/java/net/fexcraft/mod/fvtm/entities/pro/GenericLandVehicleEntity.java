package net.fexcraft.mod.fvtm.entities.pro;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.entities.CameraEntity;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.entities.WheelEntity;
import net.fexcraft.mod.fvtm.util.FvtmPermissions;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class GenericLandVehicleEntity extends Entity implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate>, LockableObject, Vehicle.VehicleEntity {

	private static final DataParameter<Float> THROTTLE = EntityDataManager.<Float>createKey(GenericLandVehicleEntity.class, DataSerializers.FLOAT);
	//
	private SeatEntity[] seats;
	private WheelEntity[] wheels;
	private Vehicle.VehicleData vehicledata;
	public VehicleAxes axes;
	private VehicleAxes prevaxes;
	public float prevRotationRoll;

	public GenericLandVehicleEntity(World world){
		super(world);
		axes = new VehicleAxes();
		prevaxes = new VehicleAxes();
		preventEntitySpawning = true;
		setSize(1F, 1F);
		if(world.isRemote){ setRenderDistanceWeight(Double.MAX_VALUE); }
		ignoreFrustumCheck = true;
		stepHeight = 1.0f;
	}

	public GenericLandVehicleEntity(World world, Vehicle.VehicleData data){
		this(world);
		this.vehicledata = data;
		this.initData();
	}

	@Override
	protected void entityInit(){
		this.dataManager.register(THROTTLE, 0f);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		axes = VehicleAxes.read(this, compound);
		prevRotationYaw = axes.getYaw();
		prevRotationPitch = axes.getPitch();
		prevRotationRoll = axes.getRoll();
		vehicledata = vehicledata == null ? vehicledata.readFromNBT(compound, world.isRemote) : Resources.getVehicleData(compound, world.isRemote);
		this.initData();
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		axes.write(this, vehicledata.writeToNBT(compound));
	}

	protected void initData(){
		this.wheels = new WheelEntity[vehicledata.getWheelPos().size()];
		this.seats = new SeatEntity[vehicledata.getSeats().size()];
		if(!world.isRemote){
			for(int i = 0; i < vehicledata.getSeats().size(); i++){
				if(seats[i] == null){
					world.spawnEntity(seats[i] = new SeatEntity(world, this, i));
				}
			}
			for(int i = 0; i < wheels.length; i++){
				if(wheels[i] == null){
					world.spawnEntity(wheels[i] = new WheelEntity(world, this, i));
				}
			}
		}
		stepHeight = vehicledata.getVehicle().getFMWheelStepHeight();
		vehicledata.getScripts().forEach((script) -> script.onCreated(this, vehicledata));
	}

	@Override
	public void onUpdate(){
		super.onUpdate();
		//TODO
	}

	public boolean attackEntityFrom(DamageSource damagesource, float i){
		if(world.isRemote || isDead){
			return true;
		}
		if(damagesource.damageType.equals("player") && damagesource.getImmediateSource().onGround && (seats[0] == null || seats[0].getControllingPassenger() == null)){
			if(vehicledata.isLocked()){
				Print.chat(damagesource.getImmediateSource(), "Vehicle is locked. Unlock to remove it.");
				return false;
			}
			else{
				if(vehicledata.getPart("engine") != null){
					vehicledata.getPart("engine").getAttributeData(EngineAttribute.EngineAttributeData.class).setOn(false);
				}
				vehicledata.getScripts().forEach((script) -> script.onRemove(this, vehicledata));
				ItemStack stack = vehicledata.getVehicle().getItemStack(vehicledata);
				//
				PlayerPerms pp = PermManager.getPlayerPerms((EntityPlayer)damagesource.getImmediateSource());
				boolean brk = pp.hasPermission(FvtmPermissions.LAND_VEHICLE_BREAK) ? pp.hasPermission(FvtmPermissions.permBreak(stack)) : false;
				if(brk){
					entityDropItem(stack, 0.5F);
					setDead();
					Print.debug(stack.toString());
					//
					if(this.getEntityAtRear() != null){
						Entity ent = this.getEntityAtRear().getEntity();
						Vehicle.VehicleData rear = this.getEntityAtRear().getVehicleData();
						rear.getScripts().forEach((script) -> script.onRemove(ent, rear));
						ItemStack trailerstack = rear.getVehicle().getItemStack(rear);
						ent.entityDropItem(trailerstack, 0.5F);
						ent.setDead();
						Print.debug(trailerstack.toString());
					}
					return true;
				}
				else{
					Print.chat(damagesource.getImmediateSource(), "No permission to break this vehicle/type.");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void setDead(){
		super.setDead();
		for(SeatEntity seat : getSeats()){ if(seat != null){ seat.setDead(); } }
		for(WheelEntity wheel : getWheels()){ if(wheel != null){ wheel.setDead();}  }
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer player){ return; }

	@Override
	public boolean canBeCollidedWith(){ return !isDead; }

	@Override
	public void applyEntityCollision(Entity entity){ return; }

	@Override
	public void setVelocity(double x, double y, double z){
		motionX = x; motionY = y; motionZ = z;
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult target){
		ItemStack stack = vehicledata.getVehicle().getItemStack(vehicledata);
		stack.setItemDamage(0);
		return stack;
	}

	@Override
	public String getName(){
		return vehicledata.getVehicle().getName();
	}

	//ADDITIONALDATA

	@Override
	public void writeSpawnData(ByteBuf buffer){
		ByteBufUtils.writeTag(buffer, axes.write(this, vehicledata.writeToNBT(new NBTTagCompound())));
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
		try{
			NBTTagCompound compound = ByteBufUtils.readTag(buffer);
			vehicledata = Resources.getVehicleData(compound, world.isRemote);
			axes = VehicleAxes.read(this, compound);
			prevRotationYaw = axes.getYaw();
			prevRotationPitch = axes.getPitch();
			prevRotationRoll = axes.getRoll();
			initData();
		}
		catch(Exception e){
			e.printStackTrace();
			Print.debug("Failed to receive additional spawn data for this vehicle!");
		}
	}

	//LOCKOBJ

	@Override
	public boolean isLocked(){
		return vehicledata.isLocked();
	}

	@Override
	public boolean unlock(World world, EntityPlayer entity, ItemStack stack, KeyItem item) {
		if(!stack.hasTagCompound()){
			Print.chat(entity, "[ERROR] Key don't has a NBT Tag Compound!");
			return false;
		}
		else{
			switch(item.getType(stack)){
				case PRIVATE:
					if(entity.getGameProfile().getId().toString().equals(item.getCreator(stack).toString())){
						Print.chat(entity, "This key can only be used by the Owner;");
						return false;
					}
					else{
						if(item.getCode(stack).equals(vehicledata.getLockCode())){
							vehicledata.setLocked(false);
							Print.chat(entity, "Vehicle is now unlocked.");
							return true;
						}
						else{
							Print.chat(entity, "Wrong key.\n[V:" + vehicledata.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
							return false;
						}
					}
				case COMMON:
					if(item.getCode(stack).equals(vehicledata.getLockCode())){
						vehicledata.setLocked(false);
						Print.chat(entity, "Vehicle is now unlocked.");
						return true;
					}
					else{
						Print.chat(entity, "Wrong key.\n[V:" + vehicledata.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
						return false;
					}
				case ADMIN:
					vehicledata.setLocked(false);
					Print.chat(entity, "[SU] Vehicle is now unlocked.");
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean lock(World world, EntityPlayer entity, ItemStack stack, KeyItem item) {
		if(!vehicledata.allowsLocking()){
			Print.chat(entity, "This vehicle doesn't allow locking.");
			return false;
		}
		else{
			if(!stack.hasTagCompound()){
				Print.chat(entity, "[ERROR] Key don't has a NBT Tag Compound!");
				return false;
			}
			else{
				switch(item.getType(stack)){
					case PRIVATE:
						if(entity.getGameProfile().getId().toString().equals(item.getCreator(stack).toString())){
							Print.chat(entity, "This key can only be used by the Owner;");
							return false;
						}
						else{
							if(item.getCode(stack).equals(vehicledata.getLockCode())){
								vehicledata.setLocked(true);
								Print.chat(entity, "Vehicle is now locked.");
								return true;
							}
							else{
								Print.chat(entity, "Wrong key.\n[V:" + vehicledata.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
								return false;
							}
						}
					case COMMON:
						if(item.getCode(stack).equals(vehicledata.getLockCode())){
							vehicledata.setLocked(true);
							Print.chat(entity, "Vehicle is now locked.");
							return true;
						}
						else{
							Print.chat(entity, "Wrong key.\n[V:" + vehicledata.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
							return false;
						}
					case ADMIN:
						vehicledata.setLocked(true);
						Print.chat(entity, "[SU] Vehicle is now locked.");
						return true;
				}
			}
		}
		return false;
	}

	//VEHENTITY

	@Override
	public Vehicle.VehicleData getVehicleData(){
		return vehicledata;
	}

	@Override
	public Vehicle.VehicleType getVehicleType(){
		return Vehicle.VehicleType.LAND;
	}

	@Override
	public Entity getEntity(){
		return this;
	}

	@Override
	public VehicleAxes getAxes() {
		return axes;
	}

	@Override
	public WheelEntity[] getWheels(){
		return wheels;
	}

	@Override
	public SeatEntity[] getSeats(){
		return seats;
	}

	@Override
	public boolean onKeyPress(int key, int seat, EntityPlayer player){
		return false;
	}

	@Override
	public Entity getCamera(){
		return null;
	}

	@Override
	public double getThrottle(){
		return this.dataManager.get(THROTTLE);
	}

	@Override
	public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, double avelx, double avely, double avelz, double throttle, float steeringYaw) {

	}

	@Override
	public Vehicle.VehicleEntity getEntityAtFront(){
		return null;
	}

	@Override
	public Vehicle.VehicleEntity getEntityAtRear(){
		return null;
	}

	@Override
	public Vec3d getAngularVelocity(){
		return null;
	}

	@Override
	public float getWheelsAngle(){
		return 0;
	}

	@Override
	public float getWheelsYaw(){
		return 0;
	}

}
