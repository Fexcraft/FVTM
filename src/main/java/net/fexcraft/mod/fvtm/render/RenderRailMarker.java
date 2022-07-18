package net.fexcraft.mod.fvtm.render;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.model.entity.RailMarkerModel;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRailMarker extends Render<RailMarker> implements IRenderFactory<RailMarker> {

	private ResourceLocation texture = new ResourceLocation("fvtm:textures/entity/railmarker.png");
	private RailMarkerModel model = new RailMarkerModel();
	
    public RenderRailMarker(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0.125F;
    }

    public void bindTexture(ResourceLocation rs){
        TexUtil.bindTexture(rs);
    }

    @Override
    public void doRender(RailMarker entity, double x, double y, double z, float entity_yaw, float ticks){
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glPushMatrix();
	    TexUtil.bindTexture(texture);
	    GL11.glRotatef(180, 0, 0, 1);
	    model.marker.render();
	    GL11.glPopMatrix();
	    GL11.glTranslatef(0, 1.5f, 0);
        EffectRenderer.drawString(getPosString(entity), 0.8f, 0xffffff, true, true, false);
        GL11.glPopMatrix();
    }
    
    private String getPosString(RailMarker entity){
		return df.format(entity.posX) + ", " + df.format(entity.posY) + ", " + df.format(entity.posZ) + " / " + "";
	}
	
	private static final DecimalFormat df = new DecimalFormat("#.#");
	static { df.setRoundingMode(RoundingMode.CEILING); }

    @Override
    protected ResourceLocation getEntityTexture(RailMarker entity){
        return texture;
    }
    
    @Override
    public Render<RailMarker> createRenderFor(RenderManager manager){
        return new RenderRailMarker(manager);
    }

}
