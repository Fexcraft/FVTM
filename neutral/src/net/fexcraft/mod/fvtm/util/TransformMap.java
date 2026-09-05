package net.fexcraft.mod.fvtm.util;

import java.util.TreeMap;

import net.fexcraft.lib.common.math.V3F;

public class TransformMap extends TreeMap<String, V3F> {

	public static String[] TYPES = new String[]{ "null" };

	public TransformMap(int gltype){
		super();
		for(String type : TYPES){
			V3F vector = new V3F();
			if(gltype == 0){
				vector.x = vector.y = vector.z = .125f;
			}
			else if(gltype == 1 && type.equals("GROUND")){
				vector.x = -.45f;
				vector.y = -.05f;
			}
			else if(gltype == 2 && (type.equals("FIRST_PERSON_LEFT_HAND") || type.equals("FIRST_PERSON_RIGHT_HAND"))){
				vector.y = type.equals("FIRST_PERSON_LEFT_HAND") ? 60f : 120f;
			}
			else if(gltype == 2 && type.equals("GUI")){
				vector.x = -30f;
				vector.y = -135f;
				vector.z = -30f;
			}
			put(type, vector);
		}
	}
	
	public void set(String type, V3F vector){
		put(type, vector);
	}
	
	public void set(String type, float x, float y, float z){
		get(type).x = x;
		get(type).y = y;
		get(type).z = z;
	}
	
	public void setAll(float x, float y, float z){
		for(String type : TYPES){
			set(type, x, y, z);
		}
	}
	
	public void setAll(float xyz){//shortcut for scale
		setAll(xyz, xyz, xyz);
	}
	
	public void add(String type, float x, float y, float z){
		get(type).x += x;
		get(type).y += y;
		get(type).z += z;
	}
	
	public void addAll(float x, float y, float z){
		for(String type : TYPES){
			add(type, x, y, z);
		}
	}
	
	public void sub(String type, float x, float y, float z){
		get(type).x -= x;
		get(type).y -= y;
		get(type).z -= z;
	}
	
	public void subAll(float x, float y, float z){
		for(String type : TYPES){
			sub(type, x, y, z);
		}
	}
	
}
