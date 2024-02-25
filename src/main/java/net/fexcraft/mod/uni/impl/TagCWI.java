package net.fexcraft.mod.uni.impl;

import java.util.ArrayList;
import java.util.Collection;

import net.fexcraft.mod.fvtm.data.block.RelayData;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

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

	public TagCWI(Object com){
		if(com instanceof NBTTagCompound){
			compound = (NBTTagCompound)com;
		}
		else compound = new NBTTagCompound();
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
	public double getDouble(String key){
		return compound.getDouble(key);
	}

	@Override
	public int getInteger(String key){
		return compound.getInteger(key);
	}

	@Override
	public long getLong(String key) {
		return compound.getLong(key);
	}

	@Override
	public boolean getBoolean(String key){
		return compound.getBoolean(key);
	}

	@Override
	public TagCW getCompound(String key){
		return new TagCWI(compound.getCompoundTag(key));
	}

	@Override
	public TagLW getList(String key){
		return new TagLWI((NBTTagList)compound.getTag(key));
	}

	@Override
	public int[] getIntArray(String key){
		return compound.getIntArray(key);
	}

	@Override
	public byte[] getByteArray(String key){
		return compound.getByteArray(key);
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
	public void set(String key, double val){
		compound.setDouble(key, val);
	}

	@Override
	public void set(String key, int val){
		compound.setInteger(key, val);
	}

	@Override
	public void set(String key, long val){
		compound.setLong(key, val);
	}

	@Override
	public void set(String key, boolean val){
		compound.setBoolean(key, val);
	}

	@Override
	public void set(String key, TagCW val){
		compound.setTag(key, val.local());
	}

	@Override
	public void set(String key, TagLW val){
		compound.setTag(key, val.local());
	}

	@Override
	public void set(String key, int[] val){
		compound.setIntArray(key, val);
	}

	@Override
	public void set(String key, byte[] val){
		compound.setByteArray(key, val);
	}

	@Override
	public int size(){
		return compound.getSize();
	}

	@Override
	public <C> C local(){
		return (C)compound;
	}

	@Override
	public Object direct(){
		return compound;
	}

	@Override
	public boolean empty(){
		return compound.isEmpty();
	}

	@Override
	public Collection<String> keys(){
		return new ArrayList<>(compound.getKeySet());
	}

	@Override
	public String toString(){
		return compound == null ? "null" : compound.toString();
	}

}
