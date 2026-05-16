package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fexcraft.mod.fcl.util.Renderer26;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.util.QV3D;

import java.util.ArrayList;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadRenderer {

	public static boolean renderRoadPreview(LevelRenderContext context){
		if(RoadPlacingUtil.CL_CURRENT == null || RoadPlacingUtil.CL_CURRENT.points.size() < 2) return true;
		double cx = context.levelState().cameraRenderState.pos.x;
		double cy = context.levelState().cameraRenderState.pos.y;
		double cz = context.levelState().cameraRenderState.pos.z;
		PoseStack pose = context.poseStack();
		RenderUtil26.set(pose, context.submitNodeCollector(), null, 255);
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		RoadPlacingUtil.NewRoad nroad = RoadPlacingUtil.CL_CURRENT;
		if(nroad.coords == null) nroad.genpreview();
		Renderer26.setColor(COL_BLU);
		for(int j = 0; j < nroad.road.vecpath.length - 1; j++){
			RenderUtil26.renderLine(
				nroad.road.vecpath[j].x, nroad.road.vecpath[j].y + 1.25f, nroad.road.vecpath[j].z,
				nroad.road.vecpath[j + 1].x, nroad.road.vecpath[j + 1].y + 1.25f, nroad.road.vecpath[j + 1].z);
		}
		int size = RoadPlacingUtil.CL_CURRENT.points.size();
		double[] arr;
		Renderer26.setColor(COL_CYN);
		for(int i = 1; i < size - 1; i++){
			arr = nroad.road.getPosition((nroad.road.length / (size - 1)) * i);
			var vec = RoadPlacingUtil.CL_CURRENT.points.get(i).vec;
			LINE_POLY.vertices[0].pos(arr[0], arr[1] + 1.25, arr[2]);
			LINE_POLY.vertices[1].pos(vec.x, vec.y + 1.25, vec.z);
			LINE.render();
			RenderUtil26.renderLine(
				arr[0], arr[1] + 1.25, arr[2],
				vec.x, vec.y + 1.25f, vec.z);
		}
		for(ArrayList<QV3D> coords : nroad.coords){
			for(QV3D coord : coords){
				pose.pushPose();
				pose.translate(coord.pos.x + 1, coord.pos.y + 1 + coord.y * sixteenth, coord.pos.z + 1);
				RenderUtil26.renderPane(0.5f, COL_CYN);
				pose.popPose();
			}
		}
		pose.popPose();
		return true;
	}

}
