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
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;
import static net.fexcraft.mod.fvtm.render.Renderer20.AY;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerRenderer implements BlockEntityRenderer<FuelFillerEntity> {

	public static final IDL TEXTURE = IDLManager.getIDLCached("fvtm:textures/block/fuelfiller.png");
	private static BlockModel MODEL;

	@Override
	public void render(FuelFillerEntity tile, float ticks, PoseStack pose, MultiBufferSource buffer, int light, int overlay){
		Renderer20.pose = pose;
		Renderer20.set(pose, buffer, light, overlay);
		FvtmRenderTypes.setCutout(TEXTURE);
		pose.pushPose();
		pose.translate(0.5, 0, 0.5);
		Direction dir = tile.getBlockState().getValue(FACING);
		pose.mulPose(new Quaternionf().rotateAxis(Static.toRadians(dir.getAxis() == Direction.Axis.Z ? dir.toYRot() + 90 : dir.toYRot() - 90), AY));
		if(MODEL == null) MODEL = (BlockModel)FvtmResources.getModel("fvtm:models/block/fuelfiller.fmf", new ModelData(), BlockModel.class);
		if(MODEL != null) MODEL.render(DefaultModel.RENDERDATA.clear());
		else DebugUtils.SPHERE.render();
		pose.popPose();
	}

	@Override
	public int getViewDistance(){
        return 128;
    }

}
