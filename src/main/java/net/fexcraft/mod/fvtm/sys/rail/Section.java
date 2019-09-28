package net.fexcraft.mod.fvtm.sys.rail;

import java.util.TreeMap;

public class Section {
	
	private TreeMap<Long, RailEntity> entities = new TreeMap<>();
	public String id;
	
	public Section(String id){
		this.id = id;
	}
	
	public void update(RailEntity ent, boolean add){
		if(add) entities.put(ent.getUID(), ent);
		else entities.remove(ent.getUID());
	}
	
	public TreeMap<Long, RailEntity> getEntities(){
		return entities;
	}

	public boolean hasEntities(){
		return entities.size() > 0;
	}

}
