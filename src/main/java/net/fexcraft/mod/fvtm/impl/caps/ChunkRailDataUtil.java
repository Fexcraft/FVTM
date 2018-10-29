package net.fexcraft.mod.fvtm.impl.caps;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ChunkRailDataUtil implements ICapabilitySerializable<NBTBase>{
	
	@CapabilityInject(ChunkRailData.class)
	public static final Capability<ChunkRailData> CAPABILITY = null;
	private ChunkRailData instance;
	
	public ChunkRailDataUtil(Chunk chunk){
		(instance = CAPABILITY.getDefaultInstance()).setChunk(chunk);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == CAPABILITY ? CAPABILITY.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return CAPABILITY.getStorage().writeNBT(CAPABILITY, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		CAPABILITY.getStorage().readNBT(CAPABILITY, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<ChunkRailData> {

		@Override
		public NBTBase writeNBT(Capability<ChunkRailData> capability, ChunkRailData instance, EnumFacing side){
			//TODO
			return new NBTTagCompound();
		}

		@Override
		public void readNBT(Capability<ChunkRailData> capability, ChunkRailData instance, EnumFacing side, NBTBase nbt){
			//TODO
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<ChunkRailData> {

		@Override
		public ChunkRailData call() throws Exception {
			return new Implementation();
		}
		
	}
	
	public static interface ChunkRailData {

		public void setChunk(Chunk chunk);
		
		public Chunk getChunk();
		
	}
	
	public static class Implementation implements ChunkRailData {
		
		private Chunk chunk;

		@Override
		public void setChunk(Chunk chunk){
			this.chunk = chunk;
		}

		@Override
		public Chunk getChunk(){
			return chunk;
		}
		
	}

}
