package net.fexcraft.mod.fvtm.sys.road;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.util.Vec316f;
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
				RoadSys system = player.world.getCapability(Capabilities.ROADSYSTEM, null).get();
				system.updateRegion(player.world.isRemote, packet.nbt.getIntArray("XZ"), packet.nbt, null);
				return;
			}
			case "update_point":{
				RoadSys system = player.world.getCapability(Capabilities.ROADSYSTEM, null).get();
				Vec316f vec = new Vec316f(packet.nbt.getCompoundTag("Pos"));
				RoadJunc point = system.getRoadPoint(vec); if(point != null) point.read(packet.nbt);
				else{
					Region region = system.getRegions().get(vec, false);
					if(region != null) region.getRoadPoints().put(vec, new RoadJunc(region, vec).read(packet.nbt));
				} return;
			}
			default: Print.debug(packet.nbt); return;
		}
	}

}
