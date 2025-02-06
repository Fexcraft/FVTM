package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.FuelFiller;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniFluidTank;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerCon extends ContainerInterface {

	protected FuelFiller.FuelFillerContainer tile;
	protected FuelFiller filler;
	protected int timer = 10;

	public FuelFillerCon(JsonMap map, UniEntity ply, V3I pos){
		super(map, ply, pos);
		tile = (FuelFiller.FuelFillerContainer)ply.entity.getWorld().getBlockEntity(pos);
		filler = tile.getFuelFiller();
		inventory = filler.items;
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(com.has("sel")){
			filler.selected = FvtmRegistry.getFuel(com.getString("sel"));
			filler.tank.clear();
			filler.converted = 0;
			if(client){
				((FuelFillerUI)ui).updateSelectedText(true);
			}
			else SEND_TO_CLIENT.accept(com, player);
		}
		if(com.has("sync") && client){
			filler.tank.amount(com.getString("t"), com.getInteger("s"));
			filler.converted = com.getInteger("c");
		}
	}

	@Override
	public void update(Object localcon){
		if(player.entity.isOnClient()) return;
		if(timer > 0){
			timer--;
			return;
		}
		timer = 10;
		TagCW com = TagCW.create();
		com.set("sync", true);
		com.set("s", filler.tank.amount());
		com.set("t", filler.tank.getFluid());
		com.set("c", filler.converted);
		SEND_TO_CLIENT.accept(com, player);
	}

}
