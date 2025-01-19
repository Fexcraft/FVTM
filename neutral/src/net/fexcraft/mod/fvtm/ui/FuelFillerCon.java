package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.FuelFiller;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.UniInventory;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerCon extends ContainerInterface {

	protected FuelFiller.FuelFillerContainer tile;
	protected FuelFiller filler;

	public FuelFillerCon(JsonMap map, UniEntity ply, V3I pos){
		super(map, ply, pos);
		inventory = UniInventory.create(2).drop(true);
		tile = (FuelFiller.FuelFillerContainer)ply.entity.getWorld().getBlockEntity(pos);
		filler = tile.getFuelFiller();
	}

}
