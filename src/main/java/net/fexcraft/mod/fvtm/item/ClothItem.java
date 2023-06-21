package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.ItemTex;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClothItem extends ItemArmor implements ItemTex<Cloth> {
	
	private Cloth type;
	
	public ClothItem(Cloth cloth){
		super((ArmorMaterial)cloth.getMaterial().getLocalMaterial(), 0, cloth.getEquitmentSlot());
		if(cloth.getMaxDamage() > 0) this.setMaxDamage(cloth.getMaxDamage());
		//
        (type = cloth).getAddon().getFCLRegisterer().addItem(type.getRegistryName().getPath(), this, 0, null);
        if(Static.side().isServer()) return;
        this.setCreativeTab(Resources.getCreativeTab(type));
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
	
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
    	tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s)));
        }
        tooltip.add(Formatter.format("&9Worn: &7" + net.fexcraft.mod.fvtm.gui.DefaultSteeringOverlay.format((stack.getItemDamage() / (float)stack.getMaxDamage()) * 100) + "%"));
        super.addInformation(stack, world, tooltip, flag);
    }

	@Override
	public TypeCore<Cloth> getDataType(){
		return type;
	}

}
