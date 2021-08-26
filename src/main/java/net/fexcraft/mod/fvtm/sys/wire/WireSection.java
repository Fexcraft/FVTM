package net.fexcraft.mod.fvtm.sys.wire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import net.fexcraft.lib.mc.utils.Print;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireSection {
	
	private long uid;
	private WireSystem data;
	private HashSet<WireUnit> units = new HashSet<>();
	//public RGB color = RGB.random();
	
	public WireSection(WireSystem data, Long sid){
		this.data = data; uid = sid == null ? data.getNewSectionId() : sid;
		Print.debug("Created Section [" + sid + "] " + (sid == null));
	}
	
	public WireSection fill(WireUnit... tracks){
		for(WireUnit track : tracks) units.add(track);
		return this;
	}
	
	public WireSection fill(Collection<WireUnit> tracks){
		units.addAll(tracks);
		return this;
	}

	public void insert(WireUnit unit){
		units.add(unit);
	}
	
	public long getUID(){
		return uid;
	}

	public void fuseAtWire(Wire zero){
		Print.debug("Fusing sections at wire: " + zero);
		WireSection old = null;
		ArrayList<WireUnit> list = new ArrayList<>();
		list.add(zero.unit);
		list = explore(data.getBlock(zero.start), list);
		list = explore(data.getBlock(zero.end), list);
		//TODO check which section is the largest, and fuse with that one instead
		for(WireUnit unit : list){
			if(unit.getSectionId() != uid){
				old = unit.section();
				old.units.remove(unit);
				unit.setSection(this);
				Print.debug("Added into section '" + uid + "': " + unit);
				if(old.units.size() == 0){
					data.getSections().remove(old.getUID());
					Print.debug("Removing section '" + old.getUID() + "'!");
				}
			}
		}
		units.clear();
		units.addAll(list);
		//this.updateClientSections(zero.junction, this, null);
	}

	/** Called after a wire was removed from a block.*/
	public void splitAtWire(Wire wire){
		Print.debug("Splitting section at wire: " + wire);
		ArrayList<WireUnit> list0 = new ArrayList<>(), list1 = new ArrayList<>(), less;
		list0 = explore(data.getBlock(wire.start), list0);
		list1 = explore(data.getBlock(wire.end), list1);
		for(WireUnit unit : list0){
			if(list1.contains(unit)) return;//section still linked somewhere, do not split
		}
		less = list0.size() > list1.size() ? list1 : list0;
		if(less.isEmpty()) return;//no connected wires, needs no action either
		WireSection section = data.getSection(null);//create new section
		for(WireUnit unit : less){
			unit.setSection(section);//assign new section to the smaller list
		}
		this.units.removeAll(less);
		section.units.addAll(less);
		Print.debug("Created section '" + section.getUID() + "' and assigned WireUnits.");
	}

	public void splitAtSignal(WireBlock block){
		Print.debug("Splitting section at block: " + block);
		ArrayList<WireUnit> list0 = new ArrayList<>(), list1 = new ArrayList<>(), less;
		list0.add(block.wires.get(0).unit);
		list1.add(block.wires.get(1).unit);
		list0 = explore(data.getBlock(block.wires.get(0).end), list0);
		list1 = explore(data.getBlock(block.wires.get(1).end), list1);
		for(WireUnit unit : list0){
			if(list1.contains(unit)) return;//section still linked somewhere, do not split
		}
		if(list0.size() > list1.size()){ less = list1; }
		else{ less = list0; }
		if(less.isEmpty()) return;
		WireSection section = data.getSection(null);
		for(WireUnit unit : less){ unit.setSection(section); }
		this.units.removeAll(less);
		section.units.addAll(less);
		Print.debug("Created section '" + section.getUID() + "' and assigned WireUnits.");
		//this.updateClientSections(junction, this, section);
	}

	private ArrayList<WireUnit> explore(WireBlock block, ArrayList<WireUnit> list){
		if(block == null) return list;
		ArrayList<Wire> tracks = new ArrayList<>();
		tracks.addAll(block.wires);
		for(Wire track : tracks){
			if(list.contains(track.unit)) continue; list.add(track.unit);
			list = explore(data.getBlock(track.end), list);
		}
		return list;
	}

	public int size(){
		return units.size();
	}

	public boolean remove(Wire wire){
		return units.remove(wire.unit);
	}

	public boolean remove(WireUnit unit){
		return units.remove(unit);
	}

}
