package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.ui.road.RoadToolCon;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolConImpl extends RoadToolCon {

	private RoadInventory inv = new RoadInventory();
	private SWI wrapper = new SWI(ItemStack.EMPTY);

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
		inv.setInventorySlotContents(index, new ItemStack((NBTTagCompound)com.direct()));
	}

	@Override
	public StackWrapper getInventoryContent(int index){
		wrapper.stack = inv.getStackInSlot(index);
		return wrapper;
	}

	@Override
	public boolean isInventoryEmpty(int at){
		return inv.getStackInSlot(at).isEmpty();
	}

}
