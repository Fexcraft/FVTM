package net.fexcraft.mod.fvtm.api.root;

import net.fexcraft.mod.fvtm.api.Addon;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract interface DataHolderObject<T>  extends IForgeRegistryEntry<T> {
	
    public Addon getAddon();

    public String getName();

    public String[] getDescription();
    
    public interface Simple<T> extends DataHolderObject<T>{

        public ItemStack getItemStack();
    	
    }
    
    public static interface Extended<T, D> extends DataHolderObject<T>{

        public ItemStack getItemStack(D dataobj);
        
    }
	
}