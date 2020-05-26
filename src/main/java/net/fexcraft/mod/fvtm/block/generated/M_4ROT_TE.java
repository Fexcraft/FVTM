package net.fexcraft.mod.fvtm.block.generated;

import static net.fexcraft.mod.fvtm.util.Properties.FACING;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.MB_Trigger;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(player.getHeldItem(hand).getItem() instanceof ItemDye){
    		return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    	}
        if(!world.isRemote){
            TileEntity te = (TileEntity)world.getTileEntity(pos);
            if(te == null){
                Print.chat(player, "No TileEntity found.");
                return true;
            }
            MultiBlockData data = te.getMultiBlockData();
            if(data == null){
                Print.chat(player, "MultiBlockData not found.");
                return true;
            }
            if(te.triggers == null) te.triggers = data.getType().getTriggers(state.getValue(FACING), pos, te.isCore() ? pos : te.getCore());
            ItemStack stack = player.getHeldItem(hand);
            te.triggers.forEach(trigger -> {
            	boolean pass = trigger.isWholeBlock();
            	if(!pass && trigger.getBB() != null) pass = trigger.getBB().contains(new Vec3d(hitX, hitY, hitZ));//TODO aabb rotation
            	if(!pass && trigger.getSide() != null) pass = trigger.getSide(state.getValue(FACING)) == side;
            	Print.debug(pass + " " + trigger.getTarget() + " " + trigger.forInventory());
            });
            return true;
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
        ((TileEntity)world.getTileEntity(pos)).setCore(pos, stack).setup();
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
    	if(!world.isRemote){
    		processBreak(world, pos, state);
        }
        super.breakBlock(world, pos, state);
    }
    
	public static void processBreak(World world, BlockPos pos, IBlockState state){
		MultiBlockData data = world.getCapability(Capabilities.MULTIBLOCKS, null).getMultiBlock(pos);
		if(data == null) return;
		ArrayList<BlockPos> positions = data.getType().getPositions(data.getData().getType(), pos, state.getValue(FACING));
		positions.forEach(blkpos -> {
			IBlockState posstate = world.getBlockState(blkpos);
			if(posstate.getBlock() instanceof M_4ROT_TE || posstate.getBlock() instanceof M_4ROT){
				TileEntity tile = (TileEntity)world.getTileEntity(blkpos);
				if(tile != null && tile.iscore){
					if(tile.iscore){
						//TODO empty out inventories (drop)
					}
				}
	            world.setBlockState(blkpos, Blocks.AIR.getDefaultState());
			}
		});
	}

	@Override
	public net.minecraft.tileentity.TileEntity createNewTileEntity(World world, int meta){
		return type.getMultiBlock() != null && type.getMultiBlock().isTickable() ? new M_4ROT_TE.TickableTE(this) : new M_4ROT_TE.TileEntity(this);
	}
	
	public static class TileEntity extends BlockBase.TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
		
		public List<MB_Trigger> triggers;
		private BlockPos core;
		private boolean iscore;
		
		public TileEntity(BlockBase type){
			super(type);
		}

		public TileEntity(){}
		
		public TileEntity setCore(BlockPos pos, ItemStack stack){
	        BlockPos core = BlockPos.fromLong(stack.getTagCompound().getLong("PlacedPos"));
	        if(!pos.equals(core)){
	            this.core = core;
	        }
	        else iscore = true;
	        this.markDirty();
	        return this;
		}
		
		public BlockPos getCore(){
			return core;
		}
		
		public boolean isCore(){
			return iscore;
		}

		public MultiBlockData getMultiBlockData(){
			return iscore ? data.getMultiBlockData() : world.getCapability(Capabilities.MULTIBLOCKS, null).getMultiBlock(pos);
		}
		
		public void setup(){
			if(data == null || data.getMultiBlockData() == null) return;
			world.getCapability(Capabilities.MULTIBLOCKS, null).registerMultiBlock(pos, EnumFacing.byIndex(this.getBlockMetadata()), data.getMultiBlockData());
		}
		
		@Override
		public void invalidate(){
			super.invalidate();
			if(data == null || data.getMultiBlockData() == null) return;
			world.getCapability(Capabilities.MULTIBLOCKS, null).unregisterMultiBlock(pos, EnumFacing.byIndex(this.getBlockMetadata()), data.getMultiBlockData());
		}

	    @Override
	    public void readFromNBT(NBTTagCompound compound){
	        super.readFromNBT(compound);
	        if(compound.hasKey("MultiBlockCore")) core = BlockPos.fromLong(compound.getLong("MultiBlockCore"));
	        iscore = core == null;
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

