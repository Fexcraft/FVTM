package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.uni.tag.TagCW;

import java.util.concurrent.ConcurrentLinkedQueue;

import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class TrackUnit {
	
	private ConcurrentLinkedQueue<RailEntity> entities = new ConcurrentLinkedQueue<>();
	private RailSystem data;
	protected Track orig, copy;
	private Section section;
	private String uid;
	
	public TrackUnit(RailSystem data, String str, Long sid){
		uid = str;
		section = (this.data = data).getSection(sid);
		section.insert(this);
	}
	
	public void update(RailEntity ent, boolean add){
		if(add) entities.add(ent);
		else entities.remove(ent);
	}
	
	public ConcurrentLinkedQueue<RailEntity> getEntities(){
		return entities;
	}

	public boolean hasCompound(Compound except){
		if(except == null) return entities.size() > 0;
		for(RailEntity ent : entities){
			if(ent.com.getUID() != except.getUID()) return true;
		}
		return false;
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
		if(o instanceof TrackUnit == false) return false;
		return ((TrackUnit)o).uid.equals(uid);
	}

	public TrackUnit setSection(Section section, boolean update){
		this.section = section;
		if(update) updateClient();
		return this;
	}
	
	@Override
	public String toString(){
		return "TrackUnit[" + uid + "/" + (section == null ? "NULL" : section.getUID()) + "]";
	}

	private void updateClient(){
		if(data.isRemote()) return;
		TagCW compound = TagCW.create();
		compound.set("unit", getUID());
		compound.set("section", getSectionId());
		if(orig == null && copy == null){
			Packets.sendToAll(PKT_TAG, "rail_upd_unit_section", compound);
		}
		else{
			Track track = orig == null ? copy : orig;
			Packets.sendToAllTrackingPos(PKT_TAG, track.junction.root.getWorldW(), track.start.vec, "rail_upd_unit_section", compound);
			if(track.length > 16){
				Packets.sendToAllTrackingPos(PKT_TAG, track.junction.root.getWorldW(), track.end.vec, "rail_upd_unit_section", compound);
			}
		}
	}

}
