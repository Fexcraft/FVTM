package net.fexcraft.mod.fvtm.model;

import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface ModelLoader {

	public boolean accepts(String name, String suffix);

	/**
	 * @param name     the model address/resourcelocation
	 * @param data existing model data from config
	 * @return the model, with optionally a (updated or overridden) ModelData object on 2nd index
	 */
	public Object[] load(String name, ModelData data, Supplier<Model> supplier) throws Exception;

}
