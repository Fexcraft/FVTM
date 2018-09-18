package net.fexcraft.mod.fvtm.blocks.rail;

import java.util.TreeMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/** @author Ferdinand Calo' (FEX___96) **/
public class Connection {
	
	private BlockPos destination, beginning;
	private BlockPos[] points;
	public Vec3d[] vecpoints;
	public boolean opposite;
	public int disl;
	
	public Connection(BlockPos begin, BlockPos dest, BlockPos... points){
		this(begin, dest, false, points);
	}
	
	public Connection(BlockPos begin, BlockPos dest, boolean opposite, BlockPos... points){
		this.opposite = opposite;
		this.destination = dest;
		this.beginning = begin;
		this.points = points;
		this.init();
	}
	
	public Connection(){}

	private void init(){
		this.vecpoints = new Vec3d[this.points.length + 2];
		this.vecpoints[0] = newVector(beginning);
		for(int i = 0; i < points.length; i++){
			vecpoints[i + 1] = newVector(points[i]);
		}
		this.vecpoints[vecpoints.length - 1] = newVector(destination);
		//Print.debug(beginning, destination, opposite); Print.debug(points); Print.debug(vecpoints);
	}

	public Connection opposite(){
		BlockPos[] poss = new BlockPos[points.length]; int j = 0;
		for(int i = points.length - 1; i > -1; i--){ poss[j++] = points[i]; }
		return new Connection(destination, beginning, true, poss);
	}
	
	private static final TreeMap<BlockPos, Vec3d> vecs = new TreeMap<>();
	
	public static final Vec3d newVector(BlockPos pos){
		if(vecs.containsKey(pos)){
			return vecs.get(pos);
		}
		Vec3d vec = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
		vecs.put(pos, vec); return vec;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		compound.setLong("dest", destination.toLong());
		compound.setLong("begin", beginning.toLong());
		compound.setByte("points", (byte)points.length);
		for(int i = 0; i < points.length; i++){
			compound.setLong("point" + i, points[i].toLong());
		}
		compound.setBoolean("opposite", opposite);
		return compound;
	}
	
	public Connection read(NBTTagCompound compound){
		this.destination = BlockPos.fromLong(compound.getLong("dest"));
		this.beginning = BlockPos.fromLong(compound.getLong("begin"));
		this.points = new BlockPos[compound.getByte("points")];
		this.opposite = compound.getBoolean("opposite");
		for(int i = 0; i < points.length; i++){
			this.points[i] = BlockPos.fromLong(compound.getLong("point" + i));
		} init(); return this;
	}
	
	public BlockPos getDestination(){
		return destination;
	}

	public BlockPos getBeginning(){
		return beginning;
	}

	public Vec3d getVecpoint(int k){
		return vecpoints[k];
	}
	
	public BlockPos[] allPositions(){
		BlockPos[] all = new BlockPos[points.length + 2];
		all[0] = beginning; all[all.length - 1] = destination;
		for(int i = 1; i < all.length - 1; i++){ all[i] = points[i - 1]; }
		return all;
	}

	public BlockPos[] getPoints(){
		return points;
	}

	public BlockPos getFirstTowardsDest(){
		return points.length > 0 ? points[0] : destination;
	}

	public boolean equalsDestOrFirst(BlockPos previous){
		return points.length > 0 ? points[0].equals(previous) : destination.equals(previous);
	}
	
}