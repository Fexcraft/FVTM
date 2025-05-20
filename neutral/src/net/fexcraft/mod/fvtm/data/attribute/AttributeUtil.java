package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.sys.event.EventType;
import net.fexcraft.mod.fvtm.sys.rail.Compound;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.UniPerm;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.MessageSender;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttributeUtil {

	public static void processToggle(VehicleInstance vehicle, TagCW com, Passenger from){
		boolean bool = com.getBoolean("bool");
		String attrid = com.getString("attr");
		Attribute<?> attr = vehicle.data.getAttribute(attrid);
		if(attr == null){
			from.send("interact.fvtm.vehicle.attribute.not_found", attrid);
			return;
		}
		if(!attr.editable || attr.hasPerm()){
			boolean perm = attr.hasPerm() && UniPerm.has(from, attr.perm);
			if(!perm){
				from.send("interact.fvtm.vehicle.attribute." + (!attr.editable ? "not_editable" : "no_permission"));
				return;
			}
		}
		if(vehicle.getSeatOf(from) == null && !attr.external){
			from.send("interact.fvtm.vehicle.attribute.not_external");
			return;
		}
		Object oldval = attr.value();
		toggleAttr(from, attr, bool, com, false, null);
		Object syncval = attr.value();
		vehicle.sendUpdate(VehicleInstance.PKT_UPD_TOGGLE_ATTR, com);
		vehicle.data.getEventHolder().run(EventType.ATTRIBUTE_UPDATE, vehicle, from, attr);
		if(!attr.sync) return;
		if(vehicle.type.isRailVehicle()){
			if(vehicle.railent == null || vehicle.railent.getCompound().isSingular()) return;
			Compound rcom = vehicle.railent.getCompound();
			for(RailEntity ent : rcom.getEntitites()){
				if(ent == vehicle.railent) continue;
				attr = ent.vehicle.data.getAttribute(attrid);
				if(attr != null){
					com = TagCW.create();
					toggleAttr(FvtmLogger.NONE, attr, bool, com, true, syncval);
					if(ent.vehicle.entity != null){
						ent.vehicle.sendUpdate(VehicleInstance.PKT_UPD_TOGGLE_ATTR, com);
					}
				}
			}
		}
		else{
			if(vehicle.front != null) return;
			VehicleInstance trailer = vehicle.rear;
			while(trailer != null){
				attr = trailer.data.getAttribute(attrid);
				if(attr != null){
					com = TagCW.create();
					toggleAttr(FvtmLogger.NONE, attr, bool, com, true, syncval);
					trailer.sendUpdate(VehicleInstance.PKT_UPD_TOGGLE_ATTR, com);
				}
				trailer = trailer.rear;
			}
		}
	}

	private static void toggleAttr(MessageSender from, Attribute<?> attr, boolean bool, TagCW com, boolean check, Object syncval){
		if(check && attr.sync){
			attr.set(syncval);
			return;
		}
		if(attr.valuetype.isTristate()){
			if(attr.valuetype.isBoolean() || !com.has("reset")){
				attr.set(bool);
				com.set("bool", attr.asBoolean());
			}
			else{
				attr.set(null);
				com.set("reset", true);
			}
		}
		else if(attr.valuetype.isNumber()){
			attr.set(attr.valuetype.isInteger() ? com.getInteger("value") : com.getFloat("value"));
		}
		else{
			from.send("interact.fvtm.vehicle.attribute.not_supported");
		}
	}

	public static void processToggleClient(VehicleInstance vehicle, TagCW com, Passenger from){
		boolean bool = com.getBoolean("bool");
		String attrid = com.getString("attr");
		Attribute<?> attr = vehicle.data.getAttribute(attrid);
		if(attr.valuetype.isTristate()){
			if(attr.valuetype.isBoolean() || !com.has("reset")) attr.set(bool);
			else attr.set(null);
		}
		else if(attr.valuetype.isNumber()){
			attr.set(attr.valuetype.isInteger() ? com.getInteger("value") : com.getFloat("value"));
		}
		else{
			from.send("interact.fvtm.vehicle.attribute.not_supported");
		}
	}

}
