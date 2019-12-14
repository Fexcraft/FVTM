package net.fexcraft.mod.fvtm.sys.railplus;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.sys.rail.RegionKey;
import net.minecraft.world.World;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class System {
	
	public final TreeMap<Long, Compound> active = new TreeMap<>();
	public final TreeMap<Long, Section> sections = new TreeMap<>();
	public final TreeMap<RegionKey, Region> regions = new TreeMap<>();
	//
	public static int nextSectionId;
	//
	public final World world;
	public final int dimension;

	public System(World world, int dimension){
		this.world = world; this.dimension = dimension;
	}

	public Section getSection(long lang, boolean create){
		if(!sections.containsKey(lang)){
			return createSection(lang);
		} return sections.get(lang);
	}
	
	public Section createSection(Long newid){
		newid = newid == null ? nextSectionId++ : newid;
		Section section = new Section(newid);
		sections.put(newid, section);
		return section;
	}

	public boolean isRemote(){
		return world.isRemote;
	}

}
