package net.fexcraft.mod.fvtm.impl.caps;

import net.fexcraft.mod.fvtm.api.capability.FVTMCaps;
import net.fexcraft.mod.fvtm.api.capability.Resources;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class WorldResourcesUtil implements ICapabilitySerializable<NBTBase>{
	
	private Resources instance;
	
	public WorldResourcesUtil(World world){
		(instance = FVTMCaps.RESOURCES.getDefaultInstance()).setWorld(world);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == FVTMCaps.RESOURCES;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == FVTMCaps.RESOURCES ? FVTMCaps.RESOURCES.cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return FVTMCaps.RESOURCES.getStorage().writeNBT(FVTMCaps.RESOURCES, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		FVTMCaps.RESOURCES.getStorage().readNBT(FVTMCaps.RESOURCES, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<Resources> {

		@Override
		public NBTBase writeNBT(Capability<Resources> capability, Resources instance, EnumFacing side){
			return new NBTTagCompound();
		}

		@Override
		public void readNBT(Capability<Resources> capability, Resources instance, EnumFacing side, NBTBase nbt){
			//
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<Resources> {

		@Override
		public Resources call() throws Exception {
			return new WorldResources();
		}
		
	}

}
