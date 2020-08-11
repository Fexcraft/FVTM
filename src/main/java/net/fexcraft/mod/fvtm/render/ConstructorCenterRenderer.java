package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.block.ConstCenterEntity;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.block.ConstructorLiftModel;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

@fTESR
public class ConstructorCenterRenderer extends TileEntitySpecialRenderer<ConstCenterEntity> {
	
	public static final ResourceLocation lifttexture = new ResourceLocation("fvtm:textures/blocks/constructor_lift.png");

    @SuppressWarnings("deprecation")
	@Override
    public void render(ConstCenterEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        ModelBase.bindTexture(lifttexture);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        Float offrot = 60f;
        switch(te.getBlockMetadata()){
            case 2: offrot = 0f; break;
            case 3: offrot = -180f; break;
            case 4: offrot = - 90f; break;
            case 5: offrot = -270f; break;
        }
        GL11.glRotated(offrot, 0, 1, 0); offrot = null; GL11.glRotated(90, 0, 1D, 0);
        //
        if(te.getVehicleData() != null && te.getVehicleData().getAttribute("constructor_show").getBooleanValue()){
            if(te.getVehicleData() == null || te.getVehicleData().getType().getVehicleType().isLandVehicle()){
            	GL11.glPushMatrix();
            	ModelBase.bindTexture(lifttexture);
                GL11.glTranslatef(0, 0, te.getWheelOffset());
                renderLP(te);
                GL11.glTranslatef(0, 0, -(te.getWheelOffset() * 2));
                GL11.glRotated(180, 0, 1, 0);
                renderLP(te);
                GL11.glPopMatrix();
            }
            else if(te.getVehicleData().getType().getVehicleType().isRailVehicle()){
        		if(te.track == null) te.track = generateNewTrack();
        		if(te.track.gauge == null) te.track.gauge = getGauge(te.getVehicleData().getAttribute("gauge").getIntegerValue());
            	if(te.track.railmodel == null){ RailRenderer.generateTrackModel(te.track, te.track.gauge.getModel()); }
            	int l = te.getVehicleData().getAttribute("constructor_length").getIntegerValue();
            	//
            	GL11.glRotated(180, 0, 0, 1);
        		ModelBase.bindTexture(te.track.gauge.getRailTexture());
        		GL11.glPushMatrix();
            	GL11.glTranslatef(-l, 0, 0);
            	for(int i = l * 2 + 1; i > 0; i--){
            		te.track.railmodel.render();
            		GL11.glTranslatef(1, 0, 0);
            	}
            	GL11.glPopMatrix();
            	//
        		ModelBase.bindTexture(te.track.gauge.getTiesTexture());
        		GL11.glPushMatrix();
            	GL11.glTranslatef(-l, 0, 0);
            	for(int i = l * 2 + 1; i > 0; i--){
            		te.track.restmodel.render();
            		GL11.glTranslatef(1, 0, 0);
            	}
            	GL11.glPopMatrix();
            	offrot = te.track.gauge.height16();
            	GL11.glRotated(-180, 0, 0, 1);
            }
        }
        //
        if(te.getVehicleData() != null){
            VehicleData vehicledata = te.getVehicleData();
            if(offrot != null){ GL11.glTranslated(0, -offrot, 0); }
            Model<VehicleData, Object> modvec = vehicledata.getType().getModel();
            try{
                if(modvec != null){
                    ModelBase.bindTexture(vehicledata.getTexture());
                    GL11.glTranslated(0, (vehicledata.getAttribute("constructor_height").getFloatValue() * 0.0625f) - te.getLiftState(), 0);
                    modvec.render(vehicledata, null, null, null);
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
                    		partdata.getType().getModel().render(vehicledata, key, null, null);
                    		partdata.getInstalledPos().translateR();
                    	}
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
        	Model<BlockData, TileEntity> model = te.getBlockData().getType().getModel();
        	if(model != null){
                ModelBase.bindTexture(te.getBlockData().getTexture());
                model.render(te.getBlockData(), null);
        	}
        }
        else{
            if(te.getLinkPos() != null) te.tryLink();
        }
        //
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    private RailGauge getGauge(int width){
    	RailGauge gauge = Resources.RAILGAUGES.getValue(InternalAddon.STANDARD_GAUGE);
    	for(RailGauge railgauge : Resources.RAILGAUGES.getValuesCollection()){
    		if(railgauge.width() == width){ gauge = railgauge; break; }
    		if(Math.abs(width - railgauge.width()) < Math.abs(width - gauge.width())){
    			gauge = railgauge; continue;
    		}
    	} return gauge;
	}

	private Track generateNewTrack(){
		return new Track(null, new Vec316f[]{ new Vec316f(new Vec3d(-.5, 0, 0)) }, new Vec316f(new Vec3d(.5, 0, 0)), null);
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
