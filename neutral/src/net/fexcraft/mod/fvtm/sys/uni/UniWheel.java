package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface UniWheel {

	public void updatePrevPos();

	public void remove();

	public boolean isAdded();

	public V3D pos();

	public void pos(double x, double y, double z);

	public void yaw(float yaw);

	public void prepare();

	public void move();

	public WheelTireData wtd();

	public void addMotion(double x, double y, double z);

	public void setMotion(double x, double y, double z);

}
