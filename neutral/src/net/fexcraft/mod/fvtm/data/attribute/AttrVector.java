package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrVector extends Attribute<Vec3f> {

	public AttrVector(String id, JsonMap map){
		this(id, tovec(map.has("value") ? map.getArray("value") : null));
		value = initial.copy();
	}

	private static Vec3f tovec(JsonArray arr){
		if(arr == null) return new Vec3f();
		else return new Vec3f(arr.get(0).float_value(), arr.get(1).float_value(), arr.get(2).float_value());
	}

	public AttrVector(String aid, Vec3f val){
		super(aid, AttrValueType.VECTOR, val);
	}

	@Override
	public Vec3f validate(Object val){
		Vec3f vec = null;
		if(val == null) vec = new Vec3f();
		else if(val instanceof Vec3f) vec = ((Vec3f)val).copy();
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
	public Vec3f parse(String val){
		Vec3f vec = null;
		if(val.contains(",")){
			vec = new Vec3f();
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
	public Attribute<Vec3f> newInstance(){
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
