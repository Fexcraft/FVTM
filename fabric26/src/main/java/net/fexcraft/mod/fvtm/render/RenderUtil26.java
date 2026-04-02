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
		REN_IN.pose = pose;
		for(ModelGroup group : model.getGroups()){
			for(Polyhedron<GLObject> poly : group){
				REN_IN.transform(poly);
				nodecoll.submitCustomGeometry(pose, type, (last, buffer) -> REN_IN.render(poly, last, type, buffer, lc));
				pose.popPose();
			}
		}
	}

	public static void render(ModelGroup group, ModelRenderData mdata, PoseStack pose, RenderType type, SubmitNodeCollector nodecoll, int lc){
		REN_IN.pose = pose;
		for(Polyhedron<GLObject> poly : group){
			REN_IN.transform(poly);
			nodecoll.submitCustomGeometry(pose, type, (last, buffer) -> REN_IN.render(poly, last, type, buffer, lc));
			pose.popPose();
		}
	}

	public static void render(Polyhedron poly, PoseStack pose, RenderType type, SubmitNodeCollector nodecoll, int lc){
		REN_IN.pose = pose;
		REN_IN.transform(poly);
		nodecoll.submitCustomGeometry(pose, type, (last, buffer) -> REN_IN.render(poly, last, type, buffer, lc));
		pose.popPose();
	}

}
