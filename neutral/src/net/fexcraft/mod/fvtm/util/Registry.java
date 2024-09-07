package net.fexcraft.mod.fvtm.util;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.uni.IDL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Registry<Type extends Content<Type>> extends ArrayList<Type> {

	public void register(Type type){
		add(type);
	}

	public void register(Object o){
		add((Type)o);
	}

	public Type get(IDL idl){
		for(Type type : this) if(type.getID().equals(idl)) return type;
		return null;
	}

	public Type get(String regname){
		for(Type type : this) if(type.getID().colon().equals(regname)) return type;
		return null;
	}

}
