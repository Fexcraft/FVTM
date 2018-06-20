package net.fexcraft.mod.fvtm.render;

import net.minecraft.client.Minecraft;

import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;

public class Renderer {

    public static void drawString(String str, double x, double y, double z, float viewerYaw, float viewerPitch, float viewerRoll, boolean glow, float scale, int color){
        //FontRenderer fontRenderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
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
        SIGN_FONT_RENDERER.drawString(str, -SIGN_FONT_RENDERER.getStringWidth(str) / 2, 0, color);
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
    	font.drawString(string, x    , y + 1, 0);
    	font.drawString(string, x + 1, y + 1, 0);
    	font.drawString(string, x - 1, y    , 0);
    	font.drawString(string, x + 1, y    , 0);
    	font.drawString(string, x - 1, y - 1, 0);
    	font.drawString(string, x    , y - 1, 0);
    	font.drawString(string, x + 1, y - 1, 0);
    	font.drawString(string, x    , y    , color);
    }
    
    public static FontRenderer SIGN_FONT_RENDERER;
    
    public static void initFontRenderer(){
    	Minecraft mc = Minecraft.getMinecraft();
    	SIGN_FONT_RENDERER = new FontRenderer2(mc.gameSettings, new ResourceLocation("fvtm", "textures/font/sign_ascii.png"), mc.getTextureManager());
    }
    
    private static class FontRenderer2 extends FontRenderer {

		public FontRenderer2(GameSettings settings, ResourceLocation location, TextureManager tm){
			super(settings, location, tm, false);
			this.readFontTexture();
		}
		
		@Override
	    protected float renderUnicodeChar(char ch, boolean italic){
	        if(ch < 256){
	        	return this.renderDefaultChar(ch, italic);
	        }
	        else{
	        	return super.renderUnicodeChar(ch, italic);
	        }
	    }
		
		private void readFontTexture(){
	        IResource iresource = null;
	        BufferedImage bufferedimage;
	        try{
	            iresource = getResource(this.locationFontTexture);
	            bufferedimage = TextureUtil.readBufferedImage(iresource.getInputStream());
	        }
	        catch(IOException ioexception){ throw new RuntimeException(ioexception); }
	        finally{ IOUtils.closeQuietly((Closeable)iresource); }
	        int i = bufferedimage.getWidth(), j = bufferedimage.getHeight();
	        int[] ai = new int[i * j];
	        bufferedimage.getRGB(0, 0, i, j, ai, 0, i);
	        int k = j / 16, l = i / 16;
	        float f = 8.0F / (float)l;
	        for(int m = 0; m < 256; ++m){
	            int j1 = m % 16;
	            int k1 = m / 16;
	            if(m == 32){ this.charWidth[m] = 4; }
	            int l1;
	            for(l1 = l - 1; l1 >= 0; --l1){
	                int i2 = j1 * l + l1;
	                boolean flag1 = true;
	                for(int j2 = 0; j2 < k && flag1; ++j2){
	                    int k2 = (k1 * l + j2) * i;
	                    if((ai[i2 + k2] >> 24 & 255) != 0){
	                        flag1 = false;
	                    }
	                }
	                if(!flag1){
	                    break;
	                }
	            }
	            ++l1;
	            this.charWidth[m] = (int)(0.5D + (double)((float)l1 * f)) + 1;
	        }
	    }
    	
    }

}
