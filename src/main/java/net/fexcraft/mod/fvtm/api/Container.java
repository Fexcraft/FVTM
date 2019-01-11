package net.fexcraft.mod.fvtm.api;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.api.root.Colorable.ColorHolder;
import net.fexcraft.mod.fvtm.api.root.DataHolderObject;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.api.root.Lockable;
import net.fexcraft.mod.fvtm.api.root.Saveloadable;
import net.fexcraft.mod.fvtm.api.root.Textureable;
import net.fexcraft.mod.fvtm.api.root.Textureable.TextureHolder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

public interface Container extends DataHolderObject.Extended<Container, Container.ContainerData>, TextureHolder, ColorHolder {

    @Override
    public default Class<Container> getRegistryType(){
        return Container.class;
    }

    public default boolean isMediumContainer(){
        return this.getType() == ContainerType.MEDIUM;
    }

    public default boolean isLargeContainer(){
        return this.getType() == ContainerType.LARGE;
    }

    public ContainerType getType();

    public Model<ContainerData, Object> getModel();

    public Class<? extends ContainerData> getDataClass();

    public int getInventorySize();

    public boolean isItemValid(ItemStack stack);

    public InventoryType getInventoryType();

    public @Nullable
    Fluid getFluidType();

    public static enum ContainerType {

        TINY, //1m //unused
        XSMALL, //2m //unused
        SMALL, //3m //unused
        MEDIUM, //6m
        LARGE; //12m

    }

    public static interface ContainerData extends Lockable, Colorable, Saveloadable<ContainerData>, Textureable {

        public Container getContainer();

        public NonNullList<ItemStack> getInventory();

        public IFluidHandler getFluidHandler();

        public @Nullable
        FluidTank getFluidTank();

    }

    public static interface ContainerItem {

        public static final String NBTKEY = "FVTM:Container";

        public ContainerData getContainer(ItemStack stack);

    }
    
    public static interface ContainerHolder {
    	
    	public @Nullable ContainerData getContainerData();
    	
    	public boolean setContainerData(@Nullable ContainerData data);
    	
    	public ContainerType getContainerType();
    	
    }

    public static enum ContainerPosition {
        LARGE_SINGLE,
        MEDIUM_DUAL1,
        MEDIUM_DUAL2,
        MEDIUM_SINGLE;
    }

}
