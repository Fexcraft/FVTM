package net.fexcraft.mod.fvtm.item;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.DECORATION_EDITOR;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecorationItem extends Item implements JunctionGridItem {

	public static DecorationItem INSTANCE;
	private static float[][] gridcolour;
	static{
		RGB cyan = new RGB(java.awt.Color.ORANGE.getRGB());
		gridcolour = new float[][] { cyan.toFloatArray(), cyan.toFloatArray() };
	}

	public DecorationItem(){
		setRegistryName("fvtm:decoration");
		setTranslationKey(getRegistryName().toString());
		setHasSubtypes(true);
		setMaxStackSize(64);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		tooltip.add(Formatter.format("&9Rightclick on a block to place a decoration."));
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote) return EnumActionResult.PASS;
		ItemStack stack = player.getHeldItem(hand);
		QV3D vector = new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 16);
		Decoration decoen = new Decoration(world);
		decoen.setPosition(vector.vec.x, vector.vec.y, vector.vec.z);
		//decoen.decos.add(Resources.DECORATIONS.get("test:metronome").copy());
		world.spawnEntity(decoen);
		if(!player.capabilities.isCreativeMode) stack.shrink(1);
    	player.openGui(FVTM.getInstance(), DECORATION_EDITOR, world, decoen.getEntityId(), 0, 0);
		return EnumActionResult.SUCCESS;
	}

	@Override
	public float[][] getGridColours(){
		return gridcolour;
	}

	@Override
	public int getPlacingGrid(){
		return 16;
	}

}
