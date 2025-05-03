package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.uni.packet.PacketHandler;
import net.fexcraft.mod.uni.packet.PacketTagListener;
import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Handler_TagListener implements PacketHandler<Packet_TagListener> {

	@Override
	public Runnable handleServer(Packet_TagListener packet, EntityW player){
		return () -> {
			PacketTagListener lis = Packets.LIS_SERVER.get(packet.to);
			if(lis != null) lis.handle(packet.tag, player);
			else FvtmLogger.log("S | Tag Packet Listener not found: " + packet.to);
		};
	}

	@Override
	public Runnable handleClient(Packet_TagListener packet, EntityW player){
		return () -> {
			try{
				PacketTagListener lis = Packets.LIS_CLIENT.get(packet.to);
				if(lis != null) lis.handle(packet.tag, player);
				else FvtmLogger.log("C | Tag Packet Listener not found: " + packet.to);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		};
	}

}
