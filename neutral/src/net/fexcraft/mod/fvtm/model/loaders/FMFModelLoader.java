package net.fexcraft.mod.fvtm.model.loaders;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.FvtmResources.InputStreamWithFallback;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.FMFParser;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.ModelLoader;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FMFModelLoader implements ModelLoader {

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("fmf");
	}

	@Override
	public boolean load(String loc, ModelData confdata, DefaultModel model) throws Exception {
		InputStreamWithFallback iswf = FvtmResources.getAssetInputStreamWithFallback(loc);
		JsonHandler.wrap(FMFParser.parse((DefaultModel)model, iswf.stream()), confdata);
		iswf.close();
		return true;
	}

}
