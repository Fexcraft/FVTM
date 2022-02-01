package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTrafficSign extends Render<TrafficSignEntity> implements IRenderFactory<TrafficSignEntity> {

    public RenderTrafficSign(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0.5F;
    }

    public void bindTexture(ResourceLocation rs){
        ModelBase.bindTexture(rs);
    }

    @Override
    public void doRender(TrafficSignEntity entity, double x, double y, double z, float entity_yaw, float ticks){
        GL11.glPushMatrix();
        {
        	GL11.glTranslated(x, y, z);
            GL11.glRotatef(180, 1f, 0f, 0f);
            GL11.glRotatef(entity.rotation, 0f, 1f, 0f);
            GL11.glPushMatrix();
            this.bindTexture(this.getEntityTexture(entity));
            //TODO entity.sign.getModel().render(entity, entity.sign);
            DebugModels.CENTERSPHERE.render(0.75f);
            GL11.glPopMatrix();
        }
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(TrafficSignEntity entity){
        return Resources.WHITE_TEXTURE;//TODO entity.sign.getTexture();
    }
    
    @Override
    public Render<TrafficSignEntity> createRenderFor(RenderManager manager){
        return new RenderTrafficSign(manager);
    }

}
