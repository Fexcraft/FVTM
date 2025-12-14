package net.fexcraft.mod.fvtm.block.generated;

import static net.fexcraft.mod.fvtm.block.StreetPost.isSolidUnder;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.BASE;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.DOWN;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.UP;
import static net.minecraft.block.BlockFence.EAST;
import static net.minecraft.block.BlockFence.NORTH;
import static net.minecraft.block.BlockFence.SOUTH;
import static net.minecraft.block.BlockFence.WEST;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.uni.world.AABB;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.BlockFence;
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
        return type.getAABB("default", stateToStr(getActualState(state, source, pos))).get(0);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos){
        return type.getAABB("selection", stateToStr(getActualState(state, world, pos))).offset(0, pos.getX(), pos.getY(), pos.getZ()).local();
    }

    @Nullable @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
        return type.getAABB("collision", stateToStr(getActualState(state, world, pos))).get(0);
    }

    private String[] stateToStr(IBlockState state){
        String str = "";
        if(state.getValue(NORTH)) str += "north";
        if(state.getValue(SOUTH)) str += "-south";
        if(state.getValue(WEST)) str += "-west";
        if(state.getValue(EAST)) str += "-east";
        if(str.startsWith("-")) str = str.substring(1);
        boolean dw = state.getValue(DOWN);
        if(state.getValue(UP)){
            if(dw){
                return str.length() == 0 ? new String[]{ "up-down" } : new String[]{ str, str + "-up-down" };
            }
            else return str.length() == 0 ? new String[]{ "up" } : new String[]{ str, str + "-up" };
        }
        else if(dw){
            return str.length() == 0 ? new String[]{ "down" } : new String[]{ str, str + "-down" };
        }
        else{
            return new String[]{ str };
        }
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
        return new BlockStateContainer(this, NORTH, EAST, WEST, SOUTH, UP, DOWN, BASE);
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
        state = getActualState(state, world, pos);
        addColl("", pos, entitybox, boxes);
        addColl("north=" + state.getValue(NORTH), pos, entitybox, boxes);
        addColl("south=" + state.getValue(SOUTH), pos, entitybox, boxes);
        addColl("west=" + state.getValue(WEST), pos, entitybox, boxes);
        addColl("east=" + state.getValue(EAST), pos, entitybox, boxes);
        addColl("up=" + state.getValue(UP), pos, entitybox, boxes);
        addColl("down=" + state.getValue(DOWN), pos, entitybox, boxes);
        addColl("base=" + state.getValue(BASE), pos, entitybox, boxes);
    }

    private void addColl(String string, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
        for(AABB aabb : type.getAABB("collision", string).get()){
            if(entitybox == null) boxes.add(aabb.local());
            else addCollisionBoxToList(pos, entitybox, boxes, aabb.local());
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

}

