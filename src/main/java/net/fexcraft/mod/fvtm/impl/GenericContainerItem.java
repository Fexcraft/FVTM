package net.fexcraft.mod.fvtm.impl;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericContainerItem extends Item implements ContainerItem {
	
	public static final GenericContainerItem INSTANCE = new GenericContainerItem();
	
	public GenericContainerItem(){
		this.setCreativeTab(Tabs.VEHICLE_PRESETS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.setRegistryName("fvtm:container");
		this.setUnlocalizedName(this.getRegistryName().toString());
	}
	
	@SideOnly(Side.CLIENT)
	public static class ItemMeshDef implements net.minecraft.client.renderer.ItemMeshDefinition {

		@Override
		public final net.minecraft.client.renderer.block.model.ModelResourceLocation getModelLocation(ItemStack stack){
			if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
				return new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)), "inventory");
			}
			return new net.minecraft.client.renderer.block.model.ModelResourceLocation(INSTANCE.getRegistryName(), "inventory");
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			ContainerData con = Resources.getContainerData(stack.getTagCompound());
			if(con == null){
				return;
			}
			tooltip.add(Formatter.format("&9Name: &7" + con.getContainer().getName()));
			tooltip.add(Formatter.format("&9Type: &7" + con.getContainer().getType().name()));
			for(String s : con.getContainer().getDescription()){
				tooltip.add(Formatter.format(s));
			}
			tooltip.add(Formatter.format("&9Selected Texture: &7" + con.getSelectedTexture()));
			if(con.getContainer().getModel() != null && con.getContainer().getModel().creators.size() > 0){
				tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
				tooltip.add(Formatter.format("&6Model by:"));
				for(String string : con.getContainer().getModel().creators){
					tooltip.add(Formatter.format("&7- &3" + string));
				}
			}
		}
    }
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(this.isInCreativeTab(tab)){
        	for(Container con : Resources.CONTAINERS.getValues()){
        		ItemStack stack = new ItemStack(this);
        		NBTTagCompound nbt = new NBTTagCompound();
        		nbt.setString(NBTKEY, con.getRegistryName().toString());
        		stack.setTagCompound(nbt);
                items.add(stack);
        	}
        }
    }
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		if(stack.hasTagCompound()){
			return "item." + stack.getTagCompound().getString(NBTKEY);
		}
        return this.getUnlocalizedName();
    }

	@Override
	public ContainerData getContainer(ItemStack stack){
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
			return Resources.getContainerData(stack.getTagCompound());
		}
		return null;
	}
	
}