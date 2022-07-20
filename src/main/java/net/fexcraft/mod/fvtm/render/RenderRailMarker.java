package net.fexcraft.mod.fvtm.render;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.model.entity.RailMarkerModel;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil.NewTrack;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRailMarker extends Render<RailMarker> implements IRenderFactory<RailMarker> {

	private ResourceLocation texture = new ResourceLocation("fvtm:textures/entity/railmarker.png");
	public static final RGB CYAN = new RGB(0, 255, 255);
	
    public RenderRailMarker(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0.125f;
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
	    RailMarkerModel.INST.marker.render();
	    NewTrack track = RailPlacingUtil.QUEUE.get(entity.queueid);
	    if(track != null){
	    	int index = track.indexOf(entity.position);
	    	boolean arrow = index == track.selected || index == 0 || index == track.points.size() - 1;
	    	if(arrow){
				(index == 0 ? RGB.GREEN : index == track.selected ? CYAN : RGB.RED).glColorApply();
				RailMarkerModel.INST.arrow.render();
				RGB.glColorReset();
	    	}
	    }
	    GL11.glPopMatrix();
	    //GL11.glTranslatef(0, 1.5f, 0);
        //EffectRenderer.drawString(getPosString(entity), 0.8f, 0xffffff, true, true, false);
        GL11.glPopMatrix();
    }
    
    protected String getPosString(RailMarker entity){
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
