package net.fexcraft.mod.fvtm.data.block;

import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public interface BlockScript {

	public void read(MultiBlockData data, NBTTagCompound tag);

	public NBTTagCompound write(MultiBlockData data, NBTTagCompound compound);

}
