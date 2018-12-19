package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.blocks.rail.TrackTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

/** @author Ferdinand Calo' (FEX___96) **/
@fTESR
public class RailTrackRenderer extends TileEntitySpecialRenderer<TrackTileEntity> {
	
	protected static final ModelRendererTurbo model, model0;
	static{
		model = new ModelRendererTurbo(null, 0, 0, 32, 32);
		model.addCylinder(0, 0, 0, 3, 5, 32, 1, 1, ModelRendererTurbo.MR_TOP);
		model.setRotationPoint(0, -5, 0);
		model0 = new ModelRendererTurbo(null, 0, 0, 32, 32);
		model0.addCylinder(-12, 0, 0, 4, 16, 6, 1.2f, 1, ModelRendererTurbo.MR_TOP);
		model0.setRotationPoint(0, 0, 0);
	}

	@Override
	public void render(TrackTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float alpha){
		/*if(te.entry == null || te.entry.getValue().length < 2){
			GL11.glPushMatrix();
			GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
			ModelBase.bindTexture(ModelConstructorCenter.getTexture());
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotated(90, 0, 1D, 0);
			ModelBase.bindTexture(Resources.NULL_TEXTURE);
			model.render();
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}*/
		if(te.entry == null){
			/*Print.debug("norender0");*/ return;
		}
		if(te.entry.getValue().length < 1){
			Print.debug("norender1"); return;
		}
		if(te.entry.getValue()[0].getGauge().getModel() == null){
			Print.debug("norender2"); return;
		}
		GL11.glPushMatrix();
		GL11.glTranslated(posX, posY - 0.5, posZ);
		GL11.glPushMatrix();
		ModelBase.bindTexture(te.entry.getValue()[0].getGauge().getTexture());
		for(int i = 0; i < te.entry.getValue().length; i++){
			te.entry.getValue()[0].getGauge().getModel().render(te.entry, te.entry.getValue()[i], null, i);
		}
		GL11.glPopMatrix(); GL11.glPopMatrix();
	}
	
	@Override
    public boolean isGlobalRenderer(TrackTileEntity tileentity){ return true; }

}
