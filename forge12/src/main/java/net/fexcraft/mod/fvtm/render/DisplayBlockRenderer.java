package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.util.AnotherUtil;
import net.fexcraft.mod.fvtm.util.GLUtils112;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

@fTESR
public class DisplayBlockRenderer extends TileEntitySpecialRenderer<DisplayEntity> {

	private static float heightoffset = 0;

    @Override
    public void render(DisplayEntity te, double posX, double posY, double posZ, float ticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        GL11.glRotatef(te.getBlockMetadata() * 22.5f, 0, 1, 0);
		TexUtil.bindTexture(FvtmRegistry.NULL_TEXTURE);
        RenderCache cache = te.getCapability(Capabilities.RENDERCACHE, null);
        heightoffset = 0;
        //
        if(te.getVehicleData() != null){
            VehicleData vehicledata = te.getVehicleData();
            Model modvec = vehicledata.getType().getModel();
            if(modvec != null){
                TexUtil.bindTexture(vehicledata.getCurrentTexture());
                if(!vehicledata.getWheelPositions().isEmpty()){
                	for(V3D vec : vehicledata.getWheelPositions().values()){
                		heightoffset += -vec.y;
                	}
                	heightoffset /= vehicledata.getWheelPositions().size();
                }
                GL11.glTranslated(0, -heightoffset, 0);
                modvec.render(RENDERDATA.set(vehicledata, null, ticks).rc(cache));
                vehicledata.getParts().forEach((key, partdata) -> {
                    TexUtil.bindTexture(partdata.getCurrentTexture());
                	if(partdata.isInstalledOnSwivelPoint()){
                		GL11.glPushMatrix();
                		AnotherUtil.translateAndRotatePartOnSwivelPointFast(vehicledata, partdata);
                        partdata.getType().getModel().render(RENDERDATA.set(vehicledata, null, partdata, key, ticks).rc(cache));
        	            GL11.glPopMatrix();
                	}
                	else{
						GLUtils112.translate(partdata.getInstalledPos());
                    	partdata.getInstalledRot().rotate112();
                		partdata.getType().getModel().render(RENDERDATA.set(vehicledata, null, partdata, key, ticks).rc(cache));
                    	partdata.getInstalledRot().rotate112R();
						GLUtils112.translateR(partdata.getInstalledPos());
                	}
                });
                GL11.glTranslated(0, heightoffset, 0);
            }
        }
        GL11.glPopMatrix();
    }

}
