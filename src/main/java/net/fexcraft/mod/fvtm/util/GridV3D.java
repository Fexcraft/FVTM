package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 *
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class GridV3D implements Comparable<GridV3D> {

	public final BlockPos pos;
	public final byte x, y, z;
	public final V3D vector;

	public GridV3D(Vec3d vec){
		pos = new BlockPos(vec);
		x = (byte)((vec.x - this.pos.getX()) / 0.0625);
		y = (byte)((vec.y - this.pos.getY()) / 0.0625);
		z = (byte)((vec.z - this.pos.getZ()) / 0.0625);
		vector = toVec();
	}

	public GridV3D(V3D vec){
		pos = new BlockPos(vec.x, vec.y, vec.z);
		x = (byte)((vec.x - this.pos.getX()) / 0.0625);
		y = (byte)((vec.y - this.pos.getY()) / 0.0625);
		z = (byte)((vec.z - this.pos.getZ()) / 0.0625);
		vector = toVec();
	}

	public GridV3D(World world, Vec3d pos, int rgs){
		this(validatePos(world, pos), rgs);
	}

	private static Vec3d validatePos(World world, Vec3d pos){
		if(world != null){
			IBlockState state = world.getBlockState(new BlockPos(pos));
			//if(state.getBlock() instanceof RailBlock) pos = new Vec3d(pos.x, (int)pos.y, pos.z);
		}
		return pos;
	}

	public GridV3D(Vec3d pos, int rgs){
		this(pos.x, pos.y, pos.z, rgs);
	}

	public GridV3D(V3D pos, int rgs){
		this(pos.x, pos.y, pos.z, rgs);
	}

	public GridV3D(double posx, double posy, double posz, int rgs){
		pos = new BlockPos(posx, posy, posz);
		byte x = (byte)((posx - pos.getX()) / 0.0625);
		byte y = (byte)((posy - pos.getY()) / 0.0625);
		byte z = (byte)((posz - pos.getZ()) / 0.0625);
		switch(rgs){
			case 1: x = y = z = 0; break;
			case 2:{
				x = x < 8 ? 0 : x > 8 ? 8 : x;
				//y = y < 8 ? 0 : y > 8 ? 8 : y;
				z = z < 8 ? 0 : z > 8 ? 8 : z;
				break;
			}
			case 4:{
				x = x < 4 ? 0 : x < 8 ? 4 : x < 12 ? 8 : x < 16 ? 12 : x;
				//y = y < 4 ? 0 : y < 8 ? 4 : y < 12 ? 8 : y < 16 ? 12 : y;
				z = z < 4 ? 0 : z < 8 ? 4 : z < 12 ? 8 : z < 16 ? 12 : z;
				break;
			}
			case 8:{
				x = x < 2 ? 0 : x < 4 ? 2 : x < 6 ? 4 : x < 8 ? 6 : x < 10 ? 8 : x < 12 ? 10 : x < 14 ? 12 : x < 16 ? 14 : x;
				//y = y < 2 ? 0 : y < 4 ? 2 : y < 6 ? 4 : y < 8 ? 6 : y < 10 ? 8 : y < 12 ? 10 : y < 14 ? 12 : y < 16 ? 14 : y;
				z = z < 2 ? 0 : z < 4 ? 2 : z < 6 ? 4 : z < 8 ? 6 : z < 10 ? 8 : z < 12 ? 10 : z < 14 ? 12 : z < 16 ? 14 : z;
				break;
			}
			case 16: default: break;
		}
		this.x = x;
		this.y = y;
		this.z = z;
		vector = toVec();
	}

	public GridV3D(NBTTagCompound compound){
		pos = BlockPos.fromLong(compound.getLong("vec_pos"));
		x = compound.getByte("pos_x");
		y = compound.getByte("pos_y");
		z = compound.getByte("pos_z");
		vector = toVec();
	}

	public GridV3D(int px, int py, int pz, byte x, byte y, byte z){
		pos = new BlockPos(px, py, pz);
		this.x = x;
		this.y = y;
		this.z = z;
		vector = toVec();
	}

	public GridV3D(BlockPos blkpos, byte x, byte y, byte z){
		pos = new BlockPos(blkpos);
		this.x = x;
		this.y = y;
		this.z = z;
		vector = toVec();
	}

	public GridV3D(GridV3D other){
		pos = new BlockPos(other.pos);
		x = other.x; y = other.y; z = other.z;
		vector = new V3D(other.vector);
	}

	public GridV3D(BlockPos blkpos, boolean centered, boolean vcentered){
		pos = new BlockPos(blkpos);
		x = z = (byte)(centered ? 8 : 0);
		y = (byte)(vcentered ? 8 : 0);
		vector = toVec();
	}

	public NBTTagCompound write(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("vec_pos", pos.toLong());
		compound.setByte("pos_x", x);
		compound.setByte("pos_y", y);
		compound.setByte("pos_z", z);
		return compound;
	}

	private V3D toVec(){
		return new V3D(pos.getX() + (x * 0.0625), pos.getY() + (y * 0.0625), pos.getZ() + (z * 0.0625));
	}

	@Override
	public int compareTo(GridV3D o){
		if(o.pos.compareTo(pos) == 0){
			if(o.y > y) return 1; else if(o.y < y) return -1;
			if(o.x > x) return 1; else if(o.x < x) return -1;
			if(o.z > z) return 1; else if(o.z < z) return -1;
			return 0;
		}
		return o.pos.compareTo(pos);
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof V3D) return obj.equals(vector);
		//noinspection PointlessBooleanExpression
		if(obj instanceof GridV3D == false) return false;
		GridV3D vec = (GridV3D)obj;
		return vec.pos.equals(pos) && vec.x == x && vec.y == y && vec.z == z;
	}

	@Override
	public String toString(){
		return "(" + vector.x + ", " + vector.y + ", " + vector.z + ")";
	}

	public String asIDString(){
		return pos.getX() + "," + pos.getY() + "," + pos.getZ() + "" + x + "," + y + "," + z;
	}

	public static GridV3D fromIDString(String str){
		String[] arr0 = str.split("\\|"), arr1 = arr0[1].split(",");
		arr0 = arr0[0].split(",");
		int[] pxyz = new int[3];
		byte[] xyz = new byte[3];
		for(int i = 0; i < 3; i++){
			pxyz[i] = Integer.parseInt(arr0[i]);
			xyz[i] = Byte.parseByte(arr1[i]);
		}
		return new GridV3D(pxyz[0], pxyz[1], pxyz[2], xyz[0], xyz[1], xyz[2]);
	}

	public static GridV3D fromIDString(String str, boolean safe){
		if(!safe) return fromIDString(str); try{
			String[] arr0 = str.split("\\|"), arr1 = arr0[1].split(",");
			arr0 = arr0[0].split(",");
			int[] pxyz = new int[3];
			byte[] xyz = new byte[3];
			for(int i = 0; i < 3; i++){
				pxyz[i] = Integer.parseInt(arr0[i]);
				xyz[i] = Byte.parseByte(arr1[i]);
			}
			return new GridV3D(pxyz[0], pxyz[1], pxyz[2], xyz[0], xyz[1], xyz[2]);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public GridV3D copy(){
		return new GridV3D(this);
	}

}
