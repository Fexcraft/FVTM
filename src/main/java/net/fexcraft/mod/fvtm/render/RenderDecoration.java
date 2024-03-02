package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDecoration extends Render<Decoration> implements IRenderFactory<Decoration> {

    public RenderDecoration(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0;
    }

    public void bindTexture(ResourceLocation rs){
        TexUtil.bindTexture(rs);
    }

    @Override
    public void doRender(Decoration entity, double x, double y, double z, float entity_yaw, float ticks){
    	return;
    }

    @Override
    protected ResourceLocation getEntityTexture(Decoration entity){
        return FvtmRegistry.WHITE_TEXTURE.local();//TODO entity.sign.getTexture();
    }
    
    @Override
    public Render<Decoration> createRenderFor(RenderManager manager){
        return new RenderDecoration(manager);
    }

}
