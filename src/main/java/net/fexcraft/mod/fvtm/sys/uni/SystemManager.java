package net.fexcraft.mod.fvtm.sys.uni;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class SystemManager {

	public static boolean SINGLEPLAYER, PLAYERON;
	private static HashMap<Systems, HashMap<Integer, DetachedSystem>> SYSTEMS = new HashMap<>();
	private static HashMap<Integer, HashMap<Systems, DetachedSystem>> SYSTEMS_DIM = new HashMap<>();
	
	public static void onServerTick(World world){
		if(world == null || !SYSTEMS_DIM.containsKey(world.provider.getDimension())) return;
		for(DetachedSystem sys : SYSTEMS_DIM.get(world.provider.getDimension()).values()){
			sys.onServerTick();
		}
	}

	public static void onClientTick(World world){
		if(world == null || !SYSTEMS_DIM.containsKey(world.provider.getDimension())) return;
		for(DetachedSystem sys : SYSTEMS_DIM.get(world.provider.getDimension()).values()){
			sys.onClientTick();
		}
	}

	public static void onChunkLoad(World world, Chunk chunk){
		for(DetachedSystem sys : SYSTEMS_DIM.get(world.provider.getDimension()).values()){
			sys.onChunkLoad(chunk);
		}
	}

	public static void onChunkUnload(World world, Chunk chunk){
		for(DetachedSystem sys : SYSTEMS_DIM.get(world.provider.getDimension()).values()){
			sys.onChunkUnload(chunk);
		}
	}

	public static <T extends DetachedSystem> T get(Systems sysid, World world){
		if(!SYSTEMS.containsKey(sysid)) return null;
		return (T)SYSTEMS.get(sysid).get(world.provider.getDimension());
	}

	public static <T extends DetachedSystem> T get(Systems sysid, World world, Class<T> clazz){
		if(!SYSTEMS.containsKey(sysid)) return null;
		return (T)SYSTEMS.get(sysid).get(world.provider.getDimension());
	}

	public static void onAttachWorldCapabilities(AttachCapabilitiesEvent<World> event){
		SINGLEPLAYER = Static.getServer() != null && Static.getServer().isSinglePlayer();
		int dim = event.getObject().provider.getDimension();
		if(!SYSTEMS_DIM.containsKey(dim)) SYSTEMS_DIM.put(dim, new HashMap<>());
		if(event.getObject().isRemote){
			if(!SYSTEMS.containsKey(Systems.ENTITY)) SYSTEMS.put(Systems.ENTITY, new HashMap<>());
			EntitySystem ensys = new EntitySystem(event.getObject());
			SYSTEMS.get(Systems.ENTITY).put(dim, ensys);
			SYSTEMS_DIM.get(dim).put(Systems.ENTITY, ensys);
		}
		else{
			if(!Config.DISABLE_RAILS){
				if(!SYSTEMS.containsKey(Systems.RAIL)) SYSTEMS.put(Systems.RAIL, new HashMap<>());
				RailSystem sys = new RailSystem(event.getObject());
				SYSTEMS.get(Systems.RAIL).put(dim, sys);
				SYSTEMS_DIM.get(dim).put(Systems.RAIL, sys);
			}
			if(!Config.DISABLE_WIRES){
				if(!SYSTEMS.containsKey(Systems.WIRE)) SYSTEMS.put(Systems.WIRE, new HashMap<>());
				WireSystem sys = new WireSystem(event.getObject());
				SYSTEMS.get(Systems.WIRE).put(dim, sys);
				SYSTEMS_DIM.get(dim).put(Systems.WIRE, sys);
			}
		}
	}
	
	private static long getDate(){
		LocalDateTime midnight = LocalDateTime.of(LocalDate.now(ZoneOffset.systemDefault()), LocalTime.MIDNIGHT);
		long mid = midnight.toInstant(ZoneOffset.UTC).toEpochMilli(); long date = Time.getDate();
		while((mid += Config.UNLOAD_INTERVAL) < date);
		return mid;
	}

	public static void onServerStarting(FMLServerStartingEvent event){
		long mid = getDate();
		for(HashMap<Integer, DetachedSystem> entry : SYSTEMS.values()){
			for(DetachedSystem sys : entry.values()){
				sys.setupTimer(mid);
			}
		}
	}

	public static void onWorldLoad(World world){
		long mid = getDate();
		for(DetachedSystem sys : SYSTEMS_DIM.get(world.provider.getDimension()).values()){
			sys.setupTimer(mid);
		}
	}

	public static void onServerStopping(FMLServerStoppingEvent event){
		for(HashMap<Integer, DetachedSystem> entry : SYSTEMS.values()){
			for(DetachedSystem sys : entry.values()){
				sys.stopTimer();
				sys.unload();
			}
		}
		SYSTEMS.clear();
		SYSTEMS_DIM.clear();
	}

	/** Called client side. */
	public static void onWorldUnload(World world){
		int dim = world.provider.getDimension();
		for(Entry<Systems, DetachedSystem> sys : SYSTEMS_DIM.get(dim).entrySet()){
			sys.getValue().stopTimer();
			sys.getValue().unload();
			SYSTEMS.get(sys.getKey()).remove(dim);
		}
		SYSTEMS_DIM.remove(dim);
	}
	
	public static enum Systems {
		
		RAIL, ROAD, WIRE, ENTITY
		
	}

	public static boolean active(Systems sys){
		return SYSTEMS.containsKey(sys);
	}

}
