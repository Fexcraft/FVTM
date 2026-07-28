package net.fexcraft.mod.fvtm.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 * Object to hold temporary animation data.
 */
public class RenderCache {

	protected LinkedHashMap<Program, Object> objects = new LinkedHashMap<>();
	protected int light;

	public Map<Program, Object> map(){
		return objects;
	}

	/** Gets an object if present, else returns null. */
	public <V> V get(Program prog){
		return (V)objects.get(prog);
	}

	/** Returns a new default object if entry is missing. */
	public <V> V get(Program prog, Function<ModelRenderData, V> def){
		V obj = (V)objects.get(prog);
		if(obj == null){
			objects.put(prog, obj = def.apply(DefaultModel.RENDERDATA));
		}
		return obj;
	}

	/** Set object to `null` to remove the entry. Otherwise, it updates the cache. */
	public <V> V set(Program prog, V value){
		if(value == null){
			objects.remove(prog);
			return null;
		}
		return (V)objects.put(prog, value);
	}

	public int light(){
		return light;
	}

	public RenderCache light(int i){
		light = i;
		return this;
	}

}