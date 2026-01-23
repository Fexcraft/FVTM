package net.fexcraft.mod.fvtm.sys.particle;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.lib.frl.gen.Generator.Values.*;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fvtm.FvtmRegistry;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Particle {
	
	public ParticleType type;
	public int persistence, frequency;
	public V3D dir;
	public RGB color = RGB.GREEN, color_to;
	public float scale = sixteenth, scale_to, speed, alpha = 1, alpha_to;
	public final String id;
	public String next;
	//
	public Polyhedron model;
	public static Polyhedron cubemodel = new Polyhedron();
	static{
		cubemodel.newGen()
				.set(OFF_X, -.5f)
				.set(OFF_Y, -.5f)
				.set(OFF_Z, -.5f)
				.set(WIDTH, 1)
				.set(HEIGHT, 1)
				.set(DEPTH, 1)
				.make();
	}

	
	public Particle(String id){
		this(id, ParticleType.CUBOID);
	}
	
	public Particle(String id, ParticleType type){
		this.type = type;
		this.id = id;
		FvtmRegistry.PARTICLES.put(id, this);
	}
	
	public Particle(String id, JsonMap map){
		this(id, ParticleType.valueOf(map.getString("type", ParticleType.CUBOID.name()).toUpperCase()));
		setTiming(map.getInteger("ticks", 200), map.getInteger("frequency", 10));
		dir = new V3D();
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
		next = map.getString("next", null);
		switch(type){
			case CUBOID: model = cubemodel;
				break;
			case FLAT:
				break;
			case MODEL:
				break;
			case SPHERE:
				break;
			default:
				break;
		}
		if(map.has("alpha")) alpha = map.getFloat("alpha", alpha);
		if(map.has("alpha_to")) alpha_to = map.getFloat("alpha_to", 0);
	}
	
	public Particle setTiming(int persistence, int frequency){
		this.persistence = persistence;
		this.frequency = frequency;
		return this;
	}
	
	public Particle setDirection(V3D vector){
		this.dir = vector;
		return this;
	}
	
	public Particle setSpeed(float value){
		this.speed = value;
		return this;
	}
	
	public Particle setModel(Polyhedron model){
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
	
	public Particle setTransparency(float trans, float trans_to){
		this.alpha = trans;
		this.alpha_to = trans_to;
		return this;
	}
	
	public Particle setNext(String id){
		next = id;
		return this;
	}

}
