package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.UniInventory;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UserInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerCon extends ContainerInterface {

	public FuelFillerCon(JsonMap map, UniEntity ply, V3I pos){
		super(map, ply, pos);
		inventory = UniInventory.create(2).drop(true);
	}

}
