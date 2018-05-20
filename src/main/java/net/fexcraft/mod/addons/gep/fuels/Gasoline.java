package net.fexcraft.mod.addons.gep.fuels;

import net.fexcraft.mod.fvtm.api.Fuel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Gasoline implements Fuel {

    private static final ResourceLocation registryname = new ResourceLocation(/*"fvtm:*/"gasoline");

    @Override
    public Fuel setRegistryName(ResourceLocation name){
        return this;
    }

    @Override
    public ResourceLocation getRegistryName(){
        return registryname;
    }

    @Override
    public String getName(){
        return "Gasoline (Petroleum)";
    }

    @Override
    public boolean isValidFuelContainer(ItemStack stack){
        if(stack.getItem() instanceof FuelItem){
            FuelItem item = (FuelItem) stack.getItem();
            return item.getFuel(stack) == this;
        }
        return false;
    }

}
