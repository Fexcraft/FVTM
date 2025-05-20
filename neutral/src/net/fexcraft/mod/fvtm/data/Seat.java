package net.fexcraft.mod.fvtm.data;

import java.util.TreeMap;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.world.EntityW;

public class Seat {

	public V3D pos;
	public V3D dis;
	public boolean driver;
	public boolean sitting;
	public String name;
	public float minyaw;
	public float maxyaw;
	public float defyaw;
	public float minpitch;
	public float maxpitch;
	public float defpitch;
	public String swivel_point;
	public boolean relative;
	public TreeMap<String, Boolean> filter = null;
	public Float scale;

	public Seat(String seatname, JsonMap map){
		pos = ContentConfigUtil.getVector(map.getArray("pos"));
		driver = map.getBoolean("driver", false);
		name = seatname;
		minyaw = map.getFloat("min_yaw", -90f);
		maxyaw = map.getFloat("max_yaw", 90f);
		minpitch = map.getFloat("min_pitch", -80f);
		maxpitch = map.getFloat("max_pitch", 80f);
		sitting = map.getBoolean("sitting", true);
		swivel_point = map.getString("swivel_point", "vehicle");
		relative = map.getBoolean("relative", false);
		defyaw = map.getFloat("def_yaw", 0f);
		defpitch = map.getFloat("def_pitch", 0f);
		if(map.has("filter")){
			filter = new TreeMap<>();
			JsonArray array = map.get("filter").asArray();
			for(JsonValue<?> elm : array.value){
				String str = elm.string_value();
				boolean bool = !str.startsWith("!");
				if(!bool) str = str.substring(1);
				filter.put(str, bool);
			}
		}
		if(map.has("scale")) scale = map.get("scale").float_value();
		dis = map.has("dismount") ? ContentConfigUtil.getVector(map.getArray("dismount")) : pos.copy();
	}

	public Seat(String name, V3D pos, boolean driver, String point){
		this.driver = driver;
		this.name = name;
		minyaw = -90;
		maxyaw = 90;
		minpitch = -80;
		maxpitch = 80;
		sitting = true;
		swivel_point = point;
	}

	public Seat(String name, V3D pos, boolean driver, boolean sitting, String point){
		this(name, pos, driver, point);
		this.sitting = sitting;
	}

	public Seat(String name, V3D pos, boolean driver, boolean sitting, String point, boolean relative){
		this(name, pos, driver, sitting, point);
		this.relative = relative;
	}

	public Seat(String name, V3D pos, boolean driver, boolean sitting, String point, boolean relative, float dy, float dp){
		this(name, pos, driver, sitting, point, relative);
		defyaw = defpitch = 0;
	}
	
	public Seat scale(Float scale){
		this.scale = scale;
		return this;
	}
	
	public float scale(){
		return scale == null ? 1f : scale;
	}

	public boolean isDriver(){
		return driver;
	}

	public String getName(){
		return name;
	}

	@Override
	public String toString(){
		return String.format("Seat@[(%s, %s, %s), %s, %s-driver, %s-%sy, %s-%sp, %s-sit, %s-scl]", pos.x, pos.y, pos.z, name, driver, minyaw, maxyaw, minpitch, maxpitch, sitting, scale);
	}

	public Seat copy(V3D partpos){
		if(partpos == null || !relative) return this;
		return new Seat(name, pos.add(partpos), driver, sitting, swivel_point, relative, defyaw, defpitch);
	}
	
	public boolean allow(EntityW ent){
		if(filter == null){
			return driver ? ent.isPlayer() : true;
		}
		Boolean bool = null;
		if(ent.isPlayer() && (bool = filter.get("players")) != null) return bool;
		bool = filter.get(ent.getRegName());
		if(bool != null) return bool;
		if(ent.isAnimal() && (bool = filter.get("animals")) != null) return bool;
		if(ent.isHostile() && (bool = filter.get("hostile")) != null) return bool;
		return false;
	}

}
