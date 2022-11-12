package net.fexcraft.mod.fvtm.data.inv;

import net.minecraft.nbt.NBTTagCompound;

public class InvHandlerVar extends InvHandler {
	
	protected int value;
	protected String id;

	public InvHandlerVar(InvType type, String arg, int cap){
		super(type);
		id = arg;
		capacity = cap;
	}

	public NBTTagCompound save(NBTTagCompound compound){
		compound.setInteger("Variable_" + id, value);
        return compound;
	}

	public void load(NBTTagCompound compound){
        value = compound.getInteger("Variable_" + id);
	}

}
