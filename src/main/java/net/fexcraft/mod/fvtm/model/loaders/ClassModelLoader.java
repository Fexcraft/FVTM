package net.fexcraft.mod.fvtm.model.loaders;

import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.Model.ModelLoader;

public class ClassModelLoader implements ModelLoader {

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals(suffix);
	}

	@Override
	public Object[] load(String name, ModelData confdata) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clasz = Class.forName(name.replace(".class", ""));
		return new Object[]{ clasz.newInstance() };
	}

}
