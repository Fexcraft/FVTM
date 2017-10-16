package net.fexcraft.mod.fme.blocks;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class EditorBlockRenderer extends TileEntitySpecialRenderer<EditorTileEntity> {
	
	private static final ModelEditor model = new ModelEditor();
	
	@Override
	public void render(EditorTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
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
		if(te.vehicledata != null){
			VehicleModel<VehicleData> modvec = te.vehicledata.getVehicle().getModel();
			if(modvec != null){
				Minecraft.getMinecraft().renderEngine.bindTexture(te.vehicledata.getTexture());
				GL11.glTranslated(0, (te.vehicledata.getVehicle().getYAxisConstructorOffset() * 0.0625f), 0);
				modvec.render(te.vehicledata, null, te.getBlockMetadata());
				te.vehicledata.getParts().forEach((key, partdata) -> {
					Minecraft.getMinecraft().renderEngine.bindTexture(partdata.getTexture());
					partdata.getPart().getOffsetFor(te.vehicledata.getVehicle().getRegistryName()).translate();
					partdata.getPart().getModel().render(te.vehicledata, key);
					partdata.getPart().getOffsetFor(te.vehicledata.getVehicle().getRegistryName()).translateR();
				});
				GL11.glTranslated(0, (te.vehicledata.getVehicle().getYAxisConstructorOffset() * -0.0625f), 0);
			}
			else{
				//Static.exception(4, "Model is null.");
			}
		}
		else{
			//
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
		model.core.render();
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}