package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3F;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrVector extends Attribute<V3F> {

	public AttrVector(String id, JsonMap map){
		this(id, tovec(map.has("value") ? map.getArray("value") : null));
		value = initial.copy();
	}

	private static V3F tovec(JsonArray arr){
		if(arr == null) return new V3F();
		else return new V3F(arr.get(0).float_value(), arr.get(1).float_value(), arr.get(2).float_value());
	}

	public AttrVector(String aid, V3F val){
		super(aid, AttrValueType.VECTOR, val);
	}

	@Override
	public V3F validate(Object val){
		V3F vec = null;
		if(val == null) vec = new V3F();
		else if(val instanceof V3F) vec = ((V3F)val).copy();
		else if(val instanceof Number){
			vec.x = ((Number)val).floatValue();
			vec.y = ((Number)val).floatValue();
			vec.z = ((Number)val).floatValue();
		}
		else vec = parse(val.toString());
		if(vec.x > max) vec.x = max;
		if(vec.y > max) vec.y = max;
		if(vec.z > max) vec.z = max;
		if(vec.x < min) vec.x = min;
		if(vec.y < min) vec.y = min;
		if(vec.z < min) vec.z = min;
		return vec;
	}

	@Override
	public V3F parse(String val){
		V3F vec = null;
		if(val.contains(",")){
			vec = new V3F();
			String[] split = val.split(",");
			vec.x = Float.parseFloat(split[0]);
			vec.y = Float.parseFloat(split[1]);
			vec.z = Float.parseFloat(split[2]);
		}
		else{
			vec.x = vec.y = vec.z = Float.parseFloat(val);
		}
		return vec;
	}

	@Override
	public void increase(float by){
		value.x += by;
	}

	@Override
	public void decrease(float by){
		value.x -= by;
	}

	@Override
	public String type(){
		return "vector3";
	}

	@Override
	public void saveValue(TagCW com){
		TagLW tag = TagLW.create();
		tag.add(value.x);
		tag.add(value.y);
		tag.add(value.z);
		com.set(id, tag);
	}

	@Override
	public void loadValue(TagCW com){
		if(!com.has(id)) return;
		TagLW tag = com.getList(id);
		value.x = tag.getFloat(0);
		value.y = tag.getFloat(1);
		value.z = tag.getFloat(2);
	}

	@Override
	public Attribute<V3F> newInstance(){
		return new AttrVector(id, initial.copy());
	}

	//

	public int asInteger(){
		return (int)value.x;
	}

	public long asLong(){
		return (long)value.x;
	}

	public float asFloat(){
		return value.x;
	}

	public String asString(){
		return value.toString();
	}

	public boolean asBoolean(){
		return value.x > 0;
	}

}
