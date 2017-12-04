package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class GenericContainerData implements ContainerData {
	
	private Container container;
	private int sel;
	private String url;
	private ResourceLocation custom;
	private boolean isexternal;
	private NonNullList<ItemStack> stacks;
	
	public GenericContainerData(Container container){
		this.container = container;
		stacks = NonNullList.<ItemStack>withSize(container.getInventorySize(), ItemStack.EMPTY);
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
		compound = ItemStackHelper.saveAllItems(compound, stacks);
		//
		tagcompound.setTag(FVTM.MODID + "_container", compound);
		return tagcompound;
	}

	@Override
	public ContainerData readFromNBT(NBTTagCompound compound){
		compound = compound.getCompoundTag(FVTM.MODID + "_container");
		sel = compound.getInteger("SelectedTexture");
		isexternal = compound.getBoolean("IsTextureExternal");
		url = isexternal ? compound.getString("CustomTexture") : null;
		custom = isexternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
		ItemStackHelper.loadAllItems(compound, stacks);
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
	
}