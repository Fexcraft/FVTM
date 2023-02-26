package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.sys.script.ScrElmType;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;

public class StringAttribute extends Attribute<String> {

	public StringAttribute(String id, String initial_value){
		super(id, initial_value);
	}
	
	public StringAttribute(String id, JsonObject obj){
		super(id, obj == null ? "" : obj.get("value").getAsString());
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		return new NBTTagString(initial ? initial() : value());
	}

	@Override
	protected String readValue(NBTBase basetag){
		return ((NBTTagString)basetag).getString();
	}

	@Override
	public Attribute<String> copyNewInstance(){
		return new StringAttribute(id(), initial());
	}

	@Override
	public int integer_value(){
		return value() == null ? 0 : value().length();
	}

	@Override
	public float float_value(){
		return integer_value();
	}

	@Override
	public String string_value(){
		return value();
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

	//

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.STRING;
	}

	@Override
	public void scr_set(String val){
		value(val);
		sync = true;
	}

	@Override
	public void scr_set(int val){
		value(val + "");
		sync = true;
	}

	@Override
	public void scr_set(float val){
		value(val + "");
		sync = true;
	}

	@Override
	public void scr_set(boolean val){
		value(val + "");
		sync = true;
	}

}
