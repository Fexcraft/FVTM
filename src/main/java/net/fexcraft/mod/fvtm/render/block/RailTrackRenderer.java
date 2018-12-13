package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.blocks.rail.TrackTileEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.model.block.ModelRailSTD125Half;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

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
	public void render(TrackTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
		if(te.connections == null || te.connections.length < 2){
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
		}
		if(te.gauge == null || te.gauge.getModel() == null) return;
		GL11.glPushMatrix();
		GL11.glTranslated(posX, posY - 0.5, posZ);
		GL11.glPushMatrix();
		ModelRailSTD125Half.bindTexture();
		for(int i = 0; i < te.connections.length; i++){
			te.gauge.getModel().render(te, te.connections[i], null, i);
		}
		GL11.glPopMatrix(); GL11.glPopMatrix();
	}

}
