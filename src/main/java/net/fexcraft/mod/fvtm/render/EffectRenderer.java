package net.fexcraft.mod.fvtm.render;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.DefaultPrograms.LightBeam;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EffectRenderer {
	

	
	public static final ArrayList<LightBeam> LIGHTRAYS = new ArrayList<>();
	public static final ArrayList<VehicleData> LIGHTRAYDATAS = new ArrayList<>();
	public static final ArrayList<VehicleEntity> LIGHTRAYVEHS = new ArrayList<>();
	public static final HashMap<Integer, Vec3f> RENDER_VEHROT = new HashMap<>();
	public static final HashMap<Integer, Vec3d> RENDER_VEHPOS = new HashMap<>();
	public static final ResourceLocation LIGHT_TEXTURE = new ResourceLocation("fvtm:textures/entity/light_beam.png");
	
    @SubscribeEvent
    public void renderLights(RenderWorldLastEvent event){
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ModelBase.bindTexture(LIGHT_TEXTURE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.SRC_ALPHA);
        for(int i = 0; i < LIGHTRAYS.size(); i++){
        	LightBeam light = LIGHTRAYS.get(i);
        	VehicleData data = LIGHTRAYDATAS.get(i);
        	VehicleEntity veh = LIGHTRAYVEHS.get(i);
        	Vec3d vehpos = RENDER_VEHPOS.get(veh.getEntity().getEntityId());
            GL11.glPushMatrix();
            GL11.glTranslated(vehpos.x, vehpos.y, vehpos.z);
            //
            Vec3f vehrot = RENDER_VEHROT.get(veh.getEntity().getEntityId());
            GL11.glRotatef(vehrot.xCoord, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(vehrot.yCoord, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(vehrot.zCoord, 1.0F, 0.0F, 0.0F);
            GL11.glPushMatrix();
            GL11.glRotatef(180f, 0f, 0f, 1f);
            if(light.swivel == null || light.swivel.equals("vehicle")){
                GL11.glTranslated(light.pos.x, light.pos.y, light.pos.z);
                GL11.glColor4f(1, 1, 1, 0.5F);
            	light.shape.render();
                GL11.glColor4f(1, 1, 1, 0.5F);
            	light.shape.render();
            }
            else{
            	//
            }
            //
            GL11.glPopMatrix();
        	GL11.glPopMatrix();
        }
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    	GL11.glPopMatrix();
        LIGHTRAYS.clear();
        LIGHTRAYDATAS.clear();
        LIGHTRAYVEHS.clear();
    }

}
