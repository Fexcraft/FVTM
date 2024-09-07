package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.model.entity.RoadMarkerModel;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil.NewRoad;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRoadMarker extends Render<RoadMarker> implements IRenderFactory<RoadMarker> {

	private ResourceLocation texture = new ResourceLocation("fvtm:textures/entity/roadmarker.png");
	public static final RGB CYAN = new RGB(0, 255, 255);
	
    public RenderRoadMarker(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0.125f;
    }

    @Override
    public void doRender(RoadMarker entity, double x, double y, double z, float entity_yaw, float ticks){
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glPushMatrix();
	    TexUtil.bindTexture(texture);
	    GL11.glRotatef(180, 0, 0, 1);
	    RoadMarkerModel.INST.marker.render();
	    NewRoad road = RoadPlacingUtil.QUEUE.get(entity.queueid);
	    if(road != null){
	    	int index = road.indexOf(entity.position);
	    	boolean arrow = index == road.selected || index == 0 || index == road.points.size() - 1;
	    	if(arrow){
				(index == road.selected ? CYAN : index == 0 ? RGB.GREEN : RGB.RED).glColorApply();
				RoadMarkerModel.INST.arrow.render();
				RGB.glColorReset();
	    	}
	    }
	    GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(RoadMarker entity){
        return texture;
    }
    
    @Override
    public Render<RoadMarker> createRenderFor(RenderManager manager){
        return new RenderRoadMarker(manager);
    }

}
