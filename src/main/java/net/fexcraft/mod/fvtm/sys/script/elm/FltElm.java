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
public class FltElm implements ScrElm {
	
	private float value;

	public FltElm(float flaot){
		value = flaot;
	}

	@Override
	public String scr_str(){
		return value + "";
	}

	@Override
	public int scr_int(){
		return (int)value;
	}

	@Override
	public float scr_flt(){
		return value;
	}

	@Override
	public boolean scr_bln(){
		return value > 0;
	}

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.FLOAT;
	}

	@Override
	public void scr_set(String val){
		try{
			value = Float.parseFloat(val);
		}
		catch(Exception e){
			//
		}
	}

	@Override
	public void scr_set(int val){
		value = val;
	}

	@Override
	public void scr_set(float val){
		value = val;
	}

	@Override
	public void scr_set(boolean val){
		value = val ? 1 : 0;
	}

}
