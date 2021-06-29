package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderULV extends Render<ULandVehicle> implements IRenderFactory<ULandVehicle> {
	

    public RenderULV(RenderManager renderManager){
        super(renderManager); shadowSize = 0.5F;
    }

    public void bindTexture(ULandVehicle ent){
        ModelBase.bindTexture(this.getEntityTexture(ent));
    }

    public void bindTexture(ResourceLocation rs){
        ModelBase.bindTexture(rs);
    }
    
    //private static final ModelRendererTurbo turbo = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-2, -2, -2, 4, 4, 4);

    @Override
    public void doRender(ULandVehicle vehicle, double x, double y, double z, float entity_yaw, float ticks){
        if(vehicle.getVehicleData() == null || vehicle.rotpoint == null){ return; }
        GL11.glPushMatrix();
        {
        	EffectRenderer.RENDER_VEHPOS.put(vehicle.getEntityId(), new double[]{ x, y, z });
            GL11.glTranslated(x, y, z);
            GL11.glPushMatrix();
            Vec3f rot = EffectRenderer.getRotations(vehicle, ticks);
            GL11.glRotatef(rot.x, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(rot.y, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(rot.z, 1.0F, 0.0F, 0.0F);
            EffectRenderer.RENDER_VEHROT.put(vehicle.getEntityId(), rot);
            //
            GL11.glPushMatrix();
            RenderCache cache = vehicle.getCapability(Capabilities.RENDERCACHE, null);
            {
	            GL11.glRotatef(180f, 0f, 0f, 1f);
	            Model<VehicleData, Object> modVehicle = vehicle.getVehicleData().getType().getModel();
	            if(modVehicle != null){
	                this.bindTexture(vehicle.getVehicleData().getTexture());
	                modVehicle.render(vehicle.getVehicleData(), null, vehicle, cache);
	                if(vehicle.getVehicleData().getParts().size() > 0){
	                	for(java.util.Map.Entry<String, PartData> entry : vehicle.getVehicleData().getParts().entrySet()){
	                    	ModelBase.bindTexture(entry.getValue().getTexture());
	                    	if(entry.getValue().isInstalledOnSwivelPoint()){
	                    		GL11.glPushMatrix();
	                    		PartModel.translateAndRotatePartOnSwivelPoint(vehicle.getVehicleData(), entry.getValue(), ticks);
		                        entry.getValue().getType().getModel().render(vehicle.getVehicleData(), entry.getKey(), vehicle, cache);
	            	            GL11.glPopMatrix();
	                    	}
	                    	else{
		                    	entry.getValue().getInstalledPos().translate();
		                    	entry.getValue().getInstalledRot().rotate();
		                        entry.getValue().getType().getModel().render(vehicle.getVehicleData(), entry.getKey(), vehicle, cache);
		                    	entry.getValue().getInstalledRot().rotateR();
		                        entry.getValue().getInstalledPos().translateR();
	                    	}
	                	}
	                }
	            }
            }
            EffectRenderer.renderHotInstallInfo(vehicle);
            GL11.glPopMatrix();
            //
            GL11.glPopMatrix();
            EffectRenderer.renderToggableInfo(vehicle);
            EffectRenderer.renderContainerInfo(vehicle, rot);
            EffectRenderer.renderSeats(vehicle);
        }
        GL11.glPopMatrix();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(ULandVehicle entity){
        return entity.getVehicleData().getTexture();
    }
    
    @Override
    public Render<ULandVehicle> createRenderFor(RenderManager manager){
        return new RenderULV(manager);
    }

}
