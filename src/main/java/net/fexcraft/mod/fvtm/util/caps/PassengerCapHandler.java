package net.fexcraft.mod.fvtm.util.caps;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Passenger;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PassengerCapHandler implements ICapabilitySerializable<NBTBase>{
	
	private Implementation instance;
	
	public PassengerCapHandler(Entity entity){
		(instance = (Implementation)Capabilities.PASSENGER.getDefaultInstance()).set(entity);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability == Capabilities.PASSENGER;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability == Capabilities.PASSENGER ? Capabilities.PASSENGER.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return Capabilities.PASSENGER.getStorage().writeNBT(Capabilities.PASSENGER, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		Capabilities.PASSENGER.getStorage().readNBT(Capabilities.PASSENGER, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<Passenger> {

		@Override
		public NBTBase writeNBT(Capability<Passenger> capability, Passenger instance, EnumFacing side){
			NBTTagCompound com = new NBTTagCompound();
			if(instance.vehicle() > -1 && instance.seat() > -1){
				com.setInteger("seat", instance.seat());
			}
			return com;
		}

		@Override
		public void readNBT(Capability<Passenger> capability, Passenger instance, EnumFacing side, NBTBase nbt){
			NBTTagCompound com = (NBTTagCompound)nbt;
			if(com.isEmpty()) return;
			instance.set(-1, com.getInteger("seat"), false);
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<Passenger> {

		@Override
		public Passenger call() throws Exception {
			return new Implementation();
		}
		
	}
	
	public static class Implementation implements Passenger {
		
		private Entity entity;
		private int vehicle = -1, seatindex = -1;

		@Override
		public void set(int veh, int seat, boolean sync){
			vehicle = veh;
			seatindex = seat;
			if(sync){
				NBTTagCompound packet = new NBTTagCompound();
				packet.setString("target_listener", Resources.UTIL_LISTENER);
				packet.setString("task", "update_passenger");
				packet.setInteger("entity", entity.getEntityId());
				packet.setInteger("vehicle", vehicle);
				packet.setInteger("seat", seatindex);
				PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(packet), Resources.getTargetPoint(entity));
			}
		}

		public void set(Entity entity){
			this.entity = entity;
		}

		@Override
		public int vehicle(){
			return vehicle;
		}

		@Override
		public int seat(){
			return seatindex;
		}

		@Override
		public Entity entity(){
			return entity;
		}
		
	}

}
