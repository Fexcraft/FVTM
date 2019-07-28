package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.legacy.AirVehicle;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAirVehicle extends Render<AirVehicle> implements IRenderFactory<AirVehicle> {

    public RenderAirVehicle(RenderManager renderManager){
        super(renderManager); shadowSize = 0.5F;
    }

    public void bindTexture(AirVehicle ent){
        ModelBase.bindTexture(this.getEntityTexture(ent));
    }

    public void bindTexture(ResourceLocation rs){
        ModelBase.bindTexture(rs);
    }

    @Override
    public void doRender(AirVehicle vehicle, double x, double y, double z, float entity_yaw, float ticks){
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
	            GL11.glRotatef(180f - vehicle.prevRotationYaw - yaw * ticks, 0.0F, 1.0F, 0.0F);
	            GL11.glRotatef(vehicle.prevRotationPitch + pitch * ticks, 0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(vehicle.prevRotationRoll + roll * ticks, 1.0F, 0.0F, 0.0F);
	            GL11.glPushMatrix();
	            {
		            GL11.glRotatef(180f, 0f, 0f, 1f); GL11.glRotatef(180f, 0f, 1f, 0f);
		            Model<VehicleData, Object> modVehicle = vehicle.getVehicleData().getType().getModel();
		            if(modVehicle != null){
		                this.bindTexture(vehicle.getVehicleData().getTexture());
		                modVehicle.render(vehicle.getVehicleData(), null, vehicle, -1);
		                if(vehicle.getVehicleData().getParts().size() > 0){
		                	for(java.util.Map.Entry<String, PartData> entry : vehicle.getVehicleData().getParts().entrySet()){
		                    	ModelBase.bindTexture(entry.getValue().getTexture());
		                    	entry.getValue().getInstalledPos().translate();
		                        entry.getValue().getType().getModel().render(vehicle.getVehicleData(), entry.getKey(), vehicle, -1);
		                        entry.getValue().getInstalledPos().translateR();
		                	}
		                }
		            }
	            }
	            GL11.glPopMatrix();
	            //GL11.glRotatef(-180f, 0f, 1f, 0f);
	            //GL11.glRotatef(-180f, 1f, 0f, 0f);
	            //GL11.glTranslatef(0, 3, 0);
	            /*if((tempholder = vehicle.getCapability(FVTMCaps.CONTAINER, null)) != null){
		            GL11.glRotatef(-180f, 0f, 1f, 0f); tempholder.render();
	            }*/
            }
            GL11.glPopMatrix();
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
    protected ResourceLocation getEntityTexture(AirVehicle entity){
        return entity.getVehicleData().getTexture();
    }
    
    @Override
    public Render<AirVehicle> createRenderFor(RenderManager manager){
        return new RenderAirVehicle(manager);
    }

}
