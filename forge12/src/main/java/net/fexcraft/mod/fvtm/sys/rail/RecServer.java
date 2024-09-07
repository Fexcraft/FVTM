package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.uni.tag.TagCW;
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
		RailSystem system = SystemManager.get(Systems.RAIL, player.world, RailSystem.class);
		if(system == null){
			Print.log("Received packet but no capability found, aborting!\n" + packet.nbt);
			return;
		};
		switch(task){
			case "update_region":{
				system.updateRegion(TagCW.wrap(packet.nbt), player); return;
			}
			default: return;
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(new PacketNBTTagCompound(compound), new Object[]{ player });
	}

}
