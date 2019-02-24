package net.fexcraft.mod.fvtm.entities.rail;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
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
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.impl.part.EngineLoopSound;
import net.fexcraft.mod.fvtm.sys.rail.MoveUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
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

	protected VehicleData cl_vehdata;
	public VehicleAxes axes;
	protected VehicleAxes prevaxes;
	public SeatEntity[] seats;
    //protected double throttle;
    public float prevRotationYaw, prevRotationPitch, prevRotationRoll;
    //protected RailboundVehicleEntity front, rear;
    protected byte toggletimer;
    public EngineLoopSound engineloop;
    //
    //protected boolean sync;
	//public boolean reverse;
    protected Vec3d angvel = new Vec3d(0, 0, 0);
    //public double serverPosX, serverPosY, serverPosZ;
    //public Double actualPosX, actualPosY, actualPosZ;
    //public double serverYaw, serverPitch, serverRoll;
    public double serverPass;
    public int serverPositionTransitionTicker;
    //
    //CLIENT
    public Track CL_CT, CL_LT, LL_CT, LL_LT;
    public double frontconndis, rearconndis;
    public double frontbogiedis, rearbogiedis;
    public boolean cl_reverse, removal;
    public double cl_passed, dl_throttle;
    //
    //SERVER
    public RailEntity railent;
	
    public RailboundVehicleEntity(World world){
        super(world);
        axes = new VehicleAxes();
        prevaxes = new VehicleAxes();
        preventEntitySpawning = true;
        setSize(0.8f, 0.8f);
        ignoreFrustumCheck = true;
    }
    
    public RailboundVehicleEntity(World world, RailEntity railent){
    	this(world); this.stepHeight = 1f; this.railent = railent;
    	railent.align(this); initVeh(railent.vehdata);
    }

	protected void initVeh(VehicleData type){
        seats = new SeatEntity[type.getSeats().size()];
        stepHeight = type.getVehicle().getFMAttribute("wheel_step_height");
        this.frontconndis = type.getFrontConnectorPos().to16FloatX();
        this.rearconndis = type.getRearConnectorPos().to16FloatX();
        this.frontbogiedis = type.getWheelPos().get(0).to16FloatX();
        this.rearbogiedis = type.getWheelPos().get(1).to16FloatX();
        this.setupCapability(this.getCapability(FVTMCaps.CONTAINER, null));
        type.getScripts().forEach((script) -> script.onCreated(this, type));
    }
	
	private void errorRemove(String error){
		if(world == null || world.isRemote) return;
		Print.log("Removing RAIL Entity, ERROR: " + error);
    	this.entityDropItem(this.getVehicleData().getVehicle().getItemStack(this.getVehicleData()), 1);
    	this.setDead();
	}

	@Override
    protected void readEntityFromNBT(NBTTagCompound compound){
		if(!world.isRemote){ this.removal = true; this.setDead(); return; }
        //
        if(cl_vehdata == null){
        	cl_vehdata = Resources.getVehicleData(compound);
        }
        else{
        	cl_vehdata.readFromNBT(compound);
        }
        prevRotationYaw = compound.getFloat("RotationYaw");
        prevRotationPitch = compound.getFloat("RotationPitch");
        prevRotationRoll = compound.getFloat("RotationRoll");
        axes = VehicleAxes.read(this, compound);
        if(compound.hasKey("LastTrack")){
        	CL_LT = new Track().read(compound.getCompoundTag("LastTrack"));
        }
        if(compound.hasKey("CurrentTrack")){
        	CL_CT = new Track().read(compound.getCompoundTag("CurrentTrack"));
        }
        else{
        	errorRemove("No Track NBT Data on READ.");
        }
        //throttle = compound.getDouble("Throttle");
        cl_passed = compound.getDouble("Passed");
        cl_reverse = compound.getBoolean("Reverse");
        initVeh(cl_vehdata); Print.debug(compound.toString());
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
        compound = vehdata().writeToNBT(compound);
        axes.write(this, compound);
        if(railent.last != null){
        	compound.setTag("LastTrack", railent.last.write(null));
        }
        if(railent.current != null){
        	compound.setTag("CurrentTrack", railent.current.write(null));
        }
        //compound.setDouble("Throttle", throttle);
        compound.setDouble("Passed", railent.passed);
        compound.setBoolean("Reverse", railent.reverse);
        Print.debug(compound.toString());
    }

    private VehicleData vehdata(){
		return world.isRemote || railent == null ? cl_vehdata : railent.vehdata;
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
        if(railent.last != null){
        	compound.setTag("LastTrack", railent.last.write(null));
        }
        if(railent.current != null){
        	compound.setTag("CurrentTrack", railent.current.write(null));
        }
        ByteBufUtils.writeTag(buffer, axes.write(this, railent.vehdata.writeToNBT(compound)));
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
        try{
            NBTTagCompound compound = ByteBufUtils.readTag(buffer);
            cl_vehdata = Resources.getVehicleData(compound);
            axes = VehicleAxes.read(this, compound);
            prevRotationYaw = axes.getYaw();
            prevRotationPitch = axes.getPitch();
            prevRotationRoll = axes.getRoll();
            initVeh(cl_vehdata);
            if(compound.hasKey("LastTrack")){
            	CL_LT = new Track().read(compound.getCompoundTag("LastTrack"));
            }
            if(compound.hasKey("CurrentTrack")){
            	CL_CT = new Track().read(compound.getCompoundTag("CurrentTrack"));
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
		return vehdata().isLocked();
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
		return vehdata();
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
            	railent.modifyThrottle( 0.05, false);
                return true;
            }
            case 1: {//Decelerate
            	if(toggletimer > 0){
            		return true;
            	} toggletimer = 4;
            	railent.modifyThrottle(-0.05, false);
                return true;
            }
            case 2: {//Left
                //reverse = false;
                return true;
            }
            case 3: {//Right
                //reverse = true;
                return true;
            }
            case 4: {//Brake
            	if(toggletimer > 0){
            		return true;
            	}
            	toggletimer = 4;
            	railent.breakThrottle();
                if(onGround){
                    motionX *= 0.8F;
                    motionZ *= 0.8F;
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
                        railent.vehdata.toggleDoors(null);
                        if(this.getEntityAtFront() != null){
                        	
                        }
                        if(this.getEntityAtRear() != null){
                        	
                        }
                        player.sendMessage(new TextComponentString("Doors " + (railent.vehdata.doorsOpen() ? "opened" : "closed") + "."));
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
                        int i = railent.vehdata.getLightsState();
                        railent.vehdata.setLightsState(++i > 3 ? 0 : i < 0 ? 0 : i);
                        if(this.getEntityAtFront() != null){
                        	
                        }
                        if(this.getEntityAtRear() != null){
                        	
                        }
                        switch(railent.vehdata.getLightsState()){
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
                        nbt.setInteger("lightsstate", railent.vehdata.getLightsState());
                        ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                    }
                }
                return true;
            }
            case 13: case 14: {
            	if(!world.isRemote){
            		boolean front = key == 13;
            		if(railent.getThrottle() > 0.001 && !railent.vehdata.getVehicle().isTrailerOrWagon()){ Print.chat(player, "Please stop the vehicle first!"); return true; }
            		if(front ? railent.vehdata.getFrontConnectorPos() == null : railent.vehdata.getRearConnectorPos() == null){
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
		if(vehdata().getFrontConnectorPos() == null) return null;
		Vec3d vec = this.getPositionVector().add(axes.getRelativeVector(vehdata().getFrontConnectorPos().to16Double()));
		return new AxisAlignedBB(vec.x - 0.5, vec.y - 0.5, vec.z - 0.5, vec.x + 0.5, vec.y + 0.5, vec.z + 0.5);
	}

	@Override
	public AxisAlignedBB getRearConnectorAABB(){
		if(vehdata().getRearConnectorPos() == null) return null;
		Vec3d vec = this.getPositionVector().add(axes.getRelativeVector(vehdata().getRearConnectorPos().to16Double()));
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
    		//TODO if(rear) ent.rear = this; else ent.front = this;
    		//TODO if(front) this.front = ent; else this.rear = ent;
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

	@SuppressWarnings("unused")
	private void tryDetach(EntityPlayer player, boolean front){
		if((front ? this.getEntityAtFront() : this.getEntityAtRear()) == null){
			Print.chat(player, "No entity connected at " + (front ? "front" : "rear") + "!");
			return;
		}
		VehicleEntity veh = front ? this.getEntityAtFront() : this.getEntityAtRear();
		veh.getEntity().dismountRidingEntity(); Boolean rear = null;
		if(veh instanceof RailboundVehicleEntity){
			RailboundVehicleEntity reil = (RailboundVehicleEntity)veh;
            //TODO if(reil.rear != null && reil.rear.equals(this)){ reil.rear = null; rear = true; }
            //TODO if(reil.front != null && reil.front.equals(this)){ reil.front = null; rear = false; }
		}
		//TODO if(front) this.front = null; else this.rear = null;
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
		return world.isRemote ? dl_throttle : railent.getThrottle();
	}

	@Override
	public void setThrottle(double newthr){
		if(!world.isRemote) railent.modifyThrottle(newthr, true);
	}

	@Override
	public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, double avelx, double avely, double avelz, double throttle, float steeringYaw){
        if(world.isRemote){
        	serverPass = posX;
            serverPositionTransitionTicker = 5;
            //
            dl_throttle = throttle;
        }
        else{
            setPosition(posX, posY, posZ);
            prevRotationYaw = yaw;
            prevRotationPitch = pitch;
            prevRotationRoll = roll;
            setRotation(yaw, pitch, roll);
            railent.modifyThrottle(throttle, true);
        }
        motionX = motX;
        motionY = motY;
        motionZ = motZ;
        angvel = new Vec3d(avelx, avely, avelz);
        this.updateRotation();
	}

	@Override
	public VehicleEntity getEntityAtFront(){
		return null;//TODO
	}

	@Override
	public VehicleEntity getEntityAtRear(){
		return null;//TODO
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
        if(Config.DROP_ITEMS_ON_BREAK && !world.isRemote && !removal){
            for(Part.PartData partData : railent.vehdata.getInventoryContainers()){
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
        if(!removal) this.getCapability(FVTMCaps.CONTAINER, null).dropContents();
        //
        super.setDead();
        for(SeatEntity seat : seats) if(seat != null) seat.setDead();
        //
        vehdata().getScripts().forEach((script) -> script.onRemove(this, vehdata()));
        /*if(this.getEntityAtRear() != null){
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
        }*///TODO
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
        if(railent.vehdata.isLocked()){
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
        if(!railent.vehdata.getScripts().isEmpty()){
            for(VehicleScript script : railent.vehdata.getScripts()){
                if(script.onInteract(this, railent.vehdata, player, hand)){
                    return true;
                }
            }
        }
        for(int i = 0; i <= railent.vehdata.getSeats().size(); i++){
            if(seats[i] != null && seats[i].processInitialInteract(player, hand)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isDrivenByPlayer(){
    	return seats[0] != null && SeatEntity.isPassengerThePlayer((SeatEntity)seats[0]);
    }
    
    @Override
    public void onUpdate(){
        super.onUpdate();
        if(vehdata() == null){
            Print.log("VehicleData is NULL; Not ticking vehicle.");
            Static.stop(); return;
        }
        if(!world.isRemote){
            for(int i = 0; i < railent.vehdata.getSeats().size(); i++){
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
            if(railent.vehdata.getVehicle().isTrailerOrWagon()){
            	//
            }
        }
        else{
            if(cl_vehdata.getVehicle().isTrailerOrWagon()){
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
        if(seats == null || (!vehdata().getVehicle().isTrailerOrWagon() && seats.length == 0)){
            this.setDead();
            return;
        }
        if(toggletimer > 0){ toggletimer--; }
        //
        if(world.isRemote){
            if(serverPositionTransitionTicker > 0){
            	double toPass = serverPass / 5;
            	MoveUtil.ObjCon<Track, Double, Vec3f> ret = MoveUtil.travelDistance(world.getCapability(WorldRailDataSerializer.CAPABILITY, null),
            		new MoveUtil.ObjCon<Track, Double, Double>(CL_CT, cl_passed, toPass));
            	CL_LT = CL_CT; CL_CT = ret.fir; cl_passed = ret.sec;
            	this.setPosition(ret.tir.xCoord, ret.tir.xCoord, ret.tir.zCoord);
                --serverPositionTransitionTicker;
            }
        }
        //TODO if(hasEnoughFuel()){ wheelsAngle += throttle * 0.2F; }
        //
        if((Config.VEHICLE_NEEDS_FUEL && vehdata().getFuelTankContent() <= 0) || vehdata().getVehicle().getFMAttribute("max_positive_throttle") <= 0){
            if(world.isRemote) dl_throttle *= 0.98F; else railent.modifyThrottle(railent.getThrottle() *- 0.98f, true);
        }
        if(!world.isRemote){
        	railent.align(this); this.updateRotation();
        	//
            if(LL_LT == null || LL_CT == null){ LL_LT = railent.last; LL_CT = railent.current; }
        	if(!LL_LT.equals(railent.last) || !LL_CT.equals(railent.current)){
        		NBTTagCompound compound = new NBTTagCompound();
        		compound.setString("task", "direction_update");
                compound.setTag("LastTrack", railent.last.write(null));
                compound.setTag("CurrentTrack", railent.current.write(null));
        		compound.setDouble("passed", railent.passed);
        		compound.setBoolean("reverse", railent.reverse);
        		ApiUtil.sendEntityUpdatePacketToAllAround(this, compound);
        	}
        } else{ this.updateRotation(); }
        //
        vehdata().getScripts().forEach((script) -> script.onUpdate(this, vehdata()));
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
    
    //tempdata
    private Vec3f qfront, qback, bf0, bf1, br0, br1;
	
	private void updateRotation(){
		double passed = world.isRemote ? cl_passed : railent.passed; Track curr = world.isRemote ? CL_CT : railent.current;
		if(curr == null){ Print.debug("No Track Data."); return; }
		WorldRailData raildata = this.world.getCapability(WorldRailDataSerializer.CAPABILITY, null);
		qfront = MoveUtil.travelDistance(raildata, new MoveUtil.ObjCon<Track, Double, Double>(curr, passed, frontbogiedis)).tir;
		qback = MoveUtil.travelDistance(raildata, new MoveUtil.ObjCon<Track, Double, Double>(curr, passed, rearbogiedis)).tir;
        double dx = qfront.xCoord - qback.xCoord, dy = qfront.yCoord - qback.yCoord, dz = qfront.zCoord - qback.zCoord;
        double dxz = Math.sqrt(dx * dx + dz * dz);
        double yaw = Math.atan2(dz, dx);
        double pitch = -Math.atan2(dy, dxz);
        double roll = 0F;
        axes.setAngles(yaw * 180F / 3.14159F, pitch * 180F / 3.14159F, roll * 180F / 3.14159F);
        this.posX = this.prevPosX = (qfront.xCoord + qback.xCoord) * 0.5;
        this.posY = this.prevPosY = (qfront.yCoord + qback.yCoord) * 0.5;
        this.posZ = this.prevPosZ = (qfront.zCoord + qback.zCoord) * 0.5;
        if(!world.isRemote) return;
        //
		bf0 = MoveUtil.travelDistance(raildata, new MoveUtil.ObjCon<Track, Double, Double>(curr, passed, frontbogiedis - 0.1)).tir;
		bf1 = MoveUtil.travelDistance(raildata, new MoveUtil.ObjCon<Track, Double, Double>(curr, passed, frontbogiedis + 0.1)).tir;
		br0 = MoveUtil.travelDistance(raildata, new MoveUtil.ObjCon<Track, Double, Double>(curr, passed, rearbogiedis - 0.1)).tir;
		br1 = MoveUtil.travelDistance(raildata, new MoveUtil.ObjCon<Track, Double, Double>(curr, passed, rearbogiedis + 0.1)).tir;
		bogierot[0] = (float)(Math.toDegrees(Math.atan2(bf0.zCoord - bf1.zCoord, bf0.xCoord - bf1.xCoord)) - (yaw * 180F / 3.14159F));
		bogierot[1] = (float)(Math.toDegrees(Math.atan2(br0.zCoord - br1.zCoord, br0.xCoord - br1.xCoord)) - (yaw * 180F / 3.14159F));
	}
	
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
            if(railent.vehdata.isLocked()){
                Print.chat(damagesource.getImmediateSource(), "Vehicle is locked. Unlock to remove it.");
                return false;
            }
            else{
                if(railent.vehdata.getPart("engine") != null){
                    railent.vehdata.getPart("engine").getAttributeData(EngineAttributeData.class).setOn(false);
                }
                railent.vehdata.getScripts().forEach((script) -> script.onRemove(this, railent.vehdata));
                ItemStack stack = railent.vehdata.getVehicle().getItemStack(railent.vehdata);
                //
                if(PermissionAPI.hasPermission((EntityPlayer)damagesource.getImmediateSource(), FvtmPermissions.VEHICLE_BREAK)
                	|| PermissionAPI.hasPermission((EntityPlayer)damagesource.getImmediateSource(), FvtmPermissions.permBreak(stack))){
                    entityDropItem(stack, 0.5F);
                    setDead(); railent.removeSelf();
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
        ItemStack stack = vehdata().getVehicle().getItemStack(vehdata());
        stack.setItemDamage(0);
        return stack;
    }

    @Override
    public String getName(){
        return vehdata().getVehicle().getName();
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
            for(VehicleScript script : railent.vehdata.getScripts()){
                if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, railent.vehdata, pkt.nbt, Side.SERVER);
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
                    pkt.nbt.setBoolean("engine_toggle_result", on = railent.vehdata.getPart("engine").getAttributeData(EngineAttributeData.class).toggle());
                    if(railent.vehdata.getFuelTankContent() == 0 || railent.vehdata.getFuelTankContent() < 0.1){
                        pkt.nbt.setBoolean("engine_toggle_result", on = false);
                        pkt.nbt.setBoolean("no_fuel", nf = true);
                    }
                    ApiUtil.sendEntityUpdatePacketToAllAround(this, pkt.nbt);
                    railent.modifyThrottle(0, true);
                    //
                    SoundEvent event = railent.vehdata.getPart("engine").getPart().getSound(nf ? "engine_fail" : on ? "engine_start" : "engine_stop");
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
                    NBTTagCompound nbt = this.railent.vehdata.writeToNBT(new NBTTagCompound());
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
            for(VehicleScript script : cl_vehdata.getScripts()){
                if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
                    script.onDataPacket(this, cl_vehdata, pkt.nbt, Side.SERVER);
                }
            }
        }
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "engine_toggle": {
                    if(net.minecraft.client.Minecraft.getMinecraft().player.isRiding() && this.seats[0] == net.minecraft.client.Minecraft.getMinecraft().player.getRidingEntity()){
                        Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Engine toggled " + (cl_vehdata.getPart("engine").getAttributeData(EngineAttributeData.class).setOn(pkt.nbt.getBoolean("engine_toggle_result")) ? "on" : "off") + ".");
                        if(pkt.nbt.hasKey("no_fuel") && pkt.nbt.getBoolean("no_fuel")){
                            Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Out of fuel!");
                        }
                    }
                    dl_throttle = 0;
                    if(cl_vehdata.getPart("engine").getAttributeData(EngineAttributeData.class).isOn() && this.engineloop == null){
                        SoundEvent event = cl_vehdata.getPart("engine").getPart().getSound("engine_running");
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
                    this.cl_vehdata.readFromNBT(pkt.nbt);
                    break;
                }
                case "lights_toggle": {
                    this.cl_vehdata.setLightsState(pkt.nbt.getInteger("lightsstate"));
                    if(this.getEntityAtRear() != null){
                        this.getEntityAtRear().getVehicleData().setLightsState(pkt.nbt.getInteger("lightsstate"));
                    }
                    break;
                }
                case "direction_update":{
                	CL_LT = new Track().read(pkt.nbt.getCompoundTag("LastTrack"));
                	CL_CT = new Track().read(pkt.nbt.getCompoundTag("CurrentTrack"));
                	cl_passed = pkt.nbt.getDouble("passed");
                	cl_reverse = pkt.nbt.getBoolean("reverse");
                	//Print.debug("PACKET CL RC", currentpos, lastpos);
                	break;
                }
                case "update_connection_front":{
                	//this.front = pkt.nbt.getInteger("entity") < 0 ? null : (RailboundVehicleEntity)world.getEntityByID(pkt.nbt.getInteger("entity")); break;
                }
                case "update_connection_rear":{
                	//this.rear = pkt.nbt.getInteger("entity") < 0 ? null : (RailboundVehicleEntity)world.getEntityByID(pkt.nbt.getInteger("entity")); break;
                }
            }
        }
    }

    // --- CAPABILITIES --- //
    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            if(facing.getAxis().isVertical() && !this.isLocked() && seats != null && seats[0] != null && seats[0].getControllingPassenger() == null){
                return !vehdata().getInventoryContainers().isEmpty() && vehdata().getInventoryContainers().get(0).getPart().getAttribute(InventoryAttribute.class).getType() == InventoryType.ITEM;
            }
            return false;
        }
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
            if(facing.getAxis().isVertical() && !this.isLocked() && seats != null && seats[0] != null && seats[0].getControllingPassenger() == null){
                return !vehdata().getInventoryContainers().isEmpty() && vehdata().getInventoryContainers().get(0).getPart().getAttribute(InventoryAttribute.class).getType() == InventoryType.FLUID;
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
            return (T) new ItemStackHandler(vehdata().getInventoryContainers().get(0).getAttributeData(InventoryAttributeData.class).getInventory());
        }
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && this.hasCapability(capability, facing)){
            return (T) vehdata().getInventoryContainers().get(0).getAttributeData(InventoryAttributeData.class).getFluidHandler();
        }
        return super.getCapability(capability, facing);
    }
	
	protected WorldRailData getWorldData(){
		return world.getCapability(WorldRailDataSerializer.CAPABILITY, null);
	}

	@Override
	public void setupCapability(ContainerHolder cap){
		if(vehdata() == null || vehdata().getContainerHolders().isEmpty()) return;
		if(world.isRemote){ cap.sync(true); return; }
		cap.setOnlyOneContainer(vehdata().getContainerHolders().size() < 2);
		for(java.util.Map.Entry<String, PartData> entry : vehdata().getParts().entrySet()){
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

	public boolean isDriverInCreativeMode(){
		if(seats == null || seats.length < 1 || seats[0] == null || seats[0].getControllingPassenger() instanceof EntityPlayer == false) return false;
		return ((EntityPlayer)seats[0].getControllingPassenger()).capabilities.isCreativeMode;
	}

}