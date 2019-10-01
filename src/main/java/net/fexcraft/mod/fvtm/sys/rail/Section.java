package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Print;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Section {
	
	private long uid;
	private RailData data;
	private HashSet<TrackUnit> units = new HashSet<>();
	public Long reserved;
	public RGB color = RGB.random();
	
	public Section(RailData data, Long sid){
		this.data = data; uid = sid == null ? data.getNewSectionId() : sid;
		Print.debug("Created Section [" + sid + "] " + (sid == null));
	}
	
	public Section fill(TrackUnit... tracks){
		for(TrackUnit track : tracks) units.add(track); return this;
	}
	
	public Section fill(Collection<TrackUnit> tracks){
		units.addAll(tracks); return this;
	}

	public void insert(TrackUnit unit){
		units.add(unit);
	}

	public void insert(Section other){
		for(TrackUnit unit : other.units){ units.add(unit.setSection(this)); }
		other.units.clear(); data.getSections().remove(other.getUID());
	}
	
	public long getUID(){
		return uid;
	}

	/** Called after a track was removed via {@link net.fexcraft.mod.fvtm.sys.rail.RailData#delTrack(Track) delTrack} .*/
	public void splitAtTrack(Track track){
		Junction end = data.getJunction(track.end); if(end == null) return;
		ArrayList<TrackUnit> list0 = new ArrayList<>(), list1 = new ArrayList<>(), /*more,*/ less;
		list0 = explore(track.junction.getNext(null, track.id, false), list0);
		list1 = explore(end.getNext(null, track.getOppositeId(), false), list1);
		for(TrackUnit unit : list0){
			if(list1.contains(unit)) return;//section still linked somewhere, do not split
		}
		if(list0.size() > list1.size()){ /*more = list0;*/ less = list1; } else{ /*more = list1;*/ less = list0; }
		if(less.isEmpty()) return;//no connected tracks, needs no action either
		Section section = data.getSection(null);//create new section
		for(TrackUnit unit : less){
			unit.setSection(section);//assign new section to the smaller list
		}
	}
	
	public void splitAtSignal(Junction junction){
		ArrayList<TrackUnit> list0 = new ArrayList<>(), list1 = new ArrayList<>(), less;
		list0.add(junction.tracks.get(0).unit); list1.add(junction.tracks.get(1).unit);
		Junction end0 = data.getJunction(junction.tracks.get(0).end);
		Junction end1 = data.getJunction(junction.tracks.get(1).end);
		list0 = explore(end0.getNext(null, junction.tracks.get(0).getOppositeId(), false), list0);
		list1 = explore(end1.getNext(null, junction.tracks.get(1).getOppositeId(), false), list1);
		for(TrackUnit unit : list0){
			if(list1.contains(unit)) return;//section still linked somewhere, do not split
		}
		if(list0.size() > list1.size()){ less = list1; } else{ less = list0; } if(less.isEmpty()) return;
		Section section = data.getSection(null); for(TrackUnit unit : less){ unit.setSection(section); }
	}

	private ArrayList<TrackUnit> explore(Track next, ArrayList<TrackUnit> list){
		if(next == null) return list; ArrayList<Track> tracks = new ArrayList<>();
		for(Track track : next.junction.tracks){ if(track.unit.getSectionId() == uid) tracks.add(track); }
		for(Track track : tracks){
			if(list.contains(track.unit)) continue; list.add(track.unit);
			Junction junc = data.getJunction(track.end); if(junc == null) continue;
			list = explore(junc.getNext(null, track.getOppositeId(), false), list);
		} return list;
	}

	public boolean isFree(RailEntity except){
		return isFree(except == null ? null : except.com);
	}

	public boolean isFree(Compound except){
		for(TrackUnit unit : units){
			if(unit.hasCompound(except)) return false;
		} return true;
	}

	public int size(){
		return units.size();
	}

	public boolean remove(Track track){
		return units.remove(track.unit);
	}

}
