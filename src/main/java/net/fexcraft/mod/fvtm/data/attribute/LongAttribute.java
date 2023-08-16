package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonObject;
import net.fexcraft.lib.script.ScrElmType;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagLong;

public class LongAttribute extends Attribute<Long> {

	public LongAttribute(String id, Long initial_value){
		super(id, initial_value);
	}
	
	public LongAttribute(String id, JsonObject obj){
		super(id, obj == null ? 0 : obj.get("value").getAsLong());
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		return new NBTTagLong(initial ? initial() : value());
	}

	@Override
	protected Long readValue(NBTBase basetag){
		try{
			return ((NBTPrimitive)basetag).getLong();
		}
		catch(Exception e){
			e.printStackTrace();
			return 0l;
		}
	}

	@Override
	public Attribute<Long> copyNewInstance(){
		return new LongAttribute(id(), initial());
	}

	@Override
	public int integer_value(){
		return (int)+value();
	}

	@Override
	public long long_value(){
		return value();
	}

	@Override
	public float float_value(){
		return value();
	}

	@Override
	public void increase(float amount){
		increase((long)amount);
	}

	@Override
	public void increase(int amount){
		value(value() + amount);
	}

	@Override
	public void decrease(float amount){
		decrease((long)amount);
	}

	@Override
	public void decrease(int amount){
		value(value() - amount);
	}

	@Override
	public void validate(){
		if((Object)value() instanceof Float) value(((Float)(Object)value()).longValue());
		if(value() > max()){
			value(((Float)max()).longValue());
		}
		if(value() < min()){
			value(((Float)min()).longValue());
		}
	}

	@Override
	public AttrValueType valuetype(){
		return AttrValueType.INTEGER;
	}

	@Override
	public String type(){
		return "long";
	}

	@Override
	public Long parseValue(String string){
		return Long.parseLong(string);
	}

	//

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.INTEGER;//there is no direct long support in scripts rn
	}

	@Override
	public void scr_set(String val){
		value(parseValue(val));
		sync = true;
	}

	@Override
	public void scr_set(int val){
		value(val + 0l);
		sync = true;
	}

	@Override
	public void scr_set(float val){
		value((long)val);
		sync = true;
	}

	@Override
	public void scr_set(boolean val){
		value(val ? 1l : 0l);
		sync = true;
	}

}