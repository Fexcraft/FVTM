package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface JackEntity {

	public VehicleData getVehicle();

	public V3D getVehiclePos();

	public InteractionHandler.InteractRef iref();

	public default double fillCoords(VehicleData data, List<V3D> list){
		list.clear();
		if(data.getType().getLiftingPoints().isEmpty()){
			list.add(new V3D());
			return 0;
		}
		double off = 0;
		for(LiftingPoint lp : data.getType().getLiftingPoints().values()){
			list.add(new V3D(lp.pos.x, lp.off, lp.pos.z));
			off += lp.pos.y;
		}
		return -off / data.getType().getLiftingPoints().size();
	}

	public List<V3D> getCoords();

}
