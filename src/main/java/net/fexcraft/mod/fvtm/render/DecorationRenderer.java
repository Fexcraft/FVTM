package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

public class DecorationRenderer {

	public static void renderDecorations(World world, double cx, double cy, double cz, float partialticks){
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		//GL11.glTranslated(-cx, -cy, -cz);
		TexUtil.bindTexture(FvtmRegistry.WHITE_TEXTURE);
		for(Entity ent : world.loadedEntityList){
			if(ent instanceof Decoration == false) continue;
			if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(ent.getEntityBoundingBox())) continue;
			Decoration deco = (Decoration)ent;
			GL11.glPushMatrix();
			GL11.glTranslated(ent.posX - cx, ent.posY - cy, ent.posZ - cz);
			if(deco.decos.size() == 0){
				DebugModels.TRAFFICSIGNCUBE.render(0.5f);
				RGB.glColorReset();
			}
			else{
				RenderCache cache = ent.getCapability(Capabilities.RENDERCACHE, null);
				for(DecorationData data : deco.decos){
					if(data.model == null){
						DebugModels.HOTINSTALLCUBE.render(0.25f);
						RGB.glColorReset();
					}
					else{
						int i = RailRenderer.getBrightness(ent.posX, ent.posY, ent.posZ), j = i % 65536, k = i / 65536;
						OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
						GL11.glPushMatrix();
						data.offset.translate();
			            if(data.roty != 0f) GL11.glRotatef(data.roty, 0, 1, 0);
			            if(data.rotz != 0f) GL11.glRotatef(data.rotz, 0, 0, 1);
			            if(data.rotx != 0f) GL11.glRotatef(data.rotx, 1, 0, 0);
			            if(data.sclx != 1f || data.scly != 1f || data.sclz != 1f) GL11.glScalef(data.sclx, data.scly, data.sclz);
						TexUtil.bindTexture((ResourceLocation)data.textures.get(data.seltex));
						data.model.render(RENDERDATA.set(data, ent, cache));
						GL11.glPopMatrix();
					}
				}
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

}
