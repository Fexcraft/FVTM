package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.render.RailRenderer.MIDDLE_GRAY;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.WireModel;
import net.fexcraft.mod.fvtm.render.RailRenderer.TurboArrayPositioned;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireRegion;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.VecUtil;
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
    

	protected static final ModelRendererTurbo model, model0, model1;
	protected static final ModelRendererTurbo[] all;
	static{
		model = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 1.25f, 6, 6, 1, 1).setLines(new RGB(0x00ddff));
		model0 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(245, 234, 128));
		model1 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(123, 245, 126));
		all = new ModelRendererTurbo[]{ model, model0, model1 };
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
            	if(Command.OTHER){// && relays[i].wires.isEmpty()){
            		model.render();
            	}
            	GL11.glPopMatrix();
        		renderWires(relays[i]);
        	}
        }
		GL11.glPopMatrix();
    }

	private static void renderWires(WireRelay relay){
        if(Command.OTHER){
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            Vec3f vec0, vec1; float flfl, glgl;
    		for(int o = 0; o < relay.wires.size(); o++){
    			Wire conn = relay.wires.get(o);
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
        	GL11.glPushMatrix();
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        	for(int i = 0; i < relay.size(); i++){
        		if(relay.wires.get(i).isOppositeCopy()) continue;
        		Wire wire = relay.wires.get(i);
        		WireModel model = wire.getWireType().getModel();
        		if(wire.wiremodel == null) generateWireModel(wire, model);
        		ModelBase.bindTexture(wire.getWireType().getWireTexture());
        		if(wire.getWireType().getModel().rail_tempcull) GlStateManager.disableCull();
        		wire.wiremodel.render();
        		if(wire.getWireType().getModel().rail_tempcull) GlStateManager.enableCull();
        		ModelBase.bindTexture(wire.getWireType().getModelTexture());
        		if(wire.getRelay().getTile() != null){
        			GL11.glTranslatef(wire.vecpath[0].x, wire.vecpath[0].y, wire.vecpath[0].z);
        			model.render(wire.getRelay().getTile().getBlockData(), wire.getRelay().getTile());
        			GL11.glTranslatef(-wire.vecpath[0].x, -wire.vecpath[0].y, -wire.vecpath[0].z);
        			int l = wire.vecpath.length - 1;
        			GL11.glTranslatef(wire.vecpath[l].x, wire.vecpath[l].y, wire.vecpath[l].z);
        			model.render(wire.getRelay().getTile().getBlockData(), wire.getRelay().getTile());
        			GL11.glTranslatef(-wire.vecpath[l].x, -wire.vecpath[l].y, -wire.vecpath[l].z);
        		}
        	}
        	if(Command.OTHER){
        		Wire wire;
        		for(int i = 0; i < relay.size(); i++){
        			wire = relay.wires.get(i);
	    			Vec3f pos = wire.getVectorPosition(wire.length * 0.5f, false);
	    			float off = wire.isOppositeCopy() ? 0.125f : -0.125f;
	    			float deg = Minecraft.getMinecraft().player.getHorizontalFacing().getHorizontalIndex() * 90f;
	    			RenderStreetSign.drawString(wire.getUnit().section().getUID() + "", pos.x + off, pos.y + 0.5, pos.z, true, true, 0.8f, wire.isOppositeCopy() ? 0xb8bc38 : 0x32a852, deg);
        		}
        	}
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		GL11.glPopMatrix();
        }
	}

	private static void generateWireModel(Wire wire, WireModel model){
		TurboArrayPositioned tarp = new TurboArrayPositioned(wire, MIDDLE_GRAY);
		float angle, passed = 0; Vec3f last, vec; ArrayList<Vec3f> path = new ArrayList<>();
		TexturedVertex vert0, vert1, vert2, vert3; TexturedPolygon poly0;
		//
		for(int p = 0; p < model.wire_model.size(); p++){
			path.clear(); vec = wire.getVectorPosition0(0.001f, false); passed = 0;
			angle = (float)Math.atan2(wire.vecpath[0].z - vec.z, wire.vecpath[0].x - vec.x);
			angle += Static.rad90;
			path.add(wire.vecpath[0].add(VecUtil.rotByRad(angle, model.wire_model.get(p)[0])));
			path.add(wire.vecpath[0].add(VecUtil.rotByRad(angle, model.wire_model.get(p)[1])));
			for(int v = 0; v < wire.vecpath.length - 1; v++){
				last = wire.vecpath[v]; vec = wire.vecpath[v + 1];
				angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x);
				angle += Static.rad90;
				path.add(vec.add(VecUtil.rotByRad(angle, model.wire_model.get(p)[0])));
				path.add(vec.add(VecUtil.rotByRad(angle, model.wire_model.get(p)[1])));
			}
			for(int k = 0; k < wire.vecpath.length - 1; k++){
				vert0 = new TexturedVertex(path.get(k * 2), 1, 1);
				vert1 = new TexturedVertex(path.get(k * 2 + 1), 0, 1);
				vert2 = new TexturedVertex(path.get((k + 1) * 2), 0, 0);
				vert3 = new TexturedVertex(path.get((k + 1) * 2 + 1), 1, 0);
				poly0 = new TexturedPolygon(new TexturedVertex[]{ vert1, vert0, vert2, vert3 });
				int pess = (int)passed; if(pess >= tarp.turbos.length) pess = tarp.turbos.length - 1;
				tarp.turbos[pess].copyTo(new TexturedPolygon[]{ poly0.setColor(MIDDLE_GRAY) });
				passed += wire.vecpath[k].dis(wire.vecpath[k + 1]);
			}
		}
		wire.wiremodel = tarp;
	}

}
