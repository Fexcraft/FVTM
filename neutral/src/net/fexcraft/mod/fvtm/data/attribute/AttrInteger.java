package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrInteger extends Attribute<Integer> {

	public AttrInteger(String id, JsonMap map){
		this(id, map.getInteger("value", 0));
	}

	public AttrInteger(String aid, Integer val){
		super(aid, AttrValueType.INTEGER, val);
	}

	@Override
	public Integer validate(Object val){
		if(val == null) return 0;
		int va = 0;
		if(val instanceof Number) va = ((Number)val).intValue();
		else va = parse(val.toString());
		return (int)(va > max ? max : va < min ? min : va);
	}

	@Override
	public Integer parse(String val){
		try{
			return validate(Integer.parseInt(val, val.startsWith("#") || val.startsWith("0x") ? 16 : 10));
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public void increase(float by){
		value += (int)by;
	}

	@Override
	public void decrease(float by){
		value -= (int)by;
	}

	@Override
	public String type(){
		return "integer";
	}

	@Override
	public void saveValue(TagCW com){
		com.set(id, value);
	}

	@Override
	public void loadValue(TagCW com){
		value = com.getInteger(id);
	}

	@Override
	public Attribute<Integer> newInstance(){
		return new AttrInteger(id, initial);
	}

	//

	public int asInteger(){
		return value;
	}

	public long asLong(){
		return value;
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
