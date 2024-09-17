package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.WireDeco;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.model.program.WirePrograms;
import net.fexcraft.mod.fvtm.render.RailRenderer.TurboArrayPositioned;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.*;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.RailRenderer.MIDDLE_GRAY;

public class WireRenderer {
    
	public static Wire CURRENT;
	public static double ANGLE;
	public static double ANGLE_DOWN;
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
    
    public static void renderWires(World world, double cx, double cy, double cz, float partialticks){
    	if(DISABLE_RAILS) return;
	    wiredata = SystemManager.get(Systems.WIRE, WrapperHolder.getWorld(world));
	    if(wiredata == null || wiredata.getRegions() == null) return;
        //
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-cx, -cy, -cz);
        for(WireRegion reg : wiredata.getRegions().values()){
        	for(RelayHolder holder : reg.getHolders().values()){
            	for(WireRelay relay : holder.relays.values()){
            		if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(relay.getAABB())) continue;
                	GL11.glPushMatrix();
                	TexUtil.bindTexture(FvtmRegistry.NULL_TEXTURE);
                	GL11.glTranslated(relay.pos.x, relay.pos.y, relay.pos.z);
                	if(Command.OTHER){// && relays[i].wires.isEmpty()){
                		model.render();
                	}
                	GL11.glPopMatrix();
            		renderWires(relay);
            	}
        	}
        }
		GL11.glPopMatrix();
    }

	private static void renderWires(WireRelay relay){
        if(Command.OTHER){
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
			V3D vec0, vec1;
			float flfl, glgl;
    		for(int o = 0; o < relay.wires.size(); o++){
    			Wire conn = relay.wires.get(o);
        		if(conn.vecpath == null) return;
    	        flfl = conn.copy ? 1 : 0;
    	        glgl = conn.copy ? 0 : 1;
                GL11.glPushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.glLineWidth(2.0F);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask(false);
    			for(int j = 0; j < conn.vecpath.length - 1; j++){
    				vec0 = conn.vecpath[j]; vec1 = conn.vecpath[j + 1];
                    bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                    bufferbuilder.pos(vec0.x, vec0.y + (conn.copy ? 0.1f : 0), vec0.z).color(0f, glgl, flfl, 1F).endVertex();
                    bufferbuilder.pos(vec1.x, vec1.y + (conn.copy ? 0.1f : 0), vec1.z).color(0f, glgl, flfl, 1F).endVertex();
                    tessellator.draw();
    			}
                GlStateManager.depthMask(true);
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GL11.glPopMatrix();
                //
                /*float[] vec = conn.getPosition(conn.length * (Time.getSecond() / 60f));
                if(vec.length == 1){ continue; }
                GL11.glPushMatrix();
                GL11.glTranslatef(vec[0], vec[1] + (conn.copy ? 0.1f : 0), vec[2]);
                (conn.copy ? model1 : model0).render();
                GL11.glPopMatrix();*///TODO
    		}
        }
        else{
        	GL11.glPushMatrix();
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        	for(int i = 0; i < relay.size(); i++){
        		if(relay.wires.get(i).copy) continue;
        		Wire wire = relay.wires.get(i);
        		if(wire.vecpath == null || wire.getWireType() == null) continue;
        		if(wire.wiremodel == null) generateWireModel(wire);
        		TexUtil.bindTexture(wire.getWireType().getTexture());
        		if(wire.getWireType().getModel().wire_nocull) GlStateManager.disableCull();
        		wire.wiremodel.render();
        		if(wire.getWireType().getModel().wire_nocull) GlStateManager.enableCull();
        		if(relay.getTile() != null){
        			CURRENT = wire;
    				ANGLE = wire.model_end_angle;
        			if(wire.deco_s != null){
        				ANGLE_DOWN = wire.model_start_angle_down;
        				GL11.glPushMatrix();
            			GL11.glTranslated(wire.vecpath[0].x, wire.vecpath[0].y, wire.vecpath[0].z);
            			GL11.glRotated(180, 0, 0, 1);
            			GL11.glRotated(90, 0, 1, 0);
            			GL11.glRotated(wire.model_start_angle, 0, 1, 0);
    	        		TexUtil.bindTexture(wire.deco_s.getTexture());
            			wire.deco_s.getModel().render(RENDERDATA.set(relay.getTile().getBlockData(), relay.getTile(), null, null, false));
            			//GL11.glTranslatef(-wire.vecpath[0].x, -wire.vecpath[0].y, -wire.vecpath[0].z);
            			GL11.glPopMatrix();
        			}
        			if(wire.deco_e != null){
        				//ANGLE = wire.model_end_angle;
        				ANGLE_DOWN = wire.model_end_angle_down;
            			int l = wire.vecpath.length - 1;
        				GL11.glPushMatrix();
            			GL11.glTranslated(wire.vecpath[l].x, wire.vecpath[l].y, wire.vecpath[l].z);
            			GL11.glRotated(180, 0, 0, 1);
            			GL11.glRotated(90, 0, 1, 0);
            			GL11.glRotated(wire.model_end_angle, 0, 1, 0);
            			//RGB.RED.glColorApply();
    	        		TexUtil.bindTexture(wire.deco_e.getTexture());
            			wire.deco_e.getModel().render(RENDERDATA.set(relay.getTile().getBlockData(), relay.getTile(), null, null, false));
            			//GL11.glTranslatef(-wire.vecpath[l].x, -wire.vecpath[l].y, -wire.vecpath[l].z);
            			//RGB.glColorReset();
            			GL11.glPopMatrix();
        			}
        			if(wire.deco_m == null) genWireDeco(relay, wire);
        			if(wire.deco_m.size() > 0){
        				WireModel wm;
        				for(Entry<String, WireDeco> dm : wire.deco_m.entrySet()){
                			wm = dm.getValue().getModel();
                			for(ModelGroup list : wm.groups){
                				if(wire.deco_d.get(dm.getKey()).containsKey(list.name)){
                					ArrayList<ModelRendererTurbo> tlist = wire.deco_g.containsKey(dm.getKey()) ? wire.deco_g.get(dm.getKey()).get(list.name) : null;
                					int didx = 0;
                					for(V3D vec : wire.deco_d.get(dm.getKey()).get(list.name)){
                            			GL11.glPushMatrix();
                            			GL11.glTranslated(vec.x, vec.y, vec.z);
                            			GL11.glRotated(180, 0, 0, 1);
                            			GL11.glRotated(90, 0, 1, 0);
                    					wm.transforms.apply();
                    	        		TexUtil.bindTexture(dm.getValue().getTexture());
                    					list.render(RENDERDATA.set(relay.getTile().getBlockData(), relay.getTile(), null, null, false));
                    					if(tlist != null){
                    		        		TexUtil.bindTexture(wire.getWireType().getTexture());
                    						tlist.get(didx++).render();
                    					}
                    					wm.transforms.deapply();
                            			GL11.glPopMatrix();
                					}
                				}
                				else{
                        			GL11.glPushMatrix();
                        			GL11.glTranslated(wire.vecpath[0].x, wire.vecpath[0].y, wire.vecpath[0].z);
                        			GL11.glRotated(180, 0, 0, 1);
                        			GL11.glRotated(90, 0, 1, 0);
                					wm.transforms.apply();
                	        		TexUtil.bindTexture(dm.getValue().getTexture());
                					list.render(RENDERDATA.set(relay.getTile().getBlockData(), relay.getTile(), null, null, false));
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
					V3D pos = wire.getVectorPosition(wire.length * 0.5, false);
	    			double off = wire.copy ? 0.125 : -0.125;
	    			double deg = Minecraft.getMinecraft().player.getHorizontalFacing().getHorizontalIndex() * 90d;
	    			RenderStreetSign.drawString(wire.getUnit().section().getUID() + "", pos.x + off, pos.y + 0.5, pos.z, true, true, 0.8f, wire.copy ? 0xb8bc38 : 0x32a852, deg);
        		}
        	}
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		GL11.glPopMatrix();
        }
	}

	private static void generateWireModel(Wire wire){
		WireModel model = wire.getWireType().getModel();
		TurboArrayPositioned tarp = new TurboArrayPositioned(wire, MIDDLE_GRAY);
		double angle, passed = 0;
		V3D last, vec;
		ArrayList<V3D> path = new ArrayList<>();
		TexturedVertex vert0, vert1, vert2, vert3;
		TexturedPolygon poly0;
		//
		for(Entry<Integer, ArrayList<V3D[]>> entry : model.wire_model.entrySet()){
			ArrayList<V3D[]> wodl = entry.getValue();
			for(int p = 0; p < wodl.size(); p++){
				path.clear();
				vec = wire.getVectorPosition(0.001f, false);
				passed = 0;
				angle = Math.atan2(wire.vecpath[0].z - vec.z, wire.vecpath[0].x - vec.x);
				angle += Static.rad90;
				path.add(wire.vecpath[0].add(VecUtil.rotByRad(angle, wodl.get(p)[0])));
				path.add(wire.vecpath[0].add(VecUtil.rotByRad(angle, wodl.get(p)[1])));
				for(int v = 0; v < wire.vecpath.length - 1; v++){
					last = wire.vecpath[v];
					vec = wire.vecpath[v + 1];
					angle = Math.atan2(last.z - vec.z, last.x - vec.x);
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
		wire.model_end_angle = Math.atan2(wire.vecpath[0].z - vec.z, wire.vecpath[0].x - vec.x);
		wire.model_end_angle = Static.toDegrees(wire.model_end_angle);
		wire.model_start_angle = wire.model_end_angle - 180;
		//
		if(wire.deco_start != null) wire.deco_s = FvtmRegistry.WIREDECOS.get(wire.deco_start);
		if(wire.deco_end != null) wire.deco_e = FvtmRegistry.WIREDECOS.get(wire.deco_end);
		float hwl = wire.length / 2;
		if(wire.deco_s != null){
			float len = getLongestDownward(wire.deco_s.getModel());
			vec = wire.getVectorPosition(len > hwl ? hwl : len, false);
	        double dx = wire.vecpath[0].x - vec.x, dy = wire.vecpath[0].y - vec.y, dz = wire.vecpath[0].z - vec.z;
			wire.model_start_angle_down = (float)Math.atan2(dy, Math.sqrt(dx * dx + dz * dz));
			wire.model_start_angle_down = Static.toDegrees(wire.model_start_angle_down);
		}
		if(wire.deco_e != null){
			float len = getLongestDownward(wire.deco_e.getModel());
			vec = wire.getVectorPosition(wire.length - (len > hwl ? hwl : len), false);
	        double dx = wire.vecpath[wire.vecpath.length - 1].x - vec.x, dy = wire.vecpath[wire.vecpath.length - 1].y - vec.y, dz = wire.vecpath[wire.vecpath.length - 1].z - vec.z;
			wire.model_end_angle_down = (float)Math.atan2(dy, Math.sqrt(dx * dx + dz * dz));
			wire.model_end_angle_down = Static.toDegrees(wire.model_end_angle_down);
		}
	}

	private static void genWireDeco(WireRelay relay, Wire wire){
		wire.deco_m = new HashMap<>();
		wire.deco_d = new HashMap<>();
		wire.deco_g = new HashMap<>();
		if(wire.decos == null) return;
		for(Entry<String, String> entry : wire.decos.entrySet()){
			WireDeco deco = FvtmRegistry.WIREDECOS.get(entry.getValue());
			if(deco != null){
				wire.deco_m.put(entry.getKey(), deco);
				wire.deco_d.put(entry.getKey(), new HashMap<>());
				wire.deco_g.put(entry.getKey(), new HashMap<>());
				for(ModelGroup list : deco.getModel().groups){
					for(Program program : list.getAllPrograms()){
						if(program instanceof WirePrograms.SpacedDeco == false) continue;
						wire.deco_d.get(entry.getKey()).put(list.name, ((WirePrograms.SpacedDeco)program).generate(relay, wire, list, entry.getKey(), true));
						break;
					}
				}
			}
		}
	}

	public static float getLongestDownward(WireModel model){
		float l = 0.01f;
		for(ModelGroup list : model.groups){
			for(Program program : list.getAllPrograms()){
				if(program instanceof WirePrograms.DownwardAngled){
					WirePrograms.DownwardAngled prog = (WirePrograms.DownwardAngled)program;
					if(prog.length() > l) l = prog.length();
				}
			}
		}
		return l;
	}

}
