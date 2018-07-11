package net.fexcraft.mod.fvtm.entities;

import java.util.TreeMap;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Container.ContainerEntity;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Fuel.FuelItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.MovementCalculationEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.PassengerHoldingEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
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

public abstract class RailboundVehicleEntity extends Entity implements VehicleEntity, IEntityAdditionalSpawnData, LockableObject, IPacketReceiver<PacketEntityUpdate> {

	protected VehicleData vehicledata;
	public VehicleAxes axes;
	protected VehicleAxes prevaxes;
	public BogieEntity[] bogies;
	public SeatEntity[] seats;
    protected TreeMap<String, ContainerEntity> containers;
    protected double throttle;
    public float prevRotationYaw, prevRotationPitch, prevRotationRoll;
    protected VehicleEntity front, rear;
    protected byte toggletimer;
    public EngineLoopSound engineloop;
    //
    protected boolean sync;
    protected Vec3d angvel = new Vec3d(0, 0, 0);
    public double serverPosX, serverPosY, serverPosZ;
    public double serverYaw, serverPitch, serverRoll;
    public int serverPositionTransitionTicker, consize = -1;
    
	
    public RailboundVehicleEntity(World worldIn){
        super(worldIn);
        axes = new VehicleAxes();
        prevaxes = new VehicleAxes();
        preventEntitySpawning = true;
        setSize(0.8f, 0.8f);
        ignoreFrustumCheck = true;
        stepHeight = 1.2f;
    }
    
    protected RailboundVehicleEntity(World world, VehicleData type){
        this(world);
        vehicledata = type;
    }

    /**
     * From Constructor (Item)
     */
    public RailboundVehicleEntity(World world, double x, double y, double z, EntityPlayer placer, VehicleData vehicleData){
        this(world, vehicleData);
        stepHeight = 1.0F;
        setPosition(x, y, z);
        rotateYaw(placer.rotationYaw + 90F);
        initVeh(vehicleData, false);
    }

    /**
     * From Constructor (Center)
     */
    public RailboundVehicleEntity(World world, double x, double y, double z, int placer, VehicleData data){
        this(world, data);
        stepHeight = 1.0F;
        setPosition(x, y, z);
        rotateYaw((placer * 90f) + 90F);
        initVeh(data, false);
        Print.debugChat("SPAWNING");
    }

    protected void initVeh(VehicleData type, boolean remote){
        seats = new SeatEntity[type.getSeats().size()];
        bogies = new BogieEntity[2];
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

	@Override
	public boolean isLocked(){
		return vehicledata.isLocked();
	}

	@Override
	public boolean unlock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = new NBTTagCompound();
        if(getEntityAtFront() != null){
            compound.setInteger("FrontEntityId", getEntityAtFront().getEntity().getEntityId());
        }
        if(getEntityAtRear() != null){
            compound.setInteger("RearEntityId", getEntityAtFront().getEntity().getEntityId());
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
    }

	@Override
	public VehicleData getVehicleData(){
		return vehicledata;
	}

	@Override
	public VehicleType getVehicleType(){
		return VehicleType.RAIL;
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
		return bogies;
	}

	@Override
	public PassengerHoldingEntity[] getSeats(){
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
            /*case 2: {//Left
                wheelsYaw -= 1F;
                return true;
            }
            case 3: {//Right
                wheelsYaw += 1F;
                return true;
            }*/
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
                    player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_INVENTORY, world, 0, 0, 0);
                }
                return true;
            }
            case 10: {
                if(!world.isRemote){
                    if(toggletimer <= 0){
                        vehicledata.toggleDoors(null);
                        if(this.getEntityAtFront() != null){
                        	
                        }
                        if(this.getEntityAtRear() != null){
                        	
                        }
                        player.sendMessage(new TextComponentString("Doors " + (vehicledata.doorsOpen() ? "opened" : "closed") + "."));
                        toggletimer = 10;
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
                    if(toggletimer <= 0){
                        int i = vehicledata.getLightsState();
                        vehicledata.setLightsState(++i > 3 ? 0 : i < 0 ? 0 : i);
                        if(this.getEntityAtFront() != null){
                        	
                        }
                        if(this.getEntityAtRear() != null){
                        	
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
                        toggletimer = 10;
                        NBTTagCompound nbt = new NBTTagCompound();
                        nbt.setString("task", "lights_toggle");
                        nbt.setInteger("lightsstate", vehicledata.getLightsState());
                        ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                    }
                }
                return true;
            }
        }
        return false;
	}

	@Override
	public Entity getCamera(){
		return null;
	}

	@Override
	public double getThrottle(){
		return throttle;
	}

	@Override
	public void setThrottle(double newthr){
		throttle = newthr;
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
        angvel = new Vec3d(avelx, avely, avelz);
        if(!(seats.length > 0 && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer)){
            this.throttle = throttle;
        }
        //
        //wheelsYaw = steeringYaw;
	}

	@Override
	public VehicleEntity getEntityAtFront(){
		return front;
	}

	@Override
	public VehicleEntity getEntityAtRear(){
		return rear;
	}

	@Override
	public Vec3d getAngularVelocity(){
		return angvel;
	}

	@Override
	public float getWheelsAngle(){
		return 0;
	}

	@Override
	public float getWheelsYaw(){
		return 0;
	}

	@Override
	public TreeMap<String, ContainerEntity> getContainers(){
		return containers;
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
        for(BogieEntity wheel : bogies){
            if(wheel != null){
                wheel.setDead();
            }
        }
        if(containers != null){
        	containers.values().forEach(con -> {
        		con.getEntity().setDead();
        	});
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
    public boolean canBeCollidedWith(){
        return true;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }
    
    @Override
    public void setVelocity(double x, double y, double z){
        motionX = x; motionY = y; motionZ = z;
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
            //TODO other item types
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
                double xx = x - posX; double yy = y - posY; double zz = z - posZ;
                double xxx = xx * xx + yy * yy + zz * zz;
                if(xxx <= 1.0D){
                    return;
                }
                serverPositionTransitionTicker = 3;
            }
            serverPosX = x; serverPosY = y; serverPosZ = z;
            serverYaw = yaw; serverPitch = pitch;
        }
    }
    
    public boolean isDrivenByPlayer(){
    	return seats[0] != null && SeatEntity.isPassengerThePlayer((SeatEntity)seats[0]);
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
                if(bogies[i] == null || !bogies[i].addedToChunk){
                	bogies[i] = new BogieEntity(world, this, i);
                    world.spawnEntity(bogies[i]);
                }
            }
            if(vehicledata.getVehicle().isTrailerOrWagon()){
            	//
            }
            if(containers != null && containers.size() < consize){
            	vehicledata.getParts().forEach((key, part) -> {
            		if(part.getAttributeData(ContainerAttributeData.class) != null){
            			ContainerAttributeData condata = part.getAttributeData(ContainerAttributeData.class);
            			GenericContainerEntity ent = null;
            			if(condata.getAttribute().getContainerType() == ContainerType.LARGE){
            				if(!containers.containsKey(key + "_0")){
            					containers.put(key + "_0", ent = new GenericContainerEntity(world, this, key, 0));
            					world.spawnEntity(ent);
            				}
            				if(!containers.containsKey(key + "_1")){
            					containers.put(key + "_1", ent = new GenericContainerEntity(world, this, key, 1));
            					world.spawnEntity(ent);
            				}
            				if(!containers.containsKey(key)){
            					containers.put(key, ent = new GenericContainerEntity(world, this, key, -1));
            					world.spawnEntity(ent);
            				}
            			}
            			else{
            				if(!containers.containsKey(key)){
            					containers.put(key, ent = new GenericContainerEntity(world, this, key, -1));
            					world.spawnEntity(ent);
            				}
            			}
            		}
            	});
            }
        }
        else{
            if(vehicledata.getVehicle().isTrailerOrWagon()){
            	//
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
        if(seats == null || (!vehicledata.getVehicle().isTrailerOrWagon() && seats.length == 0)){
            this.setDead();
            return;
        }
        if(toggletimer > 0){
        	toggletimer--;
        }
        //
        boolean drivenByPlayer = isDrivenByPlayer();
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
        for(BogieEntity wheel : bogies){
            if(wheel != null && world != null){
                wheel.prevPosX = wheel.posX;
                wheel.prevPosY = wheel.posY;
                wheel.prevPosZ = wheel.posZ;
            }
        }
        //TODO
        /*if(hasEnoughFuel()){ wheelsAngle += throttle * 0.2F; }*/
        //
        if((seats.length > 0 && seats[0] != null && seats[0].getControllingPassenger() == null) || !(isDriverInGM1() || vehicledata.getFuelTankContent() > 0) && vehicledata.getVehicle().getFMAttribute("max_positive_throttle") != 0){
            throttle *= 0.98F;
        }
        this.onUpdateMovement();
        //
        if(bogies[0] != null && bogies[1] != null){
            Vec3d front = bogies[1].getPositionVector();
            Vec3d back = bogies[0].getPositionVector();
            //Vec3d lr = new Vec3d((bogies[0].posX + bogies[1].posX) / 2F, (bogies[0].posY + bogies[1].posY) / 2F, (bogies[0].posZ + bogies[1].posZ) / 2F);
            //
            double dx = front.x - back.x, dy = front.y - back.y, dz = front.z - back.z;
            double dxz = Math.sqrt(dx * dx + dz * dz);
            //
            double yaw = Math.atan2(dz, dx);
            double pitch = -Math.atan2(dy, dxz);
            double roll = 0F;
            axes.setAngles(yaw * 180F / 3.14159F, pitch * 180F / 3.14159F, roll * 180F / 3.14159F);
        }
        //
        vehicledata.getScripts().forEach((script) -> script.onUpdate(this, vehicledata));
        //checkForCollisions();
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

    private boolean isDriverInGM1(){
    	return seats != null && seats.length > 0 && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer) seats[0].getControllingPassenger()).capabilities.isCreativeMode;
	}

	public abstract void onUpdateMovement();
    
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

}
