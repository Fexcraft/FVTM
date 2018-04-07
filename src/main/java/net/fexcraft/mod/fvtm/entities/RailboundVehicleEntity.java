package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.fexcraft.mod.fvtm.util.rail.RailMap;
import net.fexcraft.mod.fvtm.util.rail.RailMapCapability;
import net.fexcraft.mod.fvtm.util.rail.RailPiece;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RailboundVehicleEntity extends Entity implements VehicleEntity {

	public RailPiece rail, lastRail;
	private VehicleData vehicledata;
	private VehicleAxes axes, prevAxes;
	private double throttle;
	private float wheelsAngle, wheelsYaw;

	public RailboundVehicleEntity(World worldIn){
		super(worldIn);
		
		//TODO
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		//TODO
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		//TODO
	}
	
	@Override
	public void onUpdate(){
		RailMapCapability railmap = world.getCapability(RailMap.CAPABILITY, EnumFacing.DOWN);
		if(rail == null){
			rail = railmap.getNearestRailPosition(this.getPositionVector());
		}
		if(lastRail == null && rail != null){
			lastRail = railmap.getRailPositionAt(rail.prev);
		}
		if(rail == null){
			return;
		}
		RailPiece next = railmap.getNextRailPosition(rail, lastRail);
		lastRail = rail; rail = next;
		this.setPosition(rail.own.x, rail.own.y, rail.own.z);
	}
	
	// --- VEH ENT --- //

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
	public WheelEntity[] getWheels(){
		return null;//TODO
	}

	@Override
	public SeatEntity[] getSeats(){
		return null;//TODO
	}

	@Override
	public boolean onKeyPress(int key, int seat, EntityPlayer player){
		//TODO
		return false;
	}

	@Override
	public Entity getCamera(){
		//TODO
		return null;
	}

	@Override
	public double getThrottle(){
		return throttle;
	}

	@Override
	public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, double avelx, double avely, double avelz, double throttle, float steeringYaw){
		//TODO
	}

	@Override
	public VehicleEntity getEntityAtFront(){
		//TODO
		return null;
	}

	@Override
	public VehicleEntity getEntityAtRear(){
		//TODO
		return null;
	}

	@Override
	public Vec3d getAngularVelocity(){
		//TODO
		return null;
	}

	@Override
	public float getWheelsAngle(){
		return wheelsAngle;
	}

	@Override
	public float getWheelsYaw(){
		return wheelsYaw;
	}
	
}