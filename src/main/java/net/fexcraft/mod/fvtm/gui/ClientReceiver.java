package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
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
			case "update_container_holder":
			case "update_railregion":
			case "update_junction":
			case "rem_junction":
			case "update_junction_state":
			case "update_junction_signal":
			case "update_junction_signal_state":
			case "spawn_railentity":
			case "update_sections":
			case "remove_entity":
			case "update_unit_section": Static.stop(); return;
			default: return;
		}
	}

}
