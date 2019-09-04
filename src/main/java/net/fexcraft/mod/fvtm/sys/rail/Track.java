package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.Vector3D;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Track {
	
	public Vec316f start, end;
	public boolean copy;
	public Vec3f[] vecpath;
	public TrackKey id;
	public Object gauge;
	public float length;
	//
	//protected String line;
	protected Section section;
	protected Junction junction;
	
	/*public Track(Vec3d start, Vec3d end, Object gauge, Vec3d... subs){
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
	}*/
	
	public Track(Junction junction, Vec316f[] vec316fs, Vec316f vector, Object gauge){
		this.junction = junction; start = vec316fs[0]; end = vector; id = new TrackKey(start, end);
		vecpath = new Vec3f[vec316fs.length == 1 ? 2 : vec316fs.length + 1];
		if(vecpath.length == 2){
			vecpath[0] = vec316fs[0].vector; vecpath[1] = vector.vector;
			this.length = vecpath[0].distanceTo(vecpath[1]);
		}
		else{
			for(int i = 0; i < vec316fs.length; i++){ vecpath[i] = vec316fs[i].vector; }
			vecpath[vecpath.length - 1] = vector.vector;
			//
			Vec3f[] vecs = curve(vecpath); vecpath = new Vec3f[vecs.length + 2];
			vecpath[0] = new Vec3f(start.vector);
			for(int i = 0; i < vecs.length; i++){ vecpath[i + 1] = vecs[i]; }
			vecpath[vecpath.length - 1] = new Vec3f(end.vector);
			this.length = this.calcLength();
		}
		this.gauge = gauge; section = getSection(null);
	}
	
	/** Only for the READ process. @param junk just to make sure it's not used elsewhere */
	public Track(Junction junk){ this.junction = junk; }

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
		vecs = vecs == null ? vecpath : vecs; float temp = 0;
		for(int i = 0; i < vecs.length - 1; i++){ temp += vecs[i].distanceTo(vecs[i + 1]); } return temp;
	}
	
	private float calcLength(){
		return getLength(null);
	}
	
	public Track read(NBTTagCompound compound){
		this.id = new TrackKey(compound);
		//this.line = compound.hasKey("section") ? compound.getString("section") : null;
		section = getSection(compound.hasKey("section") ? compound.getString("section") : null);
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

	public Section getSection(String key){
		return junction.root.getSections().get(key == null ? id.toSectionId(copy) : key, true);
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		id.write(compound); if(section != null) compound.setString("section", section.id);
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
	
	public TrackKey getId(){
		return id;
	}
	
	public Track createOppositeCopy(){
		Track track = new Track(junction);
		track.id = new TrackKey(id, true);
		track.section = section;
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

	public TrackKey getOppositeId(){
		return new TrackKey(id, true);
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
	
	public static class TrackKey implements Comparable<TrackKey> {
		
		private static final int[] order = new int[]{ 1, 0, 2, 4, 3, 5 };
		protected int[] pos = new int[6];
		protected byte[] xyz = new byte[6];
		
		public TrackKey(Vec316f start, Vec316f end){
			pos[0] = start.pos.getX(); pos[1] = start.pos.getY(); pos[2] = start.pos.getZ();
			pos[3] = end.pos.getX(); pos[4] = end.pos.getY(); pos[5] = end.pos.getZ();
			xyz[0] = start.x; xyz[1] = start.y; xyz[2] = start.z; xyz[3] = end.x; xyz[4] = end.y; xyz[5] = end.z;
		}

		public String toSectionId(boolean opposite){
			if(opposite){
				return pos[3] + "," + pos[4] + "," + pos[5] + ";" + xyz[3] + "," + xyz[4] + "," + xyz[5]
					+ ":" + pos[0] + "," + pos[1] + "," + pos[2] + ";" + xyz[0] + "," + xyz[1] + "," + xyz[2];
			}
			else{
				return pos[0] + "," + pos[1] + "," + pos[2] + ";" + xyz[0] + "," + xyz[1] + "," + xyz[2]
					+ ":" + pos[3] + "," + pos[4] + "," + pos[5] + ";" + xyz[3] + "," + xyz[4] + "," + xyz[5];
			}
		}

		public TrackKey(NBTTagCompound compound){
			if(compound.hasKey("key_pos")) pos = compound.getIntArray("key_pos");
			if(compound.hasKey("key_xyz")) xyz = compound.getByteArray("key_xyz");
		}
		
		public NBTTagCompound write(NBTTagCompound compound){
			compound.setIntArray("key_pos", pos); compound.setByteArray("key_xyz", xyz); return compound;
		}

		public TrackKey(TrackKey key, boolean opposite){
			if(opposite){
				pos[0] = key.pos[3]; pos[1] = key.pos[4]; pos[2] = key.pos[5];
				pos[3] = key.pos[0]; pos[4] = key.pos[1]; pos[5] = key.pos[2];
				xyz[0] = key.xyz[3]; xyz[1] = key.xyz[4]; xyz[2] = key.xyz[5];
				xyz[3] = key.xyz[0]; xyz[4] = key.xyz[1]; xyz[5] = key.xyz[2];
			} else{ pos = key.pos; xyz = key.xyz; }
		}

		@Override
		public int compareTo(TrackKey o){
			for(int i = 0; i < 6; i++){ if(o.pos[order[i]] > pos[order[i]]) return 1; if(o.pos[order[i]] < pos[order[i]]) return -1; }
			for(int i = 0; i < 6; i++){ if(o.xyz[order[i]] > xyz[order[i]]) return 1; if(o.xyz[order[i]] < xyz[order[i]]) return -1; }
			return 0;
		}
		
		@Override
		public boolean equals(Object obj){
			if(obj instanceof TrackKey == false) return false; TrackKey key = (TrackKey)obj;
			for(int i = 0; i < 6; i++){ if(key.pos[i] != pos[i] || key.xyz[i] != xyz[i]) return false; } return true;
		}

		public Vec316f toVec3f(int i){
			return new Vec316f(pos[0 + i], pos[1 + i], pos[2 + i], xyz[0 + i], xyz[1 + i], xyz[2 + i]);
		}
		
	}

}
