package net.fexcraft.mod.fvtm.item;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PartItem extends TypeCoreItem<Part> implements DataCoreItem<PartData> {

    public PartItem(Part core){
		super(core); this.setHasSubtypes(true); this.setMaxStackSize(1);
        //this.setRegistryName(core.getRegistryName());
        //this.setUnlocalizedName(this.getRegistryName().toString());
        this.type.getAddon().getFCLRegisterer().addItem(
        	type.getRegistryName().getResourcePath(), this, 0, null);
        if(Static.side().isServer()) return;
        this.setCreativeTab(type.getAddon().getCreativeTab());
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        tooltip.add(Formatter.format("&9Type: &7" + type.getCategory()));
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(s));
        }
        if(type.getBaseAttributes().size() > 0){
        	tooltip.add(Formatter.format("&0&9This part has &7%s &9Attribute/s.", type.getBaseAttributes().size()));
        }
        if(type.getBaseModifiers().size() > 0){
        	tooltip.add(Formatter.format("&0&3This part has &7%s &3Modifier/s.", type.getBaseModifiers().size()));
        }
        if(type.getDefaultFunctions().size() > 0){
        	tooltip.add(Formatter.format("&0&bThis part has &7%s &bFunction/s.", type.getBaseModifiers().size()));
        }
        //TODO texture/pos data
        //TODO model data
        //TODO attribute data
        //TODO script data
    }

	@Override
	public PartData getData(ItemStack stack){
		return getData(stack.getTagCompound() == null ? new NBTTagCompound() : stack.getTagCompound());
	}

	@Override
	public PartData getData(NBTTagCompound compound){
		return new PartData(type).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(type.newItemStack());
    	}
    }

}
