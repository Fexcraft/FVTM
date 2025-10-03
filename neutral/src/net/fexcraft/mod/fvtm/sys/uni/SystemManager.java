package net.fexcraft.mod.fvtm.sys.uni;

import java.io.File;
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
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.world.*;

import static net.fexcraft.mod.fvtm.Config.*;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class SystemManager {

	public static boolean SINGLEPLAYER;
	public static boolean CLIENTLOADED;
	private static ConcurrentHashMap<Systems, ConcurrentHashMap<String, DetachedSystem>> SYSTEMS_BY_ST = new ConcurrentHashMap<>();
	private static ConcurrentHashMap<String, ConcurrentHashMap<Systems, DetachedSystem>> SYSTEMS_BY_WT = new ConcurrentHashMap<>();
	private static ConcurrentHashMap<String, WorldW> WORLDS = new ConcurrentHashMap<>();
	
	public static void onServerTick(){
		for(ConcurrentHashMap<String, DetachedSystem> sys : SYSTEMS_BY_ST.values()){
			for(DetachedSystem det : sys.values()){
				det.onServerTick();
			}
		}
	}

	public static void onClientTick(){
		for(ConcurrentHashMap<String, DetachedSystem> sys : SYSTEMS_BY_ST.values()){
			for(DetachedSystem det : sys.values()){
				det.onClientTick();
			}
		}
	}

	public static void onChunkLoad(WorldW world, ChunkW chunk){
		if(!loaded(world.type().side_key())) initWorldSystems(world, world.type());
		if(chunk == null) return;
		for(DetachedSystem sys : SYSTEMS_BY_WT.get(world.type().side_key()).values()){
			sys.onChunkLoad(chunk);
		}
	}

	public static void onChunkUnload(WorldW world, ChunkW chunk){
		ConcurrentHashMap<Systems, DetachedSystem> systems = SYSTEMS_BY_WT.get(world.type().side_key());
		if(systems == null) return;
		for(DetachedSystem sys : systems.values()){
			sys.onChunkUnload(chunk);
		}
	}

	public static <T extends DetachedSystem> T get(Systems sysid, WorldW world){
		if(!SYSTEMS_BY_ST.containsKey(sysid)){
			if(!world.isClient()) return null;
			if(!SYSTEMS_BY_WT.containsKey(world.type().side_key())){
				initWorldSystems(world, world.type());
			}
			if(!SYSTEMS_BY_ST.containsKey(sysid)) return null;
		}
		return (T)SYSTEMS_BY_ST.get(sysid).get(world.type().side_key());
	}

	public static <T extends DetachedSystem> T get(Systems sysid, String key){
		if(!SYSTEMS_BY_ST.containsKey(sysid)){
			if(!EnvInfo.CLIENT) return null;
			if(!SYSTEMS_BY_WT.containsKey(key)){
				initWorldSystems(null, new WorldType(key));
			}
			if(!SYSTEMS_BY_ST.containsKey(sysid)) return null;
			return null;
		}
		return (T)SYSTEMS_BY_ST.get(sysid).get(key);
	}

	public static <T extends DetachedSystem> T get(Systems sysid, WorldW world, Class<T> clazz){
		return get(sysid, world);
	}

	private static boolean loaded(String skey){
		return WORLDS.containsKey(skey);
	}

	public static void initWorldSystems(WorldW world, WorldType type){
		if(loaded(type.side_key())) return;
		String tk = type.side_key();
		SINGLEPLAYER = WrapperHolder.isSinglePlayer();
		if(!SYSTEMS_BY_WT.containsKey(tk)) SYSTEMS_BY_WT.put(tk, new ConcurrentHashMap<>());
		FvtmLogger.debug("world type remote = " + type.client() + "/" + SINGLEPLAYER);
		File rootfolder = type.client() ? new File("./fvtm-temp/") : WrapperHolder.getWorldFolder(world, "fvtm");
		if(type.client() || SINGLEPLAYER){
			rootfolder.deleteOnExit();//TODO check this
			/*if(!SYSTEMS.containsKey(Systems.ENTITY)) SYSTEMS.put(Systems.ENTITY, new ConcurrentHashMap<>());
			EntitySystem ensys = new EntitySystem(world);
			SYSTEMS_BY_ST.get(Systems.ENTITY).put(tk, ensys);
			SYSTEMS_BY_WT.get(tk).put(Systems.ENTITY, ensys);*///TODO
		}
		//
		if(!DISABLE_RAILS){
			if(!SYSTEMS_BY_ST.containsKey(Systems.RAIL)) SYSTEMS_BY_ST.put(Systems.RAIL, new ConcurrentHashMap<>());
			RailSystem sys = new RailSystem(world, type, rootfolder);
			SYSTEMS_BY_ST.get(Systems.RAIL).put(tk, sys);
			SYSTEMS_BY_WT.get(tk).put(Systems.RAIL, sys);
		}
		//
		if(!DISABLE_WIRES){
			if(!SYSTEMS_BY_ST.containsKey(Systems.WIRE)) SYSTEMS_BY_ST.put(Systems.WIRE, new ConcurrentHashMap<>());
			WireSystem sys = new WireSystem(world, type, rootfolder);
			SYSTEMS_BY_ST.get(Systems.WIRE).put(tk, sys);
			SYSTEMS_BY_WT.get(tk).put(Systems.WIRE, sys);
		}
		if(!DISABLE_SIGNS){
			if(!SYSTEMS_BY_ST.containsKey(Systems.SIGN)) SYSTEMS_BY_ST.put(Systems.SIGN, new ConcurrentHashMap<>());
			SignSystem sys = new SignSystem(world, type, rootfolder);
			SYSTEMS_BY_ST.get(Systems.SIGN).put(tk, sys);
			SYSTEMS_BY_WT.get(tk).put(Systems.SIGN, sys);
		}
		//
		WORLDS.put(type.side_key(), world);
	}
	
	public static long getNextInterval(long interval){
		LocalDateTime midnight = LocalDateTime.of(LocalDate.now(ZoneOffset.systemDefault()), LocalTime.MIDNIGHT);
		long mid = midnight.toInstant(ZoneOffset.UTC).toEpochMilli(); long date = Time.getDate();
		while(mid < date) mid += interval;
		return mid;
	}

	public static void onServerStarting(){
		for(Map<String, DetachedSystem> entry : SYSTEMS_BY_ST.values()){
			for(DetachedSystem sys : entry.values()){
				sys.setupTimer(getNextInterval(sys.getTimerInterval()));
			}
		}
	}

	public static void onWorldLoad(WorldW world){
		for(DetachedSystem sys : SYSTEMS_BY_WT.get(world.type().side_key()).values()){
			sys.setupTimer(getNextInterval(sys.getTimerInterval()));
		}
	}

	public static void onServerStopping(){
		for(Map<String, DetachedSystem> entry : SYSTEMS_BY_ST.values()){
			for(DetachedSystem sys : entry.values()){
				sys.stopTimer();
				sys.unload();
			}
		}
		SYSTEMS_BY_ST.clear();
		SYSTEMS_BY_WT.clear();
		WORLDS.clear();
		SINGLEPLAYER = CLIENTLOADED = false;
	}

	public static void onWorldUnload(WorldW world){
		String skey = world.type().side_key();
		ConcurrentHashMap<Systems, DetachedSystem> map = SYSTEMS_BY_WT.get(skey);
		if(map != null){
			for(Entry<Systems, DetachedSystem> sys : map.entrySet()){
				sys.getValue().stopTimer();
				sys.getValue().unload();
				SYSTEMS_BY_ST.get(sys.getKey()).remove(skey);
			}
		}
		SYSTEMS_BY_WT.remove(skey);
		WORLDS.remove(skey);
	}

	public static void syncPlayer(String skey, EntityW entity){
		ConcurrentHashMap<Systems, DetachedSystem> sys = SYSTEMS_BY_WT.get(skey);
		if(sys == null) return;
		for(DetachedSystem value : sys.values()){
			value.syncPlayer(entity);
		}
	}

	/** Only safe to use on server side code, may return null client side. */
	public static WorldW getWorldW(String skey){
		return WORLDS.get(skey);
	}

	public static enum Systems {
		
		RAIL, ROAD, WIRE, ENTITY, SIGN
		
	}

	public static boolean active(Systems sys){
		return SYSTEMS_BY_ST.containsKey(sys);
	}

}
