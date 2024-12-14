package net.fexcraft.mod.fvtm.sys.wire;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireKey {
	
	public final V3I start_pos, end_pos;
	public final String start_relay, end_relay;
	
	public WireKey(WireRelay start, WireRelay end){
		start_pos = start.holder.pos;
		start_relay = start.key;
		end_pos = end.holder.pos;
		end_relay = end.key;
	}
	
	public WireKey(TagCW compound){
		start_pos = compound.getV3I("spos");
		end_pos = compound.getV3I("epos");
		start_relay = compound.getString("skey");
		end_relay = compound.getString("ekey");
	}
	
	public WireKey(V3I spos, String skey, V3I epos, String ekey){
		start_pos = spos;
		start_relay = skey;
		end_pos = epos;
		end_relay = ekey;
	}

	/** Only for temporary use. */
	public WireKey(long pos, String string){
		start_pos = end_pos = WrapperHolder.getPos(pos);
		start_relay = end_relay = string;
	}

	public TagCW save(TagCW compound){
		if(compound == null) compound = TagCW.create();
		compound.set("spos", start_pos, true);
		compound.set("epos", end_pos, true);
		compound.set("skey", start_relay);
		compound.set("ekey", end_relay);
		return compound;
	}
	
	public String toString(){
		return str(start_pos) + ":" + start_relay + ":" + end_relay + ":" + str(end_pos);
	}
	
	public static String str(V3I pos){
		return pos.x + "," + pos.y + "," + pos.z;
	}

	public boolean equals(Object obj){
		if(obj instanceof WireKey){
			WireKey o = (WireKey)obj;
			return start_pos.equals(o.start_pos) && end_pos.equals(o.end_pos) && start_relay.endsWith(o.start_relay) && end_relay.equals(o.end_relay);
		}
		else return String.valueOf(obj).equals(toString());
	}

	public WireKey opposite(){
		return new WireKey(end_pos, end_relay, start_pos, start_relay);
	}

}
