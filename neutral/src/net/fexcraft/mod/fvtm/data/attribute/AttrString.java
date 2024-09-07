package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrString extends Attribute<String> {

	public AttrString(String id, JsonMap map){
		this(id, map.getString("value", ""));
	}

	public AttrString(String aid, String val){
		super(aid, AttrValueType.STRING, val);
	}

	@Override
	public String validate(Object val){
		return val == null ? "null" : val.toString();
	}

	@Override
	public String parse(String val){
		return val;
	}

	@Override
	public void increase(float by){
		//
	}

	@Override
	public void decrease(float by){
		//
	}

	@Override
	public String type(){
		return "string";
	}

	@Override
	public void saveValue(TagCW com){
		com.set(id, value);
	}

	@Override
	public void loadValue(TagCW com){
		value = com.getString(id);
	}

	@Override
	public Attribute<String> newInstance(){
		return new AttrString(id, initial);
	}

	//

	public int asInteger(){
		return Integer.parseInt(value, value.startsWith("#") || value.startsWith("0x") ? 16 : 10);
	}

	public long asLong(){
		return Long.parseLong(value);
	}

	public float asFloat(){
		return Float.parseFloat(value);
	}

	public String asString(){
		return value;
	}

	public boolean asBoolean(){
		return Boolean.parseBoolean(value);
	}

}
