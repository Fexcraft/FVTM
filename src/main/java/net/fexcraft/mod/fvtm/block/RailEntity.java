package net.fexcraft.mod.fvtm.block;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//@Interface(iface = "trackapi.lib.ITrack", modid = "trackapi")
public class RailEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {//, ITrack {
	
	private HashMap<PathKey, Integer> tracks = new HashMap<>();
	//private ArrayList<Track> cache = new ArrayList<>();
	//private float gauge = 1.79375f;

	public void addTrack(Track track, int height){
		PathKey key = track.getId(track.isOppositeCopy());
		if(tracks.containsKey(key)) return;
		tracks.put(key, height);
		//cache.clear();
		this.sendUpdate();
		this.markDirty();
	}

	public void remTrack(Track track, World world){
		PathKey key = track.getId(track.isOppositeCopy());
		if(!tracks.containsKey(key)) return;
		tracks.remove(key);
		//cache.clear();
		if(track.preset == null){
			EntityItem item = new EntityItem(world);
			item.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
			item.setItem(track.gauge.newItemStack());
			world.spawnEntity(item);
		}
		control(world, true, null);
	}

	public boolean control(World world, boolean checkjunc, EntityPlayer sender){
		if(checkjunc){
			RailSys system = world.getCapability(Capabilities.RAILSYSTEM, null).get();
			List<PathKey> keys = tracks.keySet().stream().collect(Collectors.toList());
			for(PathKey key : keys){
				Track track = system.getTrack(key);
				if(track == null) tracks.remove(key);
			}
		}
		if(tracks.isEmpty()){
			world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
			if(sender != null){
				Print.bar(sender, "&cBlock removed, no actual tracks are attached.");
			}
			return true;
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
		this.sendUpdate();
		this.markDirty();
		if(world.getBlockState(pos).getValue(RailBlock.HEIGHT) != height){
			world.setBlockState(pos, RailBlock.INSTANCE.getDefaultState().withProperty(RailBlock.HEIGHT, height));
			if(sender != null){
				Print.bar(sender, "&cBlock height updated.");
			}
			return true;
		}
		return false;
	}

	public void remTracks(World world){
		RailSys system = world.getCapability(Capabilities.RAILSYSTEM, null).get();
		try{
			List<PathKey> keys = tracks.keySet().stream().collect(Collectors.toList());
			for(PathKey key : keys){
				Vec316f vec = key.toVec3f(0);
				Junction junc = system.getJunction(vec, true);
				Junction seco = system.getJunction(key.toVec3f(3), true);
				int index  = junc.getIndex(key);
				if(index >= 0 && index < junc.tracks.size()){
					Track track = junc.tracks.get(index);
					junc.remove(index, true);
					if(junc.size() == 0) system.delJunction(junc.getVec316f());
					if(seco.size() == 0) system.delJunction(seco.getVec316f());
					if(track != null){
						RailGaugeItem.unregister(null, world, pos, track);
						if(track.preset != null) continue;
						//re-compensate the first one broken
						EntityItem item = new EntityItem(world);
						item.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
						item.setItem(track.gauge.newItemStack());
						world.spawnEntity(item);
					}
				}
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
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(!compound.hasKey("Tracks")) return;
        NBTTagList list = (NBTTagList)compound.getTag("Tracks");
        tracks.clear();
        for(NBTBase base : list){
        	NBTTagCompound com = (NBTTagCompound)base;
        	int height = com.getInteger("height");
        	tracks.put(new PathKey(com), height);
        }
        //cache.clear();
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState){
        return super.shouldRefresh(world, pos, oldState, newState);
    }

	public HashMap<PathKey, Integer> getTracks(){
		return tracks;
	}

	/*@Override
	@Method(modid = "trackapi")
	public double getTrackGauge(){
		return gauge;
	}

	@Override
	@Method(modid = "trackapi")
	public Vec3d getNextPosition(Vec3d pos, Vec3d motion){
		/*if(tracks.isEmpty()) return pos;
		if(cache.isEmpty() || cache.size() != tracks.size()) refreshCache();
		//RailSys system = world.getCapability(Capabilities.RAILSYSTEM, null).get();
		Vec3d moved = pos.add(motion);
		Vec3f movad = new Vec3f(moved.x, moved.y, moved.z);
		if(cache.size() == 1){
			Track track = cache.get(0);
			movad = track.getVectorOnTrack(movad);
			float dis = (float)motion.length();
			movad = track.getVectorPosition0(dis, movad.distanceTo(track.start.vector) > movad.distanceTo(track.end.vector));
		}
		else{
			//find out if it's a crossing or not
			//if it's a junction check which switch is active
			//if neither, we got trouble
		}*//*
		return pos.add(motion);
	}*/

	/*private void refreshCache(){
		RailSys system = world.getCapability(Capabilities.RAILSYSTEM, null).get();
		for(PathKey key : tracks.keySet()){
			cache.add(system.getTrack(key));
		}
	}*/

}
