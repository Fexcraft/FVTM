package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

import static net.fexcraft.mod.fvtm.util.Properties.FACING;
import static net.fexcraft.mod.uni.world.WrapperHolder.getSide;

public class M_4ROT extends PlainBase {

    public M_4ROT(Block type){
        super(type); this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return type.getAABB("default", "facing=" + state.getValue(FACING).getName()).get(0);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return type.getAABB("selection", "facing=" + state.getValue(FACING).getName()).offset(0, pos.getX(), pos.getY(), pos.getZ()).local();
    }
    
    @Nullable @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
        return type.getAABB("collision", "facing=" + state.getValue(FACING).getName()).get(0);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(player.getHeldItem(hand).getItem() instanceof ItemDye){
    		return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    	}
        if(!world.isRemote){
            MultiBlockData data = world.getCapability(Capabilities.MULTIBLOCKS, null).getMultiBlock(pos);
            BlockPos core = world.getCapability(Capabilities.MULTIBLOCKS, null).getMultiBlockCore(pos);
            if(data == null){
                Print.chat(player, "MultiBlockData not found [CAP].");
                return true;
            }
            if(core == null){
                Print.chat(player, "MultiBlock Core not found.");
                return true;
            }
            if(M_4ROT_TE.processTriggers(null, data.getType().getInteract(getSide(state.getValue(FACING)), new V3I(pos.getX(), pos.getY(), pos.getZ()), new V3I(core.getX(), core.getY(), core.getZ())), data, core, player, hand, state, pos, side, hitX, hitY, hitZ)){
            	return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing facing = EnumFacing.byIndex(meta);
        facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
        return this.getDefaultState().withProperty(FACING, facing);
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
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	if(!world.isRemote) M_4ROT_TE.processBreak(world, pos, false);
        super.breakBlock(world, pos, state);
    }

    @Override //I think it might be this method is client side only, so it will usually not find anything - as of now.
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
    	BlockPos core = world.getCapability(Capabilities.MULTIBLOCKS, null).getMultiBlockCore(pos);
    	if(core == null) return ItemStack.EMPTY;
    	MultiblockTileEntity tile = (MultiblockTileEntity)world.getTileEntity(core);
        return tile == null ? ItemStack.EMPTY : tile.getBlockData().getNewStack().local();
    }
    
    @Override
    public int quantityDropped(Random random){
        return 0;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Items.AIR;
    }
    
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state){
    	MultiblockTileEntity tile = (MultiblockTileEntity)world.getTileEntity(world.getCapability(Capabilities.MULTIBLOCKS, null).getMultiBlockCore(pos));
        return tile == null ? ItemStack.EMPTY : tile.getBlockData().getNewStack().local();
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess world, BlockPos pos){
        return false;
    }

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		for(AABB aabb : type.getAABB("collision", "facing=" + state.getValue(FACING).getName()).get()){
			if(entitybox == null) boxes.add(aabb.local());
			else addCollisionBoxToList(pos, entitybox, boxes, aabb.local());
		}
	}

}

