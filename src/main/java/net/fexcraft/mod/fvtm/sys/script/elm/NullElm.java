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
public class NullElm extends Elm {

	public NullElm(){}

	@Override
	public String string_val(){
		return "null";
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
		return Type.NULL;
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
