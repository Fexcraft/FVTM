package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;

public class RecServer implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return "fvtm:railsys";
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		// TODO Auto-generated method stub
		
	}

}
