package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.util.TexUtil;
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
        TexUtil.bindTexture(rs);
    }

    @Override
    public void doRender(TrafficSignEntity entity, double x, double y, double z, float entity_yaw, float ticks){
    	return;
    }

    @Override
    protected ResourceLocation getEntityTexture(TrafficSignEntity entity){
        return FvtmRegistry.WHITE_TEXTURE.local();//TODO entity.sign.getTexture();
    }
    
    @Override
    public Render<TrafficSignEntity> createRenderFor(RenderManager manager){
        return new RenderTrafficSign(manager);
    }

}
