package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIKey;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleMainCon extends ContainerInterface {

	public VehicleMainCon(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
	}

	@Override
	public Object get(String key, Object... objs) {
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(client) return;
		switch(com.getString("open")){
			case "info":
				player.entity.openUI(UIKeys.VEHICLE_INFO, pos);
				return;
			case "fuel":
				player.entity.openUI(UIKeys.VEHICLE_FUEL, pos);
				return;
			case "attributes":
				player.entity.openUI(UIKeys.VEHICLE_ATTRIBUTES, pos);
				return;
			case "inventories":
				player.entity.openUI(UIKeys.VEHICLE_INVENTORIES, pos);
				return;
			case "containers":
				player.entity.openUI(UIKeys.VEHICLE_CONTAINERS, pos);
				return;
			case "connectors":
				player.entity.openUI(UIKeys.VEHICLE_CONNECTORS, pos);
				return;
			default:
				return;
		}
	}

}
