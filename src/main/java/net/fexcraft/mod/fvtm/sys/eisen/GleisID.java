package net.fexcraft.mod.fvtm.sys.eisen;

import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class GleisID implements Comparable<GleisID> {
	
	private static final int[] order = new int[]{ 1, 0, 2, 4, 3, 5 };
	protected int[] pos = new int[6];
	protected byte[] xyz = new byte[6];

	public GleisID(Vec316f start, Vec316f ende){
		pos[0] = start.pos.getX(); pos[1] = start.pos.getY(); pos[2] = start.pos.getZ();
		pos[3] = ende.pos.getX(); pos[4] = ende.pos.getY(); pos[5] = ende.pos.getZ();
		xyz[0] = start.x; xyz[1] = start.y; xyz[2] = start.z; xyz[3] = ende.x; xyz[4] = ende.y; xyz[5] = ende.z;
	}

	public String toStringId(boolean opposite){
		return pos[0] + "," + pos[1] + "," + pos[2] + ";" + xyz[0] + "," + xyz[1] + "," + xyz[2]
			+ ":" + pos[3] + "," + pos[4] + "," + pos[5] + ";" + xyz[3] + "," + xyz[4] + "," + xyz[5];
	}

	public GleisID(NBTTagCompound compound){
		if(compound.hasKey("key_pos")) pos = compound.getIntArray("key_pos");
		if(compound.hasKey("key_xyz")) xyz = compound.getByteArray("key_xyz");
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		compound.setIntArray("key_pos", pos); compound.setByteArray("key_xyz", xyz); return compound;
	}

	@Override
	public int compareTo(GleisID o){
		for(int i = 0; i < 6; i++){ if(o.pos[order[i]] > pos[order[i]]) return 1; if(o.pos[order[i]] < pos[order[i]]) return -1; }
		for(int i = 0; i < 6; i++){ if(o.xyz[order[i]] > xyz[order[i]]) return 1; if(o.xyz[order[i]] < xyz[order[i]]) return -1; }
		return 0;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof GleisID == false) return false; GleisID key = (GleisID)obj;
		for(int i = 0; i < 6; i++){ if(key.pos[i] != pos[i] || key.xyz[i] != xyz[i]) return false; }
		return true;
	}

	public Vec316f toVec316f(int i){
		return new Vec316f(pos[0 + i], pos[1 + i], pos[2 + i], xyz[0 + i], xyz[1 + i], xyz[2 + i]);
	}

}
