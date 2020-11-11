package net.fexcraft.mod.fvtm.sys.uni12;

import net.fexcraft.lib.common.Static;
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
		
		float wang = Static.rad45;
		float wrad = 0.4f;
		float slipr = (wang * wrad - vel.lengthVector()) / vel.normalize().lengthVector();//??
		
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
	
	public static void proe0(){
		/*double mass = vehicle.getAttribute("weight").getFloatValue();
		for(Axle axle : axles) axle.calc(mass, acx, cg_height, wheelbase, 1f);
		//
		Vec3d atmc = new Vec3d(0, 0, 0);
        boolean canThrustCreatively = !Config.VEHICLES_NEED_FUEL || isDriverInCreative();
        EngineFunction engine = vehicle.hasPart("engine") ? vehicle.getPart("engine").getFunction("fvtm:engine") : null;
        boolean consumed = processConsumption(engine);
        
        float brkf = vehicle.getAttributeFloat("brake_force", 10000f);
    	double brake = Math.min((braking ? brkf : 0) + (pbrake ? vehicle.getAttributeFloat("parking_brake_force", 5000f) : 0), brkf);
    	double throttle = this.throttle * engineforce;*/
    	/*acx = 0;
		for(WheelEntity wheel : wheels){
            if(wheel == null) continue;
            onGround = wheel.onGround = true;
            wheel.rotationYaw = (float)rotpoint.getAxes().getRadianYaw();
            Axle axle = getAxle(wheel.getIndex());
            if(axle == null){
            	Print.debug("noax" + wheel.wheelid);
            }
            wheel.motionX *= 0.9F;
            wheel.motionY *= 0.9F;
            wheel.motionZ *= 0.9F;
            wheel.motionY -= 0.98F / TICKR;

            double cs = Math.cos(wheel.rotationYaw);
            double sn = Math.sin(wheel.rotationYaw);
            double motx = cs * wheel.motionX + sn * wheel.motionZ;
            double moty = cs * wheel.motionZ - sn * wheel.motionX;
            
            double steer = wheel.slot.steering() ? Math.signum(motx) * wheelsYaw : 0;
            double slip_angle = Math.atan2(moty + axle.yaw_speed, Math.abs(motx)) - steer;
            double grip = tiregrip * (wheel.slot.braking() && pbrake ? brakegrip : 1);//TODO TIRES
            double frict = Static.clamp((axle.pos.x > 0 ? 5 : 5.2f) * slip_angle, -grip, grip) * axle.weight_on;//TODO TIRES
            
        	double tracx = throttle - brake * Math.signum(motx);
        	double tracy = 0;
        	
        	double dragx = -rr * motx - ar * motx * Math.abs(motx);
        	double dragy = -rr * moty - ar * moty * Math.abs(moty);
        	
        	double totalx = dragx + tracx;
        	double totaly = dragy + tracy + (wheel.slot.steering() ? Math.cos(wheelsYaw) * frict : 0) + frict;
        	
        	acx += totalx / mass;
        	double acy = totaly / mass;

        	wheel.motionX += (cs * acx - sn * acy) * TICKA;
        	wheel.motionZ += (sn * acx + cs * acy) * TICKA;
        	VehicleSteeringOverlay.STRS.add(steer + " " + totalx + " " + totaly);

            wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
            //pull wheel back to car
            Vec3d targetpos = rotpoint.getAxes().getRelativeVector(vehicle.getWheelPositions().get(WHEELINDEX[wheel.wheelid]));
            Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
            Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(lata.wheel_spring_strength);
            if(despos.lengthSquared() > 0.001F){
                wheel.move(MoverType.SELF, despos.x, despos.y, despos.z);
                despos = despos.scale(0.5F); atmc = atmc.subtract(despos);
            }
            if(wheel.wheelid == 0){
            	tf = (frict + tracy) * axle.pos.x;
            }
            else if(wheel.wheelid == 3){
            	tr = (frict) * -axle.pos.x;
            }
		}
		acx /= wheels.length;
		yaw_rate += ((tf - tr) / mass) * TICKA;
		while(yaw_rate > Static.PI) yaw_rate -= Static.PI;
		while(yaw_rate < -Static.PI) yaw_rate += Static.PI;
		VehicleSteeringOverlay.STRS.add(yaw_rate + " " + Math.toDegrees(yaw_rate));
		//rotpoint.getAxes().rotateYawR((float)(yaw_rate * TICKA));
		//
	    move(MoverType.SELF, atmc.x, atmc.y, atmc.z);*/
	}

}
