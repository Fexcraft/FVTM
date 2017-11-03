package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.ConstructorCenterEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class ConstructorCenterRenderer extends TileEntitySpecialRenderer<ConstructorCenterEntity> {
	
	private static final ModelConstructorCenter model = new ModelConstructorCenter();
	
	@Override
	public void render(ConstructorCenterEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		double d = 60;
		switch(te.getBlockMetadata()){
			case 2:
				d = 0;
				break;
			case 3:
				d = -180d;
				break;
			case 4:
				d = -90;
				break;
			case 5:
				d = -270d;
				break;
		}
		GL11.glRotated(d, 0, 1, 0);
		GL11.glRotated(90 , 0, 1D, 0);
		VehicleData vehicledata = te.getVehicleData();
		if(vehicledata != null){
			VehicleModel<VehicleData>modvec = vehicledata.getVehicle().getModel();
			if(modvec != null){
				Minecraft.getMinecraft().renderEngine.bindTexture(vehicledata.getTexture());
				GL11.glTranslated(0, (vehicledata.getVehicle().getYAxisConstructorOffset() * 0.0625f) - te.getLiftState(), 0);
				modvec.render(vehicledata, null, te.getBlockMetadata());
				vehicledata.getParts().forEach((key, partdata) -> {
					Minecraft.getMinecraft().renderEngine.bindTexture(partdata.getTexture());
					partdata.getPart().getOffsetFor(vehicledata.getVehicle().getRegistryName()).translate();
					partdata.getPart().getModel().render(vehicledata, key);
					partdata.getPart().getOffsetFor(vehicledata.getVehicle().getRegistryName()).translateR();
				});
				GL11.glTranslated(0, (vehicledata.getVehicle().getYAxisConstructorOffset() * -0.0625f) + te.getLiftState(), 0);
				Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
			}
			else{
				//Static.exception(4, "Model is null.");
			}
		}
		else{
			if(te.getConstructor() != null){
				te.link(te.getConstructor());
			}
		}
		//
		GL11.glTranslatef(0, 0, te.getRenderOffset());
		renderLP(te, vehicledata, model.bodyModel);
		GL11.glTranslatef(0, 0, -(te.getRenderOffset() * 2));
		GL11.glRotated(180, 0, 1, 0);
		renderLP(te, vehicledata, model.bodyModel);
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
	private static final void renderLP(ConstructorCenterEntity te, VehicleData data, ModelRendererTurbo[] turbo){
		if(data != null){
			for(int i = 0; i < 5; i++){
				turbo[0].render();
				turbo[1].render();
				turbo[2].render();
				data.getSecondaryColor().glColorApply();
				turbo[3].render();
				turbo[4].render();
				RGB.glColorReset();
				data.getPrimaryColor().glColorApply();
				turbo[5].render();
				RGB.glColorReset();
				if(i != 4){
					GL11.glTranslated(0, -1, 0);
				}
			}
			GL11.glTranslated(0, 4, 0);
		}
		GL11.glTranslated(0, -te.getLiftState(), 0);
		model.render(model.trailerModel);
		GL11.glTranslatef(te.getLength() + 1, 0, 0);
		for(int i = 0; i < te.getRenderLength(); i++){
			GL11.glTranslatef(-1, 0, 0);
			model.render(model.turretModel);
		}
		GL11.glTranslatef(te.getLength(), 0, 0);
		GL11.glTranslated(0, te.getLiftState(), 0);
	}
	
}