package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonElement;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;

public class IntegerModifier extends Modifier<Integer> {

	public IntegerModifier(String id, ModifierType type, AttrUpdate call, ModifierPriority priority){
		super(id, type, call, priority);
	}

	@Override
	public Modifier<Integer> copyNewInstance(){
		return new IntegerModifier(id, mtype, calltype, priority);
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
		return value;
	}

	@Override
	protected NBTBase writeValue(){
		return new NBTTagInt(value);
	}

	@Override
	protected Integer readValue(NBTBase basetag){
		return ((NBTPrimitive)basetag).getInt();
	}

	@Override
	protected String impl(){
		return "integer";
	}

	@Override
	public boolean valid_valuetype(ValueType type){
		return type.isInteger() || type.isFloat();
	}

	@Override
	public Integer parseValue(JsonElement elm){
		return elm.getAsInt();
	}

	@Override
	public Integer parseValue(String str){
		try{
			return Integer.parseInt(str);
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public <VL> VL modify(VehicleData data, VehicleEntity ent, Attribute<VL> attribute, AttrUpdate call){
		// TODO Auto-generated method stub
		return null;
	}

}
