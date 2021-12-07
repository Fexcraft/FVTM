package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
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
				String attribute = packet.nbt.getString("attr");
				Attribute<?> attr = null;
				VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(veh == null && packet.nbt.hasKey("railid")){
					RailEntity ent = SystemManager.get(Systems.RAIL, player.world, RailSystem.class).getEntity(packet.nbt.getLong("railid"), false);
					attr = ent.vehdata.getAttribute(attribute);
				}
				else if(veh != null){
					attr = veh.getVehicleData().getAttribute(attribute);
				}
				else{
					Print.debug("Received packet for entity not found on client side!");
					return;
				}
				if(attr.valuetype().isTristate()){
					if(attr.valuetype().isBoolean() || !packet.nbt.hasKey("reset")) attr.value(bool);
					else attr.value(null);
				}
				else if(attr.valuetype().isNumber()){
					attr.value(attr.valuetype().isInteger() ? packet.nbt.getInteger("value") : packet.nbt.getFloat("value"));
				}
				else{
					Print.log("no code for toggling this attribute type yet");
				}
				break;
			}
			case "attr_update":{
				VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				Attribute<?> attr = veh.getVehicleData().getAttribute(packet.nbt.getString("attr"));
				if(attr.valuetype().isTristate()){
					if(packet.nbt.hasKey("reset") && packet.nbt.getBoolean("reset")){
						attr.reset();
					}
					else{
						attr.value(packet.nbt.getBoolean("value"));
					}
				}
				else if(attr.valuetype().isFloat()){
					attr.value(packet.nbt.getFloat("value"));
				}
				else if(attr.valuetype().isInteger()){
					attr.value(packet.nbt.getInteger("value"));
				}
				else if(attr.valuetype().isString()){
					attr.value(packet.nbt.getString("value"));
				}
				else attr.value(packet.nbt.getString("value"));
				break;
			}
			case "update_container_holder":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null){
					Print.debug("Entity not found. CHP " + packet.nbt.getInteger("entity"));
					return;
				}
				ContainerHolderUtil.Implementation impl = (Implementation)ent.getCapability(Capabilities.CONTAINER, null);
				if(impl == null) Print.debug("Capability is null. CHP " + packet.nbt.getInteger("entity"));
				else impl.read(null, packet.nbt);
				return;
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
			case "update_unit_section":{
				Print.debug("task: " + task + " " + packet.nbt);
				Static.stop();
				return;
			}
			case "open_gui":{
				if(packet.nbt.hasKey("data")){
					// gui should have been already opened server side
					if(player.openContainer instanceof GenericContainer && !((GenericContainer)player.openContainer).isInit()){
						((GenericContainer)player.openContainer).initPacket(packet.nbt.getCompoundTag("data"));
						Print.debug("Loaded client compound.");
					}
					else{
						GuiHandler.CLIENT_GUIDATA_CACHE = packet.nbt.getCompoundTag("data");
						Print.debug("Cached client compound.");
						// int[] xyz = packet.nbt.getIntArray("args");
						// player.openGui(FVTM.getInstance(), packet.nbt.getInteger("gui"), player.world, xyz[0], xyz[1], xyz[2]);
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
