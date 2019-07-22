package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerReceiver implements IPacketListener<PacketNBTTagCompound> {

	@Override
	public String getId(){
		return "fvtm:gui";
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayerMP player = (EntityPlayerMP)objs[0];
		switch(task){
			case "attr_toggle":{
				boolean bool = packet.nbt.getBoolean("bool");
				VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				Attribute attr = veh.getVehicleData().getAttribute(packet.nbt.getString("attr"));
				if(attr.getValueType().isBoolean()){
					attr.setCurrentValue(bool ? 1 : 0); packet.nbt.setBoolean("bool", attr.getCurrentBoolean()); Print.debug("sending back");
					PacketHandler.getInstance().sendToAllAround(packet, Resources.getTargetPoint(veh.getEntity()));
				}
				else{
					//TODO
					Print.log("no code for toggling this attribute type yet");
				}
				break;
			}
			default: return;
		}
	}

}
