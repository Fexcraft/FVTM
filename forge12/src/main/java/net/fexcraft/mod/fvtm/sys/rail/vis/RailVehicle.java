package net.fexcraft.mod.fvtm.sys.rail.vis;

import static net.fexcraft.mod.fvtm.Config.RENDER_OUT_OF_VIEW;
import static net.fexcraft.mod.fvtm.Config.VEHICLES_DROP_CONTENTS;
import static net.fexcraft.mod.fvtm.ui.UIKeys.VEHICLE_MAIN;

import java.util.UUID;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.FvtmRegistry;
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
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.TrainAdjuster;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.fexcraft.mod.fvtm.packet.Packet_VehKeyPress;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.MessageSenderI;
import net.fexcraft.mod.uni.impl.SWIE;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
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
 */
public class RailVehicle extends GenericVehicle implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {

	public Reltrs rek;
	public SwivelPoint rotpoint;
	private byte toggletimer;
    //
    public double serverPosX, serverPosY, serverPosZ;
    public double serverYaw, serverPitch, serverRoll;
    public static final int servtick = 5;
    public int sptt;
    public static final String[] BOOGIEINDEX = new String[]{ "bogie_front", "bogie_rear" };

	public RailVehicle(World world){
		super(world);
		preventEntitySpawning = true; setSize(0.5f, 0.5f); ignoreFrustumCheck = true;
        if(world.isRemote){
            setRenderDistanceWeight(1D);
        }
        Print.debug("SPAWNING " + world.isRemote + " " + this.getEntityId());
	}

	public RailVehicle(RailEntity ent){
		this((World)ent.getRegion().getSystem().getWorld().direct());
		ent.vehicle.entity = UniEntity.getEntity(this);
		(rek = new Reltrs(ent.getRegion().getSystem(), ent, null)).ent().alignEntity(true);
		initializeVehicle(false, null); Print.debug(this +  " " + rek.uid + " " + this.getPositionVector());
	}

	@Override
	protected void entityInit(){
		//
	}

	private void initializeVehicle(boolean remote, NBTTagCompound compound){
		if(compound != null) rek = new Reltrs(SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(world), RailSystem.class), compound);
		rotpoint = rek.data().getRotationPoint("vehicle");
        this.setSize(rek.data().getAttribute("hitbox_width").asFloat(), rek.data().getAttribute("hitbox_height").asFloat());
        if(seats == null) seats = new SeatInstance[rek.data().getSeats().size()];
        for(int i = 0; i < seats.length; i++) seats[i] = null;//TODO new SeatInstance(this, i);
        ContainerHolderUtil.Implementation impl = (Implementation)this.getCapability(Capabilities.CONTAINER, null);
        if(impl != null){ impl.setup = false; this.setupCapability(impl); }
        else{ Print.debug("No ContainerCapability Implementation Found!");}
        //TODO rek.data().getScripts().forEach((script) -> script.onSpawn(this, rek.data()));
        if(remote){
        	float c = rek.data().getAttributeFloat("collision_range", 2f);
        	renderbox = new AxisAlignedBB(-c, -c, -c, c, c, c);
    		EntitySystem system = SystemManager.get(Systems.ENTITY, WrapperHolder.getWorld(world));
    		//TODO if(system != null) system.add(this);
        }
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		/*RailSys system = world.getCapability(Capabilities.RAILSYSTEM, null).get();
		RailEntity ent = system.getEntity(compound.getLong("RailEntity"), true);
		if(ent != null) ent.entity = this;*/
		this.setDead();
		//super.readEntityFromNBT(compound);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		compound.setLong("RailEntity", rek.uid);
		super.writeEntityToNBT(compound);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = new NBTTagCompound();
		rotpoint.getPivot().save(new TagCWI(compound));
        compound.setTag("Entity", rek.write(new NBTTagCompound()));
		ByteBufUtils.writeTag(buffer, compound); //Print.debug("sent: " + compound);
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
        try{
            NBTTagCompound compound = ByteBufUtils.readTag(buffer); //Print.debug("recd: " + compound);
            initializeVehicle(true, compound.getCompoundTag("Entity"));
            rotpoint.loadPivot(new TagCWI(compound));
            prevRotationYaw = rotpoint.getPivot().deg_yaw();
            prevRotationPitch = rotpoint.getPivot().deg_pitch();
            prevRotationRoll = rotpoint.getPivot().deg_roll();
        }
        catch(Exception e){
            e.printStackTrace();
            Print.debug("Failed to receive additional spawn data for this vehicle!");
        }
	}
    
    @Override
    public void setDead(){
    	if(rek == null || rek.data() == null){ super.setDead(); return; }
        if(VEHICLES_DROP_CONTENTS && !world.isRemote){
            for(String part : rek.data().getInventories()){
            	InventoryFunction func = rek.data().getPart(part).getFunction("fvtm:inventory");
            	if(func == null) continue;
        		func.inventory().dropAllAt(this.getCapability(Capabilities.PASSENGER, null).asWrapper());
            }
        }
        this.getCapability(Capabilities.CONTAINER, null).dropContents();
        //
        super.setDead(); if(!world.isRemote) rek.ent().vehicle.entity = null;
        //if(seats != null) for(SeatEntity seat : seats) if(seat != null) seat.setDead();
        //
        //TODO rek.data().getScripts().forEach((script) -> script.onRemove(this, rek.data()));
    }

	@Override
	public VehicleData getVehicleData(){
		return rek.data();
	}

	@Override
	public VehicleType getVehicleType(){
		return rek.data().getType().getVehicleType();
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
		//TODO for(VehicleScript script : rek.data().getScripts()) if(script.onKeyPress(key, seat, player)) return true;
        if(!seat.driver && key.driver_only()) return false;
        if(world.isRemote && !key.toggables() /*&& key.dismount()*/){
			Packets.send(Packet_VehKeyPress.class, key);
			return true;
        }
		Passenger pass = (Passenger)UniEntity.getEntity(player);
        switch(key){
            case ACCELERATE:{
                //rek.ent().throttle += rek.ent().throttle < 0 ? 0.02f : 0.01F;
                //if(rek.ent().throttle > 1F){ rek.ent().throttle = 1F; }
                return true;
            }
            case DECELERATE:{
            	//rek.ent().throttle -= rek.ent().throttle > 0 ? 0.02f : 0.01F;
                //if(rek.ent().throttle < 0){ rek.ent().throttle = 0; }
                return true;
            }
            case TURN_LEFT:{
            	if(throttle > 0.05f) Print.bar(player, "&cDecrease the throttle before switching direction.");
            	else rek.ent().setForward(pass, false);
                return true;
            }
            case TURN_RIGHT:{
            	if(throttle > 0.05f) Print.bar(player, "&cDecrease the throttle before switching direction.");
            	else rek.ent().setForward(pass, true);
                return true;
            }
            case BRAKE:{
            	//rek.ent().throttle *= 0.8F;
                if(onGround){
                    motionX *= 0.8F;
                    motionZ *= 0.8F;
                }
                if(throttle < -0.0001){
                	//rek.ent().throttle = 0;
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
                if(rek.data().getPart("engine") != null && rek.data().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
                    Print.chat(player, "Turn engine off first!"); return true;
                }
                player.openGui(FVTM.getInstance(), VEHICLE_MAIN.id, world, 0, this.getEntityId(), 0);
                return true;
            }
            case TOGGABLES: {//client side
            	if(toggletimer > 0) return true;
            	net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay.toggle();
            	toggletimer += 10;
                return true;
            }
            case SCRIPTS: {
                //
            	return true;
            }
            case LIGHTS: {
                if(toggletimer <= 0){
                	boolean bool = !rek.data().getAttribute("lights").asBoolean();
                	rek.data().getAttribute("lights").set(bool);
                    NBTTagCompound nbt = new NBTTagCompound(); nbt.setString("task", "toggle_lights");
                    nbt.setBoolean("lights", rek.data().getAttribute("lights").asBoolean());
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                    toggletimer = 10;
                    //
                    if(rek.ent().getCompound().isMultiple()){
                    	for(RailEntity ent : rek.ent().getCompound().getEntitites()){
                    		ent.vehicle.data.getAttribute("lights").set(bool);
                    		if(ent.vehicle.entity != null){
    	                        NBTTagCompound com = new NBTTagCompound(); com.setString("task", "toggle_lights");
    	                        com.setBoolean("lights", rek.data().getAttribute("lights").asBoolean());
    	                        ApiUtil.sendEntityUpdatePacketToAllAround(ent.vehicle.entity.local(), com);
                    		}
                    	}
                    }
                }
                return true;
            }
            case COUPLER_FRONT: {
            	if(toggletimer > 0) return true;
    			rek.ent().tryCoupling(pass, true);
    			toggletimer = 10; return true;
            }
            case COUPLER_REAR: {
            	if(toggletimer > 0) return true;
    			rek.ent().tryCoupling(pass, false);
            	toggletimer = 10; return true;
            }
            case MOUSE_MAIN: case MOUSE_RIGHT: return false;
            default:{ Print.chat(player, String.format("Task for keypress %s not found.", key)); return false; }
        }
    }

	@Override
	public UUID getPlacer(){
		return world.isRemote ? null : rek.ent().getPlacer();
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
            sptt = servtick;
        }
        else{
            setPosition(posX, posY, posZ);
            prevRotationYaw = yaw;
            prevRotationPitch = pitch;
            prevRotationRoll = roll;
            rotpoint.getPivot().set_rotation(yaw, pitch, roll, true);
        }
        this.throttle = throttle; rek.data().getAttribute("fuel_stored").set(fuel);
	}

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posrotincr, boolean teleport){
        return;//sptt = 1; serverPosX = x; serverPosY = y; serverPosZ = z; serverYaw = yaw; serverPitch = pitch;
    }
	
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
        return true;
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
        return world.isRemote && rek.ent() == null ? "noent" : rek.data() == null ? "novehicle.data" : rek.data().getName();
    }

    @SideOnly(Side.CLIENT) @Override
    public boolean isInRangeToRenderDist(double dist){
        return RENDER_OUT_OF_VIEW ? true : super.isInRangeToRenderDist(dist);
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(){
        return this.getCollisionBox(this);
    }
	
	@Override
	public VehicleEntity getCoupledEntity(boolean front){
		return null;/*world.isRemote ? null : front ? rek.ent().front.hasEntity() ? rek.ent().front.entity.vehicle.entity : null
			: rek.ent().rear.hasEntity() ? rek.ent().rear.entity.vehicle.entity : null;*///TODO
	}
	
	@Override
	public VehicleEntity getFrontCoupledEntity(){
		return null;//TODO world.isRemote ? null : rek.ent().front.hasEntity() ? rek.ent().front.entity.vehicle.entity : null;
	}
	
	@Override
	public VehicleEntity getRearCoupledEntity(){
		return null;//TODO world.isRemote ? null : rek.ent().rear.hasEntity() ? rek.ent().rear.entity.vehicle.entity : null;
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
        if(isDead || hand == EnumHand.OFF_HAND){ return false; }
        ItemStack stack = player.getHeldItem(hand);
		Passenger pass = player.getCapability(Capabilities.PASSENGER, null).asWrapper();
        if(world.isRemote){
        	if((!stack.isEmpty() && stack.getItem() instanceof PartItem == false) || Lockable.isKey(FvtmRegistry.getItem(stack.getItem().getRegistryName().toString()))) return true;
            if(rek.data().getLock().isLocked()){
            	Print.chat(player, "Vehicle is locked.");
            	return true;
            }
        	//TODO ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT, this, null, player, stack);
        	return true;
        }
		ItemWrapper item = FvtmRegistry.getItem(stack.getItem().getRegistryName().toString());
        if(Lockable.isKey(item)){
			rek.data().getLock().toggle(new MessageSenderI(player), new SWIE(stack));
        	this.sendLockStateUpdate();
        	return true;
        }
        if(!stack.isEmpty()){
            if(stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getContent().isFuelContainer()){
            	pass.openUI(UIKeys.VEHICLE_FUEL, new V3I(getEntityId(), 0, 0));
            	return true;
            }
            else if(stack.getItem() instanceof ContainerItem){
            	this.getCapability(Capabilities.CONTAINER, null).openGUI(player); return true;
            }
            else if(stack.getItem() instanceof TrainAdjuster){
            	return stack.getItem().onLeftClickEntity(stack, player, this);
            }
            //space for other item interaction
            else{
                if(rek.data().getPart("engine") != null && rek.data().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
                    Print.chat(player, "Turn engine off first!");
                }
                else{
                	player.openGui(FVTM.getInstance(), VEHICLE_MAIN.id, world, 0, this.getEntityId(), 0);
                }
                return true;
            }
        }
        if(rek.data().getLock().isLocked()){
        	Print.chat(player, "Vehicle is locked.");
        	return true;
        }
        //TODO else if(ToggableHandler.handleClick(player, KeyPress.MOUSE_RIGHT)) return true;
        /*if(!rek.data().getScripts().isEmpty()){
            for(VehicleScript script : rek.data().getScripts()){
                if(script.onInteract(this, rek.data(), player, hand)){
                    return true;
                }
            }
        }*///TODO
        return false;
    }

    @Override
    public void onUpdate(){
        super.onUpdate();
        if(rek == null || rek.data() == null){
        	Print.log("VehicleData is NULL; Not ticking vehicle. Removing Vehicle.");
        	this.setDead();
        	return;
        }
        /*if(!world.isRemote){
        	//
        }*/
        prevRotationYaw = rotpoint.getPivot().deg_yaw();
        prevRotationPitch = rotpoint.getPivot().deg_pitch();
        prevRotationRoll = rotpoint.getPivot().deg_roll();
        rotpoint.updatePrevAxe();
        this.ticksExisted++;
        if(this.ticksExisted >= Integer.MAX_VALUE){
            this.ticksExisted = 0;
        }
        //
        if(toggletimer > 0){
            toggletimer--;
        }
        //
        if(world.isRemote){
            if(sptt > 0){
                double x = posX + (serverPosX - posX) / sptt;
                double y = posY + (serverPosY - posY) / sptt;
                double z = posZ + (serverPosZ - posZ) / sptt;
                double dYaw = MathHelper.wrapDegrees(serverYaw - rotpoint.getPivot().deg_yaw());
                double dPitch = MathHelper.wrapDegrees(serverPitch - rotpoint.getPivot().deg_pitch());
                double dRoll = MathHelper.wrapDegrees(serverRoll - rotpoint.getPivot().deg_roll());
                rotationYaw = (float)(rotpoint.getPivot().deg_yaw() + dYaw / sptt);
                rotationPitch = (float)(rotpoint.getPivot().deg_pitch() + dPitch / sptt);
                float rotationRoll = (float)(rotpoint.getPivot().deg_roll() + dRoll / sptt);
                --sptt; setPosition(x, y, z);
                rotpoint.getPivot().set_rotation(rotationYaw, rotationPitch, rotationRoll, true); //return;
            }
        	rek.data().getAttribute("throttle").set((float)throttle);
        	rek.data().getAttribute("speed").set((float)speed);
        	//rek.data().getAttribute("rpm").value(rpm / 100 * 100);
        	//
            V3D bf0 = rek.moveOnly(rek.passed + 0.1f), bf1 = rek.moveOnly(rek.passed - 0.1f);
            V3D br0 = rek.moveOnly(rek.passed - rek.frbogiedis - rek.rrbogiedis + 0.1f);
            V3D br1 = rek.moveOnly(rek.passed - rek.frbogiedis - rek.rrbogiedis - 0.1f);
        	if(bf0 != null && br0 != null && bf1 != null && br1 != null){
        		float front = (float)(Math.toDegrees(Math.atan2(bf0.z - bf1.z, bf0.x - bf1.x)) - rotpoint.getPivot().deg_yaw());
        		float rear  = (float)(Math.toDegrees(Math.atan2(br0.z - br1.z, br0.x - br1.x)) - rotpoint.getPivot().deg_yaw());
        		rek.data().getAttribute("bogie_front_angle").set(front);
        		rek.data().getAttribute("bogie_rear_angle").set(rear);
        	}
    		//
        	
    		/*if(Command.DEBUG)*/ rek.updatePosition();
        }
        if(!world.isRemote){
            rek.ent().alignEntity(false);
            //
            Vec3d front = new Vec3d(rek.ent().bfront.x, rek.ent().bfront.y, rek.ent().bfront.z);
            Vec3d back = new Vec3d(rek.ent().brear.x, rek.ent().brear.y, rek.ent().brear.z);
            Vec3d left = new Vec3d((front.x + back.x) / 2F, (front.y + back.y) / 2F, (front.x + back.z) / 2F);
            Vec3d right = new Vec3d((front.x + back.x) / 2F, (front.y + back.y) / 2F, (front.x + back.z) / 2F);
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
            rotpoint.getPivot().set_rotation(yaw, pitch, roll, false);
        }
        else{
        	speed = net.fexcraft.mod.fvtm.gui.VehicleSteeringOverlay.calculateSpeed(this);
        }
        if(rek.current != null && rek.current.getUnit() != null){
        	rek.data().getAttribute("section_on").set(rek.current.getUnit().section().getUID());
        }
        //TODO for(SwivelPoint point : rek.data().getRotationPoints().values()) point.update(this);
        for(SeatInstance seat : seats) seat.update();
        //TODO rek.data().getScripts().forEach((script) -> script.onUpdate(this, rek.data()));
        checkForCollisions();
        if(!world.isRemote && ticksExisted % servtick == 0){
        	//throttle = rek.ent().throttle;
        	rek.data().getAttribute("throttle").set((float)throttle);
            //TODO PacketsImpl.sendToAllAround(new PKT_VehControl(this), getTargetPoint(this));
            //TODO for(SwivelPoint point : rek.data().getRotationPoints().values()) point.sendClientUpdate(this);
        }
    }

	private void checkForCollisions(){
		// You expected anything here? Uff.
	}

	@Override
    public boolean attackEntityFrom(DamageSource source, float amount){
        if(world.isRemote || isDead){ return true; }
        if(source.damageType.equals("player") && getDriver() == null){
        	//if(ToggableHandler.handleClick(KeyPress.MOUSE_MAIN)) return true;
            if(rek.data().getLock().isLocked()){
                Print.chat(source.getImmediateSource(), "Vehicle is locked. Unlock to remove it.");
                return false;
            }
            else{
            	EntityPlayer player = (EntityPlayer)source.getTrueSource();
            	if(player.isSneaking()){
            		Print.bar(player, "&4&oRemoving entity without dropping item...."); rek.ent().remove(); return true;
            	}
                if(rek.data().hasPart("engine") && rek.data().getPart("engine").hasFunction("fvtm:engine")){
                	rek.data().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(false);
                }
                ItemStack stack = rek.data().newItemStack().local();
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
                    entityDropItem(stack, 0.5F); setDead(); rek.ent().remove();
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
        ItemStack stack = rek.data().getType().getNewStack().local();
        stack.setItemDamage(0);
		return stack;
    }

    //--- PACKETS ---//
    private long lr = -1;

    @Override
    public void processServerPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("ScriptId")){
            /*for(VehicleScript script : rek.data().getScripts()){
                if(script.getId().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, rek.data(), pkt.nbt, Side.SERVER);
                }
            }*///TODO
        }
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "resync": {
                    NBTTagCompound nbt = this.rek.data().write(TagCW.create()).local();
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
        EngineFunction engine = rek.data().getPart("engine").getFunction("fvtm:engine");
        if(world.isRemote) engine.setState(compound.getBoolean("engine_toggle_result"));
        else compound.setBoolean("engine_toggle_result", engine.toggle());
        if(rek.data().getStoredFuel() == 0){
        	compound.setBoolean("engine_toggle_result", engine.setState(false));
            compound.setBoolean("no_fuel", true);
        }
        ApiUtil.sendEntityUpdatePacketToAllAround(this, compound);
        throttle = 0;
	}

    @SideOnly(Side.CLIENT) @Override
    public void processClientPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("ScriptId")){
            /*for(VehicleScript script : rek.data().getScripts()){
                if(script.getId().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, rek.data(), pkt.nbt, Side.CLIENT);
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
                        Print.chat(player, "Engine toggled " + (rek.data().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(state) ? "on" : "off") + ".");
                        if(pkt.nbt.hasKey("no_fuel") && pkt.nbt.getBoolean("no_fuel")){
                            Print.chat(player, "Out of fuel!");
                            //TODO rek.data().playSound(this, "engine_fail");
                        }
                        else{
							//TODO rek.data().playSound(this, state ? "engine_start" : "engine_stop");
						}
                    }
                    throttle = 0;
                    if(rek.data().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn() && this.engineloop == null){
                        SoundEvent event = (SoundEvent)rek.data().getSound("engine_running").event;
                        if(event != null){
                            //TODO this.engineloop = new LoopSound(event, SoundCategory.NEUTRAL, this);
                            //TODO net.minecraft.client.Minecraft.getMinecraft().getSoundHandler().playSound(this.engineloop);
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
                    this.rek.data().read(new TagCWI(pkt.nbt));
                    break;
                }
                case "toggle_lights": {
                	rek.data().getAttribute("lights").set(pkt.nbt.getBoolean("lights"));
                	break;
                }
                case "update_track":{
                	rek.last = rek.current; rek.current = rek.sys.getTrack(new PathKey((TagCW)pkt.nbt));
                	break;
                }
                case "update_passed":{
                	rek.passed = pkt.nbt.getFloat("passed");
                	break;
                }
                case "update_coupled":{
                	/*long cou = pkt.nbt.getLong("front");
                	railentity.front.entity = cou == -1 ? null : railentity.region.getWorld().getEntity(cou, true);
                	railentity.front.coupled = pkt.nbt.getBoolean("front_static");
                	cou = pkt.nbt.getLong("rear");
                	railentity.rear.entity = cou == -1 ? null : railentity.region.getWorld().getEntity(cou, true);
                	railentity.rear.coupled = pkt.nbt.getBoolean("rear_static");*/
                	break;
                }
                case "update_commands":{
            		/*if(pkt.nbt.hasKey("commands")){
            			railentity.getCommands().clear(); NBTTagList cmds = (NBTTagList)pkt.nbt.getTag("commands");
            			for(NBTBase base : cmds){
            				if(base instanceof NBTTagCompound == false) continue;
            				JEC command = JEC.read((NBTTagCompound)base);
            				if(command != null) railentity.getCommands().add(command);
            			}
            		}*/
                	break;
                }
                case "update_forward":{
                	rek.data().getAttribute("forward").set(pkt.nbt.getBoolean("forward"));
                	break;
                }
            }
        }
    }

	@Override
	public void setupCapability(ContainerHolder capability){
		if(rek == null || rek.data() == null) return; if(world.isRemote){ capability.sync(true); return; }
		for(java.util.Map.Entry<String, PartData> entry : rek.data().getParts().entrySet()){
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
		return true;
	}
	
}
