package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fcl.util.Renderer26;
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
		Renderer26.stack = pose;
		noco = nocoll;
		Renderer26.type = type;
		Renderer26.light = lc;
	}

	public static void type(RenderType type){
		Renderer26.type = type;
	}

	public static void render(Model model, ModelRenderData mdata){
		for(ModelGroup group : model.getGroups()){
			render(group, mdata);
		}
	}

	public static void render(ModelGroup group, ModelRenderData mdata){
		group.pre(mdata);
		noco.submitCustomGeometry(Renderer26.stack, Renderer26.type, (last, cons) -> {
			Renderer26.pose = last;
			Renderer26.cons = cons;
			group.render();
			Renderer26.pose = null;
		});
		group.post(mdata);
	}

	public static void render(Polyhedron poly){
		noco.submitCustomGeometry(Renderer26.stack, Renderer26.type, (last, cons) -> {
			Renderer26.pose = last;
			Renderer26.cons = cons;
			RENDERER.render(poly);
			Renderer26.pose = null;
		});
	}

	public static void renderSphere(float scale, int col){
		Renderer26.type = FvtmRenderTypes.white();
		Renderer26.stack.pushPose();
		Renderer26.stack.scale(scale, scale, scale);
		noco.submitCustomGeometry(Renderer26.stack, FvtmRenderTypes.white(), (last, cons) -> {
			RENDERER.color(col);
			Renderer26.pose = last;
			Renderer26.cons = cons;
			RENDERER.render(DebugUtils.SPHERE);
			Renderer26.pose = null;
			Renderer26.resetColor();
		});
		Renderer26.stack.popPose();
	}

}
