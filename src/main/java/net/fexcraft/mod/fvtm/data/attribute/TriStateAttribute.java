package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonObject;
import net.fexcraft.lib.script.ScrElmType;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;

public class TriStateAttribute extends Attribute<Boolean> {

	public TriStateAttribute(String id, Boolean initial_value){
		super(id, initial_value);
	}
	
	public TriStateAttribute(String id, JsonObject obj){
		super(id, obj == null || !obj.has("value") || obj.get("value").getAsString().equals("null") ? null : obj.get("value").getAsBoolean());
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		Boolean bool = initial ? initial() : value();
		return new NBTTagByte(bool == null ? -1 : bool ? (byte)1 : (byte)0);
	}

	@Override
	protected Boolean readValue(NBTBase basetag){
		byte val = ((NBTPrimitive)basetag).getByte();
		return val < 0 ? null : val > 0;
	}

	@Override
	public Attribute<Boolean> copyNewInstance(){
		return new TriStateAttribute(id(), initial());
	}

	@Override
	public int integer_value(){
		return value() == null ? -1 : value() ? 1 : 0;
	}

	@Override
	public float float_value(){
		return value() == null ? -1 : value() ? 1 : 0;
	}

	@Override
	public boolean boolean_value(){
		return value() == null ? false : value();
	}

	@Override
	public Boolean tristate_value(){
		return value();
	}

	@Override
	public ValueType valuetype(){
		return ValueType.TRISTATE;
	}

	@Override
	public String type(){
		return "tristate";
	}

	@Override
	public Boolean parseValue(String string){
		return string == null || string.length() == 0 || string.equals("null") ? null : Boolean.parseBoolean(string);
	}

	//

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.BOOLEAN;//there is no direct tristate support in scripts rn
	}

	@Override
	public void scr_set(String val){
		value(parseValue(val));
		sync = true;
	}

	@Override
	public void scr_set(int val){
		value(val < 0 ? null : val > 0);
		sync = true;
	}

	@Override
	public void scr_set(float val){
		value(val < 0 ? null : val > 0);
		sync = true;
	}

	@Override
	public void scr_set(boolean val){
		value(val);
		sync = true;
	}

}