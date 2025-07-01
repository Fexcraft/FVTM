package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.sys.pro.WheelEntity;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.uni.EnvInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.render.EffectRenderer.drawString;

public class RenderWheel extends Render<WheelEntity> implements IRenderFactory<WheelEntity> {

    public RenderWheel(RenderManager renderManager){
        super(renderManager); shadowSize = 0.125F;
    }

    @Override
    public void doRender(WheelEntity entity, double x, double y, double z, float yaw, float partialticks){
        if(Minecraft.getMinecraft().getRenderManager().isDebugBoundingBox()){
            if(Command.OTHER) shadowSize = 0.125f;
            else shadowSize = 0f;
            GL11.glPushMatrix();
            GL11.glRotatef(entity.rotationYaw, 0, 1, 0);
            drawString(entity.wheelid, x, y + 2, z, true, true, 0.8f, 0xb8bc38, null);
            drawString(entity.motionX + "", x, y + 2.2, z, true, true, 0.8f, 0xb8bc38, null);
            drawString(entity.motionY + "", x, y + 2.4, z, true, true, 0.8f, 0xb8bc38, null);
            drawString(entity.motionZ + "", x, y + 2.6, z, true, true, 0.8f, 0xb8bc38, null);
            drawString(entity.rotationYaw + "", x, y + 2.8, z, true, true, 0.8f, 0xb8bc38, null);
            GL11.glPopMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(WheelEntity entity){
        return null;
    }

    @Override
    public Render<WheelEntity> createRenderFor(RenderManager manager){
        return new RenderWheel(manager);
    }

}
