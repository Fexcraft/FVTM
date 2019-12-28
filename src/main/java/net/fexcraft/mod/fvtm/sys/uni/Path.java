package net.fexcraft.mod.fvtm.sys.uni;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.Vector3D;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class Path {
	
	public Vec316f start, end;
	public Vec316f[] rootpath;
	public boolean copy;
	public Vec3f[] vecpath;
	public PathKey id, op;
	public float length;
	
	public Path(Vec316f[] vec316fs, Vec316f vector){
		start = vec316fs[0]; end = vector;
		id = new PathKey(start, end); op = new PathKey(id, true);
		rootpath = new Vec316f[vec316fs.length + 1];
		for(int i = 0; i < rootpath.length - 1; i++) rootpath[i] = vec316fs[i].copy();
		rootpath[rootpath.length - 1] = vector.copy(); construct();
	}

	public Path(Vec316f[] vec316fs){
		start = vec316fs[0]; end = vec316fs[vec316fs.length - 1];
		id = new PathKey(start, end); op = new PathKey(id, true);
		rootpath = new Vec316f[vec316fs.length];
		for(int i = 0; i < rootpath.length; i++) rootpath[i] = vec316fs[i].copy();
		construct();
	}
	
	public Path(){}
	
	protected void construct(){
		vecpath = new Vec3f[rootpath.length];
		if(vecpath.length == 2){
			vecpath[0] = rootpath[0].vector; vecpath[1] = rootpath[rootpath.length - 1].vector;
			this.length = vecpath[0].distanceTo(vecpath[1]);
		}
		else{
			for(int i = 0; i < rootpath.length; i++){ vecpath[i] = rootpath[i].vector; }
			//
			Vec3f[] vecs = curve(vecpath); vecpath = new Vec3f[vecs.length + 2];
			vecpath[0] = new Vec3f(start.vector);
			for(int i = 0; i < vecs.length; i++){ vecpath[i + 1] = vecs[i]; }
			vecpath[vecpath.length - 1] = new Vec3f(end.vector);
			this.length = this.calcLength();
		}
	}

	private Vec3f[] curve(Vec3f[] vecpoints){
		ArrayList<Vec3f> vecs = new ArrayList<Vec3f>();
		float length = getLength(vecpoints);
		float increment = 1 / length / Config.RAIL_SEGMENTATOR;
		double d = 0; while(d < 1){
			Vec3f[] moved = vecpoints;
			while(moved.length > 2){
				Vec3f[] arr = new Vec3f[moved.length - 1];
				for(int i = 0; i < moved.length - 1; i++){
					arr[i] = move(moved[i], moved[i + 1], moved[i].distanceTo(moved[i + 1]) * d);
				} moved = arr;
			} d += increment;//0.0625//0.05;
			vecs.add(move(moved[0], moved[1], moved[0].distanceTo(moved[1]) * d));
		}
		return vecs.toArray(new Vec3f[0]);
	}

	private Vec3f move(Vec3f vec0, Vec3f vec1, double dis){
		double[] dest = Vector3D.newVector(vec1), beg = Vector3D.newVector(vec0);
    	dest = Vector3D.direction(dest[0] - beg[0], dest[1] - beg[1], dest[2] - beg[2]);
    	dest = Vector3D.newVector(beg[0] + (dest[0] * dis), beg[1] + (dest[1] * dis), beg[2] + (dest[2] * dis));
		return new Vec3f(dest[0], dest[1], dest[2]);
	}
	
	public float getLength(Vec3f[] vecs){
		vecs = vecs == null ? vecpath : vecs; float temp = 0;
		for(int i = 0; i < vecs.length - 1; i++){ temp += vecs[i].distanceTo(vecs[i + 1]); } return temp;
	}
	
	protected float calcLength(){
		return getLength(null);
	}
	
	public Path read(NBTTagCompound compound){
		this.id = new PathKey(compound); op = new PathKey(id, true);
		this.copy = compound.getBoolean("copy");
		this.start = new Vec316f(compound.getCompoundTag("start"));
		this.end = new Vec316f(compound.getCompoundTag("end"));
		this.rootpath = new Vec316f[compound.getInteger("vectors")];
		for(int i = 0; i < rootpath.length; i++){
			rootpath[i] = new Vec316f(compound.getCompoundTag("vector-" + i));
		} construct();
		this.length = compound.hasKey("length") ? compound.getFloat("length") : calcLength();
		return this;
	}

	public NBTTagCompound write(NBTTagCompound compound){
		compound = id.write(compound == null ? new NBTTagCompound() : compound);
		compound.setBoolean("copy", copy);
		compound.setTag("start", start.write());
		compound.setTag("end", end.write());
		compound.setInteger("vectors", rootpath.length);
		for(int i = 0; i < rootpath.length; i++){
			compound.setTag("vector-" + i, rootpath[i].write());
		}
		compound.setFloat("length", length);
		return compound;
	}
	
	public Vec3f getFirstVector(){
		return vecpath.length == 0 ? null : vecpath[0];
	}
	
	public Vec3f getLastVector(){
		return vecpath.length == 0 ? null : vecpath[vecpath.length - 1];
	}
	
	public PathKey getId(){
		return id;
	}

	public PathKey getId(boolean opp){
		return opp ? getOppositeId() : getId();
	}
	
	public <T extends Path> T createOppositeCopy(T instance){
		instance.id = new PathKey(id, true);
		instance.op = new PathKey(id, false);
		instance.start = end;
		instance.end = start;
		instance.copy = true;
		instance.vecpath = new Vec3f[vecpath.length]; int j = vecpath.length - 1;
		for(int i = 0; i < instance.vecpath.length; i++){ instance.vecpath[i] = vecpath[j--]; }
		instance.length = instance.calcLength();
		return instance;
	}
	
	public boolean isOppositeCopy(){
		return copy;
	}

	public PathKey getOppositeId(){
		return op;
	}
	
	public float[] getPosition(float distance){
		if(distance >= this.length){
			if(distance == this.length) end.vector.toFloatArray();
			return new float[]{ distance - length };
		}
		float traveled = 0, temp, multi;
		for(int i = 0; i < vecpath.length - 1; i++){
			temp = traveled + (multi = vecpath[i].distanceTo(vecpath[i + 1]));
			if(temp >= distance){
				if(temp == distance) return vecpath[i + 1].toFloatArray();
				return vecpath[i + 1].distance(vecpath[i], temp - distance).toFloatArray();
			}
			else{
				traveled += multi;
			}
		}
		return start.vector.toFloatArray();
	}
	
	public Vec3f getVectorPosition0(float distance, boolean reverse){
		if(reverse) distance = (float)this.oppositePassed(distance);
		if(distance >= this.length){
			//if(distance == this.length) blkposToVec3f(end).toFloatArray();
			//return new float[]{ distance - length };
			return new Vec3f(end.vector);
		}
		float traveled = 0, temp, multi;
		for(int i = 0; i < vecpath.length - 1; i++){
			temp = traveled + (multi = vecpath[i].distanceTo(vecpath[i + 1]));
			if(temp >= distance){
				if(temp == distance) return new Vec3f(vecpath[i + 1]);
				return vecpath[i + 1].distance(vecpath[i], temp - distance);
			}
			else{
				traveled += multi;
			}
		}
		return new Vec3f(start.vector);
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == this) return true;
		if(obj instanceof Path){
			Path path = (Path)obj;
			 return path.getId().equals(getId()) && path.getType() == getType();
		} else return false;
	}
	
	@Override
	public String toString(){
		return String.format("Track[%s-%s, %s, %s]", start, end, vecpath.length, copy ? "copy" : "original");
	}

	public double oppositePassed(double sec){
		return sec >= length ? 0 : sec <= 0 ? length : this.length - sec;
	}
	
	public abstract PathType getType();

}
