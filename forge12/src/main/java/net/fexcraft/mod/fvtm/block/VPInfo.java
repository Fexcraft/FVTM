package net.fexcraft.mod.fvtm.block;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.util.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//@fBlock(modid = FVTM.MODID, name = "vpinfo")
public class VPInfo extends Block {
	
	public static VPInfo INSTANCE = null;

	public VPInfo(){
		super(Material.ROCK, MapColor.GRAY);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(1.0F);
		this.setResistance(1000.0F);
		this.setSoundType(SoundType.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        INSTANCE = this;
	}

    @Override
    public boolean isFullBlock(IBlockState state){
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return true;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing facing = EnumFacing.byIndex(meta);
        facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[]{ FACING });
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
    	if(world.isRemote || player.isSneaking()) return true;
    	player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_AND_PART_INFO, world, 0, 0, 0);
    	return true;
    }
    
}