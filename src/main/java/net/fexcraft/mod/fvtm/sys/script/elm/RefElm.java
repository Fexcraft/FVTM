/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

import net.fexcraft.mod.fvtm.sys.script.ScrBlock;
import net.fexcraft.mod.fvtm.sys.script.ScrExpr;
import net.fexcraft.mod.fvtm.sys.script.ScrExprType;
import net.fexcraft.mod.fvtm.sys.script.Script;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RefElm extends Elm {
	
	private String value;
	private boolean negative;
	private ScrExpr expr;

	public RefElm(String string, boolean neg){
		value = string;
		negative = neg;
		if(value.contains(".")){
			expr = Script.parseExpression(string, ScrExprType.EXT_RIGHT);
		}
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
		return expr == null ? "{" + value + "}" : "{" + expr.print() +  "}";
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

	public Elm getElm(ScrBlock block){
		if(expr != null) return expr.process(block, null, NULL);
		return block.getElm(value);
	}

}
