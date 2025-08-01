package net.fexcraft.mod.fvtm.sys.event;

import net.fexcraft.mod.fvtm.data.root.Soundable.SoundHolder;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventData {

	public VehicleData vehicle;
	public VehicleInstance vehent;
	public EntityW pass;
	public EventHolder rootholder;
	public EventHolder holder;
	public Object[] args;
	//
	public EntityW entity;
	public Object tile;

	public EventData set(VehicleInstance inst, EntityW passenger, EventHolder root, EventHolder hol, Object... objs){
		vehent = inst;
		vehicle = inst.data;
		pass = passenger;
		rootholder = root;
		holder = hol;
		args = objs;
		return this;
	}

	public SoundHolder sounds(){
		return (SoundHolder)holder;
	}

}
