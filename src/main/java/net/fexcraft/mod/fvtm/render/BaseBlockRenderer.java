package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.block.generated.BlockBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class BaseBlockRenderer extends TileEntitySpecialRenderer<BlockBase.TileEntity> {

    @Override
    public void render(BlockBase.TileEntity tile, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        ModelBase.bindTexture(tile.getBlockData().getTexture());
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotated(tile.getBlockData().getType().getBlockType().getRotationForMeta(tile.getBlockMetadata()), 0, 1, 0);
        tile.getBlockData().getType().getModel().render(tile.getBlockData(), null, null, tile.getCapability(Capabilities.RENDERCACHE, null), tile.getBlockMetadata());
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
