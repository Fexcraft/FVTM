package net.fexcraft.mod.fvtm.util;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTTagCompound;

public class Rot {
	
	public Vec3f vec;
	
	public Rot(){
		vec = new Vec3f();
	}
	
	public Rot(float x, float y, float z){
		vec = new Vec3f(x, y, z);
	}
	
	public Rot(Vec3f vec){
		this.vec = vec;
	}

	public void toNBT(String key, NBTTagCompound compound){
		if(isNull()) return;
		compound.setTag(key, DataUtil.writeVec3f(vec));
	}

	public boolean isNull(){
		return vec.x == 0f && vec.y == 0f && vec.z == 0f;
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
        if(vec.y != 0f) GL11.glRotatef(vec.y, 0.0F, 1.0F, 0.0F);
        if(vec.x != 0f) GL11.glRotatef(vec.x, 1.0F, 0.0F, 0.0F);
        if(vec.z != 0f) GL11.glRotatef(vec.z, 0.0F, 0.0F, 1.0F);
	}

	public void rotateR(){
        if(vec.z != 0f) GL11.glRotatef(-vec.z, 0.0F, 0.0F, 1.0F);
        if(vec.x != 0f) GL11.glRotatef(-vec.x, 1.0F, 0.0F, 0.0F);
        if(vec.y != 0f) GL11.glRotatef(-vec.y, 0.0F, 1.0F, 0.0F);
	}

}
