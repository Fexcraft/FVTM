package net.fexcraft.mod.fvtm.sys.script.wrappers;

import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.script.elm.Elm;

public class AttrWrapper extends Elm {
	
	private Attribute<?> attr;

	public AttrWrapper(Attribute<?> attr){
		this.attr = attr;
	}

	@Override
	public String string_val(){
		return attr.string_value();
	}

	@Override
	public int integer_val(){
		return attr.integer_value();
	}

	@Override
	public float float_val(){
		return attr.float_value();
	}

	@Override
	public boolean bool_val(){
		return attr.boolean_value();
	}

	@Override
	public Type type(){
		return Type.OBJ;
	}

	@Override
	public void set(String val){
		attr.value(val);
	}

	@Override
	public void set(int val){
		attr.value(val);
	}

	@Override
	public void set(float val){
		attr.value(val);
	}

	@Override
	public void set(boolean val){
		attr.value(val);
	}

}
