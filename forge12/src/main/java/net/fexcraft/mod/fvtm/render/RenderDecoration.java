package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDecoration extends Render<DecorationEntity> implements IRenderFactory<DecorationEntity> {

    public RenderDecoration(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0;
    }

    public void bindTexture(ResourceLocation rs){
        TexUtil.bindTexture(rs);
    }

    @Override
    public void doRender(DecorationEntity entity, double x, double y, double z, float entity_yaw, float ticks){
    	return;
    }

    @Override
    protected ResourceLocation getEntityTexture(DecorationEntity entity){
        return FvtmRegistry.WHITE_TEXTURE.local();//TODO entity.sign.getTexture();
    }
    
    @Override
    public Render<DecorationEntity> createRenderFor(RenderManager manager){
        return new RenderDecoration(manager);
    }

}
