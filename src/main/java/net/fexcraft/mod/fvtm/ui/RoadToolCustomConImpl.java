package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.ui.road.RoadToolCustomCon;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.impl.SWI;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.UniCon;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolCustomConImpl extends RoadToolCustomCon {

	protected RoadInventory inv;
	protected SWI wrapper = new SWI(ItemStack.EMPTY);

	public RoadToolCustomConImpl(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		inv = new RoadInventory(size[0] >= 9 ? 9 : size[0]);
	}

	@Override
	public void init(){
		int is = size[0] > 9 ? 9 : size[0];
		for(int i = 0; i < is; i++){
			((UniCon)root).addSlot(new RoadInventory.RoadSlot((FvtmWorld)player.entity.getWorld(), inv, i, 88 - offset + 1 + i * 18, 8, true, pos.x > 0));
		}
		fillStacks();
	}

	@Override
	protected void fillStacks(){
		if(!stack.getTag().has(tagname)) return;
		TagCW compound = stack.getTag().getCompound(tagname);
		for(int i = 0; i < 9; i++){
			int j = i + scroll;
			if(j >= size[0]) break;
			if(!compound.has("Block" + j)){
				inv.setInventorySlotContents(i, ItemStack.EMPTY);
				continue;
			}
			inv.setInventorySlotContents(i, new ItemStack((NBTTagCompound)compound.getCompound("Block" + j).direct()));
		}
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
