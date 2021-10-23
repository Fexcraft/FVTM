package net.fexcraft.mod.fvtm.sys.particle;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.Vec3f;

public class ParticleEntity {
	
	private Particle particle;
	protected Vec3f pos, prev, temp;
	public int passed;
	
	public ParticleEntity(Particle part, Vec3f pos){
		particle = part;
		this.pos = pos;
		prev = new Vec3f(pos);
		temp = new Vec3f();
	}
	
	public void render(float ticks){
		temp.x = prev.x + (pos.x - prev.x) * ticks;
		temp.y = prev.y + (pos.y - prev.y) * ticks;
		temp.z = prev.z + (pos.z - prev.z) * ticks;
		GL11.glTranslatef(temp.x, temp.y, temp.z);
		particle.model.render();
		GL11.glTranslatef(-temp.x, -temp.y, -temp.z);
	}

	public void update(){
		prev = pos;
		pos = new Vec3f();
		pos.x = prev.x += particle.dir.x * particle.speed.x;
		pos.y = prev.y += particle.dir.y * particle.speed.y;
		pos.z = prev.z += particle.dir.z * particle.speed.z;
		passed++;
	}

}
