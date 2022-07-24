package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class DecorationItem extends Item implements JunctionGridItem {

	public static DecorationItem INSTANCE;
	private static float[][] gridcolour;
	static{
		RGB cyan = new RGB(java.awt.Color.ORANGE.getRGB());
		gridcolour = new float[][] { cyan.toFloatArray(), cyan.toFloatArray() };
	}

	public DecorationItem(){
		super(new Properties().fireResistant().stacksTo(64).tab(InternalAddon.INSTANCE.getDefaultCreativeTab()));
		this.setRegistryName("fvtm", "decoration");
		INSTANCE = this;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flag){
		list.add(new TextComponent("Rightclick on a block to place a decoration."));
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide) return InteractionResult.PASS;
		ItemStack stack = context.getItemInHand();
		Vec316f vector = new Vec316f(context.getLevel(), context.getClickLocation(), 16);
		Decoration decoen = new Decoration(FVTM.DECO_ENT.get(), context.getLevel());
		decoen.setPos(vector.vector.x, vector.vector.y, vector.vector.z);
		context.getLevel().addFreshEntity(decoen);
		if(!context.getPlayer().isCreative()) stack.shrink(1);
    	//player.openGui(FVTM.getInstance(), DECORATION_EDITOR, world, decoen.getEntityId(), 0, 0);
		return InteractionResult.SUCCESS;
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
