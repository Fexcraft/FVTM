package net.fexcraft.mod.fvtm.util.cap.pass;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PassengerSerializer implements ICapabilitySerializable<NBTBase>{
	
	private PassengerImplementation instance;
	
	public PassengerSerializer(Entity entity){
		(instance = (PassengerImplementation)Capabilities.PASSENGER.getDefaultInstance()).set(entity);
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

}
