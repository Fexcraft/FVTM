package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.block.generated.BaseBlockEntity;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.block.Lift2024Model;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import org.joml.Quaternionf;

import static net.fexcraft.lib.common.Static.rad180;
import static net.fexcraft.mod.fvtm.render.Renderer120.AY;
import static net.fexcraft.mod.fvtm.render.Renderer120.rotateRad;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BaseBlockRenderer implements BlockEntityRenderer<BaseBlockEntity> {

	private BlockData data;

	@Override
	public void render(BaseBlockEntity tile, float ticks, PoseStack pose, MultiBufferSource buffer, int light, int overlay){
		data = tile.getBlockData();
		if(data == null) return;
		Renderer120.pose = pose;
		Renderer120.set(pose, buffer, light, overlay);
		FvtmRenderTypes.setCutout(data.getCurrentTexture());
		pose.pushPose();
		pose.translate(0.5, 0, 0.5);
		//
		data.getType().getModel().render(DefaultModel.RENDERDATA.set(data, tile, null, null, false));
 		//
		pose.popPose();
	}

	@Override
	public int getViewDistance(){
        return 128;
    }

}
