package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLandVehicle extends Render<LandVehicle> implements IRenderFactory<LandVehicle> {
	
	private ContainerHolder tempholder;

    public RenderLandVehicle(RenderManager renderManager){
        super(renderManager); shadowSize = 0.5F;
    }

    public void bindTexture(LandVehicle ent){
        ModelBase.bindTexture(this.getEntityTexture(ent));
    }

    public void bindTexture(ResourceLocation rs){
        ModelBase.bindTexture(rs);
    }
    
    //private static final ModelRendererTurbo turbo = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-2, -2, -2, 4, 4, 4);

    @Override
    public void doRender(LandVehicle vehicle, double x, double y, double z, float entity_yaw, float ticks){
        if(vehicle.getVehicleData() == null){ return; }
        GL11.glPushMatrix();
        {
            GL11.glTranslated(x, y, z);
            GL11.glPushMatrix();
            {
	            float yaw = (vehicle.axes.getYaw() - vehicle.prevRotationYaw);
	            for(; yaw > 180F; yaw -= 360F){ }
	            for(; yaw <= -180F; yaw += 360F){ }
	            float pitch = (vehicle.axes.getPitch() - vehicle.prevRotationPitch);
	            for(; pitch > 180F; pitch -= 360F){ }
	            for(; pitch <= -180F; pitch += 360F){ }
	            float roll = (vehicle.axes.getRoll() - vehicle.prevRotationRoll);
	            for(; roll > 180F; roll -= 360F){ }
	            for(; roll <= -180F; roll += 360F){ }
	            GL11.glRotatef(180F - vehicle.prevRotationYaw - yaw * ticks, 0.0F, 1.0F, 0.0F);
	            GL11.glRotatef(vehicle.prevRotationPitch + pitch * ticks, 0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(vehicle.prevRotationRoll + roll * ticks, 1.0F, 0.0F, 0.0F);
	            GL11.glPushMatrix(); RenderCache cache = vehicle.getCapability(Capabilities.RENDERCACHE, null);
	            {
		            GL11.glRotatef(180f, 0f, 0f, 1f);
		            Model<VehicleData, Object> modVehicle = vehicle.getVehicleData().getType().getModel();
		            if(modVehicle != null){
		                this.bindTexture(vehicle.getVehicleData().getTexture());
		                modVehicle.render(vehicle.getVehicleData(), null, vehicle, cache, -1);
		                if(vehicle.getVehicleData().getParts().size() > 0){
		                	for(java.util.Map.Entry<String, PartData> entry : vehicle.getVehicleData().getParts().entrySet()){
		                    	ModelBase.bindTexture(entry.getValue().getTexture());
		                    	entry.getValue().getInstalledPos().translate();
		                        entry.getValue().getType().getModel().render(vehicle.getVehicleData(), entry.getKey(), vehicle, cache, -1);
		                        entry.getValue().getInstalledPos().translateR();
		                	}
		                }
		            }
	            }
	            GL11.glPopMatrix();
	            if((tempholder = vehicle.getCapability(Capabilities.CONTAINER, null)) != null) tempholder.render(0, 0, 0);
            }
            GL11.glPopMatrix();
            /*if(Command.DEBUG && vehicle.getVehicleData() != null){
				GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glColor4f(0.5F, 0.5F, 0F, 0.3F);
				//
				for(AABB aabb : vehicle.getVehicleData().getCollisionGrid().getAABBs()){
			        GL11.glTranslated(aabb.getCurrentPos().x, aabb.getCurrentPos().y, aabb.getCurrentPos().z);
			        turbo.render();
			        GL11.glTranslated(-aabb.getCurrentPos().x, -aabb.getCurrentPos().y, -aabb.getCurrentPos().z);
				}
		        //
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glColor4f(1F, 1F, 1F, 1F);
			
            }*/
            /*if(Command.DEBUG){
                if(tempholder != null){
                	GL11.glPushMatrix();
                	ContainerType type = ContainerType.values()[tempo / 5];
                	if(last != Time.getSecond()){
                		last = Time.getSecond(); tempo++; if(tempo == 25) tempo = 0;
                	}
            		Map<String, AxisAlignedBB> map = tempholder.getContainerAABBs(type);
            		for(AxisAlignedBB axis : map.values()){
            			GL11.glTranslated(((axis.minX + axis.maxX) / 2), ((axis.minY + axis.maxY) / 2), ((axis.minZ + axis.maxZ) / 2));
            			temp.render();
            			GL11.glTranslated(-((axis.minX + axis.maxX) / 2), -((axis.minY + axis.maxY) / 2), -((axis.minZ + axis.maxZ) / 2));
            		}
                	GL11.glPopMatrix();
                }
            }*/
        }
        GL11.glPopMatrix();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(LandVehicle entity){
        return entity.getVehicleData().getTexture();
    }
    
    @Override
    public Render<LandVehicle> createRenderFor(RenderManager manager){
        return new RenderLandVehicle(manager);
    }

}
