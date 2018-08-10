package net.fexcraft.mod.fvtm.model;

import java.util.TreeMap;

import net.fexcraft.mod.lib.fmr.ModelCompound;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

@SuppressWarnings("serial")
public class ModelMap<T> extends TreeMap<String, T> {
	
	private static final ModelRendererTurbo[] empty_arr = new ModelRendererTurbo[]{};
	private static final ModelCompound empty_model = new ModelCompound();
	private static Object temp; private final boolean fmr;
	
	public ModelMap(boolean bool){ fmr = bool; }
	
	@SuppressWarnings("unchecked") @Override
	public T get(Object key){
		temp = super.get(key);
		return temp == null ? fmr ? (T)empty_model : (T)empty_arr : (T)temp;
	}
	
}