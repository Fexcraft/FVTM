package net.fexcraft.mod.fvtm.sys.wire;

import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireUnit {
	
	private WireSystem data;
	protected Wire orig, copy;
	private WireSection section;
	private String uid;
	
	public WireUnit(WireSystem data, String str, Long sid){
		uid = str;
		section = (this.data = data).getSection(sid);
		section.insert(this);
	}

	public String getUID(){
		return uid;
	}

	public long getSectionId(){
		return section.getUID();
	}
	
	public WireSection section(){
		return section;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof WireUnit == false) return false;
		return ((WireUnit)o).uid.equals(uid);
	}

	public WireUnit setSection(WireSection section){
		this.section = section;
		this.updateClient();
		return this;
	}
	
	@Override
	public String toString(){
		return "WireUnit[" + uid + "/" + (section == null ? "NULL" : section.getUID()) + "]";
	}

	private void updateClient(){
		if(data.isRemote()) return;
		TagCW compound = TagCW.create();
		compound.set("target_listener", "fvtm:wiresys");
		compound.set("task", "update_unit_section");
		compound.set("unit", getUID());
		compound.set("section", getSectionId());
		if(orig == null && copy == null){
			Packets.sendToAll(Packet_TagListener.class, "wire_udp_unit", compound);
		}
		else{
			Wire wire = orig == null ? copy : orig;
			Packets.sendToAll(Packet_TagListener.class, wire.relay.holder.getRegion().system.getServerWorld(), wire.relay.holder.pos, "wire_udp_unit", compound);
			if(wire.length > 16 && orig != null){
				Packets.sendToAll(Packet_TagListener.class, wire.relay.holder.getRegion().system.getServerWorld(), copy.relay.holder.pos, "wire_udp_unit", compound);
			}
		}
	}

}
