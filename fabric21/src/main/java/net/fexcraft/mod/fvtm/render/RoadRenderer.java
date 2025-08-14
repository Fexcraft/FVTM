package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_CYN;
import static net.fexcraft.mod.fvtm.util.DebugUtils.LINE;
import static net.fexcraft.mod.fvtm.util.DebugUtils.LINE_POLY;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadRenderer {

	public static boolean renderRoadPreview(WorldRenderContext event, HitResult res){
		if(RoadPlacingUtil.CL_CURRENT == null || RoadPlacingUtil.CL_CURRENT.points.size() < 2) return true;
		double cx = event.camera().getPosition().x;
		double cy = event.camera().getPosition().y;
		double cz = event.camera().getPosition().z;
		PoseStack pose = event.matrixStack();
		Renderer21.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 255);
		FvtmRenderTypes.setLines();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		V3D vec0, vec1;
		RoadPlacingUtil.NewRoad nroad = RoadPlacingUtil.CL_CURRENT;
		if(nroad.coords == null) nroad.genpreview();
		Renderer21.setColor(COL_BLU);
		for(int j = 0; j < nroad.road.vecpath.length - 1; j++){
			vec0 = nroad.road.vecpath[j];
			vec1 = nroad.road.vecpath[j + 1];
			LINE_POLY.vertices[0].pos(vec0.x, vec0.y + 1.25, vec0.z);
			LINE_POLY.vertices[1].pos(vec1.x, vec1.y + 1.25, vec1.z);
			LINE.render();
		}
		int size = RoadPlacingUtil.CL_CURRENT.points.size();
		double[] arr;
		Renderer21.setColor(COL_CYN);
		for(int i = 1; i < size - 1; i++){
			arr = nroad.road.getPosition((nroad.road.length / (size - 1)) * i);
			vec1 = RoadPlacingUtil.CL_CURRENT.points.get(i).vec;
			LINE_POLY.vertices[0].pos(arr[0], arr[1] + 1.25, arr[2]);
			LINE_POLY.vertices[1].pos(vec1.x, vec1.y + 1.25, vec1.z);
			LINE.render();
		}
		for(ArrayList<QV3D> coords : nroad.coords){
			for(QV3D coord : coords){
				pose.pushPose();
				pose.translate(coord.pos.x + 1, coord.pos.y + 1 + coord.y * sixteenth, coord.pos.z + 1);
				DebugUtils.renderPane(0.5f, COL_CYN);
				pose.popPose();
			}
		}
		pose.popPose();
		return true;
	}

}
