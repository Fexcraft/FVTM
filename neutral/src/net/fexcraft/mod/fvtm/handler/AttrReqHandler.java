package net.fexcraft.mod.fvtm.handler;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.handler.InteractionHandler.InteractRef;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.event.EventType;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrReqHandler {

	public static void processToggleRequest(EntityW pass, TagCW packet){
		boolean bool = packet.getBoolean("bool");
		Map.Entry<VehicleData, InteractRef> ref = ((FvtmWorld)pass.getWorld()).getInteractRef(packet);
		String attribute = packet.getString("attr");
		final Attribute<?> attr = ref.getKey().getAttribute(attribute);
		/*if(!attr.editable && !Perms.EDIT_INTERNAL_ATTRIBUTES.has(player) && (attr.hasPerm() ? !PermissionAPI.hasPermission(player, attr.perm) : true)){
			pass.send("No permission. [ED]");
			return;
		}
		if(player.getRidingEntity() != vehicle && !attr.external &&!Perms.EDIT_INTERNAL_ATTRIBUTES.has(player) && (attr.hasPerm() ? !PermissionAPI.hasPermission(player, attr.perm) : true)){
			pass.send("No permission. [EX]");
			return;
		}*///TODO perms
		toggleAttr(attr, bool, packet, false, null);
		Object syncval = attr.value();
		Packets.sendToAll(Packet_TagListener.class, "attr_toggle", packet);
		if(ref.getValue().isVehicle()){
			ref.getKey().getEventHolder().run(EventType.ATTRIBUTE_UPDATE, ref.getValue().vehicle(), pass, attr);
		}
		if(!attr.sync) return;
		if(ref.getKey().getType().getVehicleType().isRailVehicle()){
			/*RailVehicle rail = (RailVehicle)vehicle;
			Compound com = rail.rek.ent().getCompound();
			if(com.isSingular() || !com.isHead(rail.rek.ent()) && !com.isEnd(rail.rek.ent())) return;
			boolean mirror = attr.valuetype.isBoolean() && attr.group != null && attr.group.contains("mirror_lr");
			TagCW compound = packet.copy();
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
			}*///TODO
		}
		else{
			if(ref.getValue().vehicle() == null || ref.getValue().vehicle().front != null) return;
			VehicleInstance trailer = ref.getValue().vehicle().rear;
			while(trailer != null){
				Attribute<?> attr0 = trailer.data.getAttribute(attribute);
				if(attr0 != null){
					TagCW compound = packet.copy();
					toggleAttr(attr0, bool, compound, true, syncval);
					compound.set("entity", trailer.entity.getId());
					Packets.sendToAll(Packet_TagListener.class, "attr_toggle", packet);
				}
				trailer = trailer.rear;
			}
		}
	}

	/*private static void toggleAttrRailEnt(RailEntity ent, String attribute, boolean bool, TagCW compound, boolean b, Object syncval){
		Attribute<?> attr0 = ent.vehdata.getAttribute(attribute);
		if(attr0 == null) return;
		toggleAttr(attr0, bool, compound, true, syncval);
		if(ent.entity != null){
			compound.set("railid", ent.uid);
			compound.set("entity", ent.entity.getEntityId());
			Packets.sendToAll(Packet_TagListener.class, "attr_toggle", compound);
		}
	}*///TODO

	private static void toggleAttr(Attribute<?> attr, boolean bool, TagCW tag, boolean check, Object syncval){
		if(check && attr.sync){
			attr.set(syncval);
			return;
		}
		if(attr.valuetype.isTristate()){
			if(attr.valuetype.isBoolean() || !tag.has("reset")){
				attr.set(bool);
				tag.set("bool", attr.asBoolean());
			}
			else{
				attr.set(null);
				tag.set("reset", true);
			}
		}
		else if(attr.valuetype.isNumber()){
			attr.set(attr.valuetype.isInteger() ? tag.getInteger("value") : tag.getFloat("value"));
		}
		else{
			FvtmLogger.log("no code for toggling this attribute type yet");
		}
	}

	public static void processUpdateRequest(EntityW pass, TagCW packet){
		boolean reset = packet.has("reset") && packet.getBoolean("reset");
		Map.Entry<VehicleData, InteractRef> ref = ((FvtmWorld)pass.getWorld()).getInteractRef(packet);
		Attribute<?> attr = ref.getKey().getAttribute(packet.getString("attr"));
		/*if(!attr.editable && !Perms.EDIT_INTERNAL_ATTRIBUTES.has(pass) && (attr.hasPerm() ? !PermissionAPI.hasPermission(player, attr.perm) : true)){
			pass.send("No permission. [ED]");
			return;
		}
		if(pass.getRidingEntity() != vehicle && !attr.external &&!Perms.EDIT_INTERNAL_ATTRIBUTES.has(player) && (attr.hasPerm() ? !PermissionAPI.hasPermission(player, attr.perm) : true)){
			pass.send("No permission. [EX]");
			return;
		}*///TODO perms
		if(reset){
			attr.reset();
		}
		else{
			attr.set(attr.parse(packet.getString("value")));
		}
		sendAttrToggle(attr, ref.getValue());
		if(ref.getValue().isVehicle()){
			ref.getKey().getEventHolder().run(EventType.ATTRIBUTE_UPDATE, ref.getValue().vehicle(), pass, attr);
		}
	}

	public static void sendAttrToggle(Attribute<?> attr, InteractRef ref){
		if(attr == null) return;
		TagCW packet = TagCW.create();
		packet.set("attr", attr.id);
		ref.setPacket(packet);
		if(attr.valuetype.isTristate()){
			if(attr.asTristate() == null){
				packet.set("value", false);
				packet.set("reset", true);
			}
			else{
				packet.set("value", attr.asBoolean());
			}
		}
		else if(attr.valuetype.isFloat()){
			packet.set("value", attr.asFloat());
		}
		else if(attr.valuetype.isInteger()){
			packet.set("value", attr.asInteger());
		}
		else if(attr.valuetype.isString()){
			packet.set("value", attr.asString());
		}
		else packet.set("value", attr.asString());
		Packets.sendToAll(Packet_TagListener.class, "attr_update", packet);
	}

	public static void processToggleResponse(EntityW pass, TagCW packet){
		boolean bool = packet.getBoolean("bool");
		String attribute = packet.getString("attr");
		Attribute<?> attr = null;
		Map.Entry<VehicleData, InteractRef> ref = ((FvtmWorld)pass.getWorld()).getInteractRef(packet);
		if(ref == null){
			FvtmLogger.debug("Received packet for interact-ref not found on client side!");
		}
		if(ref.getValue().isVehicle() && packet.has("railid")){
			//RailEntity ent = SystemManager.get(Systems.RAIL, player.world, RailSystem.class).getEntity(packet.getLong("railid"), false);
			//attr = ent.vehdata.getAttribute(attribute);
		}
		attr = ref.getKey().getAttribute(attribute);
		if(attr.valuetype.isTristate()){
			if(attr.valuetype.isBoolean() || !packet.has("reset")) attr.set(bool);
			else attr.set(null);
		}
		else if(attr.valuetype.isNumber()){
			attr.set(attr.valuetype.isInteger() ? packet.getInteger("value") : packet.getFloat("value"));
		}
		else{
			FvtmLogger.log("no code for toggling this attribute type yet");
		}
	}

	public static void processUpdateResponse(EntityW pass, TagCW packet){
		Map.Entry<VehicleData, InteractRef> ref = ((FvtmWorld)pass.getWorld()).getInteractRef(packet);
		Attribute<?> attr = ref.getKey().getAttribute(packet.getString("attr"));
		if(attr.valuetype.isTristate()){
			if(packet.has("reset") && packet.getBoolean("reset")){
				attr.set(null);
			}
			else{
				attr.set(packet.getBoolean("value"));
			}
		}
		else if(attr.valuetype.isFloat()){
			attr.set(packet.getFloat("value"));
		}
		else if(attr.valuetype.isInteger()){
			attr.set(packet.getInteger("value"));
		}
		else if(attr.valuetype.isString()){
			attr.set(packet.getString("value"));
		}
		else attr.set(packet.getString("value"));
	}

}
