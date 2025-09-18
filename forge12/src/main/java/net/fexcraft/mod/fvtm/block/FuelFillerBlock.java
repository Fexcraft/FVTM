package net.fexcraft.mod.fvtm.block;

import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
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

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerBlock extends Block implements ITileEntityProvider {

	public static FuelFillerBlock INSTANCE;
	public static ItemBlock ITEM;

    public FuelFillerBlock(){
        super(Material.ANVIL, MapColor.OBSIDIAN);
		setRegistryName("fvtm:fuel_filler");
		setTranslationKey(getRegistryName().toString());
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new FuelFillerEntity();
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote || hand == EnumHand.OFF_HAND || player.isSneaking()) return false;
		UniEntity.getEntity(player).openUI(UIKeys.FUEL_FILLER, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

}

