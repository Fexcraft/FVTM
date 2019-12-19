package net.fexcraft.mod.fvtm.sys.road;

import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.uni.PathType;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Road extends Path {
	
	protected Boolean oneway;//null=no, true=forward, false=backward
	protected RoadPoint root;

	public Road(RoadPoint point){
		super(); root = point;
	}
	
	public Road(RoadPoint point, Vec316f[] vec316fs, Vec316f vector){
		super(vec316fs, vector); root = point;
	}
	
	public Road(RoadPoint point, Vec316f[] vec316fs){
		super(vec316fs); root = point;
	}
	
	public Road setOneWay(Boolean bool){
		oneway = bool; return this;
	}

	@Override
	public PathType getType(){
		return PathType.ROAD;
	}
	
	@Override
	public Road read(NBTTagCompound compound){
		
		
		return this;
	}

}
