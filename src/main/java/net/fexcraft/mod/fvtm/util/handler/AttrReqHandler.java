package net.fexcraft.mod.fvtm.util.handler;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.rail.Compound;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.vis.RailVehicle;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.Perms;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.server.permission.PermissionAPI;

public class AttrReqHandler {

	public static void processToggleRequest(World world, EntityPlayerMP player, NBTTagCompound packet){
		boolean bool = packet.getBoolean("bool");
		VehicleEntity veh = (VehicleEntity)world.getEntityByID(packet.getInteger("entity"));
		String attribute = packet.getString("attr");
		final Attribute<?> attr = veh.getVehicleData().getAttribute(attribute);
		if(!attr.editable() && !Perms.EDIT_INTERNAL_ATTRIBUTES.has(player) && (attr.hasPerm() ? !PermissionAPI.hasPermission(player, attr.perm()) : true)){
			Print.chat(player, "No permission. [ED]");
			return;
		}
		if(player.getRidingEntity() != veh.getEntity() && !attr.external() &&!Perms.EDIT_INTERNAL_ATTRIBUTES.has(player) && (attr.hasPerm() ? !PermissionAPI.hasPermission(player, attr.perm()) : true)){
			Print.chat(player, "No permission. [EX]");
			return;
		}
		Object old = attr.value();
		toggleAttr(attr, bool, packet, false, null);
		Object syncval = attr.value();
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(packet), Resources.getTargetPoint(veh.getEntity()));
		veh.getVehicleData().getScripts().forEach(script -> {
			script.onAttributeToggle(veh.getEntity(), attr, old, player);
		});
		if(!attr.sync()) return;
		if(veh.getVehicleType().isRailVehicle()){
			RailVehicle rail = (RailVehicle)veh;
			Compound com = rail.rek.ent().getCompound();
			if(com.isSingular() || !com.isHead(rail.rek.ent()) && !com.isEnd(rail.rek.ent())) return;
			boolean mirror = attr.valuetype().isBoolean() && attr.group() != null && attr.group().contains("mirror_lr");
			NBTTagCompound compound = packet.copy();
			if(mirror){
				com.forEachMirror(com.isHead(rail.rek.ent()), new String[]{ attribute }, flip -> {
					if(flip[0].contains("left")){
						flip[0] = flip[0].replace("left", "right");
					}
					else{
						flip[0] = flip[0].replace("right", "left");
					}
				}, pass -> {}, (ent, val) -> {
					compound.setString("attr", val[0]);
					toggleAttrRailEnt(ent, val[0], bool, compound, true, syncval);
				});
			}
			else{
				for(RailEntity ent : com.getEntitites()){
					if(ent == rail.rek.ent()) continue;
					toggleAttrRailEnt(ent, attribute, bool, compound, true, syncval);
				}
			}
		}
		else{
			if(veh.getFrontCoupledEntity() != null) return;
			VehicleEntity trailer = veh.getRearCoupledEntity();
			while(trailer != null){
				Attribute<?> attr0 = trailer.getVehicleData().getAttribute(attribute);
				if(attr0 != null){
					NBTTagCompound compound = packet.copy();
					toggleAttr(attr0, bool, compound, true, syncval);
					compound.setInteger("entity", trailer.getEntity().getEntityId());
					PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(trailer.getEntity()));
				}
				trailer = trailer.getRearCoupledEntity();
			}
		}
	}

	private static void toggleAttrRailEnt(RailEntity ent, String attribute, boolean bool, NBTTagCompound compound, boolean b, Object syncval){
		Attribute<?> attr0 = ent.vehdata.getAttribute(attribute);
		if(attr0 == null) return;
		toggleAttr(attr0, bool, compound, true, syncval);
		if(ent.entity != null){
			compound.setLong("railid", ent.uid);
			compound.setInteger("entity", ent.entity.getEntityId());
			PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(ent.entity));
		}
	}

	private static void toggleAttr(Attribute<?> attr, boolean bool, NBTTagCompound nbt, boolean check, Object syncval){
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

	public static void processUpdateRequest(World world, EntityPlayerMP player, NBTTagCompound packet){
		boolean reset = packet.hasKey("reset") && packet.getBoolean("reset");
		VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.getInteger("entity"));
		Attribute<?> attr = veh.getVehicleData().getAttribute(packet.getString("attr"));
		if(!attr.editable() && !Perms.EDIT_INTERNAL_ATTRIBUTES.has(player) && (attr.hasPerm() ? !PermissionAPI.hasPermission(player, attr.perm()) : true)){
			Print.chat(player, "No permission. [ED]");
			return;
		}
		if(player.getRidingEntity() != veh.getEntity() && !attr.external() &&!Perms.EDIT_INTERNAL_ATTRIBUTES.has(player) && (attr.hasPerm() ? !PermissionAPI.hasPermission(player, attr.perm()) : true)){
			Print.chat(player, "No permission. [EX]");
			return;
		}
		if(reset){
			attr.reset();
		}
		else{
			attr.value(attr.parseValue(packet.getString("value")));
		}
		((GenericVehicle)veh).sendAttributeUpdate(attr);
	}

	public static void processToggleResponse(World world, EntityPlayer player, NBTTagCompound packet){
		boolean bool = packet.getBoolean("bool");
		String attribute = packet.getString("attr");
		Attribute<?> attr = null;
		VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.getInteger("entity"));
		if(veh == null && packet.hasKey("railid")){
			RailEntity ent = SystemManager.get(Systems.RAIL, player.world, RailSystem.class).getEntity(packet.getLong("railid"), false);
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
			if(attr.valuetype().isBoolean() || !packet.hasKey("reset")) attr.value(bool);
			else attr.value(null);
		}
		else if(attr.valuetype().isNumber()){
			attr.value(attr.valuetype().isInteger() ? packet.getInteger("value") : packet.getFloat("value"));
		}
		else{
			Print.log("no code for toggling this attribute type yet");
		}
	}

	public static void processUpdateResponse(World world, EntityPlayer player, NBTTagCompound packet){
		VehicleEntity veh = (VehicleEntity)player.world.getEntityByID(packet.getInteger("entity"));
		Attribute<?> attr = veh.getVehicleData().getAttribute(packet.getString("attr"));
		if(attr.valuetype().isTristate()){
			if(packet.hasKey("reset") && packet.getBoolean("reset")){
				attr.value(null);
			}
			else{
				attr.value(packet.getBoolean("value"));
			}
		}
		else if(attr.valuetype().isFloat()){
			attr.value(packet.getFloat("value"));
		}
		else if(attr.valuetype().isInteger()){
			attr.value(packet.getInteger("value"));
		}
		else if(attr.valuetype().isString()){
			attr.value(packet.getString("value"));
		}
		else attr.value(packet.getString("value"));
	}

}
