package net.fexcraft.mod.fvtm.render;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.entity.RailTestEntity;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRailTestEnt extends Render<RailTestEntity> implements IRenderFactory<RailTestEntity> {

	private ResourceLocation texture = new ResourceLocation("minecraft:textures/blocks/stone_granite.png");
	private ModelRendererTurbo box = new ModelRendererTurbo(null, 16, 16).addBox(-2, -2, -2, 4, 4, 4);
	
    public RenderRailTestEnt(RenderManager renderManager){
        super(renderManager); shadowSize = 0.125F;
    }

    public void bindTexture(ResourceLocation rs){
        TexUtil.bindTexture(rs);
    }

    @Override
    public void doRender(RailTestEntity entity, double x, double y, double z, float entity_yaw, float ticks){
        GL11.glPushMatrix();
        {
        	GL11.glTranslated(x, y, z); GL11.glPushMatrix();
	        this.bindTexture(this.getEntityTexture(entity)); box.render();
	        GL11.glPopMatrix(); GL11.glTranslated(0, 1, 0);
        	EffectRenderer.drawString(getPosString(entity), 0.8f, 0xffffff, false, true, false);
        }
        GL11.glPopMatrix();
    }
    
    private String getPosString(RailTestEntity entity){
		return df.format(entity.posX) + ", " + df.format(entity.posY) + ", " + df.format(entity.posZ) + " / " + df.format(entity.passed);
	}
	
	private static final DecimalFormat df = new DecimalFormat("#.#");
	static { df.setRoundingMode(RoundingMode.CEILING); }

    @Override
    protected ResourceLocation getEntityTexture(RailTestEntity entity){
        return texture;
    }
    
    @Override
    public Render<RailTestEntity> createRenderFor(RenderManager manager){
        return new RenderRailTestEnt(manager);
    }

}
