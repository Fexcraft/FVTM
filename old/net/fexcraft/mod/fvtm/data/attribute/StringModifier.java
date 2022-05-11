package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonElement;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;

public class StringModifier extends Modifier<String> {

	public StringModifier(String id, ModifierType type, AttrUpdate call, ModifierPriority priority){
		super(id, type, call, priority);
	}

	@Override
	public Modifier<String> copyNewInstance(){
		return new StringModifier(id, mtype, calltype, priority);
	}

	@Override
	public float float_value(){
		return 0f;
	}

	@Override
	public String string_value(){
		return value;
	}

	@Override
	public int integer_value(){
		return 0;
	}

	@Override
	protected NBTBase writeValue(){
		return new NBTTagString(value);
	}

	@Override
	protected String readValue(NBTBase basetag){
		return ((NBTTagString)basetag).getString();
	}

	@Override
	public String impl(){
		return "string";
	}

	@Override
	public boolean valid_valuetype(ValueType type){
		return type.isString();
	}

	@Override
	public String parseValue(JsonElement elm){
		return elm.getAsString();
	}

	@Override
	public String parseValue(String str){
		return str;
	}

	@Override
	public Object modify(VehicleData data, VehicleEntity ent, Attribute<?> attribute, AttrUpdate call){
		String val = attribute.string_value();
		switch(mtype){
			case ADDITIVE: return val + value;
			case OPPOSITE: return reverseText(val);
			case OVERRIDE: return value;
			default: return val;
		}
	}

	public String reverseText(String val){
		char[] arr = val.toCharArray();
		String result = "";
		for(int i = arr.length - 1; i > 0; i--){
			result += arr[i];
		}
		return result;
	}

}
