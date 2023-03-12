package net.fexcraft.mod.fvtm.data.inv;

import net.minecraft.nbt.NBTTagCompound;

public class InvHandlerVar extends InvHandler {
	
	protected int value;
	protected String category, conid;

	public InvHandlerVar(String arg, int cap){
		super(InvType.VARIABLE);
		String[] str = arg.split(":");
		conid = str[0];
		category = str.length > 1 ? str[1] : "fluid";
		capacity = cap;
	}

	public NBTTagCompound save(NBTTagCompound compound, String ctag){
		compound.setInteger(ctag, value());
		return compound;
	}

	public void load(NBTTagCompound compound, String ctag){
		value = compound.getInteger(ctag);
	}

	@Override
	public int getVarValue(){
		return value;
	}

	@Override
	public void setVarValue(int i){
		value = i;
	}

	public int value(){
		return value;
	}

	public void value(int i){
		value = i;
	}
	
	public void shrink(int by){
		value -= by;
	}
	
	public void shrink(){
		value--;
	}
	
	public void grow(int by){
		value += by;
	}
	
	public void grow(){
		value++;
	}

	@Override
	public Object getCapObj(){
		return value;
	}

}
