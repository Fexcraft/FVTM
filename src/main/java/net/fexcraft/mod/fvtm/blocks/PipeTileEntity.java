package net.fexcraft.mod.fvtm.blocks;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.blocks.PipeBlock.PipeType;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.lang.BitList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class PipeTileEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {

    public boolean[] conn = new boolean[6];
    public boolean[] mode = new boolean[6];
    public static final int[] order = new int[]{1, 2, 5, 3, 4, 0};
    private int meta = -1;
    private FluidTank tank;
    public Axis axis = null;
    public EnumFacing direction;

    public PipeTileEntity(){
        for(int i = 0; i < conn.length; i++){
            conn[i] = false;
            mode[i] = false;
        }
    }

    public PipeTileEntity(World world, int meta){
        this.world = world;
        for(int i = 0; i < conn.length; i++){
            conn[i] = false;
            mode[i] = false;
        }
        tank = new FluidTank(PipeType.byMetadata(meta).getTankSize());
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
        compound.setInteger("State", list.toInt());
        compound.setTag("FluidTank", tank.writeToNBT(new NBTTagCompound()));
        if(direction != null){
            compound.setByte("Direction", (byte) direction.getIndex());
        }
        meta = this.getBlockMetadata();
        compound.setInteger("MetaCache", meta);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        BitList list = new BitList();
        list.set(compound.getInteger("State"));
        conn = list.shorten(6, 0);
        mode = list.shorten(6, 6);
        checkForAxis();
        direction = compound.hasKey("Direction") ? EnumFacing.getFront(compound.getByte("Direction")) : null;
        if(compound.hasKey("MetaCache") && tank == null){
            tank = new FluidTank(PipeType.byMetadata(meta = compound.getInteger("Meta")).getTankSize());
        }
        tank.readFromNBT(compound.getCompoundTag("FluidTank"));
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
            conn[facing.getIndex()] = tile != null && tile.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, facing.getOpposite()) && samePipeType(tile);
            mode[facing.getIndex()] = tile instanceof PipeTileEntity ? !((PipeTileEntity) tile).mode[facing.getOpposite().getIndex()] : false;
            this.sendUpdate();
            //
            if(!fromother && tile instanceof PipeTileEntity){
                ((PipeTileEntity) tile).updateConnections(world, change, facing.getOpposite(), true);
            }
        }
    }

    public void updateConnections(boolean fromother){
        for(EnumFacing facing : EnumFacing.VALUES){
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            if(tile != null){
                conn[facing.getIndex()] = tile != null && tile.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, facing.getOpposite()) && samePipeType(tile);
                mode[facing.getIndex()] = tile instanceof PipeTileEntity ? !((PipeTileEntity) tile).mode[facing.getOpposite().getIndex()] : false;
                this.sendUpdate();
                //
                if(!fromother && tile instanceof PipeTileEntity){
                    ((PipeTileEntity) tile).updateConnections(true);
                }
            }
        }
    }

    private boolean samePipeType(TileEntity tile){
        if(tile instanceof PipeTileEntity){
            return this.getPipeType().canConnect(PipeType.byMetadata(tile.getBlockMetadata()));
        }
        return true;
    }

    private PipeType getPipeType(){
        return PipeType.byMetadata(getBlockMetadata());
    }

    public void removeConnection(BlockPos pos, BlockPos change){
        if(this.world != null && this.world.isRemote){
            return;
        }
        EnumFacing facing = fromPos(pos, change);
        TileEntity tile = world.getTileEntity(change);
        if(facing != null){
            conn[facing.getIndex()] = tile != null && tile.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, facing.getOpposite()) && samePipeType(tile);
            mode[facing.getIndex()] = false;
            this.sendUpdate();
        }
    }

    private EnumFacing fromPos(BlockPos pos, BlockPos change){
        if(pos.north().equals(change)){
            return EnumFacing.NORTH;
        }
        if(pos.south().equals(change)){
            return EnumFacing.SOUTH;
        }
        if(pos.west().equals(change)){
            return EnumFacing.WEST;
        }
        if(pos.east().equals(change)){
            return EnumFacing.EAST;
        }
        if(pos.up().equals(change)){
            return EnumFacing.UP;
        }
        if(pos.down().equals(change)){
            return EnumFacing.DOWN;
        }
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

    @SuppressWarnings("unchecked")
    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && conn[facing.getIndex()]){
            return (T) tank;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void update(){
        if(world.isRemote || tank == null){
            return;
        }
        int transferred = 0, filled = 0;
        PipeType type = PipeType.byMetadata(getBlockMetadata());
        for(int i : order){
            if(!conn[i]){
                continue;
            }
            EnumFacing facing = EnumFacing.getFront(i);
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            if(tile == null){
                continue;
            }
            IFluidHandler handler = tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, facing.getOpposite());
            if(handler == null){
                continue;
            }
            if(mode[i]){
                if(tile instanceof PipeTileEntity){
                    continue;
                }
                if(filled >= type.getTPS()){
                    continue;
                }
                if(!canDrain(handler)){
                    continue;
                }
                int atd = type.getTPS() - filled;
                if(atd > (tank.getCapacity() - tank.getFluidAmount())){
                    atd = tank.getCapacity() - tank.getFluidAmount();
                }
                if(atd == 0){
                    continue;
                }
                FluidStack drained = handler.drain(atd, false);
                if(drained == null || drained.amount <= 0){
                    continue;
                }
                drained = handler.drain(atd, true);
                filled = drained.amount;
                tank.fill(drained, true);
                //TODO needs testing.
                /*if(filled >= type.getTPS() || handler.getTankProperties().length == 0 || !handler.getTankProperties()[0].canDrain() || handler.getTankProperties()[0].getContents() == null || (tank.getFluid() != null && handler.getTankProperties()[0].getContents().getFluid() != tank.getFluid().getFluid())){ continue; }
				
				if(atd == 0){ continue; }
				FluidStack drained = handler.drain(atd, false);
				if(drained == null || drained.amount == 0){
					continue;
				}
				filled += handler.drain(drained, true).amount;
				tank.fill(drained, true);*/
            }
            else{
                if(transferred >= type.getTPS()){
                    continue;
                }
                if(!canFill(handler)){
                    continue;
                }
                int atf = type.getTPS() - transferred;
                if(atf == 0){
                    Print.debug("atf == null");
                    continue;
                }
                FluidStack drain = tank.drain(atf, false);
                if(drain == null){
                    Print.debug("drain == null");
                    continue;
                }
                int fill = handler.fill(drain, true);
                FluidStack act = tank.drain(fill, true);
                transferred += act == null ? 0 : act.amount;
            }
        }
        //Debug-Only sync
        //ApiUtil.sendTileEntityUpdatePacket(this, writeToNBT(new NBTTagCompound()), 256);
    }

    private boolean canDrain(IFluidHandler handler){
        if(handler.getTankProperties().length <= 0){
            return false;
        }
        if(handler.getTankProperties()[0] != null){
            if(handler.getTankProperties()[0].getContents() == null){
                return false;
            }
            if(tank.getFluid() != null && !handler.getTankProperties()[0].getContents().isFluidEqual(tank.getFluid())){
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean canFill(IFluidHandler handler){
        if(tank.getFluid() == null){
            return false;
        }
        if(handler.getTankProperties().length > 0){
            if(!handler.getTankProperties()[0].canFill()){
                return false;
            }
            if(handler.getTankProperties()[0].getContents() == null){
                return true;
            }
            return handler.getTankProperties()[0].getContents().isFluidEqual(tank.getFluid());
        }
        return true;
    }

    public FluidTank getTank(){
        return tank;
    }

    public void switchIO(EnumFacing side){
        this.mode[side.getIndex()] = !this.mode[side.getIndex()];
        this.sendUpdate();
    }

    public void toggleConnection(EnumFacing side){
        this.conn[side.getIndex()] = !this.conn[side.getIndex()];
        this.sendUpdate();
    }

    public void sendUpdate(){
        ApiUtil.sendTileEntityUpdatePacket(this, this.writeToNBT(new NBTTagCompound()), 256);
    }

    public EnumFacing getFlowDirection(){
        return direction;
    }

}
