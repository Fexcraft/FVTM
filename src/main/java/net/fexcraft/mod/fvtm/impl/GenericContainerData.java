package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.compatibility.InventoryType;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class GenericContainerData implements ContainerData {
	
	private Container container;
	private int sel;
	private String url, lockcode;
	private ResourceLocation custom;
	private boolean isexternal, locked;
	private NonNullList<ItemStack> stacks;
	private FluidTank fluidtank;
	
	public GenericContainerData(Container container){
		this.container = container;
		switch(container.getInventoryType()){
			case ENERGY:
				break;
			case FLUID:
				fluidtank = container.getFluidType() == null ? new FluidTank(container.getInventorySize()) : new FluidTank(container.getFluidType(), 0, container.getInventorySize());
				break;
			case FUEL:
				break;
			case ITEM:
				stacks = NonNullList.<ItemStack>withSize(container.getInventorySize(), ItemStack.EMPTY);
				break;
			default:
				break;
		}
	}

	@Override
	public Container getContainer(){
		return container;
	}

	@Override
	public int getSelectedTexture(){
		return sel;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
		tagcompound.setString(ContainerItem.NBTKEY, container.getRegistryName().toString());
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("SelectedTexture", sel);
		compound.setString("CustomTexture", isexternal ? url == null ? "" : url : custom == null ? "minecraft:stone" : custom.toString());
		compound.setBoolean("IsTextureExternal", isexternal);
		compound.setBoolean("Locked", locked);
		compound.setString("LockCode", lockcode == null ? KeyItem.getNewKeyCode() : lockcode);
		if(container.getInventoryType() == InventoryType.ITEM){
			compound = ItemStackHelper.saveAllItems(compound, stacks);
		}
		else if(container.getInventoryType() == InventoryType.FLUID){
			fluidtank.writeToNBT(compound);
		}
		//
		tagcompound.setTag(FVTM.MODID + "_container", compound);
		return tagcompound;
	}

	@Override
	public ContainerData readFromNBT(NBTTagCompound tagcompound){
		NBTTagCompound compound = tagcompound.getCompoundTag(FVTM.MODID + "_container");
		sel = compound.getInteger("SelectedTexture");
		isexternal = compound.getBoolean("IsTextureExternal");
		url = isexternal ? compound.getString("CustomTexture") : null;
		custom = isexternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
		locked = compound.getBoolean("Locked");
		lockcode = compound.hasKey("LockCode") ? compound.getString("LockCode") : KeyItem.getNewKeyCode();
		if(container.getInventoryType() == InventoryType.ITEM){
			ItemStackHelper.loadAllItems(compound, stacks);
		}
		else if(container.getInventoryType() == InventoryType.FLUID){
			fluidtank.readFromNBT(compound);
		}
		//
		return this;
	}

	@Override
	public ResourceLocation getCustomTexture(){
		return isexternal ? ExternalTextureHelper.get(url) : this.custom;
	}

	@Override
	public void setCustomTexture(String string, boolean external){
		this.url = external ? string : null;
		this.custom = external ? null : new ResourceLocation(string);
		this.isexternal = external;
	}

	@Override
	public void setSelectedTexture(int i){
		this.sel = i;
	}

	@Override
	public boolean isTextureExternal(){
		return isexternal;
	}

	@Override
	public ResourceLocation getTexture(){
		return sel >= 0 ? container.getTextures().get(sel) : this.getCustomTexture();
	}

	@Override
	public NonNullList<ItemStack> getInventory(){
		return stacks;
	}

	@Override
	public boolean isLocked(){
		return locked;
	}

	@Override
	public boolean setLocked(Boolean lock){
		return lock == null ? (locked = !locked) : (locked = lock);
	}

	@Override
	public String getLockCode(){
		return lockcode;
	}

	@Override
	public IFluidHandler getFluidHandler(){
		return fluidtank;
	}
	
}