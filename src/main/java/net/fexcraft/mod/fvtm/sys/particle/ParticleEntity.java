package net.fexcraft.mod.fvtm.sys.particle;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;

public class ParticleEntity {
	
	private Particle particle;
	protected Vec3f pos, prev, temp;
	protected Vec3f dir, speed;
	protected float percent, scale;
	public RGB color;
	public int passed;
	
	public ParticleEntity(Particle part, Vec3f pos){
		particle = part;
		this.pos = pos;
		prev = new Vec3f(pos);
		temp = new Vec3f();
		dir = particle.dir;
		speed = particle.speed;
		percent = 0;
		scale = particle.scale;
		color = new RGB(particle.color);
	}
	
	public void setDirSpeed(Vec3f dir, Vec3f speed){
		this.dir = dir;
		this.speed = speed;
	}
	
	public void render(float ticks){
		temp.x = prev.x + (pos.x - prev.x) * ticks;
		temp.y = prev.y + (pos.y - prev.y) * ticks;
		temp.z = prev.z + (pos.z - prev.z) * ticks;
		GL11.glPushMatrix();
		GL11.glTranslatef(temp.x, temp.y, temp.z);
		color.glColorApply();
		GL11.glScalef(scale, scale, scale);
		particle.model.render(1f);
		RGB.glColorReset();
		GL11.glPopMatrix();
	}

	public void update(){
		prev = pos;
		pos = new Vec3f();
		pos.x = prev.x += dir.x * speed.x;
		pos.y = prev.y += dir.y * speed.y;
		pos.z = prev.z += dir.z * speed.z;
		passed++;
	}

	public boolean expired(){
		return passed >= particle.persistence;
	}

}
