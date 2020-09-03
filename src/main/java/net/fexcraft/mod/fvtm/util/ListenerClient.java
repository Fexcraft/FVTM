package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.util.caps.PassengerCapHandler;
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
				if(ent == null){
					PassengerCapHandler.CLQUEUE.put(packet.nbt.getInteger("entity"), packet.nbt.getInteger("seat"));
					return;
				}
				ent.getCapability(Capabilities.PASSENGER, null).set(packet.nbt.getInteger("vehicle"), packet.nbt.getInteger("seat"));
				return;
			}
			default: return;
		}
	}

}
