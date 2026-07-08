package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.deco.DecoInstance;
import net.fexcraft.mod.fvtm.sys.deco.DecoSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.GLUtils112;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_CYN;
import static net.fexcraft.mod.fvtm.util.DebugUtils.COL_RED;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoRenderer {

	private static DecoSystem sys;
	private static boolean holding;

	public static void renderDecos(World world, double cx, double cy, double cz, float ticks){
		sys = SystemManager.get(SystemManager.Systems.DECO, WrapperHolder.getWorld(world));
		if(sys == null) return;
		holding = Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof ToolboxItem && Minecraft.getMinecraft().player.getHeldItemMainhand().getItemDamage() == ToolboxType.DECO_ADJREM.idx;
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		for(SystemRegion<?, DecoInstance> reg : sys.getRegions().values()){
			for(DecoInstance deco : reg.getObjects().values()){
				if(deco.vec.vec.dis(cx, cy, cz) > Config.DECO_VIEW_DISTANCE) continue;
				GL11.glPushMatrix();
				GL11.glTranslated(deco.vec.vec.x - cx, deco.vec.vec.y - cy, deco.vec.vec.z - cz);
				if(deco.decorations.size() == 0){
					DebugUtils.renderBB(0.5f, COL_CYN);
				}
				else{
					if(holding || Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof DecorationItem){
						DebugUtils.renderBB(0.5f, COL_CYN);
					}
					RenderCache cache = deco.getRenderCache();
					for(DecorationData dcom : deco.decorations){
						if(dcom.getType().getModel() == null){
							DebugUtils.renderBB(0.25f, COL_RED);
						}
						else{
							int i = getBrightness(deco.vec.pos.x, deco.vec.pos.y, deco.vec.pos.z), j = i % 65536, k = i / 65536;
							OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
							GL11.glPushMatrix();
							GLUtils112.translate(dcom.offset);
							if(dcom.roty != 0f) GL11.glRotatef(dcom.roty, 0, 1, 0);
							if(dcom.rotz != 0f) GL11.glRotatef(dcom.rotz, 0, 0, 1);
							if(dcom.rotx != 0f) GL11.glRotatef(dcom.rotx, 1, 0, 0);
							if(dcom.sclx != 1f || dcom.scly != 1f || dcom.sclz != 1f) GL11.glScalef(dcom.sclx, dcom.scly, dcom.sclz);
							TexUtil.bindTexture(dcom.getTexture().getTexture());
							dcom.getType().getModel().render(RENDERDATA.set(dcom, deco).rc(cache));
							GL11.glPopMatrix();
						}
					}
				}
				GL11.glPopMatrix();
			}
		}
		GL11.glPopMatrix();
	}

	public static int getBrightness(double x, double y, double z){
		BlockPos.MutableBlockPos mutblk = new BlockPos.MutableBlockPos(MathHelper.floor(x), 0, MathHelper.floor(z));
		if(Minecraft.getMinecraft().world.isBlockLoaded(mutblk)){
			mutblk.setY(MathHelper.floor(y));
			return Minecraft.getMinecraft().world.getCombinedLight(mutblk, 0);
		}
		return 0;
	}

}
