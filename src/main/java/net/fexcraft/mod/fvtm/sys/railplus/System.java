package net.fexcraft.mod.fvtm.sys.railplus;

import java.util.TreeMap;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class System {
	
	public static final TreeMap<Long, Compound> active = new TreeMap<>();
	public static final TreeMap<Long, Section> sections = new TreeMap<>();
	//
	public static int nextSectionId;

	public static Section getAbschnitt(long lang, boolean create){
		if(!sections.containsKey(lang)){
			Section section = new Section(lang);
			sections.put(lang, section);
			return section;
		}
		return sections.get(lang);
	}

}
