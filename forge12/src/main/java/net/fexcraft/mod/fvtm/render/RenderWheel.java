package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.sys.pro.NWheelEntity;
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

public class RenderWheel extends Render<Entity> implements IRenderFactory<Entity> {

    public RenderWheel(RenderManager renderManager){
        super(renderManager); shadowSize = 0.125F;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialticks){
    	if(Command.OTHER) shadowSize = 0.125f;
    	else shadowSize = 0f;
        if(entity instanceof NWheelEntity && Minecraft.getMinecraft().getRenderManager().isDebugBoundingBox()){
            drawString(((NWheelEntity)entity).wheelid, x, y + 2, z, true, true, 0.8f, 0xb8bc38, null);
            if(EnvInfo.DEV && Static.getServer().isSinglePlayer()){
                Entity serv = Static.getServer().getWorld(entity.dimension).getEntityByID(entity.getEntityId());
                if(serv == null) return;
                drawString(serv.motionX + "", x, y + 2.2, z, true, true, 0.8f, 0xb8bc38, null);
                drawString(serv.motionY + "", x, y + 2.4, z, true, true, 0.8f, 0xb8bc38, null);
                drawString(serv.motionZ + "", x, y + 2.6, z, true, true, 0.8f, 0xb8bc38, null);
                drawString(serv.rotationYaw + "", x, y + 2.8, z, true, true, 0.8f, 0xb8bc38, null);
            }
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
