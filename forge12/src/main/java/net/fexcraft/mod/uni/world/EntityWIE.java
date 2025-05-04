package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.util.I19U;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EntityWIE extends EntityWI implements Passenger {

	private int vehicle = -1, seat = -1;
	private boolean notified;

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
		if(entity.world.isRemote && entity.isRiding() && seatid > -1) {
			RootVehicle geve = (RootVehicle)entity.getRidingEntity();
			for(SeatInstance seat : geve.vehicle.seats){
				if(seat.passenger_direct() == entity) seat.passenger(null);
			}
		}
		vehicle = veh;
		seat = seatid;
		if(!entity.world.isRemote){
			sendPassUpdate(entity.getEntityId(), vehicle, seat);
			if(entity instanceof EntityPlayer && !notified) {
				try{
					Print.link(entity, I19U.trss("fvtm.seat.controls_info"), "https://fexcraft.net/wiki/mod/fvtm/controls");
					notified = true;
				}
				catch(Exception e){
					//
				}
			}
		}
	}

	@Override
	public int vehicle(){
		return vehicle;
	}

	@Override
	public int seat(){
		return seat;
	}


	@Override
	public void onPacket(EntityW player, TagCW packet){
		if(entity instanceof RootVehicle) ((RootVehicle)entity).onPacket(player, packet);
	}

}
