package net.fexcraft.mod.fvtm.block;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RailEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private HashMap<PathKey, Integer> tracks = new HashMap<>();
	public boolean remove = true;

	public void addTrack(Track track, int height){
		PathKey key = track.getId(track.isOppositeCopy());
		if(tracks.containsKey(key)) return;
		tracks.put(key, height);
		this.sendUpdate();
		this.markDirty();
	}

	public void remTrack(Track track, World world){
		tracks.remove(track.getId(track.isOppositeCopy()));
		if(tracks.isEmpty()){
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
			this.sendUpdate();
			this.markDirty();
			return;
		}
		int height = 0;
		for(int val : tracks.values()){
			if(val == 0){
				height = 0;
				break;
			}
			else if(val > height){
				height = val;
			}
		}
		remove = false;
		this.sendUpdate();
		this.markDirty();
		world.setBlockState(pos, RailBlock.INSTANCE.getDefaultState().withProperty(RailBlock.HEIGHT, height));
	}

	public void remTracks(World world){
		RailSys system = world.getCapability(Capabilities.RAILSYSTEM, null).get();
		try{
			List<PathKey> keys = tracks.keySet().stream().collect(Collectors.toList());
			for(PathKey key : keys){
				Track track = system.getTrack(key);
				if(track == null || track.getJunction() == null) continue;
				int index = track.getJunction().tracks.indexOf(track);
				if(index == -1){
					track = system.getTrack(track.getOppositeId());
					if(track == null || track.getJunction() == null) continue;
					index = track.getJunction().tracks.indexOf(track);
				}
				//Print.debug("index " + index + " " + key + " " + track.getOppositeId());
				if(index < 0 || index >= track.getJunction().tracks.size()) continue;
				track.getJunction().remove(index, true);
				RailGaugeItem.unregister(null, world, track);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
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
        //super.readFromNBT(pkt.getNbtCompound());
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        NBTTagList list = new NBTTagList();
        for(Entry<PathKey, Integer> track : tracks.entrySet()){
        	NBTTagCompound com = new NBTTagCompound();
        	com.setInteger("height", track.getValue());
        	list.appendTag(track.getKey().write(com));
        }
        compound.setTag("Tracks", list);
        compound.setBoolean("Remove", remove);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        remove = compound.getBoolean("Remove");
        if(!compound.hasKey("Tracks")) return;
        NBTTagList list = (NBTTagList)compound.getTag("Tracks");
        tracks.clear();
        for(NBTBase base : list){
        	NBTTagCompound com = (NBTTagCompound)base;
        	int height = com.getInteger("height");
        	tracks.put(new PathKey(com), height);
        }
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState){
    	boolean bool = remove;
    	remove = true;
        return bool;
    }

	public HashMap<PathKey, Integer> getTracks(){
		return tracks;
	}

}
