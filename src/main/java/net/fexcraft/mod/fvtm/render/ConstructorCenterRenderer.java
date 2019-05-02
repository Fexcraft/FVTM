package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.block.ConstructorCenterEntity;
import net.fexcraft.mod.fvtm.data.VehicleData;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

@fTESR
public class ConstructorCenterRenderer extends TileEntitySpecialRenderer<ConstructorCenterEntity> {
	
	public static final ResourceLocation lifttexture = new ResourceLocation("fvtm:textures/blocks/constructioncenter.png");

    @Override
    public void render(ConstructorCenterEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
        ModelBase.bindTexture(lifttexture);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        double d = 60;
        switch(te.getBlockMetadata()){
            case 2: d = 0; break;
            case 3: d = -180d; break;
            case 4: d = -90; break;
            case 5: d = -270d; break;
        }
        GL11.glRotated(d, 0, 1, 0);
        GL11.glRotated(90, 0, 1D, 0);
        if(te.getVehicleData() != null){
            VehicleData vehicledata = te.getVehicleData();
            Model<VehicleData, Object> modvec = vehicledata.getType().getModel();
            try{
                if(modvec != null){
                    ModelBase.bindTexture(vehicledata.getTexture());
                    GL11.glTranslated(0, (vehicledata.getType().getAttribute("constructor_height").getCurrentFloat() * 0.0625f) /*- te.getLiftState()*/, 0);
                    modvec.render(vehicledata, null, null, te.getBlockMetadata());
                    vehicledata.getParts().forEach((key, partdata) -> {
                        ModelBase.bindTexture(partdata.getTexture());
                        //TODO partdata.getType().getOffsetFor(vehicledata.getType().getRegistryName()).translate();
                        partdata.getType().getModel().render(vehicledata, key);
                        //TODO partdata.getType().getOffsetFor(vehicledata.getType().getRegistryName()).translateR();
                    });
                    GL11.glTranslated(0, (vehicledata.getType().getAttribute("constructor_height").getCurrentFloat() * -0.0625f) /*+ te.getLiftState()*/, 0);
                    ModelBase.bindTexture(lifttexture);
                }
            }
            catch(Exception e){
            	e.printStackTrace();
            }
        }
        /*else if(te.getContainerData() != null){
            GL11.glTranslated(0, 1.5F, 0);
            Model<ContainerData, Object> model = te.getContainerData().getContainer().getModel();
            if(model != null){
                ModelBase.bindTexture(te.getContainerData().getTexture());
                model.render(te.getContainerData(), null);
                ModelBase.bindTexture(ModelConstructorCenter.getTexture());
            }
        }*/
        else{
            if(te.getLinkPos() != null) te.tryLink();
        }
        //
        if(te.getVehicleData() != null && te.getVehicleData().getType().getVehicleType().isRailVehicle()){
        	//TODO render rails
        }
        //
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
