package net.fexcraft.mod.addons.gep.fuels;

import net.fexcraft.mod.fvtm.api.Fuel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Diesel implements Fuel {

    private static final ResourceLocation registryname = new ResourceLocation(/*"fvtm:*/"diesel");

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
        return "Diesel (GAS)";
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
