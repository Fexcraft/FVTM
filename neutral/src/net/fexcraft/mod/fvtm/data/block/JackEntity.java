package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface JackEntity {

	public VehicleData getVehicle();

	public V3D getVehiclePos();

	public InteractionHandler.InteractRef iref();

}
