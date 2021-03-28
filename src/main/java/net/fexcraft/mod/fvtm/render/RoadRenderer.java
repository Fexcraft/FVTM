package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.sys.road.Region;
import net.fexcraft.mod.fvtm.sys.road.RoadJunc;
import net.fexcraft.mod.fvtm.sys.road.RoadSys;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RoadRenderer {

	protected static final ModelRendererTurbo model, model0, model1, junction_core, railentcore;
	protected static final ModelRendererTurbo[] all;
	static{
		model = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, 0, 0, 0.4f, 8, 32, 1, 1, ModelRendererTurbo.MR_TOP).setColor(RGB.RED);
		model0 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(245, 234, 128));
		model1 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(123, 245, 126));
		junction_core = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, -.5f, 0, 0.9f, 1, 8, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(120, 120, 120));//35rgb
		railentcore = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addHollowCylinder(0, -4, 0, 8, 4, 8, 8, 0, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(128, 128, 128));
		all = new ModelRendererTurbo[]{ model, model0, model1, junction_core, railentcore };
		for(ModelRendererTurbo turbo : all){
			for(TexturedPolygon poly : turbo.getFaces()){
				poly.setColor(turbo.polygonColor);
			}
		}
	}
	
	private static RoadSys roaddata;
    private static Frustum fru = new Frustum();
    
    @SubscribeEvent
    public void renderRoadPreview(RenderWorldLastEvent event){
    	/*if(!RailRenderer.HOLDING) return;*/ roaddata = Minecraft.getMinecraft().world.getCapability(Capabilities.ROADSYSTEM, null).get();
        Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
        double x = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * event.getPartialTicks();
        double y = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * event.getPartialTicks();
        double z = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * event.getPartialTicks();
        fru.setPosition(x, y, z);
        //
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-x, -y, -z);
        for(Region reg : roaddata.getRegions().values()){
        	RoadJunc[] roadpoints = reg.getRoadPoints().values().toArray(new RoadJunc[0]);
        	for(int i = 0; i < roadpoints.length; i++){
        		if(!fru.isBoundingBoxInFrustum(roadpoints[i].getAABB())) continue;
            	GL11.glPushMatrix();
            	ModelBase.bindTexture(Resources.NULL_TEXTURE);
            	GL11.glTranslatef(roadpoints[i].getVec3f().xCoord, roadpoints[i].getVec3f().yCoord, roadpoints[i].getVec3f().zCoord);
            	if(roadpoints[i].roads.isEmpty() || RailRenderer.HOLDING){ model.render(); } else{ junction_core.render(); }
            	GL11.glPopMatrix();
        		renderLines(roadpoints[i]);
        	}
        }
		GL11.glPopMatrix();
    }

	private void renderLines(RoadJunc point){
        if(Command.OTHER){
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            Vec3f vec0, vec1; float flfl, glgl;
    		for(int o = 0; o < point.roads.size(); o++){
    			Path conn = point.roads.get(o);
    	        flfl = conn.isOppositeCopy() ? 1 : 0;
    	        glgl = conn.isOppositeCopy() ? 0 : 1;
                GL11.glPushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.glLineWidth(2.0F);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask(false);
    			for(int j = 0; j < conn.vecpath.length - 1; j++){
    				vec0 = conn.vecpath[j]; vec1 = conn.vecpath[j + 1];
                    bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                    bufferbuilder.pos(vec0.xCoord, vec0.yCoord + (conn.isOppositeCopy() ? 0.1f : 0), vec0.zCoord).color(0f, glgl, flfl, 1F).endVertex();
                    bufferbuilder.pos(vec1.xCoord, vec1.yCoord + (conn.isOppositeCopy() ? 0.1f : 0), vec1.zCoord).color(0f, glgl, flfl, 1F).endVertex();
                    tessellator.draw();
    			}
                GlStateManager.depthMask(true);
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GL11.glPopMatrix();
                //
                float[] vec = conn.getPosition(conn.length * (Time.getSecond() / 60f));
                if(vec.length == 1){ Print.debug(vec[0], conn.length); continue; }
                GL11.glPushMatrix();
                GL11.glTranslatef(vec[0], vec[1] + (conn.isOppositeCopy() ? 0.1f : 0), vec[2]);
                (conn.isOppositeCopy() ? model1 : model0).render();
                GL11.glPopMatrix();
    		}
        }
	}

}
