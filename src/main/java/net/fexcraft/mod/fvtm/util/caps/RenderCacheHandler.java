package net.fexcraft.mod.fvtm.util.caps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class RenderCacheHandler implements ICapabilitySerializable<NBTBase>{
	
	private RenderCache instance;
	
	public RenderCacheHandler(){ instance = new Instance(); }

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.RENDERCACHE;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.RENDERCACHE ? Capabilities.RENDERCACHE.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return Capabilities.RENDERCACHE.getStorage().writeNBT(Capabilities.RENDERCACHE, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		Capabilities.RENDERCACHE.getStorage().readNBT(Capabilities.RENDERCACHE, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<RenderCache> {

		@Override
		public NBTBase writeNBT(Capability<RenderCache> capability, RenderCache instance, EnumFacing side){
			NBTTagCompound compound = new NBTTagCompound();
			instance.map().forEach((key, value) -> {
				compound.setFloat(key, value);
			}); return compound;
		}

		@Override
		public void readNBT(Capability<RenderCache> capability, RenderCache instance, EnumFacing side, NBTBase nbt){
			if(nbt == null || nbt instanceof NBTTagCompound == false) return;
			NBTTagCompound compound = (NBTTagCompound)nbt; if(compound.isEmpty()) return;
			for(String str : compound.getKeySet()){
				instance.set(str, compound.getFloat(str));
			}
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<RenderCache> {

		@Override
		public RenderCache call() throws Exception {
			return new Instance();
		}
		
	}
	
	public static class Instance implements RenderCache {
		
		protected LinkedHashMap<String, Float> cache = new LinkedHashMap<>();

		public Instance(){}

		@Override
		public Map<String, Float> map(){
			return cache;
		}

		@Override
		public Set<String> keys(){
			return cache.keySet();
		}

		@Override
		public Float get(String id){
			return cache.get(id);
		}

		@Override
		public Float get(String id, Float def){
			Float val = cache.get(id);
			return val == null ? def : val;
		}

		@Override
		public Float set(String id, Float value){
			if(id == null) return 0f;
			if(value == null) cache.remove(id);
			return cache.put(id, value);
		}
		
	}

}
