package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIText;
import net.fexcraft.mod.uni.ui.UserInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleFuel extends UserInterface {

	private UIText accepts;
	private VehicleInstance veh;

	public VehicleFuel(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		accepts = texts.get("accepts");
		accepts.value("ui.fvtm.vehicle_fuel.accepts");
		accepts.translate();
		veh = (VehicleInstance)container.get("vehicle");
		String accepted = " ";
		for(int i = 0; i < veh.data.getFuelGroup().length; i++){
			accepted += veh.data.getFuelGroup()[i] + (i == veh.data.getFuelGroup().length - 1 ? "" : ",");
		}
		accepts.value(accepts.value() + accepted);
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		texts.get("fuel_name").value(
			veh.data.getAttribute("fuel_primary").asString() + " - " +
			veh.data.getAttribute("fuel_secondary").asString() + " - "
			+ (veh.data.getAttribute("fuel_quality").asFloat() * 100) + "%"
		);
		texts.get("fuel_stored").value(
			veh.data.getAttribute("fuel_stored").asInteger() + "/" +
			veh.data.getAttribute("fuel_capacity").asInteger() + "mB"
		);
	}

	@Override
	public void drawbackground(float ticks, int mx, int my){
		float percent = veh.data.getAttribute("fuel_stored").asFloat() / veh.data.getAttribute("fuel_capacity").asFloat() * 100f;
		if(percent > 0) drawer.draw(gLeft + 10, gTop + 49, 0, 238, (int)percent, 18);
	}

}
