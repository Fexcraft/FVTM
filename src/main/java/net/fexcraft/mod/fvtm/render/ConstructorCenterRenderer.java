package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.model.GenericModel.RENDERDATA;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.block.ConstCenterEntity;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.block.ConstructorLiftModel;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

@fTESR
public class ConstructorCenterRenderer extends TileEntitySpecialRenderer<ConstCenterEntity> {
	
	public static final ResourceLocation lifttexture = new ResourceLocation("fvtm:textures/blocks/constructor_lift.png");

    @Override
    public void render(ConstCenterEntity tile, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        TexUtil.bindTexture(lifttexture);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        Float offrot = 60f;
        switch(tile.getBlockMetadata()){
            case 2: offrot = 0f; break;
            case 3: offrot = -180f; break;
            case 4: offrot = - 90f; break;
            case 5: offrot = -270f; break;
        }
        GL11.glRotated(offrot, 0, 1, 0); offrot = null; GL11.glRotated(90, 0, 1D, 0);
        boolean vehicle = tile.getVehicleData() != null;
        //
        if(vehicle && tile.getVehicleData().getAttribute("constructor_show").boolean_value()){
            if(tile.getVehicleData().getType().getVehicleType().isLandVehicle()){
            	GL11.glPushMatrix();
            	tile.updateLiftState();
            	TexUtil.bindTexture(lifttexture);
            	if(tile.models == null) tile.models = ConstructorLiftModel.setup(tile.getVehicleData());
            	for(ConstructorLiftModel model : tile.models) model.render(BlockModel.RENDERDATA.set((BlockData)null, tile, null, false));
                GL11.glPopMatrix();
            }
            else if(tile.getVehicleData().getType().getVehicleType().isRailVehicle()){
        		if(tile.track == null) tile.track = generateNewTrack();
        		if(tile.track.gauge == null) tile.track.gauge = getGauge(tile.getVehicleData().getAttribute("gauge").integer_value());
            	if(tile.track.railmodel == null){ RailRenderer.generateTrackModel(tile.track, tile.track.gauge.getModel()); }
            	int l = 0;
            	if(tile.getVehicleData().getFrontConnector() != null && tile.getVehicleData().getRearConnector() != null){
            		l = (int)(tile.getVehicleData().getFrontConnector().x + -tile.getVehicleData().getRearConnector().x + 1);
            	}
            	else l = Math.abs(tile.track.gauge.width()) / 16 * 4;
            	//
            	GL11.glRotated(180, 0, 0, 1);
        		TexUtil.bindTexture(tile.track.gauge.getRailTexture());
        		GL11.glPushMatrix();
            	GL11.glTranslatef(-l, 0, 0);
            	for(int i = l * 2 + 1; i > 0; i--){
            		tile.track.railmodel.renderPlain();
            		GL11.glTranslatef(1, 0, 0);
            	}
            	GL11.glPopMatrix();
            	//
        		TexUtil.bindTexture(tile.track.gauge.getTiesTexture());
        		GL11.glPushMatrix();
            	GL11.glTranslatef(-l, 0, 0);
            	for(int i = l * 2 + 1; i > 0; i--){
            		tile.track.restmodel.renderPlain();
            		GL11.glTranslatef(1, 0, 0);
            	}
            	GL11.glPopMatrix();
            	offrot = tile.track.gauge.height16();
            	GL11.glRotated(-180, 0, 0, 1);
            }
        }
        //
        if(vehicle){
            VehicleData vehicledata = tile.getVehicleData();
            if(offrot != null){ GL11.glTranslated(0, -offrot, 0); }
            Model modvec = vehicledata.getType().getModel();
            try{
                if(modvec != null){
                    TexUtil.bindTexture(vehicledata.getCurrentTexture());
                    float[] heightoffset = { 0 };
                    if(vehicledata.getType().getVehicleType().isRailVehicle() && !vehicledata.getWheelPositions().isEmpty()){
                    	vehicledata.getWheelPositions().values().forEach(cons -> {
                    		heightoffset[0] += -cons.y;
                    	});
                    	heightoffset[0] /= vehicledata.getWheelPositions().size();
                    }
                    if(!vehicledata.getType().getVehicleType().isRailVehicle()) heightoffset[0] += tile.getLiftState();
                    GL11.glTranslated(0, heightoffset[0], 0);
                    modvec.render(RENDERDATA.set(vehicledata, null, null, false));
                    vehicledata.getParts().forEach((key, partdata) -> {
                        TexUtil.bindTexture(partdata.getCurrentTexture());
                        if(partdata.isInstalledOnSwivelPoint()){
                    		GL11.glPushMatrix();
                    		PartModel.translateAndRotatePartOnSwivelPointFast(vehicledata, partdata);
	                        partdata.getType().getModel().render(RENDERDATA.set(vehicledata, null, null, partdata, key, false));
            	            GL11.glPopMatrix();
                    	}
                    	else{
                    		partdata.getInstalledPos().translate();
                    		partdata.getInstalledRot().rotate();
                    		partdata.getType().getModel().render(RENDERDATA.set(vehicledata, null, null, partdata, key, false));
                    		partdata.getInstalledRot().rotateR();
                    		partdata.getInstalledPos().translateR();
                    	}
                    });
                    GL11.glTranslated(0, heightoffset[0] - tile.getLiftState(), 0);
                }
            }
            catch(Exception e){
            	e.printStackTrace();
            }
        }
        else if(tile.getContainerData() != null){
            //GL11.glTranslated(0, 1.5F, 0);
            Model model = tile.getContainerData().getType().getModel();
            if(model != null){
                TexUtil.bindTexture(tile.getContainerData().getCurrentTexture());
                model.render(RENDERDATA.set(tile.getContainerData(), null, null, false));
                //TexUtil.bindTexture(lifttexture);
            }
        }
        else if(tile.getBlockData() != null){
        	Model model = tile.getBlockData().getType().getModel();
        	if(model != null){
                TexUtil.bindTexture(tile.getBlockData().getCurrentTexture());
                model.render(RENDERDATA.set(tile.getBlockData(), null, null, false));
        	}
        }
        else{
            if(tile.getLinkPos() != null) tile.tryLink();
        }
        //
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

	private RailGauge getGauge(int width){
    	RailGauge gauge = Resources.RAILGAUGES.get(InternalAddon.STANDARD_GAUGE);
    	for(RailGauge railgauge : Resources.RAILGAUGES){
    		if(railgauge.width() == width){ gauge = railgauge; break; }
    		if(Math.abs(width - railgauge.width()) < Math.abs(width - gauge.width())){
    			gauge = railgauge; continue;
    		}
    	} return gauge;
	}

	private Track generateNewTrack(){
		return new Track(null, new Vec316f[]{ new Vec316f(new Vec3d(-.5, 0, 0)) }, new Vec316f(new Vec3d(.5, 0, 0)), null);
	}

}
