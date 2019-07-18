package net.fexcraft.mod.fvtm.sys.legacy;

import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Axis3D;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

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

}
