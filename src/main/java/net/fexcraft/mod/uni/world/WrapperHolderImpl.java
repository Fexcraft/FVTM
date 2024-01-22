package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WrapperHolderImpl extends WrapperHolder {

	@Override
	public EntityW getEntity0(Object o){
		return ((Entity)o).getCapability(Capabilities.PASSENGER, null).asWrapper();
	}

	@Override
	public WorldW getWorld0(Object o){
		if(o == null) return null;
		if(!WORLDS.containsKey(o)){
			WORLDS.put(o, new WorldWI((World)o));
		}
		return WORLDS.get(o);
	}

	@Override
	public V3I getPos0(Object o){
		BlockPos pos = (BlockPos)o;
		return new V3I(pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public BlockSide getSide0(Object o){
		EnumFacing facing = (EnumFacing)o;
		switch(facing){
			case UP: return BlockSide.UP;
			case DOWN: return BlockSide.DOWN;
			case NORTH: return BlockSide.NORTH;
			case WEST: return BlockSide.WEST;
			case EAST: return BlockSide.EAST;
			case SOUTH: return BlockSide.SOUTH;
		}
		return BlockSide.NORTH;
	}

}
