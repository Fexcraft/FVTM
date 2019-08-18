package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Vector3D;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Track {
	
	public Vec316f start, end;
	public boolean copy;
	public Vec3f[] vecpath;
	public String id;
	public Object gauge;
	public float length;
	//
	protected String line;
	protected Object section;
	
	public Track(Vec3d start, Vec3d end, Object gauge, Vec3d... subs){
		this.id = start.toString() + "-" + end.toString();
		this.start = new Vec316f(start); this.end = new Vec316f(end);
		vecpath = new Vec3f[(subs == null || subs.length == 0 ? 0 : subs.length) + 2];
		if(vecpath.length == 2){
			vecpath[0] = new Vec3f(start.x, start.y, start.z);
			vecpath[1] = new Vec3f(end.x, end.y, end.z);
			this.length = vecpath[0].distanceTo(vecpath[1]);
		}
		else{
			vecpath[0] = new Vec3f(start.x, start.y, start.z);
			for(int i = 0; i < subs.length; i++){ vecpath[i + 1] = new Vec3f(subs[i].x, subs[i].y, subs[i].z); }
			vecpath[vecpath.length - 1] = new Vec3f(end.x, end.y, end.z);
			//
			Vec3f[] vecs = curve(vecpath); vecpath = new Vec3f[vecs.length + 2];
			vecpath[0] = new Vec3f(start.x, start.y, start.z);
			for(int i = 0; i < vecs.length; i++){ vecpath[i + 1] = vecs[i]; }
			vecpath[vecpath.length - 1] = new Vec3f(end.x, end.y, end.z);
			this.length = this.calcLength();
		}
		this.gauge = gauge;
	}
	
	/** Only for the READ process. */
	public Track(){}
	
	private Vec3f[] curve(Vec3f[] vecpoints){
		ArrayList<Vec3f> vecs = new ArrayList<Vec3f>();
		float length = getLength(vecpoints);
		float increment = 1 / length / 8;
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
		return getLength(vecs == null ? vecpath : vecs);
	}
	
	private float calcLength(){
		float temp = 0; for(int i = 0; i < vecpath.length - 1; i++){ temp += vecpath[i].distanceTo(vecpath[i + 1]); } return temp;
	}
	
	public Track read(NBTTagCompound compound){
		this.id = compound.getString("id");
		this.line = compound.hasKey("section") ? compound.getString("section") : null;
		if(section != null) this.getSection();
		if(compound.hasKey("gauge")){
			//gauge = Resources.GAUGES.getValue(new ResourceLocation(compound.getString("gauge")));
		}
		if(gauge == null){
			//gauge = Resources.GAUGES.getValue(InternalAddon.STANDARD_GAUGE);
		}
		this.copy = compound.getBoolean("copy");
		this.start = new Vec316f(compound.getCompoundTag("start"));
		this.end = new Vec316f(compound.getCompoundTag("end"));
		this.vecpath = new Vec3f[compound.getInteger("vectors")];
		for(int i = 0; i < vecpath.length; i++){
			vecpath[i] = DataUtil.readVec3f(compound.getTag("vector-" + i));
		}
		this.length = compound.hasKey("length") ? compound.getFloat("length") : calcLength();
		return this;
	}

	private void getSection(){
		//TODO
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("id", id);
		if(line != null) compound.setString("section", line);
		//compound.setString("gauge", (gauge == null ? InternalAddon.STANDARD_GAUGE : gauge.getRegistryName()).toString());
		compound.setBoolean("copy", copy);
		compound.setTag("start", start.write());
		compound.setTag("end", end.write());
		compound.setInteger("vectors", vecpath.length);
		for(int i = 0; i < vecpath.length; i++){
			compound.setTag("vector-" + i, DataUtil.writeVec3f(vecpath[i]));
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
	
	public String getId(){
		return id;
	}
	
	public Track createCopy(){
		Track track = new Track();
		track.id = this.getOppositeId();
		track.line = line;
		track.gauge = gauge;
		track.start = end;
		track.end = start;
		track.copy = true;
		track.vecpath = new Vec3f[vecpath.length]; int j = vecpath.length - 1;
		for(int i = 0; i < track.vecpath.length; i++){ track.vecpath[i] = vecpath[j--]; }
		track.length = track.calcLength();
		return track;
	}
	
	public boolean isOppositeCopy(){
		return copy;
	}

	public String getOppositeId(){
		return end.toString() + "-" + start.toString();
	}

	public boolean isCompatibleGauge(Object gauge){
		return gauge == this.gauge;//this.gauge.width() == gauge.width();
	}

	public Object getGauge(){
		return gauge;
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
	
	public Vec3f getVectorPosition(float distance, boolean reverse){
		if(reverse) distance = (float)this.oppositePassed(distance);
		if(distance >= this.length){
			//if(distance == this.length) blkposToVec3f(end).toFloatArray();
			//return new float[]{ distance - length };
			return end.vector;
		}
		float traveled = 0, temp, multi;
		for(int i = 0; i < vecpath.length - 1; i++){
			temp = traveled + (multi = vecpath[i].distanceTo(vecpath[i + 1]));
			if(temp >= distance){
				if(temp == distance) return vecpath[i + 1];
				return vecpath[i + 1].distance(vecpath[i], temp - distance);
			}
			else{
				traveled += multi;
			}
		}
		return start.vector;
	}
	
	@Override
	public boolean equals(Object obj){
		return obj == this ? true : obj instanceof Track ? ((Track)obj).getId().equals(this.getId()) : false;
	}
	
	@Override
	public String toString(){
		return String.format("Track[%s-%s, %s, %s]", start, end, vecpath.length, copy ? "copy" : "original");
	}

	public double oppositePassed(double sec){
		return sec >= length ? 0 : sec <= 0 ? length : this.length - sec;
	}

}
