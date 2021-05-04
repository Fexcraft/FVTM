package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.rail.Compound;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.vis.RailVehicle;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil.Implementation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ServerReceiver implements IPacketListener<PacketNBTTagCompound> {

	public static ServerReceiver INSTANCE;

	public ServerReceiver(){
		INSTANCE = this;
	}

	@Override
	public String getId(){
		return GuiHandler.LISTENERID;
	}

	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		String task = packet.nbt.getString("task");
		EntityPlayerMP player = (EntityPlayerMP)objs[0];
		World world = objs[0] == null ? (World)objs[1] : player.world;
		switch(task){
			case "attr_toggle":{
				boolean bool = packet.nbt.getBoolean("bool");
				VehicleEntity veh = (VehicleEntity)world.getEntityByID(packet.nbt.getInteger("entity"));
				String attribute = packet.nbt.getString("attr");
				final Attribute<?> attr = veh.getVehicleData().getAttribute(attribute);
				Object old = attr.value();
				toggleAttr(attr, bool, packet.nbt, false, null);
				Object syncval = attr.value();
				PacketHandler.getInstance().sendToAllAround(packet, Resources.getTargetPoint(veh.getEntity()));
				if(veh.getVehicleType().isRailVehicle()){
					RailVehicle rail = (RailVehicle)veh;
					Compound com = rail.rek.ent().getCompound();
					if(!com.isHead(rail.rek.ent()) && !com.isEnd(rail.rek.ent())) return;
					for(RailEntity ent : com.getEntitites()){
						if(ent == rail.rek.ent()) continue;
						Attribute<?> attr0 = ent.vehdata.getAttribute(attribute);
						if(attr0 == null) continue;
						NBTTagCompound compound = packet.nbt.copy();
						toggleAttr(attr0, bool, compound, true, syncval);
						if(ent.entity != null){
							compound.setLong("railid", ent.uid);
							compound.setInteger("entity", ent.entity.getEntityId());
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
							toggleAttr(attr0, bool, compound, true, syncval);
							compound.setInteger("entity", trailer.getEntity().getEntityId());
							PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(trailer.getEntity()));
						}
						trailer = trailer.getRearCoupledEntity();
					}
				}
				veh.getVehicleData().getScripts().forEach(script -> {
					script.onAttributeToggle(veh.getEntity(), attr, old, player);
				});
				break;
			}
			case "attr_update":{
				VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.nbt.getInteger("entity"));
				Attribute<?> attr = veh.getVehicleData().getAttribute(packet.nbt.getString("attr"));
				// TODO other checks?
				attr.value(attr.parseValue(packet.nbt.getString("value")));
				packet.nbt.setString("value", attr.string_value());
				PacketHandler.getInstance().sendToAllAround(packet, Resources.getTargetPoint(veh.getEntity()));
				break;
			}
			case "update_container_holder":{
				Entity ent = world.getEntityByID(packet.nbt.getInteger("entity"));
				if(ent == null){
					Print.debug("Entity not found. CHP " + packet.nbt.getInteger("entity"));
					return;
				}
				ContainerHolderUtil.Implementation impl = (Implementation)ent.getCapability(Capabilities.CONTAINER, null);
				if(impl == null) Print.debug("Capability is null. CHP " + packet.nbt.getInteger("entity"));
				else impl.sync(false);
				return;
			}
			case "update_region":
				Static.stop();
				return;
			case "open_gui":{
				if(packet.nbt.hasKey("data")){
					GuiHandler.SERVER_GUIDATA_CACHE.put(player.getGameProfile().getId().toString(), packet.nbt.getCompoundTag("data"));
					PacketHandler.getInstance().sendTo(packet, player);
				}
				int gui = packet.nbt.getInteger("gui");
				int[] args = packet.nbt.hasKey("args") ? packet.nbt.getIntArray("args") : new int[3];
				player.openGui(FVTM.getInstance(), gui, player.world, args[0], args[1], args[2]);
				return;
			}
			// TODO validation
			case "toggle_seat":{
				GenericVehicle veh = (GenericVehicle)world.getEntityByID(packet.nbt.getInteger("entity"));
				int seatindex = packet.nbt.getInteger("seat");
				if(seatindex < 0 || seatindex >= veh.seats.length) return;
				veh.seats[packet.nbt.getInteger("seat")].processInteract(player, packet.nbt.getBoolean("main") ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND);
				return;
			}
			default:
				return;
		}
	}

	private void toggleAttr(Attribute<?> attr, boolean bool, NBTTagCompound nbt, boolean check, Object syncval){
		if(check && attr.sync()){
			attr.value(syncval);
			return;
		}
		if(attr.valuetype().isTristate()){
			if(attr.valuetype().isBoolean() || !nbt.hasKey("reset")){
				attr.value(bool);
				nbt.setBoolean("bool", attr.boolean_value());
			}
			else{
				attr.value(null);
				nbt.setBoolean("reset", true);
			}
		}
		else if(attr.valuetype().isNumber()){
			attr.value(attr.valuetype().isInteger() ? nbt.getInteger("value") : nbt.getFloat("value"));
		}
		else{
			Print.log("no code for toggling this attribute type yet");
		}
	}

	public void process(NBTTagCompound compound, EntityPlayer player){
		this.process(compound, player, null);
	}

	public void process(NBTTagCompound compound, EntityPlayer player, World world){
		this.process(new PacketNBTTagCompound(compound), new Object[] { player, world == null ? player.world : world });
	}

}
