package net.fexcraft.mod.fvtm.api;

import net.fexcraft.lib.mc.api.KeyItem;
import net.fexcraft.mod.fvtm.api.root.DataHolderObject;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import java.util.UUID;

import javax.annotation.Nullable;

@SuppressWarnings("deprecation")
public interface Material extends DataHolderObject.Simple<Material> {

    @Override
    public default Class<Material> getRegistryType(){
        return Material.class;
    }

    public boolean isFuelContainer();

    public Fuel getFuelType();

    public int maxCapacity();

    public boolean isVehicleKey();
    
    public @Nullable EnumDyeColor getDyeColor();

    //<--- ITEM --->//
    public static abstract class MaterialItem extends KeyItem {

        public static final String NBTKEY = "FVTM:Material";

        public abstract Material getMaterial(ItemStack stack);

        @Override
        public KeyType getType(ItemStack stack){
            Material mat = this.getMaterial(stack);
            return mat != null && mat.isVehicleKey() ? stack.getTagCompound().getBoolean("VehicleKeyType") ? KeyType.ADMIN : KeyType.COMMON : null;
        }

        @Override
        public String getCode(ItemStack stack){
            Material mat = this.getMaterial(stack);
            return mat != null && mat.isVehicleKey() ? stack.getTagCompound().getString("VehicleKeyCode") : null;
        }

        @Override
        public UUID getCreator(ItemStack stack){
            Material mat = this.getMaterial(stack);
            return mat != null && mat.isVehicleKey() ? UUID.fromString(stack.getTagCompound().getString("VehicleKeyCreator")) : null;
        }

    }

}
