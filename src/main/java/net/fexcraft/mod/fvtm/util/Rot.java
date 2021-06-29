package net.fexcraft.mod.fvtm.util;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTTagCompound;

public class Rot {
	
	public static final Rot NULL = new Rot();
	private final Vec3f vec;
	public boolean nell;
	
	public Rot(){
		vec = new Vec3f();
		check();
	}

	public Rot(float x, float y, float z){
		vec = new Vec3f(x, y, z);
		check();
	}
	
	public Rot(Vec3f vec){
		this.vec = vec;
		check();
	}
	
	public Rot(JsonArray array){
		this(array.size() > 0 ? array.get(0).getAsFloat() : 0,
			array.size() > 1 ? array.get(1).getAsFloat() : 0,
			array.size() > 2 ?  array.get(2).getAsFloat() : 0);
	}

	private void check(){
		nell = vec.x == 0f && vec.y == 0f && vec.z == 0f;
	}

	public void toNBT(String key, NBTTagCompound compound){
		if(isNull()) return;
		compound.setTag(key, DataUtil.writeVec3f(vec));
	}

	public boolean isNull(){
		return nell;
	}

	public static Rot fromNBT(String key, NBTTagCompound compound){
		if(!compound.hasKey(key)) return new Rot();
		Vec3f vec = DataUtil.readVec3f(compound.getTag(key));
		return new Rot(vec);
	}

	public static Rot fromJson(JsonObject obj, String key){
		if(!obj.has(key) || obj.get(key).isJsonArray()) return new Rot();
		return new Rot(DataUtil.readVec3f(obj.get(key)));
	}

	public JsonElement toJson(){
		return DataUtil.writeVec3fJSON(vec);
	}

	public void rotate(){
		if(nell) return;
        if(vec.y != 0f) GL11.glRotatef(vec.y, 0.0F, 1.0F, 0.0F);
        if(vec.x != 0f) GL11.glRotatef(vec.x, 1.0F, 0.0F, 0.0F);
        if(vec.z != 0f) GL11.glRotatef(vec.z, 0.0F, 0.0F, 1.0F);
	}

	public void rotateR(){
		if(nell) return;
        if(vec.z != 0f) GL11.glRotatef(-vec.z, 0.0F, 0.0F, 1.0F);
        if(vec.x != 0f) GL11.glRotatef(-vec.x, 1.0F, 0.0F, 0.0F);
        if(vec.y != 0f) GL11.glRotatef(-vec.y, 0.0F, 1.0F, 0.0F);
	}

	public void set(Vec3f rot){
		vec.x = rot.x;
		vec.y = rot.y;
		vec.z = rot.z;
		check();
	}

}
