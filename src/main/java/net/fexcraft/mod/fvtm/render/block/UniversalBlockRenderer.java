package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.blocks.UniversalTileEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

@fTESR
public class UniversalBlockRenderer extends TileEntitySpecialRenderer<UniversalTileEntity> {

    @Override
    public void render(UniversalTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        if(te.getBlockData() == null){ return; }
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        //double d = te.getBlockMetadata() * 22.5d;
        //GL11.glRotated(d, 0, 1, 0);
        GL11.glRotated(90, 0, 1D, 0);
        te.getBlockData().getBlock().getModel().render(te.getBlockData(), te, null, te.getBlockMetadata());
        //
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
