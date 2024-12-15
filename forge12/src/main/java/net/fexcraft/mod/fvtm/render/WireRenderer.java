package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.WireDeco;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.model.program.WirePrograms;
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
import static net.fexcraft.mod.fvtm.Config.DISABLE_WIRES;
import static net.fexcraft.mod.fvtm.model.DebugModels.CUBE_CYN;
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
			.addSphere(0, 0, 0, 2, 6, 6, 1, 1).setLines(new RGB(0x00ddff));
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
	private static boolean holding;
	private static float size;
    
    public static void renderWires(World world, double cx, double cy, double cz, float partialticks){
    	if(DISABLE_WIRES) return;
	    wiredata = SystemManager.get(Systems.WIRE, WrapperHolder.getWorld(world));
	    if(wiredata == null || wiredata.getRegions() == null) return;
		holding = Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof WireItem;
        //
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //GL11.glTranslated(-cx, -cy, -cz);
        for(WireRegion reg : wiredata.getRegions().values()){
        	for(RelayHolder holder : reg.getHolders().values()){
            	for(WireRelay relay : holder.relays.values()){
            		if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(relay.getAABB().local())) continue;
                	if(Command.OTHER || holding){// || relay.wires.isEmpty()){
						GL11.glPushMatrix();
						GL11.glTranslated(relay.pos.x - cx, relay.pos.y - cy, relay.pos.z - cz);
						size = holder.hasRef() ? holder.ref().sizes.get(relay.getKey()) * 2 : 0.25f;
						GL11.glScalef(size, size, size);
						CUBE_CYN.render(1f);
						GL11.glPopMatrix();
                	}
            		renderWires(relay, cx, cy, cz);
            	}
        	}
        }
		GL11.glPopMatrix();
    }

	private static void renderWires(WireRelay relay, double cx, double cy, double cz){
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
                    bufferbuilder.pos(vec0.x - cx, vec0.y + (conn.copy ? 0.1f : 0) - cy, vec0.z - cz).color(0f, glgl, flfl, 1F).endVertex();
                    bufferbuilder.pos(vec1.x - cx, vec1.y + (conn.copy ? 0.1f : 0) - cy, vec1.z - cz).color(0f, glgl, flfl, 1F).endVertex();
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
				WireModel model = wire.getWireType().getModel();
        		if(wire.wiremodel == null) PathModelGenerator.generateWireModel(wire, model);
        		TexUtil.bindTexture(wire.getWireType().getTexture());
				GL11.glTranslated(wire.vecpath[0].x - cx, wire.vecpath[0].y - cy, wire.vecpath[0].z - cz);
        		wire.wiremodel.render();
        		if(relay.getTile() != null){
        			CURRENT = wire;
    				ANGLE = wire.model_end_angle;
        			if(wire.deco_s != null){
        				ANGLE_DOWN = wire.model_start_angle_down;
        				GL11.glPushMatrix();
            			//GL11.glTranslated(wire.vecpath[0].x, wire.vecpath[0].y, wire.vecpath[0].z);
            			GL11.glRotated(180, 0, 0, 1);
            			GL11.glRotated(90, 0, 1, 0);
            			GL11.glRotated(wire.model_start_angle, 0, 1, 0);
    	        		TexUtil.bindTexture(wire.deco_s.getTexture());
            			wire.deco_s.getModel().render(RENDERDATA.set(((BlockTileEntity)relay.getTile()).getBlockData(), relay.getTile(), null, null, false));
            			//GL11.glTranslatef(-wire.vecpath[0].x, -wire.vecpath[0].y, -wire.vecpath[0].z);
            			GL11.glPopMatrix();
        			}
        			if(wire.deco_e != null){
        				//ANGLE = wire.model_end_angle;
        				ANGLE_DOWN = wire.model_end_angle_down;
            			int l = wire.vecpath.length - 1;
        				GL11.glPushMatrix();
            			//GL11.glTranslated(wire.vecpath[l].x, wire.vecpath[l].y, wire.vecpath[l].z);
            			GL11.glRotated(180, 0, 0, 1);
            			GL11.glRotated(90, 0, 1, 0);
            			GL11.glRotated(wire.model_end_angle, 0, 1, 0);
            			//RGB.RED.glColorApply();
    	        		TexUtil.bindTexture(wire.deco_e.getTexture());
            			wire.deco_e.getModel().render(RENDERDATA.set(((BlockTileEntity)relay.getTile()).getBlockData(), relay.getTile(), null, null, false));
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
                            			//GL11.glTranslated(vec.x, vec.y, vec.z);
                            			GL11.glRotated(180, 0, 0, 1);
                            			GL11.glRotated(90, 0, 1, 0);
                    					wm.transforms.apply();
                    	        		TexUtil.bindTexture(dm.getValue().getTexture());
                    					list.render(RENDERDATA.set(((BlockTileEntity)relay.getTile()).getBlockData(), relay.getTile(), null, null, false));
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
                					list.render(RENDERDATA.set(((BlockTileEntity)relay.getTile()).getBlockData(), relay.getTile(), null, null, false));
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

}
