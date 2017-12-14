package net.fexcraft.mod.fvtm.entities;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Fuel.FuelItem;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.FvtmPermissions;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleControl;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleKeyPress;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LandVehicleEntity extends Entity implements VehicleEntity, IEntityAdditionalSpawnData, LockableObject, IPacketReceiver<PacketEntityUpdate> {
	
	public boolean sync = true;
	public int serverPositionTransitionTicker;
	public double serverPosX, serverPosY, serverPosZ;
	public double serverYaw, serverPitch, serverRoll;
	public VehicleData vehicledata;
	public double throttle;
	public SeatEntity[] seats;
	public WheelEntity[] wheels;
	public boolean fuelling;
	public float prevRotationRoll;
	public Vec3d angularVelocity = new Vec3d(0F, 0F, 0F);
	public boolean leftMouseHeld = false, rightMouseHeld = false;
	public VehicleAxes prevAxes, axes;
	private float yOffset;
	//
	@SideOnly(Side.CLIENT)
	public Entity camera;
	public float wheelsYaw;
	public float wheelsAngle;
	public int doorToggleTimer = 0;
	public VehicleEntity trailer;
	
	public LandVehicleEntity(World world){
		super(world);
		axes = new VehicleAxes();
		prevAxes = new VehicleAxes();
		preventEntitySpawning = true;
		setSize(1F, 1F);
		yOffset = 6F / 16F;
		ignoreFrustumCheck = true;
		if(world.isRemote){
			setRenderDistanceWeight(200D);
		}
		//
		stepHeight = 1.0F;
	}
	
	private LandVehicleEntity(World world, VehicleData type){
		this(world);
		vehicledata = type;
	}
	
	//From Item;
	public LandVehicleEntity(World world, double x, double y, double z, EntityPlayer placer, VehicleData vehicleData){
		this(world, vehicleData);
		stepHeight = 1.0F;
		setPosition(x, y, z);
		rotateYaw(placer.rotationYaw + 90F);
		initType(vehicleData, false);
	}
	
	//From Constructor;
	public LandVehicleEntity(World world, double x, double y, double z, int placer, VehicleData data){
		this(world, data);
		stepHeight = 1.0F;
		setPosition(x, y, z);
		rotateYaw((placer * 90f) + 90F);
		initType(data, false);
		Print.debugChat("SPAWNING");
	}

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
			initType(vehicledata, true);
		}
		catch(Exception e){
			e.printStackTrace();
			Print.debug("Failed to receive additional spawn data for this vehicle!");
		}
		
		camera = new CameraEntity(world, this);
		world.spawnEntity(camera);
		
	}
	
	protected void initType(VehicleData type, boolean remote){
		seats = new SeatEntity[type.getSeats().size()];
		wheels = new WheelEntity[type.getWheelPos().size()];
		if(!remote){
			for(int i = 0; i < type.getSeats().size(); i++){
				world.spawnEntity(seats[i] = new SeatEntity(world, this, i));
			}
			for(int i = 0; i < wheels.length; i++){
				world.spawnEntity(wheels[i] = new WheelEntity(world, this, i));
			}
		}
		stepHeight = type.getVehicle().getFMWheelStepHeight();
		yOffset = 10F / 16F;//TODO check dis
		vehicledata.getScripts().forEach((script) -> script.onCreated(this, vehicledata));
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag){
		tag = vehicledata.writeToNBT(tag);
		axes.write(this, tag);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag){
		if(vehicledata == null){
			vehicledata = Resources.getVehicleData(tag, world.isRemote);
		}
		else{
			vehicledata.readFromNBT(tag, world.isRemote);
		}
		prevRotationYaw = tag.getFloat("RotationYaw");
		prevRotationPitch = tag.getFloat("RotationPitch");
		prevRotationRoll = tag.getFloat("RotationRoll");
		axes = VehicleAxes.read(this, tag);
		initType(vehicledata, false);
	}
	
	public boolean isSeatFree(int seat){
		return vehicledata.getSeats().size() >= seat && seats[seat].getControllingPassenger() == null;
	}
	
	@Override
	protected boolean canTriggerWalking(){
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBox(Entity entity){
		return entity.getEntityBoundingBox();
	}

	@Override
    public boolean canBePushed(){
        return false;
    }

	@Override
	public double getMountedYOffset(){
		return 0D;
	}
	
	@Override
    public double getYOffset(){
    	return yOffset;
    }
	
	@Override
	public void setDead(){
		super.setDead();
		if(world.isRemote){
			camera.setDead();
		}
		for(SeatEntity seat : seats){
			if(seat != null){
				seat.setDead();
			}
		}
		for(WheelEntity wheel : wheels){
			if(wheel != null){
				wheel.setDead();
			}
		}
		vehicledata.getScripts().forEach((script) -> script.onRemove(this, vehicledata));
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer){
		//
	}

	@Override
	public boolean canBeCollidedWith(){
		return !isDead;
	}
	
	@Override
	public void applyEntityCollision(Entity entity){
		if(!isPartOfThis(entity)){
			super.applyEntityCollision(entity);
		}
	}
	
	@Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport){
		if(ticksExisted > 1){
			return;
		}
		if(!this.getPassengers().isEmpty() && this.getControllingPassenger() instanceof EntityPlayer){
			//
		}
		else{				
			if(sync){
				serverPositionTransitionTicker = posRotationIncrements + 5;
			}
			else{
				double var10 = x - posX; double var12 = y - posY; double var14 = z - posZ;
				double var16 = var10 * var10 + var12 * var12 + var14 * var14;
				if (var16 <= 1.0D){
					return;
				}
				serverPositionTransitionTicker = 3;
			}
			serverPosX = x;
			serverPosY = y;
			serverPosZ = z;
			serverYaw = yaw;
			serverPitch = pitch;
		}
	}
	
	@Override
	public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, double avelx, double avely, double avelz, double throttle2, float steeringYaw){
		if(world.isRemote){
			serverPosX = x;
			serverPosY = y;
			serverPosZ = z;
			serverYaw = yaw;
			serverPitch = pitch;
			serverRoll = roll;
			serverPositionTransitionTicker = 5;
		}
		else{
			setPosition(x, y, z);
			prevRotationYaw = yaw;
			prevRotationPitch = pitch;
			prevRotationRoll = roll;
			setRotation(yaw, pitch, roll);
		}
		motionX = motX;
		motionY = motY;
		motionZ = motZ;
		angularVelocity = new Vec3d(avelx, avely, avelz);
		throttle = throttle2;
		//
		wheelsYaw = steeringYaw;
	}
	

	@Override
	public void setVelocity(double d, double d1, double d2){
		motionX = d;
		motionY = d1;
		motionZ = d2;
	}
	
	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
		if(isDead || world.isRemote || hand == EnumHand.OFF_HAND){
			return false;
		}
		ItemStack stack = player.getHeldItem(hand);
		if(!stack.isEmpty() && stack.getItem() instanceof KeyItem){
			if(this.isLocked()){
				this.unlock(world, player, stack, (KeyItem)stack.getItem());
			}
			else{
				this.lock(world, player, stack, (KeyItem)stack.getItem());
			}
			return true;
		}
		if(vehicledata.isLocked()){
			Print.chat(player, "Vehicle is locked.");
			return true;
		}
		if(!stack.isEmpty()){
			if(stack.getItem() instanceof FuelItem){
				player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_INVENTORY, world, 2, 0, 0);//Fuel Inventory.
				return true;
			}
			if(stack.getItem() instanceof VehicleItem){
				if(this.vehicledata.getRearConnector() != null && this.getEntityAtRear() == null && ((VehicleItem)stack.getItem()).getVehicle(stack).getVehicle().isTrailerOrWagon()){
					Print.chat(player, "Connecting...");
					LandVehicleTrailer trailer = new LandVehicleTrailer(world, ((VehicleItem)stack.getItem()).getVehicle(stack), this);
					world.spawnEntity(trailer);
					stack.shrink(64);
					return true;
				}
			}
		}
		if(!vehicledata.getScripts().isEmpty()){
			for(VehicleScript script : vehicledata.getScripts()){
				if(script.onInteract(this, vehicledata, player)){
					return true;
				}
			}
		}
		//TODO Item interaction
		for(int i = 0; i <= vehicledata.getSeats().size(); i++){
			if(seats[i] != null && seats[i].processInitialInteract(player, hand)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean onKeyPress(int key, int seat, EntityPlayer player){
		//Print.debug("V: " + key + " " + seat + " " + player.getName() + " [" + Time.getDate() + "];");
		if(seat != 0 && key != 6){
			return false;
		}
		try{
			if(world.isRemote && key >= 6){
				PacketHandler.getInstance().sendToServer(new PacketVehicleKeyPress(key));
				return true;
			}
			switch(key){
				case 0:{//Accelerate;
					throttle += 0.01F;
					if(throttle > 1F){
						throttle = 1F;
					}
					return true;
				}
				case 1:{//Decelerate
					throttle -= 0.01F;
					if(throttle < -1F){
						throttle = -1F;
					}
					if(throttle < 0F && vehicledata.getVehicle().getFMMaxNegativeThrottle() == 0F){
						throttle = 0F;
					}
					return true;
				}
				case 2:{//Left
					wheelsYaw -= 1F;
					return true;
				}
				case 3:{//Right
					wheelsYaw += 1F;
					return true;
				}
				case 4:{//Brake
					throttle *= 0.8F;
					if(onGround){
						motionX *= 0.8F;
						motionZ *= 0.8F;
					}
					if(throttle < -0.0001){
						throttle = 0;
					}
					return true;
				}
				case 5:{//Toggle Engine
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("task", "engine_toggle");
					ApiUtil.sendEntityUpdatePacketToServer(this, nbt);
					return true;
				}
				case 6:{//Exit
					player.dismountRidingEntity();
			  		return true;
				}
				case 7:{//Inventory
					if(!world.isRemote){
						if(this.vehicledata.getPart("engine") != null && this.vehicledata.getPart("engine").getAttributeData(EngineAttributeData.class).isOn()){
							Print.chat(player, "Turn engine off first!");
						}
						else{
							player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_INVENTORY, world, 0, 0, 0);
						}
						//open inventory
					}
					return true;
				}
				case 10:{
					if(!world.isRemote){
						if(doorToggleTimer <= 0){
							vehicledata.toggleDoors(null);
							if(this.trailer != null){
								this.trailer.getVehicleData().toggleDoors(vehicledata.doorsOpen());
							}
							player.sendMessage(new TextComponentString("Doors " + (vehicledata.doorsOpen() ? "opened" : "closed") + "."));
							doorToggleTimer = 10;
							PacketHandler.getInstance().sendToAllAround(new PacketVehicleControl(this), Resources.getTargetPoint(this));
						}
					}
					return true;
				}
			}
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	private boolean driverIsCreative(){
		try{
			return seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer)seats[0].getControllingPassenger()).capabilities.isCreativeMode;
		}
		catch(Exception e){
			return false;
		}
	}
		
	@Override
    public void onUpdate(){
        super.onUpdate();
        if(!world.isRemote){
        	for(int i = 0; i < vehicledata.getSeats().size(); i++){
        		if(seats[i] == null || !seats[i].addedToChunk){
        			seats[i] = new SeatEntity(world, this, i);
    				world.spawnEntity(seats[i]);
        		}
        	}
        	for(int i = 0; i < vehicledata.getWheelPos().size(); i++){
        		if(wheels[i] == null || !wheels[i].addedToChunk){
        			wheels[i] = new WheelEntity(world, this, i);
    				world.spawnEntity(wheels[i]);
        		}
        	}
        }
        //
		prevRotationYaw = axes.getYaw();
		prevRotationPitch = axes.getPitch();
		prevRotationRoll = axes.getRoll();		
		prevAxes = axes.clone();
		//
		boolean canThrust = driverIsCreative() || vehicledata.getFuelTankContent() > 0;
		if(seats == null || seats.length == 0){
			this.setDead();
			return;
		}
		if((seats[0] != null && seats[0].getControllingPassenger() == null) || !canThrust && vehicledata.getVehicle().getFMMaxPositiveThrottle() != 0 && vehicledata.getVehicle().getFMMaxPositiveThrottle() != 0){
			throttle *= 0.98F;
			rightMouseHeld = leftMouseHeld = false;
		}
		if(vehicledata == null){
			Print.log("Vehicle type null. Not ticking vehicle.");
			Static.stop();
			return;
		}
		boolean drivenByPlayer = world.isRemote && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer;
		//		
		if(doorToggleTimer > 0){
			doorToggleTimer--;
		}
		//Aesthetics
		if(hasEnoughFuel()){
			wheelsAngle += throttle * 0.2F;	
		}
		wheelsYaw *= 0.9F;
		if(wheelsYaw >  20){ wheelsYaw = 20; }
		if(wheelsYaw < -20){ wheelsYaw = -20; }
		if(world.isRemote && !drivenByPlayer){
			if(serverPositionTransitionTicker > 0){
				double x = posX + (serverPosX - posX) / serverPositionTransitionTicker;
				double y = posY + (serverPosY - posY) / serverPositionTransitionTicker;
				double z = posZ + (serverPosZ - posZ) / serverPositionTransitionTicker;
				double dYaw = MathHelper.wrapDegrees(serverYaw - axes.getYaw());
				double dPitch = MathHelper.wrapDegrees(serverPitch - axes.getPitch());
				double dRoll = MathHelper.wrapDegrees(serverRoll - axes.getRoll());
				rotationYaw = (float)(axes.getYaw() + dYaw / serverPositionTransitionTicker);
				rotationPitch = (float)(axes.getPitch() + dPitch / serverPositionTransitionTicker);
				float rotationRoll = (float)(axes.getRoll() + dRoll / serverPositionTransitionTicker);
				--serverPositionTransitionTicker;
				setPosition(x, y, z);
				setRotation(rotationYaw, rotationPitch, rotationRoll);
				//return;
			}
		}
		Vec3d atmc = new Vec3d(0, 0, 0);
		for(WheelEntity wheel : wheels){
			if(wheel != null && world != null){
				wheel.prevPosX = wheel.posX;
				wheel.prevPosY = wheel.posY;
				wheel.prevPosZ = wheel.prevPosZ;
			}
		}
		//TODO config for vehicles need fuel
		boolean canThrustCreatively = /*!Config.vehicleConsumeFuel|| */(seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer)seats[0].getControllingPassenger()).capabilities.isCreativeMode);
		boolean consumed = false;
		Part.PartData enginepart = vehicledata.getPart("engine");
		if(enginepart != null && enginepart.getAttributeData(EngineAttributeData.class).isOn() && vehicledata.getFuelTankContent() > enginepart.getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle){
			double d = (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle) / 80;//20, set lower to prevent too fast compsumption.
			consumed = vehicledata.consumeFuel(d > 0 ? d : (vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() / 320));
		}
		for(WheelEntity wheel : wheels){
			if(wheel == null){
				continue;
			}
			onGround = true;
			wheel.onGround = true;
			wheel.rotationYaw = axes.getYaw();
			if(!vehicledata.getVehicle().getDriveType().hasTracks() && (wheel.wheelid == 2 || wheel.wheelid == 3)){
				wheel.rotationYaw += wheelsYaw;
			}
			wheel.motionX *= 0.9F;
			wheel.motionY *= 0.9F;
			wheel.motionZ *= 0.9F;
			wheel.motionY -= 0.98F / 20F;//Gravity
			if(enginepart != null){
				if((canThrustCreatively || consumed)){
					double velocityScale;
					if(vehicledata.getVehicle().getDriveType().hasTracks()){
						boolean left = wheel.wheelid == 0 || wheel.wheelid == 3;
						//
						float turningDrag = 0.02F;
						wheel.motionX *= 1F - (Math.abs(wheelsYaw) * turningDrag);
						wheel.motionZ *= 1F - (Math.abs(wheelsYaw) * turningDrag);
						//
						velocityScale = 0.04F * (throttle > 0 ? vehicledata.getVehicle().getFMMaxPositiveThrottle() : vehicledata.getVehicle().getFMMaxNegativeThrottle()) * vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
						float steeringScale = 0.1F * (wheelsYaw > 0 ? vehicledata.getVehicle().getFMTurnLeftModifier() : vehicledata.getVehicle().getFMTurnRightModifier());
						double effectiveWheelSpeed = (throttle + (wheelsYaw * (left ? 1 : -1) * steeringScale)) * velocityScale;
						wheel.motionX += effectiveWheelSpeed * Math.cos(wheel.rotationYaw * 3.14159265F / 180F);
						wheel.motionZ += effectiveWheelSpeed * Math.sin(wheel.rotationYaw * 3.14159265F / 180F);
					}
					else if(vehicledata.getVehicle().getDriveType().isFWD() || vehicledata.getVehicle().getDriveType().is4WD()){
						if(wheel.wheelid == 2 || wheel.wheelid == 3){
							velocityScale = 0.1F * throttle * (throttle > 0 ? vehicledata.getVehicle().getFMMaxPositiveThrottle() : vehicledata.getVehicle().getFMMaxNegativeThrottle()) * vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
							wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
							wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
							velocityScale = 0.01F * (wheelsYaw > 0 ? vehicledata.getVehicle().getFMTurnLeftModifier() : vehicledata.getVehicle().getFMTurnRightModifier()) * (throttle > 0 ? 1 : -1);
							wheel.motionX -= wheel.getHorizontalSpeed() * Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
							wheel.motionZ += wheel.getHorizontalSpeed() * Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
						}
						else{
							wheel.motionX *= 0.9F;
							wheel.motionZ *= 0.9F;
						}
					}
					else if(vehicledata.getVehicle().getDriveType().isRWD()){
						if(wheel.wheelid == 0 || wheel.wheelid == 1){
							velocityScale = 0.1F * throttle * (throttle > 0 ? vehicledata.getVehicle().getFMMaxPositiveThrottle() : vehicledata.getVehicle().getFMMaxNegativeThrottle()) * vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
							wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
							wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
						}
						if(wheel.wheelid == 2 || wheel.wheelid == 3){
							velocityScale = 0.01F * ((wheelsYaw > 0 ? vehicledata.getVehicle().getFMTurnLeftModifier() : vehicledata.getVehicle().getFMTurnRightModifier()) * 16) * (throttle > 0 ? 1 : -1);
							wheel.motionX = wheels[wheel.wheelid - 2].motionX;
							wheel.motionZ = wheels[wheel.wheelid - 2].motionZ;
							wheel.motionX -= wheel.getHorizontalSpeed() * Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
							wheel.motionZ += wheel.getHorizontalSpeed() * Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
							//wheels[wheel.wheelid - 2].motionX *= 0.9F;
							//wheels[wheel.wheelid - 2].motionZ *= 0.9F;
						}
						//This is surely wrong.
					}
					else{
						//
					}
				}
			}
			wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
			//pull wheels back to car
			Vec3d targetpos = axes.getRelativeVector(vehicledata.getWheelPos().get(wheel.wheelid).to16Double());
			Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
			Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(vehicledata.getVehicle().getFMWheelSpringStrength());
			if(despos.lengthSquared() > 0.001F){
				wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
				despos.scale(0.5F);
				atmc = atmc.subtract(despos);
			}
			//
			if(this.getEntityAtRear() != null){
				((VehicleEntity)this.getEntityAtRear()).moveTrailer();
			}
		}
		move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
		
		if(wheels[0] != null && wheels[1] != null && wheels[2] != null && wheels[3] != null){
			Vec3d front = new Vec3d((wheels[2].posX + wheels[3].posX) / 2F, (wheels[2].posY + wheels[3].posY) / 2F, (wheels[2].posZ + wheels[3].posZ) / 2F); 
			Vec3d back  = new Vec3d((wheels[0].posX + wheels[1].posX) / 2F, (wheels[0].posY + wheels[1].posY) / 2F, (wheels[0].posZ + wheels[1].posZ) / 2F); 
			Vec3d left = new Vec3d((wheels[0].posX + wheels[3].posX) / 2F, (wheels[0].posY + wheels[3].posY) / 2F, (wheels[0].posZ + wheels[3].posZ) / 2F); 
			Vec3d right = new Vec3d((wheels[1].posX + wheels[2].posX) / 2F, (wheels[1].posY + wheels[2].posY) / 2F, (wheels[1].posZ + wheels[2].posZ) / 2F); 
			//
			double dx = front.x - back.x, dy = front.y - back.y, dz = front.z - back.z;
			double drx = left.x - right.x, dry = left.y - right.y, drz = left.z - right.z;
			double dxz = Math.sqrt(dx * dx + dz * dz);
			double drxz = Math.sqrt(drx * drx + drz * drz);
			//
			double yaw = Math.atan2(dz, dx);
			double pitch = -Math.atan2(dy, dxz);
			double roll = 0F;
			roll = -(float)Math.atan2(dry, drxz);
			//
			if(vehicledata.getVehicle().getDriveType().hasTracks()){
				yaw = (float)Math.atan2(wheels[3].posZ - wheels[2].posZ, wheels[3].posX - wheels[2].posX) + (float)Math.PI / 2F;
			}
			axes.setAngles(yaw * 180F / 3.14159F, pitch * 180F / 3.14159F, roll * 180F / 3.14159F);
		}
		checkForCollisions();
		for(SeatEntity seat : seats){
			if(seat != null){
				seat.updatePosition();
			}
		}
		if(drivenByPlayer){
			PacketHandler.getInstance().sendToServer(new PacketVehicleControl(this));
			serverPosX = posX;
			serverPosY = posY;
			serverPosZ = posZ;
			serverYaw = axes.getYaw();
		}
		if(!world.isRemote && ticksExisted % 5 == 0){
			PacketHandler.getInstance().sendToAllAround(new PacketVehicleControl(this), Resources.getTargetPoint(this));
		}
		vehicledata.getScripts().forEach((script) -> script.onUpdate(this, vehicledata));
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
					vehicledata.getPart("engine").getAttributeData(EngineAttributeData.class).setOn(false);
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
			 			VehicleData rear = this.getEntityAtRear().getVehicleData();
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
	public boolean isLocked(){
		return vehicledata.isLocked();
	}

	@Override
	public boolean unlock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
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

	@Override
    public void fall(float distance, float damageMultiplier){
		//
	}
		
	public void checkForCollisions(){
		return;
	}
	
	public Vec3d rotate(Vec3d inVec){
		return axes.getRelativeVector(inVec);
	}
	
	public void rotateYaw(float rotateBy){
		if(Math.abs(rotateBy) < 0.01F){
			return;
		}
		axes.rotateYawD(rotateBy);
		updatePrevAngles();
	}
	
	public void rotatePitch(float rotateBy){
		if(Math.abs(rotateBy) < 0.01F){
			return;
		}
		axes.rotatePitchD(rotateBy);
		updatePrevAngles();
	}

	public void rotateRoll(float rotateBy){
		if(Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateRollD(rotateBy);
		updatePrevAngles();
	}
		
	public void updatePrevAngles(){
		double yaw = axes.getYaw() - prevRotationYaw;
		if(yaw > 180){ prevRotationYaw += 360F; }
		if(yaw < -180){ prevRotationYaw -= 360F; }
		double pitch = axes.getPitch() - prevRotationPitch;
		if(pitch > 180){ prevRotationPitch += 360F; }
		if(pitch < -180){ prevRotationPitch -= 360F; }
		double roll = axes.getRoll() - prevRotationRoll;
		if(roll > 180){ prevRotationRoll += 360F; }
		if(roll < -180){ prevRotationRoll -= 360F; }
	}
	
	public void setRotation(float rotYaw, float rotPitch, float rotRoll){
		axes.setAngles(rotYaw, rotPitch, rotRoll);
	}
	
	public boolean isPartOfThis(Entity ent){
		for(SeatEntity seat : seats){
			if(seat == null){
				continue;
			}
			if(ent == seat || seats[0].getControllingPassenger() == ent){
				return true;
			}
		}
		if(this.getEntityAtRear() != null){
			
		}
		return ent == this;	
	}
	
	@Override
	public ItemStack getPickedResult(RayTraceResult target){
		ItemStack stack = vehicledata.getVehicle().getItemStack(vehicledata);
		stack.setItemDamage(0);
		return stack;
	}
	
	public boolean hasFuel(){
		if(seats == null || seats[0] == null || seats[0].getControllingPassenger() == null){
			return false;
		}
		return driverIsCreative() || vehicledata.getFuelTankContent() > 0;
	}

	public boolean hasEnoughFuel(){
		if(seats == null || seats[0] == null || seats[0].getControllingPassenger() == null){
			return false;
		}
		return driverIsCreative() || vehicledata.getFuelTankContent() > vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle;
	}
	
	public double get3DSpeed(){
		return Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
	}
	
	public double getHorizontalSpeed(){
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}
	
	public float getPlayerRoll(){
		return axes.getRoll();
	}
	
	public float getPrevPlayerRoll() {
		return prevAxes.getRoll();
	}
	
	public float getCameraDistance(){
		return vehicledata.getVehicle().getFMCameraDistance();
	}
	
	@Override
	public String getName(){
		return vehicledata.getVehicle().getName();
	}
	
	@SideOnly(Side.CLIENT)
	public boolean showInventory(int seat){
		return seat != 0;
	}

	@Override
	public Entity getCamera(){
		if(Static.side().isClient()){
			return null;
		}
		return camera;
	}

	public VehicleData getData(){
		return vehicledata;
	}
	
	private long lr = -1;
	
	@Override
	public void processServerPacket(PacketEntityUpdate pkt){
		if(pkt.nbt.hasKey("ScriptId")){
			for(VehicleScript script : vehicledata.getScripts()){
				if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
					script.onDataPacket(this, vehicledata, pkt.nbt, Side.SERVER);
				}
			}
		}
		if(pkt.nbt.hasKey("task")){
			switch(pkt.nbt.getString("task")){
				case "engine_toggle":{
					if(lr + 1000 >= Time.getDate()){
						break;
					}
					lr = Time.getDate();
					pkt.nbt.setBoolean("engine_toggle_result", vehicledata.getPart("engine").getAttributeData(EngineAttributeData.class).toggle());
					if(vehicledata.getFuelTankContent() == 0 || vehicledata.getFuelTankContent() < 0.1){
						pkt.nbt.setBoolean("engine_toggle_result", false);
						pkt.nbt.setBoolean("no_fuel", true);
					}
					ApiUtil.sendEntityUpdatePacketToAllAround(this, pkt.nbt);
					throttle = 0;
					break;
				}
			}
		}
	}
	
	@Override
	public void processClientPacket(PacketEntityUpdate pkt){
		if(pkt.nbt.hasKey("ScriptId")){
			for(VehicleScript script : vehicledata.getScripts()){
				if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
					script.onDataPacket(this, vehicledata, pkt.nbt, Side.SERVER);
				}
			}
		}
		if(pkt.nbt.hasKey("task")){
			switch(pkt.nbt.getString("task")){
				case "engine_toggle":{
					if(net.minecraft.client.Minecraft.getMinecraft().player.isRiding() && this.seats[0] == net.minecraft.client.Minecraft.getMinecraft().player.getRidingEntity()){
						Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Engine toggled " + (vehicledata.getPart("engine").getAttributeData(EngineAttributeData.class).setOn(pkt.nbt.getBoolean("engine_toggle_result")) ? "on" : "off") + ".");
						if(pkt.nbt.hasKey("no_fuel") && pkt.nbt.getBoolean("no_fuel")){
							Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Out of fuel!");
						}
					}
					throttle = 0;
					break;
				}
				case "update_vehicledata":{
					this.vehicledata.readFromNBT(pkt.nbt, world.isRemote);
					break;
				}
			}
		}
	}

	@Override
	public VehicleData getVehicleData(){
		return this.vehicledata;
	}

	@Override
	public VehicleType getVehicleType(){
		return VehicleType.LAND;
	}

	@Override
	public Entity getEntity(){
		return this;
	}

	@Override
	public VehicleAxes getAxes(){
		return this.axes;
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
	public double getThrottle(){
		return throttle;
	}

	@Override
	public VehicleEntity getEntityAtFront(){
		return null;
	}

	@Override
	public VehicleEntity getEntityAtRear(){
		return trailer;
	}

	@Override
	public Vec3d getAngularVelocity(){
		return this.angularVelocity;
	}

	@Override
	public float getWheelsYaw(){
		return this.wheelsYaw;
	}

	@Override
	public float getWheelsAngle(){
		return this.wheelsAngle;
	}
	
}