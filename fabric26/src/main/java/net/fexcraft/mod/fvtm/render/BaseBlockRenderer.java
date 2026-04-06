package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.block.generated.BaseBlockEntity;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.render.state.BlockRS;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fcl.util.Renderer26.AY;
import static net.fexcraft.mod.fvtm.render.RenderUtil.RENDER_UTIL;
import static net.fexcraft.mod.fvtm.util.BlockTypeImpl.getRot;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BaseBlockRenderer implements BlockEntityRenderer<BaseBlockEntity, BlockRS> {

	private double rot;

	@Override
	public BlockRS createRenderState(){
		return new BlockRS();
	}

	@Override
	public void extractRenderState(BaseBlockEntity ent, BlockRS state, float partialTicks, Vec3 cpos, ModelFeatureRenderer.CrumblingOverlay breakProgress){
		BlockEntityRenderer.super.extractRenderState(ent, state, partialTicks, cpos, breakProgress);
		state.fvtmData = ent.getBlockData();
		state.blockEntity = ent;
	}

	@Override
	public void submit(BlockRS state, PoseStack pose, SubmitNodeCollector nodecoll, CameraRenderState camera){
		if(state.fvtmData == null) return;
		pose.pushPose();
		pose.translate(0.5, 0, 0.5);
		//
		rot = getRot(state.blockState);
		if(rot != 0d){
			pose.mulPose(new Quaternionf().rotateAxis((float)Static.toRadians(rot), AY));
		}
		RenderUtil26.set(pose, nodecoll, FvtmRenderTypes.getCutout(state.fvtmData.getCurrentTexture()), state.lightCoords);
		RENDER_UTIL.render(state.fvtmData.getType().getModel(), DefaultModel.RENDERDATA.set(state.fvtmData, state.blockEntity, null));
 		//
		pose.popPose();
	}

	@Override
	public int getViewDistance(){
        return 128;
    }

}
