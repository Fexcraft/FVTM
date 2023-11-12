package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.Consumable;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.item.ConsumableItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class IWI extends ItemWrapper {

	public Item item;

	public IWI(Item item){
		this.item = item;
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
	}

	@Override
	public Item local(){
		return item;
	}

	@Override
	public Object direct(){
		return item;
	}

}
