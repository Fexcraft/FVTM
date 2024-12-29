package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.entity.RailMarkerModel;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fvtm.render.Renderer120.AZ;

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
		Renderer120.set(pose, buffer, light);
		FvtmRenderTypes.setCutout(texture);
		RailMarkerModel.INST.base.render();
		DefaultModel.RENDERDATA.texture = null;
		FvtmRenderTypes.setDef(RenderType.eyes(texture.local()));
		RailMarkerModel.INST.glow.render();
		FvtmRenderTypes.setCutout(texture);
		DefaultPrograms.GLOW.post(RailMarkerModel.INST.glow, DefaultModel.RENDERDATA);
		if(marker.queueid == null){
			Renderer120.setColor(RGB.BLACK);
			RailMarkerModel.INST.arrow.render();
		}
		else{
			RailPlacingUtil.NewTrack road = RailPlacingUtil.QUEUE.get(marker.queueid);
			if(road != null){
				int index = road.indexOf(marker.position);
				boolean arrow = index == road.selected || index == 0 || index == road.points.size() - 1;
				if(arrow){
					Renderer120.setColor(index == road.selected ? CYAN : index == 0 ? RGB.GREEN : RGB.RED);
					FvtmRenderTypes.setDef(RenderType.eyes(texture.local()));
					RailMarkerModel.INST.arrow.render();
					FvtmRenderTypes.setCutout(texture);
				}
			}
		}
		Renderer120.resetColor();
		pose.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(RailMarker entity){
		return texture.local();
	}

}