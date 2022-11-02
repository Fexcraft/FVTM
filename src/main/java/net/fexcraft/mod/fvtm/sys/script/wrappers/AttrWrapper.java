package net.fexcraft.mod.fvtm.sys.script.wrappers;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.script.ScrBlock;
import net.fexcraft.mod.fvtm.sys.script.elm.Elm;

public class AttrWrapper extends Elm {
	
	private VehicleScriptContext context;
	private Attribute<?> attr;
	private boolean sync;

	public AttrWrapper(Attribute<?> attr, VehicleScriptContext context){
		this.attr = attr;
		this.context = context;
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
		attr.value(attr.parseValue(val));
		sync = true;
	}

	@Override
	public void set(int val){
		if(attr.valuetype().isString()) attr.value(val + "");
		else if(attr.valuetype().isBoolean()) attr.value(val > 0);
		else if(attr.valuetype().isFloat()) attr.value((float)val);
		else attr.value(attr.parseValue(val + ""));
		sync = true;
	}

	@Override
	public void set(float val){
		if(attr.valuetype().isString()) attr.value(val + "");
		else if(attr.valuetype().isBoolean()) attr.value(val > 0);
		else if(attr.valuetype().isInteger()) attr.value((int)val);
		else attr.value(attr.parseValue(val + ""));
		sync = true;
	}

	@Override
	public void set(boolean val){
		if(attr.valuetype().isString()) attr.value(val + "");
		else if(attr.valuetype().isTristate()) attr.value(val);
		else attr.value(attr.parseValue(val ? "1" : "0"));
		sync = true;
	}

	@Override
	public void set(Elm elm){
		if(elm.type().primitive()){
			if(elm.type().integer()) set(elm.integer_val());
			else if(elm.type().decimal()) set(elm.float_val());
			else if(elm.type().bool()) set(elm.bool_val());
			else if(elm.type().string()) set(elm.string_val());
			sync = true;	
		}
		else return;
	}

	@Override
	public Elm get(ScrBlock block, String target){
		//
		return NULL;
	}

	public Elm exec(ScrBlock block, String act, ArrayList<Elm> args){
		Elm val = NULL;
		switch(act){
			case "toggle":{
				val = asBool(attr.toggle_value());
				context.vehicle().sendAttributeUpdate(attr);
				return val;
			}
			case "sync":{
				context.vehicle().sendAttributeUpdate(attr);
				sync = false;
				return TRUE;
			}
			case "value":{
				return this;
			}
			default: break;
		}
		return val;
	}

	public void sync(){
		if(!sync) return;
		context.vehicle().sendAttributeUpdate(attr);
		sync = false;
	}

}
