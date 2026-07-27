package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.data.WireComponent;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.item.WireCompItem;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.sys.wire.*;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;

import static net.fexcraft.mod.fvtm.FVTMC.LEVEL_RS_KEY;
import static net.fexcraft.mod.fvtm.data.ToolboxType.*;
import static net.fexcraft.mod.fvtm.item.ToolboxItem.getToolboxType;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireRenderer {

	private static WireSystem wiredata;
	private static WireComponent comp;
	private static ItemStack held;
	private static boolean holding_wire;
	private static boolean holding_rem;
	private static boolean holding_slack;
	private static boolean holding_comp_relay;
	private static boolean holding_comp;
	private static boolean holding_comp_rem;

	public static void renderWires(LevelRenderContext context){
		wiredata = SystemManager.get(SystemManager.Systems.WIRE, context.levelState().getData(LEVEL_RS_KEY).key);
		if(wiredata == null || wiredata.getRegions() == null) return;
		held = Minecraft.getInstance().player.getMainHandItem();
		holding_wire = Config.DEBUG_ACTIVE || held.getItem() instanceof WireItem;
		holding_rem = Config.DEBUG_ACTIVE || (held.getItem() instanceof ToolboxItem && WIRE_REMOVAL.eq(getToolboxType(held)));
		holding_slack = Config.DEBUG_ACTIVE || held.getItem() instanceof ToolboxItem && WIRE_SLACK.eq(getToolboxType(held));
		holding_comp_rem = held.getItem() instanceof ToolboxItem && WIRE_COMPONENT.eq(getToolboxType(held));
		if(held.getItem() instanceof WireCompItem){
			WireComponent comp = ((WireCompItem)held.getItem()).getContent();
			holding_comp_relay = comp.getType().equals("relay");
			holding_comp = !holding_comp_relay;
		}
		else holding_comp_relay = holding_comp = false;
		//
		double cx = context.levelState().cameraRenderState.pos.x;
		double cy = context.levelState().cameraRenderState.pos.y;
		double cz = context.levelState().cameraRenderState.pos.z;
		PoseStack pose = context.poseStack();
		RenderUtil26.set(pose, context.submitNodeCollector(), FvtmRenderTypes.white(), 0);
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		for(SystemRegion<?, RelayHolder> reg : wiredata.getRegions().values()){
			for(RelayHolder holder : reg.getObjects().values()){
				for(WireRelay relay : holder.relays.values()){
					//TODO Renderer26.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(relay.pos.x, relay.pos.y + 0.1, relay.pos.z));
					//TODO frustum check
					UniWireRenderer.renderRelay(holder, relay, 0, 0, 0, holding_wire, holding_rem, holding_slack, holding_comp, holding_comp_relay, holding_comp_rem, comp);
				}
			}
		}
		pose.popPose();
	}

}
