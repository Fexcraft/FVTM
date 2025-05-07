package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.item.JunctionTool;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;

import java.util.HashSet;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.FvtmResources.WHITE_TEXTURE;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailRenderer {

	private static RailSystem sys;
	private static boolean holding;
	private static BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
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
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof JunctionTool;
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
				Renderer21.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(junc.getV3D().x, junc.getV3D().y + 0.1, junc.getV3D().z));
				JUNC_CORE.render();
				pose.popPose();
				if(junc.tracks.size() == 0 || holding || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof JunctionGridItem){
					DebugUtils.renderBB(0.5f, COL_ORG);
				}
				renderRails(pose, junc);
			}
		}
		pose.popPose();
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
		Renderer21.setColor(RGB.WHITE);
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
		pose.scale(0.0625f, 0.0625f, 0.0625f);
		SPHERE.render();
		pose.popPose();
		return true;
	}

}
