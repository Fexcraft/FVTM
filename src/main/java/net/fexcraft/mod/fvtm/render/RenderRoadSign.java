package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.entity.RoadSignEntity;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRoadSign extends Render<RoadSignEntity> implements IRenderFactory<RoadSignEntity> {

    public RenderRoadSign(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0.5F;
    }

    public void bindTexture(ResourceLocation rs){
        ModelBase.bindTexture(rs);
    }

    @Override
    public void doRender(RoadSignEntity entity, double x, double y, double z, float entity_yaw, float ticks){
        GL11.glPushMatrix();
        {
        	GL11.glTranslated(x, y, z);
            GL11.glRotatef(180, 1f, 0f, 0f);
            GL11.glRotatef(entity.facing.getHorizontalIndex() * 90f, 0f, 1f, 0f);
            GL11.glPushMatrix();
            this.bindTexture(this.getEntityTexture(entity));
            entity.sign.getModel().render(entity, entity.sign);
            GL11.glPopMatrix();
        }
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(RoadSignEntity entity){
        return entity.sign.getTexture();
    }
    
    @Override
    public Render<RoadSignEntity> createRenderFor(RenderManager manager){
        return new RenderRoadSign(manager);
    }

}
