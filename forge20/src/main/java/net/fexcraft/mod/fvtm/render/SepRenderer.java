package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.item.WireItem;
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
		if(SORTED_VEH_QUEUE.size() == 0 && SORTED_BLK_QUEUE.size() == 0) return;Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		Renderer120.setColor(RGB.WHITE);
		if(SORTED_VEH_QUEUE.size() > 0){
			pose.pushPose();
			pose.translate(-cx, -cy, -cz);
			for(int i = 0; i < SORTED_VEH_QUEUE.size(); i++){
				ModelGroupList.SeparateModelGroupList sroup = SORTED_VEH_QUEUE.get(i);
				VehicleInstance inst = SORTED_VEH_ENTITY.get(i);
				if(inst.entity == null) continue;
				RootVehicle veh = inst.entity.local();
				double[] vehpos = SORTED_VEH_POS.get(veh.getId());
				if(vehpos == null) continue;
				pose.pushPose();
				pose.translate(vehpos[0], vehpos[1], vehpos[2]);
				V3D vehrot = SORTED_VEH_ROT.get(veh.getId());
				RENDERER.rotate((float)-vehrot.x, 0, 1, 0);
				RENDERER.rotate((float)vehrot.y, 1, 0, 0);
				RENDERER.rotate((float)vehrot.z, 0, 0, 1);
				FvtmRenderTypes.setCutout(veh.vehicle.data.getCurrentTexture());
				sroup.render(RENDERDATA.set(SORTED_VEH_DATA.get(i), veh.vehicle, event.getPartialTick()).rcs(FVTM4.getRenderCache(veh)));
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
