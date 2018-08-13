package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.blocks.RoadLineTile;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

@fTESR
public class RoadLineRender extends TileEntitySpecialRenderer<RoadLineTile> {

    @Override
    public void render(RoadLineTile te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	if(te.lines == null || te.lines.length == 0){
            GL11.glPushMatrix();
            GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
            Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotated(90, 0, 1D, 0);
            Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
            RailConnRenderer.model.render();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    	}
    	else if(te.lines.length > 0){
            //
    	}
    }

}
