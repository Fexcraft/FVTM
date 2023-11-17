package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.sys.pro.NWheelEntity;
import net.fexcraft.mod.fvtm.util.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderWheel extends Render<Entity> implements IRenderFactory<Entity> {

    public RenderWheel(RenderManager renderManager){
        super(renderManager); shadowSize = 0.125F;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialticks){
    	if(Command.OTHER) shadowSize = 0.125f;
    	else shadowSize = 0f;
        if(entity instanceof NWheelEntity && Minecraft.getMinecraft().getRenderManager().isDebugBoundingBox()){
            GL11.glTranslatef(0, 0.25f, 0);
            RenderStreetSign.drawString(((NWheelEntity)entity).wheelid, x, y, z, true, true, 0.8f, 0xb8bc38, null);
            GL11.glTranslatef(0, -0.25f, 0);
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
