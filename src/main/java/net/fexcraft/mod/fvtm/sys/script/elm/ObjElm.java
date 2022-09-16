/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

import java.util.HashMap;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class ObjElm extends Elm {
	
	private HashMap<String, Elm> value = new HashMap<>();

	public ObjElm(){}

	@Override
	public String string_val(){
		return value.toString();
	}

	@Override
	public int integer_val(){
		return value.size();
	}

	@Override
	public float float_val(){
		return value.size();
	}

	@Override
	public boolean bool_val(){
		return value.size() > 1;
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
