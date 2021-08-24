package net.fexcraft.mod.fvtm.util.handler;

import java.util.HashMap;
import java.util.UUID;

import net.fexcraft.mod.fvtm.entity.RenderViewEntity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

/**
 * Render View Entity Storage/Handler
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RVStore {
	
	private static final HashMap<UUID, RenderViewEntity> ENTITIES = new HashMap<>();
	
	@SubscribeEvent
	public void onLogin(PlayerLoggedInEvent event){
		if(event.player.world.isRemote) return;
		RenderViewEntity entity = new RenderViewEntity(event.player);
		ENTITIES.put(event.player.getGameProfile().getId(), entity);
		event.player.world.spawnEntity(entity);
	}
	
	@SubscribeEvent
	public void onLogout(PlayerLoggedOutEvent event){
		if(event.player.world.isRemote) return;
		RenderViewEntity entity = ENTITIES.remove(event.player.getGameProfile().getId());
		if(entity != null) entity.setDead();
	}

}
