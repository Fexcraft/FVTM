package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;

public class StringAttribute extends Attribute<String> {

	public StringAttribute(String id, String initial_value){
		super(id, initial_value);
	}
	
	public StringAttribute(String id, JsonObject obj){
		super(id, obj.get("value").getAsString());
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		return new NBTTagString(initial ? init() : value());
	}

	@Override
	protected String readValue(NBTBase basetag){
		return ((NBTTagString)basetag).getString();
	}

	@Override
	public Attribute<String> copyNewInstance(){
		return new StringAttribute(id(), init());
	}

	@Override
	public int getIntegerValue(){
		return 0;
	}

	@Override
	public float getFloatValue(){
		return 0;
	}

	@Override
	public String getStringValue(){
		return value();
	}

	@Override
	public boolean getBooleanValue(){
		return Boolean.parseBoolean(value());
	}

	@Override
	public Boolean getTriStateValue(){
		return value().equalsIgnoreCase("null") ? null : Boolean.parseBoolean(value());
	}

	@Override
	public Vec3f getVectorValue(){
		return new Vec3f();
	}

	@Override
	public ValueType valuetype(){
		return ValueType.STRING;
	}

	@Override
	public String type(){
		return "string";
	}

	@Override
	public String parseValue(String string){
		return string;
	}

}
