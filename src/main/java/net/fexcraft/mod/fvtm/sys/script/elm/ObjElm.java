/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

import java.util.HashMap;

import net.fexcraft.mod.fvtm.sys.script.ScrElm;
import net.fexcraft.mod.fvtm.sys.script.ScrElmType;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class ObjElm implements ScrElm {
	
	private HashMap<String, ScrElm> value = new HashMap<>();

	public ObjElm(){}

	@Override
	public String scr_str(){
		return value.toString();
	}

	@Override
	public int scr_int(){
		return value.size();
	}

	@Override
	public float scr_flt(){
		return value.size();
	}

	@Override
	public boolean scr_bln(){
		return value.size() > 1;
	}

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.OBJ;
	}

}
