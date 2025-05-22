package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.ui.rail.RailJunction;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;

import static net.fexcraft.lib.common.Static.rad90;
import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.FvtmResources.WHITE_TEXTURE;
import static net.fexcraft.mod.fvtm.render.Renderer20.AY;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class RailRenderer {

	private static RailSystem sys;
	private static boolean holding;
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
		Renderer20.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof JunctionGridItem;
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer20.resetColor();
		FvtmRenderTypes.setCutout(WHITE_TEXTURE);
		for(SystemRegion<RailSystem, Junction> reg : sys.getRegions().values()){
			juncset.clear();
			juncset.addAll(reg.getObjects().values());
			for(Junction junc : juncset){
				pose.pushPose();
				pose.translate(junc.getV3D().x, junc.getV3D().y, junc.getV3D().z);
				Renderer20.RENDERER.light(junc.getV3D());
				if(junc.tracks.size() == 0 || holding){
					DebugUtils.renderBB(0.25f, COL_ORG);
				}
				if(holding){
					pose.translate(0, junc.tracks.get(0).gauge.getHeight(), 0);
					FvtmRenderTypes.setCutout(WHITE_TEXTURE);
					Renderer20.setColor(COL_GRY);
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
		Renderer20.pushPose();
		Renderer20.rotateRad((float)ang, AY);
		Renderer20.setColor(RailJunction.TRACK_RGB[idx]);
		hed.render();
		Renderer20.popPose();
	}

	private static void renderJuncSignal(Junction junc, int idx, RGB col){
		V3D pos = junc.tracks.get(idx).getVectorPosition0(junc.tracks.get(idx).length * 0.5f, false);
		double ang = -Math.atan2(junc.tracks.get(idx).vecpath[0].z - pos.z, junc.tracks.get(idx).vecpath[0].x - pos.x) - rad90;
		Renderer20.pushPose();
		Renderer20.rotateRad((float)ang, AY);
		Renderer20.setColor(RailJunction.TRACK_RGB[idx]);
		JUNC_SIG_DIR.render();
		Renderer20.setColor(col);
		JUNC_SIG_STATE.render();
		Renderer20.popPose();
	}

	private static void renderRails(PoseStack pose, Junction junc){
		pose.pushPose();
		Renderer20.resetColor();
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
