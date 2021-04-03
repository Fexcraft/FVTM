package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class Vector3fAttribute extends Attribute<Vec3f> {

	public Vector3fAttribute(String id, Vec3f initial_value){
		super(id, initial_value);
	}
	
	public Vector3fAttribute(String id, JsonObject obj){
		super(id, obj == null || !obj.has("value") || !obj.get("value").isJsonArray() ? new Vec3f() : parseVec(obj));
	}

	private static Vec3f parseVec(JsonObject obj){
		JsonArray xyz = obj.get("value").getAsJsonArray();
		return new Vec3f(xyz.get(0).getAsFloat(), xyz.get(1).getAsFloat(), xyz.get(2).getAsFloat());
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		Vec3f vec = initial ? initial() : value();
		NBTTagCompound com = new NBTTagCompound();
		com.setFloat("x", vec.xCoord);
		com.setFloat("y", vec.yCoord);
		com.setFloat("z", vec.zCoord);
		return com;
	}

	@Override
	protected Vec3f readValue(NBTBase basetag){
		NBTTagCompound com = (NBTTagCompound)basetag;
		return new Vec3f(com.getFloat("x"), com.getFloat("y"), com.getFloat("z"));
	}

	@Override
	public Attribute<Vec3f> copyNewInstance(){
		return new Vector3fAttribute(id(), initial());
	}

	@Override
	public int integer_value(){
		return (int)value().xCoord;
	}

	@Override
	public float float_value(){
		return value().xCoord;
	}

	@Override
	public boolean boolean_value(){
		return value().xCoord > 0;
	}

	@Override
	public Boolean tristate_value(){
		return value().xCoord == 0 ? null : value().xCoord > 0;
	}

	@Override
	public String string_value(){
		return value().xCoord + "," + value().yCoord + "," + value().zCoord;
	}

	@Override
	public ValueType valuetype(){
		return ValueType.VECTOR;
	}

	@Override
	public String type(){
		return "vector3";
	}

	@Override
	public Vec3f parseValue(String string){
		String[] split = string.split(",");
		float x = split.length > 0 ? Float.parseFloat(split[0].trim()) : 0;
		float y = split.length > 1 ? Float.parseFloat(split[1].trim()) : 0;
		float z = split.length > 2 ? Float.parseFloat(split[2].trim()) : 0;
		return new Vec3f(x, y, z);
	}

}