package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.minecraft.nbt.*;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TagLWI implements TagLW {

	private NBTTagList list;

	public TagLWI(){
		list = new NBTTagList();
	}

	public TagLWI(NBTTagList ls){
		list = ls;
	}

	@Override
	public String getString(int idx){
		return list.getStringTagAt(idx);
	}

	@Override
	public float getFloat(int idx){
		return list.getFloatAt(idx);
	}

	@Override
	public double getDouble(int idx){
		return list.getDoubleAt(idx);
	}

	@Override
	public int getInteger(int idx){
		return list.getIntAt(idx);
	}

	@Override
	public TagCW getCompound(int idx){
		return new TagCWI(list.getCompoundTagAt(idx));
	}

	@Override
	public void add(String value){
		list.appendTag(new NBTTagString(value));
	}

	@Override
	public void add(float value){
		list.appendTag(new NBTTagFloat(value));
	}

	@Override
	public void add(double value){
		list.appendTag(new NBTTagDouble(value));
	}

	@Override
	public void add(int value){
		list.appendTag(new NBTTagInt(value));
	}

	@Override
	public void add(TagCW value){
		list.appendTag(value.local());
	}

	@Override
	public int size(){
		return list.tagCount();
	}

	@Override
	public void forEach(Consumer<? super TagCW> cons){
		for(NBTBase base : list){
			if(base instanceof NBTTagCompound == false) continue;
			cons.accept(TagCW.wrap(base));
		}
	}

	@Override
	public Iterator<TagCW> iterator(){
		return new Iterator<TagCW>(){
			int idx;
			@Override
			public boolean hasNext(){
				return idx < list.tagCount();
			}
			@Override
			public TagCW next(){
				NBTBase base = list.get(idx++);
				if(base instanceof NBTTagCompound == false) return null;
				return TagCW.wrap(base);
			}
		};
	}

	@Override
	public <C> C local(){
		return (C)list;
	}

	@Override
	public Object direct(){
		return list;
	}

	@Override
	public boolean empty(){
		return list == null || list.isEmpty();
	}

	@Override
	public String toString(){
		return list == null ? "null" : list.toString();
	}

}
