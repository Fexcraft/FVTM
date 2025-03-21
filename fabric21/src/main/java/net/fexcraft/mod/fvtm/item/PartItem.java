package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem.ContentDataItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler.DPIHData;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartItem extends Item implements ContentDataItem<Part, PartData>, TextureableItem<Part> {

	private Part part;
	
    public PartItem(Properties prop, Part content){
		super(prop.stacksTo(1));
		part = content;
	}

    @Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag){
		PartData data = UniStack.getStack(stack).getContent(ContentType.PART.item_type);
    	tooltip.add(GenericUtils.format("&9Name: &7" + part.getName()));
        tooltip.add(GenericUtils.format("&9Type: &7" + part.getCategory()));
        for(String s : part.getDescription()){
            tooltip.add(GenericUtils.format(I18n.get(s)));
        }
        if(data == null) return;
        tooltip.add(GenericUtils.format("&9Texture: &7" + getTexTitle(data)));
        if(part.getInstallHandlerData() != null && part.getInstallHandlerData() instanceof DPIHData){
			DPIHData idata = part.getInstallHandlerData();
			if(!idata.removable){
				tooltip.add(GenericUtils.format(idata.swappable ? "&c&oPermanent, &a&oSwappable" : "&c&oPermanent"));
			}
			else{
				tooltip.add(GenericUtils.format(idata.swappable ? "&a&oSwappable" : "&e&oNot Swappable"));
			}
        }
		UniStack uni = UniStack.get(stack);
        if(!data.getFunctions().isEmpty() && uni != null){
			ArrayList<String> tips = new ArrayList<>();
			for(PartFunction func : data.getFunctions().values()){
				func.addInformation(uni.stack, WrapperHolder.getClientWorld(), data, tips, flag.isAdvanced());
			}
			for(String tip : tips) tooltip.add(GenericUtils.format(tip));
			tooltip.add(GenericUtils.format("&9- - - - - - &7-"));
        }
        if(part.getDefaultAttributes().size() > 0){
        	tooltip.add(GenericUtils.format("&0&9This part has &7%s &9Attribute/s.", part.getDefaultAttributes().size()));
        }
        if(part.getStaticModifiers().size() > 0){
        	tooltip.add(GenericUtils.format("&0&3This part has &7%s &3Modifier/s.", part.getStaticModifiers().size()));
        }
        if(part.getDefaultFunctions().size() > 0){
        	tooltip.add(GenericUtils.format("&0&bThis part has &7%s &bFunction/s.", part.getDefaultFunctions().size()));
        }
        if(part.getModel() != null && part.getModel().getCreators().size() > 0){
            tooltip.add(GenericUtils.format("&9Model by:"));
            for(String str : part.getModel().getCreators()){
            	tooltip.add(GenericUtils.format("&7- " + str));
            }
        }
    }

	private String getTexTitle(PartData data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getType().getDefaultTextures().get(data.getSelectedTexture()).name();
		}
		else return data.isTextureExternal() ? "external" : "internal";
	}

	@Override
	public PartData getData(StackWrapper stack){
		return getData(stack.directTag());
	}

	@Override
	public PartData getData(TagCW compound){
		return new PartData(part).read(compound);
	}

	@Override
	public Part getContent(){
		return part;
	}

	@Override
	public ContentType getType(){
		return ContentType.PART;
	}

}
