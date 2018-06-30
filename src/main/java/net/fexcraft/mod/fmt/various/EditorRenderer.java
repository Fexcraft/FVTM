package net.fexcraft.mod.fmt.various;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fmt.block.EditorTileEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class EditorRenderer extends TileEntitySpecialRenderer<EditorTileEntity> {
	
    @Override
    public void render(EditorTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        if(te.modeldata == null){ return; }
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        te.modeldata.models.values().forEach(sub -> sub.forEach(mrt -> mrt.render()));
        //
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
    
}