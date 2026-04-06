package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RenderUtil {

	public static RenderUtil RENDER_UTIL = new RenderUtil();

	public void render(Model model, ModelRenderData mdata){
		for(ModelGroup group : model.getGroups()){
			render(group, mdata);
		}
	}

	public void render(ModelGroup group, ModelRenderData mdata){
		group.pre(mdata);
		if(group.visible) render(group);
		group.post(mdata);
	}

	public void render(ModelGroup group){
		group.render();
	}

	public void render(Polyhedron poly){
		poly.render();
	}

}
