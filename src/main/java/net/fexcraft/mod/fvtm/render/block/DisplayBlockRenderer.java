package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.ConstructorCenterEntity;
import net.fexcraft.mod.fvtm.blocks.DisplayBlockEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.model.block.ModelEmptyCyl;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

@fTESR
public class DisplayBlockRenderer extends TileEntitySpecialRenderer<DisplayBlockEntity> {
	
	@Override
	public void render(DisplayBlockEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		double d = te.getBlockMetadata() * 22.5d;
		GL11.glRotated(d, 0, 1, 0);
		GL11.glRotated(90 , 0, 1D, 0);
		Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
		ModelEmptyCyl.INSTANCE.render();
		//
		VehicleData vehicledata = te.getVehicleData();
		if(vehicledata != null){
			VehicleModel<VehicleData> modvec = vehicledata.getVehicle().getModel();
			if(modvec != null){
				Minecraft.getMinecraft().renderEngine.bindTexture(vehicledata.getTexture());
				GL11.glTranslated(0, (vehicledata.getVehicle().getYAxisConstructorOffset() + 2) *  0.0625f, 0);
				modvec.render(vehicledata, null, te.getBlockMetadata());
				vehicledata.getParts().forEach((key, partdata) -> {
					Minecraft.getMinecraft().renderEngine.bindTexture(partdata.getTexture());
					partdata.getPart().getOffsetFor(vehicledata.getVehicle().getRegistryName()).translate();
					partdata.getPart().getModel().render(vehicledata, key);
					partdata.getPart().getOffsetFor(vehicledata.getVehicle().getRegistryName()).translateR();
				});
				GL11.glTranslated(0, (vehicledata.getVehicle().getYAxisConstructorOffset() + 2) * -0.0625f, 0);
				Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
			}
			else{
				Print.debug("MODEL IS NULL");
			}
		}
		else{
			//
		}
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}