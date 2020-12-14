package net.fexcraft.mod.fvtm.sys.legacy;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_FUEL;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_MAIN;

import java.util.UUID;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.LegacyData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.util.Axis3D;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.ContainerFunction;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.util.packet.PKT_VehControl;
import net.fexcraft.mod.fvtm.util.packet.PKT_VehKeyPress;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.fexcraft.mod.fvtm.util.vector.Matrix4f;
import net.fexcraft.mod.fvtm.util.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 * <br>
 * "Legacy" Main class for Vehicles.
 */
public class AirVehicle extends GenericVehicle implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {

	private LegacyData lata;
	private VehicleData vehicle;
	public SwivelPoint rotpoint;
	public Axis3D axes, prevaxes;
	//
	private UUID placer = UUID.fromString("f78a4d8d-d51b-4b39-98a3-230f2de0c670");
	//=
	public float wheelsAngle, propelerAngle;
	public float serverFY, flapsPitchLeft, flapsPitchRight;	
    public float prevRotationYaw, prevRotationPitch, prevRotationRoll;
    protected byte doorToggleTimer;
    protected Object engineloop;//TODO sound
    public boolean gearout;
    //
    public double serverPosX, serverPosY, serverPosZ;
    public double serverYaw, serverPitch, serverRoll;
    public int serverPositionTransitionTicker;
    public static final int servtick = 5;
    public static final String[] WHEELINDEX = new String[]{ "right_wing_wheel", "left_wing_wheel", "third_wheel" };

	public AirVehicle(World ilmondo){
		super(ilmondo);
		axes = new Axis3D(); prevaxes = new Axis3D();
		preventEntitySpawning = true; setSize(1f, 1f);
		ignoreFrustumCheck = true; stepHeight = 1f;
        if(world.isRemote){
            setRenderDistanceWeight(1d);
        }
        Print.debug("SPAWNING " + ilmondo.isRemote + " " + this.getEntityId());
	}
	
	/** Constructor to spawn either by a player or Constructor.
	 * 
	 * @param meta should be -1 or lower if placer rotation yaw matters
	 * */
	public AirVehicle(World world, VehicleData data, Vec3d pos, @Nullable EntityPlayer placer, int meta){
		this(world); this.setPosition(pos.x, pos.y, pos.z); this.vehicle = data;
		if(placer != null) this.placer = placer.getGameProfile().getId();
		this.rotateYaw((placer == null || meta >= 0 ? (meta * 90f) : placer.rotationYaw) + 90f);
		initializeVehicle(false);
	}

	@Override
	protected void entityInit(){
		//
	}

	private void initializeVehicle(boolean remote){
        lata = vehicle.getType().getLegacyData();
        wheels = new WheelEntity[WHEELINDEX.length];
        if(seats == null) seats = new SeatCache[vehicle.getSeats().size()];
        for(int i = 0; i < seats.length; i++) seats[i] = new SeatCache(this, i);
        stepHeight = lata.wheel_step_height;
        this.setupCapability(null);//TODO this.getCapability(FVTMCaps.CONTAINER, null));
        vehicle.getScripts().forEach((script) -> script.onSpawn(this, vehicle));
        Print.debug("INITIALIZED " + remote + " " + this.getEntityId());
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		if(vehicle == null){ vehicle = Resources.getVehicleData(compound); }
		else{ vehicle.read(compound); }
        prevRotationYaw = compound.getFloat("RotationYaw");
        prevRotationPitch = compound.getFloat("RotationPitch");
        prevRotationRoll = compound.getFloat("RotationRoll");
        prevaxes = axes.clone(); axes = Axis3D.read(this, compound);
        initializeVehicle(true); //Print.debug(compound.toString());
        super.readEntityFromNBT(compound);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		vehicle.write(compound);
		axes.write(this, compound); //Print.debug(compound.toString());
		super.writeEntityToNBT(compound);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = axes.write(this, new NBTTagCompound());
		ByteBufUtils.writeTag(buffer, vehicle.write(compound));
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
        try{
            NBTTagCompound compound = ByteBufUtils.readTag(buffer);
    		vehicle = Resources.getVehicleData(compound);
            axes = Axis3D.read(this, compound);
            prevRotationYaw = axes.getYaw();
            prevRotationPitch = axes.getPitch();
            prevRotationRoll = axes.getRoll();
            initializeVehicle(true);
        }
        catch(Exception e){
            e.printStackTrace();
            Print.debug("Failed to receive additional spawn data for this vehicle!");
        }
	}
    
    @Override
    public void setDead(){
        if(Config.VEHICLE_DROP_CONTENTS && !world.isRemote){
            for(String part : vehicle.getInventories()){
            	InventoryFunction func = vehicle.getPart(part).getFunction("fvtm:inventory"); if(func == null) continue;
            	if(func.isInventoryType(InventoryType.ITEM)){
            		for(int i = 0; i < func.getStacks().size(); i++){
                        this.entityDropItem(func.getStacks().get(i), 0.5f);
                        func.getStacks().set(i, ItemStack.EMPTY);
            		}
            	}
            	//TODO fluid handler alternative
            }
        }
        this.getCapability(Capabilities.CONTAINER, null).dropContents();
        //
        super.setDead();
        //if(seats != null) for(SeatEntity seat : seats) if(seat != null) seat.setDead();
        if(wheels != null) for(WheelEntity wheel : wheels) if(wheel != null) wheel.setDead();
        //
        vehicle.getScripts().forEach((script) -> script.onRemove(this, vehicle));
    }

	@Override
	public VehicleData getVehicleData(){
		return vehicle;
	}

	@Override
	public VehicleType getVehicleType(){
		return vehicle.getType().getVehicleType();
	}

	@Override
	public Entity getEntity(){
		return this;
	}

	public SwivelPoint getRotPoint(){
		return rotpoint;
	}
	
	public WheelEntity[] getWheels(){
		return wheels;
	}

	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player){
		for(VehicleScript script : vehicle.getScripts()) if(script.onKeyPress(key, seat, player)) return true;
        if(!seat.driver && key.driverOnly()) return false;
        if(world.isRemote && !key.toggables() /*&& key.dismount()*/){
            Packets.sendToServer(new PKT_VehKeyPress(key)); return true;
        }
        switch(key){
            case ACCELERATE:{
                throttle += throttle < 0 ? 0.02f : 0.01F;
                if(throttle > 1F){ throttle = 1F; }
                return true;
            }
            case DECELERATE:{
                throttle -= throttle > 0 ? 0.02f : 0.01F;
                if(throttle < -1F){ throttle = -1F; }
                if(throttle < 0F && lata.min_throttle == 0F){
                    throttle = 0F;
                }
                return true;
            }
            case TURN_LEFT:{
                wheelsYaw -= 1F;
                return true;
            }
            case TURN_RIGHT:{
                wheelsYaw += 1F;
                return true;
            }
            case TURN_UP:{
            	flapsPitchLeft += 1F;
            	flapsPitchRight += 1F;
                return true;
            }
            case TURN_DOWN:{
            	flapsPitchLeft -= 1F;
            	flapsPitchRight -= 1F;
                return true;
            }
            case ROLL_LEFT:{
				flapsPitchLeft += 1F;
				flapsPitchRight -= 1F;
                return true;
            }
            case ROLL_RIGHT:{
				flapsPitchLeft -= 1F;
				flapsPitchRight += 1F;
                return true;
            }
            case BRAKE:{
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
            case ENGINE: {
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString("task", "engine_toggle");
                ApiUtil.sendEntityUpdatePacketToServer(this, nbt);
                //TODO correct this
                return true;
            }
            case DISMOUNT: {
                Packets.sendToAllAround(new PKT_VehControl(this), Resources.getTargetPoint(this));
                player.dismountRidingEntity();
                return true;
            }
            case INVENTORY: {
            	/*if(vehicle.getPart("engine") != null && vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
	                Print.chat(player, "Turn engine off first!"); return true;
	            }*/
            	player.openGui(FVTM.getInstance(), VEHICLE_MAIN, world, 0, this.getEntityId(), 0);
	            return true;
            }
            case TOGGABLES: {//client side
            	if(doorToggleTimer > 0) return true;
            	net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay.toggle();
            	doorToggleTimer += 10;
                return true;
            }
            /*case OTHER:{
				if(doorToggleTimer <= 0){ doorToggleTimer = 10;
					gearout = !gearout; Print.chat(player, "Landing gear is now " + (gearout ? "down" : "up"));
					//TODO gear packet
				}
            	return true;
            }*///TODO make this an attribute instead
            case SCRIPTS: {
                /*if(!world.isRemote){
                    player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_SCRIPTSGUI, world, this.getEntityId(), seat, 0);
                    //open scripts gui
                }
                return true;*/
            }
            case LIGHTS: {
                Print.chat(player, "Feature not implemented yet.");
                return true;
            }
            default:{ Print.chat(player, String.format("Task for keypress %s not found.", key)); return false; }
        }
    }

	@Override
	public UUID getPlacer(){
		return placer;
	}
	
    public void rotateYaw(float rotateBy){
        if(Math.abs(rotateBy) < 0.01F){ return; }
        axes.rotateYawD(rotateBy);
        updatePrevAngles();
    }

    public void rotatePitch(float rotateBy){
        if(Math.abs(rotateBy) < 0.01F){ return; }
        axes.rotatePitchD(rotateBy);
        updatePrevAngles();
    }

    public void rotateRoll(float rotateBy){
        if(Math.abs(rotateBy) < 0.01F){ return; }
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

    @Override
	public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, double throttle, double steeringYaw, int fuel, double speed){
        if(world.isRemote){
            serverPosX = posX; serverPosY = posY; serverPosZ = posZ;
            serverYaw = yaw; serverPitch = pitch; serverRoll = roll;
            serverPositionTransitionTicker = servtick;
        }
        else{
            setPosition(posX, posY, posZ);
            prevRotationYaw = yaw;
            prevRotationPitch = pitch;
            prevRotationRoll = roll;
            setRotation(yaw, pitch, roll);
        }
        motionX = motX; motionY = motY; motionZ = motZ;
        this.throttle = throttle; serverFY = (float)steeringYaw;
	}

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posrotincr, boolean teleport){
        if(ticksExisted > 1){ /*Print.debug("setPositionAndRotationDirect");*/ return; }
        if(this.getDriver() != null && this.getDriver() instanceof EntityPlayer){
            //
        }
        else{
            double xx = x - posX, yy = y - posY, zz = z - posZ;
            double xyz = xx * xx + yy * yy + zz * zz; if(xyz <= 1.0D){ return; }
            serverPositionTransitionTicker = servtick / 2;
            serverPosX = x; serverPosY = y; serverPosZ = z;
            serverYaw = yaw; serverPitch = pitch;
        }
    }

	//-- Vanilla --//
	
    @Override
    protected boolean canTriggerWalking(){
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity){
        return null;
    }
    
    @Override
    public AxisAlignedBB getEntityBoundingBox(){
    	return super.getEntityBoundingBox();
    }

    @Override
    public boolean isNonBoss(){
        return false;
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
    public SoundCategory getSoundCategory(){
        return SoundCategory.NEUTRAL;
    }

    @Override
    public double getYOffset(){
        return 0D;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player){
        //
    }

    @Override
    public boolean canBeCollidedWith(){
        return true;
    }

    @Override
    public void fall(float distance, float multiplier){
        //
    }

    @Override
    public String getName(){
        return vehicle.getName();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isInRangeToRenderDist(double dist){
        return Config.RENDER_OUT_OF_VIEW ? true : super.isInRangeToRenderDist(dist);
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(){
        return this.getCollisionBox(this);
    }
    
	//-- Vanilla END --//
	
	@Override
	public VehicleEntity getCoupledEntity(boolean front){
		return null;
	}

    @Override
    public void applyEntityCollision(Entity entity){
    	Print.debug(entity); return;
    }
    
    @Override
    public void setVelocity(double x, double y, double z){
        motionX = x; motionY = y; motionZ = z; return;
    }

    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
        if(isDead || world.isRemote || hand == EnumHand.OFF_HAND){ return false; }
        ItemStack stack = player.getHeldItem(hand);
        //TODO keyitem/lock check
        if(vehicle.isLocked()){ Print.chat(player, "Vehicle is locked."); return true; }
        if(!stack.isEmpty()){
            if(stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getType().isFuelContainer()){
            	player.openGui(FVTM.getInstance(), VEHICLE_FUEL, world, VEHICLE_FUEL, this.getEntityId(), 0);
            	return true;
            }
            else if(stack.getItem() instanceof VehicleItem){
                //TODO append trailer
            }
            else if(stack.getItem() instanceof ContainerItem){
            	this.getCapability(Capabilities.CONTAINER, null).openGUI(player); return true;
            }
            //space for other item interaction
            else{
                if(vehicle.getPart("engine") != null && vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
                    Print.chat(player, "Turn engine off first!");
                }
                else{
                	player.openGui(FVTM.getInstance(), VEHICLE_MAIN, world, 0, this.getEntityId(), 0);
                }
                return true;
            }
        }
        //else if(ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT)) return true;
        if(!vehicle.getScripts().isEmpty()){
            for(VehicleScript script : vehicle.getScripts()){
                if(script.onInteract(this, vehicle, player, hand)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasEnoughFuel(){
        return isDriverInCreative() || true;//(vehicle != null && vehicle.getPart("engine") != null && vehicledata.getFuelTankContent() > vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle);
    }

    @SuppressWarnings("unused")
	@Override
    public void onUpdate(){
        super.onUpdate();
        if(vehicle == null){ Print.log("VehicleData is NULL; Not ticking vehicle."); Static.stop(); return; }
        if(!world.isRemote){
            for(int i = 0; i < wheels.length; i++){
                if(wheels[i] == null || !wheels[i].addedToChunk){
                    wheels[i] = new WheelEntity(this, i); world.spawnEntity(wheels[i]);
                }
            }
        }
        else{
            if(vehicle.getType().isTrailerOrWagon()){
            	if(getCoupledEntity(true) == null){
                	if(wheels.length == 2){
                		wheels = new WheelEntity[]{ wheels[0], wheels[1], null, null };
                	}
            	}
            	else{
            		if(wheels.length > 2){
            			wheels = new WheelEntity[]{ wheels[0], wheels[1] };
            		}
            	}
            }
        }
        prevRotationYaw = axes.getYaw();
        prevRotationPitch = axes.getPitch();
        prevRotationRoll = axes.getRoll();
        prevaxes = axes.clone();
        this.ticksExisted++;
        if(this.ticksExisted > Integer.MAX_VALUE){
            this.ticksExisted = 0;
        }
        //
        //if(seats == null || (!vehicle.getType().isTrailerOrWagon() && seats.length == 0)){ this.setDead(); return; }
        if(doorToggleTimer > 0){
            doorToggleTimer--;
        }
        //
		if(hasEnoughFuel()){ propelerAngle += (Math.pow(throttle, 0.4)) * 1.5; }
		wheelsYaw *= 0.9F; flapsPitchLeft *= 0.9F; flapsPitchRight *= 0.9F;
		if(wheelsYaw > 20) wheelsYaw = 20;
		if(wheelsYaw < -20) wheelsYaw = -20;
		if(flapsPitchRight > 20) flapsPitchRight = 20;
		if(flapsPitchRight < -20) flapsPitchRight = -20;
		if(flapsPitchLeft > 20) flapsPitchLeft = 20;
		if(flapsPitchLeft < -20) flapsPitchLeft = -20;
		//
        if(world.isRemote){
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
                --serverPositionTransitionTicker; setPosition(x, y, z);
                setRotation(rotationYaw, rotationPitch, rotationRoll); //return;
                float old = wheelsYaw; wheelsYaw = wheelsYaw + (serverFY - wheelsYaw) / serverPositionTransitionTicker;
                if(wheelsYaw != wheelsYaw) wheelsYaw = old;
            }
            vehicle.getAttribute("steering_angle").setValue(wheelsYaw);
            if(!vehicle.hasPart("third_wheel")){ Print.log("Third Wheel Missing || " + this.toString());return; }
            double cir = ((WheelData)vehicle.getPart("third_wheel").getType().getInstallationHandlerData()).getRadius() * 2 * Static.PI;
            wheelsAngle += throttle * cir; if(wheelsAngle > 360) wheelsAngle -= 360; if(wheelsAngle < -360) wheelsAngle += 360;
        	vehicle.getAttribute("wheel_angle").setValue(wheelsAngle);
        	vehicle.getAttribute("throttle").setValue((float)throttle);
        }
		float throttlePull = 0.99F;
		if(vehicle.getType().getVehicleType().isHeli() && canThrust())
			throttle = (throttle - 0.5F) * throttlePull + 0.5F;
		float lastTickSpeed = (float)getSpeed3A();
		float sensitivityAdjust = (float)(throttle > 0.5F ? 1.5F - throttle : 4F * throttle - 1F); 
		if(sensitivityAdjust < 0F){ sensitivityAdjust = 0F; } sensitivityAdjust *= 0.125F;
		float yaw = wheelsYaw * (wheelsYaw > 0 ? lata.turn_left_mod : lata.turn_right_mod) * sensitivityAdjust;
		float flapsPitch = (flapsPitchLeft + flapsPitchRight) / 2F;
		float pitch = flapsPitch * (flapsPitch > 0 ? lata.look_up_mod : lata.look_down_mod) * sensitivityAdjust;
		float flapsRoll = (flapsPitchRight - flapsPitchLeft) / 2F;
		float roll = flapsRoll * (flapsRoll > 0 ? lata.roll_left_mod : lata.roll_right_mod) * sensitivityAdjust;
		
		if(vehicle.getType().getVehicleType().isHeli()){
			/*if(!isPartIntact(EnumDriveablePart.tail)){
				yaw = 0;
				pitch = 0;
				roll = 0;
			}
			if(!isPartIntact(EnumDriveablePart.leftWing))
				roll -= 7F * getSpeedXZ();		
			if(!isPartIntact(EnumDriveablePart.rightWing))
				roll += 7F * getSpeedXZ();*///TODO part stuff;		
		}
		axes.rotateYawD(yaw); axes.rotatePitchD(pitch); axes.rotateRollD(-roll);
		//
		float g = 0.98F / 10F, drag = 1F - (0.05F * lata.drag), wobbleFactor = 0F;//.005F;
		float throttleScaled = 0.01F * (lata.max_throttle + (vehicle.getPart("engine") == null ? 0 : vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").getLegacyEngineSpeed()));
		if(!canThrust()) throttleScaled = 0;
		int numPropsWorking = 0, numProps = 0;
		float fuelConsumptionMultiplier = 2F;
		//
		if(vehicle.getType().getVehicleType().isHeli()){
			/*for(Propeller prop : type.heliPropellers)
				if(isPartIntact(prop.planePart)) numPropsWorking++;*///TODO
			numPropsWorking = numProps = 1;//TODO vehicle registered propeler amount;
			Vector3f up = axes.getYAxis(); throttleScaled *= numProps == 0 ? 0 : numPropsWorking / numProps * 2F;
			float upwardsForce = (float)(throttle * throttleScaled + (g - throttleScaled / 2F));
			if(throttle < 0.5F) upwardsForce = (float)(g * throttle * 2F);
			//TODO if(!isPartIntact(EnumDriveablePart.blades)){ upwardsForce = 0F; }
			motionX += upwardsForce * up.x * 0.5F; motionY += upwardsForce * up.y; motionZ += upwardsForce * up.z * 0.5F; motionY -= g;
			motionX *= drag; motionY *= drag; motionZ *= drag;
			//TODO data.fuelInTank -= upwardsForce * fuelConsumptionMultiplier * vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").getLegacyFuelConsumption();
		}
		else{//assuming it's a normal plane
			/*for(Propeller prop : type.propellers)
				if(isPartIntact(prop.planePart)) numPropsWorking++;*/
			numPropsWorking = numProps = 1;//TODO vehicle registered propeler amount;
			float throttleTemp = (float)(throttle * (numProps == 0 ? 0 : numPropsWorking / numProps * 2F));
			Vector3f forwards = (Vector3f)axes.getXAxis().normalise(); if(lastTickSpeed > 2F) lastTickSpeed = 2F;
			float newSpeed = lastTickSpeed + throttleScaled * 2F;
			float proportionOfMotionToCorrect = 2F * throttleTemp - 0.5F;
			if(proportionOfMotionToCorrect < 0F) proportionOfMotionToCorrect = 0F;
			if(proportionOfMotionToCorrect > 0.5F) proportionOfMotionToCorrect = 0.5F;
			g = 0.98F / 20F; motionY -= g;
			//
			int numWingsIntact = 2;//TODO
			//if(isPartIntact(EnumDriveablePart.rightWing)) numWingsIntact++;
			//if(isPartIntact(EnumDriveablePart.leftWing)) numWingsIntact++; 
			float amountOfLift = 2F * g * throttleTemp * numWingsIntact / 2F;
			if(amountOfLift > g) amountOfLift = g;
			//TODO if(!isPartIntact(EnumDriveablePart.tail)) amountOfLift *= 0.75F;
			motionY += amountOfLift;
			motionX *= 1F - proportionOfMotionToCorrect;
			motionY *= 1F - proportionOfMotionToCorrect;
			motionZ *= 1F - proportionOfMotionToCorrect;
			motionX += proportionOfMotionToCorrect * newSpeed * forwards.x;
			motionY += proportionOfMotionToCorrect * newSpeed * forwards.y;
			motionZ += proportionOfMotionToCorrect * newSpeed * forwards.z;
			motionX *= drag; motionY *= drag; motionZ *= drag;
			//TODO data.fuelInTank -= throttleScaled * fuelConsumptionMultiplier * vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").getLegacyFuelConsumption();
		}
		//
		double motion = Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
		if(motion > 10){ motionX *= 10 / motion; motionY *= 10 / motion; motionZ *= 10 / motion; }
        for(WheelEntity wheel : wheels){
            if(wheel == null) continue;
            wheel.prevPosX = wheel.posX; wheel.prevPosY = wheel.posY; wheel.prevPosZ = wheel.posZ;
            wheel.move(MoverType.SELF, motionX, motionY, motionZ);
        }
		for(int i = 0; i < 2; i++){
			Vec3f atmc = new Vec3f(motionX / 2F, motionY / 2F, motionZ / 2F);
			for(WheelEntity wheel : wheels){
				if(wheel == null) continue; onGround = true; wheel.onGround = true;
				wheel.rotationYaw = axes.getYaw();
		    	if(!vehicle.getWheelPositions().containsKey(WHEELINDEX[wheel.wheelid])){
		    		this.entityDropItem(vehicle.newItemStack(), 1); this.setDead();
		    		Print.debug("Vehicle was missing an essential Wheel Position, despawning and item dropped.");
		    		return;
		    	}
				Vec3d vec = axes.getRelativeVector(vehicle.getWheelPositions().get(WHEELINDEX[wheel.wheelid]));
				Vector3f targetWheelPos = new Vector3f((float)vec.x, (float)vec.y, (float)vec.z);
				Vector3f currentWheelPos = new Vector3f((float)(wheel.posX - posX), (float)(wheel.posY - posY), (float)(wheel.posZ - posZ));
				float targetWheelLength = (float)targetWheelPos.length();
				float currentWheelLength = (float)currentWheelPos.length();
				//
				float dLength = targetWheelLength - currentWheelLength;
				float dAngle = Vector3f.angle(targetWheelPos, currentWheelPos);
				{	
					float newLength = currentWheelLength + dLength * lata.wheel_spring_strength;
					Vector3f rotateAround = Vector3f.cross(targetWheelPos, currentWheelPos, null);
					Matrix4f mat = new Matrix4f();
					mat.m00 = currentWheelPos.x; mat.m10 = currentWheelPos.y; mat.m20 = currentWheelPos.z;
					mat.rotate(dAngle * lata.wheel_spring_strength, rotateAround);
					//
					axes.rotateAll(-dAngle * lata.wheel_spring_strength, rotateAround);
					//
					Vector3f newWheelPos = new Vector3f(mat.m00, mat.m10, mat.m20);
					newWheelPos.normalise().scale(newLength);
					float wheelProportion = 0.75F; Vector3f atmw = new Vector3f();
					atmw.x = (newWheelPos.x - currentWheelPos.x) * (1F - wheelProportion);
					atmw.y = (newWheelPos.y - currentWheelPos.y) * (1F - wheelProportion);
					atmw.z = (newWheelPos.z - currentWheelPos.z) * (1F - wheelProportion);		
					atmc.xCoord -= (newWheelPos.x - currentWheelPos.x) * (1F - wheelProportion);
					atmc.yCoord -= (newWheelPos.y - currentWheelPos.y) * (1F - wheelProportion);
					atmc.zCoord -= (newWheelPos.z - currentWheelPos.z) * (1F - wheelProportion);
					atmc.yCoord += ((wheel.posY - wheel.prevPosY) - (motionY)) * 0.5F / wheels.length;
					wheel.move(MoverType.SELF, atmw.x, atmw.y, atmw.z);
				}
			}
			move(MoverType.SELF, atmc.xCoord, atmc.yCoord, atmc.zCoord);
		}
        vehicle.getScripts().forEach((script) -> script.onUpdate(this, vehicle));
        checkForCollisions();
        for(SeatCache seat : seats) if(seat != null) seat.updatePosition();
        /*if(drivenByPlayer){
            PacketHandler.getInstance().sendToServer(new PacketVehicleControl(this));
            serverPosX = posX; serverPosY = posY; serverPosZ = posZ; serverYaw = axes.getYaw();
        }*/
        if(!world.isRemote && ticksExisted % 5 == 0){
            Packets.sendToAllAround(new PKT_VehControl(this), Resources.getTargetPoint(this));
        }
    }

	private double getSpeed3A(){
		return Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
	}

	private boolean canThrust(){
		return isDriverInCreative() || true;//fuel tank check;
	}

	public void onUpdateMovement(){
		if(vehicle.getType().isTrailerOrWagon()){
			Vec3d atmc = new Vec3d(0, 0, 0); int wheelid = 0;
	        for(WheelEntity wheel : wheels){
	            if(wheel == null){ continue; }
	            onGround = true;
	            wheel.onGround = true;
	            wheel.rotationYaw = axes.getYaw();
	            if(!lata.is_tracked && (wheel.wheelid == 2 || wheel.wheelid == 3)){
	                wheel.rotationYaw += wheelsYaw;
	            }
	            wheel.motionX *= 0.9F;
	            wheel.motionY *= 0.9F;
	            wheel.motionZ *= 0.9F;
	            wheel.motionY -= 0.98F / 20F;//Gravity
	            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
	            Vec3d s = null;
	        	if(wheelid >= WHEELINDEX.length && this.getVehicleData().getType().isTrailerOrWagon()){
	        		s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid == 2 ? 1 : 0]);
	        		s = new Vec3d(0, s.y, s.z);
	        	}
	        	else{
	        		s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid]);
	        	}
	            Vec3d targetpos = axes.getRelativeVector(s);
	            Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
	            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(lata.wheel_spring_strength);
	            if(despos.lengthSquared() > 0.001F){
	                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
	                despos = despos.scale(0.5F); atmc = atmc.subtract(despos);
	            }
	            wheelid++;
	        }
	        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
		}
		else{
			if(getVehicleType().isWaterVehicle()){
		        Vec3d atmc = new Vec3d(0, 0, 0);
		        boolean cant = !Config.VEHICLES_NEED_FUEL || isDriverInCreative();
		        boolean consumed = false;
		        EngineFunction engine = vehicle.hasPart("engine") ? vehicle.getPart("engine").getFunction("fvtm:engine") : null;
		        if(engine != null && engine.isOn() ){//TODO FUELSYSTEM && vehicledata.getFuelTankContent() > engine.getFuelConsumption() * throttle){
		            //TODO FUELSYSTEM double d = (engine.getFuelConsumption() * throttle) / 80;//20, set lower to prevent too fast consumption.
		            consumed = true;//TODO FUELSYSTEM vehicledata.consumeFuel(d > 0 ? d : (engine.getFuelConsumption() / 320));
		        }
		        for(WheelEntity wheel : wheels){
		            if(wheel == null){ continue; }
		            onGround = false; wheel.onGround = false;
		            wheel.rotationYaw = axes.getYaw();
		            if(!lata.is_tracked && (wheel.wheelid == 2 || wheel.wheelid == 3)){
		                wheel.rotationYaw += wheelsYaw;
		            }
		            wheel.motionX *= 0.9F;
		            wheel.motionY *= 0.9F;
		            wheel.motionZ *= 0.9F;
		            wheel.motionY -= 0.98F / 20F;//Gravity
		            if(engine != null){
		                if((cant || consumed)){
		                    double velocityScale;
		                    if(lata.is_tracked){
		                        boolean left = wheel.wheelid == 0 || wheel.wheelid == 3;
		                        //
		                        float turningDrag = 0.02F;
		                        wheel.motionX *= 1F - (Math.abs(wheelsYaw) * turningDrag);
		                        wheel.motionZ *= 1F - (Math.abs(wheelsYaw) * turningDrag);
		                        //
		                        velocityScale = 0.04F * (throttle > 0 ? lata.max_throttle : lata.min_throttle) * engine.getLegacyEngineSpeed();
		                        float steeringScale = 0.1F * (wheelsYaw > 0 ? lata.turn_left_mod : lata.turn_right_mod);
		                        double effectiveWheelSpeed = (throttle + (wheelsYaw * (left ? 1 : -1) * steeringScale)) * velocityScale;
		                        wheel.motionX += effectiveWheelSpeed * Math.cos(wheel.rotationYaw * 3.14159265F / 180F);
		                        wheel.motionZ += effectiveWheelSpeed * Math.sin(wheel.rotationYaw * 3.14159265F / 180F);
		                    }
		                    else{
		                        velocityScale = 0.1F * throttle * (throttle > 0 ? lata.max_throttle : lata.min_throttle) * engine.getLegacyEngineSpeed();
		                        wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
		                        wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
		                        //
		                        if(wheel.wheelid == 2 || wheel.wheelid == 3){
		                            velocityScale = 0.01F * (wheelsYaw > 0 ? lata.turn_left_mod : lata.turn_right_mod) * (throttle > 0 ? 1 : -1);
		                            wheel.motionX -= wheel.getHorizontalSpeed() * Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
		                            wheel.motionZ += wheel.getHorizontalSpeed() * Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
		                        }
		                        else{
		                            wheel.motionX *= 0.9F;
		                            wheel.motionZ *= 0.9F;
		                        }
		                    }
		                }
		            }
		            if(world.containsAnyLiquid(wheel.getEntityBoundingBox())){
		                wheel.motionY += lata.bouyancy;
		            }
		            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
		            //pull wheel back to the boat
		            Vec3d targetpos = axes.getRelativeVector(vehicle.getWheelPositions().get(WHEELINDEX[wheel.wheelid]));
		            Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
		            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(lata.wheel_spring_strength);
		            if(despos.lengthSquared() > 0.001F){
		                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
		                despos = despos.scale(0.5F); atmc = atmc.subtract(despos);
		            }
		        }
		        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
			}
			else{
				Vec3d atmc = new Vec3d(0, 0, 0);
		        boolean canThrustCreatively = !Config.VEHICLES_NEED_FUEL || isDriverInCreative();
		        boolean consumed = false;
		        EngineFunction engine = vehicle.hasPart("engine") ? vehicle.getPart("engine").getFunction("fvtm:engine") : null;
		        if(!canThrustCreatively && engine != null && engine.isOn() ){//TODO FUELSYSTEM&& vehicledata.getFuelTankContent() > engine.getFuelCompsumption() * throttle){
		            //TODO FUELSYSTEM double d = (engine.getLegacyFuelConsumption() * throttle) / 80;//20, set lower to prevent too fast compsumption.
		            consumed = true;//TODO FUELSYSTEM vehicledata.consumeFuel(d > 0 ? d : (engine.getLegacyFuelConsumption() / 320));
		        }
		        for(WheelEntity wheel : wheels){
		            if(wheel == null){
		                continue;
		            }
		            onGround = true; wheel.onGround = true;
		            wheel.rotationYaw = axes.getYaw();
		            if(!lata.is_tracked && (wheel.wheelid == 2 || wheel.wheelid == 3)){
		                wheel.rotationYaw += wheelsYaw;
		            }
		            wheel.motionX *= 0.9F;
		            wheel.motionY *= 0.9F;
		            wheel.motionZ *= 0.9F;
		            wheel.motionY -= 0.98F / 20F;//Gravity
		            if(engine != null){
		                if((canThrustCreatively || consumed)){
		                    double velocityScale;
		                    if(lata.is_tracked){
		                        boolean left = wheel.wheelid == 0 || wheel.wheelid == 3;
		                        //
		                        float turningDrag = 0.02F;
		                        wheel.motionX *= 1F - (Math.abs(wheelsYaw) * turningDrag);
		                        wheel.motionZ *= 1F - (Math.abs(wheelsYaw) * turningDrag);
		                        //
		                        velocityScale = 0.04F * (throttle > 0 ? lata.max_throttle : lata.min_throttle) * engine.getLegacyEngineSpeed();
		                        float steeringScale = 0.1F * (wheelsYaw > 0 ? lata.turn_left_mod : lata.turn_right_mod);
		                        double effectiveWheelSpeed = (throttle + (wheelsYaw * (left ? 1 : -1) * steeringScale)) * velocityScale;
		                        wheel.motionX += effectiveWheelSpeed * Math.cos(wheel.rotationYaw * 3.14159265F / 180F);
		                        wheel.motionZ += effectiveWheelSpeed * Math.sin(wheel.rotationYaw * 3.14159265F / 180F);
		                    }
		                    else{
		                        velocityScale = 0.1F * throttle * (throttle > 0 ? lata.max_throttle : lata.min_throttle) * engine.getLegacyEngineSpeed();
		                        wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
		                        wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
		                        //
		                        if(wheel.wheelid == 2 || wheel.wheelid == 3){
		                            velocityScale = 0.01F * (wheelsYaw > 0 ? lata.turn_left_mod : lata.turn_right_mod) * (throttle > 0 ? 1 : -1);
		                            wheel.motionX -= wheel.getHorizontalSpeed() * Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
		                            wheel.motionZ += wheel.getHorizontalSpeed() * Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
		                        }
		                        else{
		                            wheel.motionX *= 0.9F;
		                            wheel.motionZ *= 0.9F;
		                        }
		                    }
		                }
		            }
		            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
		            //pull wheel back to car
		            Vec3d targetpos = axes.getRelativeVector(vehicle.getWheelPositions().get(WHEELINDEX[wheel.wheelid]));
		            Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
		            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(lata.wheel_spring_strength);
		            if(despos.lengthSquared() > 0.001F){
		                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
		                despos = despos.scale(0.5F); atmc = atmc.subtract(despos);
		            }
		            //
		            /*if(this.getEntityAtRear() != null){
		                this.getEntityAtRear().moveTrailer();
		            }*/
		        }
		        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
			}
		}
	}

    private void checkForCollisions(){
		// You expected anything here? Uff.
	}
    
    @Override
    public void updatePassenger(Entity passenger){
        //if(passenger instanceof LandVehicle){ ((VehicleEntity)passenger).moveTrailer(); }
    }

	@Override
    public boolean attackEntityFrom(DamageSource source, float amount){
        //Print.debug(damagesource.damageType, damagesource.getImmediateSource().toString());
        if(world.isRemote || isDead){
            return true;
        }
        if(source.damageType.equals("player") && getDriver() == null){
        	//if(ToggableHandler.handleClick(KeyPress.MOUSE_MAIN)) return true;
            if(vehicle.isLocked()){
                Print.chat(source.getImmediateSource(), "Vehicle is locked. Unlock to remove it.");
                return false;
            }
            else{
                if(vehicle.hasPart("engine") && vehicle.getPart("engine").hasFunction("fvtm:engine")){
                    vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(false);
                }
                ItemStack stack = vehicle.newItemStack();
                //
                /*if(PermissionAPI.hasPermission((EntityPlayer)source.getImmediateSource(), FvtmPermissions.VEHICLE_BREAK)
                	|| PermissionAPI.hasPermission((EntityPlayer)source.getImmediateSource(), FvtmPermissions.permBreak(stack))){
                    if(this.getEntityAtRear() != null){
                        Entity ent = this.getEntityAtRear().getEntity();
                        /*VehicleData rear = this.getEntityAtRear().getVehicleData();
                        rear.getScripts().forEach((script) -> script.onRemove(ent, rear));
                        ItemStack trailerstack = rear.getVehicle().getItemStack(rear);
                        ent.entityDropItem(trailerstack, 0.5F);
                        ent.setDead();
                        Print.debug(trailerstack.toString());*/
                        /*if(ent instanceof UnboundVehicleEntity){
                            ((UnboundVehicleEntity)this.getEntityAtRear()).parentent = null;
                        }
                        ent.dismountRidingEntity();
                    }*///TODO
                    //
                    entityDropItem(stack, 0.5F); setDead();
                    Print.debug(stack.toString());
                    return true;
                /*}
                else{
                    Print.chat(source.getImmediateSource(), "No permission to break this vehicle/type.");
                    return false;
                }*/
            }
        }
        return true;
	}

    @Override
    public ItemStack getPickedResult(RayTraceResult target){
        ItemStack stack = vehicle.getType().newItemStack();
        stack.setItemDamage(0); return stack;
    }

    //--- PACKETS ---//
    private long lr = -1;

    @SuppressWarnings("unused") @Override
    public void processServerPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("ScriptId")){
            for(VehicleScript script : vehicle.getScripts()){
                if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, vehicle, pkt.nbt, Side.SERVER);
                }
            }
        }
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "engine_toggle": {
                    if(lr + 1000 >= Time.getDate()){ break; }
                    lr = Time.getDate(); boolean on = false, nf = false; EngineFunction engine = vehicle.getPart("engine").getFunction("fvtm:engine");
                    pkt.nbt.setBoolean("engine_toggle_result", on = engine.toggle());
                    /*if(vehicledata.getFuelTankContent() == 0 || vehicledata.getFuelTankContent() < 0.1){
                        pkt.nbt.setBoolean("engine_toggle_result", on = false);
                        pkt.nbt.setBoolean("no_fuel", nf = true);
                    }*///TODO FUEL
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, pkt.nbt);
                    throttle = 0;
                    //
                    /*SoundEvent event = vehicledata.getPart("engine").getPart().getSound(nf ? "engine_fail" : on ? "engine_start" : "engine_stop");
                    if(event != null){
                        this.playSound(event, 0.5f, 1f);
                        //this.world.playSound(null, this.posX, this.posY, this.posZ, event, this.getSoundCategory(), 1f, 1f);
                        Print.debug((nf ? "engine_fail" : on ? "engine_start" : "engine_stop") + " -> Playing!");
                    }
                    else{
                        Print.debug((nf ? "engine_fail" : on ? "engine_start" : "engine_stop") + " -> Not found.");
                    }*///TODO SOUND
                    break;
                }
                case "resync": {
                    NBTTagCompound nbt = this.vehicle.write(new NBTTagCompound());
                    nbt.setString("task", "update_vehicledata");
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void processClientPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("ScriptId")){
            for(VehicleScript script : vehicle.getScripts()){
                if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, vehicle, pkt.nbt, Side.SERVER);
                }
            }
        }
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "engine_toggle": {
                	boolean riding = net.minecraft.client.Minecraft.getMinecraft().player.isRiding();
                    if(riding && this.getDriver() == net.minecraft.client.Minecraft.getMinecraft().player.getRidingEntity()){
                        Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Engine toggled " + (vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(pkt.nbt.getBoolean("engine_toggle_result")) ? "on" : "off") + ".");
                        if(pkt.nbt.hasKey("no_fuel") && pkt.nbt.getBoolean("no_fuel")){
                            Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Out of fuel!");
                        }
                    }
                    throttle = 0;
                    if(vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn() && this.engineloop == null){
                        /*SoundEvent event = vehicledata.getPart("engine").getPart().getSound("engine_running");
                        if(event != null){
                            this.engineloop = new EngineLoopSound(event, SoundCategory.NEUTRAL, this);
                            net.minecraft.client.Minecraft.getMinecraft().getSoundHandler().playSound(this.engineloop);
                            Print.debug("engine_running -> Playing! (LOOP)");
                        }
                        else{
                            Print.debug("engine_running -> Not found.");
                        }*///TODO sound
                    }
                    break;
                }
                case "resync":
                case "update_vehicledata": {
                    this.vehicle.read(pkt.nbt);
                    break;
                }
                case "lights_toggle": {
                    /*this.vehicledata.setLightsState(pkt.nbt.getInteger("lightsstate"));
                    if(this.getEntityAtRear() != null){
                        this.getEntityAtRear().getVehicleData().setLightsState(pkt.nbt.getInteger("lightsstate"));
                    }*///TODO
                    break;
                }
                case "update_connection":{
                	break;
                }
                case "update_trailer":{
                	/*int ent = pkt.nbt.getInteger("entity");
                	if(ent == -1){
                		VehicleEntity rear = this.getEntityAtRear();
                		if(rear != null){
                			rear.getEntity().dismountRidingEntity();
                			if(rear instanceof UnboundVehicleEntity){
                				((UnboundVehicleEntity)rear).parentent = null;
                			}
                			this.trailer = null;
                		}
                	}
                	else{
                		Entity trailer = world.getEntityByID(ent);
                		if(trailer instanceof VehicleEntity == false){
                			break;
                		}
                		if(trailer instanceof UnboundVehicleEntity){
                			((UnboundVehicleEntity)trailer).parentent = this;
                		}
                		trailer.startRiding(this);
                	}*///TODO
                	break;
                }
            }
        }
    }

	@Override
	public boolean isRailType(){
		return false;
	}
	
	@Override
	public void setupCapability(ContainerHolder capability){
		if(vehicle == null) return; if(world.isRemote){ capability.sync(true); return; }
		for(java.util.Map.Entry<String, PartData> entry : vehicle.getParts().entrySet()){
			if(!entry.getValue().hasFunction("fvtm:container")) continue;
			capability.addContainerSlot(entry.getValue().getFunction(ContainerFunction.class, "fvtm:container").getAsNewSlot(entry.getKey()));
			Print.debug("Added Container Slot from: " + entry.getValue().getType().getName() + " / " + entry.getKey());
		} ((Implementation)capability).setup = true;
	}

	@Override
	public double[] getEntityRotationForFvtmContainers(){
		return rotpoint.getAxes().toDoubles();//radians?
	}

}
