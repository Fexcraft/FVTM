package net.fexcraft.mod.fvtm.sys.event;

import net.fexcraft.mod.fvtm.data.root.Soundable;
import net.fexcraft.mod.fvtm.data.root.Soundable.SoundHolder;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventHolder {

	public HashMap<EventType, ArrayList<EventListener>> listeners = new LinkedHashMap<>();
	public HashMap<String, EventHolder> subholders = new LinkedHashMap<>();
	public SoundHolder sounds;
	public Object root;

	public EventHolder(Object root){
		this.root = root;
		sounds = (SoundHolder)root;
	}

	public void integrate(EventHolder holder, String origin){
		if(origin == null){
			for(Map.Entry<EventType, ArrayList<EventListener>> entry : holder.listeners.entrySet()){
				if(!listeners.containsKey(entry.getKey())) listeners.put(entry.getKey(), new ArrayList<>());
				listeners.get(entry.getKey()).addAll(entry.getValue());
			}
		}
		else subholders.put(origin, holder);
	}

	public void deintegrate(EventHolder holder, String origin){
		if(origin == null){
			ArrayList<EventListener> lis;
			for(Map.Entry<EventType, ArrayList<EventListener>> entry : holder.listeners.entrySet()){
				lis = listeners.get(entry.getKey());
				if(lis == null) continue;
				lis.removeAll(entry.getValue());
			}
			listeners.entrySet().removeIf(entry -> entry.getValue().isEmpty());
		}
		else{
			if(subholders.containsKey(origin)) subholders.remove(origin);
		}
	}

	public void insert(EventListener lis){
		if(!listeners.containsKey(lis.type)) listeners.put(lis.type, new ArrayList<>());
		listeners.get(lis.type).add(lis);
	}

	public void run(EventType event, VehicleInstance inst, Passenger pass, Object... args){
		if(listeners.containsKey(event)){
			for(EventListener lis : listeners.get(event)){
				if(lis.cond.isMet(EventAction.DATA.set(inst, pass, this, this))){
					lis.action.run(EventAction.DATA, lis, args);
				}
			}
		}
		for(EventHolder hol : subholders.values()){
			if(!hol.listeners.containsKey(event)) continue;
			for(EventListener lis : hol.listeners.get(event)){
				if(lis.cond.isMet(EventAction.DATA.set(inst, pass, this, hol))){
					lis.action.run(EventAction.DATA, lis, args);
				}
			}
		}
	}

}
