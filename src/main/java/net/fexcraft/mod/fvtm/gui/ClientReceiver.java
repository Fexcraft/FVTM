package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ClientReceiver implements IPacketListener<PacketNBTTagCompound> {

	public static String LAST_MSG;

	@Override
	public String getId(){
		return GuiHandler.LISTENERID;
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
				if(attr.type().isTristate()){
					if(attr.type().isBoolean() || !packet.nbt.hasKey("reset")) attr.setValue(bool); else attr.setValue(null);
					if(!veh.getVehicleType().isRailVehicle()){
						VehicleEntity trailer = veh.getRearCoupledEntity();
						while(trailer != null){
							attr = trailer.getVehicleData().getAttribute(attribute);
							if(attr != null){
								if(attr.type().isBoolean() || !packet.nbt.hasKey("reset")) attr.setValue(bool);
								else attr.setValue(null);
							}
							trailer = trailer.getRearCoupledEntity();
						}
					}
				}
				else if(attr.type().isNumber()){
					attr.setValue(attr.type().isInteger() ? packet.nbt.getInteger("value") : packet.nbt.getFloat("value"));
					if(!veh.getVehicleType().isRailVehicle()){
						VehicleEntity trailer = veh.getRearCoupledEntity();
						while(trailer != null){
							attr = trailer.getVehicleData().getAttribute(attribute);
							if(attr != null){
								attr.setValue(attr.type().isInteger() ? packet.nbt.getInteger("value") : packet.nbt.getFloat("value"));
							}
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
			case "update_region":
			case "update_junction":
			case "rem_junction":
			case "update_junction_state":
			case "update_junction_signal":
			case "update_junction_signal_state":
			case "spawn_railentity":
			case "update_sections":
			case "remove_entity":
			case "update_unit_section":{ Print.debug("task: " + task + " " + packet.nbt); Static.stop(); return; }
			case "open_gui":{
                if(packet.nbt.hasKey("data")){
                	//gui should have been already opened server side
                	if(player.openContainer instanceof GenericContainer && !((GenericContainer)player.openContainer).isInit()){
                		((GenericContainer)player.openContainer).initPacket(packet.nbt.getCompoundTag("data"));
                		Print.debug("Loaded client compound.");
                	}
                	else{
                		GuiHandler.CLIENT_GUIDATA_CACHE = packet.nbt.getCompoundTag("data");
                		Print.debug("Cached client compound.");
                		//int[] xyz = packet.nbt.getIntArray("args");
                		//player.openGui(FVTM.getInstance(), packet.nbt.getInteger("gui"), player.world, xyz[0], xyz[1], xyz[2]);
                	}
                }
				return;
			}
			case "gui:cmd:msg":{
				LAST_MSG = packet.nbt.getString("msg");
				return;
			}
			default: return;
		}
	}

}
