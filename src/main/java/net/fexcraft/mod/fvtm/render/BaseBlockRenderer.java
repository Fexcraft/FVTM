package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class BaseBlockRenderer extends TileEntitySpecialRenderer<BlockTileEntity> {
	
	private BlockData data = null;
    private BlockModel model = null;

    @Override
    public void render(BlockTileEntity tile, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        if((data = tile.getBlockData()) == null) return;
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        model = (BlockModel)data.getType().getModel();
        TexUtil.bindTexture(model.bindtex ? data.getCurrentTexture().local() : Resources.WHITE_TEXTURE);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotated(data.getType().getBlockType().getRotationFor(tile.getBlockMetadata()), 0, 1, 0);
        model.render(BlockModel.RENDERDATA.set(data, tile, tile.getCapability(Capabilities.RENDERCACHE, null), null, false));
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
