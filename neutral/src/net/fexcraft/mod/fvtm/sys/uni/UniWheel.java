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

	public void move(float yaw);

	public WheelTireData wtd();

	public void addMotion(double x, double y, double z);

}
