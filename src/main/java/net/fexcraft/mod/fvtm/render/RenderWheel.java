package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.sys.pro.NWheelEntity;
import net.fexcraft.mod.fvtm.util.Command;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWheel extends Render<Entity> implements IRenderFactory<Entity> {

    public RenderWheel(RenderManager renderManager){
        super(renderManager); shadowSize = 0.125F;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialticks){
    	if(Command.OTHER) shadowSize = 0.125f;
    	else shadowSize = 0f;
        if(entity instanceof NWheelEntity /*&& Minecraft.getMinecraft().gameSettings.showDebugInfo*/){
            RenderStreetSign.drawString(((NWheelEntity)entity).wheelid, x, y, z, true, true, 0.8f, 0xb8bc38, null);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity){
        return null;
    }

    @Override
    public Render<Entity> createRenderFor(RenderManager manager){
        return new RenderWheel(manager);
    }

}
