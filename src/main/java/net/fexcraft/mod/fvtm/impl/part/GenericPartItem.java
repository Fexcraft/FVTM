package net.fexcraft.mod.fvtm.impl.part;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.api.Addon;

import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.impl.GenericCreativeTab;
import net.fexcraft.mod.fvtm.impl.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.Resources;
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

public class GenericPartItem extends Item implements PartItem {

    public static final GenericPartItem INSTANCE = new GenericPartItem();

    public GenericPartItem(){
        //this.setCreativeTab(Tabs.PARTS);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setRegistryName("fvtm:part");
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

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            PartData part = stack.getCapability(VAPDataCache.CAPABILITY, null).getPartData();
            if(part == null){
                return;
            }
            tooltip.add(Formatter.format("&9Name: &7" + part.getPart().getName()));
            tooltip.add(Formatter.format("&9Type: &7" + part.getPart().getCategory()));
            for(String s : part.getPart().getDescription()){
                tooltip.add(Formatter.format(s));
            }
            tooltip.add(Formatter.format("&9Selected Texture: &7" + part.getSelectedTexture()));
            tooltip.add(Formatter.format("&9Current Offset: &8" + part.getCurrentOffset().toString()));
            for(Class clazz : part.getPart().getAttributeClasses()){
                part.getPart().getAttribute(clazz).addInformation(stack, world, tooltip, flag);
            }
            if(part.getPart().getModel() != null && part.getPart().getModel().getCreators().size() > 0){
                tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
                tooltip.add(Formatter.format("&6Model by:"));
                for(String string : part.getPart().getModel().getCreators()){
                    try{
                        tooltip.add(Formatter.format("&7- &3" + Static.getPlayerNameByUUID(UUID.fromString(string))));
                    }
                    catch(Exception e){
                        tooltip.add(Formatter.format("&7- &3" + string));
                    }
                }
            }
            if(part.getPart().getScripts().size() > 0){
                tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
                tooltip.add(Formatter.format("&9Scripts: &7" + part.getPart().getScripts().size()));
                for(Class clazz : part.getPart().getScripts()){
                    tooltip.add(Formatter.format("&7- &3" + clazz.getName()));
                }
            }
            else{
                tooltip.add(Formatter.format("&8No Scripts."));
            }

        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(tab == CreativeTabs.SEARCH){
            for(Part part : Resources.PARTS.getValuesCollection()){
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, part.getRegistryName().toString());
                stack.setTagCompound(nbt);
                items.add(stack);
            }
        }
        if(tab instanceof GenericCreativeTab){
            Addon addon = ((GenericCreativeTab)tab).getAddon();
            Collection<Part> coll = Resources.PARTS.getValuesCollection().stream().filter(p -> p.getAddon().getRegistryName().equals(addon.getRegistryName())).collect(Collectors.toList());
            for(Part part : coll){
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, part.getRegistryName().toString());
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
    public PartData getPart(ItemStack stack){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            return Resources.getPartData(stack.getTagCompound());
        }
        return null;
    }

}
