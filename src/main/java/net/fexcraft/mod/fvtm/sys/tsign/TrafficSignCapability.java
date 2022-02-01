package net.fexcraft.mod.fvtm.sys.tsign;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class TrafficSignCapability implements TrafficSigns {
	
	private Chunk chunk;

	public TrafficSignCapability setChunk(Chunk chunk){
		this.chunk = chunk;
		return this;
	}

	@Override
	public NBTBase write(EnumFacing side){
		//
		return null;
	}

	@Override
	public void read(EnumFacing side, NBTTagCompound compound){
		//
	}

	@Override
	public void sync(boolean side){
		//
	}

	@Override
	public ItemStack signToItem(BlockPos position){
		//
		return null;
	}

}
