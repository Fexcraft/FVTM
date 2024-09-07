package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.Passenger;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface PacketHandler<PACKET extends PacketBase> {

	public Runnable handleServer(PACKET packet, Passenger player);

	public Runnable handleClient(PACKET packet, Passenger player);

}
