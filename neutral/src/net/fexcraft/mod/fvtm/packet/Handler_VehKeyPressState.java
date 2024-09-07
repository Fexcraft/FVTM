package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_VehKeyPressState implements PacketHandler<Packet_VehKeyPressState> {

	@Override
	public Runnable handleServer(Packet_VehKeyPressState packet, Passenger player){
		return () -> {
			SeatInstance seat = player.getSeatOn();
			if(seat == null) return;
			seat.root.onKeyPress(packet.keypress, seat.seat, player, packet.state);
			Packets.sendInRange(Packet_VehKeyPressState.class, player, packet.data());
		};
	}

	@Override
	public Runnable handleClient(Packet_VehKeyPressState packet, Passenger player){
		return () -> {
			Passenger pass = player.getFvtmWorld().getPassenger(packet.source);
			if(pass == null) return;
			SeatInstance seat = pass.getSeatOn();
			if(seat == null) return;
			seat.root.onKeyPress(packet.keypress, seat.seat, pass, packet.state);
		};
	}

}
