package net.fexcraft.mod.fvtm.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fBlock;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.entities.StreetSignEntity;
import net.fexcraft.mod.fvtm.entities.StreetSignEntity.StreetSignItem;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
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

@fBlock(modid = net.fexcraft.mod.fvtm.FVTM.MODID, name = "streetpost")
public class StreetPost extends BlockFence {

	public StreetPost(){
		super(Material.IRON, MapColor.GRAY);
		this.setCreativeTab(Tabs.BLOCKS);
        //
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(50.0F);
        this.setResistance(280.0F);
	}
	
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");
    public static final PropertyBool BASE = PropertyBool.create("base");
    //
    protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {
    		new AxisAlignedBB(0.375D, 0.25D, 0.375D, 0.625D, 0.75D, 0.625D),
    		new AxisAlignedBB(0.375D, 0.25D, 0.375D, 0.625D, 0.75D, 1.0D  ),
    		new AxisAlignedBB(0.0D  , 0.25D, 0.375D, 0.625D, 0.75D, 0.625D),
    		new AxisAlignedBB(0.0D  , 0.25D, 0.375D, 0.625D, 0.75D, 1.0D  ),
    		new AxisAlignedBB(0.375D, 0.25D, 0.0D  , 0.625D, 0.75D, 0.625D),
    		new AxisAlignedBB(0.375D, 0.25D, 0.0D  , 0.625D, 0.75D, 1.0D  ),
    		new AxisAlignedBB(0.0D  , 0.25D, 0.0D  , 0.625D, 0.75D, 0.625D),
    		new AxisAlignedBB(0.0D  , 0.25D, 0.0D  , 0.625D, 0.75D, 1.0D  ),
    		new AxisAlignedBB(0.375D, 0.25D, 0.375D, 1.0D  , 0.75D, 0.625D),
    		new AxisAlignedBB(0.375D, 0.25D, 0.375D, 1.0D  , 0.75D, 1.0D  ),
    		new AxisAlignedBB(0.0D  , 0.25D, 0.375D, 1.0D  , 0.75D, 0.625D),
    		new AxisAlignedBB(0.0D  , 0.25D, 0.375D, 1.0D  , 0.75D, 1.0D  ),
    		new AxisAlignedBB(0.375D, 0.25D, 0.0D  , 1.0D  , 0.75D, 0.625D),
    		new AxisAlignedBB(0.375D, 0.25D, 0.0D  , 1.0D  , 0.75D, 1.0D  ),
    		new AxisAlignedBB(0.0D  , 0.25D, 0.0D  , 1.0D  , 0.75D, 0.625D),
    		new AxisAlignedBB(0.0D  , 0.25D, 0.0D  , 1.0D  , 0.75D, 1.0D  )};
    public static final AxisAlignedBB PILLAR_AABB = new AxisAlignedBB(0.375D, 0.25D, 0.375D, 0.625D, 0.75D, 0.625D);
    public static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.375D, 0.25D, 0.625D, 0.625D, 0.75D, 1.0D);
    public static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.0D, 0.25D, 0.375D, 0.375D, 0.75D, 0.625D);
    public static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.375D, 0.25D, 0.0D, 0.625D, 0.75D, 0.375D);
    public static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.625D, 0.25D, 0.375D, 1.0D, 0.75D, 0.625D);
    
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState){
        if(!isActualState){
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
    
    @Override
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
    
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos){
        return state.withProperty(NORTH, canFenceConnectTo(worldIn, pos, EnumFacing.NORTH))
                    .withProperty(EAST,  canFenceConnectTo(worldIn, pos, EnumFacing.EAST))
                    .withProperty(SOUTH, canFenceConnectTo(worldIn, pos, EnumFacing.SOUTH))
                    .withProperty(WEST,  canFenceConnectTo(worldIn, pos, EnumFacing.WEST))
                    .withProperty(UP  ,  canFenceConnectTo(worldIn, pos, EnumFacing.UP  ))
                    .withProperty(DOWN,  canFenceConnectTo(worldIn, pos, EnumFacing.DOWN))
        			.withProperty(BASE,  isSolidUnder(worldIn, pos, state));
    }
    
    private boolean isSolidUnder(IBlockAccess worldIn, BlockPos pos, IBlockState state){
    	BlockPos offset = pos.offset(EnumFacing.DOWN);
    	IBlockState block = worldIn.getBlockState(offset);
		return block.isSideSolid(worldIn, offset, EnumFacing.UP);
	}

	public boolean canFenceConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing){
        BlockPos other = pos.offset(facing);
        Block block = world.getBlockState(other).getBlock();
        return block instanceof BlockFence || block.canBeConnectedTo(world, other, facing.getOpposite()) || canConnectTo(world, other, facing.getOpposite());
    }
    
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face){
        return BlockFaceShape.CENTER;
    }
    
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot){
        switch(rot){
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
    
    @Override
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
    
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { NORTH, EAST, WEST, SOUTH, UP, DOWN, BASE });
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(!world.isRemote && hand == EnumHand.MAIN_HAND){
            ItemStack stack = player.getHeldItemMainhand();
            if(stack.getItem() instanceof ItemLead){
            	ItemLead.attachToFence(player, world, pos);
            	return true;
            }
            else if(stack.getItem() instanceof StreetSignItem){
    			AxisAlignedBB aabb = new AxisAlignedBB(pos);
    			boolean found = false;
    			for(Entity e : world.loadedEntityList){
    				if(e instanceof StreetSignEntity && e.getEntityBoundingBox().intersects(aabb)){
    					found = true; break;
    				}
    			}
            	if(!found){
            		StreetSignEntity ent = new StreetSignEntity(world, player.getHorizontalFacing().getOpposite());
            		ent.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
            		world.spawnEntity(ent);
            	}
            	else{
            		Print.bar(player, "entity/sign at position");
            	}
            	return true;
            }
            else return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
        }
        else{
            return true;
        }
    }

}