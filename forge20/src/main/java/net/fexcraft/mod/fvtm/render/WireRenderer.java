package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.model.content.WireModel;
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
import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_REMOVAL;
import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_SLACK;
import static net.fexcraft.mod.fvtm.event.ForgeClientEvents.*;
import static net.fexcraft.mod.fvtm.item.ToolboxItem.getToolboxType;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_CYN;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_ORG;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class WireRenderer {

	public static Wire CURRENT;
	public static double ANGLE = 0;
	public static double ANGLE_DOWN = 0;
	//
	private static WireSystem wiredata;
	private static ItemStack held;
	private static boolean holding_wire;
	private static boolean holding_slack;

	@SubscribeEvent
	public static void renderWires(RenderLevelStageEvent event){
		if(DISABLE_WIRES) return;
		if(event.getStage() != RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS) return;
		wiredata = SystemManager.get(SystemManager.Systems.WIRE, WrapperHolder.getWorld(event.getCamera().getEntity().level()), WireSystem.class);
		if(wiredata == null || wiredata.getRegions() == null) return;
		held = Minecraft.getInstance().player.getMainHandItem();
		holding_wire = held.getItem() instanceof WireItem || (held.getItem() instanceof ToolboxItem && WIRE_REMOVAL.eq(getToolboxType(held)));
		holding_slack = held.getItem() instanceof ToolboxItem && WIRE_SLACK.eq(getToolboxType(held));
		Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		PoseStack pose = event.getPoseStack();
		FvtmRenderTypes.setCutout(JUNCTEX);
		Renderer120.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		pose.pushPose();
		pose.translate(-cx, -cy, -cz);
		for(SystemRegion<?, RelayHolder> reg : wiredata.getRegions().values()){
			for(RelayHolder holder : reg.getObjects().values()){
				for(WireRelay relay : holder.relays.values()){
					Renderer120.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(relay.pos.x, relay.pos.y + 0.1, relay.pos.z));
					//TODO frustum check
					if(DebugUtils.ACTIVE || holding_wire){
						DebugUtils.renderBB(relay.pos, holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f, COL_CYN);
					}
					if((DebugUtils.ACTIVE || holding_slack) && relay.wires.size() > 0){
						for(Wire wire : relay.wires){
							if(wire.copy) continue;
							DebugUtils.renderBB(wire.getVectorPosition(wire.length * 0.5, false),
								holder.hasRef() ? holder.ref().getSize(relay.getKey()) * 2 : 0.25f,COL_ORG);
						}
					}
					renderWires(pose, relay);
				}
			}
		}
		pose.popPose();
	}

	private static void renderWires(PoseStack pose, WireRelay relay){
		pose.pushPose();
		for(int i = 0; i < relay.size(); i++){
			if(relay.wires.get(i).copy) continue;
			Wire wire = relay.wires.get(i);
			if(wire.vecpath == null || wire.getWireType() == null) continue;
			WireModel model = wire.getWireType().getModel();
			if(wire.wiremodel == null) PathModelGenerator.generateWireModel(wire, model);
			FvtmRenderTypes.setCutout(wire.getWireType().getTexture());
			pose.translate(wire.vecpath[0].x, wire.vecpath[0].y, wire.vecpath[0].z);
			wire.wiremodel.render();
			if(relay.getTile() != null){
				CURRENT = wire;
				ANGLE = wire.model_end_angle;
				if(wire.deco_s != null){
					ANGLE_DOWN = wire.model_start_angle_down;
					//TODO wire deco
				}
				if(wire.deco_e != null){
					ANGLE_DOWN = wire.model_end_angle_down;
					//TODO wire deco
				}
				//TODO wire deco
			}
		}
		pose.popPose();
	}

}
