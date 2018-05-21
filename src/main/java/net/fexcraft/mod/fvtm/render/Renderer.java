package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.model.ModelHitbox;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class Renderer {

    public static void drawString(String str, double x, double y, double z, float viewerYaw, float viewerPitch, float viewerRoll, boolean glow, float scale, int color){
        FontRenderer fontRenderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        //GlStateManager.glNormal3f(0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-viewerYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(viewerPitch, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(viewerRoll, 0.0F, 0.0F, 1.0F);
        GlStateManager.scale(-0.025F, -0.025F, 0.025F);
        if(scale != 1f){ GL11.glScalef(scale, scale, scale); }
        if(glow){
            GlStateManager.disableLighting();
        }
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.depthMask(true);
        fontRenderer.drawString(str, -fontRenderer.getStringWidth(str) / 2, 0, color);ModelHitbox.instance().render();
        if(glow){
            GlStateManager.enableLighting();
        }
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
