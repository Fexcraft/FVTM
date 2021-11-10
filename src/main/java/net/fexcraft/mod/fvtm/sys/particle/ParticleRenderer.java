package net.fexcraft.mod.fvtm.sys.particle;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.render.RailRenderer;
import net.fexcraft.mod.fvtm.sys.uni.EntitySystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.world.World;

public class ParticleRenderer {
	
	private static final ArrayList<ParticleEntity> ents = new ArrayList<>();

	public static void renderParticles(World world, double cx, double cy, double cz, float ticks){
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-cx, -cy, -cz);
        Minecraft.getMinecraft().renderEngine.bindTexture(Resources.WHITE_TEXTURE);
        EntitySystem sys = SystemManager.get(Systems.ENTITY, world);
        ents.addAll(sys.particles);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        for(ParticleEntity part : ents){
        	if(part == null || part.pos == null) return;
	        int z = RailRenderer.getBrightness(part.pos), x = z % 65536, y = z / 65536;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)x / 1.0F, (float)y / 1.0F);
            part.render(ticks);
        }
        GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		ents.clear();
	}

}
