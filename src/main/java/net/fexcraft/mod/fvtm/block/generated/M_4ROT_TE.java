package net.fexcraft.mod.fvtm.block.generated;

import static net.fexcraft.mod.fvtm.util.Properties.FACING;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class M_4ROT_TE extends BlockBase {

    public M_4ROT_TE(Block type){
        super(type);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return type.getAABB("default", "facing=" + state.getValue(FACING).getName());
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return type.getAABB("selection", "facing=" + state.getValue(FACING).getName()).offset(pos);
    }
    
    @Nullable @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
        return type.getAABB("collision", "facing=" + state.getValue(FACING).getName());
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
        ((TileEntity)world.getTileEntity(pos)).setCore(stack);
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
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        super.breakBlock(world, pos, state);
    }

	@Override
	public net.minecraft.tileentity.TileEntity createNewTileEntity(World world, int meta){
		return type.getMultiBlock() != null && type.getMultiBlock().isTickable() ? new M_4ROT_TE.TickableTE(this) : new M_4ROT_TE.TileEntity(this);
	}
	
	public static class TileEntity extends BlockBase.TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
		
		private BlockPos core;
		
		public TileEntity(BlockBase type){
			super(type);
		}
		
		public void setCore(ItemStack stack){
	        BlockPos core = BlockPos.fromLong(stack.getTagCompound().getLong("PlacedPos"));
	        if(!pos.equals(core)){
	            this.core = core;
	        }
		}

		public TileEntity(){}

	    @Override
	    public void readFromNBT(NBTTagCompound compound){
	        super.readFromNBT(compound);
	        if(core != null) core = BlockPos.fromLong(compound.getLong("MultiBlockCore"));
	    }

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound compound){
	        super.writeToNBT(compound);
	        if(core != null) compound.setLong("MultiBlockCore", core.toLong());
	        return compound;
	    }

	}
	
	public static class TickableTE extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {
		
		public TickableTE(BlockBase type){
			super(type);
		}
		
		public TickableTE(){}

		@Override
		public void update(){
			if(data == null || data.getMultiBlockData() == null || data.getMultiBlockData().getScript() == null) return;
			data.getMultiBlockData().getScript().onUpdate(this);
		}

	}

}

