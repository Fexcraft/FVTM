package net.fexcraft.mod.fvtm.sys.uni;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.PassCap;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHolderWrapper;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.util.Pivot;
import net.fexcraft.mod.fvtm.util.LoopSound;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;

import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;
import static net.fexcraft.mod.fvtm.util.PacketsImpl.getTargetPoint;

/** 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class GenericVehicle extends Entity implements VehicleEntity, ContainerHolderWrapper {
	
	public float wheelsYaw;
	public double throttle;
	//@SideOnly(Side.CLIENT)
	public double speed;
	public SeatCache[] seats;
	public WheelEntity[] wheels;
	public LoopSound engineloop;
    public float prevRotationYaw;
    public float prevRotationPitch;
    public float prevRotationRoll;
    public boolean should_sit = true;
	public AxisAlignedBB renderbox;

	public GenericVehicle(World world){
		super(world);
	}
	
	public abstract SwivelPoint getRotPoint();

	public boolean onKeyPress(KeyPress key, Seat seatdata, EntityPlayer player, boolean state){
		return onKeyPress(key, seatdata, player);
	}
	
	public boolean getKeyPressState(KeyPress key){
		return false;
	}
	
	public boolean onKeyPress(KeyPress key, Seat seatdata, EntityPlayer player){
		return false;
	}
	
	/** Returns first found (driver) seat's controlling passenger that is a player. */
	public Entity getDriver(){
		for(SeatCache ent : seats){
			if(ent.seatdata.driver && ent.passenger() instanceof EntityPlayer) return ent.passenger();
		}
		return null;
	}
	
	@Override
	public Entity getControllingPassenger(){
		return null;//getDriver();
	}
	
	@Override
	public void updatePassenger(Entity pass){
		SeatCache seat = getSeatOf(pass);
		if(seat != null) seat.updatePassenger(pass);
		else{
			if(world.isRemote) pass.getCapability(Capabilities.PASSENGER, null).reconn(true);
			pass.setPosition(posX, posY, posZ);
		}
		return;
	}
	
	@Override
	public double getMountedYOffset(){
		return 0;
	}
	
	@Override
	public void addPassenger(Entity pass){
		super.addPassenger(pass);
		SeatCache cache = getSeatOf(pass);
		if(cache != null){
			cache.passenger(pass);
		}
	}
	
	@Override
	public void removePassenger(Entity pass){
		if(seats != null){
			for(SeatCache seat : seats){
				if(pass.equals(seat.passenger())){
					seat.passenger(null);
				}
			}
			if(!world.isRemote){
				pass.getCapability(Capabilities.PASSENGER, null).set(-1, -1);
			}
		}
		super.removePassenger(pass);
	}
	
	@Override
    public void removePassengers(){
		super.removePassengers();
    }

	@Override
    protected boolean canFitPassenger(Entity passenger){
		/*for(SeatCache seat : seats){
			if(seat.passenger() == null && seat.pending == null) return true;
		}
        return false;*/
		return true;
    }
	
	@Override
	public boolean shouldRiderSit(){
		return should_sit;
	}

	public void updateSittingState(Entity pass){
		SeatCache seat = getSeatOf(pass);
		if(seat != null) should_sit = seat.seatdata.sitting;
	}

	public SeatCache getSeatOf(Entity entity){
		PassCap pass = entity.getCapability(Capabilities.PASSENGER, null);
		if(pass == null || pass.seat() < 0 || seats == null || pass.seat() >= seats.length) return null;
		return seats[pass.seat()];
	}

    protected boolean isDriverInCreative(){
    	Entity con = this.getDriver();
    	return con != null && ((EntityPlayer)con).capabilities.isCreativeMode;
    }

    public boolean isDrivenByPlayer(){//TODO if we'd allow for putting any vehicle as trailer (e.g. towing), remove if-is-trailer check
    	GenericVehicle con = (getVehicleData().getType().isTrailer() && getFrontCoupledEntity() != null ? (GenericVehicle)getFrontCoupledEntity().getEntity() : this);
        return con != null && SeatCache.isPassengerThePlayer(con);
    }
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		//
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		//
	}
	
	@Override
	public boolean isLocked(){
		return getVehicleData().getLock().isLocked();
	}

    // --- CAPABILITIES --- //

	/** Generally in case of Inventories, it will always give you the first part which returns true to this capability. */
    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
    	if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
    		if((facing == null || facing.getAxis().isVertical()) && !isLocked()){
        		if(!getVehicleData().getInventories().isEmpty()){
        			for(String inv_id : getVehicleData().getInventories()){
        				if(getVehicleData().getPart(inv_id).getFunction(InventoryFunction.class, "fvtm:inventory").isInventoryType(capability)){
        					return true;
        				}
        			}
        		}
    		}
    	}
    	return super.hasCapability(capability, facing);
    }

	/** Generally in case of Inventories, it will always give you the first part which returns true to this capability. */
    @Override @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
    	if(hasCapability(capability, facing)){
			for(String inv_id : getVehicleData().getInventories()){
				InventoryFunction invfunc = getVehicleData().getPart(inv_id).getFunction(InventoryFunction.class, "fvtm:inventory");
				if(invfunc.isInventoryType(capability)){ return invfunc.getInventory(capability); }
			}
    	}
        return super.getCapability(capability, facing);
    }

	public Vehicle getVehicle(){
		return getVehicleData() == null ? null : getVehicleData().getType();
	}

	public abstract boolean isRailType();

	public abstract void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double throttle, double steeringYaw, int fuel);
	
	@Override
	public Vec3d getContainerSlotPosition(String slotid, ContainerHolder capability){
		ContainerSlot slot = capability.getContainerSlot(slotid);
		if(slot == null) return new Vec3d(0, 0, 0);
        SwivelPoint point = getVehicleData().getRotationPoint(slot.rotpoint);
        V3D relpos = point.getRelativeVector(slot.position.x, slot.position.y, slot.position.z);
		return new Vec3d(relpos.x + posX, relpos.y + posY, relpos.z + posZ);
	}
	
	@Override
	public Vec3d getContainerInSlotPosition(String slotid, ContainerHolder capability, ContainerType type, int index){
		ContainerSlot slot = capability.getContainerSlot(slotid);
		if(slot == null) return new Vec3d(0, 0, 0);
        SwivelPoint point = getVehicleData().getRotationPoint(slot.rotpoint);
        float off = index + (type.length() / 2f) - (slot.length / 2f);
        calcaxis.set_rotation(slot.rotation, 0, 0, true);
        V3D offv = calcaxis.get_vector(-off, 0, 0);
        V3D relpos = point.getRelativeVector(slot.position.x + offv.x, slot.position.y + offv.y, slot.position.z + offv.z);
		return new Vec3d(relpos.x + posX, relpos.y + posY, relpos.z + posZ);
	}
	
	private static final Pivot calcaxis = new Pivot();
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox(){
        return this.getEntityBoundingBox().grow(getVehicleData().getAttribute("collision_range").asFloat() + 2);
    }
	
	@Override
	public void playStepSound(BlockPos blockpos, Block block){
		return;
	}

	public boolean isBraking(){
		return false;
	}
	
	public void sendAttributeUpdate(Attribute<?> attr){
		if(attr == null) return;
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", "fvtm:gui");
		packet.setString("task", "attr_update");
		packet.setString("attr", attr.id);
		packet.setInteger("entity", getEntityId());
		if(attr.valuetype.isTristate()){
			if(attr.asTristate() == null){
				packet.setBoolean("value", false);
				packet.setBoolean("reset", true);
			}
			else{
				packet.setBoolean("value", attr.asBoolean());
			}
		}
		else if(attr.valuetype.isFloat()){
			packet.setFloat("value", attr.asFloat());
		}
		else if(attr.valuetype.isInteger()){
			packet.setInteger("value", attr.asInteger());
		}
		else if(attr.valuetype.isString()){
			packet.setString("value", attr.asString());
		}
		else packet.setString("value", attr.asString());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(packet), getTargetPoint(this));
	}

	public void sendAttributeUpdate(String id){
		sendAttributeUpdate(getVehicleData().getAttribute(id));
	}

	public int getSpeed(){
		return (int)speed;
	}
	
	public void sendLockStateUpdate(){
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", UTIL_LISTENER);
		packet.setString("task", "lock_state");
		packet.setBoolean("state", getVehicleData().getLock().isLocked());
		packet.setInteger("entity", getEntityId());
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(packet), getTargetPoint(this));
	}

}
