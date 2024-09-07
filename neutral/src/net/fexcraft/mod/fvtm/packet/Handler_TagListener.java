package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.Passenger;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_TagListener implements PacketHandler<Packet_TagListener> {

	@Override
	public Runnable handleServer(Packet_TagListener packet, Passenger player){
		return () -> Packets.LIS_SERVER.get(packet.to).handle(packet.tag, player);
	}

	@Override
	public Runnable handleClient(Packet_TagListener packet, Passenger player){
		return () -> Packets.LIS_CLIENT.get(packet.to).handle(packet.tag, player);
	}

}
