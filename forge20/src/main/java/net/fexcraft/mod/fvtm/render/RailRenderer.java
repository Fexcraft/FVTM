package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.item.JunctionTool;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;

import java.util.HashSet;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.Config.DISABLE_SIGNS;
import static net.fexcraft.mod.fvtm.FvtmResources.WHITE_TEXTURE;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.Renderer120.AY;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class RailRenderer {

	private static RailSystem sys;
	private static boolean holding;
	private static BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
	private static HashSet<Junction> juncset = new HashSet<>();

	@SubscribeEvent
	public static void renderRails(RenderLevelStageEvent event){
		if(DISABLE_RAILS) return;
		if(event.getStage() != RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS) return;
		sys = SystemManager.get(SystemManager.Systems.RAIL, WrapperHolder.getWorld(event.getCamera().getEntity().level()));
		if(sys == null) return;
		Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.getPoseStack();
		Renderer120.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof JunctionTool;
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer120.resetColor();
		FvtmRenderTypes.setCutout(WHITE_TEXTURE);
		for(SystemRegion<RailSystem, Junction> reg : sys.getRegions().values()){
			juncset.clear();
			juncset.addAll(reg.getObjects().values());
			for(Junction junc : juncset){
				pose.pushPose();
				pose.translate(junc.getV3D().x, junc.getV3D().y, junc.getV3D().z);
				Renderer120.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(junc.getV3D().x, junc.getV3D().y + 0.1, junc.getV3D().z));
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
		Renderer120.resetColor();
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

}
