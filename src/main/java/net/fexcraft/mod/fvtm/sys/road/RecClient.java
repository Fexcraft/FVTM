package net.fexcraft.mod.fvtm.sys.road;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.minecraft.entity.player.EntityPlayer;

public class RecClient implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return "fvtm:roadsys";
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayer player = (EntityPlayer)objs[0];
		switch(task){
			case "update_region":{
				RoadSys system = (RoadSys)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				system.updateRegion(player.world.isRemote, packet.nbt.getIntArray("XZ"), packet.nbt, null);
				return;
			}
			default: return;
		}
	}

}
