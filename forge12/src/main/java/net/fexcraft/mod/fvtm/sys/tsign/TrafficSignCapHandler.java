package net.fexcraft.mod.fvtm.sys.tsign;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class TrafficSignCapHandler implements ICapabilitySerializable<NBTBase> {

	public static final String REGNAME = "fvtm:trafficsigns";
	private TrafficSignCapability instance;
	
	public TrafficSignCapHandler(Chunk chunk){
		instance = new TrafficSignCapability().setChunk(chunk);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.TRAFFIC_SIGNS;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.TRAFFIC_SIGNS ? Capabilities.TRAFFIC_SIGNS.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return Capabilities.TRAFFIC_SIGNS.getStorage().writeNBT(Capabilities.TRAFFIC_SIGNS, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		Capabilities.TRAFFIC_SIGNS.getStorage().readNBT(Capabilities.TRAFFIC_SIGNS, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<TrafficSigns> {

		@Override
		public NBTBase writeNBT(Capability<TrafficSigns> capability, TrafficSigns instance, EnumFacing side){
			return instance.write(side);
		}

		@Override
		public void readNBT(Capability<TrafficSigns> capability, TrafficSigns instance, EnumFacing side, NBTBase nbt){
			if(nbt instanceof NBTTagCompound){
				instance.read(side, (NBTTagCompound)nbt);
			}
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<TrafficSigns> {

		@Override
		public TrafficSigns call() throws Exception {
			return new TrafficSignCapability();
		}
		
	}

}
