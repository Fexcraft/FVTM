package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniWheelImpl implements UniWheel {

	private V3D pos = new V3D();
	private V3D prev = new V3D();
	private V3D move = new V3D();
	private float yaw = 0;
	private VehicleInstance vehicle;
	private WheelTireData wdata;

	public UniWheelImpl(VehicleInstance inst, String id){
		vehicle = inst;
		wdata = vehicle.wheeldata.get(id);
		pos.copy(vehicle.pivot().get_vector(wdata.pos).add(vehicle.entity.getPos()));
		prev.copy(pos);
	}

	@Override
	public void updatePrevPos(){
		prev.copy(pos);
	}

	@Override
	public void remove(){
		//
	}

	@Override
	public boolean isAdded(){
		return true;
	}

	@Override
	public V3D prev(){
		return prev;
	}

	@Override
	public V3D pos(){
		return pos;
	}

	@Override
	public void pos(double x, double y, double z){
		pos.set(x, y, z);
	}

	@Override
	public void yaw(float yaw){
		this.yaw = yaw;
	}

	@Override
	public void prepare(){
		vehicle.entity.setOnGround(true);
		vehicle.entity.setPrevPos(prev);
		vehicle.entity.setPos(pos);
	}

	@Override
	public void move(){
		vehicle.entity.move(move);
		pos.copy(vehicle.entity.getPos());
	}

	@Override
	public WheelTireData wtd(){
		return wdata;
	}

	@Override
	public void addMotion(double x, double y, double z){
		V3D.add(x, y, z, move);
	}

	@Override
	public void setMotion(double x, double y, double z){
		move.set(x, y, z);
	}

	@Override
	public void mulMotion(double by){
		V3D.mul(by, by, by, move);
	}

	@Override
	public void fillMotion(V3D vec){
		//
	}

}
