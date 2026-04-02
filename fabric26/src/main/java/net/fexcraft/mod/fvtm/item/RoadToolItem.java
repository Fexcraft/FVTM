package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.UniRoadTool;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolItem extends Item implements JunctionGridItem {

	public RoadToolItem(Properties prop){
		super(prop.stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay disp, Consumer<Component> cons, TooltipFlag flag){
		ArrayList<String> list = new ArrayList<>();
		UniRoadTool.addTooltip(UniStack.getStack(stack).directTag(), list, (str, objs) -> I18n.get(str, objs));
		for(String str : list) cons.accept(Component.literal(str));
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		int result = UniRoadTool.onUse(UniEntity.getEntity(context.getPlayer()), context.getHand() == InteractionHand.MAIN_HAND);
		switch(result){
			case 1: return InteractionResult.FAIL;
			case 2: return InteractionResult.SUCCESS;
			case 3:{
				//TODO perm check
				ItemStack stack = context.getPlayer().getItemInHand(context.getHand());
				RoadPlacingUtil.place(WrapperHolder.getWorld(context.getLevel()),
					UniEntity.getEntity(context.getPlayer()),
					UniStack.getStack(stack).directTag(),
					new QV3D(context.getClickLocation().x, context.getClickLocation().y - 1, context.getClickLocation().z));
				return InteractionResult.SUCCESS;
			}
			case 0:
			default: return InteractionResult.PASS;
		}
	}

}
