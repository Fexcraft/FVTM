package net.fexcraft.mod.fvtm.sys.wire;

import net.minecraft.nbt.NBTTagCompound;

public class WireKey {
	
	public final long start_pos, end_pos;
	public final String start_relay, end_relay;
	
	public WireKey(WireRelay start, WireRelay end){
		start_pos = start.holder.pos.toLong();
		start_relay = start.key;
		end_pos = end.holder.pos.toLong();
		end_relay = end.key;
	}
	
	public WireKey(NBTTagCompound compound){
		start_pos = compound.getLong("spos");
		end_pos = compound.getLong("epos");
		start_relay = compound.getString("skey");
		end_relay = compound.getString("ekey");
	}
	
	public WireKey(long spos, String skey, long epos, String ekey){
		start_pos = spos;
		start_relay = skey;
		end_pos = epos;
		end_relay = ekey;
	}

	public NBTTagCompound save(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setLong("spos", start_pos);
		compound.setLong("epos", end_pos);
		compound.setString("skey", start_relay);
		compound.setString("ekey", end_relay);
		return compound;
	}
	
	public String toString(){
		return start_pos + ":" + start_relay + ":" + end_relay + ":" + end_pos;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof WireKey){
			WireKey o = (WireKey)obj;
			return start_pos == o.start_pos && end_pos == o.end_pos && start_relay.endsWith(o.start_relay) && end_relay.equals(o.end_relay);
		}
		else return String.valueOf(obj).equals(toString());
	}

	public WireKey opposite(){
		return new WireKey(end_pos, end_relay, start_pos, start_relay);
	}

}
