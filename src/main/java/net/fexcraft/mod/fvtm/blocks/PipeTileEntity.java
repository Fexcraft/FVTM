package net.fexcraft.mod.fvtm.blocks;

import javax.annotation.Nullable;

import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.lang.BitList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class PipeTileEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>{
	
	public boolean[] conn = new boolean[6];
	public boolean[] mode = new boolean[6];
	private FluidTank tank = new FluidTank(4);
	public Axis axis = null;
	
	public PipeTileEntity(){
		for(int i = 0; i < conn.length; i++){
			conn[i] = false; mode[i] = false;
		}
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
    }

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		BitList list = new BitList(conn);
		list.integrate(mode, 6);
		compound.setInteger("state", list.toInt());
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		BitList list = new BitList();
		list.set(compound.getInteger("state"));
		conn = list.shorten(6, 0);
		mode = list.shorten(6, 6);
		checkForAxis();
	}

	private void checkForAxis(){
		if(conn[0] && conn[1] && !conn[2] && !conn[3] && !conn[4] && !conn[5]){
			axis = Axis.Y;
		}
		else if(!conn[0] && !conn[1] && conn[2] && conn[3] && !conn[4] && !conn[5]){
			axis = Axis.Z;
		}
		else if(!conn[0] && !conn[1] && !conn[2] && !conn[3] && conn[4] && conn[5]){
			axis = Axis.X;
		}
		else{
			axis = null;
		}
	}

	public void updateConnections(IBlockAccess world, BlockPos pos, EnumFacing facing, boolean fromother){
		BlockPos change = pos.offset(facing);
		TileEntity tile = world.getTileEntity(change);
		if(facing != null){
			conn[facing.getIndex()] = tile != null && tile.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, facing.getOpposite());
			mode[facing.getIndex()] = false;
			ApiUtil.sendTileEntityUpdatePacket(this, this.writeToNBT(new NBTTagCompound()), 256);
			//
			if(!fromother && tile instanceof PipeTileEntity){
				((PipeTileEntity)tile).updateConnections(world, change, facing.getOpposite(), true);
			}
		}
	}

	public void removeConnection(BlockPos pos, BlockPos change){
		if(this.world != null && this.world.isRemote){ return; }
		EnumFacing facing = fromPos(pos, change);
		TileEntity tile = world.getTileEntity(change);
		if(facing != null){
			conn[facing.getIndex()] = tile != null && tile.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, facing.getOpposite());
			mode[facing.getIndex()] = false;
			ApiUtil.sendTileEntityUpdatePacket(this, this.writeToNBT(new NBTTagCompound()), 256);
		}
	}

	private EnumFacing fromPos(BlockPos pos, BlockPos change){
		if(pos.north().equals(change)){ return EnumFacing.NORTH; }
		if(pos.south().equals(change)){ return EnumFacing.SOUTH; }
		if( pos.west().equals(change)){ return EnumFacing.WEST;  }
		if( pos.east().equals(change)){ return EnumFacing.EAST;  }
		if(   pos.up().equals(change)){ return EnumFacing.UP;    }
		if( pos.down().equals(change)){ return EnumFacing.DOWN;  }
		return null;
	}

	@Override
	public void processServerPacket(PacketTileEntityUpdate packet){
		
	}

	@Override
	public void processClientPacket(PacketTileEntityUpdate packet){
		this.readFromNBT(packet.nbt);
	}
	
	@Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
        	return true;
        }
        return super.hasCapability(capability, facing);
    }

    @SuppressWarnings("unchecked") @Override @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && this.hasCapability(capability, facing)){
        	return (T)tank;
        }
        return super.getCapability(capability, facing);
    }

}
