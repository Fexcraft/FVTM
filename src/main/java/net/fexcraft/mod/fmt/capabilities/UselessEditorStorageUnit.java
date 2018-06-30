package net.fexcraft.mod.fmt.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class UselessEditorStorageUnit implements IStorage<EditorPlayerDataContainerCapability> {

	@Override
	public NBTBase writeNBT(Capability<EditorPlayerDataContainerCapability> capability, EditorPlayerDataContainerCapability instance, EnumFacing side){
		return new NBTTagCompound();
	}

	@Override
	public void readNBT(Capability<EditorPlayerDataContainerCapability> capability, EditorPlayerDataContainerCapability instance, EnumFacing side, NBTBase nbt){
		//Currently, do nothing.
	}

}