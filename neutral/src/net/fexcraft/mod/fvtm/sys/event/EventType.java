package net.fexcraft.mod.fvtm.sys.event;

import java.util.LinkedHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventType {

	public static LinkedHashMap<String, EventType> TYPES = new LinkedHashMap<>();
	public static EventType VEHICLE_SPAWN = new EventType("vehicle_spawn");
	public static EventType VEHICLE_DESPAWN = new EventType("vehicle_despawn");
	public static EventType ATTRIBUTE_UPDATE = new EventType("attr_update");
	public static EventType PART_INSTALL = new EventType("part_install");
	public static EventType PART_UNINSTALL = new EventType("part_deinstall");

	public final String key;

	private EventType(String ky){
		key = ky;
		TYPES.put(key, this);
	}

	public static EventType parse(String type){
		for(EventType et : TYPES.values()){
			if(et.key.equals(type)) return et;
		}
		return ATTRIBUTE_UPDATE;
	}

}
