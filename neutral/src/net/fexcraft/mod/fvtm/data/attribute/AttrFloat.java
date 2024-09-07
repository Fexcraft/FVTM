package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrFloat extends Attribute<Float> {

	public AttrFloat(String id, JsonMap map){
		this(id, map.getFloat("value", 0f));
	}

	public AttrFloat(String aid, Float val){
		super(aid, AttrValueType.FLOAT, val);
	}

	@Override
	public Float validate(Object val){
		if(val == null) return 0f;
		float va = 0f;
		if(val instanceof Number) va = ((Number)val).floatValue();
		else va = parse(val.toString());
		return va > max ? max : va < min ? min : va;
	}

	@Override
	public Float parse(String val){
		try{
			return validate(Float.parseFloat(val));
		}
		catch(Exception e){
			e.printStackTrace();
			return 0f;
		}
	}

	@Override
	public void increase(float by){
		value += by;
	}

	@Override
	public void decrease(float by){
		value -= by;
	}

	@Override
	public String type(){
		return "float";
	}

	@Override
	public void saveValue(TagCW com){
		com.set(id, value);
	}

	@Override
	public void loadValue(TagCW com){
		value = com.getFloat(id);
	}

	@Override
	public Attribute<Float> newInstance(){
		return new AttrFloat(id, initial);
	}

	//

	public int asInteger(){
		return (int)(float)value;
	}

	public long asLong(){
		return (long)(float)value;
	}

	public float asFloat(){
		return value;
	}

	public String asString(){
		return value + "";
	}

	public boolean asBoolean(){
		return value > 0;
	}

}
