package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.System;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.Region;
import net.fexcraft.mod.fvtm.sys.rail.TrackUnit;
import net.fexcraft.mod.fvtm.sys.rail.signals.SignalType;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ClientReceiver implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return "fvtm:gui";
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayer player = (EntityPlayer)objs[0];
		switch(task){
			case "attr_toggle":{
				boolean bool = packet.nbt.getBoolean("bool");
				VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				String attribute = packet.nbt.getString("attr");
				Attribute<?> attr = veh.getVehicleData().getAttribute(attribute);
				if(attr.type().isBoolean()){
					attr.setValue(bool);
					if(!veh.getVehicleType().isRailVehicle()){
						VehicleEntity trailer = veh.getRearCoupledEntity();
						while(trailer != null){
							attr = trailer.getVehicleData().getAttribute(attribute);
							if(attr != null && attr.type().isBoolean()){ attr.setValue(bool); }
							trailer = trailer.getRearCoupledEntity();
						}
					}
				}
				else{
					//TODO
					Print.log("no code for toggling this attribute type yet");
				}
				break;
			}
			case "attr_update":{
				VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				Attribute<?> attr = veh.getVehicleData().getAttribute(packet.nbt.getString("attr"));
				attr.setValue(attr.type().tryParse(packet.nbt.getString("value")));
				break;
			}
			case "update_container_holder":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null){ Print.debug("Entity not found. CHP " + packet.nbt.getInteger("entity")); return; }
				ContainerHolderUtil.Implementation impl = (Implementation)ent.getCapability(Capabilities.CONTAINER, null);
				if(impl == null) Print.debug("Capability is null. CHP " + packet.nbt.getInteger("entity"));
					else impl.read(null, packet.nbt); return;
			}
			case "update_railregion":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				system.updateRegion(player.world.isRemote, packet.nbt.getIntArray("XZ"), packet.nbt, null);
				return;
			}
			case "update_junction":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				Vec316f vec = new Vec316f(packet.nbt.getCompoundTag("Pos"));
				Junction junction = system.getJunction(vec); if(junction != null) junction.read(packet.nbt);
				else{
					Region region = system.getRegions().get(vec, false);
					if(region != null) region.getJunctions().put(vec, new Junction(region, vec).read(packet.nbt));
				} return;
			}
			case "rem_junction":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				Vec316f vec = new Vec316f(packet.nbt); //RailRegion region = system.getRegions().get(vec, false);
				//if(region != null) region.getJunctions().remove(vec); return;
				system.delJunction(vec); return;
			}
			case "update_junction_state":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				Junction junction = system.getJunction(new Vec316f(packet.nbt.getCompoundTag("pos")));
				if(junction != null){
					junction.switch0 = packet.nbt.getBoolean("switch0");
					junction.switch1 = packet.nbt.getBoolean("switch1");
				} return;
			}
			case "update_junction_signal":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
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
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				Junction junction = system.getJunction(new Vec316f(packet.nbt.getCompoundTag("pos")));
				if(junction != null){
					junction.signal0 = packet.nbt.getBoolean("signal0");
					junction.signal1 = packet.nbt.getBoolean("signal1");
				} return;
			}
			case "spawn_railentity":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				Region region = system.getRegions().get(packet.nbt.getIntArray("XZ"));
				RailEntity entity = new RailEntity(region, packet.nbt).read(packet.nbt);
				region.getEntities().put(entity.getUID(), entity);
				return;
			}
			case "update_sections":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				NBTTagList list = (NBTTagList)packet.nbt.getTag("units"); TrackUnit unit; NBTTagCompound com;
				for(NBTBase base : list){
					com = (NBTTagCompound)base; unit = system.getTrackUnits().get(com.getString("unit"));
					if(unit != null) unit.setSection(system.getSection(com.getLong("section")));
				}
				return;
			}
			case "remove_entity":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				RailEntity ent = system.getEntity(packet.nbt.getLong("uid"), false); if(ent == null) return; ent.dispose();
				return;
			}
			case "update_unit_section":{
				System system = (System)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				TrackUnit unit = system.getTrackUnits().get(packet.nbt.getString("unit"));
				if(unit != null) unit.setSection(system.getSection(packet.nbt.getLong("section")));
				return;
			}
			default: return;
		}
	}

}
