package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RailSystem;
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
		String task = packet.nbt.getString("task"); EntityPlayerMP player = (EntityPlayerMP)objs[0];
		RailSystem sys = player.world.getCapability(Capabilities.RAILSYSTEM, null);
		if(sys == null){ Print.log("Received packet but no capability found, aborting!\n" + packet.nbt); return; } RailSys system = sys.get();
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
