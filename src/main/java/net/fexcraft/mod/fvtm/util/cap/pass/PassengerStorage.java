package net.fexcraft.mod.fvtm.util.cap.pass;

import net.fexcraft.mod.fvtm.data.Passenger;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PassengerStorage implements IStorage<Passenger> {

	@Override
	public NBTBase writeNBT(Capability<Passenger> capability, Passenger instance, EnumFacing side) {
		NBTTagCompound com = new NBTTagCompound();
		if (instance.seat() > -1) {
			com.setInteger("seat", instance.seat());
		}
		return com;
	}

	@Override
	public void readNBT(Capability<Passenger> capability, Passenger instance, EnumFacing side, NBTBase nbt) {
		NBTTagCompound com = (NBTTagCompound) nbt;
		if (com.isEmpty()) return;
		instance.set(-1, com.getInteger("seat"));
	}

}
