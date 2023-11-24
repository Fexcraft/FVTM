package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.block.BlockEntity;
import net.fexcraft.mod.fvtm.entity.BlockSeat;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import static net.fexcraft.mod.fvtm.util.AnotherUtil.toV3;

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

	@Override
	public boolean isTilePresent(V3I pos){
		return world.getTileEntity(new BlockPos(pos.x, pos.y, pos.z)) != null;
	}

	@Override
	public BlockEntity getBlockEntity(V3I pos){
		return (BlockEntity)world.getTileEntity(new BlockPos(pos.x, pos.y, pos.z));
	}

	@Override
	public <W> W local(){
		return (W)world;
	}

	@Override
	public Object direct(){
		return world;
	}

	@Override
	public void setBlockState(V3I pos, StateWrapper state, int flag) {
		world.setBlockState(new BlockPos(pos.x, pos.y, pos.z), state.local(), flag);
	}

	@Override
	public void spawnBlockSeat(V3D vec, EntityW player){
		BlockSeat seat = new BlockSeat(world);
		seat.setPosition(vec.x, vec.y, vec.z);
		world.spawnEntity(seat);
		((Entity)player.direct()).startRiding(seat);
	}

}
