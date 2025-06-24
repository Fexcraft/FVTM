package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.FvtmPlayer;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.uni.Appendable;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Passenger implements Appendable<UniEntity> {

	public int vehicle = -1;
	public int seat = -1;
	public final EntityW entity;

	public Passenger(UniEntity ent){
		entity = ent == null ? null : ent.entity;
	}

	@Override
	public Appendable<UniEntity> create(UniEntity ent){
		//if(!ent.entity.isLiving() && !(ent.entity instanceof VehicleInstance.Holder)) return null;
		return new Passenger(ent);
	}

	@Override
	public String id(){
		return "fvtm:passenger";
	}

	public SeatInstance getSeatOn(){
		if(entity.getVehicleDirect() instanceof VehicleInstance.Holder){
			((VehicleInstance.Holder)entity.getVehicleDirect()).getVehicleInstance().getSeatOf(this);
		}
		return null;
	}

	public VehicleInstance getVehicle(){
		if(entity.getVehicleDirect() instanceof VehicleInstance.Holder){
			return ((VehicleInstance.Holder)entity.getVehicleDirect()).getVehicleInstance();
		}
		return null;
	}

	public void set(int veh, int seatid){
		FvtmLogger.marker(entity.direct(), veh, seatid);
		if(entity.isOnClient() && entity.isRiding() && seatid > -1) {
			VehicleInstance vi = getVehicle();
			for(SeatInstance seat : vi.seats){
				if(seat.passenger_direct() == entity) seat.passenger(null);
			}
		}
		vehicle = veh;
		seat = seatid;
		if(!entity.isOnClient()){
			sendPassUpdate(entity.getId(), vehicle, seat);
			if(entity.isPlayer()){
				FvtmPlayer fp = UniEntity.getApp(entity.direct(), FvtmPlayer.class);
				if(fp == null || fp.notified) return;
				try{
					entity.send("fvtm.seat.controls_info");
					entity.send("https://fexcraft.net/wiki/mod/fvtm/controls");
					fp.notified = true;
				}
				catch(Exception e){
					//
				}
			}
		}
	}

	/** Towards Clients */
	public void sendPassUpdate(int ent, int veh, int seat){
		TagCW com = TagCW.create();
		com.set("ent", ent);
		com.set("veh", veh);
		com.set("seat", seat);
		Packets.sendInRange(PKT_TAG, entity, "upd_pass", com);
	}

	/** Towards Server */
	public void reqPassUpdate(){
		TagCW com = TagCW.create();
		com.set("ent", entity.getId());
		Packets.send(PKT_TAG, "upd_pass", com);
	}

	public void onPacket(EntityW pass, TagCW packet){
		if(entity instanceof VehicleInstance.Holder) ((VehicleInstance.Holder)entity).onPacket(pass, packet);
	}

}
