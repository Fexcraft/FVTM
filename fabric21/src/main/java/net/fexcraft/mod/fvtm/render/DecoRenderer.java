package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fvtm.render.Renderer21.*;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_CYN;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoRenderer extends EntityRenderer<DecorationEntity, FvtmRenderState> {

	public DecoRenderer(EntityRendererProvider.Context context){
		super(context);
		shadowRadius = 0.125F;
	}

	@Override
	public FvtmRenderState createRenderState(){
		return new FvtmRenderState();
	}

	@Override
	public void extractRenderState(DecorationEntity entity, FvtmRenderState state, float f){
		super.extractRenderState(entity, state, f);
		state.decoration = entity;
		state.f = f;
	}

	@Override
	public void render(FvtmRenderState state, PoseStack pose, MultiBufferSource buffer, int light){
		pose.pushPose();
		Renderer21.set(pose, buffer, light);
		EntityW ent = UniEntity.getEntity(state.decoration);
		for(DecorationData data : state.decoration.decos){
			if(data.getType().getModel() == null){
				//FvtmLogger.LOGGER.debug(data.modelid);
				continue;
			}
			FvtmRenderTypes.setCutout(data.getCurrentTexture());
			pose.pushPose();
			pose.translate(data.offset.x16, data.offset.y16, data.offset.z16);
			if(data.rotx != 0.0F || data.roty != 0.0F || data.rotz != 0.0F){
				pose.mulPose(new Quaternionf()
					.rotateAxis(Static.toRadians(data.roty), AY)
					.rotateAxis(Static.toRadians(data.rotx), AX)
					.rotateAxis(Static.toRadians(data.rotz), AZ)
				);
			}
			pose.scale(data.sclx, data.scly, data.sclz);
			data.getType().getModel().render(DefaultModel.RENDERDATA.set(data, ent));//TODO rendercache
			pose.popPose();
		}
		if(state.decoration.decos.size() == 0 || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof DecorationItem){
			pose.translate(0, 0.125f, 0.);
			DebugUtils.renderBB(0.25f, COL_CYN);
		}
		pose.popPose();
	}

}