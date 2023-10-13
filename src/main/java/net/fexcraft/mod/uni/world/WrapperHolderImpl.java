package net.fexcraft.mod.uni.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WrapperHolderImpl extends WrapperHolder {

	@Override
	public PlayerW getPlayer0(Object o){
		if(!PLAYERS.containsKey(o)){
			PLAYERS.put(o, new PlayerWI((EntityPlayer)o));
		}
		return PLAYERS.get(o);
	}

	@Override
	public EntityW getEntity0(Object o){
		if(!ENTITIES.containsKey(o)){
			ENTITIES.put(o, new EntityWI((Entity)o));
		}
		return ENTITIES.get(o);
	}

	@Override
	public WorldW getWorld0(Object o){
		if(!WORLDS.containsKey(o)){
			WORLDS.put(o, new WorldWI((World)o));
		}
		return WORLDS.get(o);
	}

}
