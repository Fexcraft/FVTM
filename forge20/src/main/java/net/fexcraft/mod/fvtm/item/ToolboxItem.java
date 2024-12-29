package net.fexcraft.mod.fvtm.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToolboxItem extends Item {

	public final int var;

	public ToolboxItem(int var){
		super(new Properties().stacksTo(1));
		this.var = var;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		switch(var){
			case 0:{
				tooltip.add(Component.literal("Part Removal and Maintenance Toolbox"));
				break;
			}
			case 1:{
				tooltip.add(Component.literal("Livery/Texture Management Toolbox"));
				break;
			}
			case 2:{
				tooltip.add(Component.literal("Color Channel Painting Toolbox"));
				break;
			}
		}
	}

}
