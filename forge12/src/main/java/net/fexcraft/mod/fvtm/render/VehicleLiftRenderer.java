package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.block.Lift2024Model;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleLiftRenderer extends TileEntitySpecialRenderer<VehicleLiftEntity> {

	public static final ResourceLocation TEXTURE = new ResourceLocation("fvtm:textures/block/lift2024.png");
	private VehicleData data;

	@Override
	public void render(VehicleLiftEntity tile, double x, double y, double z, float ticks, int stage, float a){
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y, z + 0.5);
		GL11.glRotated(BlockType.GENERIC_4ROT.getRotationFor(tile.getBlockMetadata()), 0, 1, 0);
		TexUtil.bindTexture(TEXTURE);
		Lift2024Model.center.render();
		data = tile.getVehicleData();
		if(data != null){
			GL11.glPushMatrix();
			GL11.glTranslated(0, tile.liftstate + 0.3125, 0);
			if(data.getType().getModel() != null){
				TexUtil.bindTexture(data.getCurrentTexture());
				data.getType().getModel().render(DefaultModel.RENDERDATA.set(data, null, null, false, ticks));
			}
			if(data.getParts().size() > 0){
				VehicleRenderer.renderPoint(data.getRotationPoint(SwivelPoint.DEFAULT), null, data, null, ticks);
			}
			EffectRenderer.renderVehicleInfo(null, tile.getVehicleDataPos(), data);
			GL11.glPopMatrix();
			TexUtil.bindTexture(TEXTURE);
			for(LiftingPoint[] point : data.getType().getGroupedLiftingPoints().values()){
				GL11.glPushMatrix();
				V3D vec = point.length == 1 ? point[0].pos : point[0].pos.add(point[1].pos).multiply(0.5);
				double dis = point.length > 1 ? Math.abs(point[0].pos.z) + Math.abs(point[1].pos.z) : 0;
				float m = 0;
				if(point.length == 1 || dis <= 0.75){
					if(vec.x > 0){
						GL11.glTranslated(1.75 + vec.x, 0, vec.z);
						GL11.glRotatef(180, 0, 1, 0);
					}
					else{
						GL11.glTranslated(-1.75 + vec.x, 0, vec.z);
						Lift2024Model.motor.render();
					}
					Lift2024Model.struct.render();
					GL11.glTranslated(0, tile.liftstate + vec.y, 0);
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
						GL11.glTranslated((dis < 2.75 ? -r : 0) + 0.75 + vec.x, 0, vec.z);
						GL11.glRotatef(180, 0, 1, 0);
					}
					else{
						GL11.glTranslated((dis < 2.75 ? r : 0) - 0.75 + vec.x, 0, vec.z);
						Lift2024Model.motor.render();
					}
					Lift2024Model.struct.render();
					GL11.glTranslated(0, tile.liftstate + vec.y, 0);
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
				GL11.glPopMatrix();
			}
			Lift2024Model.arm_n.rotate(0, 0, 0, true);
			Lift2024Model.arm_n_e.rotate(0, 0, 0, true);
			Lift2024Model.arm_s.rotate(0, 0, 0, true);
			Lift2024Model.arm_s_e.rotate(0, 0, 0, true);
		}
		else{
			GL11.glTranslated(-2, 0, 0);
			Lift2024Model.struct.render();
			Lift2024Model.motor.render();
			Lift2024Model.lift.render();
			Lift2024Model.arm_n.render();
			Lift2024Model.arm_n_e.render();
			Lift2024Model.arm_s.render();
			Lift2024Model.arm_s_e.render();
			GL11.glTranslated(4, 0, 0);
			GL11.glRotatef(180, 0, 1, 0);
			Lift2024Model.struct.render();
			Lift2024Model.lift.render();
			Lift2024Model.arm_n.render();
			Lift2024Model.arm_n_e.render();
			Lift2024Model.arm_s.render();
			Lift2024Model.arm_s_e.render();
		}
		GL11.glPopMatrix();
	}

}
