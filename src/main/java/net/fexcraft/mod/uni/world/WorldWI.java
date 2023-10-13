package net.fexcraft.mod.uni.world;

import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WorldWI extends WorldW {

	private World world;

	public WorldWI(World level){
		world = level;
	}

	@Override
	public boolean isClient(){
		return world.isRemote;
	}

}
