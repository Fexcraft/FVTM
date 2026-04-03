package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fcl.util.Renderer21;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;

import static net.fexcraft.lib.frl.Renderer.RENDERER;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RenderUtil26 {

	private static SubmitNodeCollector noco;

	public static void set(PoseStack pose, SubmitNodeCollector nocoll, RenderType type, int lc){
		Renderer21.stack = pose;
		noco = nocoll;
		Renderer21.type = type;
		Renderer21.light = lc;
	}

	public static void type(RenderType type){
		Renderer21.type = type;
	}

	public static void render(Model model, ModelRenderData mdata){
		for(ModelGroup group : model.getGroups()){
			render(group, mdata);
		}
	}

	public static void render(ModelGroup group, ModelRenderData mdata){
		group.pre(mdata);
		noco.submitCustomGeometry(Renderer21.stack, Renderer21.type, (last, cons) -> {
			Renderer21.pose = last;
			Renderer21.cons = cons;
			group.render();
			Renderer21.pose = null;
		});
		group.post(mdata);
	}

	public static void render(Polyhedron poly){
		noco.submitCustomGeometry(Renderer21.stack, Renderer21.type, (last, cons) -> {
			Renderer21.pose = last;
			Renderer21.cons = cons;
			RENDERER.render(poly);
			Renderer21.pose = null;
		});
	}

	public static void renderSphere(float scale, int col){
		Renderer21.type = FvtmRenderTypes.white();
		Renderer21.stack.pushPose();
		Renderer21.stack.scale(scale, scale, scale);
		noco.submitCustomGeometry(Renderer21.stack, FvtmRenderTypes.white(), (last, cons) -> {
			RENDERER.color(col);
			Renderer21.pose = last;
			Renderer21.cons = cons;
			RENDERER.render(DebugUtils.SPHERE);
			Renderer21.pose = null;
			Renderer21.resetColor();
		});
		Renderer21.stack.popPose();
	}

}
