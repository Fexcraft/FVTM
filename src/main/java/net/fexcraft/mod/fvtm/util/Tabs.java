package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.registry.FCLRegistry;
import net.fexcraft.mod.fvtm.blocks.ConstructorRemote;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Tabs {
    
    public static final CreativeTabs BLOCKS = new CreativeTabs("fvtm_blocks") {
        @Override
        public ItemStack getTabIconItem(){
            return new ItemStack(FCLRegistry.getBlock("fvtm:constructor_controller"));
        }
    };

    public static final CreativeTabs VEHICLE_PRESETS = new CreativeTabs("fvtm_vehiclepresets") {
        @Override
        public ItemStack getTabIconItem(){
            return new ItemStack(ConstructorRemote.INSTANCE);
        }
    };

}
