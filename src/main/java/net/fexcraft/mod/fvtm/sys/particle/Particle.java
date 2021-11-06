package net.fexcraft.mod.fvtm.sys.particle;

import static net.fexcraft.lib.common.Static.sixteenth;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.util.Resources;

public class Particle {
	
	public ParticleType type;
	public int persistence, frequency;
	public Vec3f dir;
	public RGB color = RGB.GREEN, color_to;
	public float scale = sixteenth, scale_to, speed;
	public final String id;
	public String next;
	//
	protected ModelRendererTurbo model;
	public static ModelRendererTurbo cubemodel = new ModelRendererTurbo(null, 0, 0, 0, 0).addBox(-.5f, -.5f, -.5f, 1, 1, 1);
	public static ModelRendererTurbo spheremodel = new ModelRendererTurbo(null, 0, 0, 0, 0).addSphere(-.5f, -.5f, -.5f, 1, 8, 7, 1, 1);
	
	public Particle(String id){
		this(id, ParticleType.CUBOID);
	}
	
	public Particle(String id, ParticleType type){
		this.type = type;
		this.id = id;
		Resources.PARTICLES.put(id, this);
	}
	
	public Particle(String id, JsonMap map){
		this(id, ParticleType.valueOf(map.getString("type", ParticleType.CUBOID.name()).toUpperCase()));
		setTiming(map.getInteger("ticks", 200), map.getInteger("frequency", 10));
		dir = new Vec3f();
		if(map.has("direction")){
			JsonArray array = map.getArray("direction");
			dir.x = array.get(0).float_value();
			dir.y = array.get(1).float_value();
			dir.z = array.get(2).float_value();
		}
		speed = map.getFloat("speed", 0.01f);
		setScale(map.getFloat("scale", sixteenth), map.has("scale_to") ? map.getFloat("scale_to", 0.5f) : 0);
		if(map.has("color")) color = new RGB(map.getString("color", "#ffffff"));
		if(map.has("color_to")) color_to = new RGB(map.getString("color_to", "#000000"));
		switch(type){
			case CUBOID: model = cubemodel;
				break;
			case FLAT:
				break;
			case MODEL:
				break;
			case SPHERE: model = spheremodel;
				break;
			default:
				break;
		}
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
	
	public Particle setSpeed(float value){
		this.speed = value;
		return this;
	}
	
	public Particle setModel(ModelRendererTurbo model){
		this.model = model;
		return this;
	}
	
	public Particle setColor(RGB color, RGB end){
		this.color = color;
		this.color_to = end;
		return this;
	}
	
	public Particle setScale(float scale, float end){
		return setScale(scale, end, true);
	}
	
	public Particle setScale(float _scale, float end, boolean sth){
		this.scale = _scale;
		this.scale_to = end;
		if(!sth){
			scale *= sixteenth;
			scale_to *= sixteenth;
		}
		return this;
	}
	
	public Particle setNext(String id){
		next = id;
		return this;
	}

}
