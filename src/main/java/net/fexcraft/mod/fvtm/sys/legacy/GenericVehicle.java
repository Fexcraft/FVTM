package net.fexcraft.mod.fvtm.sys.legacy;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Axis3D;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

/** 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class GenericVehicle extends Entity implements VehicleEntity {
	
	public float wheelsYaw;
	public double throttle;
	public Vec3d angularVelocity = new Vec3d(0f, 0f, 0f);
	public WheelEntity[] wheels;

	public GenericVehicle(World world){ super(world); }
	
	public abstract Axis3D getAxes();

	public abstract SeatEntity[] getSeats();

	public abstract boolean onKeyPress(KeyPress key, Seat seatdata, EntityPlayer player);
	
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

}
