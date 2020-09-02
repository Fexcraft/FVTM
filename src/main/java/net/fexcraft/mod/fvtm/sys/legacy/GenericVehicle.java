package net.fexcraft.mod.fvtm.sys.legacy;

import java.util.UUID;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHoldingEntity;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Axis3D;
import net.fexcraft.mod.fvtm.util.LoopSound;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;

/** 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class GenericVehicle extends Entity implements VehicleEntity, ContainerHoldingEntity {
	
	public float wheelsYaw;
	public double throttle;
	public Vec3d angularVelocity = new Vec3d(0f, 0f, 0f);
	public SeatCache[] seats;
	public WheelEntity[] wheels;
	public LoopSound engineloop;

	public GenericVehicle(World world){ super(world); }
	
	public abstract SwivelPoint getRotPoint();

	public abstract boolean onKeyPress(KeyPress key, Seat seatdata, EntityPlayer player);
	
	/** Returns first found (driver) seat's controlling passenger that is a player. */
	public Entity getDriver(){
		for(SeatCache ent : seats){
			if(ent.seatdata.driver && ent.passenger() instanceof EntityPlayer) return ent.passenger();
		}
		return null;
	}
	
	@Override
	public Entity getControllingPassenger(){
		return getDriver();
	}
	
	@Override
	public void updatePassenger(Entity pass){
		SeatCache seat = getSeatOf(pass);
		if(seat != null) seat.updatePassenger();
		else pass.setPosition(posX, posY, posZ);
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
		if(cache != null) return;
		cache = getPendingSeatFor(pass);
		if(cache != null) cache.passenger(pass, false);
		//else if(!world.isRemote) pass.dismountRidingEntity();
	}
	
	@Override
	public void removePassenger(Entity pass){
		SeatCache cache = getSeatOf(pass);
		if(cache != null){
			cache.passenger(null, false);
		}
		super.removePassenger(pass);
	}
	
	@Override
    public void removePassengers(){
		if(world.isRemote){//assumably a call from the set-passengers packet
			for(SeatCache seat : seats){
				if(seat.passenger() == null) continue;
				UUID uuid = seat.passenger().getUniqueID();
				int entid = seat.passenger().getEntityId();
				seat.passenger(null, true);
				seat.pending = uuid;
				seat.pendingid = entid;
			}
		}
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

	public SeatCache getSeatOf(Entity entity){
		for(SeatCache seat : seats){
			if(seat.passenger() == entity) return seat;
		}
		return null;
	}

	public SeatCache getPendingSeatFor(Entity pass){
		for(SeatCache seat : seats){
			if(pass.getEntityId() == seat.pendingid || pass.getUniqueID().equals(seat.pending)) return seat;
		}
		return null;
	}

    protected boolean isDriverInCreative(){
    	Entity con = this.getDriver();
    	return con != null && ((EntityPlayer)con).capabilities.isCreativeMode;
    }

    public boolean isDrivenByPlayer(){//TODO if we'd allow for putting any vehicle as trailer (e.g. towing), remove if-is-trailer check
    	GenericVehicle con = (getVehicleData().getType().isTrailerOrWagon() && getFrontCoupledEntity() != null ? (GenericVehicle)getFrontCoupledEntity().getEntity() : this);
        return con != null && SeatCache.isPassengerThePlayer(con);
    }
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		try{
	        for(int i = 0; i < seats.length; i++){
	        	if(!compound.hasKey("se" + i)) continue;
        		seats[i].sendPendingPacket(new UUID(compound.getLong("se" + i), compound.getLong("at") + i), null);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		if(seats == null || seats.length == 0) return;
		NBTTagCompound seets = new NBTTagCompound();
		for(SeatCache seat : seats){
			if(seat.passenger() == null) continue;
			seets.setLong("se" + seat.seatindex, seat.passenger().getUniqueID().getMostSignificantBits());
			seets.setLong("at" + seat.seatindex, seat.passenger().getUniqueID().getLeastSignificantBits());
		}
	}
	
	@Override
	public boolean isLocked(){
		return this.getVehicleData().isLocked();
	}

    // --- CAPABILITIES --- //

	/** Generally in case of Inventories, it will always give you the first part which returns true to this capability. */
    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
    	if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
    		if((facing == null || facing.getAxis().isVertical()) && !this.isLocked()){
        		if(!this.getVehicleData().getInventories().isEmpty()){
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
    	if(this.hasCapability(capability, facing)){
			for(String inv_id : getVehicleData().getInventories()){
				InventoryFunction inventory = getVehicleData().getPart(inv_id).getFunction(InventoryFunction.class, "fvtm:inventory");
				if(inventory.isInventoryType(capability)){ return inventory.getInventory(capability); }
			}
    	}
        return super.getCapability(capability, facing);
    }

	protected Vehicle getVehicle(){
		return this.getVehicleData() == null ? null : this.getVehicleData().getType();
	}

	public abstract boolean isRailType();

	public abstract void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, Vec3d avel, double throttle, double steeringYaw, int fuel);
	
	@Override
	public Vec3d getContainerSlotPosition(String slotid, ContainerHolder capability){
		ContainerSlot slot = capability.getContainerSlot(slotid);
		if(slot == null) return new Vec3d(0, 0, 0);
        SwivelPoint point = getVehicleData().getRotationPoint(slot.rotpoint);
        Vec3d relpos = point.getRelativeVector(slot.position.x, slot.position.y, slot.position.z);
		return relpos.add(posX, posY, posZ);
	}
	
	@Override
	public Vec3d getContainerInSlotPosition(String slotid, ContainerHolder capability, ContainerType type, int index){
		ContainerSlot slot = capability.getContainerSlot(slotid);
		if(slot == null) return new Vec3d(0, 0, 0);
        SwivelPoint point = getVehicleData().getRotationPoint(slot.rotpoint);
        float off = index + (type.length() / 2f) - (slot.length / 2f);
        calcaxis.setAngles(slot.rotation, 0, 0);
        Vec3d offv = calcaxis.getRelativeVector(-off, 0, 0);
        Vec3d relpos = point.getRelativeVector(slot.position.x + offv.x, slot.position.y + offv.y, slot.position.z + offv.z);
		return relpos.add(posX, posY, posZ);
	}
	
	private static final Axis3D calcaxis = new Axis3D();
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox(){
        return this.getEntityBoundingBox().grow(getVehicleData().getAttribute("collision_range").getFloatValue());
    }

}
