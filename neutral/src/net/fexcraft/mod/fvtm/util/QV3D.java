package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 *
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class QV3D implements Comparable<QV3D> {

	public final V3I pos;
	public final V3D vec;
	public final byte x;
	public final byte y;
	public final byte z;

	public QV3D(){
		pos = new V3I();
		vec = new V3D();
		x = y = z = 0;
	}

	public QV3D(double px, double py, double pz, int div){
		pos = new V3I((int)px, (int)py, (int)pz);
		byte bx = (byte)((px - pos.x) / 0.0625);
		byte by = (byte)((py - pos.y) / 0.0625);
		byte bz = (byte)((pz - pos.z) / 0.0625);
		if(div != 16){
			if(bx < 8) bx = 0;
			if(bx > 8) bx = 8;
			if(by < 8) by = 0;
			if(by > 8) by = 8;
			if(bz < 8) bz = 0;
			if(bz > 8) bz = 8;
		}
		x = bx;
		y = by;
		z = bz;
		vec = toVec();
	}

	public QV3D(V3D pos, int div){
		this(pos.x, pos.y, pos.z, div);
	}

	public QV3D(QV3D other){
		pos = other.pos.copy();
		x = other.x;
		y = other.y;
		z = other.z;
		vec = other.vec.copy();
	}

	public QV3D(TagCW com, String tag){
		vec = com.getV3D(tag == null ? "vector" : tag);
		pos = new V3I(vec);
		x = (byte)((vec.x - pos.x) / 0.0625);
		y = (byte)((vec.y - pos.y) / 0.0625);
		z = (byte)((vec.z - pos.z) / 0.0625);
	}

	private QV3D(int px, int py, int pz, byte xc, byte yc, byte zc){
		pos = new V3I(px, py, pz);
		x = xc;
		y = yc;
		z = zc;
		vec = toVec();
	}

	public static QV3D exact(int px, int py, int pz, byte xc, byte yc, byte zc){
		return new QV3D(px, py, pz, xc, yc, zc);
	}

	public TagCW write(TagCW com, String tag){
		if(com == null) com = TagCW.create();
		com.set(tag == null ? "vector" : tag, vec);
		return com;
	}

	private V3D toVec(){
		return new V3D(pos.x + (x * 0.0625), pos.y + (y * 0.0625), pos.z + (z * 0.0625));
	}

	@Override
	public int compareTo(QV3D o){
		if(o.pos.y > pos.y) return 1;
		if(o.pos.y < pos.y) return -1;
		if(o.pos.x > pos.x) return 1;
		if(o.pos.x < pos.x) return -1;
		if(o.pos.z > pos.z) return 1;
		if(o.pos.z < pos.z) return -1;
		if(o.y > y) return 1;
		if(o.y < y) return -1;
		if(o.x > x) return 1;
		if(o.x < x) return -1;
		if(o.z > z) return 1;
		if(o.z < z) return -1;
		return 0;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof V3D) return obj.equals(vec);
		if(obj instanceof QV3D == false) return false;
		QV3D vec = (QV3D)obj;
		return vec.pos.equals(pos) && x == x && y == y && z == z;
	}

	@Override
	public String toString(){
		return "(" + vec.x + ", " + vec.y + ", " + vec.z + ")";
	}

	public String asIDString(){
		return pos.x + "," + pos.y + "," + pos.z + "|" + x + "," + y + "," + z;
	}

	public static QV3D fromIDString(String str){
		String[] arr0 = str.split("\\|"), arr1 = arr0[1].split(",");
		arr0 = arr0[0].split(",");
		int[] pxyz = new int[3];
		byte[] xyz = new byte[3];
		for(int i = 0; i < 3; i++){
			pxyz[i] = Integer.parseInt(arr0[i]);
			xyz[i] = Byte.parseByte(arr1[i]);
		}
		return new QV3D(pxyz[0], pxyz[1], pxyz[2], xyz[0], xyz[1], xyz[2]);
	}

	public QV3D copy(){
		return new QV3D(this);
	}

}
