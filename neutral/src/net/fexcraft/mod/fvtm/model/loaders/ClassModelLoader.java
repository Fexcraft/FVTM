package net.fexcraft.mod.fvtm.model.loaders;

import java.util.function.Supplier;

import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.ModelLoader;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ClassModelLoader implements ModelLoader {

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("class");
	}

	@Override
	public Object[] load(String name, ModelData confdata, Supplier<Model> supplier) throws Exception {
		Class<?> clasz = Class.forName(name.replace(".class", ""));
		return new Object[]{ clasz.newInstance() };
	}

}
