package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.block.generated.BaseBlockEntity;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;
import static net.fexcraft.mod.fvtm.render.Renderer20.AY;

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
		rot = getRot(data, tile.getBlockState());
		if(rot != 0d){
			pose.mulPose(new Quaternionf().rotateAxis((float)Static.toRadians(rot), AY));
		}
		data.getType().getModel().render(DefaultModel.RENDERDATA.set(data, tile, null));
 		//
		pose.popPose();
	}

	public static double getRot(BlockData data, BlockState state){
		if(data.getBlockType().rotations == 4 || data.getBlockType().rotations == 44){
			switch(state.getValue(FACING).ordinal()){
				case 2: return 90;
				case 3: return -90;
				case 4: return 180;
				case 5: return 0;
			}
		}
		else if(data.getBlockType().rotations == 8){
			return state.getValue(PROP_ROT8) * -45 + 90;
		}
		else if(data.getBlockType().rotations == 16){
			return state.getValue(PROP_ROT16) * -22.5 + 90;
		}
		return 0;
	}

	@Override
	public int getViewDistance(){
        return 128;
    }

}
