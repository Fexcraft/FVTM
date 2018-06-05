package net.fexcraft.mod.fvtm.model;

import java.util.TreeMap;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

@SuppressWarnings("serial")
public class ModelMap extends TreeMap<String, ModelRendererTurbo[]> {
	
	private static final ModelRendererTurbo[] empty_arr = new ModelRendererTurbo[]{};
	private static ModelRendererTurbo[] temp;
	
	@Override
	public ModelRendererTurbo[] get(Object key){
		temp = super.get(key);
		return temp == null ? empty_arr : temp;
	}
	
}