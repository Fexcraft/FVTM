package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;

public class PathKey implements Comparable<PathKey> {
	
	private static final int[] order = new int[]{ 1, 0, 2, 4, 3, 5 };
	protected int[] pos = new int[6];
	protected byte[] xyz = new byte[6];
	
	public PathKey(QV3D start, QV3D end){
		pos[0] = start.pos.x;
		pos[1] = start.pos.y;
		pos[2] = start.pos.z;
		pos[3] = end.pos.x;
		pos[4] = end.pos.y;
		pos[5] = end.pos.z;
		xyz[0] = start.x;
		xyz[1] = start.y;
		xyz[2] = start.z;
		xyz[3] = end.x;
		xyz[4] = end.y;
		xyz[5] = end.z;
	}

	public String toUnitId(boolean opposite){
		if(opposite){
			return pos[3] + "," + pos[4] + "," + pos[5] + ";" + xyz[3] + "," + xyz[4] + "," + xyz[5]
				+ ":" + pos[0] + "," + pos[1] + "," + pos[2] + ";" + xyz[0] + "," + xyz[1] + "," + xyz[2];
		}
		else{
			return pos[0] + "," + pos[1] + "," + pos[2] + ";" + xyz[0] + "," + xyz[1] + "," + xyz[2]
				+ ":" + pos[3] + "," + pos[4] + "," + pos[5] + ";" + xyz[3] + "," + xyz[4] + "," + xyz[5];
		}
	}

	public PathKey(TagCW compound){
		if(compound.has("key_pos")) pos = compound.getIntArray("key_pos");
		if(compound.has("key_xyz")) xyz = compound.getByteArray("key_xyz");
	}
	
	public TagCW write(TagCW compound){
		compound.set("key_pos", pos);
		compound.set("key_xyz", xyz);
		return compound;
	}

	public PathKey(PathKey key, boolean opposite){
		if(opposite){
			pos[0] = key.pos[3];
			pos[1] = key.pos[4];
			pos[2] = key.pos[5];
			pos[3] = key.pos[0];
			pos[4] = key.pos[1];
			pos[5] = key.pos[2];
			xyz[0] = key.xyz[3];
			xyz[1] = key.xyz[4];
			xyz[2] = key.xyz[5];
			xyz[3] = key.xyz[0];
			xyz[4] = key.xyz[1];
			xyz[5] = key.xyz[2];
		}
		else{
			pos = key.pos;
			xyz = key.xyz;
		}
	}

	@Override
	public int compareTo(PathKey o){
		for(int i = 0; i < 6; i++){
			if(o.pos[order[i]] > pos[order[i]]) return 1;
			if(o.pos[order[i]] < pos[order[i]]) return -1;
		}
		for(int i = 0; i < 6; i++){
			if(o.xyz[order[i]] > xyz[order[i]]) return 1;
			if(o.xyz[order[i]] < xyz[order[i]]) return -1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof PathKey == false) return false;
		PathKey key = (PathKey)obj;
		for(int i = 0; i < 6; i++){
			if(key.pos[i] != pos[i] || key.xyz[i] != xyz[i]) return false;
		}
		return true;
	}

	public QV3D toQV3D(int i){
		return QV3D.exact(pos[0 + i], pos[1 + i], pos[2 + i], xyz[0 + i], xyz[1 + i], xyz[2 + i]);
	}
	
	@Override
	public String toString(){
		return String.format("[ %s,%s - %s,%s - %s,%s / %s,%s - %s,%s - %s,%s ]", pos[0], xyz[0], pos[1], xyz[1], pos[2], xyz[2], pos[3], xyz[3], pos[4], xyz[4], pos[5], xyz[5]);
	}

}
