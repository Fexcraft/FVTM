package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_VehKeyPress implements PacketHandler<Packet_VehKeyPress> {

	@Override
	public Runnable handleServer(Packet_VehKeyPress packet, EntityW player){
		return () -> {
			VehicleInstance inst = VehicleInstance.Holder.getFromPlayer(player);
			if(inst == null) return;
			SeatInstance seat = inst.getSeatOf(player);
			if(seat == null) return;
			seat.onKeyPress(packet.keypress, player);
		};
	}

	@Override
	public Runnable handleClient(Packet_VehKeyPress packet, EntityW player){
		return null;
	}

}
