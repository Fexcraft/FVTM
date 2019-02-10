package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailDataSerializer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** @author Ferdinand Calo' (FEX___96) **/
public class Junction {
	
	//public Integer displaylist;
	public ArrayList<Track> tracks;
	private BlockPos core;
	public boolean switch0, switch1, crossing;
	private World world;
	
	public Junction(World world, BlockPos core){
		this.core = core; tracks = new ArrayList<Track>();
		this.switch0 = this.switch1 = false; this.world = world;
	}
	
	public Junction read(NBTTagCompound compound){
		this.core = BlockPos.fromLong(compound.getLong("Core"));
		this.switch0 = compound.getBoolean("Switch0");
		this.switch1 = compound.getBoolean("Switch1");
		this.crossing = compound.getBoolean("Crossing");
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
		compound.setBoolean("Crossing", crossing);
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
				.getJunction(track.start.equals(core) ? track.end : track.start);
			if(junk != null) junk.remove(track.getOppositeId(), false);
		}
	}

	public void clear(){
		ArrayList<Track> trecks = new ArrayList<Track>();
		for(Track track : tracks){ trecks.add(track); }
		for(Track track : trecks) this.remove(track.getId(), true);
		tracks.clear();
	}
	
	@Nullable
	public Track getNext(String track){
		switch(tracks.size()){
			case 0: return null;
			case 1: return eqCopy(track, 0) ? null : tracks.get(0);
			case 2: return eqCopy(track, 0) ? tracks.get(1) : tracks.get(0);
			case 3:{
				if(eqCopy(track, 0)){
					return tracks.get(switch0 ? 1 : 2);
				} else return tracks.get(0);
			}
			case 4:{
				if(eqCopy(track, 0)){
					return crossing ? tracks.get(1) : tracks.get(switch0 ? 1 : 2);
				}
				if(eqCopy(track, 1)){
					return crossing ? tracks.get(0) : tracks.get(switch1 ? 0 : 3);
				}
				if(eqCopy(track, 2)){
					return crossing ? tracks.get(3) : tracks.get(switch1 ? 0 : 3);
				}
				if(eqCopy(track, 3)){
					return crossing ? tracks.get(2) : tracks.get(switch0 ? 1 : 2);
				}
			}
		}
		return null;
	}

	private boolean eqCopy(String track, int i){
		return tracks.get(i).getId().equals(track);
	}
	
}