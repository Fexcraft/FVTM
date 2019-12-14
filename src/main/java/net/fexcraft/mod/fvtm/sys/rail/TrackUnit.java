package net.fexcraft.mod.fvtm.sys.rail;

import java.util.TreeMap;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class TrackUnit {
	
	private TreeMap<Long, RailEntity> entities = new TreeMap<>();
	protected Track orig, copy;
	private Section section;
	private String uid;
	
	public TrackUnit(System data, String str, Long sid){
		uid = str; section = data.getSection(sid); section.insert(this);
	}
	
	public void update(RailEntity ent, boolean add){
		if(add) entities.put(ent.getUID(), ent);
		else entities.remove(ent.getUID());
	}
	
	public TreeMap<Long, RailEntity> getEntities(){
		return entities;
	}

	public boolean hasCompound(Compound except){
		if(except == null) return entities.size() > 0;
		for(RailEntity ent : entities.values()){
			if(ent.com.getUID() != except.getUID()) return true;
		} return false;
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
		if(o instanceof TrackUnit == false) return false; return ((TrackUnit)o).uid.equals(uid);
	}

	public TrackUnit setSection(Section section){
		this.section = section; this.updateClient(); return this;
	}
	
	@Override
	public String toString(){
		return "TrackUnit[" + uid + "/" + (section == null ? "NULL" : section.getUID()) + "]";
	}

	private void updateClient(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("target_listener", "fvtm:railsys");
		compound.setString("task", "update_unit_section");
		compound.setString("unit", getUID());
		compound.setLong("section", getSectionId());
		if(orig == null && copy == null){
			PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
		}
		else{
			Track track = orig == null ? copy : orig;
			PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound),
				Resources.getTargetPoint(track.junction.root.getDimension(), track.start.pos));
			if(track.length > 16){
				PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound),
					Resources.getTargetPoint(track.junction.root.getDimension(), track.end.pos));
			}
		}
	}

}
