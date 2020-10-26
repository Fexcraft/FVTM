package net.fexcraft.mod.fvtm.sys.uni12;

import java.util.ArrayList;
import java.util.TreeMap;

import net.minecraft.util.math.Vec3d;

public class Axle {
	
	public final int id;
	public Vec3d pos;
	public final ArrayList<String> wheels = new ArrayList<>();
	
	public Axle(int id, Vec3d pos){
		this.id = id;
		this.pos = pos;
	}

	public void initCenter(TreeMap<String, Vec3d> map){
		wheels.forEach(str -> pos = pos.add(0, 0, map.get(str).z));
		pos = new Vec3d(pos.x, pos.y, pos.z / wheels.size());
	}

}
