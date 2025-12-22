package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_VehKeyPressState implements PacketHandler<Packet_VehKeyPressState> {

	@Override
	public Runnable handleServer(Packet_VehKeyPressState packet, EntityW player){
		return () -> {
			VehicleInstance inst = VehicleInstance.Holder.getFromPlayer(player);
			if(inst == null) return;
			SeatInstance seat = inst.getSeatOf(player);
			if(seat == null) return;
			seat.root.onKeyPress(packet.keypress, seat.seat, player, packet.state, true);
			Packets.sendToAllTrackingEnt(Packet_VehKeyPressState.class, seat.root.entity, packet.data());
		};
	}

	@Override
	public Runnable handleClient(Packet_VehKeyPressState packet, EntityW player){
		return () -> {
			VehicleInstance inst = VehicleInstance.Holder.getFromPlayer(player);
			if(inst == null) return;
			SeatInstance seat = inst.getSeatOf(player);
			if(seat == null || seat.root.driven) return;
			seat.root.onKeyPress(packet.keypress, seat.seat, player, packet.state, true);
		};
	}

}
