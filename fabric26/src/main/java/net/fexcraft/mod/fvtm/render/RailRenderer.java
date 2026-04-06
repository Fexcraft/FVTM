package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.mod.fcl.util.Renderer26;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.render.state.OutlineRS;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.ui.rail.RailJunction;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;

import java.util.HashSet;

import static net.fexcraft.lib.common.Static.*;
import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.FVTMC.LEVEL_RS_KEY;
import static net.fexcraft.mod.fvtm.FVTMC.OUTLINE_RS_KEY;
import static net.fexcraft.mod.fvtm.render.RenderUtil.RENDER_UTIL;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailRenderer {

	private static RailSystem sys;
	private static boolean holding;
	private static HashSet<Junction> juncset = new HashSet<>();

	public static void renderRails(LevelRenderContext context){
		sys = SystemManager.get(SystemManager.Systems.RAIL, context.levelState().getData(LEVEL_RS_KEY).key);
		if(sys == null) return;
		double cx = context.levelState().cameraRenderState.pos.x;
		double cy = context.levelState().cameraRenderState.pos.y;
		double cz = context.levelState().cameraRenderState.pos.z;
		PoseStack pose = context.poseStack();
		RenderUtil26.set(pose, context.submitNodeCollector(), FvtmRenderTypes.white(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof JunctionGridItem;
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer26.resetColor();
		for(SystemRegion<RailSystem, Junction> reg : sys.getRegions().values()){
			juncset.clear();
			juncset.addAll(reg.getObjects().values());
			for(Junction junc : juncset){
				pose.pushPose();
				pose.translate(junc.getV3D().x, junc.getV3D().y, junc.getV3D().z);
				Renderer26.RENDERER.light(junc.getV3D());
				if(junc.tracks.size() == 0 || holding){
					RenderUtil26.renderBB(0.25f, COL_ORG);
				}
				if(junc.tracks.size() > 0 && holding){
					pose.translate(0, junc.tracks.get(0).gauge.getHeight(), 0);
					RenderUtil26.typeWhite();
					Renderer26.setColor(COL_GRY);
					RENDER_UTIL.render(JUNC_CORE);
					for(int i = 0; i < junc.tracks.size(); i++){
						renderJuncModel(junc, i, JUNC_LINE);
					}
					switch(junc.type){
						case STRAIGHT:
							if(junc.tracks.size() > 1 && !junc.sigtype0.none()) renderJuncSignal(junc, 0, junc.sigstate0 ? RGB.GREEN : RGB.RED);
							if(junc.tracks.size() > 1 && !junc.sigtype1.none()) renderJuncSignal(junc, 1, junc.sigstate1 ? RGB.GREEN : RGB.RED);
							break;
						case FORK_2:
							renderJuncModel(junc, junc.switch0 ? 1 : 2, JUNC_DIR);
							break;
						case FORK_3:
							renderJuncModel(junc, junc.switch0 ? 1 : junc.switch1 ? 3 : 2, JUNC_DIR);
							break;
						case DOUBLE:
							renderJuncModel(junc, junc.switch0 ? 1 : 2, JUNC_DIR);
							renderJuncModel(junc, junc.switch1 ? 0 : 3, JUNC_DIR);
							break;
						case CROSSING: break;
					}
				}
				pose.popPose();
				renderRails(pose, junc);
			}
		}
		pose.popPose();
	}

	private static void renderJuncModel(Junction junc, int idx, Polyhedron hed){
		V3D pos = junc.tracks.get(idx).getVectorPosition0(junc.tracks.get(idx).length * 0.5f, false);
		double ang = -Math.atan2(junc.tracks.get(idx).vecpath[0].z - pos.z, junc.tracks.get(idx).vecpath[0].x - pos.x) - rad90;
		RENDERER.push();
		RENDERER.rotateRad((float)ang, 0, 1, 0);
		Renderer26.setColor(RailJunction.TRACK_RGB[idx]);
		RENDER_UTIL.render(hed);
		RENDERER.pop();
	}

	private static void renderJuncSignal(Junction junc, int idx, RGB col){
		V3D pos = junc.tracks.get(idx).getVectorPosition0(junc.tracks.get(idx).length * 0.5f, false);
		double ang = -Math.atan2(junc.tracks.get(idx).vecpath[0].z - pos.z, junc.tracks.get(idx).vecpath[0].x - pos.x) - rad90;
		RENDERER.push();
		RENDERER.rotateRad((float)ang, 0, 1, 0);
		Renderer26.setColor(RailJunction.TRACK_RGB[idx]);
		RENDER_UTIL.render(JUNC_SIG_DIR);
		Renderer26.setColor(col);
		RENDER_UTIL.render(JUNC_SIG_STATE);
		RENDERER.pop();
	}

	private static void renderRails(PoseStack pose, Junction junc){
		pose.pushPose();
		Renderer26.resetColor();
		for(int i = 0; i < junc.size(); i++){
			if(i > 2) pose.translate(0, -0.02, 0);
			if(junc.tracks.get(i).isOppositeCopy()) continue;
			pose.pushPose();
			Track track = junc.tracks.get(i);
			pose.translate(track.vecpath[0].x, track.vecpath[0].y, track.vecpath[0].z);
			RailGaugeModel model = track.gauge.getModel();
			if(track.railmodel == null) PathModelGenerator.generateTrackModel(track, model);
			RenderUtil26.type(FvtmRenderTypes.getCutout(track.gauge.getRailTexture()));
			RenderUtil26.render(() -> {
				for(int m = 0; m < track.railmodel.hedrons.length; m++){
					Renderer.RENDERER.light(track.railmodel.positions[m]);
					RENDERER.render(track.railmodel.hedrons[m]);
				}
			});
			RenderUtil26.type(FvtmRenderTypes.getCutout(track.gauge.getTiesTexture()));
			RenderUtil26.render(() -> {
				for(int m = 0; m < track.restmodel.hedrons.length; m++){
					Renderer.RENDERER.light(track.restmodel.positions[m]);
					RENDERER.render(track.restmodel.hedrons[m]);
				}
			});
			pose.popPose();
		}
		pose.popPose();
	}

	public static boolean renderGrid(LevelRenderContext context){
		if(Minecraft.getInstance().player.getMainHandItem().getItem() instanceof JunctionGridItem == false) return true;
		if(!((JunctionGridItem)Minecraft.getInstance().player.getMainHandItem().getItem()).showJunctionGrid()) return true;
		PoseStack pose = context.poseStack();
		RenderUtil26.set(pose, context.submitNodeCollector(), FvtmRenderTypes.white(), 255);
		OutlineRS ol = context.levelState().getData(OUTLINE_RS_KEY);
		QV3D vec = ol.result;
		BlockPos pos = ol.pos;
		double cx = context.levelState().cameraRenderState.pos.x;
		double cy = context.levelState().cameraRenderState.pos.y;
		double cz = context.levelState().cameraRenderState.pos.z;
		double yy = vec.y * 0.0625f;
		Renderer26.resetColor();
		RenderUtil26.typeWhite();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		for(int i = 0; i < 4; i++){
			pose.pushPose();
			pose.translate(pos.getX() + (i * 0.25 + 0.125), pos.getY() + yy + 0.01, pos.getZ() + 0.5);
			RENDER_UTIL.render(LLBB2);
			pose.popPose();
			pose.pushPose();
			pose.translate(pos.getX() + 0.5, pos.getY() + yy + 0.01, pos.getZ() + (i * 0.25 + 0.125));
			RENDER_UTIL.render(LLBB0);
			pose.popPose();
		}
		double v = vec.x < 0 ? (-vec.x - 16) * -0.0625 : vec.x * 0.0625;
		Renderer26.setColor(COL_CYN);
		pose.pushPose();
		pose.translate(pos.getX() + v, pos.getY() + yy + 0.01, pos.getZ() + 0.5);
		RENDER_UTIL.render(LLBB2);
		pose.popPose();
		v = vec.z < 0 ? (-vec.z - 16) * -0.0625 : vec.z * 0.0625;
		pose.pushPose();
		pose.translate(pos.getX() + 0.5, pos.getY() + yy + 0.01, pos.getZ() + v);
		RENDER_UTIL.render(LLBB0);
		pose.popPose();
		Renderer26.setColor(COL_ORG);
		pose.translate(vec.vec.x, vec.vec.y, vec.vec.z);
		pose.scale(thirtysecondth, thirtysecondth, thirtysecondth);
		RENDER_UTIL.render(SPHERE);
		Renderer26.resetColor();
		pose.popPose();
		return true;
	}

	public static boolean renderRailPreview(LevelRenderContext context){
		/*if(RailPlacingUtil.CL_CURRENT == null || RailPlacingUtil.CL_CURRENT.points.size() < 2) return true;
		double cx = context.levelState().cameraRenderState.pos.x;
		double cy = context.levelState().cameraRenderState.pos.y;
		double cz = context.levelState().cameraRenderState.pos.z;
		PoseStack pose = context.poseStack();
		RenderUtil26.set(pose, context.submitNodeCollector(), null, 255);
		RenderUtil26.lines();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		V3D vec0, vec1;
		RailPlacingUtil.NewTrack conn = RailPlacingUtil.CL_CURRENT;
		if(conn.preview == null) conn.genpreview();
		Renderer26.setColor(COL_BLU);
		for(int j = 0; j < conn.track.vecpath.length - 1; j++){
			vec0 = conn.track.vecpath[j];
			vec1 = conn.track.vecpath[j + 1];
			RENDER_UTIL.renderLine(vec0.x, vec0.y + 0.1f, vec0.z, vec1.x, vec1.y + 0.1f, vec1.z);
		}
		int size = RailPlacingUtil.CL_CURRENT.points.size();
		double[] arr;
		Renderer26.setColor(COL_CYN);
		for(int i = 1; i < size - 1; i++){
			arr = conn.track.getPosition((conn.track.length / (size - 1)) * i);
			vec1 = RailPlacingUtil.CL_CURRENT.points.get(i).vec;
			RENDER_UTIL.renderLine(arr[0], arr[1] - 0.05f, arr[2], vec1.x, vec1.y - 0.05f, vec1.z);
		}
		Renderer26.setColor(COL_ORG);
		for(ArrayList<V3D> l : conn.preview){
			for(int j = 0; j < l.size() - 1; j++){
				RENDER_UTIL.renderLine((vec0 = l.get(j)).x, vec0.y + conn.gauge.getHeight() - .01, vec0.z, (vec1 = l.get(j + 1)).x, vec1.y + conn.gauge.getHeight() - .01, vec1.z);
			}
		}
		Renderer26.resetColor();
		pose.popPose();*///TODO
		return true;
	}

}
