package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.blocks.CylinderSignEntity;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class CylSignRenderer extends TileEntitySpecialRenderer<CylinderSignEntity> {
	
	@Override
	public void render(CylinderSignEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX, posY, posZ);
		Minecraft.getMinecraft().renderEngine.bindTexture(te.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		switch(te.getBlockMetadata()){
			case 2:
				GL11.glTranslated(-1, 0, 0);
				break;
			case 3:
				GL11.glTranslated(0, 0, 1);
				GL11.glRotated(180d, 0, 1, 0);
				break;
			case 4:
				GL11.glRotated(270d, 0, 1, 0);
				break;
			case 5:
				GL11.glTranslated(-1, 0, 1);
				GL11.glRotated( 90d, 0, 1, 0);
				break;
		}
		//
		te.getModel().render();
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}