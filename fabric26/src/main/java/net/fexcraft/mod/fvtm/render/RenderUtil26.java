package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fvtm.model.*;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;

import static net.fexcraft.mod.fcl.util.Renderer21.REN_IN;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RenderUtil26 {

	public static void render(Model model, ModelRenderData mdata, PoseStack pose, RenderType type, SubmitNodeCollector nodecoll, int lc){
		REN_IN.stack = pose;
		for(ModelGroup group : model.getGroups()){
			render(group, mdata, pose, type, nodecoll, lc);
		}
	}

	public static void render(ModelGroup group, ModelRenderData mdata, PoseStack pose, RenderType type, SubmitNodeCollector nodecoll, int lc){
		REN_IN.stack = pose;
		REN_IN.type = type;
		REN_IN.light = lc;
		group.pre(mdata);
		nodecoll.submitCustomGeometry(pose, type, (last, cons) -> {
			REN_IN.pose = last;
			REN_IN.cons = cons;
			group.render();
			REN_IN.pose = null;
		});
		group.post(mdata);
	}

	public static void render(Polyhedron poly, PoseStack pose, RenderType type, SubmitNodeCollector nodecoll, int lc){
		REN_IN.stack = pose;
		REN_IN.type = type;
		REN_IN.light = lc;
		nodecoll.submitCustomGeometry(pose, type, (last, cons) -> {
			REN_IN.pose = last;
			REN_IN.cons = cons;
			REN_IN.render(poly);
			REN_IN.pose = null;
		});
	}

}
