package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.RenderCacheI;
import net.fexcraft.mod.fvtm.model.entity.RailMarkerModel;
import net.fexcraft.mod.fvtm.model.entity.RoadMarkerModel;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fvtm.render.Renderer21.AZ;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailMarkerRenderer extends EntityRenderer<RailMarker, FvtmRenderState> {

	private IDL texture = IDLManager.getIDLCached("fvtm:textures/entity/railmarker.png");
	public static final RGB CYAN = new RGB(0, 255, 255);

	public RailMarkerRenderer(EntityRendererProvider.Context context){
		super(context);
		shadowRadius = 0.125F;
	}

	@Override
	public FvtmRenderState createRenderState(){
		return new FvtmRenderState();
	}

	@Override
	public void extractRenderState(RailMarker entity, FvtmRenderState state, float f){
		super.extractRenderState(entity, state, f);
		state.rail_marker = entity;
		state.f = f;
	}

	@Override
	public void render(FvtmRenderState state, PoseStack pose, MultiBufferSource buffer, int light){
		pose.pushPose();
		Renderer21.set(pose, buffer, light);
		FvtmRenderTypes.setCutout(texture);
		RailMarkerModel.INST.base.render();
		DefaultModel.RENDERDATA.texture = null;
		FvtmRenderTypes.setGlow(texture);
		RailMarkerModel.INST.glow.render();
		FvtmRenderTypes.setCutout(texture);
		DefaultPrograms.GLOW.post(RailMarkerModel.INST.glow, DefaultModel.RENDERDATA);
		if(state.rail_marker.queueid == null){
			Renderer21.setColor(RGB.BLACK);
			RailMarkerModel.INST.arrow.render();
		}
		else{
			RailPlacingUtil.NewTrack road = RailPlacingUtil.QUEUE.get(state.rail_marker.queueid);
			if(road != null){
				int index = road.indexOf(state.rail_marker.position);
				boolean arrow = index == road.selected || index == 0 || index == road.points.size() - 1;
				if(arrow){
					Renderer21.setColor(index == road.selected ? CYAN : index == 0 ? RGB.GREEN : RGB.RED);
					FvtmRenderTypes.setGlow(texture.local());
					RailMarkerModel.INST.arrow.render();
					FvtmRenderTypes.setCutout(texture);
				}
			}
		}
		Renderer21.resetColor();
		pose.popPose();
	}

}