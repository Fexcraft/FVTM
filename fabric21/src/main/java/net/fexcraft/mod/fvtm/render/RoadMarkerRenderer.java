package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.InteractZone;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.model.RenderCacheI;
import net.fexcraft.mod.fvtm.model.entity.RoadMarkerModel;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.PartItemApp;
import net.fexcraft.mod.fvtm.util.Rot;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.inv.UniStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.Map;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.Renderer21.*;
import static net.fexcraft.mod.fvtm.render.SeparateRenderCache.SEP_VEH_CACHE;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;
import static net.fexcraft.mod.fvtm.util.MathUtils.valDeg;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadMarkerRenderer extends EntityRenderer<RoadMarker, FvtmRenderState> {

	private IDL texture = IDLManager.getIDLCached("fvtm:textures/entity/roadmarker.png");
	public static final RGB CYAN = new RGB(0, 255, 255);

	public RoadMarkerRenderer(EntityRendererProvider.Context context){
		super(context);
		shadowRadius = 0.125F;
	}

	@Override
	public FvtmRenderState createRenderState(){
		return new FvtmRenderState();
	}

	@Override
	public void extractRenderState(RoadMarker entity, FvtmRenderState state, float f){
		super.extractRenderState(entity, state, f);
		state.road_marker = entity;
		state.f = f;
	}

	@Override
	public void render(FvtmRenderState state, PoseStack pose, MultiBufferSource buffer, int light){
		pose.pushPose();
		Renderer21.set(pose, buffer, light);
		FvtmRenderTypes.setCutout(texture);
		pose.mulPose(new Quaternionf().rotateAxis(Static.rad180, AZ));
		RoadMarkerModel.INST.marker.render();
		if(state.road_marker.queueid == null){
			Renderer21.setColor(RGB.BLACK);
			RoadMarkerModel.INST.arrow.render();
		}
		else{
			RoadPlacingUtil.NewRoad road = RoadPlacingUtil.QUEUE.get(state.road_marker.queueid);
			if(road != null){
				int index = road.indexOf(state.road_marker.position);
				boolean arrow = index == road.selected || index == 0 || index == road.points.size() - 1;
				if(arrow){
					Renderer21.setColor(index == road.selected ? CYAN : index == 0 ? RGB.GREEN : RGB.RED);
					RoadMarkerModel.INST.arrow.render();
				}
			}
		}
		Renderer21.resetColor();
		pose.popPose();
	}

}