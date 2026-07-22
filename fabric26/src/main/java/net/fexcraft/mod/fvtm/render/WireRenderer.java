package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fexcraft.mod.fvtm.Config;
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
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_CYN;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_ORG;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireRenderer {

	private static WireSystem wiredata;
	private static ItemStack held;
	private static boolean holding_wire;
	private static boolean holding_slack;
	private static boolean holding_comp_relay;
	private static boolean holding_comp;
	private static boolean holding_comp_rem;

	public static void renderWires(LevelRenderContext context){
		wiredata = SystemManager.get(SystemManager.Systems.WIRE, context.levelState().getData(LEVEL_RS_KEY).key);
		if(wiredata == null || wiredata.getRegions() == null) return;
		held = Minecraft.getInstance().player.getMainHandItem();
		holding_wire = Config.DEBUG_ACTIVE || held.getItem() instanceof WireItem || (held.getItem() instanceof ToolboxItem && WIRE_REMOVAL.eq(getToolboxType(held)));
		holding_slack = Config.DEBUG_ACTIVE || held.getItem() instanceof ToolboxItem && WIRE_SLACK.eq(getToolboxType(held));
		holding_comp_rem = held.getItem() instanceof ToolboxItem && WIRE_COMPONENT.eq(getToolboxType(held));
		if(held.getItem() instanceof WireCompItem){
			WireCompItem item = (WireCompItem)held.getItem();
			holding_comp_relay = item.getContent().getType().equals("relay");
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
					if(Config.DEBUG_ACTIVE || holding_wire){
						RenderUtil26.renderBB(relay.pos, holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_CYN);
					}
					if((Config.DEBUG_ACTIVE || holding_slack) && relay.wires.size() > 0){
						for(Wire wire : relay.wires){
							if(wire.copy) continue;
							RenderUtil26.renderBB(wire.getVectorPosition(wire.length * 0.5, false),
								holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_ORG);
						}
					}
					if(relay.wires.size() > 0){
						if(holding_slack || holding_comp || holding_comp_rem){
							for(Wire wire : relay.wires){
								if(wire.copy) continue;
								RenderUtil26.renderBB(wire.getVectorPosition(wire.length * 0.5, false),
									holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_ORG);
							}
						}
						if(holding_comp_relay || holding_comp_rem){
							for(Wire wire : relay.wires){
								RenderUtil26.renderBB(wire.getVectorPosition(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, false),
									holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_CYN);
							}
						}
					}
					UniWireRenderer.renderRelay(relay, 0, 0, 0);
				}
			}
		}
		pose.popPose();
	}

}
