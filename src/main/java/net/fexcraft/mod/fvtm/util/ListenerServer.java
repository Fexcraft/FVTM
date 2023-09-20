package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.fexcraft.mod.fvtm.util.handler.DefaultPartInstallHandler.DPIHData;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;

public class ListenerServer implements IPacketListener<PacketNBTTagCompound> {
	
	public static ListenerServer INSTANCE;
	public ListenerServer(){ INSTANCE = this; }

	@Override
	public String getId(){
		return Resources.UTIL_LISTENER;
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayerMP player = (EntityPlayerMP)objs[0];
		switch(task){
			case "upg":{
				Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent != null && ent.getCapability(Capabilities.PASSENGER, null).seat() > -1){
					ent.getCapability(Capabilities.PASSENGER, null).update_packet();
				}
				return;
			}
			case "hot_install":{
				PartData data = player.getHeldItem(EnumHand.MAIN_HAND).getCapability(Capabilities.VAPDATA, null).getPartData();
				VehicleEntity entity = (VehicleEntity)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				PartSlots source = entity.getVehicleData().getPartSlotsProvider(packet.nbt.getString("source"));
				int index = packet.nbt.getInteger("index");
				String slot = source.get(index).category(packet.nbt.getString("source"));
				if(entity.getVehicleData().getPart(slot) != null){
					PartData oldpart = entity.getVehicleData().getPart(slot);
					boolean valid = oldpart.getType().getInstallHandlerData() instanceof DPIHData && ((DPIHData)oldpart.getType().getInstallHandlerData()).hotswap;
					//TODO if(valid && entity.getVehicleData().deinstallPart(Command.OTHER ? player : null, slot, true)){
					if(valid && entity.getVehicleData().deinstallPart(null, slot, true)){
						player.addItemStackToInventory(oldpart.getNewStack().local());
					}
					else return;
				}
				//TODO data = entity.getVehicleData().installPart(Command.OTHER ? player : null, data, "s:" + packet.nbt.getString("source") + ":" + slot + ":" + index, true);
				data = entity.getVehicleData().installPart(null, data, "s:" + packet.nbt.getString("source") + ":" + slot + ":" + index, true);
				if(data == null){
					player.getHeldItem(EnumHand.MAIN_HAND).shrink(1);
					NBTTagCompound compound = entity.getVehicleData().write(TagCW.create()).local();
					compound.setString("task", "update_vehicledata");
					PacketHandler.getInstance().sendToAllAround(new PacketEntityUpdate(entity.getEntity(), compound), Resources.getTargetPoint(entity.getEntity()));
				}
				return;
			}
			case "ts_ck_sync":{
				TrafficSigns signs = player.world.getChunk(packet.nbt.getInteger("x"), packet.nbt.getInteger("z")).getCapability(Capabilities.TRAFFIC_SIGNS, null);
				packet.nbt.setTag("signs", signs.write(null));
				PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(packet.nbt), player);
				return;
			}
			default: return;
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(new PacketNBTTagCompound(compound), new Object[]{ player });
	}

}
