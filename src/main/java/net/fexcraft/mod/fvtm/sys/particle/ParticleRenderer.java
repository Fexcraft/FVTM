package net.fexcraft.mod.fvtm.sys.particle;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.sys.uni.EntitySystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.minecraft.world.World;

public class ParticleRenderer {

	public static void renderParticles(World world, double cx, double cy, double cz, float ticks){
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-cx, -cy, -cz);
        EntitySystem sys = SystemManager.get(Systems.ENTITY, world);
        for(ParticleEntity part : sys.particles) part.render(ticks);
		GL11.glPopMatrix();
	}

}
