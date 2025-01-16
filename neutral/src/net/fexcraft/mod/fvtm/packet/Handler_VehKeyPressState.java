package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_VehKeyPressState implements PacketHandler<Packet_VehKeyPressState> {

	@Override
	public Runnable handleServer(Packet_VehKeyPressState packet, EntityW player){
		return () -> {
			Passenger pass = (Passenger)player;
			SeatInstance seat = pass.getSeatOn();
			if(seat == null) return;
			seat.root.onKeyPress(packet.keypress, seat.seat, pass, packet.state);
			Packets.sendInRange(Packet_VehKeyPressState.class, player, packet.data());
		};
	}

	@Override
	public Runnable handleClient(Packet_VehKeyPressState packet, EntityW player){
		return () -> {
			Passenger pass = ((FvtmWorld)player.getWorld()).getPassenger(packet.player);
			if(pass == null) return;
			SeatInstance seat = pass.getSeatOn();
			if(seat == null) return;
			seat.root.onKeyPress(packet.keypress, seat.seat, pass, packet.state);
		};
	}

}
