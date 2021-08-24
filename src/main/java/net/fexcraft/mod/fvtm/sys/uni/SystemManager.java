package net.fexcraft.mod.fvtm.sys.uni;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
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
	public static HashMap<Systems, HashMap<Integer, DetachedSystem>> SYSTEMS = new HashMap<>();
	public static HashMap<Integer, HashMap<Systems, DetachedSystem>> SYSTEMS_DIM = new HashMap<>();
	
	public static void onServerTick(World world){
		for(DetachedSystem sys : SYSTEMS_DIM.get(world.provider.getDimension()).values()){
			sys.onServerTick();
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
		SYSTEMS_DIM.put(dim, new HashMap<>());
		if(!Config.DISABLE_RAILS){
			if(!SYSTEMS.containsKey(Systems.RAIL)) SYSTEMS.put(Systems.RAIL, new HashMap<>());
			RailSys sys = new RailSys(event.getObject());
			SYSTEMS.get(Systems.RAIL).put(dim, sys);
			SYSTEMS_DIM.get(dim).put(Systems.RAIL, sys);
		}
	}

	public static void onServerStarting(FMLServerStartingEvent event){
		LocalDateTime midnight = LocalDateTime.of(LocalDate.now(ZoneOffset.systemDefault()), LocalTime.MIDNIGHT);
		long mid = midnight.toInstant(ZoneOffset.UTC).toEpochMilli(); long date = Time.getDate();
		while((mid += Config.UNLOAD_INTERVAL) < date);
		for(HashMap<Integer, DetachedSystem> entry : SYSTEMS.values()){
			for(DetachedSystem sys : entry.values()){
				sys.setupTimer(mid);
			}
		}
	}

	public static void onServerStopping(FMLServerStoppingEvent event){
		for(HashMap<Integer, DetachedSystem> entry : SYSTEMS.values()){
			for(DetachedSystem sys : entry.values()){
				sys.stopTimer();
				sys.unload();
			}
		}
	}
	
	public static enum Systems {
		
		RAIL, ROAD, WIRE
		
	}

}
