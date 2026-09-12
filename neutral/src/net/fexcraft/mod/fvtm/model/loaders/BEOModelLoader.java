package net.fexcraft.mod.fvtm.model.loaders;

import net.fexcraft.lib.frl.*;
import net.fexcraft.lib.tmt.*;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.FvtmResources.InputStreamWithFallback;
import net.fexcraft.mod.fvtm.model.*;

import static net.fexcraft.lib.common.Static.sixteenth;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BEOModelLoader implements ModelLoader {
	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("bob") || suffix.equals("beo");
	}

	@Override
	public boolean load(String loc, ModelData confdata, DefaultModel model) throws Exception {
		InputStreamWithFallback iswf = FvtmResources.getAssetInputStreamWithFallback(loc);
		CompactModel cm = CompactParserBEO.parse(iswf.stream(), sixteenth, false);
		if(cm.name != null) model.name = cm.name;
		if(cm.authors != null) cm.authors.forEach(a -> model.addToCreators(a));
		for(CompactModel.CompactGroup value : cm.groups.values()){
			ModelGroup group = new ModelGroup(value.name);
			model.groups.add(group);
			group.addAll(value.polyhedrons);
		}
		iswf.close();
		return true;
	}

}
