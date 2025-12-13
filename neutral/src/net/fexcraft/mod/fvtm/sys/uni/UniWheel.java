package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;

import java.util.function.Consumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniWheel {

	public static Consumer<UniWheel> SET_STEP = uw -> {};
	protected V3D pos = new V3D();
	protected V3D prev = new V3D();
	protected V3D move = new V3D();
	public final VehicleInstance vehicle;
	public final WheelTireData wdata;

	public UniWheel(VehicleInstance inst, String id){
		vehicle = inst;
		wdata = vehicle.wheeldata.get(id);
		pos.copy(vehicle.pivot().get_vector(wdata.pos).add(vehicle.entity.getPos()));
		prev.copy(pos);
	}

	public void updatePrevPos(){
		prev.copy(pos);
	}

	public void prepare(){
		vehicle.entity.setOnGround(true);
		vehicle.entity.setPrevPos(prev);
		vehicle.entity.setPos(pos);
		SET_STEP.accept(this);
	}

	public void move(){
		vehicle.entity.move(move);
		pos.copy(vehicle.entity.getPos());
	}

	public WheelTireData wtd(){
		return wdata;
	}

	public void addMotion(double x, double y, double z){
		V3D.add(x, y, z, move);
	}

	public void setMotion(double x, double y, double z){
		move.set(x, y, z);
	}

	public void mulMotion(double by){
		V3D.mul(by, by, by, move);
	}

	public void fillMotion(V3D vec){}

}
