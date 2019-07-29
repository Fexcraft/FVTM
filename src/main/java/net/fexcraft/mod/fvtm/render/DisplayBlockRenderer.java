package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

import org.lwjgl.opengl.GL11;

@fTESR
public class DisplayBlockRenderer extends TileEntitySpecialRenderer<DisplayEntity> {

    @Override
    public void render(DisplayEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(te.getBlockMetadata() * 22.5f, 0, 1, 0);
        GL11.glRotatef(90, 0, 1f, 0);
        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
        //
        if(te.getVehicleData() != null){
            VehicleData vehicledata = te.getVehicleData();
            Model<VehicleData, Object> modvec = vehicledata.getType().getModel();
            if(modvec != null){
                ModelBase.bindTexture(vehicledata.getTexture());
                GL11.glTranslated(0, (vehicledata.getAttribute("constructor_height").getFloatValue() * 0.0625f), 0);
                modvec.render(vehicledata, null, null, te.getBlockMetadata());
                vehicledata.getParts().forEach((key, partdata) -> {
                    ModelBase.bindTexture(partdata.getTexture());
                    partdata.getInstalledPos().translate();
                    partdata.getType().getModel().render(vehicledata, key);
                    partdata.getInstalledPos().translateR();
                });
                GL11.glTranslated(0, (vehicledata.getAttribute("constructor_height").getFloatValue() * -0.0625f), 0);
            }
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
