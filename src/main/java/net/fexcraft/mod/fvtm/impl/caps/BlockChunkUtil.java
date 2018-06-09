package net.fexcraft.mod.fvtm.impl.caps;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class BlockChunkUtil implements ICapabilitySerializable<NBTBase> {
	
	public static final ResourceLocation REGISTRY_NAME = new ResourceLocation("fvtm:chunk");
	private BlockChunk instance;
	//
	@CapabilityInject(BlockChunk.class)
	public static final Capability<BlockChunk> CAPABILITY = null;
	
	public BlockChunkUtil(Chunk chunk){
		instance = CAPABILITY.getDefaultInstance();
		instance.setChunk(chunk);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability == CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return hasCapability(capability, facing) ? CAPABILITY.cast(instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return CAPABILITY.getStorage().writeNBT(CAPABILITY, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		CAPABILITY.getStorage().readNBT(CAPABILITY, instance, null, nbt);
	}
	
    public static class Storage implements IStorage<BlockChunk> {
        
        @Override
        public NBTBase writeNBT(Capability<BlockChunk> capability, BlockChunk instance, EnumFacing side){
            return instance.writeToNBT(capability, instance, side);
        }
        
        @Override
        public void readNBT(Capability<BlockChunk> capability, BlockChunk instance, EnumFacing side, NBTBase nbt){
            instance.readFromNBT(capability, instance, side, nbt);
        }
        
    }
    
    public static class Callable implements java.util.concurrent.Callable<BlockChunk>{
        
        @Override
        public BlockChunk call() throws Exception {
            return new BlockChunkImplementation();
        }
    
    }
	
}