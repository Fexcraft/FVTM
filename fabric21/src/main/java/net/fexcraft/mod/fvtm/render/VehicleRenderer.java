package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.block.generated.JACK_BE;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.data.block.JackEntity;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

import java.util.Map;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.Config.DISABLE_SIGNS;
import static net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint.DEFAULT;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.RVRenderer.renderPoint;
import static net.fexcraft.mod.fvtm.render.RVRenderer.renderVehicleInfo;
import static net.fexcraft.mod.fvtm.render.Renderer21.AY;
import static net.fexcraft.mod.fvtm.render.Renderer21.light;
import static net.fexcraft.mod.fvtm.render.SeparateRenderCache.JACKS;
import static net.fexcraft.mod.fvtm.util.BlockTypeImpl.getRot;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_ORG;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_RED;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleRenderer {

	public static void renderVehicles(WorldRenderContext event){
		Camera camera = event.camera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.matrixStack();
		Renderer21.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), light);
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer21.resetColor();
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
		JACKS.clear();
	}

}
