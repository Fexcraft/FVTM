package net.fexcraft.mod.uni.world;

import net.minecraft.entity.Entity;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EntityWI extends EntityW {

	protected Entity entity;
	protected WorldW world;

	public EntityWI(Entity ent){
		entity = ent;
		world = WrapperHolder.getWorld(ent.world);
	}

	@Override
	public boolean isOnClient(){
		return entity.world.isRemote;
	}

	@Override
	public int getId(){
		return entity.getEntityId();
	}

	@Override
	public WorldW getWorld(){
		return world;
	}

}
