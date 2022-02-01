package net.fexcraft.mod.fvtm.sys.tsign;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

public interface TrafficSigns {

	public NBTBase write(EnumFacing side);

	public void read(EnumFacing side, NBTTagCompound compound);

	public void sync(boolean side);

}
