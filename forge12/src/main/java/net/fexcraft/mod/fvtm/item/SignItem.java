package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
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

import javax.annotation.Nullable;
import java.util.List;

import static net.fexcraft.mod.fvtm.item.VehicleItem.getTexTitle;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignItem extends Item implements ContentItem.ContentDataItem<Sign, SignData>, ItemTextureable.TextureableItem<Sign>, JunctionGridItem {

	private Sign sign;

	public SignItem(Sign type){
		super();
		sign = type;
		setHasSubtypes(true);
		setMaxStackSize(64);
		setRegistryName(sign.getID().colon());
		setTranslationKey(sign.getID().colon());
		if(!EnvInfo.CLIENT) return;
		setCreativeTab((CreativeTabs) FvtmResources.INSTANCE.getCreativeTab(sign));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		tooltip.add(Formatter.format("&9Name: &7" + sign.getName()));
		for(String s : sign.getDescription()){
			tooltip.add(Formatter.format(I18n.format(s)));
		}
		UniStack uni = UniStack.get(stack);
		if(uni == null) return;
		SignData data = getData(uni.stack);
		if(data != null){
			tooltip.add(Formatter.format("&9Texture: &7" + getTexTitle(data)));
			if(sign.getModel() != null && sign.getModel().getCreators().size() > 0){
				tooltip.add(Formatter.format("&9Model by:"));
				for(String str : sign.getModel().getCreators()){
					tooltip.add(Formatter.format("&7- " + str));
				}
			}
		}
		tooltip.add(Formatter.format("&9Right-click on a block to place or upgrade a sign."));
	}

	@Override
	public Sign getContent(){
		return sign;
	}

	@Override
	public ContentType getType(){
		return ContentType.SIGN;
	}

	@Override
	public SignData getData(StackWrapper stack){
		return getData(stack.directTag());
	}

	@Override
	public SignData getData(TagCW compound){
		return new SignData(sign).read(compound);
	}

}
