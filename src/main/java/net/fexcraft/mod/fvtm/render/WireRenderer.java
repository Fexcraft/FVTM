package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireRegion;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class WireRenderer {
    

	protected static final ModelRendererTurbo model, model0, model1, rellay_core;
	protected static final ModelRendererTurbo[] all;
	static{
		model = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, 0, 0, 0.4f, 8, 32, 1, 1, ModelRendererTurbo.MR_TOP).setColor(RGB.RED);
		model0 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(245, 234, 128));
		model1 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(123, 245, 126));
		rellay_core = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, -.5f, 0, 0.9f, 1, 8, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(120, 120, 120));
		all = new ModelRendererTurbo[]{ model, model0, model1, rellay_core };
		for(ModelRendererTurbo turbo : all){
			for(TexturedPolygon poly : turbo.getFaces()){
				poly.setColor(turbo.polygonColor);
			}
		}
	}
	
	private static WireSystem wiredata;
    private static Frustum fru = new Frustum();
    
    public static void renderWires(World world, float partialticks){
    	if(Config.DISABLE_RAILS) return;
	    wiredata = SystemManager.get(Systems.WIRE, world);
        Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
        double x = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * partialticks;
        double y = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * partialticks;
        double z = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * partialticks;
        fru.setPosition(x, y, z);
        //
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-x, -y, -z);
        for(WireRegion reg : wiredata.getRegions().values()){
        	WireRelay[] relays = reg.getRelays().values().toArray(new WireRelay[0]);
        	for(int i = 0; i < relays.length; i++){
        		if(!fru.isBoundingBoxInFrustum(relays[i].getAABB())) continue;
            	GL11.glPushMatrix();
            	ModelBase.bindTexture(Resources.NULL_TEXTURE);
            	GL11.glTranslatef(relays[i].getVec3f().x, relays[i].getVec3f().y, relays[i].getVec3f().z);
            	if(relays[i].wires.isEmpty()){
            		model.render();
            	}
            	else{
            		rellay_core.render();
            	}
            	GL11.glPopMatrix();
        		renderWires(relays[i]);
        	}
        }
		GL11.glPopMatrix();
    }

	private static void renderWires(WireRelay relays){
        if(Command.OTHER){
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            Vec3f vec0, vec1; float flfl, glgl;
    		for(int o = 0; o < relays.wires.size(); o++){
    			Wire conn = relays.wires.get(o);
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
                    bufferbuilder.pos(vec0.x, vec0.y + (conn.isOppositeCopy() ? 0.1f : 0), vec0.z).color(0f, glgl, flfl, 1F).endVertex();
                    bufferbuilder.pos(vec1.x, vec1.y + (conn.isOppositeCopy() ? 0.1f : 0), vec1.z).color(0f, glgl, flfl, 1F).endVertex();
                    tessellator.draw();
    			}
                GlStateManager.depthMask(true);
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GL11.glPopMatrix();
                //
                float[] vec = conn.getPosition(conn.length * (Time.getSecond() / 60f));
                if(vec.length == 1){ continue; }
                GL11.glPushMatrix();
                GL11.glTranslatef(vec[0], vec[1] + (conn.isOppositeCopy() ? 0.1f : 0), vec[2]);
                (conn.isOppositeCopy() ? model1 : model0).render();
                GL11.glPopMatrix();
    		}
        }
        else{
        	
        }
	}

}
