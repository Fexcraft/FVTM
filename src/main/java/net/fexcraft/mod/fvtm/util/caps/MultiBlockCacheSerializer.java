package net.fexcraft.mod.fvtm.util.caps;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.MultiBlockCache;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiBlockCacheSerializer implements ICapabilitySerializable<NBTBase>{
	
	private MultiBlockCache instance;
	
	public MultiBlockCacheSerializer(World world){
		(instance = Capabilities.MULTIBLOCKS.getDefaultInstance()).setWorld(world);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.MULTIBLOCKS;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.MULTIBLOCKS ? Capabilities.MULTIBLOCKS.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return Capabilities.MULTIBLOCKS.getStorage().writeNBT(Capabilities.MULTIBLOCKS, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		Capabilities.MULTIBLOCKS.getStorage().readNBT(Capabilities.MULTIBLOCKS, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<MultiBlockCache> {

		@Override
		public NBTBase writeNBT(Capability<MultiBlockCache> capability, MultiBlockCache instance, EnumFacing side){
			return new NBTTagByte((byte)0);
		}

		@Override
		public void readNBT(Capability<MultiBlockCache> capability, MultiBlockCache instance, EnumFacing side, NBTBase nbt){
			//
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<MultiBlockCache> {

		@Override
		public MultiBlockCache call() throws Exception {
			return new Implementation();
		}
		
	}
	
	public static class Implementation implements MultiBlockCache {
		
		@SuppressWarnings("unused")
		private World world;
		private HashMap<BlockPos, MultiBlockData> blocks = new HashMap<>();
		private HashMap<BlockPos, BlockPos> cores = new HashMap<>(); 

		@Override
		public void setWorld(World world){
			this.world = world;
		}

		@Override
		public void registerMultiBlock(BlockPos posfrom, EnumFacing rotation, MultiBlockData data){
			ArrayList<V3I> positions = data.getType().getPositions(new V3I(posfrom.getX(), posfrom.getY(), posfrom.getZ()), WrapperHolder.getSide(rotation));
			for(V3I vec : positions){
				BlockPos pos = new BlockPos(vec.x, vec.y, vec.z);
				blocks.put(pos, data);
				cores.put(pos, posfrom);
			}
		}

		@Override
		public void unregisterMultiBlock(BlockPos posfrom, EnumFacing rotation, MultiBlockData data){
			ArrayList<V3I> positions = data.getType().getPositions(new V3I(posfrom.getX(), posfrom.getY(), posfrom.getZ()), WrapperHolder.getSide(rotation));
			for(V3I vec : positions){
				BlockPos pos = new BlockPos(vec.x, vec.y, vec.z);
				blocks.remove(pos, data);
				cores.remove(pos, posfrom);
			}
		}

		@Override
		public MultiBlockData getMultiBlock(BlockPos pos){
			return blocks.get(pos);
		}

		@Override
		public BlockPos getMultiBlockCore(BlockPos pos){
			return cores.get(pos);
		}
		
	}

}
