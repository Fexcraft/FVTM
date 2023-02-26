/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

import java.util.ArrayList;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.script.elm.*;
import net.fexcraft.mod.fvtm.sys.script.elm.BoolElm.Final;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract interface ScrElm {
	
	public static final NullElm NULL = new NullElm();
	public static final BoolElm TRUE = new Final(true);
	public static final BoolElm FALSE = new Final(false);
	
	public default String scr_str(){
		return this.getClass().getName();
	}
	
	public default int scr_int(){
		return 0;
	}
	
	public default float scr_flt(){
		return 0f;
	}
	
	public default boolean scr_bln(){
		return false;
	}

	public default ScrElmType scr_type(){
		return ScrElmType.OBJ;
	}
	
	//
	
	public default void scr_set(String val){}

	public default void scr_set(int val){}
	
	public default void scr_set(float val){}

	public default void scr_set(boolean val){}

	public default void scr_set(ScrElm nex){}
	
	//

	public default String scr_print(){
		return scr_type() == ScrElmType.STRING ? "\"" + scr_str() + "\"" : scr_str();
	}

	public default ScrElm scr_get(ScrBlock block, String target){
		return NULL;
	}

	public default ScrElm scr_exec(ScrBlock block, String act, ArrayList<ScrElm> args){
		if(block.script.blocks.containsKey(act)){
			return ((ScrAction)block.script.blocks.get(act)).process(args);
		}
		switch(act){
			case "print":{
				if(args == null) break;
				for(ScrElm elm : args){
					if(elm.scr_type().reference()){
						ScrElm e = ((RefElm)elm).getElm(block);
						Print.log(((RefElm)elm).negative() ? e.scr_type().number() ? -elm.scr_flt() : !elm.scr_bln() :  e.scr_print());
					}
					else Print.log(elm.scr_print());
				}
				break;
			}
			default: break;
		}
		return NULL;
	}

	/** If this element overrides existing element object rather than it's value. */
	public default boolean overrides(){
		return false;
	}

	public default boolean scr_bool(ScrBlock block, ScrExpr prev, ScrElm pelm){
		return scr_bln();
	}

	/** Only for primitives. */
	public static ScrElm wrap(Object obj){
		if(obj instanceof String) return new StrElm(obj.toString());
		if(obj instanceof Integer) return new IntElm((int)obj);
		if(obj instanceof Float) return new FltElm((float)obj);
		if(obj instanceof Boolean) return new BoolElm((boolean)obj);
		return NULL;
	}

	//

	public static Two<String, ScrElm> parse(String line, ScrElmType type){
		line = line.substring(4);
		if(!line.contains("=")){
			return new Two<String, ScrElm>(line.trim(), ScrElm.from(type));
		}
		String name = line.substring(0, line.indexOf("=")).trim();
		line = line.substring(line.indexOf("=") + 1).trim();
		ScrElm elm = null;
		switch(type){
			case BOOLEAN:
				elm = new BoolElm(Boolean.parseBoolean(line));
				break;
			case FLOAT:
				elm = new FltElm(Float.parseFloat(line));
				break;
			case INTEGER:
				elm = new IntElm(Integer.parseInt(line));
				break;
			case STRING:{
				int s = 0, e = line.length();
				if(line.startsWith("\"")) s = 1;
				if(line.endsWith("\"")) e--;
				elm = new StrElm(line.substring(s, e));
				break;
			}
			case LIST:{
				elm = new ListElm();
				break;
			}
			case OBJ:{
				elm = new ObjElm();
				break;
			}
			case COND:{
				elm = new CondElm(line);
				break;
			}
			default:{
				elm = NullElm.NULL;
				break;
			}
		}
		return new Two<String, ScrElm>(name, elm);
	}

	public static ScrElm from(ScrElmType from){
		switch(from){
			case BOOLEAN: return new BoolElm(false);
			case FLOAT: return new FltElm(0f);
			case INTEGER: return new IntElm(0);
			case LIST: return new ListElm();
			case OBJ: return new ObjElm();
			case STRING: return new StrElm("");
			case NULL:
			default: return NullElm.NULL;
		}
	}

	public static ScrElm asBool(boolean bool){
		return bool ? TRUE : FALSE;
	}

}
