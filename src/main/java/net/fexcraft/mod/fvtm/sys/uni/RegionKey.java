package net.fexcraft.mod.fvtm.sys.uni;

import java.nio.ByteBuffer;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.util.math.Vec3d;

public class RegionKey implements Comparable<RegionKey> {
	
	public final int x, z;
	
	public RegionKey(int x, int z){
		this.x = x; this.z = z;
	}
	
	public RegionKey(int[] arr){
		this.x = arr[0]; this.z = arr[1];
	}
	
	public RegionKey(Vec316f vec){
		this(getRegionXZ(vec));
	}

	public RegionKey(long leng){//TODO replace this someday
		ByteBuffer buffer = ByteBuffer.allocate(8).putLong(leng);
		x = buffer.getInt(0); z = buffer.getInt(4);
	}
	
	public long toLong(){
		return ByteBuffer.allocate(8).putInt(x).putInt(z).getLong(0);
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof RegionKey == false) return false;
		return ((RegionKey)obj).x == x && ((RegionKey)obj).z == z;
	}
	
	@Override
	public int compareTo(RegionKey key){
		if(key.x > x) return 1; else if(key.x < x) return -1;
		if(key.z > z) return 1; else if(key.z < z) return -1;
		return 0;
	}
	
	@Override
	public String toString(){
		return x + ", "+ z;
	}

	public int[] toArray(){
		return new int[]{ x, z };
	}
	
	//
	
	public static int[] getRegionXZ(int cx, int cz){
		return new int[]{(int)Math.floor(cx / 32.0), (int)Math.floor(cz / 32.0)};
	}
	
	public static int[] getRegionXZ(Vec316f vec){
		return getRegionXZ((int)vec.pos.getX() >> 4, (int)vec.pos.getZ() >> 4);
	}

	public static int[] getRegionXZ(Vec3f pos){
		return getRegionXZ((int)pos.xCoord >> 4, (int)pos.zCoord >> 4);
	}

	public static int[] getRegionXZ(Vec3d vec){
		return getRegionXZ((int)vec.x >> 4, (int)vec.z >> 4);
	}

	public static int[] getRegionXZ(PathKey key){
		return getRegionXZ(key.pos[0] >> 4, key.pos[2] >> 4);
	}

	public boolean isInRegion(Vec316f vec){
		int[] id = getRegionXZ(vec); return id[0] == x && id[1] == z;
	}
	
}