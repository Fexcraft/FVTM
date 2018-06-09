package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.blocks.UniversalTileEntity;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

@fTESR
public class UniversalBlockRenderer extends TileEntitySpecialRenderer<UniversalTileEntity> {

    @Override
    public void render(UniversalTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        if(te.getBlockData() == null || !te.isCore()){ return; }
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(te.getBlockData().getTexture());
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        switch(te.getBlockMetadata()){
        	case 2: GL11.glRotated(180, 0, 1D, 0); break;
        	case 3: GL11.glRotated(  0, 0, 1D, 0); break;
        	case 4: GL11.glRotated( 90, 0, 1D, 0); break;
        	case 5: GL11.glRotated(270, 0, 1D, 0); break;
        }
        te.getBlockData().getBlock().getModel().render(te.getBlockData(), te, null, te.getBlockMetadata());
        //
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
