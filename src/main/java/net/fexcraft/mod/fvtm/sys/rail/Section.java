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
	
	private final long uid;
	private RailSystem data;
	private HashSet<TrackUnit> units = new HashSet<>();
	public Long reserved;
	public RGB color = RGB.random();
	
	public Section(RailSystem data, Long sid){
		this.data = data; uid = sid == null ? data.getNewSectionId() : sid;
		Print.log("Created Section [" + (sid == null ? "new/" + uid : sid) + "]");
	}
	
	public Section fill(TrackUnit... tracks){
		for(TrackUnit track : tracks) units.add(track);
		return this;
	}
	
	public Section fill(Collection<TrackUnit> tracks){
		units.addAll(tracks);
		return this;
	}

	public void insert(TrackUnit unit){
		units.add(unit);
	}
	
	public long getUID(){
		return uid;
	}

	public void fuseAtTrack(Track zero){
		Print.log("Fusing sections at track: " + zero);
		Section old = null;
		ArrayList<TrackUnit> list = new ArrayList<>();
		list.add(zero.unit);
		list = explore(data.getJunction(zero.start), list);
		list = explore(data.getJunction(zero.end), list);
		//TODO check which section is the largest, and fuse with that one instead
		for(TrackUnit unit : list){
			if(unit.getSectionId() != uid){
				old = unit.section();
				old.units.remove(unit);
				unit.setSection(this, true);
				Print.log("Added into section '" + uid + "': " + unit);
				if(old.units.size() == 0){
					data.getSections().remove(old.getUID());
					Print.log("Removing section '" + old.getUID() + "'!");
				}
			}
		}
		units.clear();
		units.addAll(list);
		//this.updateClientSections(zero.junction, this, null);
	}

	/** Called after a track was removed from a junction.*/
	public void splitAtTrack(Track track){
		Print.log("Splitting section at track: " + track);
		ArrayList<TrackUnit> list0 = new ArrayList<>(), list1 = new ArrayList<>(), less;
		list0 = explore(data.getJunction(track.start), list0);
		list1 = explore(data.getJunction(track.end), list1);
		for(TrackUnit unit : list0){
			if(list1.contains(unit)) return;//section still linked somewhere, do not split
		}
		less = list0.size() > list1.size() ? list1 : list0;
		if(less.isEmpty()) return;//no connected tracks, needs no action either
		Section section = data.getSection(null);//create new section
		for(TrackUnit unit : less){
			unit.setSection(section, true);//assign new section to the smaller list
		}
		this.units.removeAll(less);
		section.units.addAll(less);
		Print.log("Created section '" + section.getUID() + "' and assigned TrackUnits.");
		//this.updateClientSections(track.junction, this, section);
	}

	public void splitAtSignal(Junction junction){
		Print.log("Splitting section at junction: " + junction);
		ArrayList<TrackUnit> list0 = new ArrayList<>(), list1 = new ArrayList<>(), less;
		list0.add(junction.tracks.get(0).unit);
		list1.add(junction.tracks.get(1).unit);
		list0 = explore(data.getJunction(junction.tracks.get(0).end), list0);
		list1 = explore(data.getJunction(junction.tracks.get(1).end), list1);
		for(TrackUnit unit : list0){
			if(list1.contains(unit)) return;//section still linked somewhere, do not split
		}
		less = list0.size() > list1.size() ? list1 : list0;
		if(less.isEmpty()) return;
		Section section = data.getSection(null);
		for(TrackUnit unit : less){ unit.setSection(section, true); }
		this.units.removeAll(less);
		section.units.addAll(less);
		Print.log("Created section '" + section.getUID() + "' and assigned TrackUnits.");
		//this.updateClientSections(junction, this, section);
	}

	private ArrayList<TrackUnit> explore(Junction junction, ArrayList<TrackUnit> list){
		if(junction == null) return list;
		ArrayList<Track> tracks = new ArrayList<>();
		//for(Track track : junction.tracks){ if(track.unit.getSectionId() == uid) tracks.add(track); }
		if(!junction.hasSignal(null)) tracks.addAll(junction.tracks);
		for(Track track : tracks){
			if(list.contains(track.unit)) continue;
			list.add(track.unit);
			list = explore(data.getJunction(track.end), list);
		}
		return list;
	}

	public boolean isFree(RailEntity except){
		return isFree(except == null ? null : except.com);
	}

	public boolean isFree(Compound except){
		for(TrackUnit unit : units){
			if(unit.hasCompound(except)) return false;
		}
		return true;
	}

	public int size(){
		return units.size();
	}

	public boolean remove(Track track){
		return units.remove(track.unit);
	}

	public boolean remove(TrackUnit unit){
		return units.remove(unit);
	}

	/*private void updateClientSections(Junction junction, Section sec0, Section sec1){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("target_listener", "fvtm:railsys");
		compound.setString("task", "update_sections");
		NBTTagList list = new NBTTagList();
		if(sec0 != null){
			for(TrackUnit unit : sec0.units){
				NBTTagCompound com = new NBTTagCompound();
				com.setString("unit", unit.getUID());
				com.setLong("section", unit.getSectionId());
				list.appendTag(com);
			}
		}
		if(sec1 != null){
			for(TrackUnit unit : sec1.units){
				NBTTagCompound com = new NBTTagCompound();
				com.setString("unit", unit.getUID());
				com.setLong("section", unit.getSectionId());
				list.appendTag(com);
			}
		}
		compound.setTag("units", list);
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(junction.region.getWorld().getDimension(), junction.getVec316f().pos));
	}*/

}
