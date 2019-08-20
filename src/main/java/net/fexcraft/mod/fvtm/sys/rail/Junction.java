package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Junction {
	
	private Vec316f vecpos;
	public ArrayList<Track> tracks;
	public boolean crossing, switch0, switch1;
	public RailData root;
	
	/** General Constructor */
	public Junction(RailData root, Vec316f pos){
		vecpos = pos; tracks = new ArrayList<Track>(); this.root = root;
		this.switch0 = this.switch1 = false; crossing = false;
	}
	
	/** Only to be used from RailRegion.class */
	protected Junction(RailData world){
		this.root = world;
	}

	public Junction setRoot(RailData data){
		this.root = data; return this;
	}
	
	public Junction read(NBTTagCompound compound){
		this.vecpos = new Vec316f(compound.getCompoundTag("Pos"));
		this.switch0 = compound.getBoolean("Switch0");
		this.switch1 = compound.getBoolean("Switch1");
		this.crossing = compound.getBoolean("Crossing");
		int trackam = compound.getInteger("Tracks");
		if(trackam > 0){
			for(int i = 0; i < trackam; i++){
				tracks.add(new Track().read(compound.getCompoundTag("Track-" + i)));
			}
		}
		return this;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		for(int i = 0; i < tracks.size(); i++){
			compound.setTag("Track-" + i, tracks.get(i).write(null));
		}
		compound.setInteger("Tracks", tracks.size());
		compound.setBoolean("Switch0", switch0);
		compound.setBoolean("Switch1", switch1);
		compound.setBoolean("Crossing", crossing);
		compound.setTag("Pos", vecpos.write());
		return compound;
	}
	
	public Vec316f getVec316f(){
		return vecpos;
	}
	
	public Vec3f getVec3f(){
		return vecpos.vector;
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
			Junction junk = root.getJunction(track.start.equals(vecpos) ? track.end : track.start);
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
	
	public boolean allowsSpawningOn(){
		return true;
	}

}
