package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

public class DecorationRenderer {

	public static void renderDecorations(World world, double cx, double cy, double cz, float partialticks){
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		//GL11.glTranslated(-cx, -cy, -cz);
		for(Entity ent : world.loadedEntityList){
			if(ent instanceof DecorationEntity == false) continue;
			if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(ent.getEntityBoundingBox())) continue;
			DecorationEntity deco = (DecorationEntity)ent;
			EntityW ew = UniEntity.getEntity(ent);
			GL11.glPushMatrix();
			GL11.glTranslated(ent.posX - cx, ent.posY - cy, ent.posZ - cz);
			if(deco.decos.size() == 0){
				rencube();
			}
			else{
				if(Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof DecorationItem){
					rencube();
				}
				RenderCache cache = ent.getCapability(Capabilities.RENDERCACHE, null);
				for(DecorationData data : deco.decos){
					if(data.getType().getModel() == null){
						DebugModels.CUBE_CYN.render(0.25f);
						RGB.glColorReset();
					}
					else{
						int i = getBrightness(ent.posX, ent.posY, ent.posZ), j = i % 65536, k = i / 65536;
						OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
						GL11.glPushMatrix();
						data.offset.translate();
			            if(data.roty != 0f) GL11.glRotatef(data.roty, 0, 1, 0);
			            if(data.rotz != 0f) GL11.glRotatef(data.rotz, 0, 0, 1);
			            if(data.rotx != 0f) GL11.glRotatef(data.rotx, 1, 0, 0);
			            if(data.sclx != 1f || data.scly != 1f || data.sclz != 1f) GL11.glScalef(data.sclx, data.scly, data.sclz);
						TexUtil.bindTexture(data.getTexture().getTexture());
						data.getType().getModel().render(RENDERDATA.set(data, ew).rc(cache));
						GL11.glPopMatrix();
					}
				}
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

	private static void rencube(){
		GL11.glTranslatef(0, 0.25f, 0);
		DebugModels.CUBE_CYN.render(0.5f);
		GL11.glTranslatef(0, -0.25f, 0);
		RGB.glColorReset();
	}

	//@Deprecated
	public static int getBrightness(double x, double y, double z){
		BlockPos.MutableBlockPos mutblk = new BlockPos.MutableBlockPos(MathHelper.floor(x), 0, MathHelper.floor(z));
		if(Minecraft.getMinecraft().world.isBlockLoaded(mutblk)){
			mutblk.setY(MathHelper.floor(y));
			return Minecraft.getMinecraft().world.getCombinedLight(mutblk, 0);
		}
		return 0;
	}

}
