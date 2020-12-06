package net.fexcraft.mod.fvtm.sys.uni12;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_FUEL;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_MAIN;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.Time;
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
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHoldingEntity;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.util.LegacySpawnSystem;
import net.fexcraft.mod.fvtm.util.LoopSound;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.ContainerFunction;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.fexcraft.mod.fvtm.util.function.TireFunction;
import net.fexcraft.mod.fvtm.util.function.TransmissionFunction;
import net.fexcraft.mod.fvtm.util.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.util.packet.PKT_VehControl;
import net.fexcraft.mod.fvtm.util.packet.PKT_VehKeyPress;
import net.fexcraft.mod.fvtm.util.packet.PKT_VehKeyPressState;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
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
 */
public class ULandVehicle extends GenericVehicle implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate>, ContainerHoldingEntity {

	private VehicleData vehicle;
	public SwivelPoint rotpoint;
	//
	private UUID placer = UUID.fromString("f78a4d8d-d51b-4b39-98a3-230f2de0c670");
	//
	//public double throttle;
	public float wheelsAngle, serverWY;//, wheelsYaw;
    public float prevRotationYaw;
    public float prevRotationPitch;
    public float prevRotationRoll;
    public ULandVehicle truck, trailer;
    //public Vec3d angularVelocity = new Vec3d(0f, 0f, 0f);
    protected byte toggle_timer, gear_timer, autogear_timer;
    //
    public double serverPosX, serverPosY, serverPosZ;
    public double serverYaw, serverPitch, serverRoll;
    public int server_pos_ticker;
    public static final int servtick = 5;
    public static final String[] WHEELINDEX = new String[]{ "left_back_wheel", "right_back_wheel", "right_front_wheel", "left_front_wheel" };
    public static final String[] TRAILERWHEELINDEX = new String[]{ WHEELINDEX[0], WHEELINDEX[1] };
    //
    //
    //
    public ArrayList<Axle> axles = new ArrayList<>();
    public ArrayList<WTD> wheeldata = new ArrayList<>();
    public Axle front, rear;
    public double wheelbase, cg_height;
    public float wheel_radius;
    public boolean pbrake, braking;
    public EngineFunction engine;
    public TransmissionFunction transmission;

	public ULandVehicle(World world){	
		super(world);
		preventEntitySpawning = true; setSize(1f, 1f);
		ignoreFrustumCheck = true; stepHeight = 1f;
        if(world.isRemote){
            setRenderDistanceWeight(1d);
        }
        Print.debug("SPAWNING " + world.isRemote + " " + this.getEntityId());
	}
	
	/** Constructor to spawn either by a player or Constructor.
	 * 
	 * @param meta should be -1 or lower if placer rotation yaw matters
	 * */
	public ULandVehicle(World world, VehicleData data, Vec3d pos, @Nullable EntityPlayer placer, int meta){
		this(world); this.setPosition(pos.x, pos.y, pos.z); this.vehicle = data;
		if(placer != null) this.placer = placer.getGameProfile().getId();
		initializeVehicle(false);
		this.rotateYaw((placer == null || meta >= 0 ? (meta * 90f) : placer.rotationYaw) + 90f);
	}

	public ULandVehicle(World world, VehicleData data, EntityPlayer player, ULandVehicle truck){
		this(world, data, truck.getPositionVector(), player, 0);
		this.truck = truck; truck.trailer = this;
		rotpoint.updatePrevAxe();
		rotpoint.getAxes().setAngles(truck.rotpoint.getAxes().getYaw(), rotpoint.getAxes().getPitch(), rotpoint.getAxes().getRoll());
	}

	@Override
	protected void entityInit(){
		//
	}

	private void initializeVehicle(boolean remote){
        //lata = vehicle.getType().getLegacyData();
        wheels = new WheelEntity[WHEELINDEX.length];
        setupWheels();
        setupAxles();
        engine = vehicle.getFunctionInPart("engine", "fvtm:engine");
        transmission = vehicle.getFunctionInPart("transmission", "fvtm:transmission");
        if(seats == null) seats = new SeatCache[vehicle.getSeats().size()];
        for(int i = 0; i < seats.length; i++) seats[i] = new SeatCache(this, i);
        //stepHeight = lata.wheel_step_height;
        rotpoint = vehicle.getRotationPoint("vehicle");
        this.setSize(vehicle.getAttribute("hitbox_width").getFloatValue(), vehicle.getAttribute("hitbox_height").getFloatValue());
        ContainerHolderUtil.Implementation impl = (Implementation)this.getCapability(Capabilities.CONTAINER, null);
        if(impl != null){ impl.setup = false; this.setupCapability(impl); }
        else{ Print.debug("No ContainerCap Implementation Found!");}
        vehicle.getScripts().forEach((script) -> script.onSpawn(this, vehicle));
        //
        if(!remote && truck != null){
        	this.sendConnectionUpdate(); truck.sendConnectionUpdate();
        }
        //
	}

	private void setupAxles(){
		axles.clear();
        for(WTD wheel : wheeldata){
        	Axle axle = null;
        	if(axles.stream().anyMatch(a -> a.pos.x == wheel.pos.x && a.pos.y == wheel.pos.y)){
        		axle = axles.stream().filter(a -> a.pos.x == wheel.pos.x && a.pos.y == wheel.pos.y).findFirst().get();
        	}
        	else{
        		axle = new Axle(axles.size(), new Vec3d(wheel.pos.x, wheel.pos.y, 0));
            	axles.add(axle);
        	}
        	axle.wheels.add(wheel);
        	wheel.axle = axle;
        }
        axles.forEach(axle -> axle.initCenter());
        double amin = 0, amax = 0;
        for(Axle axle : axles){
        	if(axle.pos.x < amin){
        		amin = axle.pos.x;
        		rear = axle;
        	}
        	if(axle.pos.x > amax){
        		amax = axle.pos.x;
        		front = axle;
        	}
        }
        wheelbase = Math.abs(amin) + Math.abs(amax);
        cg_height = 0;
        for(Axle axle : axles){
        	axle.weight_ratio = Math.abs(axle.pos.x) / wheelbase;
        	cg_height = axle.pos.y;
        }
        cg_height /= axles.size();
	}
	
	private void setupWheels(){
		wheeldata.clear();
		wheel_radius = 0;
        for(Entry<String, Vec3d> entry : vehicle.getWheelPositions().entrySet()){
        	WTD wheel = new WTD(entry.getKey());
        	wheel.pos = entry.getValue();
        	PartData part = vehicle.getPart(entry.getKey());
        	if(!((WheelData)part.getType().getInstallationHandlerData()).hasTire()){
        		part = vehicle.getPart(entry.getKey() + ":tire");
        		wheel_radius += ((TireData)part.getType().getInstallationHandlerData()).getOuterRadius() * Static.sixteenth;
        	}
        	else{
        		wheel_radius += ((WheelData)part.getType().getInstallationHandlerData()).getRadius() * Static.sixteenth;
        	}
        	wheel.function = part.getFunction(TireFunction.class, "fvtm:tire").getTireAttr(part);
        	wheeldata.add(wheel);
        }
        wheel_radius /= wheeldata.size();
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		if(vehicle == null){
			vehicle = Resources.getVehicleData(compound);
		}
		else{
			vehicle.read(compound);
		}
		rotpoint = vehicle.getRotationPoint("vehicle");
		prevRotationYaw = compound.getFloat("RotationYaw");
		prevRotationPitch = compound.getFloat("RotationPitch");
		prevRotationRoll = compound.getFloat("RotationRoll");
		pbrake = compound.getBoolean("Parking");
		rotpoint.loadAxes(this, compound);
		initializeVehicle(world.isRemote); // Print.debug(compound.toString());
		super.readEntityFromNBT(compound);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		vehicle.write(compound);
		compound.setBoolean("Parking", pbrake);
		rotpoint.saveAxes(this, compound); //Print.debug(compound.toString());
		super.writeEntityToNBT(compound);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = rotpoint.saveAxes(this, new NBTTagCompound());
        if(truck != null) compound.setInteger("TruckId", truck.getEntity().getEntityId());
		ByteBufUtils.writeTag(buffer, vehicle.write(compound));
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
        try{
            NBTTagCompound compound = ByteBufUtils.readTag(buffer);
    		vehicle = Resources.getVehicleData(compound);
    		rotpoint = vehicle.getRotationPoint("vehicle");
            rotpoint.loadAxes(this, compound);
            prevRotationYaw = rotpoint.getAxes().getYaw();
            prevRotationPitch = rotpoint.getAxes().getPitch();
            prevRotationRoll = rotpoint.getAxes().getRoll();
            if(compound.hasKey("TruckId")){
            	truck = (ULandVehicle)world.getEntityByID(compound.getInteger("TruckId"));
            }
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
        if(truck != null){ truck.trailer = null; } if(trailer != null){ trailer.truck = null;}
        //Static.exception(null, false);
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

	@Override
	public SwivelPoint getRotPoint(){
		return rotpoint;
	}
	
	public WheelEntity[] getWheels(){
		return wheels;
	}
	@Override
	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player){
		return onKeyPress(key, seat, player, false);
	}

	@Override
	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player, boolean state){
		for(VehicleScript script : vehicle.getScripts()) if(script.onKeyPress(key, seat, player)) return true;
        if(!seat.driver && key.driverOnly()) return false;
        if(world.isRemote && !key.toggables()/*&& key.dismount()*/){
        	if(key.synced()){
                Packets.sendToServer(key.sync_state() ? new PKT_VehKeyPressState(this, player, key, state) : new PKT_VehKeyPress(key));
        	}
        	else{
                Packets.sendToServer(new PKT_VehKeyPress(key));
                return true;
        	}
        }
        switch(key){
            case ACCELERATE:{
                throttle += 0.05f;//01F;
                if(throttle > 1F) throttle = 1F;
                return true;
            }
            case DECELERATE:{
                throttle -= 0.05f;//01F;
                if(throttle < 0F) throttle = 0F;
                return true;
            }
            case TURN_LEFT:{
                wheelsYaw -= .5f;
                return true;
            }
            case TURN_RIGHT:{
                wheelsYaw += .5f;
                return true;
            }
            case BRAKE:{
                braking = state;
                return true;
            }
            case PBRAKE:{
            	if(toggle_timer > 0) return true;
                pbrake = !pbrake;
            	toggle_timer += 10;
                return true;
            }
            case ENGINE: {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setString("task", "engine_toggle");
                this.toggleEngine(compound); return true;
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
            	if(toggle_timer > 0) return true;
            	net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay.toggle();
            	toggle_timer += 10;
                return true;
            }
            case GEAR_UP: {
                if(gear_timer <= 0){
                	if(transmission == null) return true;
                	int gear = vehicle.getAttributeInteger("gear", 0);
                	if(transmission.isAutomatic()){
                		if(gear < 0){
                    		vehicle.getAttribute("gear").setValue(0);
                    		sendAttributeUpdate("gear");
                		}
                		else if(gear == 0){
                    		vehicle.getAttribute("gear").setValue(1);
                    		sendAttributeUpdate("gear");
                		}
                		autogear_timer += transmission.getShiftSpeed();
                	}
                	else if(gear + 1 <= transmission.getFGearAmount()){
                		vehicle.getAttribute("gear").setValue(gear + 1);
                		sendAttributeUpdate("gear");
                	}
                	gear_timer += 10;
                }
                return true;
            }
            case GEAR_DOWN: {
                if(gear_timer <= 0){
                	if(transmission == null) return true;
                	int gear = vehicle.getAttributeInteger("gear", 0);
                	if(transmission.isAutomatic()){
                		if(gear > 0){
                    		vehicle.getAttribute("gear").setValue(0);
                    		sendAttributeUpdate("gear");
                		}
                		else if(gear == 0){
                    		vehicle.getAttribute("gear").setValue(-1);
                    		sendAttributeUpdate("gear");
                		}
                		autogear_timer += transmission.getShiftSpeed();
                	}
                	else if(gear - 1 >= -transmission.getRGearAmount()){
                		vehicle.getAttribute("gear").setValue(gear - 1);
                		sendAttributeUpdate("gear");
                	}
                	gear_timer += 10;
                }
                return true;
            }
            case SCRIPTS: {
                /*if(!world.isRemote){
                    player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_SCRIPTSGUI, world, this.getEntityId(), seat, 0);
                    //open scripts gui
                }*/
                return true;
            }
            case LIGHTS: {
                if(toggle_timer <= 0){
                	if(vehicle.getAttribute("lights").getBooleanValue()){
                		if(vehicle.getAttribute("lights_long").getBooleanValue()){
                    		vehicle.getAttribute("lights").setValue(false);
                    		vehicle.getAttribute("lights_long").setValue(false);
                		}
                		else{
                    		vehicle.getAttribute("lights_long").setValue(true);
                		}
                	}
                	else{
                		vehicle.getAttribute("lights").setValue(true);
                	}
                	//
                    ULandVehicle trailer = this.trailer;
                    while(trailer != null){
                        trailer.vehicle.getAttribute("lights").setValue(vehicle.getAttribute("lights").getBooleanValue());
                        trailer.vehicle.getAttribute("lights_long").setValue(vehicle.getAttribute("lights_long").getBooleanValue());
                        trailer = trailer.trailer;
                    }
                	//TODO find a way for fog lights
                    toggle_timer = 10;
                    NBTTagCompound nbt = new NBTTagCompound();
                    nbt.setString("task", "toggle_lights");
                    nbt.setBoolean("lights", vehicle.getAttribute("lights").getBooleanValue());
                    nbt.setBoolean("lights_long", vehicle.getAttribute("lights_long").getBooleanValue());
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                }
                return true;
            }
            case COUPLER_REAR: {
        		if(throttle > 0 || throttle < 0){
        			Print.chat(player, "Please stop the vehicle first!");
        			return true;
        		}
        		if(this.vehicle.getRearConnector() == null){
        			Print.chat(player, "This vehicle does not have a rear connector installed.");
        			return true;
        		}
                if(toggle_timer <= 0){
                	if(this.getCoupledEntity(false) == null){
                		this.tryAttach(player);
                	}
                	else{
                		this.tryDetach(player);
                	}
                    toggle_timer = 10;
                }
            	return true;
            }
            default:{
            	/*Print.chat(player, String.format("Task for keypress %s not found.", key));*/
            	return false;
            }
        }
    }
	
	public boolean getKeyPressState(KeyPress key){
		if(key == KeyPress.BRAKE){
			return braking;
		}
		return false;
	}

	public void tryAttach(EntityPlayer player){
		Vec3d vec = this.getRotPoint().getAxes().getRelativeVector(this.getVehicleData().getRearConnector()).add(this.getPositionVector());
		AxisAlignedBB aabb = new AxisAlignedBB(vec.x - 0.5, vec.y - 0.5, vec.z - 0.5, vec.x + 0.5, vec.y + 0.5, vec.z + 0.5);
		List<Entity> list = world.getEntitiesInAABBexcluding(this, aabb, (ent) -> ent instanceof ULandVehicle);
		for(Entity ent : list){
			ULandVehicle veh = (ULandVehicle)ent;
			if(veh.truck == null){
				veh.truck = this; this.trailer = veh;
				this.sendConnectionUpdate(); veh.sendConnectionUpdate();
				Print.chat(player, "&a&oTrailer connected&c!"); return;
			} else continue;
		}
		Print.chat(player, "&c&oNo Trailer found at coupler position.");
		Print.debugChat(vec.toString());
	}

	private void sendConnectionUpdate(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("task", "connections_update");
		compound.setInteger("truck", truck == null ? -1 : truck.getEntityId());
		compound.setInteger("trailer", trailer == null ? -1 : trailer.getEntityId());
		ApiUtil.sendEntityUpdatePacketToAllAround(this, compound);
	}

	public void tryDetach(EntityPlayer player){
		if(this.getCoupledEntity(false) == null) return;
		trailer.truck = null; ULandVehicle trailer = this.trailer; this.trailer = null;
		trailer.sendConnectionUpdate(); this.sendConnectionUpdate();
		Print.chat(player, "&c&oTrailer disconnected&a!");
	}

	@Override
	public UUID getPlacer(){
		return placer;
	}
	
    public void rotateYaw(float rotateBy){
        if(Math.abs(rotateBy) < 0.01F){ return; }
        rotpoint.getAxes().rotateYawD(rotateBy);
        updatePrevAngles();
    }

    public void rotatePitch(float rotateBy){
        if(Math.abs(rotateBy) < 0.01F){ return; }
        rotpoint.getAxes().rotatePitchD(rotateBy);
        updatePrevAngles();
    }

    public void rotateRoll(float rotateBy){
        if(Math.abs(rotateBy) < 0.01F){ return; }
        rotpoint.getAxes().rotateRollD(rotateBy);
        updatePrevAngles();
    }

    public void updatePrevAngles(){
        double yaw = rotpoint.getAxes().getYaw() - prevRotationYaw;
        if(yaw > 180){ prevRotationYaw += 360F; }
        if(yaw < -180){ prevRotationYaw -= 360F; }
        double pitch = rotpoint.getAxes().getPitch() - prevRotationPitch;
        if(pitch > 180){ prevRotationPitch += 360F; }
        if(pitch < -180){ prevRotationPitch -= 360F; }
        double roll = rotpoint.getAxes().getRoll() - prevRotationRoll;
        if(roll > 180){ prevRotationRoll += 360F; }
        if(roll < -180){ prevRotationRoll -= 360F; }
    }

    public void setRotation(float rotYaw, float rotPitch, float rotRoll){
    	rotpoint.getAxes().setAngles(rotYaw, rotPitch, rotRoll);
    }

	public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, Vec3d avel, double throttle, double steeringYaw, int fuel){
        if(world.isRemote){
            serverPosX = posX; serverPosY = posY; serverPosZ = posZ;
            serverYaw = yaw; serverPitch = pitch; serverRoll = roll;
            server_pos_ticker = servtick;
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
        vehicle.getAttribute("fuel_stored").setValue(fuel);
	}
	
	/*@Override
    public void setPosition(double x, double y, double z){
        super.setPosition(x, y, z);
    }*/

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posrotincr, boolean teleport){
        return; /*if(ticksExisted > 1){ Print.debug("setPositionAndRotationDirect"); return; }
        if(this.getDriver() != null && this.getDriver() instanceof EntityPlayer){
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
		return front ? truck : trailer;
	}
	
	@Override
	public VehicleEntity getFrontCoupledEntity(){
		return truck;
	}
	
	@Override
	public VehicleEntity getRearCoupledEntity(){
		return trailer;
	}

    @Override
    public void applyEntityCollision(Entity entity){
    	//Print.debug(entity); return;
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
                VehicleData data = ((VehicleItem)stack.getItem()).getData(stack);
                if(data.getType().isTrailerOrWagon()){
                	if(vehicle.getRearConnector() == null){
                		Print.chat(player, "&cThis vehicle has no rear connector installed.");
                		Print.debug(vehicle.getRearConnector(), vehicle.getType().getDefaultRearConnector());
                		return true;
                	}
                	if(!LegacySpawnSystem.validToSpawn(player, stack, data, false)) return true;
                	if(trailer != null){
                		Print.chat(player, "&cPlease disconnect the currently connected trailer first.");
                		return true;
                	}
                	//TODO connector checks
                	world.spawnEntity(new ULandVehicle(world, data, player, this));
                	return true;
                }
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

    @Override
    public void onUpdate(){
        super.onUpdate(); if(this.isDead) return;
        if(vehicle == null){ Print.log("VehicleData is NULL; Not ticking vehicle."); Static.stop(); return; }
        if(!world.isRemote){
            for(int i = 0; i < wheels.length; i++){
                if(wheels[i] == null || !wheels[i].addedToChunk){
                    wheels[i] = new WheelEntity(this, i); world.spawnEntity(wheels[i]);
                }
            }
        }
        prevRotationYaw = rotpoint.getAxes().getYaw();
        prevRotationPitch = rotpoint.getAxes().getPitch();
        prevRotationRoll = rotpoint.getAxes().getRoll();
        rotpoint.updatePrevAxe();
        this.ticksExisted++;
        if(this.ticksExisted > Integer.MAX_VALUE){
            this.ticksExisted = 0;
        }
        //
        if(toggle_timer > 0){
            toggle_timer--;
        }
        if(gear_timer > 0){
            gear_timer--;
        }
        if(autogear_timer > 0){
            autogear_timer--;
        }
        //
        if(!world.isRemote){ wheelsYaw *= 0.95F;  }
        if(wheelsYaw > 45){ wheelsYaw = 45; }//TODO vehicle attr
        if(wheelsYaw < -45){ wheelsYaw = -45; }//TODO vehicle attr
        px = posX;
        py = posY;
        pz = posZ;
        if(world.isRemote){
            if(server_pos_ticker > 0){
                double x = posX + (serverPosX - posX) / server_pos_ticker;
                double y = posY + (serverPosY - posY) / server_pos_ticker;
                double z = posZ + (serverPosZ - posZ) / server_pos_ticker;
                double dYaw = MathHelper.wrapDegrees(serverYaw - rotpoint.getAxes().getYaw());
                double dPitch = MathHelper.wrapDegrees(serverPitch - rotpoint.getAxes().getPitch());
                double dRoll = MathHelper.wrapDegrees(serverRoll - rotpoint.getAxes().getRoll());
                rotationYaw = (float)(rotpoint.getAxes().getYaw() + dYaw / server_pos_ticker);
                rotationPitch = (float)(rotpoint.getAxes().getPitch() + dPitch / server_pos_ticker);
                float rotationRoll = (float)(rotpoint.getAxes().getRoll() + dRoll / server_pos_ticker);
                --server_pos_ticker;
                setPosition(x, y, z);
                setRotation(rotationYaw, rotationPitch, rotationRoll); //return;
                float old = wheelsYaw; wheelsYaw = wheelsYaw + (serverWY - wheelsYaw) / server_pos_ticker;
                if(wheelsYaw != wheelsYaw) wheelsYaw = old;
            }
            vehicle.getAttribute("steering_angle").setValue(wheelsYaw);
            wheelsAngle += speed * (wheel_radius * 2 * Static.PI) * (vehicle.getAttributeInteger("gear", 0) >= 0 ? 1 : -1);
            if(wheelsAngle > 360) wheelsAngle -= 360; if(wheelsAngle < -360) wheelsAngle += 360;
        	vehicle.getAttribute("wheel_angle").setValue(wheelsAngle);
        	vehicle.getAttribute("throttle").setValue((float)throttle);
        }
        for(WheelEntity wheel : wheels){
            if(wheel != null){
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
            if(getDriver() == null || !(isDriverInCreative() || vehicle.getAttribute("fuel_stored").getIntegerValue() > 0)){
                throttle *= 0.98F;
            }
            this.onUpdateMovement();
            if(trailer != null) trailer.alignTrailer();
            //
            if(wheels[0] != null && wheels[1] != null && wheels[2] != null && wheels[3] != null){
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
                /*if(lata.is_tracked){
                    yaw = (float) Math.atan2(wheels[3].posZ - wheels[2].posZ, wheels[3].posX - wheels[2].posX) + (float) Math.PI / 2F;
                }*///TODO TRACKED DEFINITION
                rotpoint.getAxes().setAngles(yaw * 180F / 3.14159F, pitch * 180F / 3.14159F, roll * 180F / 3.14159F);
            }
        }
        else{
        	if(engine != null && transmission != null){
            	int gear = vehicle.getAttributeInteger("gear", 0);
            	float diff = vehicle.getAttributeFloat("differential_ratio", 3.5f);
            	rpm = (int)((speed / wheel_radius) * transmission.getRatio(gear) * diff * 60 / Static.PI2);
            	if(rpm < 0) rpm = -rpm;
            	if(rpm < engine.minRPM()) rpm = engine.minRPM();
            	if(rpm > engine.maxRPM()) rpm = engine.maxRPM();
            	rpm = rpm / 100 * 100;
        	}
        	//for the GUI
        }
        //
		double x = posX - px, y = posY - py, z = posZ - pz;
		oos = os;
		os = speed;
		speed = (float)Math.sqrt(x * x + y * y + z * z) * 1000F / 20f;// / 16F;
		speed = (oos + os + speed) / 3d;
		//
        for(SwivelPoint point : vehicle.getRotationPoints().values()) point.update(this);
        vehicle.getScripts().forEach((script) -> script.onUpdate(this, vehicle));
        checkForCollisions();
        for(SeatCache seat : seats) seat.updatePosition();
        /*if(drivenByPlayer){
            PacketHandler.getInstance().sendToServer(new PacketVehicleControl(this));
            serverPosX = posX; serverPosY = posY; serverPosZ = posZ; serverYaw = axes.getYaw();
        }*/
        if(!world.isRemote && ticksExisted % 5 == 0){
        	vehicle.getAttribute("throttle").setValue((float)throttle);
            Packets.sendToAllAround(new PKT_VehControl(this), Resources.getTargetPoint(this));
            for(SwivelPoint point : vehicle.getRotationPoints().values()) point.sendClientUpdate(this);
        }
    }
    
    public static final float GRAVITY = 9.81f, GRAVE = GRAVITY / 200F;
    public static final float TICKA = 1f / 20f, o132 = Static.sixteenth / 2;
    private double px, py, pz, oos, os;
    private double accx = 0f;
	public int orpm, rpm;

	public void onUpdateMovement(){
		double mass = vehicle.getAttributeFloat("weight", 1000f);
		double rr = vehicle.getAttributeFloat("roll_resistance", 8f);
		double ar = vehicle.getAttributeFloat("air_resistance", 2.5f);
		for(Axle axle : axles) axle.calc(mass, accx, cg_height, wheelbase, 1f);
		//
		Vec3d atmc = new Vec3d(0, 0, 0);
        //EngineFunction engine = vehicle.getFunctionInPart("engine", "fvtm:engine");
        boolean consumed = processConsumption(engine);
        boolean nopass = this.getPassengers().isEmpty();
        
        float brkf = vehicle.getAttributeFloat("brake_force", 10000f);
    	double brake = Math.min((braking ? brkf : 0) + (pbrake ? vehicle.getAttributeFloat("parking_brake_force", 5000f) : 0), brkf);
    	//TransmissionFunction trans = vehicle.getFunctionInPart("transmission", "fvtm:transmission");
    	int gear = vehicle.getAttributeInteger("gear", 0);
    	float diff = vehicle.getAttributeFloat("differential_ratio", 3.5f);
    	VehicleSteeringOverlay.STRS.clear();
    	VehicleSteeringOverlay.STRS.add("ORPM: " + (rpm < 100 ? 100 : rpm / 100 * 100));
    	if(engine != null && transmission != null){
        	//orpm = rpm;
        	rpm = (int)((speed / wheel_radius) * transmission.getRatio(gear) * diff * 60 / Static.PI2);
        	//rpm = (orpm + rpm) / 2;
        	if(rpm < 0) rpm = -rpm;
        	if(rpm < engine.minRPM()) rpm = engine.minRPM();
        	if(rpm > engine.maxRPM()) rpm = engine.maxRPM();
    	}
    	float force = 0;
    	if(transmission != null){
    		force = engine.getTorque(rpm) * transmission.getRatio(gear) * diff * transmission.getEfficiency() / wheel_radius;
        	if(transmission.isAutomatic() && autogear_timer <= 0){
        		int ngear = transmission.processAutoShift(gear, rpm, engine.maxRPM(), throttle);
        		if(ngear != gear){
        			vehicle.getAttribute("gear").setValue(ngear);
        			sendAttributeUpdate("gear");
        		}
        		autogear_timer += transmission.getShiftSpeed();
        	}
    	}
    	VehicleSteeringOverlay.STRS.add("NRPM: " + (rpm < 100 ? 100 : rpm / 100 * 100));
    	double thr = this.throttle * force;
    	double cos = Math.cos(rotpoint.getAxes().getYaw() * 3.14159265F / 180F);
    	double sin = Math.sin(rotpoint.getAxes().getYaw() * 3.14159265F / 180F);
        //
    	accx = 0;
    	if(!vehicle.getType().isTrailerOrWagon()){ //if(truck != null) return;
	        for(WheelEntity wheel : wheels){
	            if(wheel == null){ continue; }
	            WTD wheeldata = getWheelData(wheel.getIndex());
	            onGround = true; wheel.onGround = true;
	            wheel.rotationYaw = rotpoint.getAxes().getYaw();
	            /*if(!lata.is_tracked && (wheel.wheelid == 2 || wheel.wheelid == 3)){
	                wheel.rotationYaw += wheelsYaw;
	            }*/////TODO TRACKED DEFINITION
	            BlockPos wheelpos = new BlockPos(wheel.posX, wheel.posY - o132, wheel.posZ);
	        	boolean rainfall = world.isRainingAt(wheelpos);
	            Material mat = world.getBlockState(wheelpos).getMaterial();
	            if(throttle < 0.001f || speed < 3 || nopass){
	            	boolean brk = braking || pbrake;
	            	double by = brk ? 0 : speed < 3 ? 0.9 : 0.99;
		            wheel.motionX *= by;
		            wheel.motionY *= by;
		            wheel.motionZ *= by;
	            }
	            wheel.motionY -= GRAVE;
	            //
	        	double motx = cos * wheel.motionX + sin * wheel.motionZ;
	        	double moty = cos * wheel.motionZ - sin * wheel.motionX;
	            double stew = wheelsYaw * 3.14159265F / 180F;
	            double steer = wheel.slot.steering() ? Math.signum(motx) * stew : 0;
	            double slip_angle = Math.atan2(moty + wheeldata.axle.yaw_speed, Math.abs(motx)) - steer;
	            double grip = wheeldata.function.getGripFor(mat, rainfall) * (wheel.slot.braking() && pbrake ? wheeldata.function.brake_grip : 1);
	        	double frict = Static.clamp((wheeldata.function.getCornerStiffnessFor(mat, wheel.slot.steering())) * slip_angle, -grip, grip) * wheeldata.axle.weight_on;
	        	double trac = wheeldata.function.getGripFor(mat, rainfall) * ((consumed ? thr : 0) - brake * Math.signum(motx));//grip inclusion here is for testing
	        	double dragx = -rr * motx - ar * motx * Math.abs(motx);
	        	double dragy = -rr * moty - ar * moty * Math.abs(moty);
	        	double totalx = dragx + trac;
	        	double totaly = dragy + (wheel.slot.steering() ? Math.cos(stew) * frict : 0);
	        	double acx = (totalx / mass) * TICKA;
	        	double acy = (totaly / mass) * TICKA;
	        	accx += acx;
	        	//
                double val;
                /*if(lata.is_tracked){//TODO update
                    boolean left = wheel.wheelid == 0 || wheel.wheelid == 3;
                    //
                    float turningDrag = 0.02F;
                    wheel.motionX *= 1F - (Math.abs(wheelsYaw) * turningDrag);
                    wheel.motionZ *= 1F - (Math.abs(wheelsYaw) * turningDrag);
                    //
                    val = 0.04F * (throttle > 0 ? lata.max_throttle : lata.min_throttle) * engine.getLegacyEngineSpeed();
                    float steeringScale = 0.1F * (wheelsYaw > 0 ? lata.turn_left_mod : lata.turn_right_mod);
                    double effectiveWheelSpeed = (throttle + (wheelsYaw * (left ? 1 : -1) * steeringScale)) * val;
                    wheel.motionX += effectiveWheelSpeed * Math.cos(wheel.rotationYaw * 3.14159265F / 180F);
                    wheel.motionZ += effectiveWheelSpeed * Math.sin(wheel.rotationYaw * 3.14159265F / 180F);
                }//TODO TRACKED DEFINITION
                else*/{
                    val = acx;
                    wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * val * Config.U12_MOTION_SCALE;
                    wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * val * Config.U12_MOTION_SCALE;
                    //
                    if(wheel.slot.steering()){
                    	//val = wheelsYaw > 1 ? 1 : wheelsYaw < -1 ? -1 : wheelsYaw;
                        val = acy / 20f;
                        wheel.motionX -= Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * val * wheelsYaw;
                        wheel.motionZ += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * val * wheelsYaw;
                    }
                    else{
                        wheel.motionX *= 0.95F;
                        wheel.motionZ *= 0.95F;
                    }
                }
	            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
	            //pull wheel back to car
	            Vec3d targetpos = rotpoint.getAxes().getRelativeVector(vehicle.getWheelPositions().get(WHEELINDEX[wheel.wheelid]));
	            Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
	            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(0.5f);//TODO lata.wss
	            if(despos.lengthSquared() > 0.001F){
	                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
	                despos = despos.scale(0.5F); atmc = atmc.subtract(despos);
	            }
	        }
	        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
	        accx /= wheels.length;
		}
		/*else{
			int wheelid = 0;
	        for(WheelEntity wheel : wheels){
	            if(wheel == null){ continue; }
	            onGround = true; wheel.onGround = true;
	            wheel.rotationYaw = rotpoint.getAxes().getYaw();
	            if(!lata.is_tracked && (wheel.wheelid == 2 || wheel.wheelid == 3)){
	                wheel.rotationYaw += wheelsYaw;
	            }
	            wheel.motionX *= 0.9F;
	            wheel.motionY *= 0.9F;
	            wheel.motionZ *= 0.9F;
	            wheel.motionY -= 0.98F / 20F;//Gravity
	            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
	            Vec3d s = null;
	        	if(wheelid >= 2 && this.getVehicleData().getType().isTrailerOrWagon()){
	        		s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid == 2 ? 1 : 0]);
	        		s = new Vec3d(0, s.y, s.z);
	        	}
	        	else{
	        		s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid]);
	        	}
	            Vec3d targetpos = rotpoint.getAxes().getRelativeVector(s);
	            Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
	            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(lata.wheel_spring_strength);
	            if(despos.lengthSquared() > 0.001F){
	                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
	                despos = despos.scale(0.5F); atmc = atmc.subtract(despos);
	            }
	            wheelid++;
	        }
	        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
		}*/
	}

	public WTD getWheelData(String index){
		for(WTD wheel : wheeldata){
			if(wheel.id.equals(index)) return wheel;
		}
		return null;
	}

	public void alignTrailer(){
        prevPosX = posX; prevPosY = posY; prevPosZ = posZ; if(wheelnull() || truck == null){ return; }
        Vec3d conn = truck.rotpoint.getAxes().getRelativeVector(truck.getVehicleData().getRearConnector());
        this.setPosition(truck.posX + conn.x, truck.posY + conn.y, truck.posZ + conn.z);
        //
        this.throttle = truck.throttle;
        double thrt = /*calculateSpeed(truck)*/ truck.throttle > 0 ? truck.throttle : -truck.throttle;
        double rawy = truck.rotpoint.getAxes().getYaw() - rotpoint.getAxes().getYaw();
        double diff = rawy * thrt * 0.2;
        //Print.debug(rawy, diff);
        diff = rawy > 0 ? (diff > rawy ? rawy : diff) : (diff < rawy ? rawy : diff);
        rotpoint.getAxes().setRotation(rotpoint.getAxes().getRadianYaw() + Math.toRadians(diff), rotpoint.getAxes().getRadianPitch(), rotpoint.getAxes().getRadianRoll());
        //
        alignWheels();
	}

    private final void alignWheels(){
        for(int wheelid = 0; wheelid < wheels.length; wheelid++){
            if(wheels[wheelid] == null ){ continue; }
            WheelEntity wheel = wheels[wheelid];
            onGround = true; wheel.onGround = true;
            wheel.rotationYaw = rotpoint.getAxes().getYaw();
            //
            Vec3d s = null;
        	if(wheelid >= 2 && getVehicle().isTrailerOrWagon()){
        		s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid == 2 ? 1 : 0]);
        		s = new Vec3d(0, s.y, s.z);
        	}
        	else{ s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid]); }
            Vec3d targetpos = rotpoint.getAxes().getRelativeVector(s), current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(getVehicle().getLegacyData().wheel_spring_strength);
            if(despos.lengthSquared() > 0.001F){
                wheel.move(MoverType.SELF, despos.x, (despos.y /*- (0.98F / 20F)*/), despos.z);
            }
            //
            if(wheel.getPositionVector().distanceTo(this.getPositionVector()) > 256){//1024
                wheel.posX = despos.x;
                wheel.posY = despos.y;
                wheel.posZ = despos.z;
            }
        }
    }
    
    public boolean wheelnull(){
    	if(wheels == null) return true;
    	for(WheelEntity ent : wheels) if(ent == null) return true;
    	return false;
    }
	
	private byte accumulator;
	private float consumed;

    private boolean processConsumption(EngineFunction engine){
    	if(engine == null) return false;
    	if(!Config.VEHICLES_NEED_FUEL) return true;
    	if(accumulator < 20){
    		if(!engine.isOn() || isDriverInCreative()){
    			//pass
    		}
    		else if(throttle == 0f || (throttle < 0.05f && throttle > -0.05f)){
    			consumed += engine.getIdleFuelConsumption();
    		}
    		else{
    			consumed += engine.getFuelConsumption(vehicle.getAttribute("fuel_secondary").getStringValue()) * throttle;
    		}
    		accumulator++; return true;
    	}
    	else{
    		if(consumed > 0){
    			int con = (int)(consumed / 20f);
    			vehicle.getAttribute("fuel_stored").decrease(con < 1 ? 1 : con);
    		}
    		if(engine.isOn() && vehicle.getAttribute("fuel_stored").getFloatValue() <= 0){
    			NBTTagCompound compound  = new NBTTagCompound();
    			compound.setString("task", "engine_toggle");
    			compound.setBoolean("engine_toggle_result", false);
            	compound.setBoolean("no_fuel", true); throttle = 0;
                ApiUtil.sendEntityUpdatePacketToAllAround(this, compound);
    		}
    		accumulator = 0; consumed = 0; return true;
    	}
	}

	private void checkForCollisions(){
		// You expected anything here? Uff.
	}
    
    /*@Override
    public void updatePassenger(Entity passenger){
        //if(passenger instanceof LandVehicle){ ((VehicleEntity)passenger).moveTrailer(); }
    }*/

	@Override
    public boolean attackEntityFrom(DamageSource source, float amount){
        //Print.debug(damagesource.damageType, damagesource.getImmediateSource().toString());
        if(world.isRemote || isDead){
            return true;
        }
        if(source.damageType.equals("player") && getDriver() == null){
        	//if(ToggableHandler.handleClick(KeyPress.MOUSE_MAIN)) return true;
            if(vehicle.isLocked()){
                Print.chat(source.getImmediateSource(), "Vehicle is locked. Unlock if you want to remove it.");
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
        ItemStack stack = vehicle.newItemStack();
        stack.setItemDamage(0);
        return stack;
    }

    //--- PACKETS ---//
    private long lr = -1;

    @Override
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
                	this.toggleEngine(pkt.nbt); break;
                }
                case "resync": {
                    NBTTagCompound nbt = this.vehicle.write(new NBTTagCompound());
                    nbt.setString("task", "update_vehicledata");
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                }
            }
        }
    }

    private void toggleEngine(NBTTagCompound compound){
        if(lr + 1000 >= Time.getDate()){ return; }
        lr = Time.getDate(); /*boolean on = false, nf = false;*/ EngineFunction engine = vehicle.getPart("engine").getFunction("fvtm:engine");
        compound.setBoolean("engine_toggle_result", /*on =*/ engine.toggle());
        if(vehicle.getStoredFuel() == 0){
        	compound.setBoolean("engine_toggle_result", /*on =*/ false);
            compound.setBoolean("no_fuel", /*nf =*/ true);
        }
        ApiUtil.sendEntityUpdatePacketToAllAround(this, compound); throttle = 0;
        /*Sound sound = vehicle.getSound(nf ? "engine_fail" : on ? "engine_start" : "engine_stop");
        if(sound != null){
            this.playSound(sound.event, 0.5f, 1f);
            Print.debug((nf ? "engine_fail" : on ? "engine_start" : "engine_stop") + " -> Playing!");
        }
        else{
            Print.debug((nf ? "engine_fail" : on ? "engine_start" : "engine_stop") + " -> Not found.");
        }*///Think that's already done client side?
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
                    if(riding && getDriver() == net.minecraft.client.Minecraft.getMinecraft().player.getRidingEntity()){
                    	boolean state = pkt.nbt.getBoolean("engine_toggle_result"); EntityPlayer player = net.minecraft.client.Minecraft.getMinecraft().player;
                        Print.chat(player, "Engine toggled " + (vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(state) ? "on" : "off") + ".");
                        if(pkt.nbt.hasKey("no_fuel") && pkt.nbt.getBoolean("no_fuel")){
                            Print.chat(player, "Out of fuel!"); vehicle.playSound(this, "engine_fail");
                        } else vehicle.playSound(this, state ? "engine_start" : "engine_stop");
                    }
                    throttle = 0;
                    if(vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn() && this.engineloop == null){
                        SoundEvent event = vehicle.getSound("engine_running").event;
                        if(event != null){
                            this.engineloop = new LoopSound(event, SoundCategory.NEUTRAL, this);
                            net.minecraft.client.Minecraft.getMinecraft().getSoundHandler().playSound(this.engineloop);
                            Print.debug("engine_running -> Playing! (LOOP)");
                        }
                        else{
                            Print.debug("engine_running -> Not found.");
                        }
                    }
                    break;
                }
                case "resync":
                case "update_vehicledata": {
                    this.vehicle.read(pkt.nbt);
                    break;
                }
                case "toggle_lights": {
                    vehicle.getAttribute("lights").setValue(pkt.nbt.getBoolean("lights"));
                    vehicle.getAttribute("lights_long").setValue(pkt.nbt.getBoolean("lights_long"));
                    ULandVehicle trailer = this.trailer;
                    while(trailer != null){
                        trailer.vehicle.getAttribute("lights").setValue(pkt.nbt.getBoolean("lights"));
                        trailer.vehicle.getAttribute("lights_long").setValue(pkt.nbt.getBoolean("lights_long"));
                        trailer = trailer.trailer;
                    }
                    break;
                }
                case "connections_update":{
                	Print.debug(this);
                	int truck = pkt.nbt.getInteger("truck"); Print.debug("packet result t0" + truck);
                	if(truck == -1) this.truck = null; else this.truck = (ULandVehicle)world.getEntityByID(truck);
                	int trailer = pkt.nbt.getInteger("trailer"); Print.debug("packet result t1" + trailer);
                	if(trailer == -1) this.trailer = null; else this.trailer = (ULandVehicle)world.getEntityByID(trailer);
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

	@Override
	public boolean isRailType(){
		return false;
	}
	
	@Override
	public boolean isBraking(){
		return braking;
	}

}
