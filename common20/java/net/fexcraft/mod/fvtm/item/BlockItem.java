package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.block.generated.PlainBase;
import net.fexcraft.mod.fvtm.data.ContentItem.ContentDataItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static net.fexcraft.mod.uni.world.WrapperHolder.getWorld;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockItem extends net.minecraft.world.item.BlockItem implements ContentDataItem<Block, BlockData>, TextureableItem<Block> {

	private Block type;

    public BlockItem(net.minecraft.world.level.block.Block block){
		super(block, genProps(((PlainBase)block).type));
		type = ((PlainBase)block).type;
	}

	public BlockItem(Block block){
		this((net.minecraft.world.level.block.Block)block.getBlock());
	}

	private static Properties genProps(Block type){
		return new Properties().stacksTo(type.getMaxStackSize());
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){;
		tooltip.add(GenericUtils.format("&9Name: &7" + type.getName()));
		for(String s : type.getDescription()) tooltip.add(GenericUtils.format(I18n.get(s)));
		if(type.getBlockType().isGenericRoad()){
			//
		}
		else if(type.getBlockType().getMetaVariants() > 0){
			tooltip.add(GenericUtils.format("&9Variant: &7" + stack.getDamageValue()));
		}
		StackWrapper wrapper = StackWrapper.wrap(stack);
		BlockData data = wrapper.getContent(ContentType.BLOCK);
		if(data == null) return;
		if(!data.getType().hasPlainModel()) tooltip.add(GenericUtils.format("&9Texture: &7" + getTexTitle(data)));
		if(!data.getFunctions().isEmpty()){
			ArrayList<String> tips = new ArrayList<>();
			for(BlockFunction func : data.getFunctions()){
				func.addInformation(wrapper, getWorld(world), data, tips, flag.isAdvanced());
			}
			for(String str : tips) tooltip.add(GenericUtils.format(str));
			tooltip.add(GenericUtils.format("&9- - - - - - &7-"));
		}
		if(type.getModel() == null) return;
		if(type.getModel().getCreators().size() > 0){
			tooltip.add(GenericUtils.format("&9Model by:"));
			for(String str : type.getModel().getCreators()){
				tooltip.add(GenericUtils.format("&7- " + str));
			}
		}
	}

	private String getTexTitle(BlockData data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getType().getDefaultTextures().get(data.getSelectedTexture()).name();
		} else return data.isTextureExternal() ? "external" : "internal";
	}

	@Override
	public BlockData getData(StackWrapper stack){
		if(!stack.hasTag()) stack.setTag(TagCW.create());
		return getData(stack.getTag());
	}

	@Override
	public BlockData getData(TagCW compound){
		return new BlockData(type).read(compound);
	}
    
    //

	@Override
	public Block getContent(){
		return type;
	}

	@Override
	public ContentType getType(){
		return ContentType.BLOCK;
	}

}
