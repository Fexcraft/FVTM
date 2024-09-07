package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIKey;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleInventoriesCon extends ContainerInterface {

	protected VehicleInstance vehicle;

	public VehicleInventoriesCon(JsonMap map, UniEntity player, V3I pos){
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
		if(client || !com.has("open")) return;
		InventoryFunction func = vehicle.data.getFunctionInPart(com.getString("open"), "fvtm:inventory");
		UIKey ui = func.inventory().type.isItem() ? UIKeys.VEHICLE_INVENTORY_ITEM : UIKeys.VEHICLE_INVENTORY_FLUID;
		player.entity.openUI(ui, pos.add(0, vehicle.data.getInventories().indexOf(com.getString("open")), 0));
	}

}
