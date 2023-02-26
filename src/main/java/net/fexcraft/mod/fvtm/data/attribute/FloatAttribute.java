package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.sys.script.ScrElmType;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;

public class FloatAttribute extends Attribute<Float> {

	public FloatAttribute(String id, Float initial_value){
		super(id, initial_value);
	}
	
	public FloatAttribute(String id, JsonObject obj){
		super(id, obj == null ? 0f : obj.get("value").getAsFloat());
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		return new NBTTagFloat(initial ? initial() : value());
	}

	@Override
	protected Float readValue(NBTBase basetag){
		try{
			return ((NBTPrimitive)basetag).getFloat();
		}
		catch(Exception e){
			e.printStackTrace();
			return 0f;
		}
	}

	@Override
	public Attribute<Float> copyNewInstance(){
		return new FloatAttribute(id(), initial());
	}

	@Override
	public int integer_value(){
		return (int)+value();
	}

	@Override
	public float float_value(){
		return value();
	}

	@Override
	public void increase(int amount){
		increase(amount + 0f);
	}

	@Override
	public void increase(float amount){
		value(value() + amount);
	}

	@Override
	public void decrease(int amount){
		decrease(amount + 0f);
	}

	@Override
	public void decrease(float amount){
		value(value() - amount);
	}

	@Override
	public void validate(){
		if(value() > max()) value(max());
		if(value() < min()) value(min());
	}

	@Override
	public ValueType valuetype(){
		return ValueType.FLOAT;
	}

	@Override
	public String type(){
		return "float";
	}

	@Override
	public Float parseValue(String string){
		return Float.parseFloat(string);
	}

	//

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.FLOAT;
	}

	@Override
	public void scr_set(String val){
		value(parseValue(val));
		sync = true;
	}

	@Override
	public void scr_set(int val){
		value(val + 0f);
		sync = true;
	}

	@Override
	public void scr_set(float val){
		value(val);
		sync = true;
	}

	@Override
	public void scr_set(boolean val){
		value(val ? 1f : 0f);
		sync = true;
	}

}
