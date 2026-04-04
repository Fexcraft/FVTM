package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fexcraft.mod.fcl.util.Renderer26;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import org.joml.Matrix4f;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fcl.util.Renderer26.AY;
import static net.fexcraft.mod.fvtm.FVTMC.LEVEL_RS_KEY;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_ORG;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_RED;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignRenderer {

	private static SignSystem sys;
	private static boolean holding;
	private static BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

	public static void renderSigns(LevelRenderContext context){
		sys = SystemManager.get(SystemManager.Systems.SIGN, context.levelState().getData(LEVEL_RS_KEY).key);
		if(sys == null) return;
		double cx = context.levelState().cameraRenderState.pos.x;
		double cy = context.levelState().cameraRenderState.pos.y;
		double cz = context.levelState().cameraRenderState.pos.z;
		PoseStack pose = context.poseStack();
		RenderUtil26.set(pose, context.submitNodeCollector(), FvtmRenderTypes.white(), 0);
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
					RenderUtil26.renderBB(0.5f, COL_ORG);
				}
				else{
					if(holding || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof SignItem){
						RenderUtil26.renderBB(0.5f, COL_ORG);
					}
					RenderCache cache = sign.getRenderCache();
					pose.mulPose(new Matrix4f().rotate(sign.yaw, AY));
					for(SignData scom : sign.components){
						if(scom.getType().getModel() == null){
							RenderUtil26.renderBB(0.25f, COL_RED);
						}
						else{
							//TODO Renderer26.light = LevelRenderer.getLightCoords(null, pos.set(sign.vec.pos.x, sign.vec.pos.y, sign.vec.pos.z));;
							pose.pushPose();
							pose.translate(scom.offset.x, scom.offset.y, scom.offset.z);
							if(scom.roty != 0f) RENDERER.rotate(scom.roty, 0, 1, 0);
							if(scom.rotz != 0f) RENDERER.rotate(scom.rotz, 0, 0, 1);
							if(scom.rotx != 0f) RENDERER.rotate(scom.rotx, 1, 0, 0);
							if(scom.sclx != 1f || scom.scly != 1f || scom.sclz != 1f) pose.scale(scom.sclx, scom.scly, scom.sclz);
							RenderUtil26.type(FvtmRenderTypes.getCutout(scom.getTexture().getTexture()));
							RenderUtil26.render(scom.getType().getModel(), RENDERDATA.set(scom, sign).rc(cache));
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
