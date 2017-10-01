package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorController;
import net.fexcraft.mod.fvtm.render.Renderer;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class ConstructorControllerRender extends TileEntitySpecialRenderer<ConstructorControllerEntity.Client> {
	
	private static final ModelConstructorController model = new ModelConstructorController();
	
	@Override
	public void render(ConstructorControllerEntity.Client te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX, posY, posZ);
		Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
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
		model.render(model.bodyModel);
		//Buttons
		{
			for(int i = 0; i < model.turretModel.length; i++){
				/*switch(i){
					case 0:{ RGB.GREEN.glColorApply(); }
					case 1:{ ConstructorControllerEntity.ORANGE.glColorApply(); }
					default:{ ConstructorControllerEntity.GRAY.glColorApply(); }
				}*/
				model.turretModel[i].render();
				//RGB.glColorReset();
			}
		}
		{
			model.steeringWheelModel[0].rotateAngleX = te.lift * Static.rad5;
			model.steeringWheelModel[1].rotateAngleX = te.lift * Static.rad5;
			model.render(model.steeringWheelModel);
		}
		this.setLightmapDisabled(true);
		for(int i = 0; i < 8; i++){
            Renderer.drawNameplate(this.getFontRenderer(), Formatter.format((i == te.selection ? "&e> " : "&7> ") + "&0" + te.text[i]), 0.09375f, -1.6775f + (i * 0.064f), 0.81f, 0, 0, 0, false, false);
		}
        this.setLightmapDisabled(false);
		//DEBUG
		/*if(te.hitX != 0 && te.hitY != 0 && te.hitZ != 0){
			GL11.glRotated(-d, 0, 1, 0);
			GL11.glRotatef(-180F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslated(te.hitX, te.hitY, te.hitZ);
			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
			ModelHitbox.instance().render();
		}*/
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}