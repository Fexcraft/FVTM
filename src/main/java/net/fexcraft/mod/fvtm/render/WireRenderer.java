package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.render.RailRenderer.MIDDLE_GRAY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.WireModel;
import net.fexcraft.mod.fvtm.model.WirePrograms;
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
    
	public static Wire CURRENT;
	public static float ANGLE;
	public static float ANGLE_DOWN;
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
        		if(conn.vecpath == null) return;
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
        		if(wire.vecpath == null || wire.getWireType() == null) continue;
        		if(wire.wiremodel == null) generateWireModel(wire);
        		ModelBase.bindTexture(wire.getWireType().getWireTexture());
        		if(wire.getWireType().getModel().wire_tempcull) GlStateManager.disableCull();
        		wire.wiremodel.render();
        		if(wire.getWireType().getModel().wire_tempcull) GlStateManager.enableCull();
        		ModelBase.bindTexture(wire.getWireType().getModelTexture());
        		if(relay.getTile() != null){
        			CURRENT = wire;
    				ANGLE = wire.model_end_angle;
        			if(wire.deco_s != null){
        				ANGLE_DOWN = wire.model_start_angle_down;
        				GL11.glPushMatrix();
            			GL11.glTranslatef(wire.vecpath[0].x, wire.vecpath[0].y, wire.vecpath[0].z);
            			GL11.glRotated(180, 0, 0, 1);
            			GL11.glRotated(90, 0, 1, 0);
            			GL11.glRotatef(wire.model_start_angle, 0, 1, 0);
            			wire.deco_s.render(relay.getTile().getBlockData(), relay.getTile());
            			//GL11.glTranslatef(-wire.vecpath[0].x, -wire.vecpath[0].y, -wire.vecpath[0].z);
            			GL11.glPopMatrix();
        			}
        			if(wire.deco_e != null){
        				//ANGLE = wire.model_end_angle;
        				ANGLE_DOWN = wire.model_end_angle_down;
            			int l = wire.vecpath.length - 1;
        				GL11.glPushMatrix();
            			GL11.glTranslatef(wire.vecpath[l].x, wire.vecpath[l].y, wire.vecpath[l].z);
            			GL11.glRotated(180, 0, 0, 1);
            			GL11.glRotated(90, 0, 1, 0);
            			GL11.glRotatef(wire.model_end_angle, 0, 1, 0);
            			//RGB.RED.glColorApply();
            			wire.deco_e.render(relay.getTile().getBlockData(), relay.getTile());
            			//GL11.glTranslatef(-wire.vecpath[l].x, -wire.vecpath[l].y, -wire.vecpath[l].z);
            			//RGB.glColorReset();
            			GL11.glPopMatrix();
        			}
        			if(wire.deco_m == null) genWireDeco(wire);
        			if(wire.deco_m.size() > 0){
        				WireModel wm;
        				for(Entry<String, WireModel> dm : wire.deco_m.entrySet()){
                			wm = dm.getValue();
                			for(TurboList list : wm.groups){
                				if(wire.deco_d.get(dm.getKey()).containsKey(list.name)){
                					for(Vec3f vec : wire.deco_d.get(dm.getKey()).get(list.name)){
                            			GL11.glPushMatrix();
                            			GL11.glTranslatef(vec.x, vec.y, vec.z);
                            			GL11.glRotated(180, 0, 0, 1);
                            			GL11.glRotated(90, 0, 1, 0);
                    					wm.transforms.apply();
                    	        		ModelBase.bindTexture(wm.texture());
                    					list.renderBlock(relay.getTile(), relay.getTile().getBlockData(), null);
                    					wm.transforms.deapply();
                            			GL11.glPopMatrix();
                					}
                				}
                				else{
                        			GL11.glPushMatrix();
                        			GL11.glTranslatef(wire.vecpath[0].x, wire.vecpath[0].y, wire.vecpath[0].z);
                        			GL11.glRotated(180, 0, 0, 1);
                        			GL11.glRotated(90, 0, 1, 0);
                					wm.transforms.apply();
                	        		ModelBase.bindTexture(wm.texture());
                					list.renderBlock(relay.getTile(), relay.getTile().getBlockData(), null);
                					wm.transforms.deapply();
                        			GL11.glPopMatrix();
                				}
                			}
        				}
        			}
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

	private static void generateWireModel(Wire wire){
		WireModel model = wire.getWireType().getModel();
		TurboArrayPositioned tarp = new TurboArrayPositioned(wire, MIDDLE_GRAY);
		float angle, passed = 0;
		Vec3f last, vec;
		ArrayList<Vec3f> path = new ArrayList<>();
		TexturedVertex vert0, vert1, vert2, vert3;
		TexturedPolygon poly0;
		//
		for(Entry<Integer, ArrayList<Vec3f[]>> entry : model.wire_model.entrySet()){
			ArrayList<Vec3f[]> wodl = entry.getValue();
			Object[] data = model.wire_data.get(entry.getKey());
			for(int p = 0; p < wodl.size(); p++){
				path.clear();
				boolean noslack = data != null && (boolean)data[0] == true;
				vec = noslack ? dis(wire, 0.001f) : wire.getVectorPosition0(0.001f, false);
				passed = 0;
				angle = (float)Math.atan2(wire.vecpath[0].z - vec.z, wire.vecpath[0].x - vec.x);
				angle += Static.rad90;
				path.add(wire.vecpath[0].add(VecUtil.rotByRad(angle, wodl.get(p)[0])));
				path.add(wire.vecpath[0].add(VecUtil.rotByRad(angle, wodl.get(p)[1])));
				for(int v = 0; v < wire.vecpath.length - 1; v++){
					last = wire.vecpath[v];
					vec = wire.vecpath[v + 1];
					if(noslack){
						vec = dis(wire, passed += last.dis(vec));
					}
					angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x);
					angle += Static.rad90;
					path.add(vec.add(VecUtil.rotByRad(angle, wodl.get(p)[0])));
					path.add(vec.add(VecUtil.rotByRad(angle, wodl.get(p)[1])));
				}
				passed = 0;
				for(int k = 0; k < wire.vecpath.length - 1; k++){
					vert0 = new TexturedVertex(path.get(k * 2), 1, 1);
					vert1 = new TexturedVertex(path.get(k * 2 + 1), 0, 1);
					vert2 = new TexturedVertex(path.get((k + 1) * 2), 0, 0);
					vert3 = new TexturedVertex(path.get((k + 1) * 2 + 1), 1, 0);
					poly0 = new TexturedPolygon(new TexturedVertex[]{ vert1, vert0, vert2, vert3 });
					int pess = (int)passed;
					if(pess >= tarp.turbos.length) pess = tarp.turbos.length - 1;
					tarp.turbos[pess].copyTo(new TexturedPolygon[]{ poly0.setColor(MIDDLE_GRAY) });
					passed += wire.vecpath[k].dis(wire.vecpath[k + 1]);
				}
			}
		}
		wire.wiremodel = tarp;
		//
		vec = wire.vecpath[wire.vecpath.length - 1];
		wire.model_end_angle = (float)Math.atan2(wire.vecpath[0].z - vec.z, wire.vecpath[0].x - vec.x);
		wire.model_end_angle = Static.toDegrees(wire.model_end_angle);
		wire.model_start_angle = wire.model_end_angle - 180;
		//
		if(wire.deco_start != null) wire.deco_s = WireModel.DECOS.get(wire.deco_start);
		if(wire.deco_end != null) wire.deco_e = WireModel.DECOS.get(wire.deco_end);
		float hwl = wire.length / 2;
		if(wire.deco_s != null){
			float len = wire.deco_s.getLongestDownward();
			vec = wire.getVectorPosition0(len > hwl ? hwl : len, false);
	        float dx = wire.vecpath[0].x - vec.x, dy = wire.vecpath[0].y - vec.y, dz = wire.vecpath[0].z - vec.z;
			wire.model_start_angle_down = (float)Math.atan2(dy, Math.sqrt(dx * dx + dz * dz));
			wire.model_start_angle_down = Static.toDegrees(wire.model_start_angle_down);
		}
		if(wire.deco_e != null){
			float len = wire.deco_e.getLongestDownward();
			vec = wire.getVectorPosition0(wire.length - (len > hwl ? hwl : len), false);
	        float dx = wire.vecpath[wire.vecpath.length - 1].x - vec.x, dy = wire.vecpath[wire.vecpath.length - 1].y - vec.y, dz = wire.vecpath[wire.vecpath.length - 1].z - vec.z;
			wire.model_end_angle_down = (float)Math.atan2(dy, Math.sqrt(dx * dx + dz * dz));
			wire.model_end_angle_down = Static.toDegrees(wire.model_end_angle_down);
		}
	}

	private static Vec3f dis(Wire wire, float dis){
		return wire.rootpath0[0].distance(wire.rootpath0[2], dis);
	}

	private static void genWireDeco(Wire wire){
		wire.deco_m = new HashMap<>();
		wire.deco_d = new HashMap<>();
		if(wire.decos == null) return;
		for(Entry<String, String> entry : wire.decos.entrySet()){
			WireModel deco = WireModel.DECOS.get(entry.getValue());
			if(deco != null){
				wire.deco_m.put(entry.getKey(), deco);
				wire.deco_d.put(entry.getKey(), new HashMap<>());
				for(TurboList list : deco.groups){
					for(TurboList.Program program : list.programs){
						if(program instanceof WirePrograms.SpacedDeco == false) continue;
						wire.deco_d.get(entry.getKey()).put(list.name, ((WirePrograms.SpacedDeco)program).generate(wire, list));
						break;
					}
				}
			}
		}
	}

}
