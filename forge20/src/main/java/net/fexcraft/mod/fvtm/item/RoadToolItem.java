package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.UniRoadTool;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolItem extends Item {

	public RoadToolItem INSTANCE;

	public RoadToolItem(){
		super(new Properties().stacksTo(1));
		INSTANCE = this;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		ArrayList<String> list = new ArrayList<>();
		if(!stack.hasTag()) stack.setTag(new CompoundTag());
		UniRoadTool.addTooltip(TagCW.wrap(stack.getTag()), list, I18n::get);
		for(String str : list) tooltip.add(Component.literal(str));
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
				if(!stack.hasTag()) stack.setTag(new CompoundTag());
				RoadPlacingUtil.place(WrapperHolder.getWorld(context.getLevel()),
					UniEntity.getEntity(context.getPlayer()),
					TagCW.wrap(stack.getTag()),
					new QV3D(context.getClickLocation().x, context.getClickLocation().y - 1, context.getClickLocation().z));
				return InteractionResult.SUCCESS;
			}
			case 0:
			default: return InteractionResult.PASS;
		}
	}

}
