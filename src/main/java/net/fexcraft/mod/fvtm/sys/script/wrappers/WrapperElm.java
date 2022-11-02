package net.fexcraft.mod.fvtm.sys.script.wrappers;

import net.fexcraft.mod.fvtm.sys.script.elm.Elm;

public abstract class WrapperElm extends Elm {

	@Override
	public int integer_val(){
		return 0;
	}

	@Override
	public float float_val(){
		return 0;
	}

	@Override
	public boolean bool_val(){
		return false;
	}

	@Override
	public Type type(){
		return Type.OBJ;
	}

	@Override
	public void set(String val){
		//
	}

	@Override
	public void set(int val){
		//
	}

	@Override
	public void set(float val){
		//
	}

	@Override
	public void set(boolean val){
		//
	}

}
