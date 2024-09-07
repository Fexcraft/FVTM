package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.attribute.AttributeUtil;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleAttributesCon extends ContainerInterface {

	protected VehicleInstance vehicle;

	public VehicleAttributesCon(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		vehicle = ((Passenger)player.entity).getFvtmWorld().getVehicle(pos.x);
	}

	@Override
	public Object get(String key, Object... objs){
		if(key.equals("vehicle")) return vehicle;
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(client) return;
		if(com.getString("cargo").equals("toggle")){
			AttributeUtil.processToggle(vehicle, com, (Passenger)player.entity);
		}
		else if(com.getString("cargo").equals("editor")){
			int idx = vehicle.data.getAttributeIndex(vehicle.data.getAttribute(com.getString("attr")));
			if(idx < 0) return;
			player.entity.openUI(UIKeys.VEHICLE_ATTR_EDITOR, pos.add(0, idx, 0));
		}
	}

}
