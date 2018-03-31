package net.fexcraft.mod.fvtm.api.root;

import net.minecraft.nbt.NBTTagCompound;

public interface Saveloadable<T> {
	
	public NBTTagCompound writeToNBT(NBTTagCompound compound);
	
	public T readFromNBT(NBTTagCompound compound);
	
}