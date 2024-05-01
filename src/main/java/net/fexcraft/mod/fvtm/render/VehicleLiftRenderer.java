package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.block.VehicleLiftEntity;
import net.fexcraft.mod.fvtm.data.block.BlockType;
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

	@Override
	public void render(VehicleLiftEntity tile, double x, double y, double z, float ticks, int stage, float a){
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y, z + 0.5);
		GL11.glRotated(BlockType.GENERIC_4ROT.getRotationFor(tile.getBlockMetadata()), 0, 1, 0);
		TexUtil.bindTexture(TEXTURE);
		Lift2024Model.control.render();
		Lift2024Model.struct.render();
		if(tile.getVehicleData() != null && tile.getVehicleData().getType().getModel() != null){
			TexUtil.bindTexture(tile.getVehicleData().getCurrentTexture() );
			tile.getVehicleData().getType().getModel().render(Lift2024Model.RENDERDATA);
		}
		GL11.glPopMatrix();
	}

}
