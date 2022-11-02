/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

public enum ScrOper {
	
	RETURN("return"),
	ACTION("act"),
	REF("{}"),
	
	SET("="),
	GET("="),
	
	ADD("+"),
	SUB("-"),
	MUL("*"),
	DIV("/"),
	MOD("%"),
	
	NOT("!"),
	NEG("-"),
	
	GRT(">"),
	GRT_EQL(">="),
	LES("<"),
	LES_EQL("<="),
	NOT_EQL("!="),
	EQL("=="),
	
	AND("&&"),
	OR("||");
	
	public final String sign;

	ScrOper(String sign){
		this.sign = sign;
	}
	
}
