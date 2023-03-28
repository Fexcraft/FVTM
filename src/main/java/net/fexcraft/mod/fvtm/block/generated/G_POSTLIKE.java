package net.fexcraft.mod.fvtm.block.generated;

import static net.fexcraft.mod.fvtm.block.StreetPost.isSolidUnder;
import static net.fexcraft.mod.fvtm.util.Properties.BASE;
import static net.fexcraft.mod.fvtm.util.Properties.DOWN;
import static net.fexcraft.mod.fvtm.util.Properties.UP;
import static net.minecraft.block.BlockFence.EAST;
import static net.minecraft.block.BlockFence.NORTH;
import static net.minecraft.block.BlockFence.SOUTH;
import static net.minecraft.block.BlockFence.WEST;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class G_POSTLIKE extends PlainBase {

    public G_POSTLIKE(Block type){
        super(type);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return type.getAABB("default", stateToStr(state))[0];
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return type.getAABB("selection", stateToStr(state))[0].offset(pos);
    }

    @Nullable @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
        return type.getAABB("collision", stateToStr(state))[0];
    }

    private String stateToStr(IBlockState state){
        String str = "north=" + state.getValue(NORTH) + ",south=" + state.getValue(SOUTH);
        str += "west=" + state.getValue(WEST) + ",east=" + state.getValue(EAST);
        str += "up=" + state.getValue(UP) + ",down=" + state.getValue(DOWN);
        return str + "base=" + state.getValue(BASE);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos){
        return state.withProperty(NORTH, canConnect(worldIn, pos, EnumFacing.NORTH))
                .withProperty(EAST,  canConnect(worldIn, pos, EnumFacing.EAST))
                .withProperty(SOUTH, canConnect(worldIn, pos, EnumFacing.SOUTH))
                .withProperty(WEST,  canConnect(worldIn, pos, EnumFacing.WEST))
                .withProperty(UP  ,  canConnect(worldIn, pos, EnumFacing.UP  ))
                .withProperty(DOWN,  canConnect(worldIn, pos, EnumFacing.DOWN))
                .withProperty(BASE,  isSolidUnder(worldIn, pos, state));
    }

    public boolean canConnect(IBlockAccess world, BlockPos pos, EnumFacing facing){
        BlockPos other = pos.offset(facing);
        net.minecraft.block.Block block = world.getBlockState(other).getBlock();
        return block instanceof BlockFence || block.canBeConnectedTo(world, other, facing.getOpposite()) || block instanceof G_POSTLIKE;
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
    public BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { NORTH, EAST, WEST, SOUTH, UP, DOWN, BASE });
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        world.setBlockState(pos, state, 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return 0;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        super.breakBlock(world, pos, state);
    }

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		for(AxisAlignedBB aabb : type.getAABB("collision", stateToStr(state))){
			if(entitybox == null) boxes.add(aabb);
			else addCollisionBoxToList(pos, entitybox, boxes, aabb);
		}
	}

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(!world.isRemote && hand == EnumHand.MAIN_HAND){
            ItemStack stack = player.getHeldItemMainhand();
            if(stack.getItem() instanceof ItemLead){
                ItemLead.attachToFence(player, world, pos);
                return true;
            }
            else return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
        }
        else{
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side){
        return true;
    }

}

