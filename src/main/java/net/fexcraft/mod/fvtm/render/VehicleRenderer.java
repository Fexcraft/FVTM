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
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.world.World;

public class VehicleRenderer {
	
	private static MutableBlockPos pos =  new BlockPos.MutableBlockPos(0, 0, 0);
	
    public static void renderVehicles(World world, double cx, double cy, double cz, float ticks){
    	if(!Config.RENDER_VEHICLES_SEPARATELY) return;
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-cx, -cy, -cz);
        double x, y, z;
        for(Entity entity : world.loadedEntityList){
        	if(entity instanceof GenericVehicle == false) continue;
        	GenericVehicle vehicle = (GenericVehicle)entity;
            x = vehicle.lastTickPosX + (vehicle.posX - vehicle.lastTickPosX) * ticks;
            y = vehicle.lastTickPosY + (vehicle.posY - vehicle.lastTickPosY) * ticks;
            z = vehicle.lastTickPosZ + (vehicle.posZ - vehicle.lastTickPosZ) * ticks;
        	if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(vehicle.renderbox == null ? vehicle.getEntityBoundingBox() : vehicle.renderbox.offset(x, y, z))) continue;
        	//
        	EffectRenderer.RENDER_VEHPOS.put(vehicle.getEntityId(), new double[]{ x, y, z });
            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            Vec3f rot = EffectRenderer.getRotations(vehicle, ticks);
            GL11.glRotatef(rot.x, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(rot.y, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(rot.z, 1.0F, 0.0F, 0.0F);
            EffectRenderer.RENDER_VEHROT.put(vehicle.getEntityId(), rot);
            //
	        int i = getBrightness(x, y, z), j = i % 65536, k = i / 65536;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            //
            GL11.glPushMatrix();
            RenderCache cache = vehicle.getCapability(Capabilities.RENDERCACHE, null);
            {
	            GL11.glRotatef(180f, 0f, 0f, 1f);
	            Model<VehicleData, Object> modVehicle = vehicle.getVehicleData().getType().getModel();
	            if(modVehicle != null){
	                ModelBase.bindTexture(vehicle.getVehicleData().getTexture());
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

	@Deprecated
	public static int getBrightness(double x, double y, double z){
		pos.setPos(x, y, z);
        if(Minecraft.getMinecraft().world.isBlockLoaded(pos)){
           return Minecraft.getMinecraft().world.getCombinedLight(pos, 0);
        }
        else return 0;
	}

}
