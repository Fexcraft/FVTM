package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.prototype.WorldRailDataSerializer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Junction {
	
	public ArrayList<Track> tracks;
	private BlockPos core;
	public boolean switch0, switch1;
	private World world;
	
	public Junction(World world, BlockPos core){
		this.core = core; tracks = new ArrayList<Track>();
		this.switch0 = this.switch1 = false; this.world = world;
	}
	
	public Junction read(NBTTagCompound compound){
		this.core = BlockPos.fromLong(compound.getLong("Core"));
		this.switch0 = compound.getBoolean("Switch0");
		this.switch1 = compound.getBoolean("Switch1");
		//tracks = new Track[compound.getInteger("Tracks")];
		int trackam = compound.getInteger("Tracks");
		if(trackam > 0){
			for(int i = 0; i < trackam; i++){
				tracks.add(new Track().read(compound.getCompoundTag("Track_" + i)));
			}
		}
		return this;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		for(int i = 0; i < tracks.size(); i++){
			compound.setTag("Track_" + i, tracks.get(i).write(null));
		}
		compound.setInteger("Tracks", tracks.size());
		compound.setBoolean("Switch0", switch0);
		compound.setBoolean("Switch1", switch1);
		compound.setLong("Core", core.toLong());
		return compound;
	}
	
	public BlockPos getCore(){
		return core;
	}

	public void addnew(Track track){
		tracks.add(track);
	}
	
	public void remove(String trackid, boolean firstcall){
		Track track = null;
		for(int i = 0; i < tracks.size(); i++){
			if(tracks.get(i).getId().equals(trackid)){ track = tracks.remove(i); break; }
		}
		if(track == null) return;
		if(firstcall){
			Junction junk = world.getCapability(WorldRailDataSerializer.CAPABILITY, null)
				.getJunctionAt(track.start.equals(core) ? track.end : track.start);
			if(junk != null) junk.remove(track.getOppositeId(), false);
		}
	}

	public void clear(){
		ArrayList<Track> trecks = new ArrayList<Track>();
		for(Track track : tracks){ trecks.add(track); }
		for(Track track : trecks) this.remove(track.getId(), true);
		tracks.clear();
	}
	
}