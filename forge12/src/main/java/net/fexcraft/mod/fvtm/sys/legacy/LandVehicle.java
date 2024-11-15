package net.fexcraft.mod.fvtm.sys.legacy;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.vehicle.*;
import net.fexcraft.mod.fvtm.function.part.ContainerFunction;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.packet.Packet_VehKeyPress;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.EntitySystem;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.ess.SimplePhysSpawnSystem;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.impl.SWIE;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.MessageSenderI;
import net.fexcraft.mod.uni.world.WrapperHolder;
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

import javax.annotation.Nullable;
import java.util.UUID;

import static net.fexcraft.mod.fvtm.Config.*;
import static net.fexcraft.mod.fvtm.ui.UIKeys.VEHICLE_MAIN;

/**
 * @author Ferdinand Calo' (FEX___96)
 * <br>
 * "Legacy" Main class for Vehicles.
 */
public class LandVehicle extends GenericVehicle implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {

	private SimplePhysData lata;
	private VehicleData vehicle;
	public SwivelPoint rotpoint;
	//
	private UUID placer = UUID.fromString("f78a4d8d-d51b-4b39-98a3-230f2de0c670");
	//
	//public double throttle;
	public float wheelsAngle, serverWY;//, wheelsYaw;
    public LandVehicle truck, trailer;
    //public Vec3d angularVelocity = new Vec3d(0f, 0f, 0f);
    protected byte doorToggleTimer;
    //
    public double serverPosX, serverPosY, serverPosZ;
    public double serverYaw, serverPitch, serverRoll;
    public int serverPositionTransitionTicker;
    public static final int servtick = 5;
    public static final String[] WHEELINDEX = new String[]{ "left_back_wheel", "right_back_wheel", "right_front_wheel", "left_front_wheel" };
    public static final String[] TRAILERWHEELINDEX = new String[]{ WHEELINDEX[0], WHEELINDEX[1] };

	public LandVehicle(World ilmondo){
		super(ilmondo);
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
		initializeVehicle(false);
		rotpoint.getPivot().set_yaw((placer == null || meta >= 0 ? (meta * 90f) : placer.rotationYaw) + 90f, true);
	}

	public LandVehicle(World world, VehicleData data, EntityPlayer player, LandVehicle truck){
		this(world, data, truck.getPositionVector(), player, 0);
		this.truck = truck; truck.trailer = this;
		rotpoint.updatePrevAxe();
		rotpoint.getPivot().copy(truck.getRotPoint().getPivot());
	}

	@Override
	protected void entityInit(){
		//
	}

	private void initializeVehicle(boolean remote){
        lata = vehicle.getType().getSphData();
        wheels = new WheelEntity[WHEELINDEX.length];
        if(seats == null) seats = new SeatInstance[vehicle.getSeats().size()];
        for(int i = 0; i < seats.length; i++) seats[i] = null;//TODO new SeatInstance(this, i);
        stepHeight = lata.wheel_step_height;
        rotpoint = vehicle.getRotationPoint("vehicle");
        this.setSize(vehicle.getAttribute("hitbox_width").asFloat(), vehicle.getAttribute("hitbox_height").asFloat());
        ContainerHolderUtil.Implementation impl = (Implementation)this.getCapability(Capabilities.CONTAINER, null);
        if(impl != null){ impl.setup = false; this.setupCapability(impl); }
        else{ Print.debug("No ContainerCap Implementation Found!");}
        //TODO vehicle.getScripts().forEach((script) -> script.onSpawn(this, vehicle));
        //
        if(!remote && truck != null){
        	this.sendConnectionUpdate(); truck.sendConnectionUpdate();
        }
        if(remote){
        	float c = vehicle.getAttributeFloat("collision_range", 2f);
        	renderbox = new AxisAlignedBB(-c, -c, -c, c, c, c);
    		EntitySystem system = SystemManager.get(Systems.ENTITY, WrapperHolder.getWorld(world));
			//if(system != null) system.add(this);
        }
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		if(vehicle == null){
			vehicle = FvtmResources.INSTANCE.getVehicleData(new TagCWI(compound));
		}
		else{
			vehicle.read(new TagCWI(compound));
		}
		rotpoint = vehicle.getRotationPoint("vehicle");
		prevRotationYaw = compound.getFloat("RotationYaw");
		prevRotationPitch = compound.getFloat("RotationPitch");
		prevRotationRoll = compound.getFloat("RotationRoll");
		rotpoint.loadPivot(new TagCWI(compound));
		initializeVehicle(world.isRemote); // Print.debug(compound.toString());
		super.readEntityFromNBT(compound);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		vehicle.write(new TagCWI(compound));
		rotpoint.savePivot(new TagCWI(compound)); //Print.debug(compound.toString());
		super.writeEntityToNBT(compound);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = new NBTTagCompound();
		rotpoint.savePivot(new TagCWI(compound));
        if(truck != null) compound.setInteger("TruckId", truck.getEntity().getEntityId());
		ByteBufUtils.writeTag(buffer, vehicle.write(new TagCWI(compound)).local());
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
        try{
            NBTTagCompound compound = ByteBufUtils.readTag(buffer);
    		vehicle = FvtmResources.INSTANCE.getVehicleData(new TagCWI(compound));
    		rotpoint = vehicle.getRotationPoint("vehicle");
            rotpoint.loadPivot(new TagCWI(compound));
            prevRotationYaw = rotpoint.getPivot().deg_yaw();
            prevRotationPitch = rotpoint.getPivot().deg_pitch();
            prevRotationRoll = rotpoint.getPivot().deg_roll();
            if(compound.hasKey("TruckId")){
            	truck = (LandVehicle)world.getEntityByID(compound.getInteger("TruckId"));
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
        if(VEHICLES_DROP_CONTENTS && !world.isRemote){
            for(String part : vehicle.getInventories()){
            	InventoryFunction func = vehicle.getPart(part).getFunction("fvtm:inventory");
            	if(func == null) continue;
        		func.inventory().dropAllAt(this.getCapability(Capabilities.PASSENGER, null).asWrapper());
            }
        }
        this.getCapability(Capabilities.CONTAINER, null).dropContents();
        //
        super.setDead();
        //if(seats != null) for(SeatEntity seat : seats) if(seat != null) seat.setDead();
        if(wheels != null) for(WheelEntity wheel : wheels) if(wheel != null) wheel.setDead();
        //
        //TODO vehicle.getScripts().forEach((script) -> script.onRemove(this, vehicle));
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

	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player){
		//TODO for(VehicleScript script : vehicle.getScripts()) if(script.onKeyPress(key, seat, player)) return true;
        if(!seat.driver && key.driver_only()) return false;
        if(world.isRemote && !key.toggables() /*&& key.dismount()*/){
			Packets.send(Packet_VehKeyPress.class, key);
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
                wheelsYaw -= 0.5f;//1F
                return true;
            }
            case TURN_RIGHT:{
                wheelsYaw += 0.5f;//1F
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
                this.toggleEngine();
                return true;
            }
            case DISMOUNT: {
                //TODO PacketsImpl.sendToAllAround(new PKT_VehControl(this), getTargetPoint(this));
                player.dismountRidingEntity();
                return true;
            }
            case INVENTORY: {
                /*if(vehicle.getPart("engine") != null && vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
                    Print.chat(player, "Turn engine off first!"); return true;
                }*/
            	player.openGui(FVTM.getInstance(), VEHICLE_MAIN.id, world, 0, this.getEntityId(), 0);
                return true;
            }
            case TOGGABLES: {//client side
            	if(doorToggleTimer > 0) return true;
            	net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay.toggle();
            	doorToggleTimer += 10;
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
                if(doorToggleTimer <= 0){
                	if(vehicle.getAttribute("lights").asBoolean()){
                		if(vehicle.getAttribute("lights_long").asBoolean()){
                    		vehicle.getAttribute("lights").set(false);
                    		vehicle.getAttribute("lights_long").set(false);
                		}
                		else{
                    		vehicle.getAttribute("lights_long").set(true);
                		}
                	}
                	else{
                		vehicle.getAttribute("lights").set(true);
                	}
                	//
                    LandVehicle trailer = this.trailer;
                    while(trailer != null){
                        trailer.vehicle.getAttribute("lights").set(vehicle.getAttribute("lights").asBoolean());
                        trailer.vehicle.getAttribute("lights_long").set(vehicle.getAttribute("lights_long").asBoolean());
                        trailer = trailer.trailer;
                    }
                	//TODO find a way for fog lights
                    doorToggleTimer = 10;
                    NBTTagCompound nbt = new NBTTagCompound();
                    nbt.setString("task", "toggle_lights");
                    nbt.setBoolean("lights", vehicle.getAttribute("lights").asBoolean());
                    nbt.setBoolean("lights_long", vehicle.getAttribute("lights_long").asBoolean());
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                }
                return true;
            }
            case COUPLER_REAR: {
        		if(throttle > 0 || throttle < 0){
        			Print.chat(player, "Please stop the vehicle first!");
        			return true;
        		}
        		/*if(this.vehicle.getRearConnector() == null){
        			Print.chat(player, "This vehicle does not have a rear connector installed.");
        			return true;
        		}*///TODO
                if(doorToggleTimer <= 0){
                	if(this.getCoupledEntity(false) == null){
                		this.tryAttach(player);
                	}
                	else{
                		this.tryDetach(player);
                	}
                    doorToggleTimer = 10;
                }
            	return true;
            }
            default:{ Print.chat(player, String.format("Task for keypress %s not found.", key)); return false; }
        }
    }

	public void tryAttach(EntityPlayer player){
		/*V3D vec = this.getRotPoint().getPivot().get_vector(this.getVehicleData().getRearConnector()).add(posX, posY, posZ);
		AxisAlignedBB aabb = new AxisAlignedBB(vec.x - 0.5, vec.y - 0.5, vec.z - 0.5, vec.x + 0.5, vec.y + 0.5, vec.z + 0.5);
		List<Entity> list = world.getEntitiesInAABBexcluding(this, aabb, (ent) -> ent instanceof LandVehicle);
		for(Entity ent : list){
			LandVehicle veh = (LandVehicle)ent;
			if(veh.truck == null){
				veh.truck = this; this.trailer = veh;
				this.sendConnectionUpdate(); veh.sendConnectionUpdate();
				Print.chat(player, "&a&oTrailer connected&c!"); return;
			} else continue;
		}
		Print.chat(player, "&c&oNo Trailer found at coupler position.");
		Print.debugChat(vec.toString());*///TODO
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
		trailer.truck = null; LandVehicle trailer = this.trailer; this.trailer = null;
		trailer.sendConnectionUpdate(); this.sendConnectionUpdate();
		Print.chat(player, "&c&oTrailer disconnected&a!");
	}

	@Override
	public UUID getPlacer(){
		return placer;
	}

    public void updatePrevAngles(){
        double yaw = rotpoint.getPivot().deg_yaw() - prevRotationYaw;
        if(yaw > 180){ prevRotationYaw += 360F; }
        if(yaw < -180){ prevRotationYaw -= 360F; }
        double pitch = rotpoint.getPivot().deg_pitch() - prevRotationPitch;
        if(pitch > 180){ prevRotationPitch += 360F; }
        if(pitch < -180){ prevRotationPitch -= 360F; }
        double roll = rotpoint.getPivot().deg_roll() - prevRotationRoll;
        if(roll > 180){ prevRotationRoll += 360F; }
        if(roll < -180){ prevRotationRoll -= 360F; }
    }

    @Override
	public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double throttle, double steeringYaw, int fuel){
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
            rotpoint.getPivot().set_rotation(yaw, pitch, roll, true);
        }
        this.throttle = throttle; serverWY = (float)steeringYaw;
        vehicle.getAttribute("fuel_stored").set(fuel);
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
        return RENDER_OUT_OF_VIEW ? true : super.isInRangeToRenderDist(dist);
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
        if(isDead || hand == EnumHand.OFF_HAND){ return false; }
        ItemStack stack = player.getHeldItem(hand);
		Passenger pass = player.getCapability(Capabilities.PASSENGER, null).asWrapper();
        if(world.isRemote){
        	if((!stack.isEmpty() && stack.getItem() instanceof PartItem == false) || Lockable.isKey(FvtmRegistry.getItem(stack.getItem().getRegistryName().toString()))) return true;
            if(vehicle.getLock().isLocked()){
            	Print.chat(player, "Vehicle is locked.");
            	return true;
            }
        	//TODO ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT, this, null, player, stack);
        	return true;
        }
		if(Lockable.isKey(FvtmRegistry.getItem(stack.getItem().getRegistryName().toString()))){
			vehicle.getLock().toggle(new MessageSenderI(player), new SWIE(stack));
        	this.sendLockStateUpdate();
        	return true;
        }
        if(!stack.isEmpty()){
            if(stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getContent().isFuelContainer()){
            	pass.openUI(UIKeys.VEHICLE_FUEL, new V3I(getEntityId(), 0, 0));
            	return true;
            }
            else if(stack.getItem() instanceof VehicleItem){
                VehicleData data = ((VehicleItem)stack.getItem()).getDataFromTag(stack.getTagCompound());
                if(data.getType().isTrailer()){
                	/*if(vehicle.getRearConnector() == null){
                		Print.chat(player, "&cThis vehicle has no rear connector installed.");
                		Print.debug(vehicle.getRearConnector(), vehicle.getType().getDefaultConnectorRear());
                		return true;
                	}*///TODO
                	if(!SimplePhysSpawnSystem.validToSpawn(UniEntity.getEntity(player), StackWrapper.wrap(stack), data)) return true;
                	if(trailer != null){
                		Print.chat(player, "&cPlease disconnect the currently connected trailer first.");
                		return true;
                	}
                	//TODO connector checks
                	world.spawnEntity(new LandVehicle(world, data, player, this));
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
                	player.openGui(FVTM.getInstance(), VEHICLE_MAIN.id, world, 0, this.getEntityId(), 0);
                }
                return true;
            }
        }
        if(vehicle.getLock().isLocked()){
        	Print.chat(player, "Vehicle is locked.");
        	return true;
        }
        //else if(ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT)) return true;
        /*if(!vehicle.getScripts().isEmpty()){
            for(VehicleScript script : vehicle.getScripts()){
                if(script.onInteract(this, vehicle, player, hand)){
                    return true;
                }
            }
        }*///TODO
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
        prevRotationYaw = rotpoint.getPivot().deg_yaw();
        prevRotationPitch = rotpoint.getPivot().deg_pitch();
        prevRotationRoll = rotpoint.getPivot().deg_roll();
        rotpoint.updatePrevAxe();
        this.ticksExisted++;
        if(this.ticksExisted > Integer.MAX_VALUE){
            this.ticksExisted = 0;
        }
        //
        if(doorToggleTimer > 0){
            doorToggleTimer--;
        }
        //
        if(!world.isRemote){ wheelsYaw *= 0.95F; }
        if(wheelsYaw > 30){ wheelsYaw = 30; } if(wheelsYaw < -30){ wheelsYaw = -30; }
        if(world.isRemote){
            if(serverPositionTransitionTicker > 0){
                double x = posX + (serverPosX - posX) / serverPositionTransitionTicker;
                double y = posY + (serverPosY - posY) / serverPositionTransitionTicker;
                double z = posZ + (serverPosZ - posZ) / serverPositionTransitionTicker;
                double dYaw = MathHelper.wrapDegrees(serverYaw - rotpoint.getPivot().deg_yaw());
                double dPitch = MathHelper.wrapDegrees(serverPitch - rotpoint.getPivot().deg_pitch());
                double dRoll = MathHelper.wrapDegrees(serverRoll - rotpoint.getPivot().deg_roll());
                rotationYaw = (float)(rotpoint.getPivot().deg_yaw() + dYaw / serverPositionTransitionTicker);
                rotationPitch = (float)(rotpoint.getPivot().deg_pitch() + dPitch / serverPositionTransitionTicker);
                float rotationRoll = (float)(rotpoint.getPivot().deg_roll() + dRoll / serverPositionTransitionTicker);
                wheelsYaw += (serverWY - wheelsYaw) / serverPositionTransitionTicker;
                --serverPositionTransitionTicker; setPosition(x, y, z);
                rotpoint.getPivot().set_rotation(rotationYaw, rotationPitch, rotationRoll, true); //return;
            }
            vehicle.getAttribute("steering_angle").set(wheelsYaw);
            double cir = ((WheelData)vehicle.getPart("left_back_wheel").getType().getInstallHandlerData()).getRadius() * 2 * Static.PI;
            wheelsAngle += throttle * cir; if(wheelsAngle > 360) wheelsAngle -= 360; if(wheelsAngle < -360) wheelsAngle += 360;
        	vehicle.getAttribute("wheel_angle").set(wheelsAngle);
        	vehicle.getAttribute("throttle").set((float)throttle);
        	vehicle.getAttribute("speed").set((float)speed);
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
            if(getDriver() == null || !(isDriverInCreative() || vehicle.getAttribute("fuel_stored").asInteger() > 0) && lata.max_throttle != 0){
                throttle *= 0.98F;
            }
            this.onUpdateMovement(); if(trailer != null){ trailer.alignTrailer(); }
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
                if(vehicle.getType().isTracked()){
                    yaw = (float) Math.atan2(wheels[3].posZ - wheels[2].posZ, wheels[3].posX - wheels[2].posX) + (float) Math.PI / 2F;
                }
                rotpoint.getPivot().set_rotation(yaw, pitch, roll, false);
            }
        }
        else{
        	speed = net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay.calculateSpeed(this);
        }
        //TODO for(SwivelPoint point : vehicle.getRotationPoints().values()) point.update(this);
        //TODO for(SeatCache seat : seats) seat.updatePosition();
        //TODO vehicle.getScripts().forEach((script) -> script.onUpdate(this, vehicle));
        checkForCollisions();
        /*if(drivenByPlayer){
            PacketHandler.getInstance().sendToServer(new PacketVehicleControl(this));
            serverPosX = posX; serverPosY = posY; serverPosZ = posZ; serverYaw = axes.deg_yaw();
        }*/
        if(!world.isRemote && ticksExisted % 5 == 0){
        	vehicle.getAttribute("throttle").set((float)throttle);
            //TODO PacketsImpl.sendToAllAround(new PKT_VehControl(this), getTargetPoint(this));
            //TODO for(SwivelPoint point : vehicle.getRotationPoints().values()) point.sendClientUpdate(this);
        }
    }

	public void onUpdateMovement(){
		if(vehicle.getType().isTrailer()){ //if(truck != null) return;
			V3D atmc = new V3D(0, 0, 0); int wheelid = 0;
	        for(WheelEntity wheel : wheels){
	            if(wheel == null){ continue; }
	            onGround = true; wheel.onGround = true;
	            wheel.rotationYaw = rotpoint.getPivot().deg_yaw();
	            if(!vehicle.getType().isTracked() && (wheel.wheelid == 2 || wheel.wheelid == 3)){
	                wheel.rotationYaw += wheelsYaw;
	            }
	            wheel.motionX *= 0.9F;
	            wheel.motionY *= 0.9F;
	            wheel.motionZ *= 0.9F;
	            wheel.motionY -= 0.98F / 20F;//Gravity
	            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
	            V3D s = null;
	        	if(wheelid >= 2 && this.getVehicleData().getType().isTrailer()){
	        		s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid == 2 ? 1 : 0]);
	        		s = new V3D(0, s.y, s.z);
	        	}
	        	else{
	        		s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid]);
	        	}
				V3D targetpos = rotpoint.getPivot().get_vector(s);
				V3D current = new V3D(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
				V3D despos = new V3D(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(lata.wheel_spring_strength);
	            if(despos.length() > 0.001F){
	                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
	                despos = despos.scale(0.5F); atmc = atmc.sub(despos);
	            }
	            wheelid++;
	        }
	        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
		}
		else{
			if(getVehicleType().isWaterVehicle()){
				V3D atmc = new V3D(0, 0, 0);
		        boolean canThrustCreatively = !VEHICLES_NEED_FUEL || isDriverInCreative();
		        EngineFunction engine = vehicle.hasPart("engine") ? vehicle.getPart("engine").getFunction("fvtm:engine") : null;
		        boolean consumed = processConsumption(engine);
		        for(WheelEntity wheel : wheels){
		            if(wheel == null){ continue; }
		            onGround = false; wheel.onGround = false;
		            wheel.rotationYaw = rotpoint.getPivot().deg_yaw();
		            if(!vehicle.getType().isTracked() && (wheel.wheelid == 2 || wheel.wheelid == 3)){
		                wheel.rotationYaw += wheelsYaw;
		            }
		            wheel.motionX *= 0.9F;
		            wheel.motionY *= 0.9F;
		            wheel.motionZ *= 0.9F;
		            wheel.motionY -= 0.98F / 20F;//Gravity
		            if(engine != null){
		                if(canThrustCreatively || consumed){
		                    double velocityScale;
		                    if(vehicle.getType().isTracked()){
		                        boolean left = wheel.wheelid == 0 || wheel.wheelid == 3;
		                        //
		                        float turningDrag = 0.02F;
		                        wheel.motionX *= 1F - (Math.abs(wheelsYaw) * turningDrag);
		                        wheel.motionZ *= 1F - (Math.abs(wheelsYaw) * turningDrag);
		                        //
		                        velocityScale = 0.04F * (throttle > 0 ? lata.max_throttle : lata.min_throttle) * engine.getSphEngineSpeed();
		                        float steeringScale = 0.1F * (wheelsYaw > 0 ? lata.turn_left_mod : lata.turn_right_mod);
		                        double effectiveWheelSpeed = (throttle + (wheelsYaw * (left ? 1 : -1) * steeringScale)) * velocityScale;
		                        wheel.motionX += effectiveWheelSpeed * Math.cos(wheel.rotationYaw * 3.14159265F / 180F);
		                        wheel.motionZ += effectiveWheelSpeed * Math.sin(wheel.rotationYaw * 3.14159265F / 180F);
		                    }
		                    else{
		                        velocityScale = 0.1F * throttle * (throttle > 0 ? lata.max_throttle : lata.min_throttle) * engine.getSphEngineSpeed();
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
					V3D targetpos = rotpoint.getPivot().get_vector(vehicle.getWheelPositions().get(WHEELINDEX[wheel.wheelid]));
					V3D current = new V3D(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
					V3D despos = new V3D(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(lata.wheel_spring_strength);
		            if(despos.length() > 0.001F){
		                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
		                despos = despos.scale(0.5F); atmc = atmc.sub(despos);
		            }
		        }
		        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
			}
			else{
				V3D atmc = new V3D(0, 0, 0);
		        boolean canThrustCreatively = !VEHICLES_NEED_FUEL || isDriverInCreative();
		        EngineFunction engine = vehicle.hasPart("engine") ? vehicle.getPart("engine").getFunction("fvtm:engine") : null;
		        boolean consumed = processConsumption(engine);
		        for(WheelEntity wheel : wheels){
		            if(wheel == null){ continue; }
		            onGround = true; wheel.onGround = true;
		            wheel.rotationYaw = rotpoint.getPivot().deg_yaw();
		            if(!vehicle.getType().isTracked() && (wheel.wheelid == 2 || wheel.wheelid == 3)){
		                wheel.rotationYaw += wheelsYaw;
		            }
		            wheel.motionX *= 0.9F;
		            wheel.motionY *= 0.9F;
		            wheel.motionZ *= 0.9F;
		            wheel.motionY -= 0.98F / 20F;//Gravity
		            if(engine != null){
		                if(canThrustCreatively || consumed){
		                    double velocityScale;
		                    if(vehicle.getType().isTracked()){
		                        boolean left = wheel.wheelid == 0 || wheel.wheelid == 3;
		                        //
		                        float turningDrag = 0.02F;
		                        wheel.motionX *= 1F - (Math.abs(wheelsYaw) * turningDrag);
		                        wheel.motionZ *= 1F - (Math.abs(wheelsYaw) * turningDrag);
		                        //
		                        velocityScale = 0.04F * (throttle > 0 ? lata.max_throttle : lata.min_throttle) * engine.getSphEngineSpeed();
		                        float steeringScale = 0.1F * (wheelsYaw > 0 ? lata.turn_left_mod : lata.turn_right_mod);
		                        double effectiveWheelSpeed = (throttle + (wheelsYaw * (left ? 1 : -1) * steeringScale)) * velocityScale;
		                        wheel.motionX += effectiveWheelSpeed * Math.cos(wheel.rotationYaw * 3.14159265F / 180F);
		                        wheel.motionZ += effectiveWheelSpeed * Math.sin(wheel.rotationYaw * 3.14159265F / 180F);
		                    }
		                    else{
		                        velocityScale = 0.1F * throttle * (throttle > 0 ? lata.max_throttle : lata.min_throttle) * engine.getSphEngineSpeed();
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
					V3D targetpos = rotpoint.getPivot().get_vector(vehicle.getWheelPositions().get(WHEELINDEX[wheel.wheelid]));
					V3D current = new V3D(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
					V3D despos = new V3D(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(lata.wheel_spring_strength);
		            if(despos.length() > 0.001F){
		                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
		                despos = despos.scale(0.5F); atmc = atmc.sub(despos);
		            }
		        }
		        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
			}
		}
	}
	
	public void alignTrailer(){
        prevPosX = posX; prevPosY = posY; prevPosZ = posZ; if(wheelnull() || truck == null){ return; }
		V3D conn = truck.rotpoint.getPivot().get_vector(V3D.NULL);//TODO truck.getVehicleData().getRearConnector());
        this.setPosition(truck.posX + conn.x, truck.posY + conn.y, truck.posZ + conn.z);
        //
        this.throttle = truck.throttle;
        double thrt = /*calculateSpeed(truck)*/ truck.throttle > 0 ? truck.throttle : -truck.throttle;
        double rawy = truck.rotpoint.getPivot().deg_yaw() - rotpoint.getPivot().deg_yaw();
        double diff = rawy * thrt * 0.2;
        //Print.debug(rawy, diff);
        diff = rawy > 0 ? (diff > rawy ? rawy : diff) : (diff < rawy ? rawy : diff);
        rotpoint.getPivot().set_rotation(rotpoint.getPivot().yaw() + Math.toRadians(diff), rotpoint.getPivot().pitch(), rotpoint.getPivot().roll(), false);
        //
        alignWheels();
	}

    private final void alignWheels(){
        for(int wheelid = 0; wheelid < wheels.length; wheelid++){
            if(wheels[wheelid] == null ){ continue; }
            WheelEntity wheel = wheels[wheelid];
            onGround = true; wheel.onGround = true;
            wheel.rotationYaw = rotpoint.getPivot().deg_yaw();
            //
			V3D s = null;
        	if(wheelid >= 2 && getVehicle().isTrailer()){
        		s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid == 2 ? 1 : 0]);
        		s = new V3D(0, s.y, s.z);
        	}
        	else{ s = vehicle.getWheelPositions().get(WHEELINDEX[wheelid]); }
			V3D targetpos = rotpoint.getPivot().get_vector(s), current = new V3D(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
			V3D despos = new V3D(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(getVehicle().getSphData().wheel_spring_strength);
            if(despos.length() > 0.001F){
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
    	if(vehicle.getAttributeInteger("fuel_stored", 0) <= 0) return false;
    	if(accumulator < 20){
    		if(engine.isOn()){
    			if(throttle == 0f || (throttle < 0.05f && throttle > -0.05f)){
        			consumed += engine.getIdleFuelConsumption();
        		}
        		else{
        			consumed += engine.getFuelConsumption(vehicle.getAttribute("fuel_secondary").asString()) * throttle;
        		}
    		}
    		accumulator++;
    		return engine.isOn();
    	}
    	else{
    		boolean bool = false;
    		if(consumed > 0){
    			int con = (int)(consumed / 20f);
    			vehicle.getAttribute("fuel_stored").decrease(con < 1 ? 1 : con);
    			bool = true;
    		}
    		if(engine.isOn() && vehicle.getAttribute("fuel_stored").asFloat() <= 0){
    			NBTTagCompound compound  = new NBTTagCompound();
    			compound.setString("task", "engine_toggle");
    			compound.setBoolean("engine_toggle_result", false);
            	compound.setBoolean("no_fuel", true);
            	throttle = 0;
            	engine.setState(false);
                ApiUtil.sendEntityUpdatePacketToAllAround(this, compound);
    		}
    		accumulator = 0;
    		consumed = 0;
    		return bool;
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
            if(vehicle.getLock().isLocked()){
                Print.chat(source.getImmediateSource(), "Vehicle is locked. Unlock if you want to remove it.");
                return false;
            }
            else{
                if(vehicle.hasPart("engine") && vehicle.getPart("engine").hasFunction("fvtm:engine")){
                    vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(false);
                }
                ItemStack stack = vehicle.newItemStack().local();
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
        ItemStack stack = vehicle.newItemStack().local();
        stack.setItemDamage(0);
        return stack;
    }

    //--- PACKETS ---//
    private long lr = -1;

    @Override
    public void processServerPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("ScriptId")){
            /*for(VehicleScript script : vehicle.getScripts()){
                if(script.getId().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, vehicle, pkt.nbt, Side.SERVER);
                }
            }*///TODO
        }
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "resync": {
                    NBTTagCompound nbt = this.vehicle.write(TagCW.create()).local();
                    nbt.setString("task", "update_vehicledata");
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                }
            }
        }
    }

    private void toggleEngine(){
        if(lr + 1000 >= Time.getDate()){ return; }
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString("task", "engine_toggle");
        lr = Time.getDate();
        EngineFunction engine = vehicle.getPart("engine").getFunction("fvtm:engine");
        if(world.isRemote) engine.setState(compound.getBoolean("engine_toggle_result"));
        else compound.setBoolean("engine_toggle_result", engine.toggle());
        if(vehicle.getStoredFuel() == 0){
        	compound.setBoolean("engine_toggle_result", engine.setState(false));
            compound.setBoolean("no_fuel", true);
        }
        ApiUtil.sendEntityUpdatePacketToAllAround(this, compound);
        throttle = 0;
	}

	@SideOnly(Side.CLIENT)
    @Override
    public void processClientPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("ScriptId")){
            /*for(VehicleScript script : vehicle.getScripts()){
                if(script.getId().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, vehicle, pkt.nbt, Side.CLIENT);
                }
            }*///TODO
        }
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "engine_toggle": {
                	boolean riding = net.minecraft.client.Minecraft.getMinecraft().player.isRiding();
                    if(riding && getDriver() == net.minecraft.client.Minecraft.getMinecraft().player){
                    	boolean state = pkt.nbt.getBoolean("engine_toggle_result");
                    	EntityPlayer player = net.minecraft.client.Minecraft.getMinecraft().player;
                        Print.chat(player, "Engine toggled " + (vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(state) ? "on" : "off") + ".");
                        if(pkt.nbt.hasKey("no_fuel") && pkt.nbt.getBoolean("no_fuel")){
                            Print.chat(player, "Out of fuel!");
                            //TODO vehicle.playSound(this, "engine_fail");
                        }
                        else{
							//TODO vehicle.playSound(this, state ? "engine_start" : "engine_stop");
						}
                    }
                    throttle = 0;
                    /*if(vehicle.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn() && this.engineloop == null){
                        SoundEvent event = (SoundEvent)vehicle.getSound("engine_running").event;
                        if(event != null){
                            this.engineloop = new LoopSound(event, SoundCategory.NEUTRAL, this);
                            net.minecraft.client.Minecraft.getMinecraft().getSoundHandler().playSound(this.engineloop);
                            Print.debug("engine_running -> Playing! (LOOP)");
                        }
                        else{
                            Print.debug("engine_running -> Not found.");
                        }
                    }*/
                    break;
                }
                case "resync":
                case "update_vehicledata": {
                    this.vehicle.read(new TagCWI(pkt.nbt));
                    break;
                }
                case "toggle_lights": {
                    vehicle.getAttribute("lights").set(pkt.nbt.getBoolean("lights"));
                    vehicle.getAttribute("lights_long").set(pkt.nbt.getBoolean("lights_long"));
                    LandVehicle trailer = this.trailer;
                    while(trailer != null){
                        trailer.vehicle.getAttribute("lights").set(pkt.nbt.getBoolean("lights"));
                        trailer.vehicle.getAttribute("lights_long").set(pkt.nbt.getBoolean("lights_long"));
                        trailer = trailer.trailer;
                    }
                    break;
                }
                case "connections_update":{
                	Print.debug(this);
                	int truck = pkt.nbt.getInteger("truck"); Print.debug("packet result t0" + truck);
                	if(truck == -1) this.truck = null; else this.truck = (LandVehicle)world.getEntityByID(truck);
                	int trailer = pkt.nbt.getInteger("trailer"); Print.debug("packet result t1" + trailer);
                	if(trailer == -1) this.trailer = null; else this.trailer = (LandVehicle)world.getEntityByID(trailer);
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
		return rotpoint.getPivot().toArray();
	}

	@Override
	public boolean isRailType(){
		return false;
	}

}
