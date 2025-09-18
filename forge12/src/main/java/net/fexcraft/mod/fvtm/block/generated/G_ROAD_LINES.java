package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD_LINES extends G_ROAD_MARKER {

	public G_ROAD_LINES(Block type){
		super(type);
		this.setDefaultState(this.blockState.getBaseState());
	}

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return getCurrentState(world, pos);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, getCurrentState(world, pos), 2);
    }

	private IBlockState getCurrentState(IBlockAccess level, BlockPos pos){
		boolean nc = isCompatible(level.getBlockState(pos.north()), level.getBlockState(pos.north().down()), level.getBlockState(pos.north().up()));
		boolean sc = isCompatible(level.getBlockState(pos.south()), level.getBlockState(pos.south().down()), level.getBlockState(pos.south().up()));
		boolean ec = isCompatible(level.getBlockState(pos.east()), level.getBlockState(pos.east().down()), level.getBlockState(pos.east().up()));
		boolean wc = isCompatible(level.getBlockState(pos.west()), level.getBlockState(pos.west().down()), level.getBlockState(pos.west().up()));
		int lines = (nc ? 1 : 0) + (sc ? 1 : 0) + (wc ? 1 : 0) + (ec ? 1 : 0);
		int lt = 0;
		int rot = 0;
		if(lines < 2){
			rot = nc || sc ? 0 : 1;
		}
		else if(lines == 2){
			if((nc && sc) || (wc && ec)){
				rot = nc ? 0 : 1;
			}
			if(nc && ec){
				lt = 1;
			}
			if(ec && sc){
				lt = 1;
				rot = 1;
			}
			if(sc && wc){
				lt = 1;
				rot = 2;
			}
			if(wc && nc){
				lt = 1;
				rot = 3;
			}
		}
		else if(lines == 3){
			lt = 2;
			if(!ec) rot = 1;
			if(!sc) rot = 2;
			if(!wc) rot = 3;
		}
		else{
			lt = 3;
		}
		return getDefaultState().withProperty(HEIGHT, getMarkerHeight(level, pos)).withProperty(LINE_TYPE, lt).withProperty(LINE_ROT, rot);
	}

	private boolean isCompatible(IBlockState... states){
		for(IBlockState state : states){
			if(isCompatible(state)) return true;
		}
		return false;
	}

	private boolean isCompatible(IBlockState state){
		if(state.getBlock() == this) return true;
		if(state.getBlock() instanceof PlainBase == false || type.getConnectsTo().isEmpty()) return false;
		net.fexcraft.mod.fvtm.data.block.Block blk = ((PlainBase)state.getBlock()).type;
		if(!blk.getBlockType().isRoadLayer() || blk.getConnectsTo().isEmpty()) return false;
		for(String ct : blk.getConnectsTo()){
			if(type.getConnectsTo().contains(ct)) return true;
		}
		return false;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
		return getCurrentState(world, pos);
	}

	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, LINE_TYPE, LINE_ROT, HEIGHT);
	}

}
