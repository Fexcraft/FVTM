package net.fexcraft.mod.fvtm.sys.particle;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

public class Particle {
	
	public ParticleType type;
	public int persistence;
	public Vec3f dir, speed;
	public final String id;
	//
	protected ModelRendererTurbo model;
	public static ModelRendererTurbo testmodel = new ModelRendererTurbo(null).addBox(-.5f, -.5f, -.5f, 1, 1, 1).setTextured(false);
	public static Particle TEST = new Particle("test").setTimeout(20).setDirection(new Vec3f(0, 1, 0)).setSpeed(new Vec3f(0, 0.01f, 0)).setModel(testmodel);
	
	public Particle(String id){
		this(id, ParticleType.CUBOID);
	}
	
	public Particle(String id, ParticleType type){
		this.type = type;
		this.id = id;
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
	
	public Particle setModel(ModelRendererTurbo model){
		this.model = model;
		return this;
	}

}
