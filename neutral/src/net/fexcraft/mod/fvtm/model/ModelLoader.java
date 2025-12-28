package net.fexcraft.mod.fvtm.model;

import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface ModelLoader {

	public boolean accepts(String name, String suffix);

	/**
	 * @param loc the model address/resourcelocation
	 * @param data existing model data from config
	 * @return if the loading was successful
	 */
	public boolean load(String loc, ModelData data, DefaultModel model) throws Exception;

}
