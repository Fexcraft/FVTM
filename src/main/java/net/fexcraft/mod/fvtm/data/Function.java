package net.fexcraft.mod.fvtm.data;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Ferdinand Calo' (FEX___96)
 *
 * <br><i>Part Function</i>
 */
public abstract class Function {
	
	public Function(@Nullable JsonObject obj){}
	
	public abstract Function read(NBTTagCompound compound);
	
	public abstract NBTTagCompound write(NBTTagCompound compound);

	public abstract String getId();
	
	/** Used to crease an use-copy from the "default" function storage in a Part. */
	public abstract Function copy();

}
