package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_VehKeyPress implements PacketHandler<Packet_VehKeyPress> {

	@Override
	public Runnable handleServer(Packet_VehKeyPress packet, Passenger player){
		return () -> {
			SeatInstance seat = player.getSeatOn();
			if(seat != null){
				seat.onKeyPress(packet.keypress, player);
			}
		};
	}

	@Override
	public Runnable handleClient(Packet_VehKeyPress packet, Passenger player){
		return null;
	}

}
