package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonObject;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;

public class BooleanAttribute extends Attribute<Boolean> {

	public BooleanAttribute(String id, Boolean initial_value){
		super(id, initial_value);
	}
	
	public BooleanAttribute(String id, JsonObject obj){
		super(id, obj == null ? false : obj.get("value").getAsBoolean());
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		return new NBTTagByte((initial ? initial() : value()) ? (byte)1 : (byte)0);
	}

	@Override
	protected Boolean readValue(NBTBase basetag){
		return ((NBTPrimitive)basetag).getByte() > 0;
	}

	@Override
	protected Attribute<Boolean> copyNewInstance(){
		return new BooleanAttribute(id(), initial());
	}

	@Override
	public int integer_value(){
		return value() ? 1 : 0;
	}

	@Override
	public float float_value(){
		return value() ? 1 : 0;
	}

	@Override
	public String string_value(){
		return value() + "";
	}

	@Override
	public boolean boolean_value(){
		return value();
	}

	@Override
	public Boolean tristate_value(){
		return value();
	}

	@Override
	public ValueType valuetype(){
		return ValueType.BOOLEAN;
	}

	@Override
	public String type(){
		return "boolean";
	}

	@Override
	public Boolean parseValue(String string){
		return Boolean.parseBoolean(string);
	}

}