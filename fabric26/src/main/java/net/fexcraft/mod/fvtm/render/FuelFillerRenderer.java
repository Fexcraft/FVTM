package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.block.FuelFillerEntity;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.Direction;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fcl.util.Renderer26.AY;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerRenderer implements BlockEntityRenderer<FuelFillerEntity, BlockEntityRenderState> {

	public static final IDL TEXTURE = IDLManager.getIDLCached("fvtm:textures/block/fuelfiller.png");
	private static BlockModel MODEL;

	@Override
	public BlockEntityRenderState createRenderState(){
		return new BlockEntityRenderState();
	}

	@Override
	public void submit(BlockEntityRenderState state, PoseStack pose, SubmitNodeCollector nodecoll, CameraRenderState camera){
		RenderUtil26.set(pose, nodecoll, FvtmRenderTypes.getCutout(TEXTURE), state.lightCoords);
		pose.pushPose();
		pose.translate(0.5, 0, 0.5);
		Direction dir = state.blockState.getValue(FACING);
		pose.mulPose(new Quaternionf().rotateAxis(Static.toRadians(dir.getAxis() == Direction.Axis.Z ? dir.toYRot() + 90 : dir.toYRot() - 90), AY));
		if(MODEL == null) MODEL = (BlockModel)FvtmResources.getModel("fvtm:models/block/fuelfiller.fmf", new ModelData(), BlockModel.class);
		if(MODEL != null) RenderUtil26.render(MODEL, DefaultModel.RENDERDATA.clear());
		else RenderUtil26.render(DebugUtils.SPHERE);
		pose.popPose();
	}

	@Override
	public int getViewDistance(){
        return 128;
    }

}
