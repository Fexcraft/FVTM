package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.blocks.ContainerTileEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.tmt.Model;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class ContainerBlockRenderer extends TileEntitySpecialRenderer<ContainerTileEntity> {
	
	@Override
	public void render(ContainerTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
		if(!te.isCore()){ return; }
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		double d = 60;
		switch(te.getBlockMetadata()){
			case 2: d = 0; break;
			case 3: d = -180d; break;
			case 4: d = -90; break;
			case 5: d = -270d; break;
		}
		GL11.glRotated(  d, 0, 1D, 0);
		GL11.glRotated(180, 0, 1D, 0);
		ContainerData condata = te.getContainerData();
		if(condata != null){
			if(condata.getContainer().getModel() != null){
				Model.bindTexture(condata.getTexture());
				condata.getContainer().getModel().render(condata);
			}
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}