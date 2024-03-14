package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.util.handler.AttrReqHandler;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;

import static net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler.*;
import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;

public class ListenerServer implements IPacketListener<PacketNBTTagCompound> {
	
	public static ListenerServer INSTANCE;
	public ListenerServer(){ INSTANCE = this; }

	@Override
	public String getId(){
		return UTIL_LISTENER;
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
			case "install":{
				PartData data = player.getHeldItem(EnumHand.MAIN_HAND).getCapability(Capabilities.VAPDATA, null).getPartData();
				RootVehicle entity = (RootVehicle)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				PartSlots source = entity.vehicle.data.getPartSlotsProvider(packet.nbt.getString("source"));
				String category = packet.nbt.getString("category");
				if(entity.vehicle.data.getPart(category) != null){
					PartData oldpart = entity.vehicle.data.getPart(category);
					boolean valid = oldpart.getType().getInstallHandlerData() instanceof DPIHData && ((DPIHData)oldpart.getType().getInstallHandlerData()).swappable;
					if(valid && entity.vehicle.data.deinstallPart(player.getCapability(Capabilities.PASSENGER, null).asSender(), category, true)){
						player.addItemStackToInventory(oldpart.getNewStack().local());
					}
					else return;
				}
				data = entity.vehicle.data.installPart(player.getCapability(Capabilities.PASSENGER, null).asSender(), data, packet.nbt.getString("source") + ":" + category, true);
				if(data == null){
					player.getHeldItem(EnumHand.MAIN_HAND).shrink(1);
					NBTTagCompound compound = entity.vehicle.data.write(TagCW.create()).local();
					compound.setString("task", "update_vehicledata");
					PacketHandler.getInstance().sendToAllAround(new PacketEntityUpdate(entity, compound), PacketsImpl.getTargetPoint(entity));
				}
				return;
			}
			case "ts_ck_sync":{
				TrafficSigns signs = player.world.getChunk(packet.nbt.getInteger("x"), packet.nbt.getInteger("z")).getCapability(Capabilities.TRAFFIC_SIGNS, null);
				packet.nbt.setTag("signs", signs.write(null));
				PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(packet.nbt), player);
				return;
			}
			case "attr_toggle":{
				AttrReqHandler.processToggleRequest(player.world, player, packet.nbt);
				return;
			}
			case "attr_update":{
				AttrReqHandler.processUpdateRequest(player.world, player, packet.nbt);
				return;
			}
			case "vehicle":{
				RootVehicle vehicle = (RootVehicle)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				if(vehicle == null) return;
				vehicle.vehicle.packet(TagCW.wrap(packet.nbt), player.getCapability(Capabilities.PASSENGER, null).asWrapper());
				return;
			}
			default: return;
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(new PacketNBTTagCompound(compound), new Object[]{ player });
	}

}
