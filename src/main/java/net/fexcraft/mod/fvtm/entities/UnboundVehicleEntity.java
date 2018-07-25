package net.fexcraft.mod.fvtm.entities;


import java.util.TreeMap;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Container.ContainerHolder;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Fuel.FuelItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.MovementCalculationEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.impl.EngineLoopSound;
import net.fexcraft.mod.fvtm.util.FvtmPermissions;
import net.fexcraft.mod.fvtm.util.ItemStackHandler;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleControl;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleKeyPress;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.server.permission.PermissionAPI;

public abstract class UnboundVehicleEntity extends Entity implements VehicleEntity, IEntityAdditionalSpawnData, LockableObject, IPacketReceiver<PacketEntityUpdate> {
	
    protected boolean sync;
    //
    protected VehicleData vehicledata;
    public VehicleAxes axes;
    protected VehicleAxes prevAxes;
    protected WheelEntity[] wheels;
    protected SeatEntity[] seats;
    protected TreeMap<String, ContainerHolder> containers;
    protected double throttle;
    protected float wheelsAngle, wheelsYaw;
    public float prevRotationYaw, prevRotationPitch, prevRotationRoll;
    protected VehicleEntity parentent, trailer;
    public Vec3d angularVelocity = new Vec3d(0F, 0F, 0F);
    protected byte doorToggleTimer = 0;
    public EngineLoopSound engineloop;
    //
    public double serverPosX, serverPosY, serverPosZ;
    public double serverYaw, serverPitch, serverRoll;
    public int serverPositionTransitionTicker, consize = -1;

    /**
     * Generic Constructor, Client/Load from NBT
     */
    public UnboundVehicleEntity(World world){
        super(world);
        axes = new VehicleAxes();
        prevAxes = new VehicleAxes();
        preventEntitySpawning = true;
        setSize(1F, 1F);
        ignoreFrustumCheck = true;
        if(world.isRemote){
            setRenderDistanceWeight(1d);
        }
        //
        stepHeight = 1.0F;
    }

    protected UnboundVehicleEntity(World world, VehicleData type){
        this(world);
        vehicledata = type;
    }

    /**
     * From Constructor (Item)
     */
    public UnboundVehicleEntity(World world, double x, double y, double z, EntityPlayer placer, VehicleData vehicleData){
        this(world, vehicleData);
        stepHeight = 1.0F;
        setPosition(x, y, z);
        rotateYaw(placer.rotationYaw + 90F);
        initVeh(vehicleData, false);
    }

    /**
     * From Constructor (Center)
     */
    public UnboundVehicleEntity(World world, double x, double y, double z, int placer, VehicleData data){
        this(world, data);
        stepHeight = 1.0F;
        setPosition(x, y, z);
        rotateYaw((placer * 90f) + 90F);
        initVeh(data, false);
        Print.debugChat("SPAWNING");
    }

    @Override
    protected void entityInit(){
        //
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound){
        if(vehicledata == null){
            vehicledata = Resources.getVehicleData(compound);
        }
        else{
            vehicledata.readFromNBT(compound);
        }
        prevRotationYaw = compound.getFloat("RotationYaw");
        prevRotationPitch = compound.getFloat("RotationPitch");
        prevRotationRoll = compound.getFloat("RotationRoll");
        axes = VehicleAxes.read(this, compound);
        initVeh(vehicledata, false);
        Print.debug(compound.toString());
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
        compound = vehicledata.writeToNBT(compound);
        axes.write(this, compound);
        Print.debug(compound.toString());
    }

    protected void initVeh(VehicleData type, boolean remote){
        seats = new SeatEntity[type.getSeats().size()];
        wheels = new WheelEntity[type.getWheelPos().size()];
        stepHeight = type.getVehicle().getFMAttribute("wheel_step_height");
        vehicledata.getScripts().forEach((script) -> script.onCreated(this, vehicledata));
        if(vehicledata.getContainerHolders().size() > 0){
        	containers = new TreeMap<>();
        	consize = 0;
        	for(PartData data : vehicledata.getContainerHolders()){
        		if(data.getAttributeData(ContainerAttributeData.class) != null){
        			if(data.getAttributeData(ContainerAttributeData.class).getAttribute().getContainerType() == ContainerType.LARGE){
        				consize += 3;
        			}
        			else{
        				consize++;
        			}
        		}
        	}
        }
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

    public void checkForCollisions(){
        return;
    }

    protected boolean isDriverInGM1(){
        return seats != null && seats.length > 0 && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer) seats[0].getControllingPassenger()).capabilities.isCreativeMode;
    }

    public boolean hasEnoughFuel(){
        return isDriverInGM1() || (vehicledata != null && vehicledata.getPart("engine") != null && vehicledata.getFuelTankContent() > vehicledata.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle);
    }

    public boolean isDrivenByPlayer(){
        if(vehicledata.getVehicle().isTrailerOrWagon()){
            return getParent() != null && getParent().getSeats()[0] != null && SeatEntity.isPassengerThePlayer((SeatEntity)getParent().getSeats()[0]);
        }
        else{
            return seats[0] != null && SeatEntity.isPassengerThePlayer((SeatEntity)seats[0]);
        }
    }

    //--- SPAWN DATA ---//
    @Override
    public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = new NBTTagCompound();
        if(getParent() != null){
            compound.setInteger("ParentId", getParent().getEntity().getEntityId());
        }
        ByteBufUtils.writeTag(buffer, axes.write(this, vehicledata.writeToNBT(compound)));
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
        try{
            NBTTagCompound compound = ByteBufUtils.readTag(buffer);
            vehicledata = Resources.getVehicleData(compound);
            axes = VehicleAxes.read(this, compound);
            prevRotationYaw = axes.getYaw();
            prevRotationPitch = axes.getPitch();
            prevRotationRoll = axes.getRoll();
            initVeh(vehicledata, true);
        }
        catch(Exception e){
            e.printStackTrace();
            Print.debug("Failed to receive additional spawn data for this vehicle!");
        }
        //camera = new CameraEntity(world, this);
        //world.spawnEntity(camera);
    }

    //--- IMPLEMENTATION ---//
    @Override
    public VehicleData getVehicleData(){
        return vehicledata;
    }

    @Override
    public VehicleType getVehicleType(){
        return vehicledata.getVehicle().getType();
    }

    @Override
    public Entity getEntity(){
        return this;
    }

    @Override
    public VehicleAxes getAxes(){
        return axes;
    }

    @Override
    public MovementCalculationEntity[] getWheels(){
        return wheels;
    }

    @Override
    public SeatEntity[] getSeats(){
        return seats;
    }

    @Override
    public boolean onKeyPress(int key, int seat, EntityPlayer player){
        if(seat != 0 && key != 6 && key != 11){
            return false;
        }
        if(world.isRemote && key >= 6){
            PacketHandler.getInstance().sendToServer(new PacketVehicleKeyPress(key));
            return true;
        }
        switch(key){
            case 0: {//Accelerate;
                throttle += 0.005F;
                if(throttle > 1F){
                    throttle = 1F;
                }
                return true;
            }
            case 1: {//Decelerate
                throttle -= 0.005F;
                if(throttle < -1F){
                    throttle = -1F;
                }
                if(throttle < 0F && vehicledata.getVehicle().getFMAttribute("max_negative_throttle") == 0F){
                    throttle = 0F;
                }
                return true;
            }
            case 2: {//Left
                wheelsYaw -= 1F;
                return true;
            }
            case 3: {//Right
                wheelsYaw += 1F;
                return true;
            }
            case 4: {//Brake
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
            case 5: {//Toggle Engine
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString("task", "engine_toggle");
                ApiUtil.sendEntityUpdatePacketToServer(this, nbt);
                return true;
            }
            case 6: {//Exit
                PacketHandler.getInstance().sendToAllAround(new PacketVehicleControl(this), Resources.getTargetPoint(this));
                player.dismountRidingEntity();
                return true;
            }
            case 7: {//Inventory
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
            case 10: {
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
            case 11: {
                if(!world.isRemote){
                    player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_SCRIPTSGUI, world, this.getEntityId(), seat, 0);
                    //open scripts gui
                }
                return true;
            }
            case 12: {
                if(!world.isRemote){
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
                }
                return true;
            }
            case 13: {
            	if(!world.isRemote){
            		if(throttle > 0 || throttle < 0){
            			Print.chat(player, "Please stop the vehicle first!");
            			return true;
            		}
            		if(this.vehicledata.getRearConnector() == null){
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
            	}
            	return true;
            }
        }
        return false;
    }

	private void tryAttach(EntityPlayer player){
		if(this.getEntityAtRear() != null){
			Print.chat(player, "Trailer already Connected.");
		}
		VehicleEntity trailer = null;
		AxisAlignedBB aabb = new AxisAlignedBB(new BlockPos(this.getPositionVector().add(axes.getRelativeVector(vehicledata.getRearConnector().to16Double()))));
		for(Entity e : world.loadedEntityList){
			if(e instanceof VehicleEntity && e.getEntityBoundingBox().intersects(aabb)){
				VehicleEntity ent = (VehicleEntity)e;
				if(ent.getVehicleData().getVehicle().isTrailerOrWagon() && ent.getEntityAtFront() == null && !ent.getEntity().isRiding()){
					trailer = ent;
					break;
				}
			}
		}
		if(trailer != null){
			try{
				if(trailer instanceof GenericTrailerEntity){
					GenericTrailerEntity ent = (GenericTrailerEntity)trailer;
					ent.parentent = this;
		            NBTTagCompound nbt = new NBTTagCompound();
		            nbt.setString("task", "update_connection");
		            nbt.setInteger("entity", this.getEntityId());
		            ApiUtil.sendEntityUpdatePacketToAllAround(ent, nbt);
		            //
		            nbt = new NBTTagCompound();
		            nbt.setString("task", "update_trailer");
		            nbt.setInteger("entity", ent.getEntityId());
		            ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
				}
				trailer.getEntity().startRiding(this);
				Print.chat(player, "Trailer attached.");
			}
			catch(Exception e){
				Print.chat(player, "ERROR! See console for info.");
				e.printStackTrace();
			}
		}
		else{
			Print.chat(player, "No Trailer Entity found at connector position.");
		}
	}

    private void tryDetach(EntityPlayer player){
		if(this.getEntityAtRear() == null){
			Print.chat(player, "No Trailer Connected!");
		}
		VehicleEntity rear = this.getEntityAtRear();
		rear.getEntity().dismountRidingEntity();
		if(rear instanceof UnboundVehicleEntity){
			((UnboundVehicleEntity)rear).parentent = null;
		}
		this.trailer = null;
		Print.chat(player, "Trailer detached.");
		//
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("task", "update_connection");
        nbt.setInteger("entity", -1);
        ApiUtil.sendEntityUpdatePacketToAllAround(rear.getEntity(), nbt);
        //
        nbt = new NBTTagCompound();
        nbt.setString("task", "update_trailer");
        nbt.setInteger("entity", -1);
        ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
	}

    @Override
    public double getThrottle(){
        return throttle;
    }
    
    @Override
    public void setThrottle(double newthr){
        this.throttle = newthr;
    }

    @Override
    public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, double avelx, double avely, double avelz, double throttle, float steeringYaw){
        if(world.isRemote){
            serverPosX = posX;
            serverPosY = posY;
            serverPosZ = posZ;
            serverYaw = yaw;
            serverPitch = pitch;
            serverRoll = roll;
            serverPositionTransitionTicker = 5;
        }
        else{
            setPosition(posX, posY, posZ);
            prevRotationYaw = yaw;
            prevRotationPitch = pitch;
            prevRotationRoll = roll;
            setRotation(yaw, pitch, roll);
        }
        motionX = motX;
        motionY = motY;
        motionZ = motZ;
        angularVelocity = new Vec3d(avelx, avely, avelz);
        if(!(seats.length > 0 && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer)){
            this.throttle = throttle;
        }
        //
        wheelsYaw = steeringYaw;
    }

    @Override
    public VehicleEntity getEntityAtFront(){
        return vehicledata.getVehicle().isTrailerOrWagon() ? getParent() : null;
    }

    @Override
    public VehicleEntity getEntityAtRear(){
        return trailer == null ? this.getPassengers().isEmpty() ? null : this.getPassengers().get(0) instanceof VehicleEntity ? (VehicleEntity)this.getPassengers().get(0) : null : trailer;
    }

    @Override
    public Vec3d getAngularVelocity(){
        return angularVelocity;
    }

    @Override
    public float getWheelsAngle(){
        return wheelsAngle;
    }

    @Override
    public float getWheelsYaw(){
        return wheelsYaw;
    }

    //--- LOCKING ---//
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
    public boolean lock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
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

    //--- VANILLA ---//
    @Override
    protected boolean canTriggerWalking(){
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity){
        return null;
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
    public void setDead(){
        if(Config.DROP_ITEMS_ON_BREAK && !world.isRemote){
            for(Part.PartData partData : this.vehicledata.getInventoryContainers()){
                InventoryAttribute.InventoryAttributeData invattr = partData.getAttributeData(InventoryAttribute.InventoryAttributeData.class);
                if(invattr == null){
                    continue;
                }
                for(int i = 0; i < invattr.getInventory().size(); i++){
                    this.entityDropItem(invattr.getInventory().get(i), 0.5f);
                    invattr.getInventory().set(i, ItemStack.EMPTY);
                }
            }
        }
        //
        super.setDead();
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
        if(containers != null){
        	containers.clear();
        	containers = null;
        }
        vehicledata.getScripts().forEach((script) -> script.onRemove(this, vehicledata));
        if(this.getEntityAtRear() != null){
            this.getEntityAtRear().getEntity().dismountRidingEntity();
            ((UnboundVehicleEntity)this.getEntityAtRear()).parentent = null;
        }
        if(world.isRemote){
        	net.fexcraft.mod.fvtm.util.RenderCache.removeEntity(this);
        }
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
    public void applyEntityCollision(Entity entity){
        return;
    }

    @Override
    public void setVelocity(double x, double y, double z){
        motionX = x;
        motionY = y;
        motionZ = z;
    }

    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
        if(isDead || world.isRemote || hand == EnumHand.OFF_HAND){
            return false;
        }
        ItemStack stack = player.getHeldItem(hand);
        if(!stack.isEmpty() && stack.getItem() instanceof KeyItem && (stack.getItem() instanceof Material.MaterialItem ? ((Material.MaterialItem) stack.getItem()).getMaterial(stack).isVehicleKey() : true)){
            if(this.isLocked()){
                this.unlock(world, player, stack, (KeyItem) stack.getItem());
            }
            else{
                this.lock(world, player, stack, (KeyItem) stack.getItem());
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
                if(this.vehicledata.getRearConnector() != null && this.getEntityAtRear() == null && ((VehicleItem) stack.getItem()).getVehicle(stack).getVehicle().isTrailerOrWagon()){
                    Print.chat(player, "Connecting...");
                    GenericTrailerEntity trailer = new GenericTrailerEntity(world, ((VehicleItem) stack.getItem()).getVehicle(stack), this);
                    world.spawnEntity(trailer);
                    stack.shrink(64);
                    return true;
                }
            }
            //TODO other Item interaction
        }
        if(!vehicledata.getScripts().isEmpty()){
            for(VehicleScript script : vehicledata.getScripts()){
                if(script.onInteract(this, vehicledata, player, hand)){
                    return true;
                }
            }
        }
        for(int i = 0; i <= vehicledata.getSeats().size(); i++){
            if(seats[i] != null && seats[i].processInitialInteract(player, hand)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport){
        if(ticksExisted > 1){
            return;
        }
        if(this.getControllingPassenger() != null && this.getControllingPassenger() instanceof EntityPlayer){
            //
        }
        else{
            if(sync){
                serverPositionTransitionTicker = posRotationIncrements + 5;
            }
            else{
                double var10 = x - posX;
                double var12 = y - posY;
                double var14 = z - posZ;
                double var16 = var10 * var10 + var12 * var12 + var14 * var14;
                if(var16 <= 1.0D){
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
    public void onUpdate(){
        super.onUpdate();
        if(vehicledata == null){
            Print.log("VehicleData is NULL; Not ticking vehicle.");
            Static.stop();
            return;
        }
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
            if(vehicledata.getVehicle().isTrailerOrWagon()){
            	if(getParent() == null){
                	if(wheels.length == 2){
                		wheels = new WheelEntity[]{ wheels[0], wheels[1], null, null };
                	}
                	if(wheels[2] == null || !wheels[2].addedToChunk){
                        wheels[2] = new WheelEntity(world, this, 2);
                        world.spawnEntity(wheels[2]);
                    }
                	if(wheels[3] == null || !wheels[3].addedToChunk){
                        wheels[3] = new WheelEntity(world, this, 2);
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
            if(containers != null && containers.size() < consize){
            	vehicledata.getParts().forEach((key, part) -> {
            		if(part.getAttributeData(ContainerAttributeData.class) != null){
            			ContainerAttributeData condata = part.getAttributeData(ContainerAttributeData.class);
            			if(condata.getAttribute().getContainerType() == ContainerType.LARGE){
            				if(!containers.containsKey(key + "_0")){
            					containers.put(key + "_0", new ContainerWrapper(this, condata, ContainerPosition.MEDIUM_DUAL1, 0));
            				}
            				if(!containers.containsKey(key + "_1")){
            					containers.put(key + "_1", new ContainerWrapper(this, condata, ContainerPosition.MEDIUM_DUAL2, 1));
            				}
            				if(!containers.containsKey(key)){
            					containers.put(key, new ContainerWrapper(this, condata, ContainerPosition.LARGE_SINGLE, -1));
            				}
            			}
            			else{
            				if(!containers.containsKey(key)){
            					containers.put(key, new ContainerWrapper(this, condata, ContainerPosition.MEDIUM_SINGLE, -1));
            				}
            			}
            		}
            	});
            }
        }
        else{
            if(vehicledata.getVehicle().isTrailerOrWagon()){
            	if(getParent() == null){
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
        prevAxes = axes.clone();
        this.ticksExisted++;
        if(this.ticksExisted > Integer.MAX_VALUE){
            this.ticksExisted = 0;
        }
        //
        if(seats == null || (!vehicledata.getVehicle().isTrailerOrWagon() && seats.length == 0)){
            this.setDead();
            return;
        }
        if(doorToggleTimer > 0){
            doorToggleTimer--;
        }
        //
        boolean drivenByPlayer = isDrivenByPlayer();
        wheelsYaw *= 0.9F;
        if(wheelsYaw > 20){
            wheelsYaw = 20;
        }
        if(wheelsYaw < -20){
            wheelsYaw = -20;
        }
        if(world.isRemote && !drivenByPlayer){
            if(serverPositionTransitionTicker > 0){
                double x = posX + (serverPosX - posX) / serverPositionTransitionTicker;
                double y = posY + (serverPosY - posY) / serverPositionTransitionTicker;
                double z = posZ + (serverPosZ - posZ) / serverPositionTransitionTicker;
                double dYaw = MathHelper.wrapDegrees(serverYaw - axes.getYaw());
                double dPitch = MathHelper.wrapDegrees(serverPitch - axes.getPitch());
                double dRoll = MathHelper.wrapDegrees(serverRoll - axes.getRoll());
                rotationYaw = (float) (axes.getYaw() + dYaw / serverPositionTransitionTicker);
                rotationPitch = (float) (axes.getPitch() + dPitch / serverPositionTransitionTicker);
                float rotationRoll = (float) (axes.getRoll() + dRoll / serverPositionTransitionTicker);
                --serverPositionTransitionTicker;
                setPosition(x, y, z);
                setRotation(rotationYaw, rotationPitch, rotationRoll);
                //return;
            }
        }
        for(WheelEntity wheel : wheels){
            if(wheel != null && world != null){
                wheel.prevPosX = wheel.posX;
                wheel.prevPosY = wheel.posY;
                wheel.prevPosZ = wheel.posZ;
            }
        }
        if(this.vehicledata.getVehicle().isTrailerOrWagon() ? this.wheels.length > 2 : true){
            if(hasEnoughFuel()){
                wheelsAngle += throttle * 0.2F;
            }
            //
            if((seats.length > 0 && seats[0] != null && seats[0].getControllingPassenger() == null) || !(isDriverInGM1() || vehicledata.getFuelTankContent() > 0) && vehicledata.getVehicle().getFMAttribute("max_positive_throttle") != 0){
                throttle *= 0.98F;
            }
            this.onUpdateMovement();
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
                if(vehicledata.getVehicle().getDriveType().hasTracks()){
                    yaw = (float) Math.atan2(wheels[3].posZ - wheels[2].posZ, wheels[3].posX - wheels[2].posX) + (float) Math.PI / 2F;
                }
                axes.setAngles(yaw * 180F / 3.14159F, pitch * 180F / 3.14159F, roll * 180F / 3.14159F);
            }
        }
        else{
        	
        }
        vehicledata.getScripts().forEach((script) -> script.onUpdate(this, vehicledata));
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
    }

    public abstract void onUpdateMovement();
    
    @Override
    public void updatePassenger(Entity passenger){
        if(passenger instanceof GenericTrailerEntity){
            ((VehicleEntity)passenger).moveTrailer();
        }
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i){
        //Print.debug(damagesource.damageType, damagesource.getImmediateSource().toString());
        if(world.isRemote || isDead){
            return true;
        }
        if(damagesource.damageType.equals("player") && (seats.length > 0 ? (seats[0] == null || seats[0].getControllingPassenger() == null) : true)){
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
                if(PermissionAPI.hasPermission((EntityPlayer)damagesource.getImmediateSource(), FvtmPermissions.VEHICLE_BREAK)
                	|| PermissionAPI.hasPermission((EntityPlayer)damagesource.getImmediateSource(), FvtmPermissions.permBreak(stack))){
                    if(this.getEntityAtRear() != null){
                        Entity ent = this.getEntityAtRear().getEntity();
                        /*VehicleData rear = this.getEntityAtRear().getVehicleData();
                        rear.getScripts().forEach((script) -> script.onRemove(ent, rear));
                        ItemStack trailerstack = rear.getVehicle().getItemStack(rear);
                        ent.entityDropItem(trailerstack, 0.5F);
                        ent.setDead();
                        Print.debug(trailerstack.toString());*/
                        if(ent instanceof UnboundVehicleEntity){
                            ((UnboundVehicleEntity)this.getEntityAtRear()).parentent = null;
                        }
                        ent.dismountRidingEntity();
                    }
                    //
                    entityDropItem(stack, 0.5F);
                    setDead();
                    Print.debug(stack.toString());
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
    public void fall(float distance, float damageMultiplier){
        //
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

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isInRangeToRenderDist(double dist){
        return Config.RENDER_OUT_OF_VIEW ? true : super.isInRangeToRenderDist(dist);
    }

    //--- PACKETS ---//
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
                case "engine_toggle": {
                    if(lr + 1000 >= Time.getDate()){
                        break;
                    }
                    lr = Time.getDate();
                    boolean on = false, nf = false;
                    pkt.nbt.setBoolean("engine_toggle_result", on = vehicledata.getPart("engine").getAttributeData(EngineAttributeData.class).toggle());
                    if(vehicledata.getFuelTankContent() == 0 || vehicledata.getFuelTankContent() < 0.1){
                        pkt.nbt.setBoolean("engine_toggle_result", on = false);
                        pkt.nbt.setBoolean("no_fuel", nf = true);
                    }
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, pkt.nbt);
                    throttle = 0;
                    //
                    SoundEvent event = vehicledata.getPart("engine").getPart().getSound(nf ? "engine_fail" : on ? "engine_start" : "engine_stop");
                    if(event != null){
                        this.playSound(event, 0.5f, 1f);
                        //this.world.playSound(null, this.posX, this.posY, this.posZ, event, this.getSoundCategory(), 1f, 1f);
                        Print.debug((nf ? "engine_fail" : on ? "engine_start" : "engine_stop") + " -> Playing!");
                    }
                    else{
                        Print.debug((nf ? "engine_fail" : on ? "engine_start" : "engine_stop") + " -> Not found.");
                    }
                    break;
                }
                case "resync": {
                    NBTTagCompound nbt = this.vehicledata.writeToNBT(new NBTTagCompound());
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
            for(VehicleScript script : vehicledata.getScripts()){
                if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, vehicledata, pkt.nbt, Side.SERVER);
                }
            }
        }
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "engine_toggle": {
                    if(net.minecraft.client.Minecraft.getMinecraft().player.isRiding() && this.seats[0] == net.minecraft.client.Minecraft.getMinecraft().player.getRidingEntity()){
                        Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Engine toggled " + (vehicledata.getPart("engine").getAttributeData(EngineAttributeData.class).setOn(pkt.nbt.getBoolean("engine_toggle_result")) ? "on" : "off") + ".");
                        if(pkt.nbt.hasKey("no_fuel") && pkt.nbt.getBoolean("no_fuel")){
                            Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Out of fuel!");
                        }
                    }
                    throttle = 0;
                    if(vehicledata.getPart("engine").getAttributeData(EngineAttributeData.class).isOn() && this.engineloop == null){
                        SoundEvent event = vehicledata.getPart("engine").getPart().getSound("engine_running");
                        if(event != null){
                            this.engineloop = new EngineLoopSound(event, SoundCategory.NEUTRAL, this);
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
                    this.vehicledata.readFromNBT(pkt.nbt);
                    break;
                }
                case "lights_toggle": {
                    this.vehicledata.setLightsState(pkt.nbt.getInteger("lightsstate"));
                    if(this.getEntityAtRear() != null){
                        this.getEntityAtRear().getVehicleData().setLightsState(pkt.nbt.getInteger("lightsstate"));
                    }
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
                	int ent = pkt.nbt.getInteger("entity");
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
                	}
                	break;
                }
            }
        }
    }

    // --- CAPABILITIES --- //
    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            if(facing.getAxis().isVertical() && !this.isLocked() && seats != null && seats[0] != null && seats[0].getControllingPassenger() == null){
                return !this.vehicledata.getInventoryContainers().isEmpty() && this.vehicledata.getInventoryContainers().get(0).getPart().getAttribute(InventoryAttribute.class).getType() == InventoryType.ITEM;
            }
            return false;
        }
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
            if(facing.getAxis().isVertical() && !this.isLocked() && seats != null && seats[0] != null && seats[0].getControllingPassenger() == null){
                return !this.vehicledata.getInventoryContainers().isEmpty() && this.vehicledata.getInventoryContainers().get(0).getPart().getAttribute(InventoryAttribute.class).getType() == InventoryType.FLUID;
            }
            return false;
        }
        return super.hasCapability(capability, facing);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && this.hasCapability(capability, facing)){
            return (T) new ItemStackHandler(this.vehicledata.getInventoryContainers().get(0).getAttributeData(InventoryAttributeData.class).getInventory());
        }
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && this.hasCapability(capability, facing)){
            return (T) this.vehicledata.getInventoryContainers().get(0).getAttributeData(InventoryAttributeData.class).getFluidHandler();
        }
        return super.getCapability(capability, facing);
    }

    protected VehicleEntity getParent(){
        if(parentent == null){
            if(this.isRiding()){
                parentent = (VehicleEntity)this.getRidingEntity();
            }
            return null;
        }
        return parentent;
    }
    
    @Override
    public TreeMap<String, ContainerHolder> getContainers(){
    	return containers;
    }

}
