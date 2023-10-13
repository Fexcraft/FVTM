package net.fexcraft.mod.uni.world;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PlayerWI extends EntityWI implements PlayerW {

	public PlayerWI(EntityPlayer ent){
		super(ent);
	}

	@Override
	public String getName(){
		return ((EntityPlayer)entity).getName();
	}

	@Override
	public UUID getUUID(){
		return ((EntityPlayer)entity).getGameProfile().getId();
	}

}
