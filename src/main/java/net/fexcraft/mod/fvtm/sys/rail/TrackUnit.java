package net.fexcraft.mod.fvtm.sys.rail;

import java.util.TreeMap;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class TrackUnit {
	
	private TreeMap<Long, RailEntity> entities = new TreeMap<>();
	private Section section;
	private String uid;
	
	public TrackUnit(RailData data, String str, Long sid){
		uid = str; section = data.getSection(sid); section.insert(this);
	}
	
	public void update(RailEntity ent, boolean add){
		if(add) entities.put(ent.getUID(), ent);
		else entities.remove(ent.getUID());
	}
	
	public TreeMap<Long, RailEntity> getEntities(){
		return entities;
	}

	public boolean hasEntities(RailEntity except){
		if(except != null && entities.containsKey(except.getUID())){
			for(Long leng : entities.keySet()) if(leng != except.getUID()) return true;
		}
		return entities.size() > 0;
	}

	public String getUID(){
		return uid;
	}

	public long getSectionId(){
		return section.getUID();
	}
	
	public Section section(){
		return section;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof TrackUnit) return false; return ((TrackUnit)o).uid.equals(uid) || super.equals(o);
	}

	public TrackUnit setSection(Section section){
		this.section = section; return this;
	}

}
