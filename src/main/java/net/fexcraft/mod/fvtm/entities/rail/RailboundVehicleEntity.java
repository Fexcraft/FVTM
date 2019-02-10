package net.fexcraft.mod.fvtm.entities.rail;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.api.KeyItem;
import net.fexcraft.lib.mc.api.LockableObject;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Fuel.FuelItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.MovementCalculationEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.PassengerHoldingEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.api.capability.ContainerHolder;
import net.fexcraft.mod.fvtm.api.capability.ContainerHolder.ContainerHolderEntity;
import net.fexcraft.mod.fvtm.api.capability.FVTMCaps;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.blocks.rail.JunctionBlock;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.impl.part.EngineLoopSound;
import net.fexcraft.mod.fvtm.sys.rail.Bogie;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailData;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailDataSerializer;
import net.fexcraft.mod.fvtm.util.FvtmPermissions;
import net.fexcraft.mod.fvtm.util.ItemStackHandler;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleControl;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleKeyPress;
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

@SuppressWarnings("deprecation")
public abstract class RailboundVehicleEntity extends Entity implements ContainerHolderEntity, VehicleEntity, IEntityAdditionalSpawnData, LockableObject, IPacketReceiver<PacketEntityUpdate> {

	protected VehicleData vehicledata;
	public VehicleAxes axes;
	protected VehicleAxes prevaxes;
	//public BogieEntity[] bogies;
	public SeatEntity[] seats;
    protected double throttle;
    public float prevRotationYaw, prevRotationPitch, prevRotationRoll;
    protected /*VehicleEntity*/ RailboundVehicleEntity front, rear;
    protected byte toggletimer;
    public EngineLoopSound engineloop;
    //
    protected boolean sync;
	public boolean reverse;
    protected Vec3d angvel = new Vec3d(0, 0, 0);
    public double serverPosX, serverPosY, serverPosZ;
    public double serverYaw, serverPitch, serverRoll;
    public int serverPositionTransitionTicker;
    //
    //public BlockPos lastpos, currentpos;
    //public BlockPos llp, lcp;
    public Track curr_track, last_track;
    public Track _curr_track, _last_track;
    public double passed;
    public Bogie _front, _rear;
    public double frontconndis, rearconndis;
	
    public RailboundVehicleEntity(World world){
        super(world);
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
    public RailboundVehicleEntity(World world, BlockPos pos, EntityPlayer placer, VehicleData vehicleData){
        this(world, vehicleData);
        stepHeight = 1.0F;
        setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        rotateYaw(placer.rotationYaw + 90F);
        initVeh(pos, vehicleData, false);
    }

    /**
     * From Constructor (Center)
     */
    public RailboundVehicleEntity(World world, BlockPos pos, int placer, VehicleData data){
        this(world, data);
        stepHeight = 1.0F;
        setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        rotateYaw((placer * 90f) + 90F);
        initVeh(pos, data, false);
        Print.debugChat("SPAWNING");
    }

	protected void initVeh(BlockPos pos, VehicleData type, boolean remote){
        seats = new SeatEntity[type.getSeats().size()];
        //bogies = new BogieEntity[2];
        stepHeight = type.getVehicle().getFMAttribute("wheel_step_height");
        this.frontconndis = vehicledata.getFrontConnectorPos().to16FloatX();
        this.rearconndis = vehicledata.getRearConnectorPos().to16FloatX();
        this.setupCapability(this.getCapability(FVTMCaps.CONTAINER, null));
        vehicledata.getScripts().forEach((script) -> script.onCreated(this, vehicledata));
        if(pos == null){
        	return;
        }
        if(world.getBlockState(pos).getBlock() == JunctionBlock.INSTANCE){
        	Print.debug("pre");
        	Junction junk = world.getCapability(WorldRailDataSerializer.CAPABILITY, null).getJunction(pos);
        	if(junk == null || junk.tracks.size() < 2){
            	this.errorRemove("Invalid Junction to place Entity on.");
        	}
        	else{
        		this.last_track = junk.tracks.get(0);
        		this.curr_track = junk.tracks.get(1);
        	}
        	Print.debug("past"); //TODO
        }
        else{
        	this.errorRemove("No Junction found.");
        }
    }
	
	private void errorRemove(String error){
		if(world == null || world.isRemote) return;
		Print.log("Removing RAIL Entity, ERROR: " + error);
    	this.entityDropItem(this.getVehicleData().getVehicle().getItemStack(this.getVehicleData()), 1);
    	this.setDead();
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
        if(compound.hasKey("LastTrack")){
        	last_track = new Track().read(compound.getCompoundTag("LastTrack"));
        }
        if(compound.hasKey("CurrentTrack")){
        	curr_track = new Track().read(compound.getCompoundTag("CurrentTrack"));
        }
        else{
        	errorRemove("No Track NBT Data on READ.");
        }
        throttle = compound.getDouble("Throttle");
        passed = compound.getDouble("Passed");
        reverse = compound.getBoolean("Reverse");
        initVeh(null, vehicledata, false);
        Print.debug(compound.toString());
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
        compound = vehicledata.writeToNBT(compound);
        axes.write(this, compound);
        if(last_track != null){
        	compound.setTag("LastTrack", last_track.write(null));
        }
        if(curr_track != null){
        	compound.setTag("CurrentTrack", curr_track.write(null));
        }
        compound.setDouble("Throttle", throttle);
        compound.setDouble("Passed", passed);
        compound.setBoolean("Reverse", reverse);
        Print.debug(compound.toString());
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = new NBTTagCompound();
        try{
            if(getEntityAtFront() != null){
                compound.setInteger("FrontEntityId", getEntityAtFront().getEntity().getEntityId());
            }
            if(getEntityAtRear() != null){
                compound.setInteger("RearEntityId", getEntityAtFront().getEntity().getEntityId());
            }
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        if(last_track != null){
        	compound.setTag("LastTrack", last_track.write(null));
        }
        if(curr_track != null){
        	compound.setTag("CurrentTrack", curr_track.write(null));
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
            initVeh(null, vehicledata, true);
            if(compound.hasKey("LastTrack")){
            	last_track = new Track().read(compound.getCompoundTag("LastTrack"));
            }
            if(compound.hasKey("CurrentTrack")){
            	curr_track = new Track().read(compound.getCompoundTag("CurrentTrack"));
            }
            else{
            	errorRemove("No Track NBT Data on SPAWN DATA READ.");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            Print.debug("Failed to receive additional spawn data for this vehicle!");
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
		return null;//bogies;
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
        if(world.isRemote && key != 5){
            PacketHandler.getInstance().sendToServer(new PacketVehicleKeyPress(key));
            return true;
        }
        switch(key){
            case 0: {//Accelerate;
            	if(toggletimer > 0){
            		return true;
            	} toggletimer = 4;
                throttle += 0.05F;
                if(throttle > 1F){
                    throttle = 1F;
                }
                return true;
            }
            case 1: {//Decelerate
            	if(toggletimer > 0){
            		return true;
            	} toggletimer = 4;
                throttle -= 0.05F;
                if(throttle < 0F){
                    throttle = 0F;
                }
                return true;
            }
            case 2: {//Left
                reverse = false;
                return true;
            }
            case 3: {//Right
                reverse = true;
                return true;
            }
            case 4: {//Brake
            	if(toggletimer > 0){
            		return true;
            	}
            	toggletimer = 4;
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
            case 13: case 14: {
            	if(!world.isRemote){
            		boolean front = key == 13;
            		if(throttle > 0.001 && !vehicledata.getVehicle().isTrailerOrWagon()){ Print.chat(player, "Please stop the vehicle first!"); return true; }
            		if(front ? this.vehicledata.getFrontConnectorPos() == null : this.vehicledata.getRearConnectorPos() == null){
            			Print.chat(player, "This vehicle does not have a " + (front ? "front" : "rear") + " connector installed.");
            			return true;
            		}
                    if(toggletimer <= 0){
                    	if(front){
                        	if(this.getEntityAtFront() == null){
                        		this.tryAttach(player, front);
                        	}
                        	else{
                        		this.tryDetach(player, front);
                        	}
                    	}
                    	else{
                        	if(this.getEntityAtRear() == null){
                        		this.tryAttach(player, front);
                        	}
                        	else{
                        		this.tryDetach(player, front);
                        	}
                    	}
                    	toggletimer = 10;
                    }
            	}
            	return true;
            }
        }
        return false;
	}

	@Override
	public AxisAlignedBB getFrontConnectorAABB(){
		if(this.vehicledata.getFrontConnectorPos() == null) return null;
		Vec3d vec = this.getPositionVector().add(axes.getRelativeVector(vehicledata.getFrontConnectorPos().to16Double()));
		return new AxisAlignedBB(vec.x - 0.5, vec.y - 0.5, vec.z - 0.5, vec.x + 0.5, vec.y + 0.5, vec.z + 0.5);
	}

	@Override
	public AxisAlignedBB getRearConnectorAABB(){
		if(this.vehicledata.getRearConnectorPos() == null) return null;
		Vec3d vec = this.getPositionVector().add(axes.getRelativeVector(vehicledata.getRearConnectorPos().to16Double()));
		return new AxisAlignedBB(vec.x - 0.5, vec.y - 0.5, vec.z - 0.5, vec.x + 0.5, vec.y + 0.5, vec.z + 0.5);
	}

    private void tryAttach(EntityPlayer player, boolean front){
    	if(front ? this.getEntityAtFront() != null : this.getEntityAtRear() != null){
			Print.chat(player, (front ? "Front" : "Rear") + " already Connected."); return;
    	}
    	AxisAlignedBB aabb = front ? this.getFrontConnectorAABB() : this.getRearConnectorAABB();
    	if(aabb == null){
			Print.chat(player, "No " + (front ? "front" : "rear") + " connector."); return;
    	}
    	RailboundVehicleEntity ent = null; Boolean rear = null;
    	for(Entity e : world.loadedEntityList){
    		if(e instanceof VehicleEntity && !e.equals(this)){ ent = (RailboundVehicleEntity)e;
    			if(ent.getVehicleData().getVehicle().getType().isRailVehicle()){
    				if(ent.getRearConnectorAABB().intersects(aabb)){
    					if(ent.getEntityAtRear() == null){ rear = true; break; }
    					else{
    						Print.chat(player, "&8Issue found.");
    						Print.chat(player, (front ? "Front" : "Rear") + " connector intersects with " + ent.toString());
    						Print.chat(player, "But the other's entity REAR connector is already connected to something.");
    						ent = null; break;
    					}
    				}
    				else if(ent.getFrontConnectorAABB().intersects(aabb)){
    					if(ent.getEntityAtFront() == null){ rear = false; break; }
    					else{
    						Print.chat(player, "&8Issue found.");
    						Print.chat(player, (front ? "Front" : "Rear") + " connector intersects with " + ent.toString());
    						Print.chat(player, "But the other's entity FRONT connector is already connected to something.");
    						ent = null; break;
    					}
    				}
    				else continue;
    			}
    		}
    	}
    	if(ent == null){
    		Print.chat(player, "No entity found at " + (front ? "FRONT" : "REAR") + " connector."); return;
    	} if(rear == null){ Print.chat(player, "ERROR! Connector direction of other entity not detected."); return; }
    	//
    	try{
    		Print.chat(player, "Connecting to " + ent.getName());
    		if(rear) ent.rear = this; else ent.front = this;
    		if(front) this.front = ent; else this.rear = ent;
    		//
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setString("task", "update_connection_" + (rear ? "rear" : "front"));
            nbt.setInteger("entity", this.getEntityId());
            ApiUtil.sendEntityUpdatePacketToAllAround(ent.getEntity(), nbt);
            //
            nbt = new NBTTagCompound();
            nbt.setString("task", "update_connection_" + (front ? "front" : "rear"));
            nbt.setInteger("entity", ent.getEntity().getEntityId());
            ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
    		Print.chat(player, "Connected!");
    	}
    	catch(Exception e){
    		Print.debug("ERROR! See console/log for info.");
    		e.printStackTrace();
    	}
	}

	private void tryDetach(EntityPlayer player, boolean front){
		if((front ? this.getEntityAtFront() : this.getEntityAtRear()) == null){
			Print.chat(player, "No entity connected at " + (front ? "front" : "rear") + "!");
			return;
		}
		VehicleEntity veh = front ? this.getEntityAtFront() : this.getEntityAtRear();
		veh.getEntity().dismountRidingEntity(); Boolean rear = null;
		if(veh instanceof RailboundVehicleEntity){
			RailboundVehicleEntity reil = (RailboundVehicleEntity)veh;
            if(reil.rear != null && reil.rear.equals(this)){ reil.rear = null; rear = true; }
            if(reil.front != null && reil.front.equals(this)){ reil.front = null; rear = false; }
		}
		if(front) this.front = null; else this.rear = null;
		Print.chat(player, "Detaching " + veh.getEntity().getName());
		//
		NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("task", "update_connection_" + (front ? "front" : "rear"));
        nbt.setInteger("entity", -1);
        ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
        //
        if(rear != null){
            nbt = new NBTTagCompound();
            nbt.setString("task", "update_connection_" + (rear ? "rear" : "front"));
            nbt.setInteger("entity", -1);
            ApiUtil.sendEntityUpdatePacketToAllAround(veh.getEntity(), nbt);
        }
		Print.chat(player, "Detached.");
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
        this.throttle = throttle;
        //
        //wheelsYaw = steeringYaw;
        this.updateRotation();
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
        this.getCapability(FVTMCaps.CONTAINER, null).dropContents();
        //
        super.setDead();
        for(SeatEntity seat : seats){
            if(seat != null){
                seat.setDead();
            }
        }
        /*for(BogieEntity wheel : bogies){
            if(wheel != null){
                wheel.setDead();
            }
        }*/
        vehicledata.getScripts().forEach((script) -> script.onRemove(this, vehicledata));
        if(this.getEntityAtRear() != null){
            this.getEntityAtRear().getEntity().dismountRidingEntity();
            RailboundVehicleEntity rear = (RailboundVehicleEntity)this.getEntityAtRear();
            if(rear.rear.equals(this)) rear.rear = null;
            if(rear.front.equals(this)) rear.front = null;
        }
        if(this.getEntityAtFront() != null){
            this.getEntityAtFront().getEntity().dismountRidingEntity();
            RailboundVehicleEntity front = (RailboundVehicleEntity)this.getEntityAtFront();
            if(front.rear.equals(this)) front.rear = null;
            if(front.front.equals(this)) front.front = null;
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
            else if(stack.getItem() instanceof VehicleItem){
            	VehicleData data = ((VehicleItem)stack.getItem()).getVehicle(stack);
            	if(data.getVehicle().getType().isRailVehicle()){
            		//TODO add check if locomotive?
            		//this.tryAttach(player, stack, data);
            	}
            	else{
            		Print.chat(player, "&cNot a rail vehicle.");
            		return true;
            	}
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
        /*if(this.getControllingPassenger() != null && this.getControllingPassenger() instanceof EntityPlayer){
            //
        }
        else{*/
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
        /*}*/
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
            /*for(int i = 0; i < vehicledata.getWheelPos().size(); i++){
                if(bogies[i] == null || !bogies[i].addedToChunk){
                	bogies[i] = new BogieEntity(world, this, i, firstpos);
                    world.spawnEntity(bogies[i]);
                }
            }*/
            if(vehicledata.getVehicle().isTrailerOrWagon()){
            	//
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
        if(this.ticksExisted >= Integer.MAX_VALUE){
            this.ticksExisted = 0;
        }
        //
        if(seats == null || (!vehicledata.getVehicle().isTrailerOrWagon() && seats.length == 0)){
            this.setDead();
            return;
        }
        if(toggletimer > 0){ toggletimer--; }
        //
        if(world.isRemote){
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
        //TODO if(hasEnoughFuel()){ wheelsAngle += throttle * 0.2F; }
        //
        if((Config.VEHICLE_NEEDS_FUEL && vehicledata.getFuelTankContent() <= 0) || vehicledata.getVehicle().getFMAttribute("max_positive_throttle") <= 0){
            throttle *= 0.98F;
        }
        if(!world.isRemote){
        	this.onUpdateMovement(0f, false, null);
        	this.updateRotation();
        	//
            if(_last_track == null || _curr_track == null){ _last_track = last_track; _curr_track = curr_track; }
        	if(!_last_track.equals(last_track) || !_curr_track.equals(curr_track)){
        		NBTTagCompound compound = new NBTTagCompound();
        		compound.setString("task", "direction_update");
                compound.setTag("LastTrack", last_track.write(null));
                compound.setTag("CurrentTrack", curr_track.write(null));
        		compound.setDouble("passed", passed);
        		compound.setBoolean("reverse", reverse);
        		ApiUtil.sendEntityUpdatePacketToAllAround(this, compound);
        	}
        }
        //
        vehicledata.getScripts().forEach((script) -> script.onUpdate(this, vehicledata));
        //this.updateCollisions();
        for(SeatEntity seat : seats){
            if(seat != null){
                seat.updatePosition();
            }
        }
        if(!world.isRemote && ticksExisted % 5 == 0){
            PacketHandler.getInstance().sendToAllAround(new PacketVehicleControl(this), Resources.getTargetPoint(this));
        }
    }

	//temp
    //public double[] _front, _back;
	
	private void updateRotation(){
		return;
        /*Vec3d thiz = this.getPositionVector();
        _front = RailUtil.move(this.getWorldData(), thiz, currentpos, lastpos, vehicledata.getWheelPos().get(1).to16FloatX()).dest;
        _back = RailUtil.move(this.getWorldData(), thiz, currentpos, lastpos, vehicledata.getWheelPos().get(0).to16FloatX()).dest;
        if(_front != null && _back != null){
        	//if(reverse){ double[] copy = _front; _front = _back; _back = copy; }
            double dx = _front[0] - _back[0], dy = _front[1] - _back[1], dz = _front[2] - _back[2];
            double dxz = Math.sqrt(dx * dx + dz * dz);
            //
            double yaw = Math.atan2(dz, dx);
            double pitch = -Math.atan2(dy, dxz);
            double roll = 0F;
            axes.setAngles(yaw * 180F / 3.14159F, pitch * 180F / 3.14159F, roll * 180F / 3.14159F);
            //
            /*double[] fr0 = RailUtil.move(world, thiz, currentpos, lastpos, vehicledata.getWheelPos().get(1).to16FloatX() - 0.125).dest;
            double[] fr1 = RailUtil.move(world, thiz, currentpos, lastpos, vehicledata.getWheelPos().get(1).to16FloatX() + 0.125).dest;
            double[] bk0 = RailUtil.move(world, thiz, currentpos, lastpos, vehicledata.getWheelPos().get(0).to16FloatX() - 0.125).dest;
            double[] bk1 = RailUtil.move(world, thiz, currentpos, lastpos, vehicledata.getWheelPos().get(0).to16FloatX() + 0.125).dest;
            bogierot[0] = -(float)(Math.toDegrees(Math.atan2(fr0[2] - fr1[2], fr0[0] - fr1[0]) + axes.getRadianYaw()));
            bogierot[1] = -(float)(Math.toDegrees(Math.atan2(bk0[2] - bk1[2], bk0[0] - bk1[0]) + axes.getRadianYaw()));*/
            //TODO
            /*if(oldf != null && _front != null){
            	bogierot[0] = (float)Math.toDegrees(Math.atan2(oldf[2] - _front[2], oldf[0] - _front[0]));
            }
            if(oldb != null &&  _back != null){
            	bogierot[1] = (float)Math.toDegrees(Math.atan2(oldb[2] -  _back[2], oldb[0] -  _back[0]));
            }*/
        //}
	}

	/*private double[] calcBogiePos(int i, Vec3d own){
		return getNextBogiePos(vehicledata.getWheelPos().get(i).to16FloatX(), own, i == 1 ? currentpos : lastpos, i == 0 ? currentpos : lastpos);
	}
	
	public double[] getNextBogiePos(double dis, Vec3d core, BlockPos curr, BlockPos last){
		dis = Math.abs(dis); double[] dest = Vector3D.newVector(curr), own = Vector3D.newVector(core.x, core.y, core.z);
		while(Double.compare(dis, Vector3D.distance(own, dest)) >= 0){
			dis -= Vector3D.distance(own, dest);
			if(dis <= 0.001){ break; }
			else{
				BlockPos las = world.getCapability(net.fexcraft.mod.fvtm.api.Resources.CAPABILITY, null).getNextRailCoordinate(curr, last);
				if(las == null){ break; }
				if(curr.equals(las)){ break; }
				last = curr; curr = las; own = Vector3D.newVector(last); dest = Vector3D.newVector(curr);
			}
		}
    	dest = Vector3D.direction(dest[0] - own[0], dest[1] - own[1], dest[2] - own[2]);
		return Vector3D.newVector(own[0] + (dest[0] * dis), own[1] + (dest[1] * dis), own[2] + (dest[2] * dis));
	}*/
	
	private float[] bogierot = new float[]{ 0, 0 };

	@Override
	public float[] getBogieYaw(){
		return bogierot;
	}
	
	/**
	 * @param amount amount to move
	 * @param call if from another (connected) entity
	 * @param front direction call is from
	 */
	public abstract void onUpdateMovement(double amount, boolean call, Boolean front);
    
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
                case "direction_update":{
                	last_track = new Track().read(pkt.nbt.getCompoundTag("LastTrack"));
                	curr_track = new Track().read(pkt.nbt.getCompoundTag("CurrentTrack"));
                	passed = pkt.nbt.getDouble("passed");
                	reverse = pkt.nbt.getBoolean("reverse");
                	//Print.debug("PACKET CL RC", currentpos, lastpos);
                	break;
                }
                case "update_connection_front":{
                	this.front = pkt.nbt.getInteger("entity") < 0 ? null : (RailboundVehicleEntity)world.getEntityByID(pkt.nbt.getInteger("entity")); break;
                }
                case "update_connection_rear":{
                	this.rear = pkt.nbt.getInteger("entity") < 0 ? null : (RailboundVehicleEntity)world.getEntityByID(pkt.nbt.getInteger("entity")); break;
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
	
	protected WorldRailData getWorldData(){
		return world.getCapability(WorldRailDataSerializer.CAPABILITY, null);
	}

	@Override
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
	}

	@Override
	public float[] getEntityRotationForContainer(){
		return new float[]{ (float)axes.getRadianYaw(), (float)axes.getRadianPitch(), (float)axes.getRadianRoll() };
	}

}