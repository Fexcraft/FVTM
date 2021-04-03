package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.math.Vec3d;

@fTESR
public class DisplayBlockRenderer extends TileEntitySpecialRenderer<DisplayEntity> {
	
	private static float heightoffset = 0;

    @Override
    public void render(DisplayEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(te.getBlockMetadata() * 22.5f, 0, 1, 0);
        GL11.glRotatef(90, 0, 1f, 0);
        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
        RenderCache cache = te.getCapability(Capabilities.RENDERCACHE, null);
        heightoffset = 0;
        //
        if(te.getVehicleData() != null){
            VehicleData vehicledata = te.getVehicleData();
            Model<VehicleData, Object> modvec = vehicledata.getType().getModel();
            if(modvec != null){
                ModelBase.bindTexture(vehicledata.getTexture());
                if(!vehicledata.getWheelPositions().isEmpty()){
                	for(Vec3d vec : vehicledata.getWheelPositions().values()){
                		heightoffset += -vec.y;
                	}
                	heightoffset /= vehicledata.getWheelPositions().size();
                }
                GL11.glTranslated(0, -heightoffset, 0);
                modvec.render(vehicledata, null, null, cache);
                vehicledata.getParts().forEach((key, partdata) -> {
                    ModelBase.bindTexture(partdata.getTexture());
                	if(partdata.isInstalledOnSwivelPoint()){
                		GL11.glPushMatrix();
                		PartModel.translateAndRotatePartOnSwivelPointFast(vehicledata, partdata);
                        partdata.getType().getModel().render(vehicledata, key, null, null);
        	            GL11.glPopMatrix();
                	}
                	else{
                		partdata.getInstalledPos().translate();
                		partdata.getType().getModel().render(vehicledata, key, null, cache);
                		partdata.getInstalledPos().translateR();
                	}
                });
                GL11.glTranslated(0, heightoffset, 0);
            }
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
