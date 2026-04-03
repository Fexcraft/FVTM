package net.fexcraft.mod.fvtm.render;

import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleRenderer {

	public static void renderVehicles(LevelRenderContext event){
		/*Camera camera = event.camera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.matrixStack();
		Renderer26.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), light);
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer26.resetColor();
		for(Map.Entry<V3D, JackEntity> entry : JACKS.entrySet()){
			JACK_BE jack = (JACK_BE)entry.getValue();
			if(jack.getVehicle() == null) continue;
			pose.pushPose();
			RENDERER.translate(entry.getKey());
			pose.mulPose(new Quaternionf()
				.rotateAxis((float)Static.toRadians(getRot(jack.getBlockState())), AY)
			);
			//
			light = LevelRenderer.getLightColor(Minecraft.getInstance().level, jack.getBlockPos());
			pose.pushPose();
			Model vehmod = jack.getVehicle().getType().getModel();
			FvtmRenderTypes.setCutout(jack.getVehicle().getCurrentTexture());
			if(vehmod != null){
				pose.pushPose();
				vehmod.render(RENDERDATA.set(jack.getVehicle(), null, event.camera().getPartialTickTime()).rc(null));
				pose.popPose();
			}
			if(jack.getVehicle().getParts().size() > 0){
				renderPoint(pose, jack.getVehicle().getRotationPoint(DEFAULT), null, jack.getVehicle(), null, event.camera().getPartialTickTime());
			}
			renderVehicleInfo(pose, jack.getVehiclePos(), jack.getVehicle());
			pose.popPose();
			//
			pose.popPose();
		}
		pose.popPose();
		JACKS.clear();*/
	}

}
