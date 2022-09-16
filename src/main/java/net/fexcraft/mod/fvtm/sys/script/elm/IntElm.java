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
public class IntElm extends Elm {
	
	private int value;

	public IntElm(int integer){
		value = integer;
	}

	@Override
	public String string_val(){
		return value + "";
	}

	@Override
	public int integer_val(){
		return value;
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
		return Type.INTEGER;
	}

	@Override
	public void set(String val){
		try{
			value = Integer.parseInt(val);
		}
		catch(Exception e){
			//
		}
	}

	@Override
	public void set(int val) {
		value = val;
	}

	@Override
	public void set(float val){
		value = (int)val;
	}

	@Override
	public void set(boolean val){
		value = val ? 1 : 0;
	}

}
