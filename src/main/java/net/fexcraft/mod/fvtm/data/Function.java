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
	
	public static abstract class StaticFuntion extends Function {

		public StaticFuntion(JsonObject obj){ super(obj); }

		@Override /** Do not read anything. */
		public Function read(NBTTagCompound compound){ return this; }

		@Override /** Do not write anything. */
		public NBTTagCompound write(NBTTagCompound compound){ return null; }

		@Override /** Return self because we don't need copies. */
		public Function copy(){ return this; }
		
	}

}
