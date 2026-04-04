package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fcl.util.Renderer26;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.model.entity.RailMarkerModel;
import net.fexcraft.mod.fvtm.render.state.RailMarkerRS;
import net.fexcraft.mod.fvtm.render.state.VehicleRenderState;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.level.CameraRenderState;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailMarkerRenderer extends EntityRenderer<RailMarker, RailMarkerRS> {

	private static IDL texture = IDLManager.getIDLCached("fvtm:textures/entity/railmarker.png");
	public static final RGB CYAN = new RGB(0, 255, 255);

	public RailMarkerRenderer(EntityRendererProvider.Context context){
		super(context);
		shadowRadius = 0.125F;
	}

	@Override
	public RailMarkerRS createRenderState(){
		return new RailMarkerRS();
	}

	@Override
	public void extractRenderState(RailMarker entity, RailMarkerRS state, float f){
		super.extractRenderState(entity, state, f);
		state.rail_marker = entity;
	}

	@Override
	public void submit(RailMarkerRS state, PoseStack pose, SubmitNodeCollector nodecoll, CameraRenderState camera){
		pose.pushPose();
		RenderUtil26.set(pose, nodecoll, FvtmRenderTypes.getCutout(texture), state.lightCoords);
		RenderUtil26.render(RailMarkerModel.INST.base);
		RENDERDATA.texture = null;
		RenderUtil26.type(FvtmRenderTypes.getGlow(texture));
		RenderUtil26.render(RailMarkerModel.INST.glow);
		if(state.rail_marker.queueid == null){
			Renderer26.setColor(RGB.BLACK);
			RenderUtil26.render(RailMarkerModel.INST.arrow);
		}
		else{
			RailPlacingUtil.NewTrack road = RailPlacingUtil.QUEUE.get(state.rail_marker.queueid);
			if(road != null){
				int index = road.indexOf(state.rail_marker.position);
				boolean arrow = index == road.selected || index == 0 || index == road.points.size() - 1;
				if(arrow){
					Renderer26.setColor(index == road.selected ? CYAN : index == 0 ? RGB.GREEN : RGB.RED);
					RenderUtil26.render(RailMarkerModel.INST.arrow);
				}
			}
		}
		Renderer26.resetColor();
		pose.popPose();
	}

}