package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.block.generated.PlainBase;
import net.fexcraft.mod.fvtm.data.ContentItem.ContentDataItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockItem21 extends net.minecraft.world.item.BlockItem implements ContentDataItem<Block, BlockData>, TextureableItem<Block> {

	private Block type;

    public BlockItem21(Properties prop, net.minecraft.world.level.block.Block block){
		super(block, genProps(prop, ((PlainBase)block).type));
		type = ((PlainBase)block).type;
	}

	public BlockItem21(Properties prop, Block block){
		this(prop, (net.minecraft.world.level.block.Block)block.getBlock());
	}

	private static Properties genProps(Properties prop, Block type){
		return prop.stacksTo(type.getMaxStackSize());
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay disp, Consumer<Component> cons, TooltipFlag flag){
		cons.accept(GenericUtils.format("&9Name: &7" + type.getName()));
		for(String s : type.getDescription()) cons.accept(GenericUtils.format(I18n.get(s)));
		if(type.getBlockType().isGenericRoad()){
			//
		}
		else if(type.getBlockType().getMetaVariants() > 0){
			cons.accept(GenericUtils.format("&9Variant: &7" + stack.getDamageValue()));
		}
		UniStack uni = UniStack.get(stack);
		if(uni == null) return;
		BlockData data = uni.stack.getContent(ContentType.BLOCK.item_type);
		if(data == null) return;
		if(!data.getType().hasPlainModel()) cons.accept(GenericUtils.format("&9Texture: &7" + getTexTitle(data)));
		if(!data.getFunctions().isEmpty()){
			ArrayList<String> tips = new ArrayList<>();
			for(BlockFunction func : data.getFunctions()){
				func.addInformation(uni.stack, WrapperHolder.getClientWorld(), data, tips, flag.isAdvanced());
			}
			for(String str : tips) cons.accept(GenericUtils.format(str));
			cons.accept(GenericUtils.format("&9- - - - - - &7-"));
		}
		if(type.getModel() == null) return;
		if(type.getModel().getCreators().size() > 0){
			cons.accept(GenericUtils.format("&9Model by:"));
			for(String str : type.getModel().getCreators()){
				cons.accept(GenericUtils.format("&7- " + str));
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
		return getData(stack.directTag());
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
