package net.fexcraft.mod.fvtm.util;

import java.util.List;

import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.blocks.ConstructorRemote;
import net.fexcraft.mod.fvtm.impl.GenericCreativeTab;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Tabs {
    
    public static final CreativeTabs BLOCKS = new CreativeTabs("fvtm_blocks") {
        @Override
        public ItemStack getTabIconItem(){
            return new ItemStack(RegistryUtil.getBlock("fvtm:constructor_controller"));
        }
    };

    public static final CreativeTabs VEHICLE_PRESETS = new CreativeTabs("fvtm_vehiclepresets") {
        @Override
        public ItemStack getTabIconItem(){
            return new ItemStack(ConstructorRemote.INSTANCE);
        }
    };

}
