package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fcl.util.Renderer20;
import net.fexcraft.mod.fvtm.block.generated.BaseBlockEntity;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fcl.util.Renderer20.AY;
import static net.fexcraft.mod.fvtm.util.BlockTypeImpl.getRot;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BaseBlockRenderer implements BlockEntityRenderer<BaseBlockEntity> {

	private BlockData data;
	private double rot;

	@Override
	public void render(BaseBlockEntity tile, float ticks, PoseStack pose, MultiBufferSource buffer, int light, int overlay){
		data = tile.getBlockData();
		if(data == null) return;
		Renderer20.pose = pose;
		Renderer20.set(pose, buffer, light, overlay);
		FvtmRenderTypes.setCutout(data.getCurrentTexture());
		pose.pushPose();
		pose.translate(0.5, 0, 0.5);
		//
		rot = getRot(tile.getBlockState());
		if(rot != 0d){
			pose.mulPose(new Quaternionf().rotateAxis((float)Static.toRadians(rot), AY));
		}
		data.getType().getModel().render(DefaultModel.RENDERDATA.set(data, tile, null));
 		//
		pose.popPose();
	}

	@Override
	public int getViewDistance(){
        return 128;
    }

}
