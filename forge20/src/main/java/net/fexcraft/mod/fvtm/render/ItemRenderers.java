package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.content.VehicleModel;
import net.fexcraft.mod.fvtm.util.VehItemApp;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.item.UniStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.NonNullLazy;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fvtm.render.Renderer120.*;
import static net.fexcraft.mod.fvtm.render.Renderer120.AY;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ItemRenderers {

	public static final NonNullLazy<BlockEntityWithoutLevelRenderer> VEHICLE_RENDERER = NonNullLazy.of(() -> new BlockEntityWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels()) {
		@Override
		public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack pose, MultiBufferSource src, int v0, int v1){
			VehItemApp via = UniStack.getApp(stack, VehItemApp.class);
			if(via != null && via.data != null && via.data.getType().getModel() != null){
				VehicleModel model = (VehicleModel)via.data.getType().getModel();
				Renderer120.set(pose, src, v0);
				FvtmRenderTypes.setCutout(via.data.getCurrentTexture());
				pose.pushPose();
				//
				pose.translate(0.5, 0.5, 0);
				Vec3f translate = model.item_translate.get(context.name());
				pose.translate(translate.x, translate.y, translate.z);
				if(via.data.getType().isTrailer() && !via.data.getType().getVehicleType().isRailVehicle()){
					if(context == ItemDisplayContext.GUI){
						pose.translate(-.375, -.375, 0);
					}
					else if(context == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || context == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND){
						pose.translate(0, 0, -0.5);
					}
				}
				Vec3f rotate = model.item_rotate.get(context.name());
				pose.mulPose(new Quaternionf()
					.rotateAxis(Static.toRadians(rotate.y), AY)
					.rotateAxis(Static.toRadians(rotate.x), AX)
					.rotateAxis(Static.toRadians(rotate.z), AZ));
				Vec3f scale = model.item_scale.get(context.name());
				pose.scale(scale.x, scale.y, scale.z);
				//
				pose.pushPose();
				pose.mulPose(new Quaternionf().rotateAxis(-Static.rad90, AY));
				model.render(DefaultModel.RENDERDATA.set(via.data, null, null, false, 0));
				if(via.data.getParts().size() > 0){
					RVRenderer.renderPoint(pose, via.data.getRotationPoint("vehicle"), null, via.data, null, 0);
				}
				pose.popPose();
				//
				pose.popPose();
			}
		}
	});

}
