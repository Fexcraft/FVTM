package net.fexcraft.mod.fvtm.model.loaders;

import java.io.Closeable;
import java.io.InputStream;
import java.util.function.Supplier;

import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.Model.ModelLoader;
import net.fexcraft.mod.fvtm.model.FMFParser;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.util.ResourceLocation;

public class FMFModelLoader implements ModelLoader {

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("fmf");
	}

	@Override
	public Object[] load(String name, ModelData confdata, Supplier<Model> supp_model) throws Exception {
		Object[] stream = Resources.getModelInputStreamWithFallback(new ResourceLocation(name));
		Model model = supp_model.get();
		confdata.putAll(FMFParser.parse((GenericModel)model, (InputStream)stream[0]));
		if(stream.length > 1) for(Closeable c : (Closeable[])stream[1]) c.close();
		return new Object[]{ model, confdata };
	}

}
