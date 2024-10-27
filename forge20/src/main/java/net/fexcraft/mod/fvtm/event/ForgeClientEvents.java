package net.fexcraft.mod.fvtm.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fexcraft.lib.common.math.*;
import net.fexcraft.lib.frl.ColoredVertex;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.render.FvtmRenderTypes;
import net.fexcraft.mod.fvtm.render.PathModelGenerator;
import net.fexcraft.mod.fvtm.render.Renderer120;
import net.fexcraft.mod.fvtm.sys.rail.*;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.util.DebugUtils.JUNC_CORE;
import static net.fexcraft.mod.fvtm.util.DebugUtils.SPHERE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class ForgeClientEvents {

	//@SubscribeEvent
	public static void onPlayerRender(RenderPlayerEvent.Pre event){
		//Renderer120.pose = event.getPoseStack();
		//Renderer120.buffer = event.getMultiBufferSource();
		//Renderer120.light = event.getPackedLight();
		if(!event.getRenderer().getModel().body.hasChild("fvtm")){
			event.getRenderer().getModel().body.children.put("fvtm", new ModelPart(new ArrayList<>(), new HashMap<>()) {
				@Override
				public void render(PoseStack pose, VertexConsumer cons, int i, int j){
					render(pose, cons, i, j, 1.0F, 1.0F, 1.0F, 1.0F);
				}

				@Override
				public void render(PoseStack pose, VertexConsumer cons, int i, int j, float k, float l, float m, float n){
					Renderer120.set(pose, cons, i, j);
					FvtmRenderTypes.setLines();
					SPHERE.render();
				}
			});
		}
		//Renderer120.rentype = RenderType.entityCutout(data.getCurrentTexture().local());
		//data.getType().getModel().render(DefaultModel.RENDERDATA);
	}

	private static Polyhedron LINE = new Polyhedron();
	private static Polygon POLY;
	static {
		POLY = new Polygon(new Vertex[]{ new ColoredVertex(new Vec3f()), new ColoredVertex(new Vec3f())});
		LINE.polygons.add(POLY);
	}
	private static Vec3f BLUE = new Vec3f(0, 0, 1);
	private static Vec3f CYAN = new Vec3f(0, 1, 1);
	private static Vec3f ORG = new Vec3f(1, 0.75f, 0);

	@SubscribeEvent
	public static void renderRoad(RenderLevelStageEvent event){
		if(RoadPlacingUtil.CL_CURRENT == null || RoadPlacingUtil.CL_CURRENT.points.size() < 2) return;
		if(event.getStage() != RenderLevelStageEvent.Stage.AFTER_CUTOUT_BLOCKS) return;
		Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.getPoseStack();
		VertexConsumer cons = Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(RenderType.lines());
		Renderer120.set(pose, cons, 0);
		FvtmRenderTypes.setLines();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		V3D vec0, vec1;
		RoadPlacingUtil.NewRoad nroad = RoadPlacingUtil.CL_CURRENT;
		if(nroad.preview == null) nroad.genpreview();
		Renderer120.setColor(BLUE);
		for(int j = 0; j < nroad.road.vecpath.length - 1; j++){
			vec0 = nroad.road.vecpath[j];
			vec1 = nroad.road.vecpath[j + 1];
			POLY.vertices[0].pos(vec0.x, vec0.y - 0.25f, vec0.z);
			POLY.vertices[1].pos(vec1.x, vec1.y - 0.25f, vec1.z);
			LINE.render();
		}
		int size = RoadPlacingUtil.CL_CURRENT.points.size();
		double[] arr;
		Renderer120.setColor(CYAN);
		for(int i = 1; i < size - 1; i++){
			arr = nroad.road.getPosition((nroad.road.length / (size - 1)) * i);
			vec1 = RoadPlacingUtil.CL_CURRENT.points.get(i).vec;
			POLY.vertices[0].pos(arr[0], arr[1] - 0.25f, arr[2]);
			POLY.vertices[1].pos(vec1.x, vec1.y - 0.25f, vec1.z);
			LINE.render();
		}
		Renderer120.setColor(ORG);
		for(ArrayList<V3D> l : nroad.preview){
			for(int j = 0; j < l.size() - 1; j++){
				POLY.vertices[0].pos((vec0 = l.get(j)).x, vec0.y - 0.45f, vec0.z);
				POLY.vertices[1].pos((vec1 = l.get(j + 1)).x, vec1.y - 0.45f, vec1.z);
				LINE.render();
			}
		}
		pose.popPose();
	}

	@SubscribeEvent
	public static void renderRail(RenderLevelStageEvent event){
		if(RailPlacingUtil.CL_CURRENT == null || RailPlacingUtil.CL_CURRENT.points.size() < 2) return;
		if(event.getStage() != RenderLevelStageEvent.Stage.AFTER_CUTOUT_BLOCKS) return;
		Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.getPoseStack();
		VertexConsumer cons = Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(RenderType.lines());
		Renderer120.set(pose, cons, 0);
		FvtmRenderTypes.setLines();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		V3D vec0, vec1;
		RailPlacingUtil.NewTrack conn = RailPlacingUtil.CL_CURRENT;
		if(conn.preview == null) conn.genpreview();
		Renderer120.setColor(BLUE);
		for(int j = 0; j < conn.track.vecpath.length - 1; j++){
			vec0 = conn.track.vecpath[j];
			vec1 = conn.track.vecpath[j + 1];
			POLY.vertices[0].pos(vec0.x, vec0.y - 0.4f, vec0.z);
			POLY.vertices[1].pos(vec1.x, vec1.y - 0.4f, vec1.z);
			LINE.render();
		}
		int size = RailPlacingUtil.CL_CURRENT.points.size();
		double[] arr;
		Renderer120.setColor(CYAN);
		for(int i = 1; i < size - 1; i++){
			arr = conn.track.getPosition((conn.track.length / (size - 1)) * i);
			vec1 = RailPlacingUtil.CL_CURRENT.points.get(i).vec;
			POLY.vertices[0].pos(arr[0], arr[1] - 0.45f, arr[2]);
			POLY.vertices[1].pos(vec1.x, vec1.y - 0.45f, vec1.z);
			LINE.render();
		}
		Renderer120.setColor(ORG);
		for(ArrayList<V3D> l : conn.preview){
			for(int j = 0; j < l.size() - 1; j++){
				POLY.vertices[0].pos((vec0 = l.get(j)).x, vec0.y + conn.gauge.getHeight() - .49, vec0.z);
				POLY.vertices[1].pos((vec1 = l.get(j + 1)).x, vec1.y + conn.gauge.getHeight() - .49, vec1.z);
				LINE.render();
			}
		}
		pose.popPose();
	}

	public static final IDL JUNCTEX = IDLManager.getIDLCached("minecraft:textures/block/stone.png");
	private static RailSystem railsys;
	private static HashSet<Junction> juncset = new HashSet<>();

	@SubscribeEvent
	public static void renderRail1(RenderLevelStageEvent event){
		if(DISABLE_RAILS) return;
		railsys = SystemManager.get(SystemManager.Systems.RAIL, WrapperHolder.getWorld(event.getCamera().getEntity().level()), RailSystem.class);
		if(railsys == null || railsys.getRegions() == null) return;
		if(event.getStage() != RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS) return;
		Camera camera = event.getCamera();
		//float ticks = event.getPartialTick();
		double cx = camera.getPosition().x;//.xOld + (camera.getX() - camera.xOld) * ticks;
		double cy = camera.getPosition().y;//.yOld + (camera.getY() - camera.yOld) * ticks;
		double cz = camera.getPosition().z;//.zOld + (camera.getZ() - camera.zOld) * ticks;
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		PoseStack pose = event.getPoseStack();
		//VertexConsumer cons = Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(RenderType.lines());
		FvtmRenderTypes.setCutout(JUNCTEX);
		Renderer120.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		for(Region reg : railsys.getRegions().values()){
			juncset.clear();
			juncset.addAll(reg.getJunctions().values());
			for(Junction junc : juncset){
				pose.pushPose();
				pose.translate(junc.getV3D().x, junc.getV3D().y, junc.getV3D().z);
				Renderer120.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(junc.getV3D().x, junc.getV3D().y + 0.1, junc.getV3D().z));
				JUNC_CORE.render();
				pose.popPose();
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

	private static RootVehicle vehicle;

	@SubscribeEvent
	public static void onLevelRender(RenderGuiOverlayEvent event){
		if(Minecraft.getInstance().player.getVehicle() instanceof RootVehicle && event.getOverlay().id().getPath().equals("hotbar")){
			vehicle = (RootVehicle)Minecraft.getInstance().player.getVehicle();
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, "Throttle: " + round(vehicle.vehicle.throttle), 10, 10, 0xffffff);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, "Steering: " + round(vehicle.vehicle.steer_yaw), 10, 20, 0xffffff);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, "Speed: " + round(vehicle.vehicle.speed), 10, 30, 0xffffff);
		}
	}

	private static double round(double var){
		return (int)(var * 100) / 100D;
	}


	@SubscribeEvent
	public static void clientTick(TickEvent.ClientTickEvent event){
		if(event.phase != TickEvent.Phase.START) return;
		SystemManager.onClientTick();
	}

}
