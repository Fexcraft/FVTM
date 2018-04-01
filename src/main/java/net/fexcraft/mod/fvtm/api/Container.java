package net.fexcraft.mod.fvtm.api;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.api.root.Colorable.ColorHolder;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.api.root.Lockable;
import net.fexcraft.mod.fvtm.api.root.Saveloadable;
import net.fexcraft.mod.fvtm.api.root.Textureable;
import net.fexcraft.mod.fvtm.api.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.model.container.ContainerModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Container extends IForgeRegistryEntry<Container>, TextureHolder, ColorHolder {

	@Override
	public default Class<Container> getRegistryType(){
		return Container.class;
	}
	
	public ItemStack getItemStack(@Nullable ContainerData data);
	
	public default boolean isMediumContainer(){
		return this.getType() == ContainerType.MEDIUM;
	}
	
	public default boolean isLargeContainer(){
		return this.getType() == ContainerType.LARGE;
	}
	
	public Addon getAddon();

	public String getName();
	
	public ContainerType getType();

	public String[] getDescription();
	
	@SideOnly(Side.CLIENT)
	public ContainerModel<ContainerData> getModel();
	
	public Class<? extends ContainerData> getDataClass();
	
	public int getInventorySize();
	
	public boolean isItemValid(ItemStack stack);
	
	public InventoryType getInventoryType();
	
	public @Nullable Fluid getFluidType();
	
	public static enum ContainerType {
		
		TINY,//unused
		SMALL,//unused
		MEDIUM,
		LARGE;
		
	}
	
	public static interface ContainerData extends Lockable, Colorable, Saveloadable<ContainerData>, Textureable {
		
		public Container getContainer();
		
		public NonNullList<ItemStack> getInventory();

		public IFluidHandler getFluidHandler();
		
	}
	
	public static interface ContainerItem {
		
		public static final String NBTKEY = "FVTM:Container";
		
		public ContainerData getContainer(ItemStack stack);
		
	}
	
	public static enum ContainerPosition {
		LARGE_SINGLE,
		MEDIUM_DUAL1,
		MEDIUM_DUAL2,
		MEDIUM_SINGLE;
	}
	
}