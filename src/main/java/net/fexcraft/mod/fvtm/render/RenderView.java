package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.entity.RenderViewEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderView extends Render<RenderViewEntity> implements IRenderFactory<RenderViewEntity> {
	

    public RenderView(RenderManager renderManager){
        super(renderManager); shadowSize = 0.5F;
    }

    @Override
    public void doRender(RenderViewEntity entity, double x, double y, double z, float entity_yaw, float ticks){
    	if(entity.getPlayer() != Minecraft.getMinecraft().player) return;
        GL11.glPushMatrix();
        {
        	RailRenderer.renderRails(entity.world, ticks);
        	WireRenderer.renderWires(entity.world, ticks);
        }
        GL11.glPopMatrix();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(RenderViewEntity entity){
        return Resources.NULL_TEXTURE;
    }
    
    @Override
    public Render<RenderViewEntity> createRenderFor(RenderManager manager){
        return new RenderView(manager);
    }

}
