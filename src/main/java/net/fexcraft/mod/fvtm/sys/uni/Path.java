package net.fexcraft.mod.fvtm.sys.uni;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.util.GridV3D;
import net.fexcraft.mod.fvtm.util.Vector3D;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class Path {
	
	public GridV3D start, end;
	public GridV3D[] rootpath;
	public boolean copy;
	public V3D[] vecpath;
	public PathKey id, op;
	public double length;
	
	public Path(GridV3D[] gridvecs, GridV3D vector){
		start = gridvecs[0];
		end = vector;
		id = new PathKey(start, end);
		op = new PathKey(id, true);
		rootpath = new GridV3D[gridvecs.length + 1];
		for(int i = 0; i < rootpath.length - 1; i++) rootpath[i] = gridvecs[i].copy();
		rootpath[rootpath.length - 1] = vector.copy();
		construct();
	}

	public Path(GridV3D[] gridvecs){
		start = gridvecs[0];
		end = gridvecs[gridvecs.length - 1];
		id = new PathKey(start, end);
		op = new PathKey(id, true);
		rootpath = new GridV3D[gridvecs.length];
		for(int i = 0; i < rootpath.length; i++) rootpath[i] = gridvecs[i].copy();
		construct();
	}
	
	public Path(){}
	
	protected void construct(){
		vecpath = new V3D[rootpath.length];
		if(vecpath.length == 2){
			vecpath[0] = rootpath[0].vector; vecpath[1] = rootpath[rootpath.length - 1].vector;
			this.length = vecpath[0].dis(vecpath[1]);
		}
		else{
			for(int i = 0; i < rootpath.length; i++){
				vecpath[i] = rootpath[i].vector;
			}
			//
			V3D[] vecs = curve(vecpath);
			vecpath = new V3D[vecs.length + 2];
			vecpath[0] = new V3D(start.vector);
			for(int i = 0; i < vecs.length; i++){
				vecpath[i + 1] = vecs[i];
			}
			vecpath[vecpath.length - 1] = new V3D(end.vector);
			this.length = this.calcLength();
		}
	}

	/**
	 * Multi-Point Curve Creation
	 * @param vecpoints
	 * @return
	 */
	private V3D[] curve(V3D[] vecpoints){
		ArrayList<V3D> vecs = new ArrayList<V3D>();
		double length = getLength(vecpoints);
		double increment = 1 / length / Config.RAIL_SEGMENTATOR, d = 0;
		while(d < 1){
			V3D[] moved = vecpoints;
			while(moved.length > 2){
				V3D[] arr = new V3D[moved.length - 1];
				for(int i = 0; i < moved.length - 1; i++){
					arr[i] = move(moved[i], moved[i + 1], moved[i].dis(moved[i + 1]) * d);
				}
				moved = arr;
			}
			d += increment;//0.0625//0.05;
			vecs.add(move(moved[0], moved[1], moved[0].dis(moved[1]) * d));
		}
		return vecs.toArray(new V3D[0]);
	}

	public static V3D move(V3D vec0, V3D vec1, double dis){
		double[] dest = Vector3D.newVector(vec1), beg = Vector3D.newVector(vec0);
    	dest = Vector3D.direction(dest[0] - beg[0], dest[1] - beg[1], dest[2] - beg[2]);
    	dest = Vector3D.newVector(beg[0] + (dest[0] * dis), beg[1] + (dest[1] * dis), beg[2] + (dest[2] * dis));
		return new V3D(dest[0], dest[1], dest[2]);
	}
	
	public double getLength(V3D[] vecs){
		vecs = vecs == null ? vecpath : vecs;
		float temp = 0;
		for(int i = 0; i < vecs.length - 1; i++){
			temp += vecs[i].dis(vecs[i + 1]);
		}
		return temp;
	}
	
	protected double calcLength(){
		return getLength(null);
	}
	
	public Path read(NBTTagCompound compound){
		id = new PathKey(compound);
		op = new PathKey(id, true);
		copy = compound.getBoolean("copy");
		start = new GridV3D(compound.getCompoundTag("start"));
		end = new GridV3D(compound.getCompoundTag("end"));
		rootpath = new GridV3D[compound.getInteger("vectors")];
		for(int i = 0; i < rootpath.length; i++){
			rootpath[i] = new GridV3D(compound.getCompoundTag("vector-" + i));
		}
		construct();
		length = compound.hasKey("length") ? compound.getDouble("length") : calcLength();
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
		compound.setDouble("length", length);
		return compound;
	}
	
	public V3D getFirstVector(){
		return vecpath.length == 0 ? null : vecpath[0];
	}
	
	public V3D getLastVector(){
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
		instance.rootpath = new GridV3D[rootpath.length]; int j = rootpath.length - 1;
		for(int i = 0; i < instance.rootpath.length; i++){
			instance.rootpath[i] = rootpath[j--].copy();
		}
		instance.construct(); instance.length = instance.calcLength();
		return instance;
	}
	
	public boolean isOppositeCopy(){
		return copy;
	}

	public PathKey getOppositeId(){
		return op;
	}
	
	public double[] getPosition(double distance){
		if(distance >= this.length){
			if(distance == this.length) vecpath[vecpath.length - 1].toFloatArray();
			return new double[]{ distance - length };
		}
		double traveled = 0, temp, multi;
		for(int i = 0; i < vecpath.length - 1; i++){
			temp = traveled + (multi = vecpath[i].dis(vecpath[i + 1]));
			if(temp >= distance){
				if(temp == distance) return vecpath[i + 1].toDoubleArray();
				return vecpath[i + 1].distance(vecpath[i], temp - distance).toDoubleArray();
			}
			else{
				traveled += multi;
			}
		}
		return vecpath[0].toDoubleArray();
	}
	
	public V3D getVectorPosition0(double distance, boolean reverse){
		if(reverse) distance = oppositePassed(distance);
		if(distance >= this.length){
			//if(distance == this.length) blkposToVec(end).toFloatArray();
			//return new float[]{ distance - length };
			return new V3D(vecpath[vecpath.length - 1]);
		}
		double traveled = 0, temp, multi;
		for(int i = 0; i < vecpath.length - 1; i++){
			temp = traveled + (multi = vecpath[i].dis(vecpath[i + 1]));
			if(temp >= distance){
				if(temp == distance) return new V3D(vecpath[i + 1]);
				return vecpath[i + 1].distance(vecpath[i], temp - distance);
			}
			else{
				traveled += multi;
			}
		}
		return new V3D(vecpath[0]);
	}
	
	public abstract V3D getVectorPosition(double distance, boolean reverse);
	
	@Override
	public boolean equals(Object obj){
		if(obj == this) return true;
		if(obj instanceof Path){
			Path path = (Path)obj;
			return path.getId().equals(getId()) && path.getType() == getType();
		}
		else return false;
	}
	
	@Override
	public String toString(){
		return String.format("Path[%s-%s, %s, %s]", start, end, vecpath.length, copy ? "copy" : "original");
	}

	public double oppositePassed(double sec){
		return sec >= length ? 0 : sec <= 0 ? length : length - sec;
	}
	
	public abstract PathType getType();

}
