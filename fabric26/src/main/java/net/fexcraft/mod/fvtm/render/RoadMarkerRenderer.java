package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fcl.util.Renderer26;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.model.entity.RoadMarkerModel;
import net.fexcraft.mod.fvtm.render.state.RailMarkerRS;
import net.fexcraft.mod.fvtm.render.state.RoadMarkerRS;
import net.fexcraft.mod.fvtm.render.state.VehicleRenderState;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fcl.util.Renderer26.AZ;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadMarkerRenderer extends EntityRenderer<RoadMarker, RoadMarkerRS> {

	private IDL texture = IDLManager.getIDLCached("fvtm:textures/entity/roadmarker.png");
	public static final RGB CYAN = new RGB(0, 255, 255);

	public RoadMarkerRenderer(EntityRendererProvider.Context context){
		super(context);
		shadowRadius = 0.125F;
	}

	@Override
	public RoadMarkerRS createRenderState(){
		return new RoadMarkerRS();
	}

	@Override
	public void extractRenderState(RoadMarker entity, RoadMarkerRS state, float f){
		super.extractRenderState(entity, state, f);
		state.road_marker = entity;
	}

	@Override
	public void submit(RoadMarkerRS state, PoseStack pose, SubmitNodeCollector nodecoll, CameraRenderState camera){
		pose.pushPose();
		FvtmRenderTypes.getCutout(texture);
		pose.mulPose(new Quaternionf().rotateAxis(Static.rad180, AZ));
		RoadMarkerModel.INST.marker.render();
		if(state.road_marker.queueid == null){
			Renderer26.setColor(RGB.BLACK);
			RoadMarkerModel.INST.arrow.render();
		}
		else{
			RoadPlacingUtil.NewRoad road = RoadPlacingUtil.QUEUE.get(state.road_marker.queueid);
			if(road != null){
				int index = road.indexOf(state.road_marker.position);
				boolean arrow = index == road.selected || index == 0 || index == road.points.size() - 1;
				if(arrow){
					Renderer26.setColor(index == road.selected ? CYAN : index == 0 ? RGB.GREEN : RGB.RED);
					RoadMarkerModel.INST.arrow.render();
				}
			}
		}
		Renderer26.resetColor();
		pose.popPose();
	}

}