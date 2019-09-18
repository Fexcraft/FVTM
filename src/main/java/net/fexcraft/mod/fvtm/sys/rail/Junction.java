package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.sys.rail.Track.TrackKey;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Junction {
	
	private Vec316f vecpos;
	public ArrayList<Track> tracks;
	public boolean switch0, switch1;
	public RailData root;
	public Signal signal;
	public JunctionType type;
	
	/** General Constructor */
	public Junction(RailData root, Vec316f pos){
		vecpos = pos; tracks = new ArrayList<Track>(); this.root = root;
		this.switch0 = this.switch1 = false; type = JunctionType.STRAIGHT;
	}
	
	/** Only to be used from RailRegion.class */
	protected Junction(RailData world){
		this.root = world; tracks = new ArrayList<>();
	}

	public Junction setRoot(RailData data){
		this.root = data; return this;
	}
	
	public Junction read(NBTTagCompound compound){
		this.vecpos = new Vec316f(compound.getCompoundTag("Pos"));
		this.switch0 = compound.getBoolean("Switch0");
		this.switch1 = compound.getBoolean("Switch1");
		//this.crossing = compound.getBoolean("Crossing");
		int trackam = compound.getInteger("Tracks");
		if(trackam > 0){
			for(int i = 0; i < trackam; i++){
				try{ tracks.add(new Track(this).read(compound.getCompoundTag("Track" + i))); }
				catch(Exception e){ e.printStackTrace(); }
			}
		}
		if(compound.hasKey("Signal")) signal = Signal.valueOf(compound.getString("Signal"));
		if(tracks.size() > 2) type = compound.hasKey("Type") ? JunctionType.valueOf(compound.getString("Type"))
			: tracks.size() == 3 ? JunctionType.FORK_2 : JunctionType.CROSSING;
		else type = JunctionType.STRAIGHT;
		return this;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		for(int i = 0; i < tracks.size(); i++){
			compound.setTag("Track" + i, tracks.get(i).write(null));
		}
		compound.setInteger("Tracks", tracks.size());
		compound.setBoolean("Switch0", switch0);
		compound.setBoolean("Switch1", switch1);
		//compound.setBoolean("Crossing", crossing);
		compound.setTag("Pos", vecpos.write());
		if(signal != null) compound.setString("Signal", signal.name());
		if(tracks.size() > 2) compound.setString("Type", type.name());
		return compound;
	}
	
	public Vec316f getVec316f(){
		return vecpos;
	}
	
	public Vec3f getVec3f(){
		return vecpos.vector;
	}

	public void addnew(Track track){
		tracks.add(track); updateClient();
	}
	
	private void updateClient(){
		root.getRegions().get(RailData.getRegionXZ(vecpos)).updateClient(vecpos);
	}

	public void remove(TrackKey trackid, boolean firstcall){
		Track track = null;
		for(int i = 0; i < tracks.size(); i++){
			if(tracks.get(i).getId().equals(trackid)){ track = tracks.remove(i); break; }
		}
		if(track == null) return;
		if(firstcall){
			Junction junk = root.getJunction(track.start.equals(vecpos) ? track.end : track.start);
			if(junk != null) junk.remove(track.getOppositeId(), false);
		}
		this.updateClient();
	}

	public void clear(){
		ArrayList<Track> trecks = new ArrayList<Track>();
		for(Track track : tracks){ trecks.add(track); }
		for(Track track : trecks) this.remove(track.getId(), true);
		tracks.clear(); this.updateClient();
	}
	
	@Nullable
	public Track getNext(TrackKey track){
		switch(tracks.size()){
			case 0: return null;
			case 1: return eqTrack(track, 0) ? null : tracks.get(0);
			case 2: return eqTrack(track, 0) ? tracks.get(1) : tracks.get(0);
			case 3:{
				if(eqTrack(track, 0)){
					return tracks.get(switch0 ? 1 : 2);
				} else return tracks.get(0);
			}
			case 4:{
				if(eqTrack(track, 0)){
					return type.isCrossing() ? tracks.get(1) : tracks.get(switch0 ? 1 : 2);
				}
				if(eqTrack(track, 1)){
					return type.isCrossing() ? tracks.get(0) : tracks.get(switch1 ? 0 : 3);
				}
				if(eqTrack(track, 2)){
					return type.isCrossing() ? tracks.get(3) : tracks.get(switch1 ? 0 : 3);
				}
				if(eqTrack(track, 3)){
					return type.isCrossing() ? tracks.get(2) : tracks.get(switch0 ? 1 : 2);
				}
			}
		}
		return null;
	}

	private boolean eqTrack(TrackKey track, int i){
		return tracks.get(i).getId().equals(track);
	}
	
	public boolean allowsSpawningOn(){
		return true;
	}

	public Track getTrack(TrackKey key){
		for(Track track : tracks) if(track.getId().equals(key)) return track; return null;
	}

	public int size(){
		return tracks.size();
	}

}
