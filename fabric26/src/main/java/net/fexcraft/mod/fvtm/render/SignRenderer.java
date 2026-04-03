package net.fexcraft.mod.fvtm.render;

import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.minecraft.core.BlockPos;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignRenderer {

	private static SignSystem sys;
	private static boolean holding;
	private static BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

	public static void renderSigns(LevelRenderContext event){
		/*sys = SystemManager.get(SystemManager.Systems.SIGN, WrapperHolder.getWorld(event.camera().getEntity().level()));
		if(sys == null || event.matrixStack() == null) return;
		Camera camera = event.camera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.matrixStack();
		Renderer26.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof ToolboxItem && ((ToolboxItem)Minecraft.getInstance().player.getMainHandItem().getItem()).var == ToolboxType.SIGN_ADJREM.idx;
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer26.resetColor();
		for(SystemRegion<?, SignInstance> reg : sys.getRegions().values()){
			for(SignInstance sign : reg.getObjects().values()){
				//TODO distance check
				pose.pushPose();
				pose.translate(sign.vec.vec.x, sign.vec.vec.y, sign.vec.vec.z);
				if(sign.components.size() == 0){
					DebugUtils.renderBB(0.5f, COL_ORG);
				}
				else{
					if(holding || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof SignItem){
						DebugUtils.renderBB(0.5f, COL_ORG);
					}
					RenderCache cache = sign.getRenderCache();
					pose.mulPose(new Matrix4f().rotate(sign.yaw, AY));
					for(SignData scom : sign.components){
						if(scom.getType().getModel() == null){
							DebugUtils.renderBB(0.25f, COL_RED);
						}
						else{
							Renderer26.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(sign.vec.pos.x, sign.vec.pos.y, sign.vec.pos.z));;
							pose.pushPose();
							pose.translate(scom.offset.x, scom.offset.y, scom.offset.z);
							if(scom.roty != 0f) RENDERER.rotate(scom.roty, 0, 1, 0);
							if(scom.rotz != 0f) RENDERER.rotate(scom.rotz, 0, 0, 1);
							if(scom.rotx != 0f) RENDERER.rotate(scom.rotx, 1, 0, 0);
							if(scom.sclx != 1f || scom.scly != 1f || scom.sclz != 1f) pose.scale(scom.sclx, scom.scly, scom.sclz);
							FvtmRenderTypes.getCutout(scom.getTexture().getTexture());
							scom.getType().getModel().render(RENDERDATA.set(scom, sign).rc(cache));
							pose.popPose();
						}
					}
				}
				pose.popPose();
			}
		}
		pose.popPose();*/
	}

}
