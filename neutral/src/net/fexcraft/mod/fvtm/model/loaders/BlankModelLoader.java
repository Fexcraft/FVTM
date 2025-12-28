package net.fexcraft.mod.fvtm.model.loaders;

import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.ModelLoader;

import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlankModelLoader implements ModelLoader {

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("blank");
	}

	@Override
	public boolean load(String loc, ModelData confdata, DefaultModel model) throws Exception {
		return true;
	}

}
