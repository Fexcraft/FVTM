/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

import net.fexcraft.mod.fvtm.sys.script.ScrBlock;
import net.fexcraft.mod.fvtm.sys.script.ScrElm;
import net.fexcraft.mod.fvtm.sys.script.ScrElmType;
import net.fexcraft.mod.fvtm.sys.script.ScrExpr;
import net.fexcraft.mod.fvtm.sys.script.ScrExprType;
import net.fexcraft.mod.fvtm.sys.script.Script;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RefElm implements ScrElm {
	
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
	public String scr_str(){
		return value;
	}

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.REF;
	}

	@Override
	public String scr_print(){
		return expr == null ? "{" + value + "}" : "{" + expr.print() +  "}";
	}

	public boolean negative(){
		return negative;
	}

	public ScrElm getElm(ScrBlock block){
		if(expr != null) return expr.process(block, null, NULL);
		return block.getElm(value, null);
	}

}
