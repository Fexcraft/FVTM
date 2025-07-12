package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.function.part.TireFunction;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler;

import java.util.Map;

import static net.fexcraft.mod.fvtm.util.MathUtils.valRad;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ClassicVehMove implements VehicleMovement {

	protected VehicleInstance inst;

	public ClassicVehMove(VehicleInstance vi){
		inst = vi;
	}

	public void initWheels(){
		inst.wheels.clear();
		for(Map.Entry<String, V3D> entry : inst.data.getWheelPositions().entrySet()){
			if(entry.getKey().endsWith(":tire")) continue;
			WheelTireData wheel = new WheelTireData(entry.getKey());
			wheel.pos = entry.getValue();
			PartData part = inst.data.getPart(entry.getKey());
			if(!((WheelInstallationHandler.WheelData)part.getType().getInstallHandlerData()).hasTire()){
				part = inst.data.getPart(entry.getKey()+ ":tire");
				wheel.radius = ((TireInstallationHandler.TireData)part.getType().getInstallHandlerData()).getOuterRadius();
			}
			else{
				wheel.radius += ((WheelInstallationHandler.WheelData)part.getType().getInstallHandlerData()).getRadius();
			}
			wheel.function = part.getFunction(TireFunction.class, "fvtm:tire").getTireAttr(part);
			wheel.slot = inst.data.getWheelSlots().get(entry.getKey());
			wheel.mirror = inst.data.getWheelSlots().get(entry.getKey()).mirror;
			inst.wheeldata.put(entry.getKey(), wheel);
		}
		assignWheels();
		setupAxles();
	}

	@Override
	public void move(boolean nocons){
		if(inst.data.getType().isTrailer()) return;
		inst.entity.setOnGround(true);
		inst.moveto.set(0, 0, 0);
		if(inst.type.isWaterVehicle()){
			//TODO
		}
		else{
			if(inst.throttle > -0.01 && inst.throttle < 0.01) inst.throttle = 0;
			double steer = Math.toRadians(inst.steer_yaw);
			double wyaw = valRad(inst.pivot().yaw());
			double syaw = valRad(wyaw + steer);
			double myaw = 0;
			double ryaw = 0;
			double scal = 0;
			double decr = 0;
			V3D wm;
			boolean cons = nocons || (inst.engine != null && inst.consumeFuel());
			for(UniWheel wheel : inst.wheels.values()){
				if(wheel.wtd() == null) continue;
				wm = wheel.wtd().move;
				scal = (-Math.sin(-wyaw) * wm.x + -Math.cos(-wyaw) * wm.z) * 0.05;
				wheel.prepare();
				wheel.yaw((float)ryaw);
				if(inst.engine != null && cons && inst.throttle != 0){
					scal += 0.05 * inst.throttle * (inst.throttle > 0 ? inst.spdata.max_throttle : inst.spdata.min_throttle) * inst.engine.getSphEngineSpeed();
				}
				scal *= Config.MOTION_SCALE;
				ryaw = inst.pivot().deg_yaw();
				myaw = wyaw;
				if(wheel.wtd().slot.steering){
					ryaw += inst.steer_yaw;
					myaw = syaw;
				}
				wm.x += -Math.sin(-myaw) * scal;
				wm.y = -VehicleInstance.GRAVITY_20th;
				wm.z += -Math.cos(-myaw) * scal;
				decr = 0.95;
				if(inst.brake > 0 || inst.pbrake){
					decr = inst.pbrake ? 0.8 : decr - inst.brake * 0.1;
				}
				V3D.mul(decr, 1, decr, wm);
				wheel.setMotion(wm.x, wm.y, wm.z);
				wheel.move();
			}
		}
		inst.alignToWheels();
	}

	public void assignWheels(){
		inst.w_front_l = inst.w_front_r = inst.w_rear_l = inst.w_rear_r = new WheelTireData();
		for(WheelTireData wheel : inst.wheeldata.values()){
			if(!inst.data.getType().isTrailer()){
				if(wheel.pos.x <= inst.w_front_l.pos.x && wheel.pos.z <= inst.w_front_l.pos.z){
					inst.w_front_l = wheel;
					continue;
				}
				if(wheel.pos.x >= inst.w_front_r.pos.x && wheel.pos.z <= inst.w_front_r.pos.z){
					inst.w_front_r = wheel;
					continue;
				}
			}
			if(wheel.pos.x <= inst.w_rear_l.pos.x && wheel.pos.z >= inst.w_rear_l.pos.z){
				inst.w_rear_l = wheel;
				continue;
			}
			if(wheel.pos.x >= inst.w_rear_r.pos.x && wheel.pos.z >= inst.w_rear_r.pos.z){
				inst.w_rear_r = wheel;
			}
		}
		if(inst.data.getType().isTrailer()){
			inst.w_front_l = new WheelTireData("_" + inst.w_rear_l.id);
			inst.w_front_l.asTrailerFront(inst.w_rear_l);
			inst.wheeldata.put(inst.w_front_l.id, inst.w_front_l);
			inst.w_front_r = new WheelTireData("_" + inst.w_rear_r.id);
			inst.w_front_r.asTrailerFront(inst.w_rear_r);
			inst.wheeldata.put(inst.w_front_r.id, inst.w_front_r);
		}
	}

	public void setupAxles(){};

}
