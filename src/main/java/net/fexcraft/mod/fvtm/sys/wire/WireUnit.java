package net.fexcraft.mod.fvtm.sys.wire;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;

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
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("target_listener", "fvtm:wiresys");
		compound.setString("task", "update_unit_section");
		compound.setString("unit", getUID());
		compound.setLong("section", getSectionId());
		if(orig == null && copy == null){
			PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
		}
		else{
			Wire wire = orig == null ? copy : orig;
			PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(wire.relay.system.getDimension(), wire.start.pos));
			if(wire.length > 16){
				PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(wire.relay.system.getDimension(), wire.end.pos));
			}
		}
	}

}
