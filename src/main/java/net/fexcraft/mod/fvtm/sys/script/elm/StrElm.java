/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class StrElm extends Elm {
	
	private String value;

	public StrElm(String string){
		value = string;
	}

	@Override
	public String string_val(){
		return value;
	}

	@Override
	public int integer_val(){
		if(NumberUtils.isCreatable(value)){
			return Integer.parseInt(value);
		}
		return 0;
	}

	@Override
	public float float_val(){
		if(NumberUtils.isCreatable(value)){
			return Float.parseFloat(value);
		}
		return 0;
	}

	@Override
	public boolean bool_val(){
		return value.equals("true") || value.equals("1");
	}

	@Override
	public Type type(){
		return Type.STRING;
	}

	@Override
	public void set(String val){
		value = val;
	}

	@Override
	public void set(int val){
		value = val + "";
	}

	@Override
	public void set(float val){
		value = val + "";
	}

	@Override
	public void set(boolean val){
		value = val + "";
	}

}
