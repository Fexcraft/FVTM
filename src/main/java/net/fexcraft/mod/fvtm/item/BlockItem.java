package net.fexcraft.mod.fvtm.item;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.registry.ItemBlock16;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.block.generated.BlockBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockItem extends ItemBlock16 implements DataCoreItem<BlockData> {
	
	private Block type;

    public BlockItem(net.minecraft.block.Block block) throws Exception {
		super(block); type = ((BlockBase)block).type;
		this.setHasSubtypes(true); this.setMaxStackSize(type.getMaxStackSize());
		this.setRegistryName(block.getRegistryName());
		this.setUnlocalizedName(block.getUnlocalizedName());
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        if(type.isFunctional()) tooltip.add(Formatter.format("&b&oFunctional Block"));
        if(type.isDecoration()) tooltip.add(Formatter.format("&e&oDecoration Block"));
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s, new Object[0])));
        }
        BlockData data = stack.getCapability(Capabilities.VAPDATA, null).getBlockData(); if(data == null) return;
        tooltip.add(Formatter.format("&9Texture: &7" + getTexTitle(data)));
    }

	private String getTexTitle(BlockData data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getType().getDefaultTextures().get(data.getSelectedTexture()).getName();
		} else return data.isExternalTexture() ? "external" : "internal";
	}

	@Override
	public BlockData getData(ItemStack stack){
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound()); return getData(stack.getTagCompound());
	}

	@Override
	public BlockData getData(NBTTagCompound compound){
		return new BlockData(type).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == type.getAddon().getCreativeTab()){
    		items.add(type.newItemStack());
    	}
    }
    
    @Override
    public CreativeTabs getCreativeTab(){
        return type.getAddon().getCreativeTab();
    }
    
    @Override
    public int getItemBurnTime(ItemStack stack){
    	return type.getItemBurnTime() * stack.getCount();
    }

}
