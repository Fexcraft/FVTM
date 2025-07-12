package net.fexcraft.mod.fvtm.sys.uni;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface VehicleMovement {

	public default void initWheels(){}

	public default void updateAttrs(){}

	public default void move(boolean nocons){}

	public default double yaw(double dx, double dz){
		return -Math.atan2(dx, dz);
	}

}
