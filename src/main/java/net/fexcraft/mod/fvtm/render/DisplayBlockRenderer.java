package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.math.Vec3d;

@fTESR
public class DisplayBlockRenderer extends TileEntitySpecialRenderer<DisplayEntity> {
	
	private Vec3d temp;

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
        //
        if(te.getVehicleData() != null){
            VehicleData vehicledata = te.getVehicleData();
            Model<VehicleData, Object> modvec = vehicledata.getType().getModel();
            if(modvec != null){
                ModelBase.bindTexture(vehicledata.getTexture());
                GL11.glTranslated(0, (vehicledata.getAttribute("constructor_height").getFloatValue() * 0.0625f), 0);
                modvec.render(vehicledata, null, null, cache, te.getBlockMetadata());
                vehicledata.getParts().forEach((key, partdata) -> {
                    ModelBase.bindTexture(partdata.getTexture());
                	if(partdata.isInstalledOnSwivelPoint()){
                		SwivelPoint point = vehicledata.getRotationPoint(partdata.getSwivelPointInstalledOn());
                		temp = point.getRelativeVector(partdata.getInstalledPos().to16Double(), true);
                		GL11.glPushMatrix();
                        GL11.glTranslated(temp.x, temp.y, temp.z);
        	            GL11.glRotated(point.getRelativeRot().x, 0.0F, 1.0F, 0.0F);
        	            GL11.glRotated(point.getRelativeRot().y, 0.0F, 0.0F, 1.0F);
        	            GL11.glRotated(point.getRelativeRot().z, 1.0F, 0.0F, 0.0F);
        	            partdata.getType().getModel().render(vehicledata, key, null, cache, -1);
        	            GL11.glPopMatrix();
                	}
                	else{
                		partdata.getInstalledPos().translate();
                		partdata.getType().getModel().render(vehicledata, key, null, cache, -1);
                		partdata.getInstalledPos().translateR();
                	}
                });
                GL11.glTranslated(0, (vehicledata.getAttribute("constructor_height").getFloatValue() * -0.0625f), 0);
            }
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
