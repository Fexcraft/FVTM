package net.fexcraft.mod.fvtm.item;

import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nullable;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.sys.deco.DecoSystem;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecorationItem extends Item implements ContentItem.ContentDataItem<Decoration, DecorationData>, ItemTextureable.TextureableItem<Decoration> {

	private Decoration deco;

	public DecorationItem(Decoration deco){
		super(new Properties().stacksTo(deco.getMaxStack()));
		this.deco = deco;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		tooltip.add(GenericUtils.format("&9Name: &7" + deco.getName()));
		for(String s : deco.getDescription()){
			tooltip.add(GenericUtils.format(I18n.get(s)));
		}
		DecorationData data = getDataFromTag(stack.getTag());
		if(data != null){
			tooltip.add(GenericUtils.format("&9Texture: &7" + VehicleItem.getTexTitle(data)));
			if(deco.getModel() != null && deco.getModel().getCreators().size() > 0){
				tooltip.add(GenericUtils.format("&9Model by:"));
				for(String str : deco.getModel().getCreators()){
					tooltip.add(GenericUtils.format("&7- " + str));
				}
			}
		}
		tooltip.add(GenericUtils.format("&9Rightclick on a block to place this decoration."));
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
	public void initializeClient(Consumer<IClientItemExtensions> consumer){
		//TODO
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide || context.getPlayer().isShiftKeyDown()) return InteractionResult.PASS;
		EntityW ply = UniEntity.getEntity(context.getPlayer());
		SystemManager.run(SystemManager.Systems.DECO, ply.getWorld(), DecoSystem.class, sys -> {
			sys.addNewDeco(ply, UniStack.getStack(context.getItemInHand()), new QV3D(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z));
		});
		return InteractionResult.SUCCESS;
	}

}