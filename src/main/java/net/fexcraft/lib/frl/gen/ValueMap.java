package net.fexcraft.lib.frl.gen;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class ValueMap extends HashMap<String, Object> {

	public boolean has(String key){
		return containsKey(key);
	}

	public <T> void addArray(String key, Class<T> clazz){
		put(key, new ArrayList<T>());
	}

	public <T> ArrayList<T> getArray(String key, int size, T def){
		if(!containsKey(key)){
			ArrayList<T> list = new ArrayList<>();
			for(int i = 0; i < size; i++) list.add(def);
			put(key, list);
		}
		return (ArrayList<T>)get(key);
	}

	public <T> ArrayList<T> getArray(String key){
		return (ArrayList<T>)get(key);
	}

	public <T> ArrayList<T> getArray(String key, Class<T> clazz){
		return (ArrayList<T>)get(key);
	}
	
	public <T> T getValue(String key){
		return (T)get(key);
	}
	
	public <T> T getValue(String key, T def){
		return containsKey(key) ? (T)get(key) : def;
	}

}
