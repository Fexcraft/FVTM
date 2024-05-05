package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import static net.fexcraft.mod.fvtm.util.Properties.FACING;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleLiftBlock extends Block implements ITileEntityProvider {

    public static VehicleLiftBlock INSTANCE;
    public static ItemBlock ITEM;

	public VehicleLiftBlock(){
		super(Material.ANVIL, MapColor.OBSIDIAN);
		setRegistryName("fvtm:vehicle_lift");
		setTranslationKey(getRegistryName().toString());
		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new VehicleLiftEntity();
	}

	@Override
	public boolean isFullBlock(IBlockState state){
		return false;
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
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}

	@Override
	public IBlockState getStateFromMeta(int meta){
		EnumFacing facing = EnumFacing.byIndex(meta);
		facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
		return getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return state.getValue(FACING).getIndex();
	}

	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, FACING);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity tile, ItemStack stack){
		super.harvestBlock(world, player, pos, state, tile, stack);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(world.isRemote || hand == EnumHand.OFF_HAND) return false;
		if(player.isSneaking()){
			VehicleLiftEntity tile = (VehicleLiftEntity)world.getTileEntity(pos);
			if(tile != null){
				tile.setVehicle(ItemStack.EMPTY);
				return true;
			}
			return true;
		}
		if(player.getHeldItemMainhand().getItem() instanceof VehicleItem){
			VehicleLiftEntity tile = (VehicleLiftEntity)world.getTileEntity(pos);
			if(tile != null){
				tile.setVehicle(player.getHeldItemMainhand());
				if(!player.capabilities.isCreativeMode) player.getHeldItemMainhand().shrink(1);
				return true;
			}
		}
		return true;
	}

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

}
