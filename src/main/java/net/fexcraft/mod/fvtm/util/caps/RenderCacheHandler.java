package net.fexcraft.mod.fvtm.util.caps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
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
				//TODO compound.setFloat(key, value);
			});
			return compound;
		}

		@Override
		public void readNBT(Capability<RenderCache> capability, RenderCache instance, EnumFacing side, NBTBase nbt){
			if(nbt == null || nbt instanceof NBTTagCompound == false) return;
			NBTTagCompound compound = (NBTTagCompound)nbt;
			if(compound.isEmpty()) return;
			for(String str : compound.getKeySet()){
				//TODO instance.set(str, compound.getFloat(str));
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

		protected LinkedHashMap<Program, Object> objects = new LinkedHashMap<>();

		public Instance(){}

		@Override
		public Map<Program, Object> map(){
			return objects;
		}

		@Override
		public <V> V get(Program prog){
			return (V)objects.get(prog);
		}

		@Override
		public <V> V get(Program prog, Function<ModelRenderData, V> def){
			V obj = (V)objects.get(prog);
			if(obj == null){
				objects.put(prog, obj = def.apply(DefaultModel.RENDERDATA));
			}
			return obj;
		}

		@Override
		public <V> V set(Program prog, V value){
			if(value == null){
				objects.remove(prog);
				return null;
			}
			return (V)objects.put(prog, value);
		}
		
	}

}
