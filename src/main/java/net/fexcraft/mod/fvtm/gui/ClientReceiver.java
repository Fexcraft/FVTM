package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailData;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailRegion;
import net.fexcraft.mod.fvtm.sys.rail.cmds.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.signals.SignalType;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

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
				Attribute<?> attr = veh.getVehicleData().getAttribute(packet.nbt.getString("attr"));
				if(attr.type().isBoolean()){
					attr.setValue(bool);
					if(veh.getRearCoupledEntity() != null){
						attr = veh.getRearCoupledEntity().getVehicleData().getAttribute(packet.nbt.getString("attr"));
						if(attr != null && attr.type().isBoolean()) attr.setValue(bool);
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
				RailData system = (RailData)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				system.updateRegion(player.world.isRemote, packet.nbt.getIntArray("XZ"), packet.nbt, null);
				return;
			}
			case "update_junction":{
				RailData system = (RailData)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				Vec316f vec = new Vec316f(packet.nbt.getCompoundTag("Pos"));
				Junction junction = system.getJunction(vec); if(junction != null) junction.read(packet.nbt);
				else{
					RailRegion region = system.getRegions().get(vec, false);
					if(region != null) region.getJunctions().put(vec, new Junction(region, vec).read(packet.nbt));
				} return;
			}
			case "rem_junction":{
				RailData system = (RailData)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				Vec316f vec = new Vec316f(packet.nbt); RailRegion region = system.getRegions().get(vec, false);
				if(region != null) region.getJunctions().remove(vec); return;
			}
			case "update_junction_state":{
				RailData system = (RailData)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				Junction junction = system.getJunction(new Vec316f(packet.nbt.getCompoundTag("pos")));
				if(junction != null){
					junction.switch0 = packet.nbt.getBoolean("switch0");
					junction.switch1 = packet.nbt.getBoolean("switch1");
				} return;
			}
			case "update_junction_signal":{
				RailData system = (RailData)player.world.getCapability(Capabilities.RAILSYSTEM, null);
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
				RailData system = (RailData)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				Junction junction = system.getJunction(new Vec316f(packet.nbt.getCompoundTag("pos")));
				if(junction != null){
					junction.signal0 = packet.nbt.getBoolean("signal0");
					junction.signal1 = packet.nbt.getBoolean("signal1");
				} return;
			}
			case "spawn_railentity":{
				RailData system = (RailData)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				RailRegion region = system.getRegions().get(packet.nbt.getIntArray("XZ"));
				RailEntity entity = new RailEntity(region).read(packet.nbt);
				region.getEntities().put(entity.getUID(), entity);
				return;
			}
			default: return;
		}
	}

}
