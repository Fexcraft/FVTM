package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fcl.util.Renderer20;
import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelGroupList;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.minecraft.client.Camera;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fcl.util.Renderer20.pose;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.RVRenderer.renderPointSep;
import static net.fexcraft.mod.fvtm.render.SeparateRenderCache.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class SepRenderer {

	@SubscribeEvent
	public static void renderSeparate(RenderLevelStageEvent event){
		if(VEHICLES.size() == 0 && SORTED_BLK_QUEUE.size() == 0) return;Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		Renderer20.setColor(RGB.WHITE);
		if(VEHICLES.size() > 0){
			pose.pushPose();
			pose.translate(-cx, -cy, -cz);
			for(VehicleInstance inst : VEHICLES){
				if(inst.entity == null) continue;
				if(inst.cache == null) inst.cache = FVTM4.getRenderCache(inst.entity.local());
				SepVehCache cache = inst.cache.get(SEP_VEH_CACHE, data -> new SeparateRenderCache.SepVehCache());
				pose.pushPose();
				pose.translate(cache.pos[0], cache.pos[1], cache.pos[2]);
				RENDERER.rotate((float)-cache.rot.x, 0, 1, 0);
				RENDERER.rotate((float)cache.rot.y, 1, 0, 0);
				RENDERER.rotate((float)cache.rot.z, 0, 0, 1);
				Model vehmod = inst.data.getType().getModel();
				if(vehmod != null && vehmod.getSeparateGroups() != null){
					pose.pushPose();
					FvtmRenderTypes.setCutout(inst.data.getCurrentTexture());
					vehmod.getSeparateGroups().render(RENDERDATA.set(inst, event.getPartialTick()).rc(inst.cache).sep());
					pose.popPose();
				}
				if(cache.parts.size() > 0){
					renderPointSep(pose, inst.point, inst, cache.parts, event.getPartialTick());
				}
				pose.popPose();
			}
			pose.popPose();
		}
		if(SORTED_BLK_QUEUE.size() > 0){
			pose.pushPose();
			pose.translate(-cx, -cy, -cz);
			for(int i = 0; i < SORTED_BLK_QUEUE.size(); i++){
				ModelGroupList.SeparateModelGroupList sgroup = SORTED_BLK_QUEUE.get(i);
				BlockData data = SORTED_BLK_DATA.get(i);
				BlockEntity tile = (BlockEntity)SORTED_BLK_ENTITY.get(i);
				pose.pushPose();
				pose.translate(tile.getBlockPos().getX() + 0.5, tile.getBlockPos().getY(), tile.getBlockPos().getZ() + 0.5);
				//TODO rotate
				sgroup.render(RENDERDATA.set(data, tile, null).rcs(null/*TODO*/));
				pose.popPose();
			}
			pose.popPose();
		}
		clear();
	}

}
