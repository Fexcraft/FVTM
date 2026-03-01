package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.item.WireDecoItem;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.sys.wire.RelayHolder;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_REMOVAL;
import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_SLACK;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_CYN;

public class WireRenderer {

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
	private static ItemStack held;
	private static boolean holding_wire;
	private static boolean holding_slack;
	private static boolean holding_relaydeco;
	private static boolean holding_deco;
	private static V3D cubepos;
    
    public static void renderWires(World world, double cx, double cy, double cz, float partialticks){
    	if(!Config.MD_WIRE) return;
	    wiredata = SystemManager.get(Systems.WIRE, WrapperHolder.getWorld(world));
	    if(wiredata == null || wiredata.getRegions() == null) return;
		held = Minecraft.getMinecraft().player.getHeldItemMainhand();
		holding_wire = Command.OTHER || held.getItem() instanceof WireItem || (held.getItem() instanceof ToolboxItem && WIRE_REMOVAL.eq(held.getItemDamage()));
		holding_slack = Command.OTHER || held.getItem() instanceof ToolboxItem && WIRE_SLACK.eq(held.getItemDamage());
		if(held.getItem() instanceof WireDecoItem){
			WireDecoItem item = (WireDecoItem)held.getItem();
			holding_relaydeco = item.getContent().getType().equals("relay");
			holding_deco = !holding_relaydeco;
		}
		else holding_relaydeco = holding_deco = false;
        //
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //GL11.glTranslated(-cx, -cy, -cz);
        for(SystemRegion<?, RelayHolder> reg : wiredata.getRegions().values()){
        	for(RelayHolder holder : reg.getObjects().values()){
            	for(WireRelay relay : holder.relays.values()){
            		if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(relay.getAABB().local())) continue;
                	if(Command.OTHER || holding_wire){// || relay.wires.isEmpty()){
						GL11.glPushMatrix();
						GL11.glTranslated(relay.pos.x - cx, relay.pos.y - cy, relay.pos.z - cz);
						DebugUtils.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_CYN);
						GL11.glPopMatrix();
                	}
					if(relay.wires.size() > 0){
						if(holding_slack || holding_deco){
							for(Wire wire : relay.wires){
								if(wire.copy) continue;
								cubepos = wire.getVectorPosition(wire.length * 0.5, false);
								GL11.glPushMatrix();
								GL11.glTranslated(cubepos.x - cx, cubepos.y - cy, cubepos.z - cz);
								DebugUtils.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_CYN);
								GL11.glPopMatrix();
							}
						}
						if(holding_relaydeco){
							for(Wire wire : relay.wires){
								cubepos = wire.getVectorPosition(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, false);
								GL11.glPushMatrix();
								GL11.glTranslated(cubepos.x - cx, cubepos.y - cy, cubepos.z - cz);
								DebugUtils.renderBB(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_CYN);
								GL11.glPopMatrix();
							}
						}
					}
					if(Command.OTHER) renderDebugRelay(relay, cx, cy, cz);
					else UniWireRenderer.renderRelay(relay, cx, cy, cz);
            	}
        	}
        }
		GL11.glPopMatrix();
    }

	private static void renderDebugRelay(WireRelay relay, double cx, double cy, double cz){
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
			GL11.glPopMatrix();*/
		}
	}

}
