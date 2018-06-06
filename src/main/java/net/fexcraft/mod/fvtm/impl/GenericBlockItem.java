package net.fexcraft.mod.fvtm.impl;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockItem;
import net.fexcraft.mod.fvtm.blocks.UniversalBlock;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericBlockItem extends ItemBlock16 implements BlockItem {

    public static GenericBlockItem INSTANCE = new GenericBlockItem();

    public GenericBlockItem(){
    	super(UniversalBlock.INSTANCE);
    	INSTANCE = this;
        //this.setCreativeTab(Tabs.BLOCKS);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setRegistryName("fvtm:block");
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
            BlockData con = Resources.getBlockData(stack.getTagCompound());
            if(con == null){ return; }
        	this.setMaxStackSize(con.getBlock().isFunctional() ? 1 : 64);
            tooltip.add(Formatter.format("&9Name: &7" + con.getBlock().getName()));
            tooltip.add(Formatter.format("&9Type: &7" + (con.getBlock().isFunctional() ? "functional" : "decorational")));
            for(String s : con.getBlock().getDescription()){
                tooltip.add(Formatter.format(s));
            }
            tooltip.add(Formatter.format("&9Selected Texture: &7" + con.getSelectedTexture()));
            if(con.getBlock().getModel() != null && con.getBlock().getModel().getCreators().size() > 0){
                tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
                tooltip.add(Formatter.format("&6Model by:"));
                for(String string : con.getBlock().getModel().getCreators()){
                    try{
                        tooltip.add(Formatter.format("&7- &3" + Static.getPlayerNameByUUID(UUID.fromString(string))));
                    }
                    catch(Exception e){
                        tooltip.add(Formatter.format("&7- &3" + string));
                    }
                }
            }
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(this.isInCreativeTab(tab)){
            for(Block con : Resources.BLOCKS.getValues()){
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, con.getRegistryName().toString());
                stack.setTagCompound(nbt);
                items.add(stack);
            }
        }
        if(tab instanceof GenericCreativeTab){
            Addon addon = ((GenericCreativeTab)tab).getAddon();
            Collection<Block> coll = Resources.BLOCKS.getValues().stream().filter(p -> p.getAddon().getRegistryName().equals(addon.getRegistryName())).collect(Collectors.toList());
            for(Block con : coll){
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
	public BlockData getBlock(ItemStack stack){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            return Resources.getBlockData(stack.getTagCompound());
        }
        return null;
	}

}
