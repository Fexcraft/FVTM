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

	public static EventData DATA = new EventData();
	public static LinkedHashMap<String, EventAction> ACTIONS = new LinkedHashMap<>();
	public static EventAction NONE = new EventAction("none");
	public static EventAction LOGGER = new EventAction("logger").set((data, lis, args) ->{
		String str = lis.args[0];
		if(lis.args.length > 1) for(int i = 1; i < lis.args.length; i++) str += " " + lis.args[i];
		FvtmLogger.log(str);
	});
	public static EventAction SEND_MSG = new EventAction("msg").set((data, lis, args) ->{
		if(data.pass == null) return;
		String str = lis.args[0];
		if(lis.args.length > 1) for(int i = 1; i < lis.args.length; i++) str += " " + lis.args[i];
		if(lis.type.equals(EventType.ATTRIBUTE_UPDATE)){
			str = str.replace("{attr}", ((Attribute)args[0]).id);
			str = str.replace("{value}", ((Attribute)args[0]).asString());
		}
		data.pass.send(str);
	});
	public static EventAction SET_ATTR = new EventAction("set_attr").set((data, lis, args) -> {
		Attribute attr = data.vehicle.getAttribute(lis.args[0]);
		if(attr != null){
			attr.set(lis.args[1]);
			if(data.vehent != null) data.vehent.sendUpdate(VehicleInstance.PKT_UPD_VEHICLEDATA);//TODO packet to update only attribute
		}
	});
	public static EventAction RESET_ATTR = new EventAction("reset_attr").set((data, lis, args) -> {
		Attribute attr = data.vehicle.getAttribute(lis.args[0]);
		if(attr != null){
			attr.reset();
			if(data.vehent != null) data.vehent.sendUpdate(VehicleInstance.PKT_UPD_VEHICLEDATA);//TODO packet to update only attribute
		}
	});
	public static EventAction PLAY_SOUND = new EventAction("play_sound").set((data, lis, args) -> {
		String ori = lis.args.length > 1 ? lis.args[1] : null;
		String sound = lis.args[0];
		Sound s = null;
		if(ori != null){
			PartData part = data.vehicle.getPart(ori);
			if(part != null) s = part.getType().getSounds().get(sound);
		}
		if(s == null) s = data.holder.sounds.getSounds().get(sound);
		if(s != null) data.vehent.entity.playSound(s.event, s.volume, s.pitch);
	});
	public static EventAction START_SOUND = new EventAction("start_sound").set((data, lis, args) -> {
		String sound = lis.args[0];
		Sound s = data.holder.sounds.getSounds().get(sound);
		if(s != null) data.vehent.startSound(sound);
	});
	public static EventAction STOP_SOUND = new EventAction("stop_sound").set((data, lis, args) -> {
		data.vehent.stopSound(lis.args[0]);
	});

	public final String key;
	private TriConsumer<EventData, EventListener, Object[]> consumer;

	private EventAction(String ky){
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

	public void run(EventData data, EventListener lis, Object[] args){
		consumer.accept(data, lis, args);
	}

}
