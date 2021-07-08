package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

@fItem(modid = "fvtm", name = "cloth")
public class ClothItem extends ItemArmor {

	public ClothItem(){
		super(ArmorMaterial.IRON, 0, EntityEquipmentSlot.HEAD);
		//
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type){
		return "fvtm:textures/entity/blank.png";
	}

}
