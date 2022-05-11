package net.fexcraft.lib.frl.gen;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polyhedron;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 * @param <GLO>
 */
public class Generator<GLO> {

	protected static final Vec3f NULL_VEC = new Vec3f(0, 0, 0);
	
	protected Polyhedron<GLO> poly;
	protected ValueMap map = new ValueMap();
	
	public Generator(Polyhedron<GLO> poli){
		if(poli != null) poly = poli;
		else poly = new Polyhedron<>();
	}
	
	public Generator(Polyhedron<GLO> poli, float texW, float texH){
		this(poli);
		map.put("texture_width", texW);
		map.put("texture_height", texH);
	}
	
	public Generator(Polyhedron<GLO> poli, float texW, float texH, Type type){
		this(poli, texW, texH);
		map.put("type", type);
	}
	
	public Generator(Polyhedron<GLO> poli, Type type){
		this(poli, 0, 0, type);
	}

	public Polyhedron<GLO> get(){
		return poly;
	}
	
	public Polyhedron<GLO> make(){
		Type type = map.getValue("type", Type.CUBOID);
		switch(type){
			case CYLINDER:{
				Generator_Cylinder.make(poly, map);
				break;
			}
			case CUBOID:
			default:{
				Generator_Cuboid.make(poly, map);
				break;
			}
		}
		return poly;
	}
	
	public Generator<GLO> setValue(String key, Object value){
		map.put(key, value);
		return this;
	}
	
	public Generator<GLO> set(String key, Object value){
		map.put(key, value);
		return this;
	}
	
	public Generator<GLO> removePolygon(int index){
		if(!map.has("rem_poly")) map.addArray("rem_poly", int.class);
		map.getArray("rem_poly").add(index);
		return this;
	}
	
	public Generator<GLO> removePolygon(int... idxs){
		for(int i : idxs) removePolygon(i);
		return this;
	}

	public ValueMap getMap(){
		return map;
	}
	
	public static enum Type {
		
		CUBOID, CYLINDER
		
	}

	protected static boolean[] intToBoolArray(ArrayList<Integer> array, int size){
		boolean[] bool = new boolean[size];
		if(array == null || array.size() == 0) return bool;
		for(int i = 0; i < array.size(); i++){
			int j = array.get(i);
			if(j >= 0 && j < bool.length) bool[j] = true;
		}
		return bool;
	}

	protected static boolean detached(boolean[] rems, boolean[] deuv, int i){
		return rems[i] || deuv[i];
	}

}
