package net.fexcraft.mod.fvtm.api;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.capability.ContainerHolder;
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

        TINY(1f), XSMALL(2f), SMALL(3f), MEDIUM(6f), LARGE(12f);
    	
    	private boolean even; private float length;
    	
    	ContainerType(float length){
    		this.length = length; even = this.length % 2 == 0;
    	}
    	
    	public float length(){ return length; }
    	
    	public boolean evenLength(){ return even; }

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
    
    public static interface ContainerHolderEntity {
    	
    	public void setupCapability(ContainerHolder cap);
    	
    	@Deprecated public float[] cheGetRotation();
    	
    }

    public static enum ContainerPosition {
        LARGE_SINGLE,
        MEDIUM_DUAL1,
        MEDIUM_DUAL2,
        MEDIUM_SINGLE;
    }

}
