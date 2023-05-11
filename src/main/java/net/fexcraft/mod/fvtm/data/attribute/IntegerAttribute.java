package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonObject;
import net.fexcraft.lib.script.ScrElmType;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;

public class IntegerAttribute extends Attribute<Integer> {

	public IntegerAttribute(String id, Integer initial_value){
		super(id, initial_value);
	}
	
	public IntegerAttribute(String id, JsonObject obj){
		super(id, obj == null ? 0 : obj.get("value").getAsInt());
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		return new NBTTagInt(initial ? initial() : value());
	}

	@Override
	protected Integer readValue(NBTBase basetag){
		try{
			return ((NBTPrimitive)basetag).getInt();
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Attribute<Integer> copyNewInstance(){
		return new IntegerAttribute(id(), initial());
	}

	@Override
	public int integer_value(){
		return value();
	}

	@Override
	public float float_value(){
		return value();
	}

	@Override
	public void increase(float amount){
		increase((int)amount);
	}

	@Override
	public void increase(int amount){
		value(value() + amount);
	}

	@Override
	public void decrease(float amount){
		decrease((int)amount);
	}

	@Override
	public void decrease(int amount){
		value(value() - amount);
	}

	@Override
	public void validate(){
		if((Object)value() instanceof Float) value(((Float)(Object)value()).intValue());
		if(value() > max()){
			value(((Float)max()).intValue());
		}
		if(value() < min()){
			value(((Float)min()).intValue());
		}
	}

	@Override
	public ValueType valuetype(){
		return ValueType.INTEGER;
	}

	@Override
	public String type(){
		return "integer";
	}

	@Override
	public Integer parseValue(String string){
		return Integer.parseInt(string);
	}

	//

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.INTEGER;
	}

	@Override
	public void scr_set(String val){
		value(parseValue(val));
		sync = true;
	}

	@Override
	public void scr_set(int val){
		value(val);
		sync = true;
	}

	@Override
	public void scr_set(float val){
		value((int)val);
		sync = true;
	}

	@Override
	public void scr_set(boolean val){
		value(val ? 1 : 0);
		sync = true;
	}

}