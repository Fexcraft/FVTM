package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.block.ConstCenterEntity;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.block.ConstructorLiftModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

@fTESR
public class ConstructorCenterRenderer extends TileEntitySpecialRenderer<ConstCenterEntity> {
	
	public static final ResourceLocation lifttexture = new ResourceLocation("fvtm:textures/blocks/constructor_lift.png");

    @Override
    public void render(ConstCenterEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
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
                    GL11.glTranslated(0, (vehicledata.getAttribute("constructor_height").getFloatValue() * 0.0625f) - te.getLiftState(), 0);
                    modvec.render(vehicledata, null, null, null, te.getBlockMetadata());
                    vehicledata.getParts().forEach((key, partdata) -> {
                        ModelBase.bindTexture(partdata.getTexture());
                        partdata.getInstalledPos().translate();
                        partdata.getType().getModel().render(vehicledata, key);
                        partdata.getInstalledPos().translateR();
                    });
                    GL11.glTranslated(0, (vehicledata.getAttribute("constructor_height").getFloatValue() * -0.0625f) + te.getLiftState(), 0);
                }
            }
            catch(Exception e){
            	e.printStackTrace();
            }
        }
        else if(te.getContainerData() != null){
            //GL11.glTranslated(0, 1.5F, 0);
            Model<ContainerData, Object> model = te.getContainerData().getType().getModel();
            if(model != null){
                ModelBase.bindTexture(te.getContainerData().getTexture());
                model.render(te.getContainerData(), null);
                //ModelBase.bindTexture(lifttexture);
            }
        }
        else if(te.getBlockData() != null){
        	Model<BlockData, Object> model = te.getBlockData().getType().getModel();
        	if(model != null){
                ModelBase.bindTexture(te.getBlockData().getTexture());
                model.render(te.getBlockData(), null);
        	}
        }
        else{
            if(te.getLinkPos() != null) te.tryLink();
        }
        //
        if(te.getVehicleData() != null && te.getVehicleData().getAttribute("constructor_show").getBooleanValue()){
            if(te.getVehicleData() == null || te.getVehicleData().getType().getVehicleType().isLandVehicle()){
            	ModelBase.bindTexture(lifttexture);
                GL11.glTranslatef(0, 0, te.getWheelOffset());
                renderLP(te);
                GL11.glTranslatef(0, 0, -(te.getWheelOffset() * 2));
                GL11.glRotated(180, 0, 1, 0);
                renderLP(te);
            }
            else if(te.getVehicleData().getType().getVehicleType().isRailVehicle()){
            	//int l = te.getVehicleData().getAttribute("constructor_length").getCurrentInteger();
            	/*ModelRailSTD125.bindTexture();
            	GL11.glTranslatef(-l, 1.5f, 0);
            	for(int i = l * 2 + 1; i > 0; i--){
            		ModelRailSTD125.INSTANCE.render();
            		GL11.glTranslatef(1, 0, 0);
            	}*///TODO
            }
        }
        //
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    private static final void renderLP(ConstCenterEntity te){
        if(te.getVehicleData() != null){
            for(int i = 0; i < 5; i++){
                ConstructorLiftModel.INSTANCE.frame.renderPlain();
                te.getVehicleData().getSecondaryColor().glColorApply();
                ConstructorLiftModel.INSTANCE.secondary.renderPlain();
                RGB.glColorReset();
                te.getVehicleData().getPrimaryColor().glColorApply();
                ConstructorLiftModel.INSTANCE.primary.renderPlain();
                RGB.glColorReset();
                if(i != 4){
                    GL11.glTranslated(0, -1, 0);
                }
            }
            GL11.glTranslated(0, 4, 0);
        }
        if(te.getVehicleData() != null && te.getVehicleData().getType().getVehicleType().isWaterVehicle()){
            return;
        }
        GL11.glTranslated(0, -te.getLiftState(), 0);
        if(te.getVehicleData() != null){
            ConstructorLiftModel.INSTANCE.holder.renderPlain();
        }
        GL11.glTranslatef(te.getLength() + 1, 0, 0);
        for(int i = 0; i < te.getRenderLength(); i++){
            GL11.glTranslatef(-1, 0, 0);
            ConstructorLiftModel.INSTANCE.rails.renderPlain();
        }
        GL11.glTranslatef(te.getLength(), 0, 0);
        GL11.glTranslated(0, te.getLiftState(), 0);
    }

}
