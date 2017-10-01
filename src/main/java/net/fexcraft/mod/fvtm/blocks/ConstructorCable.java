package net.fexcraft.mod.fvtm.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.util.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//@fBlock(modid = FVTM.MODID, name = "landvehicle_constructor_cable")
public class ConstructorCable extends Block {
	
	public ConstructorCable(){
    	super(Material.IRON);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(5.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(Tabs.BLOCKS);
    	this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
    }
	
	public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[]{
    		new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D),
    		new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.375D, 0.625D, 1.0D, 1.0D),
    		new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 0.625D),
    		new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.625D, 1.0D, 0.625D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D),
    		new AxisAlignedBB(0.375D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D),
    		new AxisAlignedBB(0.375D, 0.0D, 0.375D, 1.0D, 1.0D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 1.0D),
    		new AxisAlignedBB(0.375D, 0.0D, 0.0D, 1.0D, 1.0D, 0.625D),
    		new AxisAlignedBB(0.375D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.625D),
    		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)
    	};
    public static final AxisAlignedBB PILLAR_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 0.03125D, 0.625D);
    public static final AxisAlignedBB SOUTH_AABB  = new AxisAlignedBB(0.375D, 0.0D, 0.625D, 0.625D, 0.03125D,   1.0D);
    public static final AxisAlignedBB WEST_AABB   = new AxisAlignedBB(  0.0D, 0.0D, 0.375D, 0.375D, 0.03125D, 0.625D);
    public static final AxisAlignedBB NORTH_AABB  = new AxisAlignedBB(0.375D, 0.0D,   0.0D, 0.625D, 0.03125D, 0.375D);
    public static final AxisAlignedBB EAST_AABB   = new AxisAlignedBB(0.625D, 0.0D, 0.375D,   1.0D, 0.03125D, 0.625D);
    
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean b){
        if(!b){
            state = state.getActualState(worldIn, pos);
        }
        addCollisionBoxToList(pos, entityBox, collidingBoxes, PILLAR_AABB);
        if(((Boolean)state.getValue(NORTH)).booleanValue()){
            addCollisionBoxToList(pos, entityBox, collidingBoxes, NORTH_AABB);
        }
        if(((Boolean)state.getValue(EAST)).booleanValue()){
            addCollisionBoxToList(pos, entityBox, collidingBoxes, EAST_AABB);
        }
        if(((Boolean)state.getValue(SOUTH)).booleanValue()){
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SOUTH_AABB);
        }
        if(((Boolean)state.getValue(WEST)).booleanValue()){
            addCollisionBoxToList(pos, entityBox, collidingBoxes, WEST_AABB);
        }
    }
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        state = this.getActualState(state, source, pos);
        return BOUNDING_BOXES[getBoundingBoxIdx(state)];
    }
	
	private static int getBoundingBoxIdx(IBlockState state){
        int i = 0;
        if(((Boolean)state.getValue(NORTH)).booleanValue()){
            i |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }
        if(((Boolean)state.getValue(EAST)).booleanValue()){
            i |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }
        if(((Boolean)state.getValue(SOUTH)).booleanValue()){
            i |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }
        if(((Boolean)state.getValue(WEST)).booleanValue()){
            i |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }
        return i;
    }
	
	public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    public boolean isFullCube(IBlockState state){
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos){
        return false;
    }

    public boolean canConnectTo(IBlockAccess world, BlockPos pos){
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        return block == Blocks.BARRIER ? false : (block instanceof ConstructorCable || block instanceof ConstructorController || block instanceof ConstructorCenter ? true : false);
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side){
        return true;
    }
    
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(!worldIn.isRemote){
            return ItemLead.attachToFence(playerIn, worldIn, pos);
        }
        else{
            ItemStack itemstack = playerIn.getHeldItem(hand);
            return itemstack.getItem() == Items.LEAD || itemstack.isEmpty();
        }
    }
    
    public int getMetaFromState(IBlockState state){
        return 0;
    }
    
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos){
        return state.withProperty(NORTH, canFenceConnectTo(worldIn, pos, EnumFacing.NORTH))
                .withProperty(EAST, canFenceConnectTo(worldIn, pos, EnumFacing.EAST))
                .withProperty(SOUTH, canFenceConnectTo(worldIn, pos, EnumFacing.SOUTH))
                .withProperty(WEST, canFenceConnectTo(worldIn, pos, EnumFacing.WEST));
    }
    
    public IBlockState withRotation(IBlockState state, Rotation r){
        switch (r){
            case CLOCKWISE_180:
                return state.withProperty(NORTH, state.getValue(SOUTH)).withProperty(EAST, state.getValue(WEST)).withProperty(SOUTH, state.getValue(NORTH)).withProperty(WEST, state.getValue(EAST));
            case COUNTERCLOCKWISE_90:
                return state.withProperty(NORTH, state.getValue(EAST)).withProperty(EAST, state.getValue(SOUTH)).withProperty(SOUTH, state.getValue(WEST)).withProperty(WEST, state.getValue(NORTH));
            case CLOCKWISE_90:
                return state.withProperty(NORTH, state.getValue(WEST)).withProperty(EAST, state.getValue(NORTH)).withProperty(SOUTH, state.getValue(EAST)).withProperty(WEST, state.getValue(SOUTH));
            default:
                return state;
        }
    }
    
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn){
        switch (mirrorIn){
            case LEFT_RIGHT:
                return state.withProperty(NORTH, state.getValue(SOUTH)).withProperty(SOUTH, state.getValue(NORTH));
            case FRONT_BACK:
                return state.withProperty(EAST, state.getValue(WEST)).withProperty(WEST, state.getValue(EAST));
            default:
                return super.withMirror(state, mirrorIn);
        }
    }

    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {NORTH, EAST, WEST, SOUTH});
    }
    
    @Override
    public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing){
        Block connector = world.getBlockState(pos.offset(facing)).getBlock();
        if(connector instanceof ConstructorCable || connector instanceof ConstructorController || connector instanceof ConstructorCenter){
            return true;
        }
        return false;
    }

    private boolean canFenceConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing){
        Block block = world.getBlockState(pos.offset(facing)).getBlock();
        return block.canBeConnectedTo(world, pos.offset(facing), facing.getOpposite()) || canConnectTo(world, pos.offset(facing));
    }
    
}