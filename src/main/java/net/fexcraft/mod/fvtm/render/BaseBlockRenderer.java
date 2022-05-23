package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class BaseBlockRenderer extends TileEntitySpecialRenderer<BlockTileEntity> {

    @Override
    public void render(BlockTileEntity tile, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        TexUtil.bindTexture(tile.getBlockData().getCurrentTexture());
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotated(tile.getBlockData().getType().getBlockType().getRotationForMeta(tile.getBlockMetadata()), 0, 1, 0);
        tile.getBlockData().getType().getModel().render(BlockModel.RENDERDATA.set(tile.getBlockData(), tile, tile.getCapability(Capabilities.RENDERCACHE, null)));
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
