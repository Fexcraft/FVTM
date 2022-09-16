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
public class RefElm extends Elm {
	
	private String value;
	private boolean negative;

	public RefElm(String string, boolean neg){
		value = string;
		negative = neg;
	}

	@Override
	public String string_val(){
		return value;
	}

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
		return Type.REF;
	}

	public String print_val(){
		return "{" + value + "}";
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

	public boolean negative(){
		return negative;
	}

}
