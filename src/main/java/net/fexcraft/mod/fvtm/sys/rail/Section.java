package net.fexcraft.mod.fvtm.sys.rail;

import java.util.Collection;
import java.util.HashSet;

import net.fexcraft.lib.common.math.RGB;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Section {
	
	private long uid;
	private HashSet<TrackUnit> units = new HashSet<>();
	public Long reserved;
	public RGB color = RGB.random();
	
	public Section(RailData data, Long sid){
		uid = sid == null ? data.getNewSectionId() : sid;
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
	
	public long getUID(){
		return uid;
	}

}
