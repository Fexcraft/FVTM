package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.mod.fcl.util.Renderer20;
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

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_ORG;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_RED;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class DecoRenderer {

	private static DecoSystem sys;
	private static boolean holding;
	private static BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

	@SubscribeEvent
	public static void renderDecos(RenderLevelStageEvent event){
		if(!Config.MD_DECORATION) return;
		if(event.getStage() != RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS) return;
		sys = SystemManager.get(SystemManager.Systems.DECO, WrapperHolder.getWorld(event.getCamera().getEntity().level()));
		if(sys == null) return;
		Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.getPoseStack();
		Renderer20.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof ToolboxItem && ((ToolboxItem)Minecraft.getInstance().player.getMainHandItem().getItem()).var == ToolboxType.DECO_ADJREM.idx;
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		Renderer20.resetColor();
		for(SystemRegion<?, DecoInstance> reg : sys.getRegions().values()){
			for(DecoInstance deco : reg.getObjects().values()){
				if(deco.vec.pos.dis(cx, cy, cz) > Config.DECO_VIEW_DISTANCE) continue;
				pose.pushPose();
				pose.translate(deco.vec.vec.x, deco.vec.vec.y, deco.vec.vec.z);
				if(deco.decorations.size() == 0){
					DebugUtils.renderBB(0.5f, COL_ORG);
				}
				else{
					if(holding || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof DecorationItem){
						DebugUtils.renderBB(0.5f, COL_ORG);
					}
					RenderCache cache = deco.getRenderCache();
					for(DecorationData dcom : deco.decorations){
						if(dcom.getType().getModel() == null){
							DebugUtils.renderBB(0.25f, COL_RED);
						}
						else{
							Renderer20.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(deco.vec.pos.x, deco.vec.pos.y, deco.vec.pos.z));;
							pose.pushPose();
							pose.translate(dcom.offset.x, dcom.offset.y, dcom.offset.z);
							if(dcom.roty != 0f) RENDERER.rotate(dcom.roty, 0, 1, 0);
							if(dcom.rotz != 0f) RENDERER.rotate(dcom.rotz, 0, 0, 1);
							if(dcom.rotx != 0f) RENDERER.rotate(dcom.rotx, 1, 0, 0);
							if(dcom.sclx != 1f || dcom.scly != 1f || dcom.sclz != 1f) pose.scale(dcom.sclx, dcom.scly, dcom.sclz);
							FvtmRenderTypes.setCutout(dcom.getTexture().getTexture());
							dcom.getType().getModel().render(RENDERDATA.set(dcom, deco).rc(cache));
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
