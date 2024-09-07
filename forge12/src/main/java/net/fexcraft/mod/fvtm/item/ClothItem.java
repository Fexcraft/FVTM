package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.uni.EnvInfo;
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

import javax.annotation.Nullable;
import java.util.List;

public class ClothItem extends ItemArmor implements ItemTextureable.TextureableItem<Cloth> {
	
	private Cloth cloth;
	
	public ClothItem(Cloth cloth){
		super((ArmorMaterial)cloth.getMaterial().local(), 0, EntityEquipmentSlot.fromString(cloth.getEqSlot().toLowerCase()));
		this.cloth = cloth;
		setHasSubtypes(true);
		setRegistryName(cloth.getID().colon());
		setTranslationKey(cloth.getID().colon());
		if(cloth.getMaxDamage() > 0) this.setMaxDamage(cloth.getMaxDamage());
        if(!EnvInfo.CLIENT) return;
        setCreativeTab((CreativeTabs) FvtmResources.INSTANCE.getCreativeTab(cloth));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type){
		return "fvtm:textures/entity/blank.png";
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(cloth.getNewStack().local());
    	}
    }

	@Override
	public Cloth getContent(){
		return cloth;
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
    	tooltip.add(Formatter.format("&9Name: &7" + cloth.getName()));
        for(String s : cloth.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s)));
        }
        tooltip.add(Formatter.format("&9Worn: &7" + net.fexcraft.mod.fvtm.gui.DefaultSteeringOverlay.format((stack.getItemDamage() / (float)stack.getMaxDamage()) * 100) + "%"));
        super.addInformation(stack, world, tooltip, flag);
    }

}
