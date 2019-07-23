package net.fexcraft.mod.fvtm.sys.legacy;

import java.util.UUID;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.vehicle.LegacyData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.util.Axis3D;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.util.packet.PKT_VehControl;
import net.fexcraft.mod.fvtm.util.packet.PKT_VehKeyPress;
import net.fexcraft.mod.fvtm.util.packet.Packets;
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
public class LandVehicle extends GenericVehicle implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {

	private LegacyData lata;
	private VehicleData vehicle;
	public Axis3D axes, prevaxes;
	//
	public SeatEntity[] seats;
	private UUID placer = UUID.fromString("f78a4d8d-d51b-4b39-98a3-230f2de0c670");
	//
	//public double throttle;
	public float wheelsAngle, serverWY;//, wheelsYaw;
    public float prevRotationYaw, prevRotationPitch, prevRotationRoll;
    public VehicleEntity truck, trailer;
    //public Vec3d angularVelocity = new Vec3d(0f, 0f, 0f);
    protected byte doorToggleTimer;
    protected Object engineloop;//TODO sound
    //
    public double serverPosX, serverPosY, serverPosZ;
    public double serverYaw, serverPitch, serverRoll;
    public int serverPositionTransitionTicker;
    public static final int servtick = 5;
    public static final String[] WHEELINDEX = new String[]{ "left_back_wheel", "right_back_wheel", "right_front_wheel", "left_front_wheel" };

	public LandVehicle(World ilmondo){
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
	public LandVehicle(World world, VehicleData data, Vec3d pos, @Nullable EntityPlayer placer, int meta){
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
        seats = new SeatEntity[vehicle.getSeats().size()];
        stepHeight = lata.wheel_step_height;
        this.setupCapability(null);//TODO this.getCapability(FVTMCaps.CONTAINER, null));
        //TODO data.getScripts().forEach((script) -> script.onCreated(this, vehicledata));
	}

	//TODO
	private void setupCapability(Object object){
		//
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
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		vehicle.write(compound); axes.write(this, compound); //Print.debug(compound.toString());
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = axes.write(this, new NBTTagCompound());
        if(truck != null) compound.setInteger("TruckId", truck.getEntity().getEntityId());
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
            /*for(Part.PartData partData : this.vehicledata.getInventoryContainers()){
                InventoryAttribute.InventoryAttributeData invattr = partData.getAttributeData(InventoryAttribute.InventoryAttributeData.class);
                if(invattr == null){
                    continue;
                }
                for(int i = 0; i < invattr.getInventory().size(); i++){
                    this.entityDropItem(invattr.getInventory().get(i), 0.5f);
                    invattr.getInventory().set(i, ItemStack.EMPTY);
                }
            }*///TODO
        }
        //this.getCapability(FVTMCaps.CONTAINER, null).dropContents(); //TODO
        //
        super.setDead();
        if(seats != null) for(SeatEntity seat : seats) if(seat != null) seat.setDead();
        if(wheels != null) for(WheelEntity wheel : wheels) if(wheel != null) wheel.setDead();
        //
        //TODO vehicledata.getScripts().forEach((script) -> script.onRemove(this, vehicledata));
        if(this.getCoupledEntity(true) != null){
        	this.dismountRidingEntity(); ((LandVehicle)this.getCoupledEntity(true)).trailer = null;
        }
        if(this.getCoupledEntity(false) != null){
        	this.getCoupledEntity(false).getEntity().dismountRidingEntity(); ((LandVehicle)this.getCoupledEntity(false)).truck = null;
        }
        if(world.isRemote){
        	//TODO ? net.fexcraft.mod.fvtm.util.RenderCache.removeEntity(this);
        }
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

	public Axis3D getAxes(){
		return axes;
	}
	
	public WheelEntity[] getWheels(){
		return wheels;
	}
	
	public SeatEntity[] getSeats(){
		return seats;
	}

	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player){
		//Print.debug(key, seat.driver, key.dismount(), key.scripts(), player, seat);
        if(!seat.driver && !key.dismount() && !key.scripts() && !key.toggables()){
            return false;
        }
        if(world.isRemote && !key.toggables() /*&& key.dismount() */){
            Packets.sendToServer(new PKT_VehKeyPress(key));
            return true;
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
                return true;
            }
            case DISMOUNT: {
                Packets.sendToAllAround(new PKT_VehControl(this), Resources.getTargetPoint(this));
                player.dismountRidingEntity();
                return true;
            }
            case INVENTORY: {
                if(!world.isRemote){
                    if(vehicle.getPart("engine") != null && vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
                        Print.chat(player, "Turn engine off first!");
                    }
                    else{
                    	NBTTagCompound compound = new NBTTagCompound();
	                    compound.setString("target_listener", "fcl_gui");
	                    compound.setString("task", "open_gui");
	                    compound.setString("guimod", "fvtm");
	                    compound.setInteger("gui", 930);
	                    compound.setIntArray("args", new int[]{ 0, 0, 0 });
	                    PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
                    }
                    //open inventory
                }
                return true;
            }
            case TOGGABLES: {
                if(world.isRemote){
                	if(doorToggleTimer > 0) return true;
                	net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay.toggle();
                	doorToggleTimer += 10;
                }
                return true;
            }
            case SCRIPTS: {
                /*if(!world.isRemote){
                    player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_SCRIPTSGUI, world, this.getEntityId(), seat, 0);
                    //open scripts gui
                }
                return true;*/
            }
            case LIGHTS: {
                /*if(!world.isRemote){
                    if(doorToggleTimer <= 0){
                        int i = vehicledata.getLightsState();
                        vehicledata.setLightsState(++i > 3 ? 0 : i < 0 ? 0 : i);
                        if(this.getEntityAtRear() != null){
                            this.getEntityAtRear().getVehicleData().setLightsState(vehicledata.getLightsState());
                        }
                        switch(vehicledata.getLightsState()){
                            case 0: {
                                Print.chat(player, "Lights Off.");
                                break;
                            }
                            case 1: {
                                Print.chat(player, "Lights On.");
                                break;
                            }
                            case 2: {
                                Print.chat(player, "(Long) Lights On.");
                                break;
                            }
                            case 3: {
                                Print.chat(player, "(Fog) Lights On.");
                                break;
                            }
                        }
                        doorToggleTimer = 10;
                        NBTTagCompound nbt = new NBTTagCompound();
                        nbt.setString("task", "lights_toggle");
                        nbt.setInteger("lightsstate", vehicledata.getLightsState());
                        ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                    }
                }*/
                return true;
            }
            case COUPLER_REAR: {
            	/*if(!world.isRemote){
            		if(throttle > 0 || throttle < 0){
            			Print.chat(player, "Please stop the vehicle first!");
            			return true;
            		}
            		if(this.vehicledata.getRearConnectorPos() == null){
            			Print.chat(player, "This vehicle does not have a rear connector installed.");
            			return true;
            		}
                    if(doorToggleTimer <= 0){
                    	if(this.getEntityAtRear() == null){
                    		this.tryAttach(player);
                    	}
                    	else{
                    		this.tryDetach(player);
                    	}
                        doorToggleTimer = 10;
                    }
            	}*/
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
        if(Math.abs(rotateBy) < 0.01F){
            return;
        }
        axes.rotateRollD(rotateBy);
        updatePrevAngles();
    }

    public void updatePrevAngles(){
        double yaw = axes.getYaw() - prevRotationYaw;
        if(yaw > 180){
            prevRotationYaw += 360F;
        }
        if(yaw < -180){
            prevRotationYaw -= 360F;
        }
        double pitch = axes.getPitch() - prevRotationPitch;
        if(pitch > 180){
            prevRotationPitch += 360F;
        }
        if(pitch < -180){
            prevRotationPitch -= 360F;
        }
        double roll = axes.getRoll() - prevRotationRoll;
        if(roll > 180){
            prevRotationRoll += 360F;
        }
        if(roll < -180){
            prevRotationRoll -= 360F;
        }
    }

    public void setRotation(float rotYaw, float rotPitch, float rotRoll){
        axes.setAngles(rotYaw, rotPitch, rotRoll);
    }

	public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, Vec3d avel, double throttle, double steeringYaw){
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
        motionX = motX; motionY = motY; motionZ = motZ; angularVelocity = avel;
        this.throttle = throttle; serverWY = (float)steeringYaw;
	}

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posrotincr, boolean teleport){
        return; /*if(ticksExisted > 1){ Print.debug("setPositionAndRotationDirect"); return; }
        if(this.getControllingPassenger() != null && this.getControllingPassenger() instanceof EntityPlayer){
            //
        }
        else{
            double xx = x - posX, yy = y - posY, zz = z - posZ;
            double xyz = xx * xx + yy * yy + zz * zz; if(xyz <= 1.0D){ return; }
            serverPositionTransitionTicker = servtick / 2;
            serverPosX = x; serverPosY = y; serverPosZ = z;
            serverYaw = yaw; serverPitch = pitch;
        }*/
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
        return vehicle.getType().getName();
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
		return front ? truck : trailer;
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
            /*if(stack.getItem() instanceof FuelItem){//TODO fuel
                player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_INVENTORY, world, 2, 0, 0);
                return true; }*/
            if(stack.getItem() instanceof VehicleItem){
                //TODO append trailer
            }
            //TODO other Item interaction
        }
        /*if(!vehicle.getScripts().isEmpty()){
            for(VehicleScript script : vehicledata.getScripts()){
                if(script.onInteract(this, vehicledata, player, hand)){
                    return true;
                }
            }
        }*///TODO scripts
        for(SeatEntity seat : seats){ if(seat.processInitialInteract(player, hand)){ return true; } }
        return false;
    }

    protected boolean isDriverInGM1(){
        return seats != null && seats.length > 0 && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer
        	&& ((EntityPlayer)seats[0].getControllingPassenger()).capabilities.isCreativeMode;
    }

    public boolean hasEnoughFuel(){
        return isDriverInGM1() || true;//(vehicle != null && vehicle.getPart("engine") != null && vehicledata.getFuelTankContent() > vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle);
    }

    public boolean isDrivenByPlayer(){
        if(vehicle.getType().isTrailerOrWagon()){
        	LandVehicle veh = (LandVehicle)getCoupledEntity(true);
            return veh != null && veh.getSeats()[0] != null && SeatEntity.isPassengerThePlayer(veh.getSeats()[0]);
        }
        else{
            return seats[0] != null && SeatEntity.isPassengerThePlayer((SeatEntity)seats[0]);
        }
    }

    @SuppressWarnings("unused")
	@Override
    public void onUpdate(){
        super.onUpdate();
        if(vehicle == null){ Print.log("VehicleData is NULL; Not ticking vehicle."); Static.stop(); return; }
        if(!world.isRemote){
        	for(int i = 0; i < vehicle.getSeats().size(); i++){
        		Seat seat = vehicle.getSeat(i);
            	if(seats[i] == null || !seats[i].addedToChunk){
            		seats[i] = new SeatEntity(this, i); world.spawnEntity(seats[i]);
            	}
        	}
            for(int i = 0; i < WHEELINDEX.length; i++){
                if(wheels[i] == null || !wheels[i].addedToChunk){
                    wheels[i] = new WheelEntity(this, i); world.spawnEntity(wheels[i]);
                }
            }
            if(vehicle.getType().isTrailerOrWagon()){
            	if(getCoupledEntity(true) == null){
                	if(wheels.length == 2){
                		wheels = new WheelEntity[]{ wheels[0], wheels[1], null, null };
                	}
                	if(wheels[2] == null || !wheels[2].addedToChunk){
                        wheels[2] = new WheelEntity(this, 2);
                        world.spawnEntity(wheels[2]);
                    }
                	if(wheels[3] == null || !wheels[3].addedToChunk){
                        wheels[3] = new WheelEntity(this, 2);
                        world.spawnEntity(wheels[3]);
                    }
            	}
            	else{
            		if(wheels.length > 2){
            			if(wheels[2] != null){ wheels[2].setDead(); }
            			if(wheels[3] != null){ wheels[3].setDead(); }
            			wheels = new WheelEntity[]{ wheels[0], wheels[1] };
            		}
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
        if(!world.isRemote){ wheelsYaw *= 0.95F;  }
        if(wheelsYaw > 30){ wheelsYaw = 30; } if(wheelsYaw < -30){ wheelsYaw = -30; }
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
                float old = wheelsYaw; wheelsYaw = wheelsYaw + (serverWY - wheelsYaw) / serverPositionTransitionTicker;
                if(wheelsYaw != wheelsYaw) wheelsYaw = old;
            }
            vehicle.getAttribute("steering_angle").setValue(wheelsYaw);
            double cir = ((WheelData)vehicle.getPart("left_front_wheel").getType().getInstallationHandlerData()).getRadius() * 2 * Static.PI;
            wheelsAngle += throttle * cir; if(wheelsAngle > 360) wheelsAngle -= 360; if(wheelsAngle < -360) wheelsAngle += 360;
        	vehicle.getAttribute("wheel_angle").setValue(wheelsAngle);
        	vehicle.getAttribute("throttle").setValue(throttle);
        }
        for(WheelEntity wheel : wheels){
            if(wheel != null && world != null){
                wheel.prevPosX = wheel.posX;
                wheel.prevPosY = wheel.posY;
                wheel.prevPosZ = wheel.posZ;
            }
        }
        if(!world.isRemote){// && vehicle.getType().isTrailerOrWagon() ? this.wheels.length > 2 : true){
            /*if(hasEnoughFuel()){
                //wheelsAngle += throttle * 20; if(wheelsAngle > 360) wheelsAngle = -360; if(wheelsAngle < -360) wheelsAngle = 360;
                //animation stuff }*/
            //
            if((seats.length > 0 && seats[0] != null && seats[0].getControllingPassenger() == null) || !(isDriverInGM1() || true/*vehicle.getFuelTankContent() > 0*/) && lata.max_throttle != 0){
                throttle *= 0.98F;
            }
            this.onUpdateMovement();
            //
            if(wheels[0] != null && wheels[1] != null && wheels.length > 2 && wheels[2] != null && wheels[3] != null){
                Vec3d front = new Vec3d((wheels[2].posX + wheels[3].posX) / 2F, (wheels[2].posY + wheels[3].posY) / 2F, (wheels[2].posZ + wheels[3].posZ) / 2F);
                Vec3d back = new Vec3d((wheels[0].posX + wheels[1].posX) / 2F, (wheels[0].posY + wheels[1].posY) / 2F, (wheels[0].posZ + wheels[1].posZ) / 2F);
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
                roll = -(float) Math.atan2(dry, drxz);
                //
                if(lata.is_tracked){
                    yaw = (float) Math.atan2(wheels[3].posZ - wheels[2].posZ, wheels[3].posX - wheels[2].posX) + (float) Math.PI / 2F;
                }
                axes.setAngles(yaw * 180F / 3.14159F, pitch * 180F / 3.14159F, roll * 180F / 3.14159F);
            }
        }
        else{
        	
        }
        //TODO scripts vehicle.getScripts().forEach((script) -> script.onUpdate(this, vehicledata));
        checkForCollisions();
        for(SeatEntity seat : seats){ if(seat != null){ seat.updatePosition(); } }
        /*if(drivenByPlayer){
            PacketHandler.getInstance().sendToServer(new PacketVehicleControl(this));
            serverPosX = posX; serverPosY = posY; serverPosZ = posZ; serverYaw = axes.getYaw();
        }*/
        if(!world.isRemote && ticksExisted % 5 == 0){
            Packets.sendToAllAround(new PKT_VehControl(this), Resources.getTargetPoint(this));
        }
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
		        boolean canThrustCreatively = !Config.VEHICLES_NEED_FUEL || (seats != null && seats[0] != null
		        	&& seats[0].getControllingPassenger() instanceof EntityPlayer
		        	&& ((EntityPlayer)seats[0].getControllingPassenger()).capabilities.isCreativeMode);
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
		        boolean canThrustCreatively = !Config.VEHICLES_NEED_FUEL || (seats != null && seats[0] != null
		        	&& seats[0].getControllingPassenger() instanceof EntityPlayer
		        	&& ((EntityPlayer)seats[0].getControllingPassenger()).capabilities.isCreativeMode);
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
        if(source.damageType.equals("player") && (seats.length > 0 ? (seats[0] == null || seats[0].getControllingPassenger() == null) : true)){
            if(vehicle.isLocked()){
                Print.chat(source.getImmediateSource(), "Vehicle is locked. Unlock to remove it.");
                return false;
            }
            else{
                if(vehicle.hasPart("engine") && vehicle.getPart("engine").hasFunction("fvtm:engine")){
                    vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(false);
                }
                //TODO vehicle.getScripts().forEach((script) -> script.onRemove(this, vehicledata));
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
        /*if(pkt.nbt.hasKey("ScriptId")){
            for(VehicleScript script : vehicledata.getScripts()){
                if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, vehicledata, pkt.nbt, Side.SERVER);
                }
            }
        }*///TODO
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
        /*if(pkt.nbt.hasKey("ScriptId")){
            for(VehicleScript script : vehicledata.getScripts()){
                if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, vehicledata, pkt.nbt, Side.SERVER);
                }
            }
        }*///TODO
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "engine_toggle": {
                    if(net.minecraft.client.Minecraft.getMinecraft().player.isRiding() && this.seats[0] == net.minecraft.client.Minecraft.getMinecraft().player.getRidingEntity()){
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
                	int ent = pkt.nbt.getInteger("entity");
                	if(ent == -1){
                		trailer = null;
                	}
                	else{
                		trailer = (VehicleEntity)world.getEntityByID(ent);
                	}
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

	/*@Override
	public void setupCapability(ContainerHolder cap){
		if(vehicledata == null || this.vehicledata.getContainerHolders().isEmpty()) return;
		if(world.isRemote){ cap.sync(true); return; }
		cap.setOnlyOneContainer(this.vehicledata.getContainerHolders().size() < 2);
		for(java.util.Map.Entry<String, PartData> entry : this.vehicledata.getParts().entrySet()){
    		if(entry.getValue().getPart().getAttribute(ContainerAttribute.class) != null){
    			ContainerAttribute condata = entry.getValue().getPart().getAttribute(ContainerAttribute.class);
    			cap.addContainerSlot(entry.getKey(), condata.getContainerOffset().to16Double(),
    				condata.getContainerType(), condata.getContainerRotation(), condata.getSupportedTypes());
    		}
		} cap.setSetup(true); cap.sync(false);
	}*/

	/*@Override
	public float[] getEntityRotationForContainer(){
		return new float[]{ (float)axes.getRadianYaw(), (float)axes.getRadianPitch(), (float)axes.getRadianRoll() };
	}*/

}
