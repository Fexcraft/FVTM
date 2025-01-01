package net.fexcraft.mod.fvtm.sys.pro;

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
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.function.part.ContainerFunction;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.function.part.TireFunction;
import net.fexcraft.mod.fvtm.function.part.TransmissionFunction;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.packet.Packet_VehKeyPress;
import net.fexcraft.mod.fvtm.packet.Packet_VehKeyPressState;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.ess.BasicSpawnSystem;
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
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.UUID;

import static net.fexcraft.mod.fvtm.Config.*;
import static net.fexcraft.mod.fvtm.ui.UIKeys.VEHICLE_MAIN;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ULandVehicle extends RootVehicle implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {

	public float wheelsAngle, serverWY;
    public ULandVehicle truck, trailer;
    protected byte toggle_timer, gear_timer, autogear_timer;
    //
    public double serverPosX, serverPosY, serverPosZ;
    public double serverYaw, serverPitch, serverRoll;
    public int server_pos_ticker, rpm, orpm, crpm;
    //
    public ArrayList<Axle> axles = new ArrayList<>();
    public ArrayList<WheelTireData> wheeldata = new ArrayList<>();
    public Axle front, rear;
    public double wheelbase, cg_height;
    public float wheel_radius;

	public ULandVehicle(World world){
		super(world);
		preventEntitySpawning = true; setSize(1f, 1f);
		ignoreFrustumCheck = true; stepHeight = 1f;
        if(world.isRemote){
            setRenderDistanceWeight(1d);
        }
	}
	
	/** Constructor to spawn either by a player or Constructor.
	 * 
	 * @param meta should be -1 or lower if placer rotation yaw matters
	 * */
	public ULandVehicle(World world, VehicleData data, V3D pos, EntityPlayer placer, int meta){
		this(world);
		setPosition(pos.x, pos.y, pos.z);
		vehicle.init(data);
		if(placer != null){
			vehicle.setPlacer(placer.getGameProfile().getId());
		}
		float prot = placer != null ? (MathHelper.floor(((placer.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15) * 22.5f : 0;
		vehicle.pivot().set_yaw((placer == null || meta >= 0 ? (meta * 90f) : prot) + -90F, true);
		init(null);
	}

	public ULandVehicle(NLandVehicle truck, VehicleData data, EntityPlayer placer){
		this(truck.world, data, truck.vehicle.getV3D(), placer, 0);
		vehicle.front = truck.vehicle;
		truck.vehicle.rear = vehicle;
		vehicle.point.updatePrevAxe();
		vehicle.point.getPivot().copy(truck.vehicle.point.getPivot());
		vehicle.sendUpdate(VehicleInstance.PKT_UPD_CONNECTOR);
	}

	@Override
	public boolean isAdv(){
		return true;
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void init(TagCW com){
		super.init(com);
		setupAxles();
	}

	private void setupAxles(){
		axles.clear();
        for(WheelTireData wheel : wheeldata){
        	Axle axle = null;
        	if(axles.stream().anyMatch(a -> a.pos.x == wheel.pos.x && a.pos.y == wheel.pos.y)){
        		axle = axles.stream().filter(a -> a.pos.x == wheel.pos.x && a.pos.y == wheel.pos.y).findFirst().get();
        	}
        	else{
        		axle = new Axle(axles.size(), new V3D(wheel.pos.x, wheel.pos.y, 0));
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

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		super.readEntityFromNBT(compound);
		vehicle.pbrake = compound.getBoolean("ParkingBrake");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		super.writeEntityToNBT(compound);
		compound.setBoolean("ParkingBrake", vehicle.pbrake);
	}

	@Override
	public void writeSpawnData(TagCW com){
		if(vehicle.front != null){
			com.set("TruckId", vehicle.front.entity.getId());
		}
	}

	@Override
	public void readSpawnData(TagCW com){
		if(com.has("TruckId")){
			vehicle.front = ((ULandVehicle)world.getEntityByID(com.getInteger("TruckId"))).vehicle;
			vehicle.front.rear = vehicle;
		}
	}

	public void tryAttach(EntityPlayer player){
		/*V3D vec = this.getRotPoint().getPivot().get_vector(this.getVehicleData().getRearConnector()).add(posX, posY, posZ);
		AxisAlignedBB aabb = new AxisAlignedBB(vec.x - 0.5, vec.y - 0.5, vec.z - 0.5, vec.x + 0.5, vec.y + 0.5, vec.z + 0.5);
		List<Entity> list = world.getEntitiesInAABBexcluding(this, aabb, ent -> ent instanceof ULandVehicle || ent instanceof LandVehicle);
		for(Entity ent : list){
			ULandVehicle veh = (ULandVehicle)ent;
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
		trailer.truck = null; ULandVehicle trailer = this.trailer; this.trailer = null;
		trailer.sendConnectionUpdate(); this.sendConnectionUpdate();
		Print.chat(player, "&c&oTrailer disconnected&a!");
	}

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
        return true;
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
        if(isDead || hand == EnumHand.OFF_HAND) return false;
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
                	if(!BasicSpawnSystem.validToSpawn(UniEntity.getEntity(player), StackWrapper.wrap(stack), data)) return true;
                	if(trailer != null){
                		Print.chat(player, "&cPlease disconnect the currently connected trailer first.");
                		return true;
                	}
                	if(truck != null){
                		Print.chat(player, "&cPlease disconnect the currently connected trailer first.");
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
                	player.openGui(FVTM.getInstance(), VEHICLE_MAIN.id, world, 0, this.getEntityId(), 0);
                }
                return true;
            }
        }
        if(vehicle.getLock().isLocked()){
        	Print.chat(player, "Vehicle is locked.");
        	return true;
        }
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
        super.onUpdate();
        if(this.isDead) return;
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
        if(!world.isRemote){ wheelsYaw *= 0.98F;  }
        float wymax = vehicle.getAttributeFloat("max_steering_angle", 45);
        wheelsYaw = Static.clamp(wheelsYaw, -wymax, wymax);
        //px = posX; py = posY; pz = posZ;
        if(world.isRemote){
            if(server_pos_ticker > 0){
                double x = posX + (serverPosX - posX) / server_pos_ticker;
                double y = posY + (serverPosY - posY) / server_pos_ticker;
                double z = posZ + (serverPosZ - posZ) / server_pos_ticker;
                double dYaw = MathHelper.wrapDegrees(serverYaw - rotpoint.getPivot().deg_yaw());
                double dPitch = MathHelper.wrapDegrees(serverPitch - rotpoint.getPivot().deg_pitch());
                double dRoll = MathHelper.wrapDegrees(serverRoll - rotpoint.getPivot().deg_roll());
                rotationYaw = (float)(rotpoint.getPivot().deg_yaw() + dYaw / server_pos_ticker);
                rotationPitch = (float)(rotpoint.getPivot().deg_pitch() + dPitch / server_pos_ticker);
                float rotationRoll = (float)(rotpoint.getPivot().deg_roll() + dRoll / server_pos_ticker);
                wheelsYaw += (serverWY - wheelsYaw) / server_pos_ticker;
                crpm += (rpm - crpm) / server_pos_ticker;
                --server_pos_ticker;
                setPosition(x, y, z);
                rotpoint.getPivot().set_rotation(rotationYaw, rotationPitch, rotationRoll, true); //return;
            }
            vehicle.getAttribute("steering_angle").set(wheelsYaw);
            wheelsAngle += speed * (wheel_radius * 2 * Static.PI) * (vehicle.getAttributeInteger("gear", 0) >= 0 ? 1 : -1);
            if(wheelsAngle > 360) wheelsAngle -= 360; if(wheelsAngle < -360) wheelsAngle += 360;
        	vehicle.getAttribute("wheel_angle").set(wheelsAngle);
        	vehicle.getAttribute("throttle").set((float)throttle);
        	//
        	vehicle.getAttribute("speed").set((float)speed);
        	vehicle.getAttribute("rpm").set(crpm / 100 * 100);
        }
        for(WheelEntity wheel : wheels){
            if(wheel != null){
            	wheel.prevPosX = wheel.posX;
            	wheel.prevPosY = wheel.posY;
            	wheel.prevPosZ = wheel.posZ;
            }
        }
        if(!world.isRemote){// && vehicle.getType().isTrailer() ? this.wheels.length > 2 : true){
            if(getDriver() == null || !(isDriverInCreative() || vehicle.getAttribute("fuel_stored").asInteger() > 0)){
                throttle *= 0.98F;
            }
            if(truck == null){
                if(vehicle.getType().isTrailer()) relign();
                else onUpdateMovement();
            }
        }
        else updateSounds();
        //
		double x = posX - prevPosX, y = posY - prevPosY, z = posZ - prevPosZ;
		while(avsp.size() < 10) avsp.add(speed);
		avsp.add(Math.sqrt(x * x + y * y + z * z) * 1000F / 20f);
		avsp.remove(0);
		speed = 0;
		for(double d : avsp) speed += d;
		speed /= avsp.size();
		//
        //TODO for(SwivelPoint point : vehicle.getRotationPoints().values()) point.update(this);
        //TODO for(SeatCache seat : seats) seat.updatePosition();
        //TODO vehicle.getScripts().forEach((script) -> script.onUpdate(this, vehicle));
        checkForCollisions();
        if(!world.isRemote && ticksExisted % VEHICLE_SYNC_RATE == 0 && truck == null){
        	vehicle.getAttribute("throttle").set((float)throttle);
            //TODO PacketsImpl.sendToAllAround(new PKT_VehControl(this), getTargetPoint(this));
            //TODO for(SwivelPoint point : vehicle.getRotationPoints().values()) point.sendClientUpdate(this);
            ULandVehicle trailer = this.trailer;
            while(trailer != null){
                //TODO PacketsImpl.sendToAllAround(new PKT_VehControl(trailer), getTargetPoint(trailer));
                //TODO for(SwivelPoint point : trailer.vehicle.getRotationPoints().values()) point.sendClientUpdate(trailer);
                trailer = trailer.trailer;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    private void updateSounds(){
    	if(!world.isRemote || engine == null) return;
    	if(engine.isOn() && engineloop == null){
            SoundEvent event = (SoundEvent)vehicle.getSound("engine_running").event;
            if(event != null){
                //TODO this.engineloop = new LoopSound(event, SoundCategory.NEUTRAL, this);
                //TODO net.minecraft.client.Minecraft.getMinecraft().getSoundHandler().playSound(this.engineloop);
                Print.debug("engine_running -> Playing! (LOOP)");
            }
            else{
                Print.debug("engine_running -> Not found.");
            }
    	}
    	else if(!engine.isOn()){
    		engineloop = null;
    	}
    	if(engineloop != null){
    		engineloop.patch = 1f;//TODO calc
    	}
	}

	private ArrayList<Double> avsp = new ArrayList<>();
    public static final float GRAVITY = 9.81f, GRAVE = GRAVITY / 200F;
    public static final float TICKA = 1f / 20f, o132 = Static.sixteenth / 2;
    /*private double /*px, py, pz, oos, os;*/
    private double appmass = 0;
    private double accx = 0f;

	public void onUpdateMovement(){
		if(trailer != null){
			ULandVehicle trailer = this.trailer;
			while(trailer.trailer != null) trailer = trailer.trailer;
			ULandVehicle truck = trailer.truck;
			trailer.appmass = trailer.vehicle.getAttributeFloat("weight", 1000);
			while(truck != null){
				truck.appmass = truck.vehicle.getAttributeFloat("weight", 1000);
				truck.appmass += truck.trailer.appmass * truck.trailer.vehicle.getAttributeFloat("trailer_weight_ratio", 0.2f);
				truck = truck.truck;
			}
		}
		else appmass = vehicle.getAttributeFloat("weight", 1000f);
		double mass = appmass;
		double rr = vehicle.getAttributeFloat("roll_resistance", 8f);
		double ar = vehicle.getAttributeFloat("air_resistance", 2.5f);
		for(Axle axle : axles) axle.calc(mass, accx, cg_height, wheelbase, 1f);
		boolean overloaded = appmass - vehicle.getAttributeFloat("weight", 1000f) > vehicle.getAttributeFloat("max_towing", 3500f);
		//
		V3D atmc = new V3D(0, 0, 0);
        boolean consumed = processConsumption(engine);
        boolean nopass = this.getPassengers().isEmpty();
        
        float brkf = vehicle.getAttributeFloat("brake_force", 10000f);
    	double brake = Math.min((braking ? brkf : 0) + (pbrake ? vehicle.getAttributeFloat("parking_brake_force", 5000f) : 0), brkf);
    	int gear = vehicle.getAttributeInteger("gear", 0);
    	float diff = vehicle.getAttributeFloat("differential_ratio", 3.5f);
    	if(engine != null && transmission != null){
        	orpm = rpm;
        	rpm = (int)((speed / wheel_radius) * transmission.getRatio(gear) * diff * 60 / Static.PI2);
        	rpm = (orpm + rpm) / 2;
        	if(rpm < 0) rpm = -rpm;
        	if(rpm < engine.minRPM()) rpm = engine.minRPM();
        	if(rpm > engine.maxRPM()) rpm = engine.maxRPM();
    	}
    	float force = 0;
    	if(!overloaded && engine != null && transmission != null){
    		force = engine.getTorque(rpm) * transmission.getRatio(gear) * diff * transmission.getEfficiency() / wheel_radius;
        	if(transmission.isAutomatic() && autogear_timer <= 0){
        		int ngear = transmission.processAutoShift(gear, rpm, engine.maxRPM(), throttle);
        		if(ngear != gear){
        			vehicle.getAttribute("gear").set(ngear);
        			sendAttributeUpdate("gear");
        		}
        		autogear_timer += transmission.getShiftSpeed();
        	}
    	}
    	if(overloaded){
    		//TODO dedicated icon/message in GUI
    		EntityPlayer player = (EntityPlayer)this.getDriver();
    		if(player != null) Print.bar(player, "&cTEMP: Towing limit reached, vehicle is overloaded.");
    	}
    	double thr = this.throttle * force;
    	double cos = Math.cos(rotpoint.getPivot().deg_yaw() * 3.14159265F / 180F);
    	double sin = Math.sin(rotpoint.getPivot().deg_yaw() * 3.14159265F / 180F);
    	boolean slowdown = throttle < 0.001f || gear == 0;
    	double val;
    	onGround = true;
    	accx = 0;
        //
        for(WheelEntity wheel : wheels){
            if(wheel == null){ continue; }
            WheelTireData wheeldata = getWheelData(wheel.getIndex());
            wheel.onGround = true;
            wheel.rotationYaw = rotpoint.getPivot().deg_yaw();
            /*if(!lata.is_tracked && (wheel.wheelid == 2 || wheel.wheelid == 3)){
                wheel.rotationYaw += wheelsYaw;
            }*/////TODO TRACKED DEFINITION
            BlockPos wheelpos = new BlockPos(wheel.posX, wheel.posY - o132, wheel.posZ);
        	boolean rainfall = world.isRainingAt(wheelpos);
            Material mat = world.getBlockState(wheelpos).getMaterial();
            if(slowdown || speed < 3 || nopass){
            	boolean brk = braking || pbrake;
            	double by = brk && !slowdown ? 0 : speed < 3 ? 0.9 : 0.99;
	            wheel.motionX *= by;
	            wheel.motionY *= by;
	            wheel.motionZ *= by;
            }
            wheel.motionY -= GRAVE;
            //
        	double motx = cos * wheel.motionX + sin * wheel.motionZ;
        	double moty = cos * wheel.motionZ - sin * wheel.motionX;
            double stew = wheelsYaw * 3.14159265F / 180F;
            double steer = wheel.slot.steering ? Math.signum(motx) * stew : 0;
            double slip_angle = Math.atan2(moty + wheeldata.axle.yaw_speed, Math.abs(motx)) - steer;
            double grip = wheeldata.function.getGripFor(mat, rainfall) * (wheel.slot.braking && pbrake ? wheeldata.function.brake_grip : 1);
        	double frict = Static.clamp((wheeldata.function.getCornerStiffnessFor(mat, wheel.slot.steering)) * slip_angle, -grip, grip) * wheeldata.axle.weight_on;
        	double trac = wheeldata.function.getGripFor(mat, rainfall) * ((consumed ? thr : 0) - brake * Math.signum(motx));//grip inclusion here is for testing
        	double dragx = -rr * motx - ar * motx * Math.abs(motx);
        	double dragy = -rr * moty - ar * moty * Math.abs(moty);
        	double totalx = dragx + trac;
        	double totaly = dragy + (wheel.slot.steering ? Math.cos(stew) * frict : 0);
        	double acx = (totalx / mass) * TICKA;
        	double acy = (totaly / mass) * TICKA;
        	accx += acx;
        	//
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
                val = acx * U12_MOTION_SCALE;
                wheel.motionX *= 0.25;
                wheel.motionZ *= 0.25;
                wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * (val + motx * 0.75);
                wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * (val + motx * 0.75);
                //
                if(wheel.slot.steering){
                	if(motx > 0.01f || motx < -0.01f){
                        val = acy * 0.05;
                        wheel.motionX -= Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * val * wheelsYaw;
                        wheel.motionZ += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * val * wheelsYaw;
                	}
                }
            }
            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
            atmc = alignWheel(this, wheel, vehicle.getWheelPositions().get(WHEELINDEX[wheel.wheelid]), atmc, false);//pulling wheel back to vehicle
        }
        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
        accx /= wheels.length;
        rerot();
        //
        ULandVehicle trailer = this.trailer;
        while(trailer != null){
            if(trailer.wheelnull()){
            	trailer = trailer.trailer;
            	continue;
            }
        	atmc = new V3D(0, 0, 0);
			V3D opos = new V3D(trailer.posX, trailer.posY, trailer.posZ);
            V3D conn = trailer.truck.rotpoint.getPivot().get_vector(V3D.NULL);//trailer.truck.getVehicleData().getRearConnector());
            val = opos.dis(conn = conn.add(trailer.truck.posX, trailer.truck.posY, trailer.truck.posZ));
        	cos = Math.cos(trailer.rotpoint.getPivot().yaw());
        	sin = Math.sin(trailer.rotpoint.getPivot().yaw());
            //
            V3D trax = trailer.rotpoint.getPivot().get_vector(trailer.rear.pos).add(trailer.posX, trailer.posY, trailer.posZ);
            trailer.rotpoint.getPivot().set_yaw((float)Math.atan2(conn.z - trax.z, conn.x - trax.x), false);
    		int wheelid = 0;
        	trailer.onGround = true;
        	for(WheelEntity wheel : trailer.wheels){
        		if(wheel == null) continue;
        		wheel.onGround = true;
                wheel.rotationYaw = trailer.rotpoint.getPivot().deg_yaw();
                wheel.motionX = wheel.motionZ = 0;
                if(val < GRAVE) wheel.motionY = 0;
                wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * val;
                wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * val;
                wheel.motionY -= GRAVE;
				V3D s = null;
            	if(wheelid >= 2){
            		s = trailer.vehicle.getWheelPositions().get(WHEELINDEX[wheelid == 2 ? 1 : 0]);
            		s = new V3D(0, s.y, s.z);
            	}
            	else s = trailer.vehicle.getWheelPositions().get(WHEELINDEX[wheelid]);
                atmc = alignWheel(trailer, wheel, s, atmc, true);
                //trailer.rerott();
                wheelid++;
        	}
            trailer.move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
            trailer.opos();
            trailer.setPosition(conn.x, conn.y, conn.z);
            for(int i = 0; i < 2; i++){
            	trailer.wheels[i].move(MoverType.SELF, 0, -GRAVE, 0);
            }
            trailer.rerott();
        	trailer = trailer.trailer;
        }
	}
	
	private void relign(){
		int wheelid = 0;
		V3D atmc = new V3D(0, 0, 0);
        for(WheelEntity wheel : wheels){
            if(wheel == null) continue;
            onGround = true; wheel.onGround = true;
            wheel.rotationYaw = rotpoint.getPivot().deg_yaw();
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
            atmc = alignWheel(this, wheel, s, atmc, true);
            wheelid++;
        }
        move(MoverType.SELF, atmc.x, atmc.y, atmc.z);
        rerot();
	}
	
	private void opos(){ prevPosX = posX; prevPosY = posY; prevPosZ = posZ; }
	
	private static V3D alignWheel(ULandVehicle vehicle, WheelEntity wheel, V3D vec, V3D atmc, boolean corrcheck){
		V3D targetpos = vehicle.rotpoint.getPivot().get_vector(vec);
		V3D current = new V3D(wheel.posX - vehicle.posX, wheel.posY - vehicle.posY, wheel.posZ - vehicle.posZ);
		V3D despos = new V3D(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(0.5f);//TODO lata.wss
        if(despos.length() > 0.001F){
            wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
            despos = despos.scale(0.5F);
            return atmc.sub(despos);
        }
        if(corrcheck && wheel.getPositionVector().distanceTo(vehicle.getPositionVector()) > 8){//1024
            wheel.posX = despos.x;
            wheel.posY = despos.y;
            wheel.posZ = despos.z;
        }
        return atmc;
	}
    
    public void rerot(){
        if(wheelnull()) return;
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
        rotpoint.getPivot().set_rotation(yaw, pitch, roll, false);
    }
    
    public void rerott(){
        if(wheels[0] == null || wheels[1] == null) return;
        Vec3d front = this.getPositionVector();
        Vec3d back = new Vec3d((wheels[0].posX + wheels[1].posX) / 2F, (wheels[0].posY + wheels[1].posY) / 2F - rear.pos.y, (wheels[0].posZ + wheels[1].posZ) / 2F);
        Vec3d left = wheels[0].getPositionVector();
        Vec3d right = wheels[1].getPositionVector();
        //
        double dx = front.x - back.x, dy = front.y - back.y, dz = front.z - back.z;
        double drx = left.x - right.x, dry = left.y - right.y, drz = left.z - right.z;
        double dxz = Math.sqrt(dx * dx + dz * dz);
        double drxz = Math.sqrt(drx * drx + drz * drz);
        //
        double yaw = Math.atan2(dz, dx);
        double pitch = -Math.atan2(dy, dxz);
        rotpoint.getPivot().set_rotation(yaw, pitch, -(float)Math.atan2(dry, drxz), false);
    }
	
	@Override
	public int getSpeed(){
		return (int)speed;
	}

	public WheelTireData getWheelData(String index){
		for(WheelTireData wheel : wheeldata){
			if(wheel.id.equals(index)) return wheel;
		}
		return null;
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
    	if(!VEHICLES_NEED_FUEL || isDriverInCreative()) return true;
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
                    ULandVehicle trailer = this.trailer;
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
		return rotpoint.getPivot().toArray();
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
