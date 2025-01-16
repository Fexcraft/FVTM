package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_SPUpdate implements PacketHandler<Packet_SPUpdate> {

	@Override
	public Runnable handleServer(Packet_SPUpdate packet, EntityW player){
		return () -> findAndApply(packet, player);
	}

	@Override
	public Runnable handleClient(Packet_SPUpdate packet, EntityW player){
		return () -> findAndApply(packet, player);
	}

	private void findAndApply(Packet_SPUpdate packet, EntityW player){
		SwivelPoint point = ((FvtmWorld)player.getWorld()).getSwivelPoint(packet.entid, packet.pointid);
		if(point != null) point.processPacket(packet, player.isOnClient());
	}

}
