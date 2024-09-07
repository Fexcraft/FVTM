package net.fexcraft.mod.fvtm.model;

import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.RenderCache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RenderCacheI implements RenderCache {

	protected LinkedHashMap<Program, Object> objects = new LinkedHashMap<>();

	public RenderCacheI(){}

	@Override
	public Map<Program, Object> map(){
		return objects;
	}

	@Override
	public <V> V get(Program prog){
		return (V)objects.get(prog);
	}

	@Override
	public <V> V get(Program prog, Function<ModelRenderData, V> def){
		V obj = (V)objects.get(prog);
		if(obj == null){
			objects.put(prog, obj = def.apply(DefaultModel.RENDERDATA));
		}
		return obj;
	}

	@Override
	public <V> V set(Program prog, V value){
		if(value == null){
			objects.remove(prog);
			return null;
		}
		return (V)objects.put(prog, value);
	}

}
