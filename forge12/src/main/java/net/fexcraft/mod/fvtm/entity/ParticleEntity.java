package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import org.lwjgl.opengl.GL11;

public class ParticleEntity {
	
	public final Particle particle;
	public V3D pos, prev, temp, dir;
	public double percent, scale, speed;
	public RGB color;
	public int passed;
	
	public ParticleEntity(Particle part, V3D pos, V3D dir, Double speed){
		particle = part;
		this.pos = pos;
		prev = new V3D(pos);
		temp = new V3D();
		this.dir = dir == null ? part.dir : dir;
		this.speed = speed == null ? part.speed : speed;
		percent = 0;
		scale = particle.scale;
		color = new RGB(particle.color);
		if(particle.alpha == -1) color.alpha = Static.random.nextFloat();
	}
	
	public void setDirSpeed(V3D dir, float speed){
		this.dir = dir;
		this.speed = speed;
	}
	
	public void render(float ticks, double cx, double cy, double cz){
		temp.x = pos.x;//prev.x + (pos.x - prev.x) * ticks;
		temp.y = pos.y;//prev.y + (pos.y - prev.y) * ticks;
		temp.z = pos.z;//prev.z + (pos.z - prev.z) * ticks;
		GL11.glPushMatrix();
		GL11.glTranslated(temp.x - cx, temp.y - cy, temp.z - cz);
		color.glColorApply();
		GL11.glScaled(scale, scale, scale);
		particle.model.render();
		RGB.glColorReset();
		GL11.glPopMatrix();
	}

	public void update(){
		prev = pos;
		pos = new V3D();
		double x = (Static.random.nextDouble() - 0.5) / 50d, z = (Static.random.nextDouble() - 0.5) / 50d;
		pos.x = prev.x + dir.x * speed + x;
		pos.y = prev.y + dir.y * speed;
		pos.z = prev.z + dir.z * speed + z;
		percent = passed / particle.persistence;
		if(particle.scale_to > 0){
			scale = particle.scale + (particle.scale_to - particle.scale) * percent;
		}
		if(particle.color_to != null){
			color.packed = mix(particle.color, particle.color_to, (float)percent);
		}
		if(particle.alpha >= 0 && particle.alpha_to != particle.alpha){
			color.alpha = (float)(particle.alpha + (particle.alpha_to - particle.alpha) * percent);
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
