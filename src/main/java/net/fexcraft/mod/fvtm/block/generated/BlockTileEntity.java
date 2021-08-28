package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTileEntity extends net.minecraft.tileentity.TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	public byte meta = -1;
	public BlockData data;
	
	public BlockTileEntity(BlockBase type){
		data = new BlockData(type.type);
	}
	
	public BlockTileEntity(){}

	public BlockData getBlockData(){
		return data;
	}

    public final void sendUpdate(){
        ApiUtil.sendTileEntityUpdatePacket(world, pos, this.getUpdateTag());
    }

    @Override
    public void processClientPacket(PacketTileEntityUpdate pkt){
        this.readFromNBT(pkt.nbt);
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
        super.readFromNBT(pkt.getNbtCompound());
        this.readFromNBT(pkt.getNbtCompound());
    }
    
    @Override
    public void onLoad(){
        IBlockState state = world.getBlockState(pos);
        meta = (byte)state.getBlock().getMetaFromState(state);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        if(data != null) data.write(compound);
        if(meta > -1){
            compound.setByte("block_meta", meta);
        }
        else{
            IBlockState state = world.getBlockState(pos);
            compound.setByte("block_meta", (byte)state.getBlock().getMetaFromState(state));
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(data != null) data.read(compound);
        else data = Resources.getBlockData(compound);
        if(compound.hasKey("block_meta")) meta = compound.getByte("block_meta");
        if(data.getType().canBeWired() && SystemManager.active(Systems.WIRE)){
        	SystemManager.get(Systems.WIRE, world, WireSystem.class).register(this);
        }
    }
    
    @Override
    public void setWorldCreate(World world){
    	this.world = world;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public double getMaxRenderDistanceSquared(){
        return super.getMaxRenderDistanceSquared() * 8;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return INFINITE_EXTENT_AABB;
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState){
        return oldState.getBlock() != newState.getBlock();
    }
	
	@Override
	public void invalidate(){
		super.invalidate();
        if(data.getType().canBeWired() && SystemManager.active(Systems.WIRE)){
        	SystemManager.get(Systems.WIRE, world, WireSystem.class).unregister(this);
        }
	}

}
