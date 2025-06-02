package net.fexcraft.mod.fvtm.sys.event;

import org.apache.logging.log4j.util.TriConsumer;

import java.util.LinkedHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventAction {

	public static LinkedHashMap<String, EventAction> ACTIONS = new LinkedHashMap<>();
	public static EventData DATA = new EventData();
	public static EventAction NONE = EventActions.init();
	public final String key;
	private TriConsumer<EventData, EventListener, Object[]> consumer;

	protected EventAction(String ky){
		key = ky;
		ACTIONS.put(key, this);
	}

	public EventAction set(TriConsumer<EventData, EventListener, Object[]> cons){
		consumer = cons;
		return this;
	}

	public static EventAction parse(String type){
		for(EventAction et : ACTIONS.values()){
			if(et.key.equals(type)) return et;
		}
		return NONE;
	}

	public void run(EventData data, EventListener lis, Object[] objs){
		consumer.accept(data, lis, objs);
	}

}
