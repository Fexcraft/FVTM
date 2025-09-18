package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;
import static net.fexcraft.mod.fvtm.data.block.Block.BLK_GETTER_CACHE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class G_ROAD_PATTERN extends G_ROAD_MARKER {

	public PropertyInteger prop_x;
	public PropertyInteger prop_z;
	public int texx;
	public int texz;
	private int sizex;
	private int sizez;
	private int defx;
	private int defz;

	public G_ROAD_PATTERN(Block type){
		super(type);
		this.setDefaultState(this.blockState.getBaseState());
	}

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		EnumFacing rot = facing;
		if(type.isRandomRot()) rot = EnumFacing.values()[Static.random.nextInt(4) + 2];
		else if(placer != null) rot = placer.getHorizontalFacing();
		return getActualState(getDefaultState().withProperty(FACING, rot).withProperty(PATTERN_ROOT, false), world, pos);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, getStateForPlacement(world, pos, EnumFacing.NORTH, 0, 0, 0, stack.getMetadata(), placer), 2);
    }

	@Override
	public IBlockState getStateFromMeta(int meta){
		EnumFacing facing = EnumFacing.byHorizontalIndex(meta % 4);
		return this.getDefaultState().withProperty(FACING, facing).withProperty(PATTERN_ROOT, meta >= 4);
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return state.getValue(FACING).getHorizontalIndex() * (state.getValue(PATTERN_ROOT) ? 2 : 1);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
		int[] xz = { defx, defz };
		EnumFacing rot = state.getValue(FACING);
		if(!state.getValue(PATTERN_ROOT)){
			IBlockState n = getSamePattern(getPatternAt(world, pos.north()));
			IBlockState w = getSamePattern(getPatternAt(world, pos.west()));
			IBlockState s = getSamePattern(getPatternAt(world, pos.south()));
			IBlockState e = getSamePattern(getPatternAt(world, pos.east()));
			if(n == null && w == null && s == null && e == null){
				state = state.withProperty(PATTERN_ROOT, true);
			}
			else{
				switch(rot){
					case NORTH: rot = setPatternPos(rot, xz, n, w, s, e); break;
					case SOUTH: rot = setPatternPos(rot, xz, s, e, n, w); break;
					case EAST: rot = setPatternPos(rot, xz, e, n, w, s); break;
					case WEST: rot = setPatternPos(rot, xz, w, s, e, n); break;
				}
			}
		}
		return state.withProperty(HEIGHT, getMarkerHeight(world, pos)).withProperty(FACING, rot)
			.withProperty(prop_x, xz[0]).withProperty(prop_z, xz[1]);
	}

	@Override
	protected BlockStateContainer createBlockState(){
		JsonArray arr = BLK_GETTER_CACHE.getCustomStates().get("pattern_x").asArray();
		prop_x = FvtmProperties.PATTERN_X.get(sizex = arr.get(0).integer_value());
		defx = arr.get(1).integer_value();
		texx = arr.get(2).integer_value();
		arr = BLK_GETTER_CACHE.getCustomStates().get("pattern_z").asArray();
		prop_z = FvtmProperties.PATTERN_Z.get(sizez = arr.get(0).integer_value());
		defz = arr.get(1).integer_value();
		texz = arr.get(2).integer_value();
		return new BlockStateContainer(this, FACING, HEIGHT, PATTERN_ROOT, prop_x, prop_z);
	}

	private EnumFacing setPatternPos(EnumFacing rot, int[] xz, IBlockState n, IBlockState w, IBlockState s, IBlockState e){
		if(n != null){
			xz[0] = n.getValue(prop_x);
			xz[1] = n.getValue(prop_z) + 1;
			if(xz[1] >= sizez) xz[1] = 0;
			if(xz[1] < 0) xz[1] = sizez - 1;
			return n.getValue(FACING);
		}
		if(w != null){
			xz[0] = w.getValue(prop_x) + 1;
			xz[1] = w.getValue(prop_z);
			if(xz[0] >= sizex) xz[0] = 0;
			if(xz[0] < 0) xz[0] = sizex - 1;
			return w.getValue(FACING);
		}
		if(s != null){
			xz[0] = s.getValue(prop_x);
			xz[1] = s.getValue(prop_z) - 1;
			if(xz[1] >= sizez) xz[1] = 0;
			if(xz[1] < 0) xz[1] = sizez - 1;
			return s.getValue(FACING);
		}
		if(e != null){
			xz[0] = e.getValue(prop_x) - 1;
			xz[1] = e.getValue(prop_z);
			if(xz[0] >= sizex) xz[0] = 0;
			if(xz[0] < 0) xz[0] = sizex - 1;
			return e.getValue(FACING);
		}
		return rot;
	}

	private IBlockState getSamePattern(IBlockState state){
		return state != null && ((PlainBase)state.getBlock()).type == type ? state : null;
	}

	private IBlockState getPatternAt(IBlockAccess level, BlockPos pos){
		IBlockState state = level.getBlockState(pos);
		if(state.getBlock() instanceof G_ROAD_PATTERN) return state;
		state = level.getBlockState(pos.down());
		if(state.getBlock() instanceof G_ROAD_PATTERN) return state;
		state = level.getBlockState(pos.up());
		return state.getBlock() instanceof G_ROAD_PATTERN ? state : null;
	}

}
