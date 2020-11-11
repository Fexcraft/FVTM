package net.fexcraft.mod.fvtm.sys.uni12;

import java.util.ArrayList;

import net.minecraft.util.math.Vec3d;

public class Axle {

	public final ArrayList<WTD> wheels = new ArrayList<>();
	public final int id;
	public double weight_ratio;
	public double weight_on;
	public double yaw_speed;
	public Vec3d pos;
	
	public Axle(int id, Vec3d pos){
		this.id = id;
		this.pos = pos;
	}

	public void initCenter(){
		wheels.forEach(wtd -> pos = pos.add(0, 0, wtd.pos.z));
		pos = new Vec3d(pos.x, pos.y, pos.z / wheels.size());
	}

	public void calc(double mass, double acc, double height, double base, double yaw){
		double ahb = 0.2 * acc * height / base;
		weight_on = mass * (weight_ratio * ULandVehicle.GRAVITY + (pos.x > 0 ? -ahb : ahb));
		yaw_speed = pos.x * yaw;
	}

}
