package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignRegion;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.wire.*;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.GLUtils112;
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
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.Config.DISABLE_SIGNS;
import static net.fexcraft.mod.fvtm.Config.DISABLE_WIRES;
import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_REMOVAL;
import static net.fexcraft.mod.fvtm.data.ToolboxType.WIRE_SLACK;
import static net.fexcraft.mod.fvtm.event.ForgeClientEvents.*;
import static net.fexcraft.mod.fvtm.item.ToolboxItem.getToolboxType;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.Renderer120.AY;
import static net.fexcraft.mod.fvtm.util.DebugUtils.CUBE;
import static net.fexcraft.mod.fvtm.util.DebugUtils.CYNCOLOR;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE, value = { Dist.CLIENT })
public class SignRenderer {

	private static SignSystem sys;
	private static boolean holding;
	private static BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

	@SubscribeEvent
	public static void renderWires(RenderLevelStageEvent event){
		if(DISABLE_SIGNS) return;
		sys = SystemManager.get(SystemManager.Systems.SIGN, WrapperHolder.getWorld(event.getCamera().getEntity().level()));
		if(sys == null) return;
		Camera camera = event.getCamera();
		double cx = camera.getPosition().x;
		double cy = camera.getPosition().y;
		double cz = camera.getPosition().z;
		PoseStack pose = event.getPoseStack();
		Renderer120.set(pose, Minecraft.getInstance().renderBuffers().bufferSource(), 0);
		holding = Minecraft.getInstance().player.getMainHandItem().getItem() instanceof ToolboxItem && ((ToolboxItem)Minecraft.getInstance().player.getMainHandItem().getItem()).var == ToolboxType.SIGN_ADJREM.idx;
		pose.pushPose();
		Renderer120.resetColor();
		for(SignRegion reg : sys.getRegions().values()){
			for(SignInstance sign : reg.getSigns().values()){
				//TODO distance check
				pose.pushPose();
				pose.translate(sign.vec.vec.x - cx, sign.vec.vec.y - cy, sign.vec.vec.z - cz);
				if(sign.components.size() == 0){
					Renderer120.setColor(ORG);
					CUBE.render();
					Renderer120.resetColor();
				}
				else{
					if(holding || Minecraft.getInstance().player.getMainHandItem().getItem() instanceof SignItem){
						Renderer120.setColor(ORG);
						CUBE.render();
						Renderer120.resetColor();
					}
					RenderCache cache = sign.getRenderCache();
					pose.mulPoseMatrix(new Matrix4f().rotate(sign.yaw, AY));
					for(SignData scom : sign.components){
						if(scom.getType().getModel() == null){
							Renderer120.setColor(ORG);
							CUBE.render();
							Renderer120.resetColor();
						}
						else{
							Renderer120.light = LevelRenderer.getLightColor(camera.getEntity().level(), pos.set(sign.vec.pos.x, sign.vec.pos.y, sign.vec.pos.z));;
							pose.pushPose();
							pose.translate(scom.offset.x, scom.offset.y, scom.offset.z);
							if(scom.roty != 0f) GL11.glRotatef(scom.roty, 0, 1, 0);
							if(scom.rotz != 0f) GL11.glRotatef(scom.rotz, 0, 0, 1);
							if(scom.rotx != 0f) GL11.glRotatef(scom.rotx, 1, 0, 0);
							if(scom.sclx != 1f || scom.scly != 1f || scom.sclz != 1f) GL11.glScalef(scom.sclx, scom.scly, scom.sclz);
							FvtmRenderTypes.setCutout(scom.getTexture().getTexture());
							scom.getType().getModel().render(RENDERDATA.set(scom, sign, cache));
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
