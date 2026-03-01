package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fcl.util.Renderer20;
import net.fexcraft.mod.fvtm.block.generated.JACK_BE;
import net.fexcraft.mod.fvtm.data.block.JackEntity;
import net.fexcraft.mod.fvtm.model.Model;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Quaternionf;

import java.util.Map;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fcl.util.Renderer20.*;
import static net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint.DEFAULT;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.RVRenderer.*;
import static net.fexcraft.mod.fvtm.render.SeparateRenderCache.*;
import static net.fexcraft.mod.fvtm.util.BlockTypeImpl.getRot;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class VehicleRenderer {

	@SubscribeEvent
	public static void renderSeparate(RenderLevelStageEvent event){
		if(JACKS.isEmpty()) return;
		Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		Renderer20.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), light);
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer20.setColor(RGB.WHITE);
		for(Map.Entry<V3D, JackEntity> entry : JACKS.entrySet()){
			JACK_BE jack = (JACK_BE)entry.getValue();
			if(jack.getVehicle() == null) continue;
			pose.pushPose();
			RENDERER.translate(entry.getKey());
			pose.mulPose(new Quaternionf()
				.rotateAxis((float)Static.toRadians(getRot(jack.getBlockState())), AY)
			);
			light = LevelRenderer.getLightColor(Minecraft.getInstance().level, jack.getBlockPos());
			//
			pose.pushPose();
			Model vehmod = jack.getVehicle().getType().getModel();
			FvtmRenderTypes.setCutout(jack.getVehicle().getCurrentTexture());
			if(vehmod != null){
				pose.pushPose();
				vehmod.render(RENDERDATA.set(jack.getVehicle(), null, event.getPartialTick()).rc(null));
				pose.popPose();
			}
			if(jack.getVehicle().getParts().size() > 0){
				renderPoint(pose, jack.getVehicle().getRotationPoint(DEFAULT), null, jack.getVehicle(), null, event.getPartialTick());
			}
			renderVehicleInfo(pose, jack.getVehiclePos(), jack.getVehicle());
			pose.popPose();
			//
			pose.popPose();
		}
		pose.popPose();
		JACKS.clear();
	}

}
