/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class FltElm extends Elm {
	
	private float value;

	public FltElm(float flaot){
		value = flaot;
	}

	@Override
	public String string_val(){
		return value + "";
	}

	@Override
	public int integer_val(){
		return (int)value;
	}

	@Override
	public float float_val(){
		return value;
	}

	@Override
	public boolean bool_val(){
		return value > 0;
	}

	@Override
	public Type type(){
		return Type.FLOAT;
	}

	@Override
	public void set(String val){
		try{
			value = Float.parseFloat(val);
		}
		catch(Exception e){
			//
		}
	}

	@Override
	public void set(int val){
		value = val;
	}

	@Override
	public void set(float val){
		value = val;
	}

	@Override
	public void set(boolean val){
		value = val ? 1 : 0;
	}

}
