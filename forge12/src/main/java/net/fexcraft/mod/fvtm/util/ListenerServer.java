package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;

public class ListenerServer implements IPacketListener<PacketNBTTagCompound> {
	
	public static ListenerServer INSTANCE;
	public ListenerServer(){ INSTANCE = this; }

	@Override
	public String getId(){
		return UTIL_LISTENER;
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayerMP player = (EntityPlayerMP)objs[0];
		switch(task){
			case "upg":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent != null && ent.getCapability(Capabilities.PASSENGER, null).seat() > -1){
					ent.getCapability(Capabilities.PASSENGER, null).update_packet();
				}
				return;
			}
			default: return;
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(new PacketNBTTagCompound(compound), new Object[]{ player });
	}

}
