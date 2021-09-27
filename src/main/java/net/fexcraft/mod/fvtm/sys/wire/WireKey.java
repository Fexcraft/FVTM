package net.fexcraft.mod.fvtm.sys.wire;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireKey {
	
	public final BlockPos start_pos, end_pos;
	public final String start_relay, end_relay;
	
	public WireKey(WireRelay start, WireRelay end){
		start_pos = start.holder.pos;
		start_relay = start.key;
		end_pos = end.holder.pos;
		end_relay = end.key;
	}
	
	public WireKey(NBTTagCompound compound){
		start_pos = BlockPos.fromLong(compound.getLong("spos"));
		end_pos = BlockPos.fromLong(compound.getLong("epos"));
		start_relay = compound.getString("skey");
		end_relay = compound.getString("ekey");
	}
	
	public WireKey(BlockPos spos, String skey, BlockPos epos, String ekey){
		start_pos = spos;
		start_relay = skey;
		end_pos = epos;
		end_relay = ekey;
	}

	/** Only for temporary use. */
	public WireKey(long pos, String string){
		start_pos = end_pos = BlockPos.fromLong(pos);
		start_relay = end_relay = string;
	}

	public NBTTagCompound save(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setLong("spos", start_pos.toLong());
		compound.setLong("epos", end_pos.toLong());
		compound.setString("skey", start_relay);
		compound.setString("ekey", end_relay);
		return compound;
	}
	
	public String toString(){
		return str(start_pos) + ":" + start_relay + ":" + end_relay + ":" + str(end_pos);
	}
	
	public static String str(BlockPos pos){
		return pos.getX() + "," + pos.getY() + "," + pos.getZ();
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
