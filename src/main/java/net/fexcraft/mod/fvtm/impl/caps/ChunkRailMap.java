package net.fexcraft.mod.fvtm.impl.caps;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ChunkRailMap implements ICapabilitySerializable<NBTTagCompound>{
	
	@CapabilityInject(CKRailMap.class)
	public static final Capability<CKRailMap> CAPABILITY = null;
	private CKRailMap instance;
	
	public ChunkRailMap(ItemStack stack){
		//TODO
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
	public NBTTagCompound serializeNBT(){
		return (NBTTagCompound)CAPABILITY.getStorage().writeNBT(CAPABILITY, instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt){
		CAPABILITY.getStorage().readNBT(CAPABILITY, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<CKRailMap> {

		@Override
		public NBTBase writeNBT(Capability<CKRailMap> capability, CKRailMap instance, EnumFacing side){
			return new NBTTagCompound();
		}

		@Override
		public void readNBT(Capability<CKRailMap> capability, CKRailMap instance, EnumFacing side, NBTBase nbt){
			//
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<CKRailMap> {

		@Override
		public CKRailMap call() throws Exception {
			return new Implementation();
		}
		
	}
	
	public static interface CKRailMap {

		//
		
	}
	
	public static class Implementation implements CKRailMap {
		
	}

}
