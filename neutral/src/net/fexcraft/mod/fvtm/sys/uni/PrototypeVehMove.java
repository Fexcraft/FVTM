package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PrototypeVehMove extends ClassicVehMove {

	public ArrayList<Axle> axles = new ArrayList<>();
	public boolean overloaded;
	public Axle ax_fron;
	public Axle ax_rear;
	public double wheelbase;
	public double cg_height;
	public double appmass = 0;
	public double force;
	public double accel = 0f;
	public double angor = 0f;
	public double abvel = 0f;
	public double torq;
	public int rpm;
	public int orpm;

	public PrototypeVehMove(VehicleInstance vi){
		super(vi);
	}

	@Override
	public void setupAxles(){
		axles.clear();
		for(WheelTireData wheel : inst.wheeldata.values()){
			Axle axle = null;
			for(Axle ax : axles){
				if(ax.pos.z == wheel.pos.z && ax.pos.y == wheel.pos.y){
					axle = ax;
					break;
				}
			}
			if(axle == null){
				axle = new Axle(axles.size(), new V3D(0, wheel.pos.y, wheel.pos.z));
				axles.add(axle);
			}
			axle.wheels.add(wheel);
			wheel.axle = axle;
		}
		axles.forEach(Axle::initCenter);
		double amin = 16, amax = -16;
		for(Axle axle : axles){
			if(axle.pos.z < amin){
				amin = axle.pos.z;
				ax_fron = axle;
			}
			if(axle.pos.z > amax){
				amax = axle.pos.z;
				ax_rear = axle;
			}
		}
		wheelbase = Math.abs(amin) + Math.abs(amax);
		cg_height = 0;
		for(Axle axle : axles){
			axle.weight_ratio = Math.abs(axle.pos.z) / wheelbase;
			cg_height += axle.pos.y;
		}
		cg_height /= axles.size();
	}

	@Override
	public void updateAttrs(){
		inst.data.getAttribute("rpm").set(rpm / 100 * 100);
	}

	@Override
	public void move(boolean cons){
		if(inst.front == null) remass();
		move0(cons);
		if(inst.rear != null) inst.rear.align();
	}

	private void move0(boolean nocons){
		if(inst.data.getType().isTrailer()) return;
		double mass = appmass;
		double rr = inst.data.getAttributeFloat("roll_resistance", 8f);
		double ar = inst.data.getAttributeFloat("air_resistance", 2.5f);
		double axpwdiv = 0;
		for(Axle axle : axles){
			axle.calc(mass, accel, cg_height, wheelbase, angor);
			axle.powered = axle.wheels.get(0).slot.powered(inst.data);
			axpwdiv++;
		}
		if(axpwdiv > 0) axpwdiv = 1d / axpwdiv;
		overloaded = appmass - inst.data.getAttributeFloat("weight", 1000f) > inst.data.getAttributeFloat("max_towing", 3500f);
		boolean cons = nocons || (inst.engine != null && inst.consumeFuel());
		double brkf = inst.data.getAttributeFloat("brake_force", 10000f) * inst.brake;
		double brake = Math.min(brkf + (inst.pbrake ? inst.data.getAttributeFloat("parking_brake_force", 5000f) : 0), brkf) * 0.25;
		int gear = inst.data.getAttributeInteger("gear", 0);
		float diff = inst.data.getAttributeFloat("differential_ratio", 3.5f);
		double tr = inst.transmission == null ? 0 : inst.transmission.getRatio(gear);
		if(inst.engine != null && inst.transmission != null){
			orpm = rpm;
			rpm = (int)((inst.speed * axles.get(0).radius * 72) * tr * diff * 60 / Static.PI2);
			if(rpm < 0) rpm = -rpm;
			if(rpm < inst.engine.minRPM()) rpm = inst.engine.minRPM();
			if(rpm > inst.engine.maxRPM()) rpm = inst.engine.maxRPM();
		}
		force = 0;
		if(!overloaded && inst.engine != null && inst.transmission != null){
			torq = inst.engine.getTorque(rpm);
			force = torq * /*tr * */diff * inst.transmission.getEfficiency();
			if(inst.transmission.isAutomatic() && inst.autogear_timer <= 0){
				int ngear = inst.transmission.processAutoShift(gear, rpm, inst.engine.maxRPM(), inst.throttle);
				if(ngear != gear){
					inst.data.getAttribute("gear").set(ngear);
					inst.updateAttr("gear");
				}
				inst.autogear_timer += inst.transmission.getShiftSpeed();
			}
			force = force * inst.throttle * axpwdiv;
		}
		double s = -Math.cos(-inst.pivot().yaw());
		double c = -Math.sin(-inst.pivot().yaw());
		double steer_rad = -Math.toRadians(inst.steer_yaw);
		inst.entity.setOnGround(true);
		accel = 0;
		//
		double mov_for = c * inst.motion.x + s * inst.motion.z;
		double mov_sig = Math.signum(mov_for);
		double mov_sid = c * inst.motion.z - s * inst.motion.x;
		double steer_sig = mov_sig * steer_rad;
		double slipf = Math.atan2(mov_sid + ax_fron.yaw_speed, Math.abs(mov_for)) - (ax_fron.steering ? steer_sig : 0);
		double slipr = Math.atan2(mov_sid + ax_rear.yaw_speed, Math.abs(mov_for)) - (ax_rear.steering ? steer_sig : 0);
		double gripf = ax_fron.getGrip(inst);
		double gripr = ax_rear.getGrip(inst);
		double fricf = ax_fron.getFric(slipf, gripf);
		double fricr = ax_rear.getFric(slipr, gripr);
		double tracf = cons && ax_fron.powered ? (force / ax_fron.radius) * (tr == 0 ? 0 : 1d / tr) : 0;
		double tracr = cons && ax_rear.powered ? (force / ax_rear.radius) * (tr == 0 ? 0 : 1d / tr) : 0;
		tracf -= brake * mov_sig;
		tracr -= brake * mov_sig;
		double drag_f = -(rr * mov_for + ar * mov_for * Math.abs(mov_for));
		double drag_s = -(rr * mov_sid + ar * mov_sid * Math.abs(mov_sid));
		double res_f = ((drag_f + tracf + tracr) / mass);// * MOTION_SCALE;
		double frics = (ax_fron.steering ? Math.cos(steer_rad) * fricf : fricf) + (ax_rear.steering ? Math.cos(steer_rad) * fricr : fricr);
		double res_s = ((drag_s + frics) / mass);// * MOTION_SCALE;
		accel += res_f;
		V3D.add((c * res_f - s * res_s) * 0.05, 0, (s * res_f + c * res_s) * 0.05, inst.motion);
		abvel = inst.motion.length();
		double antor = fricf * -ax_fron.pos.z - fricr * ax_rear.pos.z;
		if(abvel < 0.05 && inst.throttle < 0.01){
			inst.motion.set(0, 0, 0);
			abvel = antor = 0;
		}
		angor = -antor / mass * 0.05;
		inst.pivot().set_yaw((float)(inst.pivot().yaw() + angor * 0.05), false);
		inst.entity.move(inst.motion);
		inst.pos = inst.entity.getPos();
		accel /= inst.wheels.size();
	}

	private void remass(){
		if(inst.rear != null){
			PrototypeVehMove trailer = inst.rear.vm();
			while(trailer.inst.rear != null) trailer = trailer.inst.rear.vm();
			PrototypeVehMove truck = trailer.inst.front.vm();
			trailer.appmass = trailer.inst.data.getAttributeFloat("weight", 1000);
			while(truck != null){
				truck.appmass = truck.inst.data.getAttributeFloat("weight", 1000);
				truck.appmass += ((PrototypeVehMove)truck.inst.rear.vm()).appmass * truck.inst.rear.data.getAttributeFloat("trailer_weight_ratio", 0.2f);
				truck = truck.inst.front.vm();
			}
		}
		else appmass = inst.data.getAttributeFloat("weight", 1000f);
	}

	@Override
	public double yaw(double dx, double dz){
		return inst.speed > 0.01 ? inst.pivot().yaw() : -Math.atan2(dx, dz);
	}

}
