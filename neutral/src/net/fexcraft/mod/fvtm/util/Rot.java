package net.fexcraft.mod.fvtm.util;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.uni.tag.TagCW;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Rot {
	
	public static final Rot NULL = new Rot();
	private final V3D vec;
	public boolean nell;
	
	public Rot(){
		vec = new V3D();
		check();
	}

	public Rot(double x, double y, double z){
		vec = new V3D(x, y, z);
		check();
	}
	
	public Rot(V3D vec){
		this.vec = vec;
		check();
	}
	
	public Rot(JsonArray array){
		this(SaveUtils.loadV3D(array));
	}

	private void check(){
		nell = vec.x == 0f && vec.y == 0f && vec.z == 0f;
	}

	public void toTag(String key, TagCW compound){
		if(isNull()) return;
		compound.set(key, SaveUtils.saveV3D(vec));
	}

	public boolean isNull(){
		return nell;
	}

	public static Rot fromTag(String key, TagCW compound){
		if(!compound.has(key)) return new Rot();
		V3D vec = SaveUtils.loadV3D(compound.getList(key));
		return new Rot(vec);
	}

	public static Rot fromJson(JsonMap map, String key){
		if(!map.has(key) || !map.get(key).isArray()) return new Rot();
		return new Rot(SaveUtils.loadV3D(map.getArray(key)));
	}

	public JsonArray toJson(){
		return SaveUtils.saveV3DJson(vec);
	}

	public void rotate112(){
		if(nell) return;
        if(vec.y != 0f) GL11.glRotated(vec.y, 0.0F, 1.0F, 0.0F);
        if(vec.x != 0f) GL11.glRotated(vec.x, 1.0F, 0.0F, 0.0F);
        if(vec.z != 0f) GL11.glRotated(vec.z, 0.0F, 0.0F, 1.0F);
	}

	public void rotate112R(){
		if(nell) return;
        if(vec.z != 0f) GL11.glRotated(-vec.z, 0.0F, 0.0F, 1.0F);
        if(vec.x != 0f) GL11.glRotated(-vec.x, 1.0F, 0.0F, 0.0F);
        if(vec.y != 0f) GL11.glRotated(-vec.y, 0.0F, 1.0F, 0.0F);
	}

	public void set(Vec3f rot){
		vec.x = rot.x;
		vec.y = rot.y;
		vec.z = rot.z;
		check();
	}

	public Rot add(Rot other){
		return new Rot(vec.add(other.vec));
	}

	public V3D vec(){
		return vec;
	}

}
