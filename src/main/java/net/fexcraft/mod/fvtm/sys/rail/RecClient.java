package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.sys.rail.signals.SignalType;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class RecClient implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return "fvtm:railsys";
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayer player = (EntityPlayer)objs[0];
		switch(task){
			case "update_railregion":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				system.updateRegion(player.world.isRemote, packet.nbt.getIntArray("XZ"), packet.nbt, null);
				return;
			}
			case "update_junction":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				Vec316f vec = new Vec316f(packet.nbt.getCompoundTag("Pos"));
				Junction junction = system.getJunction(vec); if(junction != null) junction.read(packet.nbt);
				else{
					Region region = system.getRegions().get(vec, false);
					if(region != null) region.getJunctions().put(vec, new Junction(region, vec).read(packet.nbt));
				} return;
			}
			case "rem_junction":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				Vec316f vec = new Vec316f(packet.nbt); //RailRegion region = system.getRegions().get(vec, false);
				//if(region != null) region.getJunctions().remove(vec); return;
				system.delJunction(vec); return;
			}
			case "update_junction_state":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				Junction junction = system.getJunction(new Vec316f(packet.nbt.getCompoundTag("pos")));
				if(junction != null){
					junction.switch0 = packet.nbt.getBoolean("switch0");
					junction.switch1 = packet.nbt.getBoolean("switch1");
				} return;
			}
			case "update_junction_signal":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				Junction junction = system.getJunction(new Vec316f(packet.nbt.getCompoundTag("pos")));
				if(junction != null){
					if(packet.nbt.hasKey("nosignal") && packet.nbt.getBoolean("nosignal")){
						junction.signal = null; junction.signal_dir = EntryDirection.FORWARD;
					}
					else{
						junction.signal = SignalType.values()[packet.nbt.getInteger("signal")];
						junction.signal_dir = EntryDirection.values()[packet.nbt.getInteger("signal_dir")];
					}
					junction.signalpos0 = junction.signalpos1 = null;
				} return;
			}
			case "update_junction_signal_state":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				Junction junction = system.getJunction(new Vec316f(packet.nbt.getCompoundTag("pos")));
				if(junction != null){
					junction.signal0 = packet.nbt.getBoolean("signal0");
					junction.signal1 = packet.nbt.getBoolean("signal1");
				} return;
			}
			case "spawn_railentity":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				Region region = system.getRegions().get(packet.nbt.getIntArray("XZ"));
				RailEntity entity = new RailEntity(region, packet.nbt).read(packet.nbt);
				region.getEntities().put(entity.getUID(), entity);
				return;
			}
			case "update_sections":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				NBTTagList list = (NBTTagList)packet.nbt.getTag("units"); TrackUnit unit; NBTTagCompound com;
				for(NBTBase base : list){
					com = (NBTTagCompound)base; unit = system.getTrackUnits().get(com.getString("unit"));
					if(unit != null) unit.setSection(system.getSection(com.getLong("section")));
				}
				return;
			}
			case "remove_entity":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				RailEntity ent = system.getEntity(packet.nbt.getLong("uid"), false); if(ent == null) return; ent.dispose();
				return;
			}
			case "update_unit_section":{
				RailSys system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
				TrackUnit unit = system.getTrackUnits().get(packet.nbt.getString("unit"));
				if(unit != null) unit.setSection(system.getSection(packet.nbt.getLong("section")));
				return;
			}
			default: Print.debug(packet.nbt); return;
		}
	}

}
