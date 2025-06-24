package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.inv.FvtmInvItems;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.function.part.InventoryFunction;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleInvItemsCon extends ContainerInterface {

	protected VehicleInstance vehicle;
	protected FvtmInvItems inv;

	public VehicleInvItemsCon(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		vehicle = ((FvtmWorld)player.entity.getWorld()).getVehicle(pos.x);
		if(pos.y < vehicle.data.getVehInvKeys().size()){
			inv = (FvtmInvItems)vehicle.data.getVehInventories().get(pos.y);
		}
		else{
			PartData data = vehicle.data.getPart(vehicle.data.getInventories().get(pos.y - vehicle.data.getVehInvKeys().size()));
			inv = (FvtmInvItems)data.getFunction(InventoryFunction.class, "fvtm:inventory").inventory();
		}
		inventory = inv.items;
	}

	@Override
	public void init(){
		int y = inv.rows < 7 ? (7 - inv.rows) * 18 : 0;
		for(int r = 0; r < inv.rows; r++){
			for(int c = 0; c < inv.cols; c++){
				root.addSlot("default", inventory, r * inv.cols + c, 8 + c * 18, 8 + r * 18 + y);
			}
		}
	}

}
