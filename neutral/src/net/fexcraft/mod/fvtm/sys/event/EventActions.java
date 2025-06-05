package net.fexcraft.mod.fvtm.sys.event;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Sound;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventActions {

	public static List<EventAction> JUNC_PASS_ACTIONS = new ArrayList<>();
	public static List<EventAction> JUNC_SIGNAL_ACTIONS = new ArrayList<>();
	public static List<EventAction> JUNC_SWITCH_ACTIONS = new ArrayList<>();

	public static EventAction init(){
		new EventAction("logger").set((data, lis, objs) ->{
			String str = lis.argString();
			str = str.replace("{event}", lis.type.key);
			if(lis.type.equals(EventType.ATTRIBUTE_UPDATE)){
				str = str.replace("{attr}", ((Attribute)objs[0]).id);
				str = str.replace("{value}", ((Attribute)objs[0]).asString());
			}
			if(lis.type.key.startsWith("rail_")){
				str = str.replace("{junction}", data.holder.junction().posString());
			}
			FvtmLogger.log(str);
		});
		new EventAction("msg").set((data, lis, objs) ->{
			if(data.pass == null) return;
			String str = lis.argString();
			str = str.replace("{event}", lis.type.key);
			if(lis.type.equals(EventType.ATTRIBUTE_UPDATE)){
				str = str.replace("{attr}", ((Attribute)objs[0]).id);
				str = str.replace("{value}", ((Attribute)objs[0]).asString());
			}
			if(lis.type.key.startsWith("rail_")){
				str = str.replace("{junction}", data.holder.junction().posString());
			}
			data.pass.send(str);
		});
		//
		new EventAction("play_sound").set((data, lis, objs) -> {
			String ori = lis.args.length > 1 ? lis.args[1] : null;
			String sound = lis.args[0];
			Sound s = null;
			if(ori != null){
				PartData part = data.vehicle.getPart(ori);
				if(part != null) s = part.getType().getSounds().get(sound);
			}
			if(s == null) s = data.sounds().getSounds().get(sound);
			if(s != null) data.vehent.entity.playSound(s.event, s.volume, s.pitch);
		});
		new EventAction("start_sound").set((data, lis, objs) -> {
			String sound = lis.args[0];
			Sound s = data.sounds().getSounds().get(sound);
			if(s != null) data.vehent.startSound(sound);
		});
		new EventAction("stop_sound").set((data, lis, objs) -> {
			data.vehent.stopSound(lis.args[0]);
		});
		//
		new EventAction("set_attr").set((data, lis, objs) -> {
			Attribute attr = data.vehicle.getAttribute(lis.args[0]);
			if(attr != null){
				attr.set(lis.args[1]);
				if(data.vehent != null) data.vehent.updateAttr(lis.args[0]);
			}
		});
		new EventAction("reset_attr").set((data, lis, objs) -> {
			Attribute attr = data.vehicle.getAttribute(lis.args[0]);
			if(attr != null){
				attr.reset();
				if(data.vehent != null) data.vehent.updateAttr(lis.args[0]);
			}
		});
		new EventAction("set_throttle").set((data, lis, objs) -> {
			float am = Float.parseFloat(lis.args[0]);
			if(am < -1) am = -1;
			if(am > 1) am = 1;
			if(data.vehent.railent != null){
				data.vehent.railent.setThrottle(am);
			}
			else data.vehent.throttle = am;
		});
		JUNC_PASS_ACTIONS.add(EventAction.parse("set_attr"));
		JUNC_PASS_ACTIONS.add(EventAction.parse("reset_attr"));
		JUNC_SIGNAL_ACTIONS.add(EventAction.parse("set_attr"));
		JUNC_SIGNAL_ACTIONS.add(EventAction.parse("reset_attr"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("set_attr"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("reset_attr"));
		//
		new EventAction("rail_reverse").set((data, lis, objs) -> {
			data.vehent.railent.setForward(data.pass, !data.vehent.railent.getCompound().forward);
		});
		JUNC_PASS_ACTIONS.add(EventAction.parse("rail_reverse"));
		JUNC_PASS_ACTIONS.add(EventAction.parse("set_throttle"));
		//
		new EventAction("rail_fork2_bool").set((data, lis, objs) -> {
			data.holder.junction().switch0 = Boolean.parseBoolean(lis.args[0]);
		});
		new EventAction("rail_fork3_bool").set((data, lis, objs) -> {
			data.holder.junction().switch0 = Boolean.parseBoolean(lis.args[0]);
			data.holder.junction().switch1 = Boolean.parseBoolean(lis.args[1]);
		});
		new EventAction("rail_double_bool").set((data, lis, objs) -> {
			data.holder.junction().switch0 = Boolean.parseBoolean(lis.args[0]);
			data.holder.junction().switch1 = Boolean.parseBoolean(lis.args[1]);
		});
		new EventAction("rail_double_bool0").set((data, lis, objs) -> {
			data.holder.junction().switch0 = Boolean.parseBoolean(lis.args[0]);
		});
		new EventAction("rail_double_bool1").set((data, lis, objs) -> {
			data.holder.junction().switch1 = Boolean.parseBoolean(lis.args[0]);
		});
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_fork2_bool"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_fork3_bool"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_double_bool"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_double_bool0"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_double_bool1"));
		//
		new EventAction("rail_fork2_switch").set((data, lis, objs) -> {
			data.holder.junction().switch0 = lis.args[0].charAt(0) == '1';
		});
		new EventAction("rail_fork3_switch").set((data, lis, objs) -> {
			data.holder.junction().switch0 = lis.args[0].charAt(0) == '1';
			data.holder.junction().switch1 = lis.args[0].charAt(0) == '3';
		});
		new EventAction("rail_double_switch").set((data, lis, objs) -> {
			data.holder.junction().switch0 = lis.args[0].charAt(0) == '1';
			data.holder.junction().switch1 = lis.args[1].charAt(0) == '0';
		});
		new EventAction("rail_double_switch0").set((data, lis, objs) -> {
			data.holder.junction().switch0 = lis.args[0].charAt(0) == '1';
		});
		new EventAction("rail_double_switch1").set((data, lis, objs) -> {
			data.holder.junction().switch1 = lis.args[0].charAt(0) == '0';
		});
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_fork2_switch"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_fork3_switch"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_double_switch"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_double_switch0"));
		JUNC_SWITCH_ACTIONS.add(EventAction.parse("rail_double_switch1"));
		//
		return new EventAction("none").set((d, l, o) -> {});
	}

}
