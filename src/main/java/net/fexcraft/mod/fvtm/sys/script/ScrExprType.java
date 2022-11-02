/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

public enum ScrExprType {
	
	EXT_NONE, EXT_RETURN, EXT_LEFT, EXT_RIGHT, EXT_COND;

	public boolean returnable(){
		return this == EXT_NONE;
	}

}
