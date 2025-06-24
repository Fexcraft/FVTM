package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_SeatUpdate implements PacketHandler<Packet_SeatUpdate> {

	@Override
	public Runnable handleServer(Packet_SeatUpdate packet, EntityW player){
		return () -> findAndApply(packet, player, true);
	}

	@Override
	public Runnable handleClient(Packet_SeatUpdate packet, EntityW player){
		return () -> findAndApply(packet, player, false);
	}

	private void findAndApply(Packet_SeatUpdate packet, EntityW player, boolean send){
		SeatInstance seat = ((FvtmWorld)player.getWorld()).getSeat(packet.entid, packet.seatid);
		if(seat != null){
			seat.pelook = seat.elook.copy();
			seat.elook.set_rotation(packet.yaw, packet.pitch, 0F, true);
			if(!send) return;
			Packets.sendToAllTrackingEnt(Packet_SeatUpdate.class, seat.root.entity, seat);
		}
	}

}
