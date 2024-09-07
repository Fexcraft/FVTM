package net.fexcraft.mod.fvtm.sys.event;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventData {

	public VehicleData vehicle;
	public VehicleInstance vehent;
	public Passenger pass;
	public EventHolder rootholder;
	public EventHolder holder;
	//
	public Object entity;
	public Object tile;

	public EventData set(VehicleInstance inst, Passenger passenger, EventHolder root, EventHolder hol){
		vehent = inst;
		vehicle = inst.data;
		pass = passenger;
		rootholder = root;
		holder = hol;
		return this;
	}

}
