package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonElement;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;

public class FloatModifier extends Modifier<Float> {

	public FloatModifier(String id, ModifierType type, AttrUpdate call, ModifierPriority priority){
		super(id, type, call, priority);
	}

	@Override
	public Modifier<Float> copyNewInstance(){
		return new FloatModifier(id, mtype, calltype, priority);
	}

	@Override
	public float float_value(){
		return value;
	}

	@Override
	public String string_value(){
		return value + "";
	}

	@Override
	public int integer_value(){
		return (int)+value;
	}

	@Override
	protected NBTBase writeValue(){
		return new NBTTagFloat(value);
	}

	@Override
	protected Float readValue(NBTBase basetag){
		return ((NBTPrimitive)basetag).getFloat();
	}

	@Override
	protected String impl(){
		return "float";
	}

	@Override
	public boolean valid_valuetype(ValueType type){
		return type.isFloat() || type.isInteger();
	}

	@Override
	public Float parseValue(JsonElement elm){
		return elm.getAsFloat();
	}

	@Override
	public Float parseValue(String str){
		try{
			return Float.parseFloat(str);
		}
		catch(Exception e){
			e.printStackTrace();
			return 0f;
		}
	}

	@Override
	public Object modify(VehicleData data, VehicleEntity ent, Attribute<?> attribute, AttrUpdate call){
		//if(attribute.valuetype().isFloat() || attribute.valuetype().isInteger()){
			float result = attribute.float_value();
			switch(mtype){
				case ADDITIVE: result += value; break;
				case OPPOSITE: result = -result; break;
				case OVERRIDE: result = value; break;
				case PROCENT_ADD: result += result * 0.01f * value; break;
				case PROCENT_DEC: result -= result * 0.01f * value; break;
				case PROCENT_SET: result  = result * 0.01f * value; break;
				default: return null;
			}
			return attribute.valuetype().isInteger() ? (int)result : result;
		//}
		//return null;
	}

}
