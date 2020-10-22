package net.fexcraft.mod.fvtm.sys.uni12;

import net.fexcraft.lib.common.math.Vec3f;

public class Testing {
	
	private static float ticks = 1 / 20f;
	
	public static void pro0(){
		float engineforce = 2;
		Vec3f dir = new Vec3f(1, 0, 0).normalize();
		Vec3f traction = dir.scale(engineforce);
		
		float c_drag = 1f;
		Vec3f vel = new Vec3f(1, 0, 0);
		Vec3f drag = vel.scale(-c_drag).scale(vel.lengthVector());
		
		float c_rr = c_drag * 30f;
		Vec3f rr = vel.scale(-c_rr);
		
		Vec3f flong = traction.add(drag).add(rr);
		
		
		float mass = 1000f;
		Vec3f acc = flong.divide(mass);
		vel = vel.add(acc.scale(ticks));
		
		Vec3f pos = new Vec3f();
		pos = pos.add(vel.scale(ticks));
		
	}
	
	public static void pro1(boolean brake){
		Vec3f dir = new Vec3f(1, 0, 0).normalize();
		Vec3f drive = getEngineForce(dir);
		
		float c_drag = 0.45f;
		Vec3f vel = new Vec3f(1, 0, 0);
		Vec3f drag = vel.scale(-c_drag).scale(vel.lengthVector());
		
		float c_rr = c_drag * 30f;
		Vec3f rr = vel.scale(-c_rr);
		
		float c_brake = 0.8f;
		Vec3f flong = (brake ? dir.scale(-c_brake) : drive).add(drag).add(rr);
		
		
		float mass = 1000f;
		Vec3f acc = flong.divide(mass);
		vel = vel.add(acc.scale(ticks));
		
		Vec3f pos = new Vec3f();
		pos = pos.add(vel.scale(ticks));
		
		
		float gravity = 9.8f;
		float accel = mass * (gravity / 2);
		float weight = mass * gravity;
		float tyrefc = 1f;
		float fmax = tyrefc * weight;
		float cgh = 1f;
		float afd = 1f, ard = 0.5f;
		float wbase = afd + ard;
		//float waf = (afd / (afd + ard)) * weight;
		//float war = (ard / (afd + ard)) * weight;
		float waf = (afd / wbase) * weight - (cgh / wbase) * mass * accel;
		float war = (ard / wbase) * weight + (cgh / wbase) * mass * accel;
		
		
		
		
	}

	private static Vec3f getEngineForce(Vec3f dir){
		//float throttle = 0.5f;
		//float max_rpm = 4000f;
		//float curr_rpm = 2600f;
		float torque = 450f;//"getTorque(curr_rpm);"
		float r_gear = 2.6f;
		float r_diff = 3.4f;
		float tm_eff = 0.75f;
		float wheel_r = 0.4f;
		return dir.scale(torque * r_gear * r_diff * tm_eff / wheel_r);
	}

}
