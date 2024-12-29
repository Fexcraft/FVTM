package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.ui.road.RoadToolCon;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.world.item.ItemStack;

/**
 * @author Ferdinand Calo' (FEX___96
 */
public class RoadToolConImpl extends RoadToolCon {

	private RoadInventory inv = new RoadInventory();

	public RoadToolConImpl(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		initInv();
	}

	@Override
	public Object getInventory(){
		return inv;
	}

	@Override
	public void setInventoryContent(int index, TagCW com){
		inv.setItem(index, ItemStack.of(com.local()));
	}

	@Override
	public StackWrapper getInventoryContent(int index){
		return StackWrapper.wrap(inv.getItem(index));
	}

	@Override
	public boolean isInventoryEmpty(int at){
		return inv.getItem(at).isEmpty();
	}

}
