package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_SPUpdate implements PacketHandler<Packet_SPUpdate> {

	@Override
	public Runnable handleServer(Packet_SPUpdate packet, Passenger player){
		return () -> findAndApply(packet, player);
	}

	@Override
	public Runnable handleClient(Packet_SPUpdate packet, Passenger player){
		return () -> findAndApply(packet, player);
	}

	private void findAndApply(Packet_SPUpdate packet, Passenger player){
		SwivelPoint point = player.getFvtmWorld().getSwivelPoint(packet.entid, packet.pointid);
		if(point != null) point.processPacket(packet, player.isOnClient());
	}

}
