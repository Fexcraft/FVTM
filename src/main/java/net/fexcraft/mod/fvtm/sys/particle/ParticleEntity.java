package net.fexcraft.mod.fvtm.sys.particle;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
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
		temp.x = pos.x;//prev.x + (pos.x - prev.x) * ticks;
		temp.y = pos.y;//prev.y + (pos.y - prev.y) * ticks;
		temp.z = pos.z;//prev.z + (pos.z - prev.z) * ticks;
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
		float x = (Static.random.nextFloat() - 0.5f) / 50f, z = (Static.random.nextFloat() - 0.5f) / 50f;
		pos.x = prev.x + dir.x * speed.x + x;
		pos.y = prev.y + dir.y * speed.y;
		pos.z = prev.z + dir.z * speed.z + z;
		percent = passed / (float)particle.persistence;
		if(particle.scale_end > 0){
			scale = particle.scale + (particle.scale_end - particle.scale) * percent;
		}
		if(particle.end_color != null){
			color.packed = mix(particle.color, particle.end_color, percent);
		}
		passed++;
	}
	
	public int mix(RGB base, RGB mix, float percent){
		float[] fl = base.toFloatArray();
		float[] f1 = mix.toFloatArray();
		int r = (int)((fl[0] + (f1[0] - fl[0]) * percent) * 256);
		int g = (int)((fl[1] + (f1[1] - fl[1]) * percent) * 256);
		int b = (int)((fl[2] + (f1[2] - fl[2]) * percent) * 256);
		r = r > 255 ? 255 : r < 0 ? 0 : r;
		g = g > 255 ? 255 : g < 0 ? 0 : g;
		b = b > 255 ? 255 : b < 0 ? 0 : b;
		return (65536 * r) + (256 * g) + b;
	}

	public boolean expired(){
		return passed >= particle.persistence;
	}

}
