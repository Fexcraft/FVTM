package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.ui.rail.RailJunction;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.HashSet;

import static net.fexcraft.lib.common.Static.*;
import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.FvtmResources.WHITE_TEXTURE;
import static net.fexcraft.mod.fvtm.render.Renderer21.AY;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailRenderer {

	private static RailSystem sys;
	private static boolean holding;
	private static HashSet<Junction> juncset = new HashSet<>();

	public static void renderRails(WorldRenderContext event){
		if(DISABLE_RAILS) return;
		sys = SystemManager.get(SystemManager.Systems.RAIL, WrapperHolder.getWorld(event.camera().getEntity().level()));
		if(sys == null) return;
		Camera camera = event.camera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.matrixStack();
		Renderer21.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof JunctionGridItem;
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer21.resetColor();
		FvtmRenderTypes.setCutout(WHITE_TEXTURE);
		for(SystemRegion<RailSystem, Junction> reg : sys.getRegions().values()){
			juncset.clear();
			juncset.addAll(reg.getObjects().values());
			for(Junction junc : juncset){
				pose.pushPose();
				pose.translate(junc.getV3D().x, junc.getV3D().y, junc.getV3D().z);
				Renderer21.RENDERER.light(junc.getV3D());
				if(junc.tracks.size() == 0 || holding){
					DebugUtils.renderBB(0.25f, COL_ORG);
				}
				if(junc.tracks.size() > 0 && holding){
					pose.translate(0, junc.tracks.get(0).gauge.getHeight(), 0);
					FvtmRenderTypes.setCutout(WHITE_TEXTURE);
					Renderer21.setColor(COL_GRY);
					JUNC_CORE.render();
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
		Renderer21.pushPose();
		Renderer21.rotateRad((float)ang, AY);
		Renderer21.setColor(RailJunction.TRACK_RGB[idx]);
		hed.render();
		Renderer21.popPose();
	}

	private static void renderJuncSignal(Junction junc, int idx, RGB col){
		V3D pos = junc.tracks.get(idx).getVectorPosition0(junc.tracks.get(idx).length * 0.5f, false);
		double ang = -Math.atan2(junc.tracks.get(idx).vecpath[0].z - pos.z, junc.tracks.get(idx).vecpath[0].x - pos.x) - rad90;
		Renderer21.pushPose();
		Renderer21.rotateRad((float)ang, AY);
		Renderer21.setColor(RailJunction.TRACK_RGB[idx]);
		JUNC_SIG_DIR.render();
		Renderer21.setColor(col);
		JUNC_SIG_STATE.render();
		Renderer21.popPose();
	}

	private static void renderRails(PoseStack pose, Junction junc){
		pose.pushPose();
		Renderer21.resetColor();
		for(int i = 0; i < junc.size(); i++){
			if(i > 2) pose.translate(0, -0.02, 0);
			if(junc.tracks.get(i).isOppositeCopy()) continue;
			pose.pushPose();
			Track track = junc.tracks.get(i);
			pose.translate(track.vecpath[0].x, track.vecpath[0].y, track.vecpath[0].z);
			RailGaugeModel model = track.gauge.getModel();
			if(track.railmodel == null) PathModelGenerator.generateTrackModel(track, model);
			FvtmRenderTypes.setCutout(track.gauge.getRailTexture());
			track.railmodel.render();
			FvtmRenderTypes.setCutout(track.gauge.getTiesTexture());
			track.restmodel.render();
			pose.popPose();
		}
		pose.popPose();
	}

	public static boolean renderGrid(WorldRenderContext event, HitResult res){
		if(Minecraft.getInstance().player.getMainHandItem().getItem() instanceof JunctionGridItem == false) return true;
		if(!((JunctionGridItem)Minecraft.getInstance().player.getMainHandItem().getItem()).showJunctionGrid()) return true;
		PoseStack pose = event.matrixStack();
		Renderer21.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 255);
		QV3D vec = new QV3D(res.getLocation().x, res.getLocation().y, res.getLocation().z);
		BlockPos pos = BlockPos.containing(res.getLocation());
		double cx = event.camera().getPosition().x;
		double cy = event.camera().getPosition().y;
		double cz = event.camera().getPosition().z;
		double yy = vec.y * 0.0625f;
		Renderer21.resetColor();
		FvtmRenderTypes.setCutout(FvtmRegistry.WHITE_TEXTURE);
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		for(int i = 0; i < 4; i++){
			pose.pushPose();
			pose.translate(pos.getX() + (i * 0.25 + 0.125), pos.getY() + yy + 0.01, pos.getZ() + 0.5);
			LLBB2.render();
			pose.popPose();
			pose.pushPose();
			pose.translate(pos.getX() + 0.5, pos.getY() + yy + 0.01, pos.getZ() + (i * 0.25 + 0.125));
			LLBB0.render();
			pose.popPose();
		}
		double v = vec.x < 0 ? (-vec.x - 16) * -0.0625 : vec.x * 0.0625;
		Renderer21.setColor(COL_CYN);
		pose.pushPose();
		pose.translate(pos.getX() + v, pos.getY() + yy + 0.01, pos.getZ() + 0.5);
		LLBB2.render();
		pose.popPose();
		v = vec.z < 0 ? (-vec.z - 16) * -0.0625 : vec.z * 0.0625;
		pose.pushPose();
		pose.translate(pos.getX() + 0.5, pos.getY() + yy + 0.01, pos.getZ() + v);
		LLBB0.render();
		pose.popPose();
		Renderer21.setColor(COL_ORG);
		pose.translate(vec.vec.x, vec.vec.y, vec.vec.z);
		pose.scale(thirtysecondth, thirtysecondth, thirtysecondth);
		SPHERE.render();
		pose.popPose();
		return true;
	}

	public static boolean renderRailPreview(WorldRenderContext event, HitResult res){
		if(RailPlacingUtil.CL_CURRENT == null || RailPlacingUtil.CL_CURRENT.points.size() < 2) return true;
		double cx = event.camera().getPosition().x;
		double cy = event.camera().getPosition().y;
		double cz = event.camera().getPosition().z;
		PoseStack pose = event.matrixStack();
		Renderer21.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 255);
		FvtmRenderTypes.setLines();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		V3D vec0, vec1;
		RailPlacingUtil.NewTrack conn = RailPlacingUtil.CL_CURRENT;
		if(conn.preview == null) conn.genpreview();
		Renderer21.setColor(COL_BLU);
		for(int j = 0; j < conn.track.vecpath.length - 1; j++){
			vec0 = conn.track.vecpath[j];
			vec1 = conn.track.vecpath[j + 1];
			LINE_POLY.vertices[0].pos(vec0.x, vec0.y + 0.1f, vec0.z);
			LINE_POLY.vertices[1].pos(vec1.x, vec1.y + 0.1f, vec1.z);
			LINE.render();
		}
		int size = RailPlacingUtil.CL_CURRENT.points.size();
		double[] arr;
		Renderer21.setColor(COL_CYN);
		for(int i = 1; i < size - 1; i++){
			arr = conn.track.getPosition((conn.track.length / (size - 1)) * i);
			vec1 = RailPlacingUtil.CL_CURRENT.points.get(i).vec;
			LINE_POLY.vertices[0].pos(arr[0], arr[1] - 0.05f, arr[2]);
			LINE_POLY.vertices[1].pos(vec1.x, vec1.y - 0.05f, vec1.z);
			LINE.render();
		}
		Renderer21.setColor(COL_ORG);
		for(ArrayList<V3D> l : conn.preview){
			for(int j = 0; j < l.size() - 1; j++){
				LINE_POLY.vertices[0].pos((vec0 = l.get(j)).x, vec0.y + conn.gauge.getHeight() - .01, vec0.z);
				LINE_POLY.vertices[1].pos((vec1 = l.get(j + 1)).x, vec1.y + conn.gauge.getHeight() - .01, vec1.z);
				LINE.render();
			}
		}
		Renderer21.resetColor();
		pose.popPose();
		return true;
	}

}
