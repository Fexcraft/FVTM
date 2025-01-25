package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.ContentItem.ContentDataItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler.DPIHData;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PartItem extends Item implements ContentDataItem<Part, PartData>, TextureableItem<Part> {

	private Part part;
	
    public PartItem(Part content){
		super();
		part = content;
		setHasSubtypes(true);
		setMaxStackSize(1);
		setRegistryName(part.getID().colon());
		setTranslationKey(part.getID().colon());
		if(!EnvInfo.CLIENT) return;
		setCreativeTab((CreativeTabs) FvtmResources.INSTANCE.getCreativeTab(part));
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
    	VehicleAndPartDataCache cache = stack.getCapability(Capabilities.VAPDATA, null);
    	if(!cache.overridesLang(false)) tooltip.add(Formatter.format("&9Name: &7" + part.getName()));
        tooltip.add(Formatter.format("&9Type: &7" + part.getCategory()));
        for(String s : part.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s)));
        }
        PartData data = cache.getPartData();
        if(data == null) return;
        tooltip.add(Formatter.format("&9Texture: &7" + getTexTitle(data)));
        if(part.getInstallHandlerData() != null && part.getInstallHandlerData() instanceof DPIHData){
			DPIHData idata = part.getInstallHandlerData();
			if(!idata.removable){
				tooltip.add(Formatter.format(idata.swappable ? "&c&oPermanent, &a&oSwappable" : "&c&oPermanent"));
			}
			else{
				tooltip.add(Formatter.format(idata.swappable ? "&a&oSwappable" : "&e&oNot Swappable"));
			}
        }
        if(!data.getFunctions().isEmpty()){
			StackWrapper wrapper = UniStack.getStack(stack);
            for(PartFunction func : data.getFunctions().values()){
				func.addInformation(wrapper, WrapperHolder.getWorld(world), data, tooltip, flag.isAdvanced());
            }
            tooltip.add(Formatter.format("&9- - - - - - &7-"));
        }
        if(part.getDefaultAttributes().size() > 0){
        	tooltip.add(Formatter.format("&0&9This part has &7%s &9Attribute/s.", part.getDefaultAttributes().size()));
        }
        if(part.getStaticModifiers().size() > 0){
        	tooltip.add(Formatter.format("&0&3This part has &7%s &3Modifier/s.", part.getStaticModifiers().size()));
        }
        if(part.getDefaultFunctions().size() > 0){
        	tooltip.add(Formatter.format("&0&bThis part has &7%s &bFunction/s.", part.getDefaultFunctions().size()));
        }
        if(part.getModel() != null && part.getModel().getCreators().size() > 0){
            tooltip.add(Formatter.format("&9Model by:"));
            for(String str : part.getModel().getCreators()){
            	tooltip.add(Formatter.format("&7- " + str));
            }
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public String getItemStackDisplayName(ItemStack stack){
    	if(!stack.getCapability(Capabilities.VAPDATA, null).overridesLang(false)){
        	String langname = "item." + stack.getItem().getRegistryName().toString() + ".name";
        	langname = net.minecraft.util.text.translation.I18n.translateToLocal(langname).trim();
        	if(langname.length() > 0) return langname;
        	stack.getCapability(Capabilities.VAPDATA, null).overridesLang(true);
    	}
        return Formatter.format(part.getName());
    }

	private String getTexTitle(PartData data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getType().getDefaultTextures().get(data.getSelectedTexture()).name();
		}
		else return data.isTextureExternal() ? "external" : "internal";
	}

	@Override
	public PartData getData(StackWrapper stack){
		if(!stack.hasTag()) stack.setTag(TagCW.create());
		return getData(stack.getTag());
	}

	@Override
	public PartData getData(TagCW compound){
		return new PartData(part).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(part.getNewStack().local());
    	}
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
