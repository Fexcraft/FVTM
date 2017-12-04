package net.fexcraft.mod.fvtm.render.entity;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.entities.WaterVehicleEntity;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWaterVehicle extends Render<WaterVehicleEntity> implements IRenderFactory<WaterVehicleEntity> {
	
	public RenderWaterVehicle(RenderManager renderManager){
		super(renderManager);
		shadowSize = 0.5F;
	}

	public void bindTexture(WaterVehicleEntity ent){
		super.bindEntityTexture(ent);
	}
	
	public void bindTexture(ResourceLocation rs){
		super.bindTexture(rs);
	}
	
	@Override
    public void doRender(WaterVehicleEntity vehicle, double x, double y, double z, float entity_yaw, float ticks){
    	if(vehicle.getVehicleData() == null){
    		return;
    	}
        GL11.glPushMatrix();{
		    GL11.glTranslated(x, y, z);
		    float yaw   =  (vehicle.axes.getYaw()   - vehicle.prevRotationYaw  );
		    for(; yaw   >   180F; yaw   -= 360F){}
		    for(; yaw   <= -180F; yaw   += 360F){}
		    float pitch =  (vehicle.axes.getPitch() - vehicle.prevRotationPitch);
		    for(; pitch >   180F; pitch -= 360F){}
		    for(; pitch <= -180F; pitch += 360F){}
		    float roll  =  (vehicle.axes.getRoll()  - vehicle.prevRotationRoll );
		    for(; roll  >   180F; roll  -= 360F){}
		    for(; roll  <= -180F; roll  += 360F){}
		    GL11.glRotatef(180F - vehicle.prevRotationYaw - yaw * ticks, 0.0F, 1.0F, 0.0F);
		    GL11.glRotatef(vehicle.prevRotationPitch + pitch * ticks, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(vehicle.prevRotationRoll + roll * ticks, 1.0F, 0.0F, 0.0F);
        	GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glPushMatrix();
			VehicleModel<VehicleData> modVehicle = vehicle.getVehicleData().getVehicle().getModel();
			if(modVehicle != null){
				this.bindTexture(vehicle.getVehicleData().getTexture());
				modVehicle.render(vehicle.getVehicleData(), vehicle, -1);
				if(vehicle.getVehicleData().getParts().size() > 0){
					vehicle.getVehicleData().getParts().forEach((key, partdata) ->{
						this.bindTexture(partdata.getTexture());
						Pos pos = partdata.getPart().getOffsetFor(vehicle.getVehicleData().getVehicle().getRegistryName());
						pos.translate();
						partdata.getPart().getModel().render(vehicle.getVehicleData(), key, vehicle);
						pos.translateR();
						ContainerAttribute conattr;
						if((conattr = partdata.getPart().getAttribute(ContainerAttribute.class)) != null){
							conattr.getContainerOffset().translate();
							ContainerAttributeData condata = partdata.getAttributeData(ContainerAttributeData.class);
							ContainerData container;
							if(conattr.getContainerType() == ContainerType.LARGE){
								if(condata.getContainer(ContainerPosition.MEDIUM_DUAL2) != null){
									container = condata.getContainer(ContainerPosition.MEDIUM_DUAL1);
									this.bindTexture(container.getTexture());
									container.getContainer().getModel().render(container, ContainerPosition.MEDIUM_DUAL1, vehicle);
									//
									container = condata.getContainer(ContainerPosition.MEDIUM_DUAL2);
									this.bindTexture(container.getTexture());
									container.getContainer().getModel().render(container, ContainerPosition.MEDIUM_DUAL2, vehicle);
								}
								else{
									container = condata.getContainer(ContainerPosition.LARGE_SINGLE);
									this.bindTexture(container.getTexture());
									container.getContainer().getModel().render(container, ContainerPosition.LARGE_SINGLE, vehicle);
								}
							}
							else if(conattr.getContainerType() == ContainerType.MEDIUM){
								container = condata.getContainer(ContainerPosition.MEDIUM_SINGLE);
								this.bindTexture(container.getTexture());
								container.getContainer().getModel().render(container, ContainerPosition.MEDIUM_SINGLE, vehicle);
							}
							else {
								//No other types supported yet.
							}
							conattr.getContainerOffset().translateR();
						}
					});//TODO put container rendering into one generic method
				}
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(WaterVehicleEntity entity){
		return entity.getVehicleData().getTexture();
	}
	
	@Override
	public Render<WaterVehicleEntity> createRenderFor(RenderManager manager){
		return new RenderWaterVehicle(manager);
	}
	
}