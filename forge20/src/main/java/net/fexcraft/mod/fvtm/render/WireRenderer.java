package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.item.WireDecoItem;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.sys.wire.*;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.fexcraft.mod.fvtm.Config.DISABLE_WIRES;
import static net.fexcraft.mod.fvtm.FvtmResources.WHITE_TEXTURE;
import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_REMOVAL;
import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_SLACK;
import static net.fexcraft.mod.fvtm.item.ToolboxItem.getToolboxType;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_CYN;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_ORG;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class WireRenderer {

	private static WireSystem wiredata;
	private static ItemStack held;
	private static boolean holding_wire;
	private static boolean holding_slack;
	private static boolean holding_relaydeco;
	private static boolean holding_deco;

	@SubscribeEvent
	public static void renderWires(RenderLevelStageEvent event){
		if(DISABLE_WIRES) return;
		if(event.getStage() != RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS) return;
		wiredata = SystemManager.get(SystemManager.Systems.WIRE, WrapperHolder.getWorld(event.getCamera().getEntity().level()), WireSystem.class);
		if(wiredata == null || wiredata.getRegions() == null) return;
		held = Minecraft.getInstance().player.getMainHandItem();
		holding_wire = Config.DEBUG_ACTIVE || held.getItem() instanceof WireItem || (held.getItem() instanceof ToolboxItem && WIRE_REMOVAL.eq(getToolboxType(held)));
		holding_slack = Config.DEBUG_ACTIVE || held.getItem() instanceof ToolboxItem && WIRE_SLACK.eq(getToolboxType(held));
		if(held.getItem() instanceof WireDecoItem){
			WireDecoItem item = (WireDecoItem)held.getItem();
			holding_relaydeco = item.getContent().getType().equals("relay");
			holding_deco = !holding_relaydeco;
		}
		else holding_relaydeco = holding_deco = false;
		//
		Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		PoseStack pose = event.getPoseStack();
		FvtmRenderTypes.setCutout(WHITE_TEXTURE);
		Renderer20.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		for(SystemRegion<?, RelayHolder> reg : wiredata.getRegions().values()){
			for(RelayHolder holder : reg.getObjects().values()){
				for(WireRelay relay : holder.relays.values()){
					Renderer20.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(relay.pos.x, relay.pos.y + 0.1, relay.pos.z));
					//TODO frustum check
					if(Config.DEBUG_ACTIVE || holding_wire){
						DebugUtils.renderBB(relay.pos, holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_CYN);
					}
					if((Config.DEBUG_ACTIVE || holding_slack) && relay.wires.size() > 0){
						for(Wire wire : relay.wires){
							if(wire.copy) continue;
							DebugUtils.renderBB(wire.getVectorPosition(wire.length * 0.5, false),
								holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f,COL_ORG);
						}
					}
					if(relay.wires.size() > 0){
						if(holding_slack || holding_deco){
							for(Wire wire : relay.wires){
								if(wire.copy) continue;
								DebugUtils.renderBB(wire.getVectorPosition(wire.length * 0.5, false),
									holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_ORG);
							}
						}
						if(holding_relaydeco){
							for(Wire wire : relay.wires){
								DebugUtils.renderBB(wire.getVectorPosition(holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, false),
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
