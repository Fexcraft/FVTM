package net.fexcraft.mod.fvtm.data;

import java.util.TreeMap;
import java.util.UUID;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.uni.Pos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Seat {

	public float x, y, z;
	public boolean driver, sitting;
	public String name;
	public float minyaw, maxyaw, defyaw;
	public float minpitch, maxpitch, defpitch;
	public String swivel_point;
	public boolean nofirst, nothird;
	public boolean relative;
	public TreeMap<String, Boolean> filter = null;
	public Float scale;

	public Seat(JsonMap map){
		x = map.getFloat("x", 0f);
		y = map.getFloat("y", 0f);
		z = map.getFloat("z", 0f);
		driver = map.getBoolean("driver", false);
		name = map.has("name") ? map.get("name").string_value() : UUID.randomUUID().toString().substring(0, 8);
		minyaw = map.getFloat("min_yaw", -90f);
		maxyaw = map.getFloat("max_yaw", 90f);
		minpitch = map.getFloat("min_pitch", -80f);
		maxpitch = map.getFloat("max_pitch", 80f);
		sitting = map.getBoolean("sitting", true);
		swivel_point = map.getString("swivel_point", "vehicle");
		nofirst = map.getBoolean("no_first_person", false);
		nothird = map.getBoolean("no_third_person", false);
		if(nofirst && nothird) nothird = false;
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
	}

	public Seat(String name, float x, float y, float z, boolean driver, String point, boolean nof, boolean not){
		this.x = x;
		this.y = y;
		this.z = z;
		this.driver = driver;
		this.name = name;
		minyaw = -90;
		maxyaw = 90;
		minpitch = -80;
		maxpitch = 80;
		sitting = true;
		swivel_point = point;
		nofirst = nof;
		nothird = not;
	}

	public Seat(String name, float x, float y, float z, boolean driver, boolean sitting, String point, boolean nof, boolean not){
		this(name, x, y, z, driver, point, nof, not);
		this.sitting = sitting;
	}

	public Seat(String name, float x, float y, float z, boolean driver, boolean sitting, String point, boolean nof, boolean not, boolean relative){
		this(name, x, y, z, driver, sitting, point, nof, not);
		this.relative = relative;
	}

	public Seat(String name, float x, float y, float z, boolean driver, boolean sitting, String point, boolean nof, boolean not, boolean relative, float dy, float dp){
		this(name, x, y, z, driver, sitting, point, nof, not, relative);
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

	public Vec3f copyPos(){
		return new Vec3f(x, y, z);
	}

	public Vec3d toVec3d(){
		return new Vec3d(x, y, z);
	}

	public String getName(){
		return name;
	}

	@Override
	public String toString(){
		return String.format("Seat@[(%s, %s, %s), %s, %s-driver, %s-%sy, %s-%sp, %s-sit, %s-nof, %s-not, %s-scl]", x, y, z, name, driver, minyaw, maxyaw, minpitch, maxpitch, sitting, nofirst, nothird, scale);
	}

	public int getViewValue(int current, boolean additive){
		if(!additive){
			if(nofirst) return 1;
			if(nothird) return 0;
			return current;
		}
		if(nofirst) return current > 1 ? 1 : 2;
		else if(nothird) return 0;
		else return (current + 1) % 3;
	}

	public Seat copy(Pos partpos){
		if(partpos == null || !relative) return this;
		float x = this.x + partpos.to16FloatX();
		float y = this.y - partpos.to16FloatY();
		float z = this.z - partpos.to16FloatZ();
		return new Seat(name, x, y, z, driver, sitting, swivel_point, nofirst, nothird, relative, defyaw, defpitch);
	}
	
	public boolean allow(Entity ent){
		if(filter == null){
			return driver ? ent instanceof EntityPlayer : true;
		}
		Boolean bool = null;
		if(ent instanceof EntityPlayer && (bool = filter.get("players")) != null) return bool;
		EntityEntry entry = EntityRegistry.getEntry(ent.getClass());
		if(entry == null) return false;
		bool = filter.get(entry.getRegistryName().toString());
		if(bool != null) return bool;
		if(ent instanceof EntityAnimal && (bool = filter.get("animals")) != null) return bool;
		if(ent instanceof EntityMob    && (bool = filter.get("hostile")) != null) return bool;
		return false;
	}

}
