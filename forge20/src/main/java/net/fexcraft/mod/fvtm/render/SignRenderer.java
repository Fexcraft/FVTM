package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.Renderer20.AY;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_ORG;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_RED;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class SignRenderer {

	private static SignSystem sys;
	private static boolean holding;
	private static BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

	@SubscribeEvent
	public static void renderSigns(RenderLevelStageEvent event){
		if(!Config.MD_SIGN) return;
		if(event.getStage() != RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS) return;
		sys = SystemManager.get(SystemManager.Systems.SIGN, WrapperHolder.getWorld(event.getCamera().getEntity().level()));
		if(sys == null) return;
		Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.getPoseStack();
		Renderer20.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof ToolboxItem && ((ToolboxItem)Minecraft.getInstance().player.getMainHandItem().getItem()).var == ToolboxType.SIGN_ADJREM.idx;
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer20.resetColor();
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
					pose.mulPoseMatrix(new Matrix4f().rotate(sign.yaw, AY));
					for(SignData scom : sign.components){
						if(scom.getType().getModel() == null){
							DebugUtils.renderBB(0.25f, COL_RED);
						}
						else{
							Renderer20.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(sign.vec.pos.x, sign.vec.pos.y, sign.vec.pos.z));;
							pose.pushPose();
							pose.translate(scom.offset.x, scom.offset.y, scom.offset.z);
							if(scom.roty != 0f) RENDERER.rotate(scom.roty, 0, 1, 0);
							if(scom.rotz != 0f) RENDERER.rotate(scom.rotz, 0, 0, 1);
							if(scom.rotx != 0f) RENDERER.rotate(scom.rotx, 1, 0, 0);
							if(scom.sclx != 1f || scom.scly != 1f || scom.sclz != 1f) pose.scale(scom.sclx, scom.scly, scom.sclz);
							FvtmRenderTypes.setCutout(scom.getTexture().getTexture());
							scom.getType().getModel().render(RENDERDATA.set(scom, sign).rc(cache));
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
