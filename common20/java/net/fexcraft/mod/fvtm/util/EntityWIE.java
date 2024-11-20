package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fcl.util.EntityWI;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.UIKey;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EntityWIE extends EntityWI implements Passenger {

	private boolean notified;
	private int vehicle;
	private int seat;

	public EntityWIE(Entity iah){
		super(iah);
	}

	@Override
	public SeatInstance getSeatOn(){
		if(entity.getVehicle() instanceof RootVehicle == false) return null;
		return ((RootVehicle)entity.getVehicle()).getSeatOf(entity);
	}

	@Override
	public void set(int veh, int seatid){
		if(entity.level().isClientSide && entity.isPassenger() && seatid > -1){
			RootVehicle root = (RootVehicle)entity.getVehicle();
			for(SeatInstance seat : root.vehicle.seats){
				if(seat.passenger_direct() == entity) seat.passenger(null);
			}
		}
		vehicle = veh;
		seat = seatid;
		if(!entity.level().isClientSide){
			update_packet();
			if(entity instanceof Player && !notified){
				try{
					//TODO send controls info/link in chat // "https://fexcraft.net/wiki/mod/fvtm/controls"
					notified = true;
				}
				catch(Exception e){
					//
				}
			}
		}
	}

	private void update_packet(){
		TagCW packet = TagCW.create();
		packet.set("entity", entity.getId());
		packet.set("vehicle", vehicle);
		packet.set("seat", seat);
		Packets.sendToAll(Packet_TagListener.class, "passenger_update", packet);
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
	public void decreaseXZMotion(double x){
		//
	}

	@Override
	public void setYawPitch(float oyaw, float opitch, float yaw, float pitch){
		//
	}

	@Override
	public void onPacket(EntityW player, TagCW packet){
		if(entity instanceof RootVehicle) ((RootVehicle)entity).onPacket(player, packet);
	}

}
