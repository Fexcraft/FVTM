package net.fexcraft.mod.fvtm.sys.uni;

import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.GRAVITY;

import java.util.ArrayList;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Axle {

	public final ArrayList<WheelTireData> wheels = new ArrayList<>();
	public final int id;
	public boolean powered;
	public boolean steering;
	public double weight_ratio;
	public double weight_on;
	public double yaw_speed;
	public double radius;
	public V3D pos;
	
	public Axle(int id, V3D pos){
		this.id = id;
		this.pos = pos;
	}

	public void initCenter(){
		wheels.forEach(wtd -> {
			pos = pos.add(wtd.pos.x, 0, 0);
			radius += wtd.radius;
			if(wtd.slot.steering) steering = true;
		});
		pos = new V3D(pos.x / wheels.size(), pos.y, pos.z);
		radius /= wheels.size();
	}

	public void calc(double mass, double acc, double height, double base, double yaw){
		double ahb = 0.2 * acc * height / base;
		weight_on = mass * (weight_ratio * GRAVITY + (pos.z < 0 ? -ahb : ahb));
		yaw_speed = -pos.z * yaw * 0.05;
	}

	public double getGrip(VehicleInstance vi){
		double grip = 0;
		for(WheelTireData wheel : wheels){
			double gr = wheel.function.getGripFor(null, vi.entity.getWorld().isRainingAt(vi.wheels.get(wheel.id).pos()));
			if(wheel.slot.braking && vi.pbrake) gr *= wheel.function.brake_grip;
			grip += gr;
		}
		return grip / wheels.size();
	}

	public double getFric(VehicleInstance vi, double slip, double grip){
		double stif = 0;
		for(WheelTireData wheel : wheels){
			stif += wheel.function.getCornerStiffnessFor(null, wheel.slot.steering);
		}
		return Static.clamp(-(stif / wheels.size()) * slip, -grip, grip) * weight_on;
	}
}
