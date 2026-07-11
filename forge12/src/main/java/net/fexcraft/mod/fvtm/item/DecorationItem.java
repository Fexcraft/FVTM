package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.sys.deco.DecoSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.fexcraft.mod.fvtm.item.VehicleItem.getTexTitle;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecorationItem extends Item implements ContentItem.ContentDataItem<Decoration, DecorationData>, ItemTextureable.TextureableItem<Decoration>, JunctionGridItem {

	private static float[][] gridcolour;
	static{
		RGB cyan = new RGB(java.awt.Color.ORANGE.getRGB());
		gridcolour = new float[][] { cyan.toFloatArray(), cyan.toFloatArray() };
	}
	private Decoration deco;

	public DecorationItem(Decoration type){
		super();
		deco = type;
		setHasSubtypes(true);
		setMaxStackSize(deco.getMaxStack());
		setRegistryName(deco.getID().colon());
		setTranslationKey(deco.getID().colon());
		if(!EnvInfo.CLIENT) return;
		setCreativeTab((CreativeTabs) FvtmResources.INSTANCE.getCreativeTab(deco));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		tooltip.add(Formatter.format("&9Name: &7" + deco.getName()));
		for(String s : deco.getDescription()){
			tooltip.add(Formatter.format(I18n.format(s)));
		}
		UniStack uni = UniStack.get(stack);
		if(uni == null) return;
		DecorationData data = getData(uni.stack);
		if(data != null){
			tooltip.add(Formatter.format("&9Texture: &7" + getTexTitle(data)));
			if(deco.getModel() != null && deco.getModel().getCreators().size() > 0){
				tooltip.add(Formatter.format("&9Model by:"));
				for(String str : deco.getModel().getCreators()){
					tooltip.add(Formatter.format("&7- " + str));
				}
			}
		}
		tooltip.add(Formatter.format("&9Right-click on a block to place a decoration."));
	}

	@Override
	public float[][] getGridColours(){
		return gridcolour;
	}

	@Override
	public Decoration getContent(){
		return deco;
	}

	@Override
	public ContentType getType(){
		return ContentType.DECORATION;
	}

	@Override
	public DecorationData getData(StackWrapper stack){
		return getData(stack.directTag());
	}

	@Override
	public DecorationData getData(TagCW compound){
		return new DecorationData(deco).read(compound);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote || player.isSneaking()) return EnumActionResult.PASS;
		EntityW ply = UniEntity.getEntity(player);
		SystemManager.run(SystemManager.Systems.DECO, ply.getWorld(), DecoSystem.class, sys -> {
			sys.addNewDeco(ply, UniStack.getStack(player.getHeldItem(hand)), new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ));
		});
		return EnumActionResult.SUCCESS;
	}

}
