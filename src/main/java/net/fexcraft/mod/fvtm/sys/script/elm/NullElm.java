/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

import net.fexcraft.mod.fvtm.sys.script.ScrElm;
import net.fexcraft.mod.fvtm.sys.script.ScrElmType;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class NullElm implements ScrElm {

	public NullElm(){}

	@Override
	public String scr_str(){
		return "null";
	}

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.NULL;
	}

}
