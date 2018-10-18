package net.fexcraft.mod.fvtm.api;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.compatibility.TANItemData;
import net.fexcraft.mod.fvtm.api.root.DataHolderObject;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public interface Consumable extends DataHolderObject.Simple<Consumable> {

    @Override
    public default Class<Consumable> getRegistryType(){
        return Consumable.class;
    }

    public int getHealAmount();

    public float getSaturation();

    public int getItemUseDuration();

    public boolean isWolfMeat();

    public boolean isDrinkable();

    public boolean alwaysEdible();

    public @Nullable
    TANItemData getTANData();

    public @Nullable
    ItemStack getContainerItemStack();

    // Consumable - Item //
    public static abstract class ConsumableItem extends ItemFood {

        public ConsumableItem(){
            super(0, false);
        }

        public static final String NBTKEY = "FVTM:Consumable";

        public abstract Consumable getConsumable(ItemStack stack);

    }

}
