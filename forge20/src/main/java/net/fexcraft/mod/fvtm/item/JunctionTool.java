package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.rail.JuncToolItem;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JunctionTool extends Item implements JunctionGridItem {

	public JunctionTool(){
		super(new Properties().stacksTo(1));
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide) return InteractionResult.PASS;
		Player player = context.getPlayer();
		return JuncToolItem.onUse(WrapperHolder.getWorld(context.getLevel()), UniEntity.getEntity(player), UniStack.getStack(player.getItemInHand(context.getHand())),
			new QV3D(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z)) ? InteractionResult.SUCCESS : InteractionResult.FAIL;
	}

}
