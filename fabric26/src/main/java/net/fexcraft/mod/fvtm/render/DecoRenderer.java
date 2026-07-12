package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fexcraft.mod.fcl.util.Renderer26;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.deco.DecoInstance;
import net.fexcraft.mod.fvtm.sys.deco.DecoSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fcl.util.Renderer26.*;
import static net.fexcraft.mod.fvtm.FVTMC.LEVEL_RS_KEY;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.RenderUtil.RENDER_UTIL;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_ORG;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoRenderer {

	private static DecoSystem sys;
	private static boolean holding;
	private static BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
	private static Level level;

	public static void renderDecos(LevelRenderContext context){
		sys = SystemManager.get(SystemManager.Systems.DECO, context.levelState().getData(LEVEL_RS_KEY).key);
		if(sys == null) return;
		level = WrapperHolder.getClientWorld().local();
		double cx = context.levelState().cameraRenderState.pos.x;
		double cy = context.levelState().cameraRenderState.pos.y;
		double cz = context.levelState().cameraRenderState.pos.z;
		PoseStack pose = context.poseStack();
		RenderUtil26.set(pose, context.submitNodeCollector(), FvtmRenderTypes.white(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof ToolboxItem && ((ToolboxItem)Minecraft.getInstance().player.getMainHandItem().getItem()).var == ToolboxType.DECO_ADJREM.idx;
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer26.resetColor();
		for(SystemRegion<?, DecoInstance> reg : sys.getRegions().values()){
			for(DecoInstance deco : reg.getObjects().values()){
				if(deco.vec.pos.dis(cx, cy, cz) > Config.DECO_VIEW_DISTANCE) continue;
				pose.pushPose();
				pose.translate(deco.vec.vec.x, deco.vec.vec.y, deco.vec.vec.z);
				if(deco.decorations.size() == 0){
					RenderUtil26.renderBB(0.5f, COL_ORG);
				}
				else{
					if(holding || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof DecorationItem){
						RenderUtil26.renderBB(0.5f, COL_ORG);
					}
					RenderCache cache = deco.getRenderCache();
					for(DecorationData dcom : deco.decorations){
						if(dcom.getType().getModel() == null){
							RenderUtil26.renderBB(0.25f, COL_RED);
						}
						else{
							cache.light(LevelRenderer.getLightCoords(level, pos.set(deco.vec.pos.x + dcom.offset.x, deco.vec.pos.y +  + dcom.offset.y + sixteenth, deco.vec.pos.z + dcom.offset.z)));
							pose.pushPose();
							pose.translate(dcom.offset.x, dcom.offset.y, dcom.offset.z);
							if(dcom.roty != 0f) RENDERER.rotate(dcom.roty, 0, 1, 0);
							if(dcom.rotz != 0f) RENDERER.rotate(dcom.rotz, 0, 0, 1);
							if(dcom.rotx != 0f) RENDERER.rotate(dcom.rotx, 1, 0, 0);
							if(dcom.sclx != 1f || dcom.scly != 1f || dcom.sclz != 1f) pose.scale(dcom.sclx, dcom.scly, dcom.sclz);
							RenderUtil26.type(FvtmRenderTypes.getCutout(dcom.getTexture().getTexture()));
							RENDER_UTIL.render(dcom.getType().getModel(), RENDERDATA.set(dcom, deco).rc(cache));
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