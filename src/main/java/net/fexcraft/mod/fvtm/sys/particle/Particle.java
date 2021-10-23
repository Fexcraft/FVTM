package net.fexcraft.mod.fvtm.sys.particle;

import net.fexcraft.lib.common.math.Vec3f;

public class Particle {
	
	public ParticleType type;
	public int persistence, passed;
	public Vec3f dir, speed;
	
	public Particle(){
		this(ParticleType.CUBOID);
	}
	
	public Particle(ParticleType type){
		this.type = type;
	}
	
	public Particle setTimeout(int persistence){
		this.persistence = persistence;
		return this;
	}
	
	public Particle setDirection(Vec3f vector){
		this.dir = vector;
		return this;
	}
	
	public Particle setSpeed(Vec3f vector){
		this.speed = vector;
		return this;
	}

}
