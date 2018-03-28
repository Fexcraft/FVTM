package net.fexcraft.mod.fvtm.blocks;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "container_block", tileentity = ContainerTileEntity.class)
public class ContainerBlock extends BlockContainer {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static ContainerBlock INSTANCE;

	public ContainerBlock(){
		super(Material.IRON, MapColor.BLACK);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(Tabs.BLOCKS);
		this.setSoundType(SoundType.METAL);
		//
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(50.0F);
        this.setResistance(280.0F);
        //
        INSTANCE = this;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new ContainerTileEntity();
	}
	
    @Override
	public boolean isFullBlock(IBlockState state){
		return true;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
        return false;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
        return false;
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return FULL_BLOCK_AABB;
    }

	@Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos){
        return FULL_BLOCK_AABB;
    }
	
	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

	@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, state, 2);
        ((ContainerTileEntity)world.getTileEntity(pos)).setUp(placer, stack);
    }
    
	@Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        if (enumfacing.getAxis() == EnumFacing.Axis.Y){
            enumfacing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
	
	@Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	
	@Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state){
		if(!world.isRemote){
			ContainerTileEntity tile = (ContainerTileEntity)world.getTileEntity(pos);
			tile.notifyBreak(world, pos, state);
		}
		super.breakBlock(world, pos, state);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			ContainerTileEntity te = (ContainerTileEntity)world.getTileEntity(pos);
			if(te == null){
				Print.chat(player, "No TileEntity found.");
				return true;
			}
			if(!te.isCore() && te.getCorePos() == null){
				Print.chat(player, "Linked Core block is null! Removing...");
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
				return true;
			}
			//TODO open GUI
		}
		return false;
	}
	
	public static ArrayList<BlockPos> getPositions(ContainerData data, BlockPos pos, EnumFacing facing){
		ArrayList<BlockPos> list = new ArrayList<BlockPos>();
		facing = rotate90(facing);
		BlockPos core = new BlockPos(pos);
		int length = data.getContainer().isLargeContainer() ? 12 : 6;
		int xhl = facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH ? 1 : length / 2;
		int zhl = facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH ? length / 2 : 1;
		for(int x = -xhl; x < xhl * 2; x++){
			for(int y = 0; y < 3; y++){
				for(int z = -zhl; z < zhl * 2; z++){
					list.add(core.add(x, y, z));
				}
			}
		}
		return list;
	}
	
	public static EnumFacing rotate90(EnumFacing facing){
		switch(facing){
			case DOWN:  return EnumFacing.DOWN;
			case EAST:  return EnumFacing.SOUTH;
			case NORTH: return EnumFacing.EAST;
			case SOUTH: return EnumFacing.WEST;
			case UP:    return EnumFacing.UP;
			case WEST:  return EnumFacing.NORTH;
			default: return null;
		}
	}
	
}