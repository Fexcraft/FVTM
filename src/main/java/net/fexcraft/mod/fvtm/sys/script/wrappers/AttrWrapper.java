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
		attr.value(val);
		sync = true;
	}

	@Override
	public void set(int val){
		attr.value(val);
		sync = true;
	}

	@Override
	public void set(float val){
		attr.value(val);
		sync = true;
	}

	@Override
	public void set(boolean val){
		attr.value(val);
		sync = true;
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
