package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelGroupList;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.sys.wire.RelayHolder;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.Config.DISABLE_WIRES;
import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_REMOVAL;
import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_SLACK;
import static net.fexcraft.mod.fvtm.event.ForgeClientEvents.*;
import static net.fexcraft.mod.fvtm.item.ToolboxItem.getToolboxType;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.RVRenderer.renderPointSep;
import static net.fexcraft.mod.fvtm.render.Renderer120.pose;
import static net.fexcraft.mod.fvtm.render.SeparateRenderCache.*;
import static net.fexcraft.mod.fvtm.util.DebugUtils.CUBE;

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
		Renderer120.setColor(RGB.WHITE);
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
