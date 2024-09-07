package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrBoolean extends Attribute<Boolean> {

	public AttrBoolean(String id, JsonMap map){
		this(id, map.getBoolean("value", false));
	}

	public AttrBoolean(String aid, Boolean val){
		super(aid, AttrValueType.BOOLEAN, val);
	}

	@Override
	public Boolean validate(Object val){
		return val == null ? false : Boolean.parseBoolean(val.toString());
	}

	@Override
	public Boolean parse(String val){
		return Boolean.parseBoolean(val);
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
		return "boolean";
	}

	@Override
	public void saveValue(TagCW com){
		com.set(id, value);
	}

	@Override
	public void loadValue(TagCW com){
		value = com.getBoolean(id);
	}

	@Override
	public Attribute<Boolean> newInstance(){
		return new AttrBoolean(id, initial);
	}

	//

	public int asInteger(){
		return value ? 1 : 0;
	}

	public long asLong(){
		return value ? 1l : 0l;
	}

	public float asFloat(){
		return value ? 1f : 0f;
	}

	public String asString(){
		return value + "";
	}

	public boolean asBoolean(){
		return value;
	}

}
