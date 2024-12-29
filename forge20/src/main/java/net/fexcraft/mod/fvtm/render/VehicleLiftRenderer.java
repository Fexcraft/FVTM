package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.block.Lift2024Model;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.resources.ResourceLocation;
import org.joml.Quaternionf;

import static net.fexcraft.lib.common.Static.rad180;
import static net.fexcraft.mod.fvtm.render.Renderer120.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleLiftRenderer implements BlockEntityRenderer<VehicleLiftEntity> {

	public static final IDL TEXTURE = IDLManager.getIDLCached("fvtm:textures/block/lift2024.png");
	private VehicleData data;

	@Override
	public void render(VehicleLiftEntity tile, float ticks, PoseStack pose, MultiBufferSource buffer, int light, int overlay){
		Renderer120.pose = pose;
		Renderer120.set(pose, buffer, light, overlay);
		FvtmRenderTypes.setCutout(TEXTURE);
		pose.pushPose();
		pose.translate(0.5, 0, 0.5);
		if(tile.rot != 0){
			pose.mulPose(new Quaternionf().rotateAxis((float)Static.toRadians(BlockType.GENERIC_4ROT.getRotationFor(tile.rot)), AY));
		}
		ChestRenderer e;
		Lift2024Model.center.render();
		data = tile.getVehicleData();
		if(data != null){
			pose.pushPose();
			pose.translate(0, tile.liftstate + 0.3125, 0);
			if(data.getType().getModel() != null){
				FvtmRenderTypes.setCutout(data.getCurrentTexture());
				data.getType().getModel().render(DefaultModel.RENDERDATA.set(data, null, null, false, ticks));
			}
			if(data.getParts().size() > 0){
				RVRenderer.renderPoint(pose, data.getRotationPoint(SwivelPoint.DEFAULT), null, data, null, ticks);
			}
			V3D vdp = tile.getVehicleDataPos();
			if(RVRenderer.isInRange(pose, vdp, data)){
				RVRenderer.renderVehicleInfo(pose, vdp, data);
			}
			pose.popPose();
			FvtmRenderTypes.setCutout(TEXTURE);
			for(LiftingPoint[] point : data.getType().getGroupedLiftingPoints().values()){
				pose.pushPose();
				V3D vec = point.length == 1 ? point[0].pos : point[0].pos.add(point[1].pos).multiply(0.5);
				double dis = point.length > 1 ? Math.abs(point[0].pos.z) + Math.abs(point[1].pos.z) : 0;
				float m = 0;
				if(point.length == 1 || dis <= 0.75){
					if(vec.x > 0){
						pose.translate(1.75 + vec.x, 0, vec.z);
						rotateRad(pose, rad180, AY);
					}
					else{
						pose.translate(-1.75 + vec.x, 0, vec.z);
						Lift2024Model.motor.render();
					}
					Lift2024Model.struct.render();
					pose.translate(0, tile.liftstate + vec.y, 0);
					Lift2024Model.lift.render();
					Lift2024Model.arm_n.rotate(0, -90, 0, true);
					Lift2024Model.arm_n_e.rotate(0, -90, 0, true);
					Lift2024Model.arm_s.rotate(0, 90, 0, true);
					Lift2024Model.arm_s_e.rotate(0, 90, 0, true);
					Lift2024Model.arm_n.render();
					Lift2024Model.arm_n_e.render();
					Lift2024Model.arm_s.render();
					Lift2024Model.arm_s_e.render();
				}
				else{
					float r = (float)(2 - dis - 0.75) * 0.5f;
					if(vec.x > 0){
						pose.translate((dis < 2.75 ? -r : 0) + 0.75 + vec.x, 0, vec.z);
						rotateRad(pose, rad180, AY);
					}
					else{
						pose.translate((dis < 2.75 ? r : 0) - 0.75 + vec.x, 0, vec.z);
						Lift2024Model.motor.render();
					}
					Lift2024Model.struct.render();
					pose.translate(0, tile.liftstate + vec.y, 0);
					Lift2024Model.lift.render();
					//
					if(dis < 2.75){
						r *= 90;
						Lift2024Model.arm_n.rotate(0, r, 0, true);
						Lift2024Model.arm_n_e.rotate(0, r, 0, true);
						Lift2024Model.arm_s.rotate(0, -r, 0, true);
						Lift2024Model.arm_s_e.rotate(0, -r, 0, true);
					}
					else{
						m = dis > 4.75 ? 1 : (float)((dis - 2.75) * 0.5);
						Lift2024Model.arm_n_e.translate(0, 0, -m, false);
						Lift2024Model.arm_s_e.translate(0, 0, m, false);
					}
					//
					Lift2024Model.arm_n.render();
					Lift2024Model.arm_n_e.render();
					Lift2024Model.arm_s.render();
					Lift2024Model.arm_s_e.render();
					if(m != 0f){
						Lift2024Model.arm_n_e.translate(0, 0, m, false);
						Lift2024Model.arm_s_e.translate(0, 0, -m, false);
					}
				}
				pose.popPose();
			}
			Lift2024Model.arm_n.rotate(0, 0, 0, true);
			Lift2024Model.arm_n_e.rotate(0, 0, 0, true);
			Lift2024Model.arm_s.rotate(0, 0, 0, true);
			Lift2024Model.arm_s_e.rotate(0, 0, 0, true);
		}
		else{
			pose.translate(-2, 0, 0);
			Lift2024Model.struct.render();
			Lift2024Model.motor.render();
			Lift2024Model.lift.render();
			Lift2024Model.arm_n.render();
			Lift2024Model.arm_n_e.render();
			Lift2024Model.arm_s.render();
			Lift2024Model.arm_s_e.render();
			pose.translate(4, 0, 0);
			rotateRad(pose, rad180, AY);
			Lift2024Model.struct.render();
			Lift2024Model.lift.render();
			Lift2024Model.arm_n.render();
			Lift2024Model.arm_n_e.render();
			Lift2024Model.arm_s.render();
			Lift2024Model.arm_s_e.render();
		}
		pose.popPose();
	}

	@Override
	public int getViewDistance(){
        return 128;
    }

}
