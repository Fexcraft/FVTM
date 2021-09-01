package net.fexcraft.mod.fvtm.sys.road;

import net.fexcraft.lib.common.math.Vec3f;
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
	protected RoadJunc root;

	public Road(RoadJunc point){
		super(); root = point;
	}
	
	public Road(RoadJunc point, Vec316f[] vec316fs){
		super(vec316fs); root = point;
	}
	
	public Road(RoadJunc point, Vec316f[] vec316fs, Vec316f vector){
		super(vec316fs, vector); root = point;
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
		super.read(compound);
		oneway = compound.hasKey("oneway") ? compound.getBoolean("oneway") : null;
		return this;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		compound = super.write(compound);
		if(oneway != null) compound.setBoolean("oneway", oneway);
		return compound;
	}
	
	public Road createOppositeCopy(){
		Road road = super.createOppositeCopy(new Road(root));
		road.oneway = oneway; return road;
	}
	
	@Override
	public String toString(){
		return String.format("Road[%s-%s, %s, %s]", start, end, vecpath.length, copy ? "copy" : "original");
	}

	@Override
	public Vec3f getVectorPosition(float distance, boolean reverse){
		return getVectorPosition0(distance, reverse);
	}

}
