package net.fexcraft.mod.fvtm.impl.caps;

import net.fexcraft.mod.fvtm.api.Resources;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import static net.fexcraft.mod.fvtm.api.Resources.CAPABILITY;

public class WorldResourcesUtil implements ICapabilitySerializable<NBTBase>{
	
	private Resources instance;
	
	public WorldResourcesUtil(World world){
		(instance = CAPABILITY.getDefaultInstance()).setWorld(world);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == CAPABILITY ? CAPABILITY.cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return CAPABILITY.getStorage().writeNBT(CAPABILITY, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		CAPABILITY.getStorage().readNBT(CAPABILITY, instance, null, nbt);
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
