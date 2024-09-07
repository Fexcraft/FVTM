package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.entity.StreetSign;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderStreetSign extends Render<StreetSign> implements IRenderFactory<StreetSign> {

    public RenderStreetSign(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0.5F;
    }

    public void bindTexture(ResourceLocation rs){
        TexUtil.bindTexture(rs);
    }

    @Override
    public void doRender(StreetSign entity, double x, double y, double z, float entity_yaw, float ticks){
        GL11.glPushMatrix();
        {
        	float rot = 60;
        	switch(entity.facing.getIndex()){
	        	case 2:{ rot = 0; break; }
	        	case 3:{ rot = 180; break; }
	        	case 4:{ rot = 90; break; }
	        	case 5:{ rot = 270; break; }
        	}
        	GL11.glTranslated(x, y + 1, z);
            GL11.glRotatef(rot, 0f, 1f, 0f);
            GL11.glPushMatrix();
            this.bindTexture(this.getEntityTexture(entity));
            entity.model.render();
            GL11.glPopMatrix();
        	GL11.glTranslated(0, -1, 0);
        	GL11.glTranslated(0, 1.25, -0.24);
            for(int i = 0; i < 4; i++){
            	GL11.glTranslated(0, -0.25, 0);
            	if(entity.text[i] == null || entity.text[i].equals("")){ continue; }
            	drawString(entity.text[i], 0, -0.05, 0, entity.centered[i], true, 0.8f, entity.texture > 1 ? 0xffffff : 0, null);
            }
        }
        GL11.glPopMatrix();
    }
    
    public static void drawString(String str, double x, double y, double z, boolean centered, boolean glow, float scale, int color, Double yaw){
        FontRenderer fontRenderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
        GlStateManager.pushMatrix(); GlStateManager.translate(x, y, z);
        GlStateManager.scale(-0.025F, -0.025F, 0.025F);
        if(scale != 1f){ GL11.glScalef(scale, scale, scale); }
        if(glow){ GlStateManager.disableLighting(); }
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.depthMask(true);
        if(yaw != null) GL11.glRotated(yaw, 0, 1, 0);
        fontRenderer.drawString(str, centered ? -fontRenderer.getStringWidth(str) / 2 : -24, 0, color);
        if(glow){ GlStateManager.enableLighting(); }
        GlStateManager.disableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(StreetSign entity){
        return StreetSign.textures[entity.texture];
    }
    
    @Override
    public Render<StreetSign> createRenderFor(RenderManager manager){
        return new RenderStreetSign(manager);
    }

}
