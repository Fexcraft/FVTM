/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

import net.fexcraft.mod.fvtm.sys.script.ScrExpr;
import net.fexcraft.mod.fvtm.sys.script.ScrExprType;
import net.fexcraft.mod.fvtm.sys.script.Script;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class CondElm extends Elm {
	
	private ScrExpr value;

	public CondElm(String expr){
		value = Script.parseExpression(expr, ScrExprType.EXT_COND);
	}

	@Override
	public String string_val(){
		return value.print();
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
		return Type.COND;
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
