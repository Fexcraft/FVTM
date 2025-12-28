package net.fexcraft.mod.fvtm.model.loaders;

import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.function.Supplier;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.FvtmResources.InputStreamWithFallback;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.FMFParser;
import net.fexcraft.mod.fvtm.model.Model;
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
	public Object[] load(String name, ModelData confdata, Supplier<Model> supplier) throws Exception {
		InputStreamWithFallback iswf = FvtmResources.getAssetInputStreamWithFallback(name);
		Model model = supplier.get();
		JsonHandler.wrap(FMFParser.parse((DefaultModel)model, iswf.stream()), confdata);
		iswf.close();
		return new Object[]{ model, confdata };
	}

}
