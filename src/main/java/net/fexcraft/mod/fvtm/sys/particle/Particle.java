package net.fexcraft.mod.fvtm.sys.particle;

import static net.fexcraft.lib.common.Static.sixteenth;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

public class Particle {
	
	public ParticleType type;
	public int persistence, frequency;
	public Vec3f dir, speed;
	public RGB color = RGB.GREEN, end_color;
	public float scale = sixteenth, scale_end;
	public final String id;
	//
	protected ModelRendererTurbo model;
	public static ModelRendererTurbo testmodel = new ModelRendererTurbo(null, 0, 0, 0, 0).addBox(-.5f, -.5f, -.5f, 1, 1, 1);
	public static Particle TEST0 = new Particle("test0").setTiming(500, 5).setDirection(new Vec3f(0, 1, 0)).setSpeed(new Vec3f(0, 0.05f, 0)).setModel(testmodel).setScale(sixteenth, 0.5f).setColor(RGB.RED, RGB.WHITE);
	public static Particle TEST1 = new Particle("test1").setTiming(500, 5).setDirection(new Vec3f(0, 1, 0)).setSpeed(new Vec3f(0, 0.05f, 0)).setModel(testmodel).setScale(sixteenth, 0.5f).setColor(RGB.GREEN, RGB.WHITE);
	public static Particle TEST2 = new Particle("test2").setTiming(500, 5).setDirection(new Vec3f(0, 1, 0)).setSpeed(new Vec3f(0, 0.05f, 0)).setModel(testmodel).setScale(sixteenth, 0.5f).setColor(RGB.BLUE, RGB.WHITE);
	public static Particle TEST3 = new Particle("test3").setTiming(500, 5).setDirection(new Vec3f(0, 1, 0)).setSpeed(new Vec3f(0, 0.05f, 0)).setModel(testmodel).setScale(sixteenth, 0.5f).setColor(RGB.BLACK, RGB.WHITE);
	public static Particle[] TEST = { TEST0, TEST1, TEST2, TEST3 };
	
	public Particle(String id){
		this(id, ParticleType.CUBOID);
	}
	
	public Particle(String id, ParticleType type){
		this.type = type;
		this.id = id;
	}
	
	public Particle setTiming(int persistence, int frequency){
		this.persistence = persistence;
		this.frequency = frequency;
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
	
	public Particle setColor(RGB color, RGB end){
		this.color = color;
		this.end_color = end;
		return this;
	}
	
	public Particle setScale(float scale, float end){
		return setScale(scale, end, true);
	}
	
	public Particle setScale(float _scale, float end, boolean sth){
		this.scale = _scale;
		this.scale_end = end;
		if(!sth){
			scale *= sixteenth;
			scale_end *= sixteenth;
		}
		return this;
	}

}
