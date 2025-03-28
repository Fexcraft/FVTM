package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.block.FuelFillerEntity;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerRenderer extends TileEntitySpecialRenderer<FuelFillerEntity> {

	public static final ResourceLocation TEXTURE = new ResourceLocation("fvtm:textures/block/fuelfiller.png");
	public static BlockModel MODEL;

	@Override
	public void render(FuelFillerEntity tile, double x, double y, double z, float ticks, int stage, float a){
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y, z + 0.5);
		GL11.glRotated(BlockType.GENERIC_4ROT.getRotationFor(tile.getBlockMetadata()) - 180, 0, 1, 0);
		TexUtil.bindTexture(TEXTURE);
		if(MODEL == null) MODEL = (BlockModel)FvtmResources.getModel("fvtm:models/block/fuelfiller.fmf", new ModelData(), BlockModel.class);
		if(MODEL != null) MODEL.render(DefaultModel.RENDERDATA.clear());
		GL11.glPopMatrix();
	}

}
