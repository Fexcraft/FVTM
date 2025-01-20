package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.FuelFiller;
import net.fexcraft.mod.fvtm.data.vehicle.CatalogPreset;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.UniInventory;
import net.fexcraft.mod.uni.tag.TagCW;
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

	@Override
	public void packet(TagCW com, boolean client){
		if(com.has("sel")){
			filler.selected = FvtmRegistry.getFuel(com.getString("sel"));
			filler.stored = 0;
			filler.converted = 0;
			if(client){
				((FuelFillerUI)ui).updateSelectedText(true);
			}
			else SEND_TO_CLIENT.accept(com, player);
		}
	}

}
