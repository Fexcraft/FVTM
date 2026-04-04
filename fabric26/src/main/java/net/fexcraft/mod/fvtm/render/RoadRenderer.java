package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
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
		//RenderUtil26.lines();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		//V3D vec0, vec1;
		RoadPlacingUtil.NewRoad nroad = RoadPlacingUtil.CL_CURRENT;
		if(nroad.coords == null) nroad.genpreview();
		/*Renderer26.setColor(COL_BLU);
		for(int j = 0; j < nroad.road.vecpath.length - 1; j++){
			vec0 = nroad.road.vecpath[j];
			vec1 = nroad.road.vecpath[j + 1];
			LINE_POLY.vertices[0].pos(vec0.x, vec0.y + 1.25, vec0.z);
			LINE_POLY.vertices[1].pos(vec1.x, vec1.y + 1.25, vec1.z);
			LINE.render();
		}
		int size = RoadPlacingUtil.CL_CURRENT.points.size();
		double[] arr;
		Renderer26.setColor(COL_CYN);
		for(int i = 1; i < size - 1; i++){
			arr = nroad.road.getPosition((nroad.road.length / (size - 1)) * i);
			vec1 = RoadPlacingUtil.CL_CURRENT.points.get(i).vec;
			LINE_POLY.vertices[0].pos(arr[0], arr[1] + 1.25, arr[2]);
			LINE_POLY.vertices[1].pos(vec1.x, vec1.y + 1.25, vec1.z);
			LINE.render();
		}*/
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
