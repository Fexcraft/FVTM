package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.blocks.RailConnTile;
import net.fexcraft.mod.fvtm.entities.RailLink;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.Vec3d;

import org.lwjgl.opengl.GL11;

@fTESR
public class RailConnRenderer extends TileEntitySpecialRenderer<RailConnTile> {
	
	private static final ModelRendererTurbo model;
	static {
        model = new ModelRendererTurbo(null, 0, 0, 32, 32);
        model.addCylinder(0, 0, 0, 2, 16, 32, 1, 1, ModelRendererTurbo.MR_TOP);
        model.setRotationPoint(0, -16, 0);
	}

    @Override
    public void render(RailConnTile te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	//if(te.links == null || te.links.length == 0){
            GL11.glPushMatrix();
            GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
            Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotated(90, 0, 1D, 0);
            Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
            model.render();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    	//}
    	if(te.links != null && te.links.length > 0){
            GL11.glPushMatrix();
            GL11.glTranslated(posX, posY, posZ);
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(2.0F);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask(false);
            Minecraft mc = Minecraft.getMinecraft();
        	Vec3d pos = new Vec3d(posX + mc.player.posX, posY + mc.player.posY, posZ + mc.player.posZ);
            for(RailLink link : te.links){
            	Vec3d vec0 = link._2x.subtract(pos); Vec3d vec = link._1x.subtract(pos);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferbuilder = tessellator.getBuffer();
                bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                bufferbuilder.pos(vec0.x, vec0.y, vec0.z).color(1, 0, 0, 1F).endVertex();
                bufferbuilder.pos(vec.x, vec.y, vec.z).color(1, 0, 0, 1f).endVertex();
                tessellator.draw();
            }
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    	}
    }

}
