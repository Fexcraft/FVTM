package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class BaseBlockRenderer extends TileEntitySpecialRenderer<BlockTileEntity> {
	
	private BlockData data = null;
    private BlockModel model = null;

    @Override
    public void render(BlockTileEntity tile, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        data = tile.getBlockData();
        model = (BlockModel) data.getType().getModel();
        if(model.bindtex) TexUtil.bindTexture(data.getCurrentTexture());
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotated(data.getType().getBlockType().getRotationForMeta(tile.getBlockMetadata()), 0, 1, 0);
        model.render(BlockModel.RENDERDATA.set(data, tile, tile.getCapability(Capabilities.RENDERCACHE, null)));
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
