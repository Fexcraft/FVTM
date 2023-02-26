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
public class CondElm implements ScrElm {
	
	private ScrExpr value;

	public CondElm(String expr){
		value = Script.parseExpression(expr, ScrExprType.EXT_COND);
	}

	@Override
	public String scr_str(){
		return value.print();
	}

	@Override
	public boolean scr_bool(ScrBlock block, ScrExpr prev, ScrElm pelm){
		return value.process(block, prev, pelm).scr_bln();
	}

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.COND;
	}

}
