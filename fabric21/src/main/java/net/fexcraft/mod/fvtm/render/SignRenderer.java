package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import org.joml.Matrix4f;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.Config.DISABLE_SIGNS;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.Renderer21.AY;
import static net.fexcraft.mod.fvtm.render.Renderer21.ORG;
import static net.fexcraft.mod.fvtm.util.DebugUtils.CUBE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignRenderer {

	private static SignSystem sys;
	private static boolean holding;
	private static BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

	public static void renderSigns(WorldRenderContext event){
		if(DISABLE_SIGNS) return;
		sys = SystemManager.get(SystemManager.Systems.SIGN, WrapperHolder.getWorld(event.camera().getEntity().level()));
		if(sys == null || event.matrixStack() == null) return;
		Camera camera = event.camera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.matrixStack();
		Renderer21.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof ToolboxItem && ((ToolboxItem)Minecraft.getInstance().player.getMainHandItem().getItem()).var == ToolboxType.SIGN_ADJREM.idx;
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer21.resetColor();
		for(SystemRegion<?, SignInstance> reg : sys.getRegions().values()){
			for(SignInstance sign : reg.getObjects().values()){
				//TODO distance check
				pose.pushPose();
				pose.translate(sign.vec.vec.x, sign.vec.vec.y, sign.vec.vec.z);
				if(sign.components.size() == 0){
					FvtmRenderTypes.setLines();
					Renderer21.setColor(ORG);
					pose.pushPose();
					pose.scale(0.5f, 0.5f, 0.5f);
					CUBE.render();
					pose.popPose();
					Renderer21.resetColor();
				}
				else{
					if(holding || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof SignItem){
						FvtmRenderTypes.setLines();
						pose.pushPose();
						Renderer21.setColor(ORG);
						pose.scale(0.5f, 0.5f, 0.5f);
						CUBE.render();
						pose.popPose();
						Renderer21.resetColor();
					}
					RenderCache cache = sign.getRenderCache();
					pose.mulPose(new Matrix4f().rotate(sign.yaw, AY));
					for(SignData scom : sign.components){
						if(scom.getType().getModel() == null){
							FvtmRenderTypes.setLines();
							Renderer21.setColor(ORG);
							pose.pushPose();
							pose.scale(0.5f, 0.5f, 0.5f);
							CUBE.render();
							pose.popPose();
							Renderer21.resetColor();
						}
						else{
							Renderer21.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(sign.vec.pos.x, sign.vec.pos.y, sign.vec.pos.z));;
							pose.pushPose();
							pose.translate(scom.offset.x, scom.offset.y, scom.offset.z);
							if(scom.roty != 0f) RENDERER.rotate(scom.roty, 0, 1, 0);
							if(scom.rotz != 0f) RENDERER.rotate(scom.rotz, 0, 0, 1);
							if(scom.rotx != 0f) RENDERER.rotate(scom.rotx, 1, 0, 0);
							if(scom.sclx != 1f || scom.scly != 1f || scom.sclz != 1f) pose.scale(scom.sclx, scom.scly, scom.sclz);
							FvtmRenderTypes.setCutout(scom.getTexture().getTexture());
							scom.getType().getModel().render(RENDERDATA.set(scom, sign, cache));
							pose.popPose();
						}
					}
				}
				pose.popPose();
			}
		}
		pose.popPose();
	}

}
