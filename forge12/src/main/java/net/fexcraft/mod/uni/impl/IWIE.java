package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.fvtm.data.Consumable;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ConsumableItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class IWIE extends IWI {

	public IWIE(Item item){
		super(item);
	}

	@Override
	public void linkContainer(){
		if(item instanceof MaterialItem){
			Material mat = ((MaterialItem)item).getContent();
			if(mat.getItemContainer() == null) return;
			item.setContainerItem(Item.getByNameOrId(mat.getItemContainer()));
		}
		if(item instanceof ConsumableItem){
			Consumable con = ((ConsumableItem)item).getContent();
			if(con.getItemContainer() == null) return;
			item.setContainerItem(Item.getByNameOrId(con.getItemContainer()));
		}
		if(item instanceof BlockItem){
			Block blk = ((BlockItem)item).getContent();
			if(blk.getItemContainer() == null) return;
			item.setContainerItem(Item.getByNameOrId(blk.getItemContainer()));
		}
	}

	@Override
	public void regToDict(){
		if(item instanceof MaterialItem){
			Material mat = ((MaterialItem)item).getContent();
			if(mat.getOreDictId() == null) return;
			OreDictionary.registerOre(mat.getOreDictId(), (Item)mat.getItemWrapper().direct());
		}
		if(item instanceof ConsumableItem){
			Consumable con = ((ConsumableItem)item).getContent();
			if(con.getOreDictId() == null) return;
			OreDictionary.registerOre(con.getOreDictId(), (Item)con.getItemWrapper().direct());
		}
		if(item instanceof BlockItem){
			Block blk = ((BlockItem)item).getContent();
			if(blk.getOreDictId() == null) return;
			OreDictionary.registerOre(blk.getOreDictId(), (Item)blk.getItemWrapper().direct());
		}
	}

}
