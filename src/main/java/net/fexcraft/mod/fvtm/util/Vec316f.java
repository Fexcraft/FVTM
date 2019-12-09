package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/**
 * <i>Junction Vector</i>
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Vec316f implements Comparable<Vec316f>{
	
	public final BlockPos pos;
	public final byte x, y, z;
	public final Vec3f vector;

	public Vec316f(Vec3d pos){
		this.pos = new BlockPos(pos);
		x = (byte)((pos.x - this.pos.getX()) / 0.0625);
		y = (byte)((pos.y - this.pos.getY()) / 0.0625);
		z = (byte)((pos.z - this.pos.getZ()) / 0.0625);
		vector = toVec3f();
	}

	public Vec316f(Vec3f pos){
		this.pos = new BlockPos(pos.xCoord, pos.yCoord, pos.zCoord);
		x = (byte)((pos.xCoord - this.pos.getX()) / 0.0625);
		y = (byte)((pos.yCoord - this.pos.getY()) / 0.0625);
		z = (byte)((pos.zCoord - this.pos.getZ()) / 0.0625);
		vector = toVec3f();
	}

	public Vec316f(Vec3d pos, int rgs){
		this.pos = new BlockPos(pos);
		byte x = (byte)((pos.x - this.pos.getX()) / 0.0625);
		byte y = (byte)((pos.y - this.pos.getY()) / 0.0625);
		byte z = (byte)((pos.z - this.pos.getZ()) / 0.0625);
		switch(rgs){
			case 1: x = y = z = 0; break;
			case 2:{
				x = x < 8 ? 0 : x > 8 ? 8 : x;
				y = y < 8 ? 0 : y > 8 ? 8 : y;
				z = z < 8 ? 0 : z > 8 ? 8 : z;
				break;
			}
			case 4:{
				x = x < 4 ? 0 : x < 8 ? 4 : x < 12 ? 8 : x < 16 ? 12 : x;
				y = y < 4 ? 0 : y < 8 ? 4 : y < 12 ? 8 : y < 16 ? 12 : y;
				z = z < 4 ? 0 : z < 8 ? 4 : z < 12 ? 8 : z < 16 ? 12 : z;
				break;
			}
			case 8:{
				x = x < 2 ? 0 : x < 4 ? 2 : x < 6 ? 4 : x < 8 ? 6 : x < 10 ? 8 : x < 12 ? 10 : x < 14 ? 12 : x < 16 ? 14 : x;
				y = y < 2 ? 0 : y < 4 ? 2 : y < 6 ? 4 : y < 8 ? 6 : y < 10 ? 8 : y < 12 ? 10 : y < 14 ? 12 : y < 16 ? 14 : y;
				z = z < 2 ? 0 : z < 4 ? 2 : z < 6 ? 4 : z < 8 ? 6 : z < 10 ? 8 : z < 12 ? 10 : z < 14 ? 12 : z < 16 ? 14 : z;
				break;
			}
			case 16: default: break;
		}
		this.x = x; this.y = y; this.z = z; vector = toVec3f();
	}

	public Vec316f(NBTTagCompound compound){
		pos = BlockPos.fromLong(compound.getLong("vec_pos"));
		x = compound.getByte("pos_x"); y = compound.getByte("pos_y");
		z = compound.getByte("pos_z"); vector = toVec3f();
	}

	public Vec316f(int px, int py, int pz, byte x, byte y, byte z){
		pos = new BlockPos(px, py, pz); this.x = x; this.y = y; this.z = z; vector = toVec3f();
	}

	public Vec316f(Vec316f other){
		pos = new BlockPos(other.pos);
		x = other.x; y = other.y; z = other.z;
		vector = new Vec3f(other.vector);
	}

	public NBTTagCompound write(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("vec_pos", pos.toLong());
		compound.setByte("pos_x", x); compound.setByte("pos_y", y);
		compound.setByte("pos_z", z); return compound;
	}

	private Vec3f toVec3f(){
		return new Vec3f(pos.getX() + (x * 0.0625f), pos.getY() + (y * 0.0625f), pos.getZ() + (z * 0.0625f));
	}

	@Override
	public int compareTo(Vec316f o){
		if(o.pos.compareTo(pos) == 0){
			if(o.y > y) return 1; else if(o.y < y) return -1;
			if(o.x > x) return 1; else if(o.x < x) return -1;
			if(o.z > z) return 1; else if(o.z < z) return -1;
			return 0;
		} return o.pos.compareTo(pos);
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Vec3f) return ((Vec3f)obj).equals(vector);
		if(obj instanceof Vec316f == false) return false; Vec316f vec = (Vec316f)obj;
		if(vec.pos.equals(pos)) return vec.x == x && vec.y == y && vec.z == z; else return false;
	}
	
	@Override
	public String toString(){
		return "(" + vector.xCoord + ", " + vector.yCoord + ", " + vector.zCoord + ")";
	}

	public String asIDString(){
		return pos.getX() + "," + pos.getY() + "," + pos.getZ() + "|" + x + "," + y + "," + z;
	}
	
	public static Vec316f fromIDString(String str){
		String[] arr0 = str.split("|"), arr1 = arr0[1].split(","); arr0 = arr0[0].split(",");
		int[] pxyz = new int[3]; byte[] xyz = new byte[3];
		for(int i = 0; i < 3; i++){ pxyz[i] = Integer.parseInt(arr0[i]); xyz[i] = Byte.parseByte(arr1[i]); }
		return new Vec316f(pxyz[0], pxyz[1], pxyz[2], xyz[0], xyz[1], xyz[2]);
	}
	
	public static Vec316f fromIDString(String str, boolean safe){
		if(!safe) return fromIDString(str); try{
			String[] arr0 = str.split("|"), arr1 = arr0[1].split(","); arr0 = arr0[0].split(",");
			int[] pxyz = new int[3]; byte[] xyz = new byte[3];
			for(int i = 0; i < 3; i++){ pxyz[i] = Integer.parseInt(arr0[i]); xyz[i] = Byte.parseByte(arr1[i]); }
			return new Vec316f(pxyz[0], pxyz[1], pxyz[2], xyz[0], xyz[1], xyz[2]);
		} catch(Exception e){ e.printStackTrace(); return null; }
	}

}
