package net.fexcraft.mod.fvtm.sys.event;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.attribute.AttributeUtil;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import org.apache.logging.log4j.util.TriConsumer;

import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventAction {

	public static LinkedHashMap<String, EventAction> ACTIONS = new LinkedHashMap<>();
	public static EventData DATA = new EventData();
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
		return EventActions.NONE;
	}

	public void run(EventData data, EventListener lis, Object[] args){
		consumer.accept(data, lis, args);
	}

}
