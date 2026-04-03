package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.block.generated.BaseBlockEntity;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fcl.util.Renderer21.AY;
import static net.fexcraft.mod.fvtm.util.BlockTypeImpl.getRot;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BaseBlockRenderer implements BlockEntityRenderer<BaseBlockEntity, BERS> {

	private double rot;

	@Override
	public BERS createRenderState(){
		return new BERS();
	}

	@Override
	public void extractRenderState(BaseBlockEntity ent, BERS state, float partialTicks, Vec3 cpos, ModelFeatureRenderer.CrumblingOverlay breakProgress){
		BlockEntityRenderer.super.extractRenderState(ent, state, partialTicks, cpos, breakProgress);
		state.fvtmData = ent.getBlockData();
	}

	@Override
	public void submit(BERS state, PoseStack pose, SubmitNodeCollector nodecoll, CameraRenderState camera){
		if(state.fvtmData == null) return;
		pose.pushPose();
		pose.translate(0.5, 0, 0.5);
		//
		rot = getRot(state.blockState);
		if(rot != 0d){
			pose.mulPose(new Quaternionf().rotateAxis((float)Static.toRadians(rot), AY));
		}
		RenderUtil26.set(pose, nodecoll, FvtmRenderTypes.getCutout(state.fvtmData.getCurrentTexture()), state.lightCoords);
		RenderUtil26.render(state.fvtmData.getType().getModel(), DefaultModel.RENDERDATA.set(state.fvtmData, state, null));
 		//
		pose.popPose();
	}

	@Override
	public int getViewDistance(){
        return 128;
    }

}
