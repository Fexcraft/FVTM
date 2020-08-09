package net.fexcraft.mod.fvtm.block;

import java.util.ArrayList;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RailEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private ArrayList<PathKey> tracks = new ArrayList<>();
	private boolean removed;

	public void addTrack(Track track){
		tracks.add(track.getId());
		this.sendUpdate();
		this.markDirty();
	}

	public void remTrack(Track track){
		tracks.remove(track.getId());
		this.sendUpdate();
		this.markDirty();
	}
	
	//

    public final void sendUpdate(){
        ApiUtil.sendTileEntityUpdatePacket(world, pos, this.getUpdateTag());
    }

    @Override
    public final void processClientPacket(PacketTileEntityUpdate pkt){
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
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        NBTTagList list = new NBTTagList();
        for(PathKey track : tracks){
        	list.appendTag(track.write(new NBTTagCompound()));
        }
        compound.setTag("Tracks", list);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(!compound.hasKey("Tracks")) return;
        NBTTagList list = (NBTTagList)compound.getTag("Tracks");
        tracks.clear();
        for(NBTBase base : list){
        	tracks.add(new PathKey((NBTTagCompound)base));
        }
        if(world != null && world.isRemote){
        	world.markBlockRangeForRenderUpdate(pos, pos);
        }
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState){
        return removed;
    }

	public ArrayList<PathKey> getTracks(){
		return tracks;
	}

}
