package net.fexcraft.mod.fvtm.sys.tsign;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public interface TrafficSigns {

	public NBTBase write(EnumFacing side);

	public void read(EnumFacing side, NBTTagCompound compound);

	public void sync(boolean side);

	public ItemStack signToItem(BlockPos position);

}
