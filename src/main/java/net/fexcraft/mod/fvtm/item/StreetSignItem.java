package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.item.Item;

@fItem(modid = FVTM.MODID, name = "streetsign")
public class StreetSignItem extends Item {
	
	public static Item INSTANCE;
	
	public StreetSignItem(){
		super(); INSTANCE = this;
	}
	
}
