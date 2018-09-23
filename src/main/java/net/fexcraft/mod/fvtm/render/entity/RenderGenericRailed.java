package net.fexcraft.mod.fvtm.render.entity;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.entities.rail.RailboundVehicleEntity;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGenericRailed extends Render<RailboundVehicleEntity> implements IRenderFactory<RailboundVehicleEntity> {

    public RenderGenericRailed(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0.5F;
        /*if(!reg){ MinecraftForge.EVENT_BUS.register(this); reg = true; }*/
    }

    public void bindTexture(RailboundVehicleEntity ent){
        ModelBase.bindTexture(this.getEntityTexture(ent));
    }

    public void bindTexture(ResourceLocation rs){
        ModelBase.bindTexture(rs);
    }

    private static final ModelRendererTurbo light = new ModelRendererTurbo(null);
    private static final ModelRendererTurbo light2 = new ModelRendererTurbo(null);
    public static final ModelRendererTurbo CUBE = new ModelRendererTurbo(null);

    static{
        //light.flip = true;
        light.addCylinder(48, 0, 0, 16, 128, 32, 0.25f, 2, ModelRendererTurbo.MR_RIGHT);
        light2.flip = true;
        light2.addCylinder(48, 0, 0, 16, 128, 32, 0.25f, 2, ModelRendererTurbo.MR_RIGHT);
        CUBE.addBox(-8, -8, -8, 16, 16, 16);
        CUBE.setRotationPoint(0, 0, 0);
    }

    @Override
    public void doRender(RailboundVehicleEntity vehicle, double x, double y, double z, float entity_yaw, float ticks){
        if(vehicle.getVehicleData() == null){
            return;
        }
        GL11.glPushMatrix();
        {
            GL11.glTranslated(x, y, z);
            float yaw = (vehicle.axes.getYaw() - vehicle.prevRotationYaw);
            for(; yaw > 180F; yaw -= 360F){
            }
            for(; yaw <= -180F; yaw += 360F){
            }
            float pitch = (vehicle.axes.getPitch() - vehicle.prevRotationPitch);
            for(; pitch > 180F; pitch -= 360F){
            }
            for(; pitch <= -180F; pitch += 360F){
            }
            float roll = (vehicle.axes.getRoll() - vehicle.prevRotationRoll);
            for(; roll > 180F; roll -= 360F){
            }
            for(; roll <= -180F; roll += 360F){
            }
            GL11.glRotatef(180F - vehicle.prevRotationYaw - yaw * ticks, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(vehicle.prevRotationPitch + pitch * ticks, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(vehicle.prevRotationRoll + roll * ticks, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(180f, 0f, 0f, 1f);
            GL11.glPushMatrix();
            Model<VehicleData, Object> modVehicle = vehicle.getVehicleData().getVehicle().getModel();
            if(modVehicle != null){
                ModelBase.bindTexture(vehicle.getVehicleData().getTexture());
                modVehicle.render(vehicle.getVehicleData(), null, vehicle, -1);
                if(vehicle.getVehicleData().getParts().size() > 0){
                    vehicle.getVehicleData().getParts().forEach((key, partdata) -> {
                    	ModelBase.bindTexture(partdata.getTexture());
                        Pos pos = partdata.getPart().getOffsetFor(vehicle.getVehicleData().getVehicle().getRegistryName());
                        pos.translate();
                        partdata.getPart().getModel().render(vehicle.getVehicleData(), key, vehicle, -1);
                        partdata.getPart().getAttributes().forEach(attr -> { if(attr.hasRenderData()){ attr.render(vehicle, partdata, key); } });
                        pos.translateR();
                    });
                }
            }
            if(Command.DEBUG){
            	try{
            		ModelBase.bindTexture(Resources.NULL_TEXTURE);
                	Pos pos = vehicle.getVehicleData().getFrontConnectorPos();
                    if(pos != null){ pos.translate(); RGB.GREEN.glColorApply(); CUBE.render(); RGB.glColorReset(); pos.translateR(); }
                	pos = vehicle.getVehicleData().getRearConnectorPos();
                    if(pos != null){ pos.translate(); RGB.RED.glColorApply(); CUBE.render(); RGB.glColorReset(); pos.translateR(); }
            	}
            	catch(Exception e){
            		e.printStackTrace();
            	}
            }
            GL11.glPopMatrix();
        }
        GL11.glPopMatrix();
        //Renderer.drawString(vehicle.getVehicleData().getVehicle().getName(), x, y + 2, z, vehicle.axes.getYaw(), vehicle.axes.getPitch(), vehicle.axes.getRoll(), false, MapColor.GOLD.colorValue);
    }

    @Override
    protected ResourceLocation getEntityTexture(RailboundVehicleEntity entity){
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
    public Render<RailboundVehicleEntity> createRenderFor(RenderManager manager){
        return new RenderGenericRailed(manager);
    }

}
