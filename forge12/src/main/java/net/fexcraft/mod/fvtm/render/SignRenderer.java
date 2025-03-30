package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.item.SignItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignRegion;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.GLUtils112;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

public class SignRenderer {

	private static SignSystem sys;
	private static boolean holding;

	public static void renderSigns(World world, double cx, double cy, double cz, float ticks){
		sys = SystemManager.get(SystemManager.Systems.SIGN, WrapperHolder.getWorld(world));
		if(sys == null) return;
		holding = Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof ToolboxItem && Minecraft.getMinecraft().player.getHeldItemMainhand().getItemDamage() == ToolboxType.SIGN_ADJREM.idx;
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		for(SignRegion reg : sys.getRegions().values()){
			for(SignInstance sign : reg.getSigns().values()){
				//TODO distance check
				GL11.glPushMatrix();
				GL11.glTranslated(sign.vec.vec.x - cx, sign.vec.vec.y - cy, sign.vec.vec.z - cz);
				if(sign.components.size() == 0){
					rencube();
				}
				else{
					if(holding || Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof SignItem){
						rencube();
					}
					RenderCache cache = sign.getRenderCache();
					for(SignData scom : sign.components){
						if(scom.getType().getModel() == null){
							DebugModels.CUBE_CYN.render(0.25f);
							RGB.glColorReset();
						}
						else{
							int i = DecorationRenderer.getBrightness(sign.vec.pos.x, sign.vec.pos.y, sign.vec.pos.z), j = i % 65536, k = i / 65536;
							OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
							GL11.glPushMatrix();
							GLUtils112.translate(scom.offset);
							if(scom.roty != 0f) GL11.glRotatef(scom.roty, 0, 1, 0);
							if(scom.rotz != 0f) GL11.glRotatef(scom.rotz, 0, 0, 1);
							if(scom.rotx != 0f) GL11.glRotatef(scom.rotx, 1, 0, 0);
							if(scom.sclx != 1f || scom.scly != 1f || scom.sclz != 1f) GL11.glScalef(scom.sclx, scom.scly, scom.sclz);
							TexUtil.bindTexture(scom.getTexture().getTexture());
							scom.getType().getModel().render(RENDERDATA.set(scom, sign, cache));
							GL11.glPopMatrix();
						}
					}
				}
				GL11.glPopMatrix();
			}
		}
		GL11.glPopMatrix();
	}

	private static void rencube(){
		GL11.glTranslatef(0, 0.25f, 0);
		DebugModels.CUBE_CYN.render(0.5f);
		GL11.glTranslatef(0, -0.25f, 0);
		RGB.glColorReset();
	}

}
