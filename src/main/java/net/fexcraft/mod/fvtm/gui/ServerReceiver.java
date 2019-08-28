package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

public class ServerReceiver implements IPacketListener<PacketNBTTagCompound> {
	
	public static ServerReceiver INSTANCE;
	public ServerReceiver(){ INSTANCE = this; }

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
				Attribute<?> attr = veh.getVehicleData().getAttribute(packet.nbt.getString("attr"));
				if(attr.type().isBoolean()){
					attr.setValue(bool); packet.nbt.setBoolean("bool", attr.getBooleanValue());
					PacketHandler.getInstance().sendToAllAround(packet, Resources.getTargetPoint(veh.getEntity()));
					if(veh.getRearCoupledEntity() != null){
						attr = veh.getRearCoupledEntity().getVehicleData().getAttribute(packet.nbt.getString("attr"));
						if(attr != null && attr.type().isBoolean()){
							attr.setValue(bool); NBTTagCompound compound = packet.nbt.copy(); compound.setBoolean("bool", attr.getBooleanValue());
							PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(veh.getRearCoupledEntity().getEntity()));
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
				//TODO other checks?
				attr.setValue(attr.type().tryParse(packet.nbt.getString("value"))); packet.nbt.setString("value", attr.getStringValue());
				PacketHandler.getInstance().sendToAllAround(packet, Resources.getTargetPoint(veh.getEntity()));
				break;
			}
			case "update_container_holder":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null){ Print.debug("Entity not found. CHP " + packet.nbt.getInteger("entity")); return; }
				ContainerHolderUtil.Implementation impl = (Implementation)ent.getCapability(Capabilities.CONTAINER, null);
				if(impl == null) Print.debug("Capability is null. CHP " + packet.nbt.getInteger("entity"));
					else impl.sync(false); return;
			}
			case "update_railregion":{
				RailData system = (RailData)player.world.getCapability(Capabilities.RAILSYSTEM, null);
				system.updateRegion(player.world.isRemote, packet.nbt.getIntArray("XZ"), packet.nbt, player);
			}
			default: return;
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(new PacketNBTTagCompound(compound), new Object[]{ player });
	}

}
