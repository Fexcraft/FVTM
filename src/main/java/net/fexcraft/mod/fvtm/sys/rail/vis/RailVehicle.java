package net.fexcraft.mod.fvtm.sys.rail.vis;

import java.util.UUID;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
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
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.sys.legacy.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.KeyPress;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.ContainerFunction;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.fexcraft.mod.fvtm.util.handler.ToggableHandler;
import net.fexcraft.mod.fvtm.util.packet.PKT_VehControl;
import net.fexcraft.mod.fvtm.util.packet.PKT_VehKeyPress;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.minecraft.entity.Entity;
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
 */
public class RailVehicle extends GenericVehicle implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate>, ContainerHoldingEntity {

	public Reltrs rek;
	public SwivelPoint rotpoint;
	private byte toggletimer;
	public SeatEntity[] seats;
	//
    public float prevRotationYaw, prevRotationPitch, prevRotationRoll;
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
		this(ent.getRegion().getWorld().getWorld()); ent.entity = this;
		(rek = new Reltrs(ent.getRegion().getWorld(), ent, null)).ent().alignEntity(true);
		initializeVehicle(false, null); Print.debug(this +  " " + rek.uid + " " + this.getPositionVector());
	}

	@Override
	protected void entityInit(){
		//
	}

	private void initializeVehicle(boolean remote, NBTTagCompound compound){
		if(compound != null) rek = new Reltrs(world.getCapability(Capabilities.RAILSYSTEM, null).get(), compound);
		rotpoint = rek.data().getRotationPoint("vehicle");
		seats = new SeatEntity[rek.data().getSeats().size()];
        ContainerHolderUtil.Implementation impl = (Implementation)this.getCapability(Capabilities.CONTAINER, null);
        if(impl != null){ impl.setup = false; this.setupCapability(impl); }
        else{ Print.debug("No ContainerCapability Implementation Found!");}
        rek.data().getScripts().forEach((script) -> script.onSpawn(this, rek.data()));
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		this.setDead();
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		compound.setLong("RailEntity", rek.uid);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = rotpoint.getAxes().write(this, new NBTTagCompound());
        compound.setTag("Entity", rek.write(new NBTTagCompound()));
		ByteBufUtils.writeTag(buffer, compound); //Print.debug("sent: " + compound);
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
        try{
            NBTTagCompound compound = ByteBufUtils.readTag(buffer); //Print.debug("recd: " + compound);
            initializeVehicle(true, compound.getCompoundTag("Entity"));
            rotpoint.loadAxes(this, compound);
            prevRotationYaw = rotpoint.getAxes().getYaw();
            prevRotationPitch = rotpoint.getAxes().getPitch();
            prevRotationRoll = rotpoint.getAxes().getRoll();
        }
        catch(Exception e){
            e.printStackTrace();
            Print.debug("Failed to receive additional spawn data for this vehicle!");
        }
	}
    
    @Override
    public void setDead(){
    	if(rek == null || rek.data() == null){ super.setDead(); return; }
        if(Config.VEHICLE_DROP_CONTENTS && !world.isRemote){
            for(String part : rek.data().getInventories()){
            	InventoryFunction func = rek.data().getPart(part).getFunction("fvtm:inventory"); if(func == null) continue;
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
        super.setDead(); if(!world.isRemote) rek.ent().entity = null;
        if(seats != null) for(SeatEntity seat : seats) if(seat != null) seat.setDead();
        //
        rek.data().getScripts().forEach((script) -> script.onRemove(this, rek.data()));
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
	
	public SeatEntity[] getSeats(){
		return seats;
	}

	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player){
		for(VehicleScript script : rek.data().getScripts()) if(script.onKeyPress(key, seat, player)) return true;
        if(!seat.driver && key.driverOnly()) return false;
        if(world.isRemote && !key.toggables() /*&& key.dismount()*/){
            Packets.sendToServer(new PKT_VehKeyPress(key)); return true;
        }
        switch(key){
            case ACCELERATE:{
                rek.ent().throttle += rek.ent().throttle < 0 ? 0.02f : 0.01F;
                if(rek.ent().throttle > 1F){ rek.ent().throttle = 1F; }
                return true;
            }
            case DECELERATE:{
            	rek.ent().throttle -= rek.ent().throttle > 0 ? 0.02f : 0.01F;
                if(rek.ent().throttle < 0){ rek.ent().throttle = 0; }
                return true;
            }
            case TURN_LEFT:{
            	if(throttle > 0.05f) Print.bar(player, "&cDecrease the throttle before switching direction.");
            	else rek.ent().setForward(player, false);
                return true;
            }
            case TURN_RIGHT:{
            	if(throttle > 0.05f) Print.bar(player, "&cDecrease the throttle before switching direction.");
            	else rek.ent().setForward(player, true);
                return true;
            }
            case BRAKE:{
            	rek.ent().throttle *= 0.8F;
                if(onGround){
                    motionX *= 0.8F;
                    motionZ *= 0.8F;
                }
                if(throttle < -0.0001){
                	rek.ent().throttle = 0;
                }
                return true;
            }
            case ENGINE: {
            	//TODO check this (server/client)
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
                if(rek.data().getPart("engine") != null && rek.data().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
                    Print.chat(player, "Turn engine off first!"); return true;
                }
                GenericContainer.openGui("fvtm", 930, new int[]{ 0, this.getEntityId(), 0 }, player);
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
                	boolean bool = !rek.data().getAttribute("lights").getBooleanValue();
                	rek.data().getAttribute("lights").setValue(bool);
                    NBTTagCompound nbt = new NBTTagCompound(); nbt.setString("task", "toggle_lights");
                    nbt.setBoolean("lights", rek.data().getAttribute("lights").getBooleanValue());
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                    toggletimer = 10;
                    //
                    if(rek.ent().getCompound().isMultiple()){
                    	for(RailEntity ent : rek.ent().getCompound().getEntitites()){
                    		ent.vehdata.getAttribute("lights").setValue(bool);
                    		if(ent.entity != null){
    	                        NBTTagCompound com = new NBTTagCompound(); com.setString("task", "toggle_lights");
    	                        com.setBoolean("lights", rek.data().getAttribute("lights").getBooleanValue());
    	                        ApiUtil.sendEntityUpdatePacketToAllAround(ent.entity, com);
                    		}
                    	}
                    }
                }
                return true;
            }
            case COUPLER_FRONT: {
            	if(toggletimer > 0) return true;
    			rek.ent().tryCoupling(player, true);
    			toggletimer = 10; return true;
            }
            case COUPLER_REAR: {
            	if(toggletimer > 0) return true;
    			rek.ent().tryCoupling(player, true);
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
            sptt = servtick;
        }
        else{
            setPosition(posX, posY, posZ);
            prevRotationYaw = yaw;
            prevRotationPitch = pitch;
            prevRotationRoll = roll;
            setRotation(yaw, pitch, roll);
        }
        motionX = motX; motionY = motY; motionZ = motZ; angularVelocity = avel;
        this.throttle = throttle; rek.data().getAttribute("fuel_stored").setValue(fuel);
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
        return world.isRemote && rek.ent() == null ? "noent" : rek.data() == null ? "novehdata" : rek.data().getType().getName();
    }

    @SideOnly(Side.CLIENT) @Override
    public boolean isInRangeToRenderDist(double dist){
        return Config.RENDER_OUT_OF_VIEW ? true : super.isInRangeToRenderDist(dist);
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(){
        return this.getCollisionBox(this);
    }
	
	@Override
	public VehicleEntity getCoupledEntity(boolean front){
		return world.isRemote ? null : front ? rek.ent().front.hasEntity() ? rek.ent().front.entity.entity : null
			: rek.ent().rear.hasEntity() ? rek.ent().rear.entity.entity : null;
	}
	
	@Override
	public VehicleEntity getFrontCoupledEntity(){
		return world.isRemote ? null : rek.ent().front.hasEntity() ? rek.ent().front.entity.entity : null;
	}
	
	@Override
	public VehicleEntity getRearCoupledEntity(){
		return world.isRemote ? null : rek.ent().rear.hasEntity() ? rek.ent().rear.entity.entity : null;
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
        if(rek.data().isLocked()){ Print.chat(player, "Vehicle is locked."); return true; }
        if(!stack.isEmpty()){
            if(stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getType().isFuelContainer()){
            	GenericContainer.openGui("fvtm", 933, new int[]{ 933, this.getEntityId(), 0 }, player); return true;
            }
            else if(stack.getItem() instanceof ContainerItem){
            	this.getCapability(Capabilities.CONTAINER, null).openGUI(player); return true;
            }
            //space for other item interaction
            else{
                if(rek.data().getPart("engine") != null && rek.data().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn()){
                    Print.chat(player, "Turn engine off first!");
                }
                else{
                	GenericContainer.openGui("fvtm", 930, new int[]{ 0, this.getEntityId(), 0 }, player);
                }
                return true;
            }
        }
        else if(ToggableHandler.handleClick(KeyPress.MOUSE_RIGHT)) return true;
        if(!rek.data().getScripts().isEmpty()){
            for(VehicleScript script : rek.data().getScripts()){
                if(script.onInteract(this, rek.data(), player, hand)){
                    return true;
                }
            }
        }
        for(SeatEntity seat : seats){ if(seat.processInitialInteract(player, hand)){ return true; } }
        return false;
    }

    @Override
    public void onUpdate(){
        super.onUpdate();
        if(rek == null || rek.data() == null){
        	Print.log("VehicleData is NULL; Not ticking vehicle. Removing Vehicle."); this.setDead(); return;
        }
        if(!world.isRemote){
        	for(int i = 0; i < rek.data().getSeats().size(); i++){
        		//Seat seat = rek.data().getSeat(i);
            	if(seats[i] == null || !seats[i].addedToChunk){
            		seats[i] = new SeatEntity(this, i); world.spawnEntity(seats[i]);
            	}
        	}
        }
        prevRotationYaw = rotpoint.getAxes().getYaw();
        prevRotationPitch = rotpoint.getAxes().getPitch();
        prevRotationRoll = rotpoint.getAxes().getRoll();
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
                double dYaw = MathHelper.wrapDegrees(serverYaw - rotpoint.getAxes().getYaw());
                double dPitch = MathHelper.wrapDegrees(serverPitch - rotpoint.getAxes().getPitch());
                double dRoll = MathHelper.wrapDegrees(serverRoll - rotpoint.getAxes().getRoll());
                rotationYaw = (float)(rotpoint.getAxes().getYaw() + dYaw / sptt);
                rotationPitch = (float)(rotpoint.getAxes().getPitch() + dPitch / sptt);
                float rotationRoll = (float)(rotpoint.getAxes().getRoll() + dRoll / sptt);
                --sptt; setPosition(x, y, z);
                setRotation(rotationYaw, rotationPitch, rotationRoll); //return;
            }
        	rek.data().getAttribute("throttle").setValue((float)throttle);
        	//
        	Vec3f bf0 = rek.moveOnly(rek.passed + 0.1f), bf1 = rek.moveOnly(rek.passed - 0.1f);
        	Vec3f br0 = rek.moveOnly(rek.passed - rek.frbogiedis - rek.rrbogiedis + 0.1f);
        	Vec3f br1 = rek.moveOnly(rek.passed - rek.frbogiedis - rek.rrbogiedis - 0.1f);
        	if(bf0 != null && br0 != null && bf1 != null && br1 != null){
        		float front = (float)(Math.toDegrees(Math.atan2(bf0.zCoord - bf1.zCoord, bf0.xCoord - bf1.xCoord)) - rotpoint.getAxes().getYaw());
        		float rear  = (float)(Math.toDegrees(Math.atan2(br0.zCoord - br1.zCoord, br0.xCoord - br1.xCoord)) - rotpoint.getAxes().getYaw());
        		rek.data().getAttribute("bogie_front_angle").setValue(front); rek.data().getAttribute("bogie_rear_angle").setValue(rear);
        	}
    		//
    		/*if(Command.DEBUG)*/ rek.updatePosition();
        }
        if(!world.isRemote){
            rek.ent().alignEntity(false);
            //
            Vec3d front = new Vec3d(rek.ent().bfront.xCoord, rek.ent().bfront.yCoord, rek.ent().bfront.zCoord);
            Vec3d back = new Vec3d(rek.ent().brear.xCoord, rek.ent().brear.yCoord, rek.ent().brear.zCoord);
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
            rotpoint.getAxes().setAngles(yaw * 180F / 3.14159F, pitch * 180F / 3.14159F, roll * 180F / 3.14159F);
        }
        else{
        	
        }
        for(SwivelPoint point : rek.data().getRotationPoints().values()) point.update(this);
        rek.data().getScripts().forEach((script) -> script.onUpdate(this, rek.data()));
        checkForCollisions();
        for(SeatEntity seat : seats){ if(seat != null){ seat.updatePosition(); } }
        if(!world.isRemote && ticksExisted % servtick == 0){
        	throttle = rek.ent().throttle;
        	rek.data().getAttribute("throttle").setValue((float)throttle);
            Packets.sendToAllAround(new PKT_VehControl(this), Resources.getTargetPoint(this));
            for(SwivelPoint point : rek.data().getRotationPoints().values()) point.sendClientUpdate(this);
        }
    }

	private void checkForCollisions(){
		// You expected anything here? Uff.
	}
    
    @Override
    public void updatePassenger(Entity passenger){
        //
    }

	@Override
    public boolean attackEntityFrom(DamageSource source, float amount){
        if(world.isRemote || isDead){ return true; }
        if(source.damageType.equals("player") && (seats.length > 0 ? (seats[0] == null || seats[0].getControllingPassenger() == null) : true)){
        	if(ToggableHandler.handleClick(KeyPress.MOUSE_MAIN)) return true;
            if(rek.data().isLocked()){
                Print.chat(source.getImmediateSource(), "Vehicle is locked. Unlock to remove it.");
                return false;
            }
            else{
            	EntityPlayer player = (EntityPlayer)source.getTrueSource();
            	if(player.isSneaking()){
            		Print.bar(player, "&4&oRemoving entity without dropping item...."); rek.ent().dispose(); return true;
            	}
                if(rek.data().hasPart("engine") && rek.data().getPart("engine").hasFunction("fvtm:engine")){
                	rek.data().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(false);
                }
                ItemStack stack = rek.data().newItemStack();
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
                    entityDropItem(stack, 0.5F); setDead(); rek.ent().dispose();
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
        ItemStack stack = rek.data().getType().newItemStack();
        stack.setItemDamage(0); return stack;
    }

    //--- PACKETS ---//
    private long lr = -1;

    @SuppressWarnings("unused") @Override
    public void processServerPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("ScriptId")){
            for(VehicleScript script : rek.data().getScripts()){
                if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, rek.data(), pkt.nbt, Side.SERVER);
                }
            }
        }
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "engine_toggle": {
                    if(lr + 1000 >= Time.getDate()){ break; }
                    lr = Time.getDate(); boolean on = false, nf = false; EngineFunction engine = rek.data().getPart("engine").getFunction("fvtm:engine");
                    pkt.nbt.setBoolean("engine_toggle_result", on = engine.toggle());
                    if(rek.data().getStoredFuel() == 0){
                        pkt.nbt.setBoolean("engine_toggle_result", on = false);
                        pkt.nbt.setBoolean("no_fuel", nf = true);
                    }
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, pkt.nbt);
                    rek.ent().throttle = 0;
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
                    NBTTagCompound nbt = this.rek.data().write(new NBTTagCompound());
                    nbt.setString("task", "update_vehicledata");
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT) @Override
    public void processClientPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("ScriptId")){
            for(VehicleScript script : rek.data().getScripts()){
                if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, rek.data(), pkt.nbt, Side.SERVER);
                }
            }
        }
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "engine_toggle": {
                    if(net.minecraft.client.Minecraft.getMinecraft().player.isRiding() && this.seats[0] == net.minecraft.client.Minecraft.getMinecraft().player.getRidingEntity()){
                        Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Engine toggled " + (rek.data().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").setState(pkt.nbt.getBoolean("engine_toggle_result")) ? "on" : "off") + ".");
                        if(pkt.nbt.hasKey("no_fuel") && pkt.nbt.getBoolean("no_fuel")){
                            Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Out of fuel!");
                        }
                    } throttle = 0;
                    break;
                }
                case "resync":
                case "update_vehicledata": {
                    this.rek.data().read(pkt.nbt);
                    break;
                }
                case "toggle_lights": {
                	rek.data().getAttribute("lights").setValue(pkt.nbt.getBoolean("lights"));
                	break;
                }
                case "update_track":{
                	rek.last = rek.current; rek.current = rek.sys.getTrack(new PathKey(pkt.nbt));
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
		return rotpoint.getAxes().toDoubles();
	}

	@Override
	public boolean isRailType(){
		return true;
	}
}
