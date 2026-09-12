package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fcl.util.Renderer20;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import static net.fexcraft.mod.fvtm.model.InternalModels.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailMarkerRenderer extends EntityRenderer<RailMarker> {

	private IDL texture = IDLManager.getIDLCached("fvtm:textures/entity/railmarker.png");
	public static final RGB CYAN = new RGB(0, 255, 255);

	public RailMarkerRenderer(EntityRendererProvider.Context context){
		super(context);
		shadowRadius = 0.125F;
	}

	@Override
	public void render(RailMarker marker, float yaw, float tick, PoseStack pose, MultiBufferSource buffer, int light){
		pose.pushPose();
		Renderer20.set(pose, buffer, light);
		FvtmRenderTypes.setCutout(texture);
		RAIL_MARKER_BASE.render();
		//FvtmRenderTypes.setGlow(texture);
		RAIL_MARKER_GLOW.render();
		if(marker.queueid == null){
			Renderer20.setColor(RGB.BLACK);
			RAIL_MARKER_ARROW.render();
		}
		else{
			RailPlacingUtil.NewTrack road = RailPlacingUtil.QUEUE.get(marker.queueid);
			if(road != null){
				int index = road.indexOf(marker.position);
				boolean arrow = index == road.selected || index == 0 || index == road.points.size() - 1;
				if(arrow){
					Renderer20.setColor(index == road.selected ? CYAN : index == 0 ? RGB.GREEN : RGB.RED);
					RAIL_MARKER_ARROW.render();
				}
			}
		}
		Renderer20.resetColor();
		pose.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(RailMarker entity){
		return texture.local();
	}

}