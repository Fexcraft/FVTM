package net.fexcraft.mod.fvtm.sys.wire;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

public class RecServer implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return "fvtm:wiresys";
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayerMP player = (EntityPlayerMP)objs[0];
		WireSystem system = SystemManager.get(Systems.WIRE, WrapperHolder.getWorld(player.world), WireSystem.class);
		if(system == null){
			Print.log("Received packet but no wire system found, aborting!\n" + packet.nbt);
			return;
		}
		switch(task){
			case "update_region":{
				system.updateRegion(packet.nbt, player); return;
			}
			default: return;
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(new PacketNBTTagCompound(compound), new Object[]{ player });
	}

}
