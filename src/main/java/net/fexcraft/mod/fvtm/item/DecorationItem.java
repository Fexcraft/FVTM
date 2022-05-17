package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DecorationItem extends Item implements JunctionGridItem {

	public static DecorationItem INSTANCE;
	private static float[][] gridcolour;
	static{
		RGB cyan = new RGB(java.awt.Color.ORANGE.getRGB());
		gridcolour = new float[][] { cyan.toFloatArray(), cyan.toFloatArray() };
	}

	public DecorationItem(){
		super(new Properties().fireResistant().stacksTo(64));
		this.setRegistryName("fvtm", "decoration");
		INSTANCE = this;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flag){
		list.add(new TextComponent("Rightclick on a block to place a decoration."));
	}

	/*@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote) return EnumActionResult.PASS;
		ItemStack stack = player.getHeldItem(hand);
		Vec316f vector = new Vec316f(world, new Vec3d(pos).add(hitX, hitY, hitZ), 16);
		Decoration decoen = new Decoration(world);
		decoen.setPosition(vector.vector.x, vector.vector.y, vector.vector.z);
		//decoen.decos.add(Resources.DECORATIONS.get("test:metronome").copy());
		world.spawnEntity(decoen);
		if(!player.capabilities.isCreativeMode) stack.shrink(1);
    	player.openGui(FVTM.getInstance(), DECORATION_EDITOR, world, decoen.getEntityId(), 0, 0);
		return EnumActionResult.SUCCESS;
	}*/

	@Override
	public float[][] getGridColours(){
		return gridcolour;
	}

	@Override
	public int getPlacingGrid(){
		return 16;
	}

}
