package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.data.block.BlockType;
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
		Lift2024Model.control.render();
		Lift2024Model.struct.render();
		data = tile.getVehicleData();
		if(data != null){
			GL11.glTranslated(0.75 + tile.mleft, tile.liftstate, 0);
			if(data.getType().getModel() != null){
				TexUtil.bindTexture(data.getCurrentTexture());
				data.getType().getModel().render(DefaultModel.RENDERDATA.set(data, null, null, false, ticks));
			}
			if(data.getParts().size() > 0){
				VehicleRenderer.renderPoint(data.getRotationPoint(SwivelPoint.DEFAULT), null, data, null, ticks);
			}
			GL11.glTranslated(0.75 - tile.mrigh, -tile.liftstate, 0);
			GL11.glRotatef(180, 0, 1, 0);
			TexUtil.bindTexture(TEXTURE);
			Lift2024Model.struct.render();
		}
		GL11.glPopMatrix();
	}

}
