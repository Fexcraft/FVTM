package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.uni.inv.ItemWrapper;
import net.fexcraft.mod.uni.inv.StackWrapper;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface WithItem {

	public void setItemWrapper(ItemWrapper item);
	
	public ItemWrapper getItemWrapper();

	public default <Item> Item getItem(){
		return getItemWrapper().local();
	}

	public StackWrapper getNewStack();

	public String getItemContainer();

	public String getCreativeTab();

}
