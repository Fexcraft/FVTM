package net.fexcraft.mod.uni.world;

import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.minecraft.entity.Entity;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EntityWIE extends EntityWI implements Passenger {

	public EntityWIE(Entity ent){
		super(ent);
	}

	@Override
	public SeatInstance getSeatOn(){
		if(entity.getRidingEntity() instanceof RootVehicle == false) return null;
		return ((RootVehicle)entity.getRidingEntity()).getSeatOf(entity);
	}

	@Override
	public void set(int veh, int seatid){
		//
	}

	@Override
	public int vehicle(){
		return 0;
	}

	@Override
	public int seat(){
		return 0;
	}

}
