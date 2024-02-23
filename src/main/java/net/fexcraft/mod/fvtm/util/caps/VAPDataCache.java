package net.fexcraft.mod.fvtm.util.caps;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ContainerItem;
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
		else if(stack.getItem() instanceof BlockItem){
			instance = new BlockImplementation();
		}
		else if(stack.getItem() instanceof ContainerItem){
			instance = new ContainerImplementation();
		}
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
		private ContainerData condata;
		private BlockData bdata;
		boolean[] bools = new boolean[3];

		@Override
		public void setStack(ItemStack stack){
			this.stack = stack;
			bools[0] = stack.getItem() instanceof VehicleItem;
			bools[1] = stack.getItem() instanceof PartItem;
			bools[2] = stack.getItem() instanceof BlockItem;
		}

		@Override
		public VehicleData getVehicleData(){
			return vdata == null ? vdata = ((VehicleItem)stack.getItem()).getDataFromTag(stack.getTagCompound()) : vdata;
		}

		@Override
		public PartData getPartData(){
			return pdata == null ? pdata = ((PartItem)stack.getItem()).getDataFromTag(stack.getTagCompound()) : pdata;
		}

		@Override
		public ContainerData getContainerData(){
			return condata == null ? condata = ((ContainerItem)stack.getItem()).getDataFromTag(stack.getTagCompound()) : condata;
		}

		@Override
		public BlockData getBlockData(){
			return bdata == null ? bdata = ((BlockItem)stack.getItem()).getDataFromTag(stack.getTagCompound()) : bdata;
		}

		@Override
		public boolean overridesLang(boolean bool){
			return false;
		}
		
	}
	
	public static class VehicleImplementation implements VehicleAndPartDataCache {
		
		private ItemStack stack;
		private VehicleData data;
		private boolean override;

		@Override
		public void setStack(ItemStack stack){
			this.stack = stack;
		}

		@Override
		public VehicleData getVehicleData(){
			return data == null ? stack == null ? null : (data = ((VehicleItem)stack.getItem()).getDataFromTag(stack.getTagCompound())) : data;
		}

		@Override
		public PartData getPartData(){
			return null;
		}

		@Override
		public ContainerData getContainerData(){
			return null;
		}

		@Override
		public BlockData getBlockData(){
			return null;
		}

		@Override
		public boolean overridesLang(boolean bool){
			if(bool) override = true;
			return override;
		}
		
	}
	
	public static class PartImplementation implements VehicleAndPartDataCache {
		
		private ItemStack stack;
		private PartData data;
		private boolean override;

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
			return data == null ? stack == null ? null : (data = ((PartItem)stack.getItem()).getDataFromTag(stack.getTagCompound())) : data;
		}

		@Override
		public ContainerData getContainerData(){
			return null;
		}

		@Override
		public BlockData getBlockData(){
			return null;
		}

		@Override
		public boolean overridesLang(boolean bool){
			if(bool) override = true;
			return override;
		}
		
	}
	
	public static class BlockImplementation implements VehicleAndPartDataCache {
		
		private ItemStack stack;
		private BlockData data;
		private boolean override;

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
			return data == null ? stack == null ? null : (data = ((BlockItem)stack.getItem()).getDataFromTag(stack.getTagCompound())) : data;
		}

		@Override
		public ContainerData getContainerData(){
			return null;
		}

		@Override
		public boolean overridesLang(boolean bool){
			if(bool) override = true;
			return override;
		}
		
	}
	
	public static class ContainerImplementation implements VehicleAndPartDataCache {
		
		private ItemStack stack;
		private ContainerData data;
		private boolean override;

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
		public ContainerData getContainerData(){
			return data == null ? stack == null ? null : (data = ((ContainerItem)stack.getItem()).getDataFromTag(stack.getTagCompound())) : data;
		}

		@Override
		public BlockData getBlockData(){
			return null;
		}

		@Override
		public boolean overridesLang(boolean bool){
			if(bool) override = true;
			return override;
		}
		
	}

}
