package net.fexcraft.mod.fvtm.util;

import java.util.EnumMap;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;

public class TransformMap extends EnumMap<TransformType, Vec3f> {

	public TransformMap(int gltype){
		super(TransformType.class);
		for(TransformType type : TransformType.values()){
			Vec3f vector = new Vec3f();
			if(gltype == 0){
				vector.xCoord = vector.yCoord = vector.zCoord = .125f;
			}
			else if(gltype == 1 && type == TransformType.GROUND){
				vector.xCoord = -.45f;
				vector.yCoord = -.05f;
			}
			else if(gltype == 2 && (type == TransformType.FIRST_PERSON_LEFT_HAND || type == TransformType.FIRST_PERSON_RIGHT_HAND)){
				vector.yCoord = type == TransformType.FIRST_PERSON_LEFT_HAND ? 60f : 120f;
			}
			else if(gltype == 2 && type == TransformType.GUI){
				vector.xCoord = -30f;
				vector.yCoord = -135f;
				vector.zCoord = -30f;
			}
			put(type, vector);
		}
	}
	
	public void set(TransformType type, Vec3f vector){
		put(type, vector);
	}
	
	public void set(TransformType type, float x, float y, float z){
		get(type).xCoord = x;
		get(type).yCoord = y;
		get(type).zCoord = z;
	}
	
	public void setAll(float x, float y, float z){
		//Print.debug("setting all");
		for(TransformType type : TransformType.values()){
			set(type, x, y, z);
		}
		//Static.stop();
	}
	
	public void setAll(float xyz){//shortcut for scale
		setAll(xyz, xyz, xyz);
	}
	
	public void add(TransformType type, float x, float y, float z){
		get(type).xCoord += x;
		get(type).yCoord += y;
		get(type).zCoord += z;
	}
	
	public void addAll(float x, float y, float z){
		for(TransformType type : TransformType.values()){
			add(type, x, y, z);
		}
	}
	
	public void sub(TransformType type, float x, float y, float z){
		get(type).xCoord -= x;
		get(type).yCoord -= y;
		get(type).zCoord -= z;
	}
	
	public void subAll(float x, float y, float z){
		for(TransformType type : TransformType.values()){
			sub(type, x, y, z);
		}
	}
	
}
