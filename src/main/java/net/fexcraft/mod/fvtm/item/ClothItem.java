package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.Cloth;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ClothItem extends ItemArmor {
	
	private Cloth type;
	
	public ClothItem(Cloth cloth){
		super(cloth.getArMaterial(), 0, cloth.getEquitmentSlot());
		this.setMaxDamage(cloth.getMaxDamage());
		this.type = cloth;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type){
		return "fvtm:textures/entity/blank.png";
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(type.newItemStack());
    	}
    }

	public Cloth getType(){
		return type;
	}

}
