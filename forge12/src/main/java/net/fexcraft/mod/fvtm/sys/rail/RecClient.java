package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.rail.signals.SignalType;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
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
		RailSystem system = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(player.world));
		try{
			switch(task){
				case "update_region":{
					system.updateRegion(TagCW.wrap(packet.nbt), null);
					return;
				}
				case "update_junction":{
					QV3D vec = new QV3D(TagCW.wrap(packet.nbt), "Pos");
					Junction junction = system.getJunction(vec); if(junction != null) junction.read(TagCW.wrap(packet.nbt));
					else{
						Region region = system.getRegions().get(vec, false);
						if(region != null) region.getJunctions().put(vec, new Junction(region, vec).read(TagCW.wrap(packet.nbt)));
					}
					return;
				}
				case "rem_junction":{
					QV3D vec = new QV3D(TagCW.wrap(packet.nbt), null); //RailRegion region = system.getRegions().get(vec, false);
					//if(region != null) region.getJunctions().remove(vec); return;
					system.delJunction(vec);
					return;
				}
				case "update_junction_state":{
					Junction junction = system.getJunction(new QV3D(TagCW.wrap(packet.nbt), "pos"));
					if(junction != null){
						junction.switch0 = packet.nbt.getBoolean("switch0");
						junction.switch1 = packet.nbt.getBoolean("switch1");
					}
					return;
				}
				case "update_junction_signal":{
					Junction junction = system.getJunction(new QV3D(TagCW.wrap(packet.nbt), "pos"));
					if(junction != null){
						if(packet.nbt.hasKey("nosignal") && packet.nbt.getBoolean("nosignal")){
							junction.signal = null;
							junction.signal_dir = EntryDirection.FORWARD;
						}
						else{
							junction.signal = SignalType.values()[packet.nbt.getInteger("signal")];
							junction.signal_dir = EntryDirection.values()[packet.nbt.getInteger("signal_dir")];
						}
						junction.signalpos0 = junction.signalpos1 = null;
					} return;
				}
				case "update_junction_signal_state":{
					Junction junction = system.getJunction(new QV3D(TagCW.wrap(packet.nbt), "pos"));
					if(junction != null){
						junction.signal0 = packet.nbt.getBoolean("signal0");
						junction.signal1 = packet.nbt.getBoolean("signal1");
					} return;
				}
				case "spawn_railentity":{
					/*Print.debug("Receiving entity spawn request.");
					Region region = system.getRegions().get(packet.nbt.getIntArray("XZ"), true);
					if(region != null && region.loaded) region.spawnEntity(new RailEntity(region, packet.nbt.getLong("uid")).read(packet.nbt));
					else Region.clientqueue.put(packet.nbt.getLong("uid"), packet.nbt.copy());*/
					Static.stop(); return;
				}
				case "update_sections":{
					NBTTagList list = (NBTTagList)packet.nbt.getTag("units"); TrackUnit unit; NBTTagCompound com;
					for(NBTBase base : list){
						com = (NBTTagCompound)base;
						unit = system.getTrackUnits().get(com.getString("unit"));
						if(unit != null){
							unit.setSection(system.getSection(com.getLong("section")), false);
						}
					}
					Print.debug(list);
					return;
				}
				case "remove_entity":{
					//RailEntity ent = system.getEntity(packet.nbt.getLong("uid"), false); if(ent == null) return; ent.dispose();
					return;
				}
				default: Print.debug(packet.nbt); return;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Print.debug(packet.nbt);
			Static.stop();
		}
	}

}
