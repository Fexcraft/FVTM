package net.fexcraft.mod.fvtm.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fexcraft.lib.common.math.*;
import net.fexcraft.lib.frl.ColoredVertex;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.render.FvtmRenderTypes;
import net.fexcraft.mod.fvtm.render.Renderer20;
import net.fexcraft.mod.fvtm.sys.rail.*;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.ui.VehicleOverlay;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashMap;

import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class ForgeClientEvents {

	//@SubscribeEvent
	public static void onPlayerRender(RenderPlayerEvent.Pre event){
		//Renderer20.pose = event.getPoseStack();
		//Renderer20.buffer = event.getMultiBufferSource();
		//Renderer20.light = event.getPackedLight();
		if(!event.getRenderer().getModel().body.hasChild("fvtm")){
			event.getRenderer().getModel().body.children.put("fvtm", new ModelPart(new ArrayList<>(), new HashMap<>()) {
				@Override
				public void render(PoseStack pose, VertexConsumer cons, int i, int j){
					render(pose, cons, i, j, 1.0F, 1.0F, 1.0F, 1.0F);
				}

				@Override
				public void render(PoseStack pose, VertexConsumer cons, int i, int j, float k, float l, float m, float n){
					Renderer20.set(pose, cons, i, j);
					FvtmRenderTypes.setLines();
					SPHERE.render();
				}
			});
		}
		//Renderer20.rentype = RenderType.entityCutout(data.getCurrentTexture().local());
		//data.getType().getModel().render(DefaultModel.RENDERDATA);
	}

	private static Polyhedron LINE = new Polyhedron();
	private static Polygon POLY;
	static {
		POLY = new Polygon(new Vertex[]{ new ColoredVertex(new Vec3f()), new ColoredVertex(new Vec3f())});
		LINE.polygons.add(POLY);
	}
	private static Polyhedron sphere = new Polyhedron().importMRT(new ModelRendererTurbo(null, 0, 0, 32, 32)
		.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32), false, 0.0625f);
	public static Vec3f BLUE = new Vec3f(0, 0, 1);
	public static Vec3f CYAN = new Vec3f(0, 1, 1);
	public static Vec3f ORG = new Vec3f(1, 0.75f, 0);

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
		Renderer20.set(pose, cons, 0);
		FvtmRenderTypes.setLines();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		V3D vec0, vec1;
		RoadPlacingUtil.NewRoad nroad = RoadPlacingUtil.CL_CURRENT;
		if(nroad.preview == null) nroad.genpreview();
		Renderer20.setColor(BLUE);
		for(int j = 0; j < nroad.road.vecpath.length - 1; j++){
			vec0 = nroad.road.vecpath[j];
			vec1 = nroad.road.vecpath[j + 1];
			POLY.vertices[0].pos(vec0.x, vec0.y + 1.25, vec0.z);
			POLY.vertices[1].pos(vec1.x, vec1.y + 1.25, vec1.z);
			LINE.render();
		}
		int size = RoadPlacingUtil.CL_CURRENT.points.size();
		double[] arr;
		Renderer20.setColor(CYAN);
		for(int i = 1; i < size - 1; i++){
			arr = nroad.road.getPosition((nroad.road.length / (size - 1)) * i);
			vec1 = RoadPlacingUtil.CL_CURRENT.points.get(i).vec;
			POLY.vertices[0].pos(arr[0], arr[1] + 1.25, arr[2]);
			POLY.vertices[1].pos(vec1.x, vec1.y + 1.25, vec1.z);
			LINE.render();
		}
		Renderer20.setColor(ORG);
		for(ArrayList<V3D> l : nroad.preview){
			for(int j = 0; j < l.size() - 1; j++){
				POLY.vertices[0].pos((vec0 = l.get(j)).x, vec0.y + 1.45, vec0.z);
				POLY.vertices[1].pos((vec1 = l.get(j + 1)).x, vec1.y + 1.45, vec1.z);
				LINE.render();
			}
		}
		for(ArrayList<V3I> coords : nroad.coords){
			for(V3I coord : coords){
				pose.pushPose();
				pose.translate(coord.x + 0.5, coord.y + 0.55, coord.z + 0.5);
				DebugUtils.renderBB(1, COL_CYN);
				pose.popPose();
			}
		}
		pose.popPose();
	}

	@SubscribeEvent
	public static void renderGrid(RenderHighlightEvent event){
		if(Minecraft.getInstance().player.getMainHandItem().getItem() instanceof JunctionGridItem == false) return;
		if(!((JunctionGridItem)Minecraft.getInstance().player.getMainHandItem().getItem()).showJunctionGrid()) return;
		PoseStack pose = event.getPoseStack();
		Renderer20.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 255);
		FvtmRenderTypes.setLines();
		QV3D vec = new QV3D(event.getTarget().getLocation().x, event.getTarget().getLocation().y, event.getTarget().getLocation().z);
		BlockPos pos = BlockPos.containing(event.getTarget().getLocation());
		double cx = event.getCamera().getPosition().x;
		double cy = event.getCamera().getPosition().y;
		double cz = event.getCamera().getPosition().z;
		double yy = vec.y * 0.0625f;
		Renderer20.setColor(RGB.WHITE);
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
		Renderer20.setColor(CYAN);
		pose.pushPose();
		pose.translate(pos.getX() + v, pos.getY() + yy + 0.01, pos.getZ() + 0.5);
		LLBB2.render();
		pose.popPose();
		v = vec.z < 0 ? (-vec.z - 16) * -0.0625 : vec.z * 0.0625;
		pose.pushPose();
		pose.translate(pos.getX() + 0.5, pos.getY() + yy + 0.01, pos.getZ() + v);
		LLBB0.render();
		pose.popPose();
		Renderer20.setColor(ORG);
		pose.translate(vec.vec.x, vec.vec.y, vec.vec.z);
		sphere.render();
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
		Renderer20.set(pose, cons, 0);
		FvtmRenderTypes.setLines();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		V3D vec0, vec1;
		RailPlacingUtil.NewTrack conn = RailPlacingUtil.CL_CURRENT;
		if(conn.preview == null) conn.genpreview();
		Renderer20.setColor(BLUE);
		for(int j = 0; j < conn.track.vecpath.length - 1; j++){
			vec0 = conn.track.vecpath[j];
			vec1 = conn.track.vecpath[j + 1];
			POLY.vertices[0].pos(vec0.x, vec0.y + 0.1f, vec0.z);
			POLY.vertices[1].pos(vec1.x, vec1.y + 0.1f, vec1.z);
			LINE.render();
		}
		int size = RailPlacingUtil.CL_CURRENT.points.size();
		double[] arr;
		Renderer20.setColor(CYAN);
		for(int i = 1; i < size - 1; i++){
			arr = conn.track.getPosition((conn.track.length / (size - 1)) * i);
			vec1 = RailPlacingUtil.CL_CURRENT.points.get(i).vec;
			POLY.vertices[0].pos(arr[0], arr[1] - 0.05f, arr[2]);
			POLY.vertices[1].pos(vec1.x, vec1.y - 0.05f, vec1.z);
			LINE.render();
		}
		Renderer20.setColor(ORG);
		for(ArrayList<V3D> l : conn.preview){
			for(int j = 0; j < l.size() - 1; j++){
				POLY.vertices[0].pos((vec0 = l.get(j)).x, vec0.y + conn.gauge.getHeight() - .01, vec0.z);
				POLY.vertices[1].pos((vec1 = l.get(j + 1)).x, vec1.y + conn.gauge.getHeight() - .01, vec1.z);
				LINE.render();
			}
		}
		pose.popPose();
	}

	private static RootVehicle vehicle;

	@SubscribeEvent
	public static void onLevelRender(RenderGuiOverlayEvent event){
		if(Minecraft.getInstance().player.getVehicle() instanceof RootVehicle && event.getOverlay().id().getPath().equals("hotbar")){
			vehicle = (RootVehicle)Minecraft.getInstance().player.getVehicle();
			VehicleOverlay.RS[] rs = VehicleOverlay.update(vehicle.vehicle);
			for(VehicleOverlay.RS r : rs){
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, r.str, r.x, r.y, 0xffffff);
			}
		}
	}

	@SubscribeEvent
	public static void clientTick(TickEvent.ClientTickEvent event){
		if(event.phase != TickEvent.Phase.START) return;
		SystemManager.onClientTick();
	}

}
