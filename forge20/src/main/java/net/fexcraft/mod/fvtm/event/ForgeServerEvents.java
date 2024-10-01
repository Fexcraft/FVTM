package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.UniChunk;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mod.EventBusSubscriber(modid = "fvtm", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeServerEvents {

	@SubscribeEvent
	public static void serverTick(TickEvent.ServerTickEvent event){
		if(event.phase != TickEvent.Phase.START) return;
		SystemManager.onServerTick();
	}

	@SubscribeEvent
	public static void onServerStarting(ServerStartingEvent event){
		SystemManager.onServerStarting();
	}

	@SubscribeEvent
	public static void onServerStopping(ServerStoppingEvent event){
		SystemManager.onServerStopping();
	}

	@SubscribeEvent
	public static void onChunkLoad(ChunkEvent.Load event){
		SystemManager.onChunkLoad(WrapperHolder.getWorld(event.getLevel()), UniChunk.getChunk(event.getChunk()));
	}

	@SubscribeEvent
	public static void onChunkUnload(ChunkEvent.Unload event){
		SystemManager.onChunkUnload(WrapperHolder.getWorld(event.getLevel()), UniChunk.getChunk(event.getChunk()));
	}

	@SubscribeEvent
	public static void onLevelLoad(LevelEvent.Load event){
		SystemManager.onWorldLoad(WrapperHolder.getWorld(event.getLevel()));
	}

	@SubscribeEvent
	public static void onLevelUnload(LevelEvent.Unload event){
		SystemManager.onWorldUnload(WrapperHolder.getWorld(event.getLevel()));
	}

}
