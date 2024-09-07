package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.Passenger;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_VehMove implements PacketHandler<Packet_VehMove> {

	@Override
	public Runnable handleServer(Packet_VehMove packet, Passenger player){
		return () -> player.getFvtmWorld().onVehicleMove(packet);
	}

	@Override
	public Runnable handleClient(Packet_VehMove packet, Passenger player){
		return () -> player.getFvtmWorld().onVehicleMove(packet);
	}


}
