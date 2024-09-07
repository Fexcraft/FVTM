package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrTristate extends Attribute<Boolean> {

	public AttrTristate(String id, JsonMap map){
		this(id, map.has("value") ? validatee(map.get("value").string_value()) : null);
	}

	private static Boolean validatee(String value){
		if(value.equals("null") || value.trim().length() == 0) return null;
		else return Boolean.parseBoolean(value);
	}

	public AttrTristate(String aid, Boolean val){
		super(aid, AttrValueType.TRISTATE, val);
	}

	@Override
	public Boolean validate(Object val){
		return val == null ? null : Boolean.parseBoolean(val.toString());
	}

	@Override
	public Boolean parse(String val){
		return val.equals("null") || val.trim().length() == 0 ? null : Boolean.parseBoolean(val);
	}

	@Override
	public void increase(float by){
		value = true;
	}

	@Override
	public void decrease(float by){
		value = false;
	}

	@Override
	public String type(){
		return "tristate";
	}

	@Override
	public void saveValue(TagCW com){
		if(value == null) return;
		com.set(id, value);
	}

	@Override
	public void loadValue(TagCW com){
		if(!com.has(id)) value = null;
		else value = com.getBoolean(id);
	}

	@Override
	public Attribute<Boolean> newInstance(){
		return new AttrTristate(id, initial);
	}

	//

	public int asInteger(){
		return value == null ? -1 : value ? 1 : 0;
	}

	public long asLong(){
		return value == null ? -1l : value ? 1l : 0l;
	}

	public float asFloat(){
		return value == null ? -1f : value ? 1f : 0f;
	}

	public String asString(){
		return value + "";
	}

	public boolean asBoolean(){
		return value != null && value;
	}

	public Boolean asTristate(){
		return value;
	}

}
