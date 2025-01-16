package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_VehKeyPress implements PacketHandler<Packet_VehKeyPress> {

	@Override
	public Runnable handleServer(Packet_VehKeyPress packet, EntityW player){
		return () -> {
			Passenger pass = (Passenger)player;
			SeatInstance seat = pass.getSeatOn();
			if(seat != null){
				seat.onKeyPress(packet.keypress, pass);
			}
		};
	}

	@Override
	public Runnable handleClient(Packet_VehKeyPress packet, EntityW player){
		return null;
	}

}
