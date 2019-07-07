package net.fexcraft.mod.fvtm.util.caps;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class VAPDataCache implements ICapabilitySerializable<NBTBase>{
	
	private VehicleAndPartDataCache instance;
	
	public VAPDataCache(ItemStack stack){
		//(instance = CAPABILITY.getDefaultInstance()).setStack(stack);
		if(stack.getItem() instanceof VehicleItem){
			instance = new VehicleImplementation();
		}
		else if(stack.getItem() instanceof PartItem){
			instance = new PartImplementation();
		}
		/*else if(stack.getItem() instanceof BlockItem){
			instance = new BlockImplementation();
		}*/
		//
		instance.setStack(stack);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.VAPDATA;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == Capabilities.VAPDATA ? Capabilities.VAPDATA.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return Capabilities.VAPDATA.getStorage().writeNBT(Capabilities.VAPDATA, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		Capabilities.VAPDATA.getStorage().readNBT(Capabilities.VAPDATA, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<VehicleAndPartDataCache> {

		@Override
		public NBTBase writeNBT(Capability<VehicleAndPartDataCache> capability, VehicleAndPartDataCache instance, EnumFacing side){
			return new NBTTagByte((byte)0);
		}

		@Override
		public void readNBT(Capability<VehicleAndPartDataCache> capability, VehicleAndPartDataCache instance, EnumFacing side, NBTBase nbt){
			//
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<VehicleAndPartDataCache> {

		@Override
		public VehicleAndPartDataCache call() throws Exception {
			return new Implementation();
		}
		
	}
	
	public static class Implementation implements VehicleAndPartDataCache {
		
		private ItemStack stack;
		private VehicleData vdata;
		private PartData pdata;
		//private BlockData bdata;
		boolean[] bools = new boolean[3];

		@Override
		public void setStack(ItemStack stack){
			this.stack = stack;
			bools[0] = stack.getItem() instanceof VehicleItem;
			bools[1] = stack.getItem() instanceof PartItem;
			//bools[2] = stack.getItem() instanceof BlockItem;
		}

		@Override
		public VehicleData getVehicleData(){
			return vdata == null ? vdata = ((VehicleItem)stack.getItem()).getData(stack) : vdata;
		}

		@Override
		public PartData getPartData(){
			return pdata == null ? pdata = ((PartItem)stack.getItem()).getData(stack) : pdata;
		}

		/*@Override
		public BlockData getBlockData(){
			return bdata == null ? bdata = ((BlockItem)stack.getItem()).getBlock(stack) : bdata;
		}*/
		
	}
	
	public static class VehicleImplementation implements VehicleAndPartDataCache {
		
		private ItemStack stack;
		private VehicleData data;

		@Override
		public void setStack(ItemStack stack){
			this.stack = stack;
		}

		@Override
		public VehicleData getVehicleData(){
			return data == null ? stack == null ? null : (data = ((VehicleItem)stack.getItem()).getData(stack)) : data;
		}

		@Override
		public PartData getPartData(){
			return null;
		}

		/*@Override
		public BlockData getBlockData(){
			return null;
		}*/
		
	}
	
	public static class PartImplementation implements VehicleAndPartDataCache {
		
		private ItemStack stack;
		private PartData data;

		@Override
		public void setStack(ItemStack stack){
			this.stack = stack;
		}

		@Override
		public VehicleData getVehicleData(){
			return null;
		}

		@Override
		public PartData getPartData(){
			return data == null ? stack == null ? null : (data = ((PartItem)stack.getItem()).getData(stack)) : data;
		}

		/*@Override
		public BlockData getBlockData(){
			return null;
		}*/
		
	}
	
	/*public static class BlockImplementation implements VehicleAndPartDataCache {
		
		private ItemStack stack;
		private BlockData data;

		@Override
		public void setStack(ItemStack stack){
			this.stack = stack;
		}

		@Override
		public VehicleData getVehicleData(){
			return null;
		}

		@Override
		public PartData getPartData(){
			return null;
		}

		@Override
		public BlockData getBlockData(){
			return data == null ? stack == null ? null : (data = ((BlockItem)stack.getItem()).getBlock(stack)) : data;
		}
		
	}*/

}
