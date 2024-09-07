package net.fexcraft.mod.fvtm.sys.tsign;

import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public interface TrafficSigns {

	public NBTTagCompound write(EnumFacing side);

	public void read(EnumFacing side, NBTTagCompound compound);

	public ItemStack signToItem(BlockPos position);

	public Map<BlockPos, TrafficSignData> getSigns();

	public TrafficSignData getSign(BlockPos pos);

	public TrafficSignData getSign(int x, int y, int z);

	public TrafficSignData remove(BlockPos pos);

	public void addSignAt(BlockPos pos, float rot, float off, boolean client);

}
