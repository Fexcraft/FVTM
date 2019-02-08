package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM.InternalAddon;
import net.fexcraft.mod.fvtm.api.Gauge;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vector3D;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

/** @author Ferdinand Calo' (FEX___96) **/
public class Track {
	
	public @Nullable LineSection line;
	public Vec3f[] vectors;//TODO see about storing the angle also
	private String id;
	private Gauge gauge;
	public BlockPos start, end;
	private boolean copy;
	public String line_id;
	//private float start_, end_;
	public float length;
	
	/** "subs" was Vec3f's initially. */
	public Track(BlockPos start, BlockPos end, Gauge gauge, BlockPos... subs){
		this.id = start.toLong() + "_" + end.toLong(); this.gauge = gauge;
		this.start = start; this.end = end; //start_ = startangle; end_ = endangle;
		this.vectors = new Vec3f[subs == null ? 2 : subs.length + 2];
		if(vectors.length == 2){
			vectors[0] = new Vec3f(start.getX() + 0.5, start.getY() + 0.5, start.getZ() + 0.5);
			vectors[1] = new Vec3f(end.getX() + 0.5, end.getY() + 0.5, end.getZ() + 0.5);
		}
		else{
			vectors[0] = new Vec3f(start.getX() + 0.5, start.getY() + 0.5, start.getZ() + 0.5);
			for(int i = 0; i < subs.length; i++){ vectors[i + 1] = new Vec3f(subs[i].getX() + 0.5, subs[i].getY() + 0.5, subs[i].getZ() + 0.5); }
			vectors[vectors.length - 1] = new Vec3f(end.getX() + 0.5, end.getY() + 0.5, end.getZ() + 0.5);
			//
			Vec3f[] vecs = curve(vectors); vectors = new Vec3f[vecs.length + 2];
			vectors[0] = new Vec3f(start.getX() + 0.5, start.getY() + 0.5, start.getZ() + 0.5);
			for(int i = 0; i < vecs.length; i++){ vectors[i + 1] = vecs[i]; }
			vectors[vectors.length - 1] = new Vec3f(end.getX() + 0.5, end.getY() + 0.5, end.getZ() + 0.5);
		}
		this.length = this.calcLength();
		if(Static.dev()) Print.log("Track Length - " + this.getId() + ": " + length);
	}
	
	private Vec3f[] curve(Vec3f[] vecpoints){
		ArrayList<Vec3f> vecs = new ArrayList<Vec3f>();
		double d = 0; while(d < 1){
			Vec3f[] moved = vecpoints;
			while(moved.length > 2){
				Vec3f[] arr = new Vec3f[moved.length - 1];
				for(int i = 0; i < moved.length - 1; i++){
					arr[i] = move(moved[i], moved[i + 1], moved[i].distanceTo(moved[i + 1]) * d);
				} moved = arr;
			} d += 0.05;
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
	
	/** Only to be used with .read(); after. */
	public Track(){}

	public Track read(NBTTagCompound compound){
		this.id = compound.getString("id");
		this.line_id = compound.hasKey("line_id") ? compound.getString("line_id") : null;
		if(line_id != null) this.grabLine();
		if(compound.hasKey("gauge")){
			gauge = Resources.GAUGES.getValue(new ResourceLocation(compound.getString("gauge")));
		}
		if(gauge == null){
			gauge = Resources.GAUGES.getValue(InternalAddon.STANDARD_GAUGE);
		}
		this.copy = compound.getBoolean("copy");
		this.start = BlockPos.fromLong(compound.getLong("start"));
		this.end = BlockPos.fromLong(compound.getLong("end"));
		this.vectors = new Vec3f[compound.getInteger("vectors")];
		for(int i = 0; i < vectors.length; i++){
			vectors[i] = new Vec3f(
				compound.getFloat("vector_" + i + "x"),
				compound.getFloat("vector_" + i + "y"),
				compound.getFloat("vector_" + i + "z"));
		}
		//this.start_ = compound.getFloat("start_angle");
		//this.end_ = compound.getFloat("end_angle");
		this.length = compound.hasKey("length") ? compound.getFloat("length") : calcLength();
		return this;
	}
	
	private float calcLength(){
		float temp = 0; for(int i = 0; i < vectors.length - 1; i++){ temp += vectors[i].distanceTo(vectors[i + 1]); } return temp;
	}

	private void grabLine(){
		//TODO
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("id", id);
		if(line_id != null) compound.setString("line_id", line_id);
		compound.setString("gauge", (gauge == null ? InternalAddon.STANDARD_GAUGE : gauge.getRegistryName()).toString());
		compound.setBoolean("copy", copy);
		compound.setLong("start", start.toLong());
		compound.setLong("end", end.toLong());
		compound.setInteger("vectors", vectors.length);
		for(int i = 0; i < vectors.length; i++){
			compound.setFloat("vector_" + i + "x", vectors[i].xCoord);
			compound.setFloat("vector_" + i + "y", vectors[i].yCoord);
			compound.setFloat("vector_" + i + "z", vectors[i].zCoord);
		}
		//compound.setFloat("start_angle", start_);
		//compound.setFloat("start_end", end_);
		compound.setFloat("length", length);
		return compound;
	}
	
	public Vec3f getFirstVector(){
		return vectors.length == 0 ? null : vectors[0];
	}
	
	public Vec3f getLastVector(){
		return vectors.length == 0 ? null : vectors[vectors.length - 1];
	}
	
	public String getId(){
		return id;
	}
	
	public Track oppositeCopy(){
		Track track = new Track();
		track.id = this.getOppositeId();
		track.line_id = line_id;
		track.gauge = gauge;
		track.start = end;
		track.end = start;
		track.copy = true;
		track.vectors = new Vec3f[vectors.length]; int j = vectors.length - 1;
		for(int i = 0; i < track.vectors.length; i++){
			track.vectors[i] = vectors[j--];
		}
		track.length = track.calcLength();
		return track;
	}
	
	public boolean isOppositeCopy(){
		return copy;
	}

	public String getOppositeId(){
		return end.toLong() + "_" + start.toLong();
	}

	public boolean isCompatibleGauge(Gauge gauge){
		return this.gauge.width() == gauge.width();
	}

	public Gauge getGauge(){
		return gauge;
	}
	
	public float[] getPosition(float distance){
		if(distance >= this.length){
			if(distance == this.length) blkposToVec3f(end).toFloatArray();
			return new float[]{ distance - length };
		}
		float traveled = 0, temp, multi;
		for(int i = 0; i < vectors.length - 1; i++){
			temp = traveled + (multi = vectors[i].distanceTo(vectors[i + 1]));
			if(temp >= distance){
				if(temp == distance) return vectors[i + 1].toFloatArray();
				return vectors[i + 1].distance(vectors[i], temp - distance).toFloatArray();
			}
			else{
				traveled += multi;
			}
		}
		return blkposToVec3f(start).toFloatArray();
	}

	private Vec3f blkposToVec3f(BlockPos pos){
		return new Vec3f(pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f);
	}
	
}