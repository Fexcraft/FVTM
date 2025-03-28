package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.uni.inv.StackWrapper;
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
			case 3:{
				tooltip.add("Wire removal Toolbox");
				break;
			}
			case 4:{
				tooltip.add("Wire Slack Adjustment Toolbox");
				break;
			}
			case 5:{
				tooltip.add("Sign Adjustment and Removal Toolbox");
				break;
			}
			default: break;
		}
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
		if(tab == CreativeTabs.SEARCH || tab == getCreativeTab()){
			for(ToolboxType value : ToolboxType.values()){
				items.add(new ItemStack(INSTANCE, 1, value.idx));
			}
		}
	}

	public static int getToolboxType(StackWrapper stack){
		return stack.damage();
	}

	public static int getToolboxType(ItemStack stack){
		return stack.getItemDamage();
	}

}
