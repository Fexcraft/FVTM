package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface Passenger extends EntityW {

	public SeatInstance getSeatOn();

	public default FvtmWorld getFvtmWorld(){
		return (FvtmWorld)getWorld();
	}

	public void set(int veh, int seatid);

	public int vehicle();

	public int seat();

	public V3D getEyeVec();

	public V3D getLookVec();

	public boolean isShiftDown();

}
