package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TagCWI implements TagCW {

	private NBTTagCompound compound;

	public TagCWI(){
		compound = new NBTTagCompound();
	}

	public TagCWI(NBTTagCompound com){
		compound = com;
	}

	@Override
	public String getString(String key){
		return compound.getString(key);
	}

	@Override
	public float getFloat(String key){
		return compound.getFloat(key);
	}

	@Override
	public int getInteger(String key){
		return compound.getInteger(key);
	}

	@Override
	public boolean getBoolean(String key){
		return compound.getBoolean(key);
	}

	@Override
	public boolean has(String key){
		return compound.hasKey(key);
	}

	@Override
	public void set(String key, String val){
		compound.setString(key, val);
	}

	@Override
	public void set(String key, float val){
		compound.setFloat(key, val);
	}

	@Override
	public void set(String key, int val){
		compound.setInteger(key, val);
	}

	@Override
	public void set(String key, boolean val){
		compound.setBoolean(key, val);
	}

	@Override
	public <C> C local(){
		return (C)compound;
	}

	@Override
	public Object direct(){
		return compound;
	}

}
