package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class Renderer {

    public static void drawNameplate(FontRenderer fontRendererIn, String str, float x, float y, float z, int verticalShift, float viewerYaw, float viewerPitch, boolean isThirdPersonFrontal, boolean isSneaking){
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.glNormal3f(0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-viewerYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float) (isThirdPersonFrontal ? -1 : 1) * viewerPitch, 1.0F, 0.0F, 0.0F);
        //GlStateManager.scale(-0.025F, -0.025F, 0.025F);
        GL11.glScaled(0.005, 0.005, 0.005);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(false);
        //
        if(!isSneaking){
            GlStateManager.disableDepth();
        }
        //
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        /*int i = fontRendererIn.getStringWidth(str) / 2;
        GlStateManager.disableTexture2D();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos((double)(-i - 1), (double)(-1 + verticalShift), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        bufferbuilder.pos((double)(-i - 1), (double)(8 + verticalShift), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        bufferbuilder.pos((double)(i + 1), (double)(8 + verticalShift), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        bufferbuilder.pos((double)(i + 1), (double)(-1 + verticalShift), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();*/
        //
        if(!isSneaking){
            fontRendererIn.drawString(str, 0/*-fontRendererIn.getStringWidth(str) / 2*/, verticalShift, 0x000000);
            /*553648127*/
            GlStateManager.enableDepth();
        }
        //
        GlStateManager.depthMask(true);
        fontRendererIn.drawString(str, 0/*-fontRendererIn.getStringWidth(str) / 2*/, verticalShift, isSneaking ? 0x000000 : -1);
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();
    }

    /**
     * got this from <b>ebf</b>
     */
    public static void drawTextOutlined(FontRenderer font, String string, int x, int y, int color){
        font.drawString(string, x - 1, y + 1, 0);
        font.drawString(string, x, y + 1, 0);
        font.drawString(string, x + 1, y + 1, 0);
        font.drawString(string, x - 1, y, 0);
        font.drawString(string, x + 1, y, 0);
        font.drawString(string, x - 1, y - 1, 0);
        font.drawString(string, x, y - 1, 0);
        font.drawString(string, x + 1, y - 1, 0);
        font.drawString(string, x, y, color);
    }

}
