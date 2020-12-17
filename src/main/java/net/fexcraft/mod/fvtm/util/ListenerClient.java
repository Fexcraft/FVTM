package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ListenerClient implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return Resources.UTIL_LISTENER;
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayer player = (EntityPlayer)objs[0];
		switch(task){
			case "update_passenger":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null) return;
				/*if(ent == null){
					PassengerCapHandler.CLQUEUE.put(uuid, packet.nbt.getInteger("seat"));
					return;
				}*/
				ent.getCapability(Capabilities.PASSENGER, null).set(packet.nbt.getInteger("vehicle"), packet.nbt.getInteger("seat"));
				return;
			}
			case "config_sync":{
				ULandVehicle.SYNC_RATE = packet.nbt.hasKey("u12_sync_rate") ? packet.nbt.getInteger("u12_sync_rate") : Config.U12_SYNC_RATE;
				return;
			}
			default: return;
		}
	}

}
