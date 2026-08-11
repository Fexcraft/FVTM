package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.rail.JuncToolItem;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JunctionToolItem extends Item implements JunctionGridItem {

	public static JunctionToolItem INSTANCE;

	public JunctionToolItem(){
		setHasSubtypes(true);
		setMaxStackSize(1);
		setRegistryName("fvtm:junction_tool");
		setTranslationKey("fvtm:junction_tool");
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World level, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(level.isRemote) return EnumActionResult.PASS;
		return JuncToolItem.onUse(WrapperHolder.getWorld(level), UniEntity.getEntity(player), UniStack.getStack(player.getHeldItem(hand)), new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ))
			? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
	}

}
