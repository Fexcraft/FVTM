package net.fexcraft.mod.fvtm.render;

import java.util.Map;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHoldingEntity;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.function.PartSlotsFunction;
import net.fexcraft.mod.fvtm.util.handler.DefaultPartInstallHandler.DPIHData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
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
        if(vehicle.getVehicleData() == null || vehicle.rotpoint == null){ return; }
        GL11.glPushMatrix();
        {
        	EffectRenderer.RENDER_VEHPOS.put(vehicle.getEntityId(), new Vec3d(x, y, z));
            GL11.glTranslated(x, y, z);
            GL11.glPushMatrix();
            {
	            float yaw = (vehicle.rotpoint.getAxes().getYaw() - vehicle.prevRotationYaw);
	            for(; yaw > 180F; yaw -= 360F){ }
	            for(; yaw <= -180F; yaw += 360F){ }
	            float pitch = (vehicle.rotpoint.getAxes().getPitch() - vehicle.prevRotationPitch);
	            for(; pitch > 180F; pitch -= 360F){ }
	            for(; pitch <= -180F; pitch += 360F){ }
	            float roll = (vehicle.rotpoint.getAxes().getRoll() - vehicle.prevRotationRoll);
	            for(; roll > 180F; roll -= 360F){ }
	            for(; roll <= -180F; roll += 360F){ }
	            GL11.glRotatef(180F - vehicle.prevRotationYaw - yaw * ticks, 0.0F, 1.0F, 0.0F);
	            GL11.glRotatef(vehicle.prevRotationPitch + pitch * ticks, 0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(vehicle.prevRotationRoll + roll * ticks, 1.0F, 0.0F, 0.0F);
	            EffectRenderer.RENDER_VEHROT.put(vehicle.getEntityId(), new Vec3f(180F - vehicle.prevRotationYaw - yaw * ticks, vehicle.prevRotationPitch + pitch * ticks, vehicle.prevRotationRoll + roll * ticks));
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
			                        entry.getValue().getType().getModel().render(vehicle.getVehicleData(), entry.getKey(), vehicle, cache);
			                        entry.getValue().getInstalledPos().translateR();
		                    	}
		                	}
		                }
		            }
	            }
	            if(Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof PartItem
	            	&& vehicle.getVehicleData().getAttribute("collision_range").getFloatValue() + 1 > vehicle.getDistance(Minecraft.getMinecraft().player)){
					PartData part = Minecraft.getMinecraft().player.getHeldItemMainhand().getCapability(Capabilities.VAPDATA, null).getPartData();
					if(part.getType().getInstallationHandlerData() instanceof DPIHData && ((DPIHData)part.getType().getInstallationHandlerData()).hotswap){
						GL11.glDisable(GL11.GL_TEXTURE_2D);
						GL11.glLineWidth(4f);
	        			for(Entry<String, PartData> data : vehicle.getVehicleData().getParts().entrySet()){
	        				if(!data.getValue().hasFunction("fvtm:part_slots")) continue;
	        				PartSlotsFunction func = data.getValue().getFunction("fvtm:part_slots");
	        				for(int i = 0; i < func.getSlotTypes().size(); i++){
	        					String type = func.getSlotTypes().get(i);
	        					for(String str : part.getType().getCategories()){
	        						if(str.equals(type)){
	        							func.getSlotPositions().get(i).translate();
	        			            	GL11.glPushMatrix();
	        			            	float scal = func.getSlotRadius().get(i);
	        			            	GL11.glScalef(scal, scal, scal);
	        							DebugModels.HOTINSTALLCUBE.render(1f);
	        			            	GL11.glPopMatrix();
	        							func.getSlotPositions().get(i).translateR();
	        						}
	        					}
	        				}
	        			}
	        			GL11.glLineWidth(1f);
						GL11.glEnable(GL11.GL_TEXTURE_2D);
					}
	            }
	            GL11.glPopMatrix();
	            if((tempholder = vehicle.getCapability(Capabilities.CONTAINER, null)) != null) tempholder.render(0, 0, 0);
	            if(Command.DEBUG){
	            	if(tempholder != null) ((ContainerHolderUtil.Implementation)tempholder).renderDebug();
	            	GL11.glPushMatrix();
	            	float scal = vehicle.getVehicleData().getAttribute("collision_range").getFloatValue() * 16;
	            	GL11.glScalef(scal, scal, scal);
	            	GL11.glDisable(GL11.GL_TEXTURE_2D);
					GL11.glLineWidth(2f);
	            	DebugModels.CENTERSPHERE.render();
        			GL11.glLineWidth(1f);
					GL11.glEnable(GL11.GL_TEXTURE_2D);
	            	GL11.glPopMatrix();
	            	if(Static.dev()){
	            		for(Attribute<?> attr : vehicle.getVehicleData().getAttributes().values()){
	            			if(!attr.hasAABBs()) continue;
	            			for(Map.Entry<String, float[]> box : attr.getAABBs().entrySet()){
	            				SwivelPoint point = vehicle.getVehicleData().getRotationPoint(attr.getAABBSP(box.getKey()));
	            				Vec3d temp = point.getRelativeVector(box.getValue()[0] * Static.sixteenth, -box.getValue()[1] * Static.sixteenth, -box.getValue()[2] * Static.sixteenth);
	            	        	temp = temp.add(vehicle.getEntity().getPositionVector());
	            	        	vehicle.world.spawnParticle(EnumParticleTypes.FLAME, temp.x, temp.y, temp.z, 0, 0, 0);
	            			}
	            		}
	            	}
	            }
            }
            GL11.glPopMatrix();
            if(Command.DEBUG){
            	ContainerHolder cap = vehicle.getCapability(Capabilities.CONTAINER, null);
            	if(cap != null){
            		ContainerHoldingEntity ent = vehicle;
            		for(String slotid : cap.getContainerSlotIds()){
            			ContainerSlot slot = cap.getContainerSlot(slotid);
            			ContainerType type = ContainerType.values()[Time.getSecond() % 5];
                    	for(int i = 0; i < slot.length; i += type.length()){
                    		Vec3d vec = ent.getContainerInSlotPosition(slot.id, cap, type, i);
                    		vehicle.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, vec.x, vec.y, vec.z, 0, 0, 0);
                    	}
            		}
            	}
            }
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
