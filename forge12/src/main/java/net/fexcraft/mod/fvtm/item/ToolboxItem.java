package net.fexcraft.mod.fvtm.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToolboxItem extends Item {

	public static ToolboxItem INSTANCE;

	public ToolboxItem(){
		super();
		INSTANCE = this;
		setMaxStackSize(1);
		setRegistryName("fvtm:toolbox");
		setTranslationKey("fvtm:toolbox");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		switch(stack.getItemDamage()){
			case 0:{
				tooltip.add("Part Removal and Maintenance Toolbox");
				break;
			}
			case 1:{
				tooltip.add("Livery/Texture Management Toolbox");
				break;
			}
			case 2:{
				tooltip.add("Color Channel Painting Toolbox");
				break;
			}
		}
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
		if(tab == CreativeTabs.SEARCH || tab == getCreativeTab()){
			items.add(new ItemStack(INSTANCE, 1, 0));
			items.add(new ItemStack(INSTANCE, 1, 1));
			items.add(new ItemStack(INSTANCE, 1, 2));
		}
	}

}
