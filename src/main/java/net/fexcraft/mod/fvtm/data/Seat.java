package net.fexcraft.mod.fvtm.data;

import java.util.TreeMap;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Pos;
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

	public Seat(JsonObject obj){
		Pos pos = Pos.fromJson(obj, false);
		x = pos.to16FloatX();
		y = pos.to16FloatY();
		z = pos.to16FloatZ();
		driver = JsonUtil.getIfExists(obj, "driver", false);
		name = obj.has("name") ? obj.get("name").getAsString() : UUID.randomUUID().toString().substring(0, 8);
		minyaw = JsonUtil.getIfExists(obj, "min_yaw", -90f).floatValue();
		maxyaw = JsonUtil.getIfExists(obj, "max_yaw", 90f).floatValue();
		minpitch = JsonUtil.getIfExists(obj, "min_pitch", -80f).floatValue();
		maxpitch = JsonUtil.getIfExists(obj, "max_pitch", 80f).floatValue();
		sitting = JsonUtil.getIfExists(obj, "sitting", true);
		swivel_point = JsonUtil.getIfExists(obj, "rot_point", "vehicle");
		nofirst = JsonUtil.getIfExists(obj, "no_first_person", false);
		nothird = JsonUtil.getIfExists(obj, "no_third_person", false);
		if(nofirst && nothird) nothird = false;
		relative = JsonUtil.getIfExists(obj, "relative", false);
		defyaw = JsonUtil.getIfExists(obj, "def_yaw", 0).floatValue();
		defpitch = JsonUtil.getIfExists(obj, "def_pitch", 0).floatValue();
		if(obj.has("filter")){
			filter = new TreeMap<>();
			JsonArray array = obj.get("filter").getAsJsonArray();
			for(JsonElement elm : array){
				String str = elm.getAsString();
				boolean bool = !str.startsWith("!");
				if(!bool) str = str.substring(1);
				filter.put(str, bool);
			}
		}
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
		return String.format("Seat@[(%s, %s, %s), %s, %s-driver, %s-%sy, %s-%sp, %s-sit, %s-nof, %s-not]", x, y, z, name, driver, minyaw, maxyaw, minpitch, maxpitch, sitting, nofirst, nothird);
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
