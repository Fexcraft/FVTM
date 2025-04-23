package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.FvtmRegistry;
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
import net.minecraft.resources.ResourceLocation;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fvtm.render.Renderer120.*;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoRenderer extends EntityRenderer<DecorationEntity> {

	public DecoRenderer(EntityRendererProvider.Context context){
		super(context);
		shadowRadius = 0.125F;
	}

	@Override
	public void render(DecorationEntity deco, float yaw, float tick, PoseStack pose, MultiBufferSource buffer, int light){
		pose.pushPose();
		Renderer120.set(pose, buffer, light);
		EntityW ent = UniEntity.getEntity(deco);
		for(DecorationData data : deco.decos){
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
			data.getType().getModel().render(DefaultModel.RENDERDATA.set(data, ent).rc(FVTM4.getRenderCache(deco)));
			pose.popPose();
		}
		if(deco.decos.size() == 0 || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof DecorationItem){
			pose.translate(0, 0.125f, 0.);
			DebugUtils.renderBB(0.25f, COL_CYN);
		}
		pose.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(DecorationEntity entity){
		return FvtmRegistry.WHITE_TEXTURE.local();
	}

}