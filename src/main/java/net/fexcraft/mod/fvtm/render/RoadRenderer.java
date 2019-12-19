package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.road.Region;
import net.fexcraft.mod.fvtm.sys.road.RoadSys;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RoadRenderer {
    
	private JunctionGridItem jitem;
    private ItemStack stack;
    private Vec316f[] vecs;
	//
	public static final RGB MIDDLE_GRAY = new RGB(127, 127, 127);
	public static boolean HOLDING;

	//@SubscribeEvent
    public void preview(DrawBlockHighlightEvent event){ HOLDING = false;
    	if((stack = event.getPlayer().getHeldItemMainhand()).isEmpty()) return;
    	else if(event.getTarget() == null || event.getTarget().typeOfHit != net.minecraft.util.math.RayTraceResult.Type.BLOCK) return;
    	if(stack.getItem() instanceof JunctionGridItem && ((JunctionGridItem)stack.getItem()).showJunctionGrid()){
    		Vec316f vec = new Vec316f(event.getTarget().hitVec, Config.RAIL_PLACING_GRID);
    		jitem = (JunctionGridItem)stack.getItem();  HOLDING = true;
    		if(jitem.offsetVectors()){
        		vecs = new Vec316f[jitem.getVectors(stack).length];
    			float seg = 360f / jitem.getSegments();
    			int con = (int)((((int)event.getPlayer().rotationYaw + 90f) * jitem.getSegments()) / 360f);
    			for(int i = 0; i < vecs.length; i++){
    				vecs[i] = new Vec316f(VecUtil.rotByRad(seg * con * Static.rad1, jitem.getVectors(stack)[i].vector).add(vec.vector), Config.RAIL_PLACING_GRID);
    			}
				Print.bar(event.getPlayer(), seg + " " + con + " " + (seg * con) + " " + (seg * con * Static.rad1));
    		}
    		else{
    			vecs = jitem.getVectors(stack);
    		}
        	//
    		EntityPlayer player = event.getPlayer(); GlStateManager.disableTexture2D();
            double x = player.lastTickPosX + (player.posX - player.lastTickPosX) * event.getPartialTicks();
            double y = player.lastTickPosY + (player.posY - player.lastTickPosY) * event.getPartialTicks();
            double z = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * event.getPartialTicks();
    		GL11.glTranslated(-x, -y, -z); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		GL11.glPushMatrix();
            GL11.glTranslated(vec.vector.xCoord, vec.vector.yCoord, vec.vector.zCoord);
            model1.render(); GL11.glPopMatrix();
            //
            for(int v = 0; v < vecs.length; v++){
        		GL11.glPushMatrix();
                GL11.glTranslated(vecs[v].vector.xCoord, vecs[v].vector.yCoord, vecs[v].vector.zCoord);
                model0.render();
                if(jitem.offsetVectors() && (v == 0 || v == vecs.length - 1)) model.render();
                GL11.glPopMatrix();
            }
            //
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(2.0F);
            GlStateManager.depthMask(false);
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
        	float[][] color =  ((JunctionGridItem)stack.getItem()).getGridColours();
            if(vecs.length > 1){
                for(int i = 1; i < vecs.length; i++){
                    bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                    bufferbuilder.pos(vecs[i - 1].vector.xCoord, vecs[i - 1].vector.yCoord + 0.01, vecs[i - 1].vector.zCoord)
                    	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
                    bufferbuilder.pos(vecs[i].vector.xCoord, vecs[i].vector.yCoord + 0.01, vecs[i].vector.zCoord)
                    	.color(color[1][0], color[1][1], color[1][2], color[1][3]).endVertex();
                    tessellator.draw();
                }
            }
            BlockPos pos = event.getTarget().getBlockPos();
            float yy = vec.y == 0 ? 1 : vec.y * 0.0625f;
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.getX() + (vec.x * 0.0625), pos.getY() + yy + 0.01, pos.getZ())
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            bufferbuilder.pos(pos.getX() + (vec.x * 0.0625), pos.getY() + yy + 0.01, pos.getZ() + 1)
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            tessellator.draw();
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.getX(), pos.getY() + yy + 0.01, pos.getZ() + (vec.z * 0.0625))
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            bufferbuilder.pos(pos.getX() + 1, pos.getY() + yy + 0.01, pos.getZ() + (vec.z * 0.0625))
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            tessellator.draw();
            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
            //
            GlStateManager.enableTexture2D();
            GL11.glTranslated(x, y, z);
    	} else return;
    }

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
    	if(!HOLDING) return; roaddata = Minecraft.getMinecraft().world.getCapability(Capabilities.ROADSYSTEM, null).get();
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
        	/*Junction[] junctions = reg.getJunctions().values().toArray(new Junction[0]);
        	for(int i = 0; i < junctions.length; i++){
        		if(!fru.isBoundingBoxInFrustum(junctions[i].getAABB())) continue;
            	GL11.glPushMatrix();
            	ModelBase.bindTexture(Resources.NULL_TEXTURE);
            	GL11.glTranslatef(junctions[i].getVec3f().xCoord, junctions[i].getVec3f().yCoord, junctions[i].getVec3f().zCoord);
            	if(junctions[i].tracks.isEmpty() || HOLDING){ model.render(); } else{ junction_core.render(); }
            	GL11.glPopMatrix();
        		renderLines(junctions[i]);
        	}*/
        }
		GL11.glPopMatrix();
    }

	@SuppressWarnings("unused")
	private void renderLines(Junction value){
        if(Command.DEBUG){
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            Vec3f vec0, vec1; float flfl, glgl;
    		for(int o = 0; o < value.tracks.size(); o++){
    			Path conn = value.tracks.get(o);
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
