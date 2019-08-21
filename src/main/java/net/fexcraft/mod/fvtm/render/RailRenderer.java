package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.RailItemTemp;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailData;
import net.fexcraft.mod.fvtm.sys.rail.RailRegion;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RailRenderer {
    
    private ItemStack stack;
    private Vec316f[] vecs;

	@SubscribeEvent
    public void preview(DrawBlockHighlightEvent event){
    	if((stack = event.getPlayer().getHeldItemMainhand()).isEmpty()) return;
    	//else if(event.getTarget() == null || event.getTarget().typeOfHit != RayTraceResult.Type.BLOCK) return;
    	if(stack.getItem() instanceof RailItemTemp){
    		vecs = ((RailItemTemp)stack.getItem()).getVectors(stack); Vec316f vec = new Vec316f(event.getTarget().hitVec);
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
            for(Vec316f v : vecs){
        		GL11.glPushMatrix();
                GL11.glTranslated(v.vector.xCoord, v.vector.yCoord, v.vector.zCoord);
                model0.render(); GL11.glPopMatrix();
            }
            if(vecs.length > 1){
                GL11.glPushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.glLineWidth(2.0F);
                GlStateManager.depthMask(false);
        		Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferbuilder = tessellator.getBuffer();
                for(int i = 1; i < vecs.length; i++){
                    bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                    bufferbuilder.pos(vecs[i - 1].vector.xCoord, vecs[i - 1].vector.yCoord, vecs[i - 1].vector.zCoord).color(0f, 1f, 0f, 1F).endVertex();
                    bufferbuilder.pos(vecs[i].vector.xCoord, vecs[i].vector.yCoord, vecs[i].vector.zCoord).color(0f, 1f, 0f, 1F).endVertex();
                    tessellator.draw();
                }
                GlStateManager.depthMask(true);
                GlStateManager.disableBlend();
                GL11.glPopMatrix();
            }
            GlStateManager.enableTexture2D();
            GL11.glTranslated(x, y, z);
    	} else return;
    }
    
	protected static final ModelRendererTurbo model, model0, model1, junction_core;
	static{
		model = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, 0, 0, 0.4f, 8, 32, 1, 1, ModelRendererTurbo.MR_TOP);
		model0 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(245, 234, 128));
		model1 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(123, 245, 126));
		junction_core = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, -.5f, 0, 0.9f, 1, 8, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(35, 35, 35));
	}
	
	private static RailData raildata;
    
    @SubscribeEvent
    public void renderRails(RenderWorldLastEvent event){
	    raildata = (RailData)Static.getServer().getEntityWorld().getCapability(Capabilities.RAILSYSTEM, null);
        //if(raildata.isLoading()) return;
        Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
        double x = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * event.getPartialTicks();
        double y = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * event.getPartialTicks();
        double z = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * event.getPartialTicks();
        //
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-x, -y, -z);
        ModelBase.bindTexture(Resources.NULL_TEXTURE);
        for(RailRegion reg : raildata.getRegions().values()){
        	//if(reg.READING) continue;
        	for(int i = 0; i < reg.getJunctions().size(); i++){
        		Junction junk = reg.getJunctions().values().toArray(new Junction[0])[i];
        		//if(junk.tracks.isEmpty()){
            		GL11.glPushMatrix();
                    GlStateManager.disableTexture2D();
            		GL11.glTranslatef(junk.getVec3f().xCoord, junk.getVec3f().yCoord, junk.getVec3f().zCoord);
            		if(junk.tracks.isEmpty()){ RGB.RED.glColorApply(); model.render(); RGB.glColorReset(); }
            		else junction_core.render();
                    GlStateManager.enableTexture2D();
            		GL11.glPopMatrix();
        		//}
        		renderLines(junk);
        	}
        }
		GL11.glPopMatrix();
    }

	private void renderLines(Junction value){
		Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        Vec3f vec0, vec1; float flfl, glgl;
        //
        if(true){
    		for(int o = 0; o < value.tracks.size(); o++){
    			Track conn = value.tracks.get(o);
    	        flfl = conn.isOppositeCopy() ? 1 : 0;
    	        glgl = conn.isOppositeCopy() ? 0 : 1;
                GL11.glPushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.glLineWidth(2.0F);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask(false);
    			for(int j = 0; j < conn.vecpath.length - 1; j++){
    				vec0 = conn.vecpath[j];//.subtract(pos);
    				vec1 = conn.vecpath[j + 1];//.subtract(pos);
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
                if(vec.length == 1){ /*Print.debug(vec[0], conn.length);*/ continue; }
                GL11.glPushMatrix();
                GL11.glTranslatef(vec[0], vec[1] + (conn.isOppositeCopy() ? 0.1f : 0), vec[2]);
                (conn.isOppositeCopy() ? model1 : model0).render();// GL11.glTranslatef(-vec[0], -vec[1], -vec[2]);
                GL11.glPopMatrix();
    		}
        }
        /*else{
        	//if(value.displaylist == null){
        		//value.displaylist = GL11.glGenLists(1);
        		//GL11.glNewList(value.displaylist, GL11.GL_COMPILE);
        		//
            	/*GL11.glPushMatrix();
            	Minecraft.getMinecraft().entityRenderer.enableLightmap();
            	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            	GL11.glEnable(GL11.GL_LIGHTING);
            	GL11.glDisable(GL11.GL_BLEND);
            	RenderHelper.enableStandardItemLighting();
        		for(Track conn : value.tracks){
        			if(conn.isOppositeCopy()) continue;
        			//ModelBase.bindTexture(conn.getGauge().getTexture());
        			boolean b = false;
        			for(int k = 0; k < conn.vecpath.length - 1; k++){
        				vec0 = conn.vecpath[k];//.subtract(pos);
        				vec1 = conn.vecpath[k + 1];//.subtract(pos);//TODO replace with translate
        				double dis = vec1.distanceTo(vec0);
        				/* renderpiece(vec1, vec, dis); while(dis > 0.5){ dis -= 0.5; renderpiece(vec1, vec, dis); } if(dis > 0) renderpiece(vec1, vec, dis); */
        				/*if(b = !b) GL11.glTranslated(0, -0.01, 0);
        				GL11.glTranslatef(0, -0.5f, 0);
        				while(dis > 0){ RailGaugeModel.renderpiece(((RailGaugeModel)conn.getGauge().getModel()).base, vec0, vec1, dis, true); dis -= 0.5; }
        				GL11.glTranslatef(0,  0.5f, 0);
        				if(b) GL11.glTranslated(0, 0.01, 0);
        			}
        		}
        		Minecraft.getMinecraft().entityRenderer.disableLightmap();
        		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        		GL11.glDisable(GL11.GL_LIGHTING);
        		GL11.glPopMatrix();
        		//
				//GL11.glEndList();
        	//}
			//GL11.glCallList(value.displaylist);
        }*/
	}
	
	public static int getBrightness(double x, double y, double z){
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(MathHelper.floor(x), 0, MathHelper.floor(z));
        if(Minecraft.getMinecraft().world.isBlockLoaded(blockpos$mutableblockpos)){
            blockpos$mutableblockpos.setY(MathHelper.floor(y));
            return Minecraft.getMinecraft().world.getCombinedLight(blockpos$mutableblockpos, 0);
        } else { return 0; }
	}

}
