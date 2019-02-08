package net.fexcraft.mod.fvtm.render.entity;

import java.util.Map;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.capability.ContainerHolder;
import net.fexcraft.mod.fvtm.api.capability.FVTMCaps;
import net.fexcraft.mod.fvtm.entities.land.UnboundVehicleEntity;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGenericVehicle extends Render<UnboundVehicleEntity> implements IRenderFactory<UnboundVehicleEntity> {

    public RenderGenericVehicle(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0.5F;
        /*if(!reg){ MinecraftForge.EVENT_BUS.register(this); reg = true; }*/
    }

    public void bindTexture(UnboundVehicleEntity ent){
        ModelBase.bindTexture(this.getEntityTexture(ent));
    }

    public void bindTexture(ResourceLocation rs){
        ModelBase.bindTexture(rs);
    }
    
    private ContainerHolder tempholder;

    @Override
    public void doRender(UnboundVehicleEntity vehicle, double x, double y, double z, float entity_yaw, float ticks){
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
	            GL11.glPushMatrix();
	            {
		            GL11.glRotatef(180f, 0f, 0f, 1f);
		            Model<VehicleData, Object> modVehicle = vehicle.getVehicleData().getVehicle().getModel();
		            if(modVehicle != null){
		                this.bindTexture(vehicle.getVehicleData().getTexture());
		                modVehicle.render(vehicle.getVehicleData(), null, vehicle, -1);
		                if(vehicle.getVehicleData().getParts().size() > 0){
		                	for(java.util.Map.Entry<String, PartData> entry : vehicle.getVehicleData().getParts().entrySet()){
		                    	ModelBase.bindTexture(entry.getValue().getTexture());
		                        Pos pos = entry.getValue().getPart().getOffsetFor(vehicle.getVehicleData().getVehicle().getRegistryName());
		                        pos.translate();
		                        entry.getValue().getPart().getModel().render(vehicle.getVehicleData(), entry.getKey(), vehicle, -1);
		                        for(Attribute attr : entry.getValue().getPart().getAttributes()) if(attr.hasRenderData()){ attr.render(vehicle, entry.getValue(), entry.getKey()); };
		                        pos.translateR();
		                	}
		                }
		            }
		            if(Command.DEBUG){
		            	try{
		            		ModelBase.bindTexture(Resources.NULL_TEXTURE);
		                	Pos pos = vehicle.getVehicleData().getFrontConnectorPos();
		                	if(pos != null){ pos.translate(); RenderGenericRailed.CUBE.render(); pos.translateR(); }
		                	pos = vehicle.getVehicleData().getRearConnectorPos();
		                    if(pos != null){ pos.translate(); RenderGenericRailed.CUBE.render(); pos.translateR(); }
		            	}
		            	catch(Exception e){
		            		e.printStackTrace();
		            	}
		            }
	            }
	            GL11.glPopMatrix();
	            //GL11.glRotatef(-180f, 0f, 1f, 0f);
	            //GL11.glRotatef(-180f, 1f, 0f, 0f);
	            //GL11.glTranslatef(0, 3, 0);
	            if((tempholder = vehicle.getCapability(FVTMCaps.CONTAINER, null)) != null){
		            GL11.glRotatef(-180f, 0f, 1f, 0f); tempholder.render();
	            }
            }
            GL11.glPopMatrix();
            if(Command.DEBUG){
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
            }
        }
        GL11.glPopMatrix();
        //Renderer.drawString(vehicle.getVehicleData().getVehicle().getName(), x, y + 2, z, vehicle.axes.getYaw(), vehicle.axes.getPitch(), vehicle.axes.getRoll(), false, MapColor.GOLD.colorValue);
    }
    
    private static int tempo, last;
    private static final ModelRendererTurbo temp = new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 4, 16, 16, 0, 0).setTextured(false).setColor(RGB.GREEN);

    @Override
    protected ResourceLocation getEntityTexture(UnboundVehicleEntity entity){
        return entity.getVehicleData().getTexture();
    }

    //@SubscribeEvent
    /*public void renderWorld(RenderWorldLastEvent event){
		World world = Minecraft.getMinecraft().world;
		if(world == null){
			return;
		}
        Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
        double x = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * event.getPartialTicks();
        double y = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * event.getPartialTicks();
        double z = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * event.getPartialTicks();
        //
        GL11.glPushMatrix();
        Minecraft.getMinecraft().entityRenderer.enableLightmap();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        
        RenderHelper.enableStandardItemLighting();
        
        GL11.glTranslatef(-(float)x, -(float)y, -(float)z);
		for(Entity entity : world.loadedEntityList){
			if(entity instanceof LandVehicleEntity){
				LandVehicleEntity vehicle = (LandVehicleEntity)entity;
		        int i = vehicle.getBrightnessForRender();
		        if(vehicle.isBurning()){
		            i = 15728880;
		        }

		        int j = i % 65536;
		        int k = i / 65536;
		        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
		        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		        doRender(vehicle, vehicle.prevPosX + (vehicle.posX - vehicle.prevPosX) * event.getPartialTicks(), vehicle.prevPosY + (vehicle.posY - vehicle.prevPosY) * event.getPartialTicks(), vehicle.prevPosZ + (vehicle.posZ - vehicle.prevPosZ) * event.getPartialTicks(), 0F, event.getPartialTicks());
			}
		}
		//
		Minecraft.getMinecraft().entityRenderer.disableLightmap();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}*/
    
    @Override
    public Render<UnboundVehicleEntity> createRenderFor(RenderManager manager){
        return new RenderGenericVehicle(manager);
    }

}
