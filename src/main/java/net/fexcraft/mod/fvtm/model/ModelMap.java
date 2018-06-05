package net.fexcraft.mod.fvtm.model;

import java.util.TreeMap;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

@SuppressWarnings("serial")
public class ModelMap extends TreeMap<String, ModelRendererTurbo[]> {
	
	private static final ModelRendererTurbo[] empty_arr = new ModelRendererTurbo[]{};
	
	@Override
	public ModelRendererTurbo[] get(Object key){
		ModelRendererTurbo[] mrt = super.get(key);
		return mrt == null ? empty_arr : mrt;
	}
	
}