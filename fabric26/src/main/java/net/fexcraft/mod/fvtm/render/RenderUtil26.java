package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fcl.util.Renderer26;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

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
		if(group.visible){
			int col = Renderer26.color;
			noco.submitCustomGeometry(Renderer26.stack, Renderer26.type, (last, cons) -> {
				Renderer26.setColor(col);
				Renderer26.pose = last;
				Renderer26.cons = cons;
				group.render();
				Renderer26.pose = null;
			});
		}
		group.post(mdata);
	}

	public static void render(Polyhedron poly){
		if(!poly.visible) return;
		int col = Renderer26.color;
		noco.submitCustomGeometry(Renderer26.stack, Renderer26.type, (last, cons) -> {
			Renderer26.setColor(col);
			Renderer26.pose = last;
			Renderer26.cons = cons;
			RENDERER.render(poly);
			Renderer26.pose = null;
		});
	}

	public static void render(Runnable run){
		int col = Renderer26.color;
		noco.submitCustomGeometry(Renderer26.stack, Renderer26.type, (last, cons) -> {
			Renderer26.setColor(col);
			Renderer26.pose = last;
			Renderer26.cons = cons;
			run.run();
			Renderer26.pose = null;
		});
	}

	public static void render(Polyhedron poly, int col){
		if(!poly.visible) return;
		noco.submitCustomGeometry(Renderer26.stack, Renderer26.type, (last, cons) -> {
			Renderer26.setColor(col);
			Renderer26.pose = last;
			Renderer26.cons = cons;
			RENDERER.render(poly);
			Renderer26.pose = null;
			Renderer26.resetColor();
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

	public static void renderBB(V3D pos, float scale, int col){
		RENDERER.translate(pos.x, pos.y, pos.z);
		renderBB(scale, col);
		RENDERER.translate(-pos.x, -pos.y, -pos.z);
	}

	public static void renderBB(float scale, int col){
		Renderer26.type = FvtmRenderTypes.white();
		float hs = scale * 0.5f;
		//
		RENDERER.push();
		RENDERER.scale(scale, 1, 1);
		RENDERER.translate(0, -hs, -hs);
		render(LLBB0, col);
		RENDERER.translate(0, 0, scale);
		render(LLBB0, col);
		RENDERER.translate(0, scale, 0);
		render(LLBB0, col);
		RENDERER.translate(0, 0, -scale);
		render(LLBB0, col);
		RENDERER.pop();
		//
		RENDERER.push();
		RENDERER.scale(1, scale, 1);
		RENDERER.translate(-hs, 0, -hs);
		render(LLBB1, col);
		RENDERER.translate(scale, 0, 0);
		render(LLBB1, col);
		RENDERER.translate(0, 0, scale);
		render(LLBB1, col);
		RENDERER.translate(-scale, 0, 0);
		render(LLBB1, col);
		RENDERER.pop();
		//
		RENDERER.push();
		RENDERER.scale(1, 1, scale);
		RENDERER.translate(-hs, -hs, 0);
		render(LLBB2, col);
		RENDERER.translate(scale, 0, 0);
		render(LLBB2, col);
		RENDERER.translate(0, scale, 0);
		render(LLBB2, col);
		RENDERER.translate(-scale, 0, 0);
		render(LLBB2, col);
		RENDERER.pop();
	}

	public static void typeWhite(){
		type(FvtmRenderTypes.white());
	}

}
