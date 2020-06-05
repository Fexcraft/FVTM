package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.FCL;
import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.rail.Compound;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.vis.RailVehicle;
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
		return GuiHandler.LISTENERID;
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayerMP player = (EntityPlayerMP)objs[0];
		switch(task){
			case "attr_toggle":{
				boolean bool = packet.nbt.getBoolean("bool");
				VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				String attribute = packet.nbt.getString("attr");
				final Attribute<?> attr = veh.getVehicleData().getAttribute(attribute);
				Object old = attr.getValue();
				if(attr.type().isTristate()){
					if(attr.type().isBoolean() || !packet.nbt.hasKey("reset")){
						attr.setValue(bool); packet.nbt.setBoolean("bool", attr.getBooleanValue());
					}
					else{
						attr.setValue(null); packet.nbt.setBoolean("reset", true);
					}
					PacketHandler.getInstance().sendToAllAround(packet, Resources.getTargetPoint(veh.getEntity()));
					if(veh.getVehicleType().isRailVehicle()){
						RailVehicle reil = (RailVehicle)veh;
						Compound com = reil.rek.ent().getCompound();
						if(!com.isHead(reil.rek.ent()) && !com.isEnd(reil.rek.ent())) return;
						for(RailEntity ent : com.getEntitites()){
							if(ent.entity != null){
								Attribute<?> attr0 = ent.vehdata.getAttribute(attribute); if(attr0 == null) continue;
								NBTTagCompound compound = packet.nbt.copy(); 
								if(attr0.type().isBoolean() || !packet.nbt.hasKey("reset")){
									attr0.setValue(bool); compound.setBoolean("bool", attr0.getBooleanValue());
								}
								else{
									attr0.setValue(null); compound.setBoolean("reset", true);
								}
								PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(ent.entity));
							}
						}
					}
					else{
						if(veh.getFrontCoupledEntity() != null) return;
						VehicleEntity trailer = veh.getRearCoupledEntity();
						while(trailer != null){
							Attribute<?> attr0 = trailer.getVehicleData().getAttribute(attribute);
							if(attr0 != null){
								NBTTagCompound compound = packet.nbt.copy();
								if(attr0.type().isBoolean() || !packet.nbt.hasKey("reset")){
									attr0.setValue(bool); compound.setBoolean("bool", attr0.getBooleanValue());
								}
								else{
									attr0.setValue(null); compound.setBoolean("reset", true);
								}
								PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(trailer.getEntity()));
							}
							trailer = trailer.getRearCoupledEntity();
						}
					}
				}
				else if(attr.type().isNumber()){
					attr.setValue(attr.type().isInteger() ? packet.nbt.getInteger("value") : packet.nbt.getFloat("value"));
					PacketHandler.getInstance().sendToAllAround(packet, Resources.getTargetPoint(veh.getEntity()));
					if(veh.getVehicleType().isRailVehicle()){
						RailVehicle reil = (RailVehicle)veh;
						Compound com = reil.rek.ent().getCompound();
						if(!com.isHead(reil.rek.ent()) && !com.isEnd(reil.rek.ent())) return;
						for(RailEntity ent : com.getEntitites()){
							if(ent.entity != null){
								Attribute<?> attr0 = ent.vehdata.getAttribute(attribute); if(attr0 == null) continue;
								NBTTagCompound compound = packet.nbt.copy();
								attr0.setValue(attr0.type().isInteger() ? packet.nbt.getInteger("value") : packet.nbt.getFloat("value"));
								PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(ent.entity));
							}
						}
					}
					else{
						if(veh.getFrontCoupledEntity() != null) return;
						VehicleEntity trailer = veh.getRearCoupledEntity();
						while(trailer != null){
							Attribute<?> attr0 = trailer.getVehicleData().getAttribute(attribute);
							if(attr0 != null){
								NBTTagCompound compound = packet.nbt.copy();
								attr0.setValue(attr0.type().isInteger() ? packet.nbt.getInteger("value") : packet.nbt.getFloat("value"));
								PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(trailer.getEntity()));
							}
							trailer = trailer.getRearCoupledEntity();
						}
					}
				}
				else{
					//TODO
					Print.log("no code for toggling this attribute type yet");
				}
				veh.getVehicleData().getScripts().forEach(script -> {
					script.onAttributeToggle(veh.getEntity(), attr, old, player);
				});
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
			case "update_region": Static.stop(); return;
			case "open_gui":{
                if(packet.nbt.hasKey("data")){
                	GuiHandler.SERVER_GUIDATA_CACHE.put(player.getGameProfile().getId().toString(), packet.nbt.getCompoundTag("data"));
                	PacketHandler.getInstance().sendTo(packet, player);
                }
                int gui = packet.nbt.getInteger("gui");
                int[] args = packet.nbt.hasKey("args") ? packet.nbt.getIntArray("args") : new int[3];
                player.openGui(FCL.getInstance(), gui, player.world, args[0], args[1], args[2]);
				return;
			}
			default: return;
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(new PacketNBTTagCompound(compound), new Object[]{ player });
	}

}
