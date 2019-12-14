package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

public class RecServer implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return "fvtm:railsys";
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayerMP player = (EntityPlayerMP)objs[0];
		switch(task){
			case "update_railregion":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				system.updateRegion(player.world.isRemote, packet.nbt.getIntArray("XZ"), packet.nbt, player);
			}
			default: return;
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(new PacketNBTTagCompound(compound), new Object[]{ player });
	}

}
