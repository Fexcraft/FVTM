/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fexcraft.mod.fvtm.impl;

import java.util.TreeMap;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class GenericCreativeTab extends CreativeTabs {

    private static TreeMap<ResourceLocation, GenericCreativeTab> tabs = new TreeMap<>();
    private NonNullList<ItemStack> list;
    private Addon addon;
    private int icon, sec;

    public GenericCreativeTab(Addon addon){
        super(addon.getRegistryName().toString());
        tabs.put(addon.getRegistryName(), this);
        this.addon = addon;
    }

    @Override
    public ItemStack getTabIconItem(){
        return null;
    }

    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel(){
        return addon.getName();
    }

    public Addon getAddon(){
        return addon;
    }

    @Override
    public ItemStack getIconItemStack(){
        if(list == null){
            list = NonNullList.create(); this.displayAllRelevantItems(list);
        }
        if(sec != Time.getSecond()){
            sec = Time.getSecond();
            this.icon++; if(icon >= list.size()){ icon = 0; }
        }
        return icon >= list.size() ? ItemStack.EMPTY : list.get(icon);
    }

}
