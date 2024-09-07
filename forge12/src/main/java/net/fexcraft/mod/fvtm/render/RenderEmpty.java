package net.fexcraft.mod.fvtm.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEmpty extends Render<Entity> implements IRenderFactory<Entity> {

    public RenderEmpty(RenderManager renderManager){
        super(renderManager); shadowSize = 0.125F;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialticks){
        return;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity){
        return null;
    }

    @Override
    public Render<Entity> createRenderFor(RenderManager manager){
        return new RenderEmpty(manager);
    }

}
