package net.fexcraft.mod.fvtm.sys.uni;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.Config.DISABLE_WIRES;
import static net.fexcraft.mod.fvtm.Config.UNLOAD_INTERVAL;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class SystemManager {

	public static boolean SINGLEPLAYER, PLAYERON;
	private static ConcurrentHashMap<Systems, ConcurrentHashMap<Object, DetachedSystem>> SYSTEMS = new ConcurrentHashMap<>();
	private static ConcurrentHashMap<Object, ConcurrentHashMap<Systems, DetachedSystem>> SYSTEMS_DIM = new ConcurrentHashMap<>();
	private static ConcurrentHashMap<Object, Boolean> LOADED_DIM = new ConcurrentHashMap<>();
	
	public static void onServerTick(){
		for(ConcurrentHashMap<Object, DetachedSystem> sys : SYSTEMS.values()){
			for(DetachedSystem det : sys.values()){
				det.onServerTick();
			}
		}
	}

	public static void onClientTick(){
		for(ConcurrentHashMap<Object, DetachedSystem> sys : SYSTEMS.values()){
			for(DetachedSystem det : sys.values()){
				det.onClientTick();
			}
		}
	}

	public static void onChunkLoad(WorldW world, ChunkW chunk){
		if(!loaded(world.dimkey())) onAttachWorldCapabilities(world);
		for(DetachedSystem sys : SYSTEMS_DIM.get(world.dimkey()).values()){
			sys.onChunkLoad(chunk);
		}
	}

	public static void onChunkUnload(WorldW world, ChunkW chunk){
		ConcurrentHashMap<Systems, DetachedSystem> systems = SYSTEMS_DIM.get(world.dimkey());
		if(systems == null) return;
		for(DetachedSystem sys : systems.values()){
			sys.onChunkUnload(chunk);
		}
	}

	public static <T extends DetachedSystem> T get(Systems sysid, WorldW world){
		if(!SYSTEMS.containsKey(sysid)) return null;
		return (T)SYSTEMS.get(sysid).get(world.dimkey());
	}

	public static <T extends DetachedSystem> T get(Systems sysid, WorldW world, Class<T> clazz){
		if(!SYSTEMS.containsKey(sysid)) return null;
		return (T)SYSTEMS.get(sysid).get(world.dimkey());
	}

	private static boolean loaded(Object dimension){
		Boolean bool = LOADED_DIM.get(dimension);
		return bool != null && bool;
	}

	public static void onAttachWorldCapabilities(WorldW world){
		if(loaded(world.dimkey())) return;
		SINGLEPLAYER = WrapperHolder.isSinglePlayer();
		Object dim = world.dimkey();
		if(!SYSTEMS_DIM.containsKey(dim)) SYSTEMS_DIM.put(dim, new ConcurrentHashMap<>());
		FvtmLogger.debug("dimension remote = " + world.isClient() + "/" + SINGLEPLAYER);
		if(world.isClient() || SINGLEPLAYER){
			/*if(!SYSTEMS.containsKey(Systems.ENTITY)) SYSTEMS.put(Systems.ENTITY, new ConcurrentHashMap<>());
			EntitySystem ensys = new EntitySystem(world);
			SYSTEMS.get(Systems.ENTITY).put(dim, ensys);
			SYSTEMS_DIM.get(dim).put(Systems.ENTITY, ensys);*///TODO
		}
		//
		if(!DISABLE_RAILS){
			if(!SYSTEMS.containsKey(Systems.RAIL)) SYSTEMS.put(Systems.RAIL, new ConcurrentHashMap<>());
			RailSystem sys = new RailSystem(world);
			SYSTEMS.get(Systems.RAIL).put(dim, sys);
			SYSTEMS_DIM.get(dim).put(Systems.RAIL, sys);
		}
		//
		if(!DISABLE_WIRES){
			if(!SYSTEMS.containsKey(Systems.WIRE)) SYSTEMS.put(Systems.WIRE, new ConcurrentHashMap<>());
			/*WireSystem sys = new WireSystem(world);
			SYSTEMS.get(Systems.WIRE).put(dim, sys);
			SYSTEMS_DIM.get(dim).put(Systems.WIRE, sys);*///TODO
		}
		//
		LOADED_DIM.put(dim, true);
	}
	
	private static long getDate(){
		LocalDateTime midnight = LocalDateTime.of(LocalDate.now(ZoneOffset.systemDefault()), LocalTime.MIDNIGHT);
		long mid = midnight.toInstant(ZoneOffset.UTC).toEpochMilli(); long date = Time.getDate();
		while((mid += UNLOAD_INTERVAL) < date);
		return mid;
	}

	public static void onServerStarting(){
		long mid = getDate();
		for(Map<Object, DetachedSystem> entry : SYSTEMS.values()){
			for(DetachedSystem sys : entry.values()){
				sys.setupTimer(mid);
			}
		}
	}

	public static void onWorldLoad(WorldW world){
		long mid = getDate();
		for(DetachedSystem sys : SYSTEMS_DIM.get(world.dimkey()).values()){
			sys.setupTimer(mid);
		}
	}

	public static void onServerStopping(){
		for(Map<Object, DetachedSystem> entry : SYSTEMS.values()){
			for(DetachedSystem sys : entry.values()){
				sys.stopTimer();
				sys.unload();
			}
		}
		SYSTEMS.clear();
		SYSTEMS_DIM.clear();
		LOADED_DIM.clear();
	}

	/** Called client side. */
	public static void onWorldUnload(WorldW world){
		Object dim = world.dimkey();
		ConcurrentHashMap<Systems, DetachedSystem> map = SYSTEMS_DIM.get(dim);
		if(map != null){
			for(Entry<Systems, DetachedSystem> sys : map.entrySet()){
				sys.getValue().stopTimer();
				sys.getValue().unload();
				SYSTEMS.get(sys.getKey()).remove(dim);
			}
		}
		SYSTEMS_DIM.remove(dim);
		LOADED_DIM.remove(dim);
	}
	
	public static enum Systems {
		
		RAIL, ROAD, WIRE, ENTITY
		
	}

	public static boolean active(Systems sys){
		return SYSTEMS.containsKey(sys);
	}

}
