package net.fexcraft.mod.fvtm.sys.particle;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.render.RailRenderer;
import net.fexcraft.mod.fvtm.sys.uni.EntitySystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ParticleRenderer {
	
	private static final ArrayList<ParticleEntity> ents = new ArrayList<>();

	public static void renderParticles(World world, double cx, double cy, double cz, float ticks){
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-cx, -cy, -cz);
        Minecraft.getMinecraft().renderEngine.bindTexture(RailRenderer.WOOLTEX);
        EntitySystem sys = SystemManager.get(Systems.ENTITY, world);
        ents.addAll(sys.particles);
        for(ParticleEntity part : ents) part.render(ticks);
		GL11.glPopMatrix();
	}

}
